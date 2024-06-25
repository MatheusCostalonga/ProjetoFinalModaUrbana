/*                                                                                                                               /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO.UsuarioDAO;
import model.bean.UsuarioDTO;

@WebServlet(urlPatterns = {"/loginCliente", "/logar"})
@MultipartConfig

public class LoginClienteController extends HttpServlet {

    UsuarioDTO usuario = new UsuarioDTO();
    UsuarioDAO usuarios = new UsuarioDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nextPage = "/WEB-INF/jsp/TelaLogin.jsp";
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("continuarLogin")) {

                usuario = usuarios.leia(Integer.parseInt(cookie.getValue()));
                request.setAttribute("usuario", usuario);
            }
        }
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
     *
     *
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = request.getServletPath();
        if (url.equals("/logar")) {
            realizarLogin(request, response);
        } else {
            processRequest(request, response);
        }

    }
    

    protected void realizarLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        usuario.setUsuario(request.getParameter("usuario"));
        usuario.setSenha(request.getParameter("senha"));
        PrintWriter out = response.getWriter();
        String cliente = request.getParameter("usuario");
        int idUsuario = usuarios.validaUsuario(usuario);
        if (usuario.getUsuario().trim().equals("") || usuario.getSenha().trim().equals("")) {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Por favor, preencha todos os campos.');");
            out.println("window.location.href = './loginCliente';");
            out.println("</script>");
        } else {

            if (idUsuario > 0) {
                Cookie cookie = new Cookie("continuarLogin", Integer.toString(idUsuario));
                response.addCookie(cookie);
                if (idUsuario == 1) {
                   sucesso(request, response);
                } else {
                   sucesso(request, response);
                }
            } else {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('login não encontrado.');");
                out.println("window.location.href = './loginCliente';");
                out.println("</script>");
            }
        }
    }
    protected void sucesso(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                PrintWriter out = response.getWriter();
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
        out.println("  title: 'Login efetuado com sucesso',");
        out.println("  text: 'Seja bem vindo',");
        out.println("  showConfirmButton: false, ");// Remove o botão de confirmação
        out.println("});");

        // Redireciona automaticamente para a página inicial quando der o tempo determinado
        out.println("setTimeout(function() {");
        out.println("  window.location.href = 'menu';");
        out.println("}, 3000);");

        out.println("</script>");
        out.println("</body>");
        out.println("</html>");
    }
    /**

     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
