/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import model.DAO.CategoriasDAO;
import model.DAO.ProdutosDAO;
import model.bean.CategoriaDTO;
import model.bean.ProdutoDTO;

/**
 *
 * @author Senai
 */
@MultipartConfig
public class ProdutosController extends HttpServlet {

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
            String nextPage = "/WEB-INF/jsp/index.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
            dispatcher.forward(request, response);
        } else if (url.equals("/buscar-produtos")) {
            String busca = request.getParameter("busca") != null ? request.getParameter("busca") : "";
            System.out.println("aqui:");
            System.out.println(busca);
            if(busca.equals("")) {
                String categoria = request.getParameter("cat");
                System.out.println("aqui**");
                List<ProdutoDTO> produtos = produtosDAO.buscarCategoria(Integer.parseInt(categoria));
                request.setAttribute("produtos", produtos);
            } else {
                busca = "%"+busca+"%";
                List<ProdutoDTO> produtos = produtosDAO.buscaProdutos(busca);
                request.setAttribute("produtos", produtos);
            }
            String nextPage = "/WEB-INF/jsp/index.jsp";
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
        newProduto.setNome(request.getParameter("nome"));
        System.out.println(request.getParameter("categorias"));
        newProduto.setCategoriaId(Integer.parseInt(request.getParameter("categorias"))); 
        newProduto.setValor(Float.parseFloat(request.getParameter("valor")));
        newProduto.setDescricao(request.getParameter("descricao"));
        newProduto.setTamanho(request.getParameter("tamanho"));
        Part filePart = request.getPart("imagem");
        InputStream istream = filePart.getInputStream();
        ByteArrayOutputStream byteA = new ByteArrayOutputStream();
        byte[] img = new byte[4096];
        int byteRead = -1;
        while((byteRead = istream.read(img)) != -1 ) {
            byteA.write(img, 0, byteRead);
        }
        byte[] imgBytes = byteA.toByteArray();
        newProduto.setImagem(imgBytes);
        ProdutosDAO produtosD = new ProdutosDAO();
        produtosD.cadastrarProduto(newProduto);
        response.sendRedirect("./menu");
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
