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
import model.DAO.UsuarioDAO;
import model.bean.CarrinhoDTO;
import model.bean.EnderecosDTO;
import model.bean.UsuarioDTO;

/**
 *
 * @author Leandro
 */
@WebServlet(urlPatterns = {"/checkout", "/modificarEndereco"})
@MultipartConfig
public class CheckoutController extends HttpServlet {
    CarrinhoDTO carrinhosdto = new CarrinhoDTO();
    CarrinhoDAO carrinho = new CarrinhoDAO();
    EnderecosDTO enderecosdto = new EnderecosDTO();
    EnderecoDAO endereco = new EnderecoDAO();
    
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

        Cookie[] cookies = request.getCookies();
        if(cookies != null){
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("continuarLogin")) {
                
                usuario = usuarios.leia(Integer.parseInt(cookie.getValue()));
                request.setAttribute("usuario", usuario);
                int idUsuario = Integer.parseInt(cookie.getValue());
               
                     List<CarrinhoDTO> carrinhos = carrinho.MostrarTamanho();       
        request.setAttribute("carrinhos", carrinhos);
        List<CarrinhoDTO> totalCarrinho = carrinho.leiaTotal();       
        request.setAttribute("totalCarrinho", totalCarrinho);
                List<EnderecosDTO> enderecoExistente = endereco.EndercoUsuarios(idUsuario);
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
             String action = request.getParameter("action");
             System.out.println("chegou aqui no checkout");
                if ("InserirEndereco".equals("action")) {
                         System.out.println("inserirEndereço");
   inserirEndereco(request, response);
    } else if ("EditarEndereco".equals("action")) {
                    System.out.println("EditarEndereco");
        editarEndereco(request, response);
    } else {
        processRequest(request, response);
         out.println("<script type=\"text/javascript\">");
            out.println("alert('Coloque todas as informações que estão sendo solicitadas');");
            out.println("</script>");
    }    
  }
          protected void inserirEndereco(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        PrintWriter out = response.getWriter();      
        EnderecosDTO newEndereco = new EnderecosDTO();
        newEndereco.setRua(request.getParameter("rua"));
        newEndereco.setNumero(Integer.parseInt("numero"));
        newEndereco.setUsuario_id1(Integer.parseInt("id_usuario"));
        newEndereco.setCep(request.getParameter("cep"));
        newEndereco.setComplemento(request.getParameter("complemento"));
        endereco.inserir(newEndereco);
                    out.println("<script type=\"text/javascript\">");
            out.println("alert('Informações adicionadas com sucesso');");
            out.println("window.location.href = './checkout';");
            out.println("</script>");}
          
        protected void editarEndereco(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        PrintWriter out = response.getWriter();      
        EnderecosDTO newEndereco = new EnderecosDTO();
        newEndereco.setId_endereco(Integer.parseInt("id_endereco"));
        newEndereco.setRua(request.getParameter("rua"));
        newEndereco.setNumero(Integer.parseInt("numero"));
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
