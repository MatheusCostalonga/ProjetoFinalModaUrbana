/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import model.DAO.CarrinhoDAO;
import model.DAO.CategoriasDAO;
import model.DAO.ProdutosDAO;
import model.DAO.UsuarioDAO;
import model.bean.CarrinhoDTO;
import model.bean.CategoriaDTO;
import model.bean.ProdutoDTO;
import model.bean.UsuarioDTO;

@WebServlet(urlPatterns = {"/deslogarSite"})
@MultipartConfig
public class CentralController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                 UsuarioDAO usuarios = new UsuarioDAO();
            UsuarioDTO usuario = new UsuarioDTO(); 
                            CarrinhoDAO carrinho = new CarrinhoDAO();

                            
            Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("continuarLogin")) {

                usuario = usuarios.leia(Integer.parseInt(cookie.getValue()));
                request.setAttribute("usuario", usuario);
                

            }
        }
        ProdutosDAO produtosDAO = new ProdutosDAO();        
                        CategoriasDAO categoriasDAO = new CategoriasDAO();        
        List<CategoriaDTO> categorias = categoriasDAO.listarCategorias();
        request.setAttribute("categoria", categorias);
        String url = request.getServletPath();
        System.out.println(url);
        if(url.equals("/cadastrar-produto")) {
            String nextPage = "/WEB-INF/jsp/cadastroProduto.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
            dispatcher.forward(request, response);
        } else if(url.equals("/menu")){  

        List<ProdutoDTO> produtos = produtosDAO.listarProdutos();
            request.setAttribute("produtos", produtos);
            for (Cookie cookie : cookies) {
            if (cookie.getName().equals("continuarLogin")) {

                usuario = usuarios.leia(Integer.parseInt(cookie.getValue()));
                request.setAttribute("usuario", usuario);
                                int idUsuario = Integer.parseInt(cookie.getValue());
        List<CarrinhoDTO> totalCarrinho = carrinho.leiaTotalCarrinho(idUsuario);       
        request.setAttribute("totalCarrinho", totalCarrinho);
         List<CarrinhoDTO> carrinhos = carrinho.MostrarTudo(idUsuario);       
        request.setAttribute("carrinhos", carrinhos);
            }
        }

  
       
            List<ProdutoDTO> camisetas = produtosDAO.ListarCamiseta();
            request.setAttribute("camisetas", camisetas);
            List<ProdutoDTO> camisa = produtosDAO.ListarCamisa();
            request.setAttribute("camisa", camisa);
            List<ProdutoDTO> calca = produtosDAO.ListarCalça();
            request.setAttribute("calca", calca);
            List<ProdutoDTO> jaqueta = produtosDAO.ListarJaqueta();
            request.setAttribute("jaqueta", jaqueta);
            List<ProdutoDTO> bermuda = produtosDAO.ListarBermuda();
            request.setAttribute("bermuda", bermuda);

          
            String nextPage = "/WEB-INF/jsp/index.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
            dispatcher.forward(request, response);
        } else if (url.equals("/buscar-produtos")) {
            String busca = request.getParameter("busca") != null ? request.getParameter("busca") : "";
            if(busca.equals("")) {
                String categoria = request.getParameter("cat");
                List<ProdutoDTO> produtos = produtosDAO.buscarCategoria(Integer.parseInt(categoria));
                request.setAttribute("produtos", produtos);
            } else {
                busca = "%"+busca+"%";  
                System.out.println("busca: "+busca);
                List<ProdutoDTO> produtos = produtosDAO.buscaProdutos(busca);
                request.setAttribute("produtos", produtos);
            }
            String nextPage = "/WEB-INF/jsp/buscaProdutos.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
            dispatcher.forward(request, response);
        }
    }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                ProdutoDTO newProduto = new ProdutoDTO();
        newProduto.setNome_produto(request.getParameter("nome_produto"));
        newProduto.setCategoriaId(Integer.parseInt(request.getParameter("categorias"))); 
        newProduto.setValor(Float.parseFloat(request.getParameter("valor")));
        newProduto.setDescricao(request.getParameter("descricao"));
        newProduto.setTamanhoId(Integer.parseInt(request.getParameter("tamanho_id")));
        newProduto.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
Part adicionarImagem = request.getPart("imagem");
        String fileName = Paths.get(adicionarImagem.getSubmittedFileName()).getFileName().toString();
        if (fileName != null && !fileName.isEmpty()) {
        String basePath = getServletContext().getRealPath("/") + "assets"; // Caminho para a pasta assets
        File uploads = new File(basePath);
        if (!uploads.exists()) {
            uploads.mkdirs(); // Cria o diretório se não existir
        }
        File arquivo = new File(uploads, fileName);

        try (InputStream input = adicionarImagem.getInputStream()) {
            Files.copy(input, arquivo.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            e.printStackTrace(); // Trate as exceções de forma adequada
        }

        // Configurando apenas o caminho relativo da imagem no banco de dados
        newProduto.setImagem("assets/" + fileName);
    } else {
        newProduto.setImagem(null);
    }
       
        ProdutosDAO produtosD = new ProdutosDAO();
        produtosD.cadastrarProduto(newProduto);
        response.sendRedirect("./menu");
        
                        String url = request.getServletPath();  
                             PrintWriter out = response.getWriter();
    if(url.equals("/deslogarSite")){
        System.out.println("chego aqui");
        Cookie[] cookies = request.getCookies();

            for (Cookie cookie : cookies) {
               if (cookie.getName().equals("continuarLogin")) {
       UsuarioDTO usuario = new UsuarioDTO();
       UsuarioDAO usuarios = new UsuarioDAO();
                usuario = usuarios.leia(Integer.parseInt(cookie.getValue()));
                request.setAttribute("usuario", usuario);
                                int idUsuario = Integer.parseInt(cookie.getValue());
                            cookie.setValue("0");
                    response.addCookie(cookie);
                
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Produto Adicionado</title>");
        out.println("<script src=\"https://cdn.jsdelivr.net/npm/sweetalert2@11\"></script>");
        out.println("</head>");
        out.println("<body>");

        // Exibe o SweetAlert com a mensagem de sucesso
        out.println("<script>");
        out.println("Swal.fire({");
        out.println("  icon: 'success',");
        out.println("  title: 'Deslogado com sucesso',");
        out.println("  text: 'volte sempre',");
        out.println("  showConfirmButton: false, ");// Remove o botão de confirmação
        out.println("});");

        // Redireciona automaticamente para a página inicial quando der o tempo determinado
        out.println("setTimeout(function() {");
        out.println("  window.location.href = 'menu';");
        out.println("}, 3000);");

        out.println("</script>");
        out.println("</body>");
        out.println("</html>");
    
                }
           
    }
    }
    }
    
    

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}