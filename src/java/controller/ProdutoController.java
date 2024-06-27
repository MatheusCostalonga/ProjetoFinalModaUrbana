/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO.CarrinhoDAO;
import model.DAO.CategoriasDAO;
import model.DAO.ProdutosDAO;
import model.DAO.UsuarioDAO;
import model.bean.CarrinhoDTO;
import model.bean.CategoriaDTO;
import model.bean.ProdutoDTO;
import model.bean.UsuarioDTO;

/**
 *
 * @author Senai
 */
@WebServlet(urlPatterns = "/enviarItemCarrinho")
@MultipartConfig
public class ProdutoController extends HttpServlet {

    CarrinhoDTO carrinhos = new CarrinhoDTO();
    CarrinhoDAO carrinho = new CarrinhoDAO();
   ProdutosDAO produtosDAO = new ProdutosDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            UsuarioDAO usuarios = new UsuarioDAO();
            UsuarioDTO usuario = new UsuarioDTO();
Cookie[] cookies = request.getCookies();
                    for (Cookie cookie : cookies) {   
                      if (cookie.getName().equals("continuarLogin")) {
                usuario = usuarios.leia(Integer.parseInt(cookie.getValue()));
               int idUsuario = Integer.parseInt(cookie.getValue());
                request.setAttribute("usuario", usuario);
                        List<ProdutoDTO> produtos = produtosDAO.listarProdutos();
            request.setAttribute("produtos", produtos);
        List<CarrinhoDTO> totalCarrinho = carrinho.leiaTotalCarrinho(idUsuario);       
        request.setAttribute("totalCarrinho", totalCarrinho);
         List<CarrinhoDTO> carrinhos = carrinho.MostrarTudo(idUsuario);       
        request.setAttribute("carrinhos", carrinhos);             

                      }
                    } 
    int id_produto = Integer.parseInt(request.getParameter("id"));
        List<ProdutoDTO> produtos = produtosDAO.buscarProduto(id_produto);
        request.setAttribute("produtos", produtos);
                List<CarrinhoDTO> carrinhos = carrinho.lerCarrinho();
        request.setAttribute("carrinhos",carrinhos);
               CategoriasDAO categoriasDAO = new CategoriasDAO();        
        List<CategoriaDTO> categorias = categoriasDAO.listarCategorias();
        request.setAttribute("categoria", categorias);
                String url = "/WEB-INF/jsp/produto.jsp";   
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response); 
            
  
        
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
                String action = request.getServletPath();  
                             PrintWriter out = response.getWriter();

                     Cookie[] cookies = request.getCookies();
                      if(cookies != null){   
                    for (Cookie cookie : cookies) {
                      if (cookie.getName().equals("continuarLogin")) {
              int idUsuario = Integer.parseInt(cookie.getValue());
             
        if(action.equals("/enviarItemCarrinho")){
       int quantDesejada = Integer.parseInt(request.getParameter("quantidade"));
       int produtoId = Integer.parseInt(request.getParameter("idProduto"));
       int quantEstoque = produtosDAO.consultarQuantidadeProduto(produtoId);
                    if (quantEstoque >= quantDesejada) {
                        System.out.println("diminuirquantidadeDesejada "+quantDesejada);
                        System.out.println("diminuirProdutoId "+produtoId);
                      produtosDAO.diminuirQuantidadeProduto(quantDesejada, produtoId);  
                      produto(request, response);        
                    } else{
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Produto Adicionado</title>");
        out.println("<script src=\"https://cdn.jsdelivr.net/npm/sweetalert2@11\"></script>");
        out.println("</head>");
        out.println("<body>");
        // Exibe o SweetAlert com a mensagem de sucesso
        out.println("<script>");
        out.println("Swal.fire({");
        out.println("  icon: 'warning',");
        out.println("  title: 'Atenção',");
        out.println("  text: 'Quantidade indisponivel',");
        out.println("  showConfirmButton: false, ");// Remove o botão de confirmação       
        out.println("});");
       // Redireciona automaticamente para a página inicial quando der o tempo determinado
        out.println("setTimeout(function() {");
out.println("  window.history.back();"); // Volta para a página anterior
out.println("}, 3000);");      
        out.println("</script>");
        out.println("</body>");
        out.println("</html>");
                    } }  }  }          
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Realizar Login</title>");
        out.println("<script src=\"https://cdn.jsdelivr.net/npm/sweetalert2@11\"></script>");
        out.println("</head>");
        out.println("<body>");
        // Exibe o SweetAlert com a mensagem de info
        out.println("<script>");
        out.println("Swal.fire({");
        out.println("  icon: 'info',");
        out.println("  title: 'Realize login',");
        out.println("  text: 'Para adicionar produto ao carrinho precisa estar logado em sua conta',");
        out.println("  showConfirmButton: false, ");// Remove o botão de confirmação
        out.println("});");
        // Redireciona automaticamente para a página inicial quando der o tempo determinado
        out.println("setTimeout(function() {");
        out.println("  window.location.href = 'logar';");
        out.println("}, 3000);");       
        out.println("</script>");
        out.println("</body>");
        out.println("</html>");        
        }else  if (action.equals("/buscar-produtos")) {
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
        processRequest(request, response);
    }else{
            processRequest(request, response);
        } 
    }
    
        protected void produto(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            PrintWriter out = response.getWriter();
            carrinhos.setNomeCarrinho(request.getParameter("nome_produto"));
            carrinhos.setValorCarrinho(Float.parseFloat(request.getParameter("valor")));
            carrinhos.setDescricaoCarrinho(request.getParameter("descricao"));
            carrinhos.setTamanhoId3(Integer.parseInt(request.getParameter("tamanho_id")));
            carrinhos.setQuantidadeCarrinho(Integer.parseInt(request.getParameter("quantidade")));
            carrinhos.setProdutoId3(Integer.parseInt(request.getParameter("idProduto")));
            carrinhos.setImagemCarrinho(request.getParameter("imagem"));
            carrinhos.setCategoriaId3(Integer.parseInt(request.getParameter("categoriaId")));
            carrinhos.setUsuarioId3(Integer.parseInt(request.getParameter("id_usuario")));
            carrinho.cadastrarProdutoCarrinho(carrinhos);
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
        out.println("  title: 'Produto adicionado',");
        out.println("  text: 'Aguarde um instante, que o produto esta sendo adicionado ao carrinho',");
        out.println("  showConfirmButton: false, ");// Remove o botão de confirmação
        out.println("});");
        // Redireciona automaticamente para a página inicial quando der o tempo determinado
        out.println("setTimeout(function() {");
        out.println("  window.location.href = 'menu';");
        out.println("}, 3000);");     
        out.println("</script>");
        out.println("</body>");
        out.println("</html>");
out.close();
    }
   
    /*
       
       
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
