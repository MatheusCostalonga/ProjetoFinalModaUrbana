/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO.UsuarioDAO;
import model.bean.UsuarioDTO;

/**
 *
 * @author Senai
 */
@WebServlet(urlPatterns = {"/users", "/inserir"})
@MultipartConfig
public class CadastroClienteController extends HttpServlet {
UsuarioDAO usuarios = new UsuarioDAO();
UsuarioDTO usuario = new UsuarioDTO();

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
        String url = request.getServletPath();
        if (url.equals("/CadastroClienteController")) {
            String path = "/WEB-INF/jsp/TelaCadastro.jsp";
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(path);
                dispatcher.forward(request, response);
                
        } 
        if (url.equals("/inserir")) {
            doPost(request, response);
        }     
    }

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
        String url = request.getServletPath();
        if (url.equals("/users")) {
            List<UsuarioDTO> users = usuarios.ler();

            Gson gson = new Gson();
            String json = gson.toJson(users);

            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
        }
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
        usuario.setNome(request.getParameter("nome"));
        usuario.setCpf(request.getParameter("cpf"));
        usuario.setTelefone(request.getParameter("telefone"));
        usuario.setData_nascimento(request.getParameter("data_nascimento"));
        usuario.setUsuario(request.getParameter("usuario"));
        usuario.setSenha(request.getParameter("senha"));
        usuarios.inserir(usuario);
        
          PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Cadastro bem sucedido</title>");
        out.println("<script src=\"https://cdn.jsdelivr.net/npm/sweetalert2@11\"></script>");
        out.println("</head>");
        out.println("<body>");

        // Exibe o SweetAlert com a mensagem de sucesso
        out.println("<script>");
        out.println("Swal.fire({");
        out.println("  icon: 'success',");
        out.println("  title: 'Cadastro realizado co sucesso',");
        out.println("  text: '',");
        out.println("  showConfirmButton: false, ");// Remove o botão de confirmação
        out.println("});");

        // Redireciona automaticamente para a página inicial quando der o tempo determinado
        out.println("setTimeout(function() {");
        out.println("  window.location.href = 'login';");
        out.println("}, 3000);");

        out.println("</script>");
        out.println("</body>");
        out.println("</html>");
        String path = "/WEB-INF/jsp/TelaLogin.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(path);
        dispatcher.forward(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
