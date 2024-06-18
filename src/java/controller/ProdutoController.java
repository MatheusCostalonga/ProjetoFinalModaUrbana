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
import model.DAO.ProdutosDAO;
import model.DAO.UsuarioDAO;
import model.bean.CarrinhoDTO;
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
                request.setAttribute("usuario", usuario);
                      }
                    } 
    int id_produto = Integer.parseInt(request.getParameter("id"));
        List<ProdutoDTO> produtos = produtosDAO.buscarProduto(id_produto);
        request.setAttribute("produtos", produtos);
                List<CarrinhoDTO> carrinhos = carrinho.leia();
        request.setAttribute("carrinhos",carrinhos);
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
                      produto(request, response);
                    } else{
                        out.println("<script type=\"text/javascript\">");
            out.println("alert('Não temos tudo isso no estoque, sinto muito');");
            out.println("window.location.href = './menu';");
            out.println("</script>"); 
                    }
               }
        
            }
        } out.println("<script type=\"text/javascript\">");
            out.println("alert('Faça o login para poder adicionar produtos ao carrinho');");
            out.println("window.location.href = './loginCliente';");
            out.println("</script>");             
        }else {
            processRequest(request, response);
        } 
    }
    
        protected void produto(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            PrintWriter out = response.getWriter();
                 System.out.println("usuario id: "+carrinhos.getUsuarioId3());
                 System.out.println("categoria id: "+carrinhos.getCategoriaId3());
            carrinhos.setNomeCarrinho(request.getParameter("nome_produto"));
            carrinhos.setValorCarrinho(Float.parseFloat(request.getParameter("valor")));
            carrinhos.setDescricaoCarrinho(request.getParameter("descricao"));
            carrinhos.setTamanhoId3(Integer.parseInt(request.getParameter("tamanho_id")));
            carrinhos.setQuantidadeCarrinho(Integer.parseInt(request.getParameter("quantidade")));
            carrinhos.setProdutoId3(Integer.parseInt(request.getParameter("idProduto")));
            carrinhos.setImagemCarrinho(request.getParameter("imagem"));
            carrinhos.setCategoriaId3(Integer.parseInt(request.getParameter("categoriaId")));
            carrinhos.setUsuarioId3(Integer.parseInt(request.getParameter("id_usuario")));
            carrinho.cadastrarCarrinho(carrinhos);
          out.println("<script type=\"text/javascript\">");
            out.println("alert('Produto adicionado ao carrinho com sucesso');");
            out.println("window.location.href = './menu';");
            out.println("</script>");

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
