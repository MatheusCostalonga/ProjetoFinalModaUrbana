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
import model.DAO.PedidosClienteDAO;
import model.DAO.ProdutosDAO;
import model.DAO.UsuarioDAO;
import model.bean.CarrinhoDTO;
import model.bean.CategoriaDTO;
import model.bean.PedidosClienteDTO;
import model.bean.ProdutoDTO;
import model.bean.UsuarioDTO;

/**
 *
 * @author Leandro
 */
@WebServlet(urlPatterns = {"/pedidosCliente"})
@MultipartConfig
public class PedidosClienteController extends HttpServlet {
       PedidosClienteDTO pedidoCliente = new PedidosClienteDTO();
       PedidosClienteDAO pedidoClienteDao = new PedidosClienteDAO();
       UsuarioDTO usuario = new UsuarioDTO();
       UsuarioDAO usuarios = new UsuarioDAO();
       ProdutosDAO produtosDAO = new ProdutosDAO();
           CarrinhoDTO carrinhos = new CarrinhoDTO();
    CarrinhoDAO carrinho = new CarrinhoDAO();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

         Cookie[] cookies = request.getCookies();
        if(cookies != null){
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("continuarLogin")) {
                
                usuario = usuarios.leia(Integer.parseInt(cookie.getValue()));
                request.setAttribute("usuario", usuario);
                int idUsuario = Integer.parseInt(cookie.getValue());
                System.out.println("idUsuario "+idUsuario);
             List<PedidosClienteDTO> pedidosCliente = pedidoClienteDao.LerPedidosCliente(idUsuario);
                request.setAttribute("pedidosCliente", pedidosCliente);
                        List<CarrinhoDTO> totalCarrinho = carrinho.leiaTotalCarrinho(idUsuario);       
        request.setAttribute("totalCarrinho", totalCarrinho);
         List<CarrinhoDTO> carrinhos = carrinho.MostrarTudo(idUsuario);       
        request.setAttribute("carrinhos", carrinhos);  
                List<PedidosClienteDTO> totalProdutosPedidos = pedidoClienteDao.leiaTotalPedidos(idUsuario);       
        request.setAttribute("totalProdutosPedidos", totalProdutosPedidos);

            }
        }
        }
               CategoriasDAO categoriasDAO = new CategoriasDAO();        
        List<CategoriaDTO> categorias = categoriasDAO.listarCategorias();
        request.setAttribute("categoria", categorias);
        String nextPage = "/WEB-INF/jsp/PedidosCliente.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
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
                String url = request.getServletPath();  
   
        if (url.equals("/buscar-produtos")) {
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
    }
    }
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
