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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO.CarrinhoDAO;
import model.bean.CarrinhoDTO;
import model.bean.EnderecosDTO;

/**
 *
 * @author Leandro
 */
public class CheckoutController extends HttpServlet {
    CarrinhoDTO carrinhosdto = new CarrinhoDTO();
    CarrinhoDAO carrinho = new CarrinhoDAO();
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
        
 List<CarrinhoDTO> carrinhos = carrinho.MostrarTamanho();       
        request.setAttribute("carrinhos", carrinhos);
        List<CarrinhoDTO> totalCarrinho = carrinho.leiaTotal();       
        request.setAttribute("totalCarrinho", totalCarrinho);
        String nextPage = "/WEB-INF/jsp/checkout.jsp";
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


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        EnderecosDTO newEndereco = new EnderecosDTO();
        newEndereco.setRua(request.getParameter("rua"));
        newEndereco.setNumero(Integer.parseInt("numero"));
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
