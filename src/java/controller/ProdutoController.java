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
import model.DAO.ProdutosDAO;
import model.bean.CarrinhoDTO;
import model.bean.ProdutoDTO;

/**
 *
 * @author Senai
 */
@WebServlet(urlPatterns = "/enviarItemCarrinho")
@MultipartConfig
public class ProdutoController extends HttpServlet {

    CarrinhoDTO carrinhos = new CarrinhoDTO();
    CarrinhoDAO carrinho = new CarrinhoDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                ProdutosDAO produtosDAO = new ProdutosDAO();
                int id_produto = Integer.parseInt(request.getParameter("id"));
        List<ProdutoDTO> produtos = produtosDAO.buscarProduto(id_produto);
        request.setAttribute("produtos", produtos);
        
        List<CarrinhoDTO> carrinhos = carrinho.leia();
        request.setAttribute("carrinhos",carrinhos);
            Cookie[] cookies = request.getCookies();
           for(Cookie cookie : cookies){
               
           }
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
        if(action.equals("/enviarItemCarrinho")){
                      produto(request, response);
        }else {
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
            carrinho.cadastrarCarrinho(carrinhos);
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Produto adicionado com sucesso.');");
            out.println("window.location.href = './pages/produto.jsp';");
            out.println("</script>");
            response.sendRedirect("./menu");

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
