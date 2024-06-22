/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
import model.DAO.EnderecoDAO;
import model.DAO.PedidosAdmDAO;
import model.DAO.PedidosClienteDAO;
import model.DAO.ProdutosDAO;
import model.DAO.UsuarioDAO;
import model.bean.CarrinhoDTO;
import model.bean.EnderecosDTO;
import model.bean.PedidosAdmDTO;
import model.bean.PedidosClienteDTO;
import model.bean.UsuarioDTO;

/**
 *
 * @author Leandro
 */
@WebServlet(urlPatterns = {"/checkout", "/modificarEndereco","/AdicionarItemProdutosPedidos","/ExcluirItemCarrinho",})
@MultipartConfig
public class CheckoutController extends HttpServlet {
    CarrinhoDTO carrinhosdto = new CarrinhoDTO();
    CarrinhoDAO carrinho = new CarrinhoDAO();
    EnderecosDTO enderecosdto = new EnderecosDTO();
    EnderecoDAO endereco = new EnderecoDAO();
    PedidosClienteDAO pedidosClientesDao = new PedidosClienteDAO();
    PedidosClienteDTO pedidosClientesDto = new PedidosClienteDTO();
    ProdutosDAO produtosDao = new ProdutosDAO();
    PedidosAdmDAO pedidosDao = new PedidosAdmDAO();
    PedidosAdmDTO pedidosDto = new PedidosAdmDTO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                         UsuarioDAO usuarios = new UsuarioDAO();
            UsuarioDTO usuario = new UsuarioDTO();

        Cookie[] cookies = request.getCookies();
        if(cookies != null){
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("continuarLogin")) {
                
                usuario = usuarios.leia(Integer.parseInt(cookie.getValue()));
                request.setAttribute("usuario", usuario);
                int idUsuario = Integer.parseInt(cookie.getValue());
               
        List<CarrinhoDTO> carrinhos = carrinho.MostrarTudo(idUsuario);       
        request.setAttribute("carrinhos", carrinhos);
        List<CarrinhoDTO> totalCarrinho = carrinho.leiaTotalCarrinho(idUsuario);       
        request.setAttribute("totalCarrinho", totalCarrinho);
                List<EnderecosDTO> enderecoExistente = endereco.enderecoUsuarios(idUsuario);
                request.setAttribute("enderecoExistente", enderecoExistente);
                               if (enderecoExistente == null || enderecoExistente.isEmpty()) {
                    enderecoExistente = new ArrayList<>();
                    EnderecosDTO defaultEndereco = new EnderecosDTO();
                    enderecoExistente.add(defaultEndereco);
                    request.setAttribute("enderecoExistente", enderecoExistente);
                }

                 String nextPage = "/WEB-INF/jsp/checkout.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
            dispatcher.forward(request, response);
               
                }
            PrintWriter out = response.getWriter();
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Faça o login para poder entrar no checkout');");
            out.println("window.location.href = './loginCliente';");
            out.println("</script>");
            
            
        }
                            

       
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


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        String url = request.getServletPath();
              PrintWriter out = response.getWriter(); 
               Cookie[] cookies = request.getCookies();
               if(url.equals("/modificarEndereco")){
        if(cookies != null){
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("continuarLogin")) {
           int idUsuario = Integer.parseInt(cookie.getValue());
           
              List<EnderecosDTO> enderecoExistente = endereco.enderecoUsuarios(idUsuario);
            String cep = request.getParameter("cep");
                 if (enderecoExistente == null || enderecoExistente.isEmpty()) {
                     if (cep.length() == 9) {
                     inserirEndereco(request, response);     
                     }else{
               out.println("<script type=\"text/javascript\">");
            out.println("alert('O cep deve conter 9 caracteres');");
            out.println("window.location.href = './checkout';");
            out.println("</script>"); 
                     }
                }else{
               if (cep.length() == 9) {
                   editarEndereco(request, response);       
                     }else{
               out.println("<script type=\"text/javascript\">");
            out.println("alert('O cep deve conter 9 caracteres');");
            out.println("window.location.href = './checkout';");
            out.println("</script>"); 
                     }  
                 }
  
            }
        }
        }  
               }/*Aqui para cima é somente para o cep, daquip para baixo é para adicionar os produtos aos pedidos*/
      else if(url.equals("/AdicionarItemProdutosPedidos")){
          if(cookies != null){
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("continuarLogin")) {
           int idUsuario = Integer.parseInt(cookie.getValue());

           
           produtoPedidos(request, response);
           
            }              
        }
          }        
         } else if(url.equals("/ExcluirItemCarrinho")){
           int idCarrinho = Integer.parseInt(request.getParameter("idCarrinho"));
           int quantidadeCarrinho = Integer.parseInt(request.getParameter("quantidadeCarrinho"));
           int idProduto = Integer.parseInt(request.getParameter("idProduto"));
           carrinho.deletarProdutoCarrinho(idCarrinho);
           produtosDao.aumentarQuantidadeProduto(idProduto, quantidadeCarrinho);
       }
    }
            protected void produtoPedidos(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            PrintWriter out = response.getWriter();
            
                // Obtém os valores dos parâmetros do jsp como arrays
                String[] nomeCarrinho = request.getParameterValues("nomeCarrinho");
                String[] valor = request.getParameterValues("valor");
                String[] descricao = request.getParameterValues("descricao");
                String[] tamanho = request.getParameterValues("tamanho");
                String[] quantidade = request.getParameterValues("quantidade");
                String[] produtoId = request.getParameterValues("produtoId");
                String[] categoria = request.getParameterValues("categoria");
                String[] imagem = request.getParameterValues("imagem");
                int usuarioId = Integer.parseInt(request.getParameter("id_usuario"));
                
                    System.out.println("Dados Recebidos: ");
    for (int i = 0; i < nomeCarrinho.length; i++) {
        System.out.println("Produto " + i + ":");
        System.out.println("Nome: " + nomeCarrinho[i]);
        System.out.println("Valor: " + valor[i]);
        System.out.println("Descrição: " + descricao[i]);
        System.out.println("Tamanho: " + tamanho[i]);
        System.out.println("Quantidade: " + quantidade[i]);
        System.out.println("ProdutoId: " + produtoId[i]);
        System.out.println("Categoria: " + categoria[i]);
        System.out.println("Imagem: " + imagem[i]);
    }
                
                for (int i = 0; i < nomeCarrinho.length; i++) {
    // Defini o valor dos atributos do PedidosProdutosDto com os valores correspondentes de cada item
    pedidosClientesDto.setNome_produtos_pedidos(nomeCarrinho[i]);
    pedidosClientesDto.setValor_pedidos_produtos(Float.parseFloat(valor[i]));
    pedidosClientesDto.setDescricao_pedidos_produtos(descricao[i]);
    pedidosClientesDto.setTamanho_id4(Integer.parseInt(tamanho[i]));
    pedidosClientesDto.setQuantidade_pedidos_produtos(Integer.parseInt(quantidade[i]));
    pedidosClientesDto.setProduto_id4(Integer.parseInt(produtoId[i]));
    pedidosClientesDto.setCategoria_id4(Integer.parseInt(categoria[i]));
    pedidosClientesDto.setImagem_pedidos_produtos(imagem[i]);
    pedidosClientesDto.setUsuario_id4(usuarioId);

            System.out.println("Inserindo Produto " + i + ": " + pedidosClientesDto);

    // Chama o método do DAO para cadastrar o pedido de produto
    pedidosClientesDao.cadastrarPedidosProdutos(pedidosClientesDto);

} 
    carrinho.deletarCarrinho();
           int idEndereco = Integer.parseInt(request.getParameter("id_endereco"));
           String metodoPagamento = request.getParameter("metodoPagamento");
      pedidosDao.cadastrarInformPedidos(usuarioId, idEndereco);
    }
    
          protected void inserirEndereco(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        PrintWriter out = response.getWriter();      
        EnderecosDTO newEndereco = new EnderecosDTO();

        newEndereco.setRua(request.getParameter("rua"));
        newEndereco.setNumero(Integer.parseInt(request.getParameter("numero")));
        newEndereco.setUsuario_id1(Integer.parseInt(request.getParameter("id_usuario")));
        newEndereco.setCep(request.getParameter("cep"));
        newEndereco.setComplemento(request.getParameter("complemento"));
        endereco.inserirEndereco(newEndereco);
                    out.println("<script type=\"text/javascript\">");
            out.println("alert('Informações adicionadas com sucesso');");
            out.println("window.location.href = './checkout';");
            out.println("</script>");
          }
          
        protected void editarEndereco(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        PrintWriter out = response.getWriter();      
        EnderecosDTO newEndereco = new EnderecosDTO();
        newEndereco.setId_endereco(Integer.parseInt(request.getParameter("id_endereco")));
        newEndereco.setRua(request.getParameter("rua"));
        newEndereco.setUsuario_id1(Integer.parseInt(request.getParameter("id_usuario")));
        newEndereco.setNumero(Integer.parseInt(request.getParameter("numero")));
        newEndereco.setCep(request.getParameter("cep"));
        newEndereco.setComplemento(request.getParameter("complemento"));
        endereco.editarEndereco(newEndereco);
        out.println("<script type=\"text/javascript\">");
            out.println("alert('Informações alteradas com sucesso');");
            out.println("window.location.href = './checkout';");
            out.println("</script>");
        }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
