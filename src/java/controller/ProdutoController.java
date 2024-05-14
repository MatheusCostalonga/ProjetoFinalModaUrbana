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

    CarrinhoDTO carrinho = new CarrinhoDTO();
    CarrinhoDAO carrinhos = new CarrinhoDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                ProdutosDAO produtosDAO = new ProdutosDAO();
                int id_produto = Integer.parseInt(request.getParameter("id"));

        List<ProdutoDTO> produtos = produtosDAO.buscarProduto(id_produto);
        request.setAttribute("produtos", produtos);
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
        CarrinhoDTO carrinho = new CarrinhoDTO();
        PrintWriter out = response.getWriter();
        System.out.println(request.getParameter("nome_produto_carrinho"));
        System.out.println(request.getParameter("valor_produto_carrinho"));
        carrinho.setNomeCarrinho(request.getParameter("nome_produto_carrinho"));
        carrinho.setValorCarrinho(Float.parseFloat(request.getParameter("valor_produto_carrinho")));
        carrinho.setDescricaoCarrinho(request.getParameter("descricao_produto_carrinho"));
        carrinho.setQuantidadeCarrinho(Integer.parseInt(request.getParameter("quantidade_carrinho")));
        carrinho.setProdutoId3(Integer.parseInt(request.getParameter("produto_id3")));
        carrinho.setImagemCarrinho(request.getParameter("imagem_produto_carrinho"));
        carrinhos.cadastrarCarrinho(carrinho);
        out.println("<script type=\"text/javascript\">");
        out.println("alert('Compra feita com sucesso.');");
        out.println("window.location.href = './pages/produto.jsp';");
        out.println("</script>");
        response.sendRedirect("./menu");

    }
    /**                ProdutoDTO newProduto = new ProdutoDTO();
        newProduto.setNome(request.getParameter("nome"));
        System.out.println(request.getParameter("categorias"));
        newProduto.setCategoriaId(Integer.parseInt(request.getParameter("categorias"))); 
        newProduto.setValor(Float.parseFloat(request.getParameter("valor")));
        newProduto.setDescricao(request.getParameter("descricao"));
        newProduto.setTamanho(request.getParameter("tamanho"));
Part filePart = request.getPart("imagem");
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        if (fileName != null && !fileName.isEmpty()) {
        String basePath = getServletContext().getRealPath("/") + "assets"; // Caminho para a pasta assets
        File uploads = new File(basePath);
        if (!uploads.exists()) {
            uploads.mkdirs(); // Cria o diretório se não existir
        }
        File file = new File(uploads, fileName);

        try (InputStream input = filePart.getInputStream()) {
            Files.copy(input, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
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
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
