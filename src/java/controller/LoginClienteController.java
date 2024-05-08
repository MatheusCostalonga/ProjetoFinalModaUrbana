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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO.UsuarioDAO;
import model.bean.UsuarioDTO;


@WebServlet(name = "LoginClienteController", urlPatterns = {"/loginCliente","/logado","/clientes", "/insert"})
public class LoginClienteController extends HttpServlet {
            UsuarioDTO usuario = new UsuarioDTO();
            UsuarioDAO usuarios = new UsuarioDAO();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.       
     * <servlet-mapping>
        <servlet-name>LoginClienteController</servlet-name>
        <url-pattern>/logarCliente</url-pattern>
    </servlet-mapping>
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                String url = request.getServletPath();
    switch (url) {
            case "/loginCliente": {
                String path = "/WEB-INF/jsp/TelaLogin.jsp";
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(path);
                dispatcher.forward(request, response);
                break;
            }
            case "/logado": {
                String path = "/WEB-INF/jsp/index.jsp";
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(path);
                dispatcher.forward(request, response);
                break;
            }
        
                default:
                break;
        }
        if (url.equals("/insert")) {
            doPost(request, response);
        
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
                String url = request.getServletPath();
        if (url.equals("/clientes")) {
            List<UsuarioDTO> clientes = usuarios.ler();

            Gson gson = new Gson();
            String json = gson.toJson(clientes);

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
     
    
      protected void entrar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        usuario.setUsuario(request.getParameter("usuario"));
        usuario.setSenha(request.getParameter("senha"));
        PrintWriter tout = response.getWriter();
          System.out.println("aqui");
          System.out.println(usuario.getUsuario());
          System.out.println(usuario.getSenha());
        if (usuario.getUsuario().trim().equals("") || usuario.getSenha().trim().equals("")) {
            tout.println("<script type=\"text/javascript\">");
            tout.println("alert('Por favor, preencha todos os campos.');");
            tout.println("window.location.href = './loginCliente';");
            tout.println("</script>"); 
        }else{
            UsuarioDTO user = usuarios.validaUsuario(usuario);
            if(user.getId_usuario()> 0) {
                response.sendRedirect("./menu");
            } else {
            tout.println("<script type=\"text/javascript\">");
            tout.println("alert('Login ou senha incoretos!.');");
            tout.println("window.location.href = './loginCliente';");
            tout.println("</script>");
                }
            } 
      } */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        usuario.setNome(request.getParameter("nome"));
        usuario.setSenha(request.getParameter("senha"));
        usuario.setUsuario(request.getParameter("usuario"));
        usuario.setTelefone(request.getParameter("telefone"));
        usuario.setData_nascimento(request.getParameter("data_nascimento"));
        usuario.setCpf(request.getParameter("cpf"));
        usuarios.inserir(usuario);
        String path = "/WEB-INF/jsp/login.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(path);
        dispatcher.forward(request, response);
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
