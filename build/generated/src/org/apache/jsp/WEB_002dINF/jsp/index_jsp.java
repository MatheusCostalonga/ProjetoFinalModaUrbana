package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\r\n");
      out.write("    \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"./styles/menu.css\">\r\n");
      out.write("        <meta charset=\"UTF-8\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">\r\n");
      out.write("         \r\n");
      out.write("        <title>ecommerce</title>\r\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js\" integrity=\"sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("        <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js\" integrity=\"sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("        <script src=\"https://kit.fontawesome.com/187b9a1422.js\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("    <header>\r\n");
      out.write("        <img class=\"imagemLogo\" src=\"./assets/LogoModaUrbana.png\" alt=\"Logo da moda urbana\">\r\n");
      out.write("        <div  class=\"buttonCarrinho\">\r\n");
      out.write("            <button><i id=\"buttonIconeCarrinho\" class=\"fa-solid fa-cart-shopping\"></i></button>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"buttonIcone\">\r\n");
      out.write("            <button><i id=\"iconeUsuario\" class=\"fa-solid fa-user\"></i>    Minha Conta ↓</button>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"buttonLupa\">\r\n");
      out.write("            <input type=\"text\" id=\"pesquisa\" placeholder=\"Pesquisar\">\r\n");
      out.write("            <button><i id=\"buttonIconeLupa\" class=\"fa-solid fa-magnifying-glass\"></i></button>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <nav class=\"categorias\">\r\n");
      out.write("\r\n");
      out.write("            <div class=\"main-menu\">\r\n");
      out.write("                <b><a class=\"open-btn\" href=\"#\"><i id=\"iconeCategoria\" class=\"fa-solid fa-bars menu\"></i>  Todas as Categorias</i></a></b>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"offcanvas-menu\">\r\n");
      out.write("                    <button   class=\"close-btn\" href=\"#\"><i class=\"fa-solid fa-xmark\"></i></button>\r\n");
      out.write("                    <ul>\r\n");
      out.write("                        <li><a href=\"./loginCliente\">Login</a></li>//jaqueta\r\n");
      out.write("                        <li><a href=\"./cadastroCliente\">Cadastro</a></li>//Camisetas\r\n");
      out.write("                        <li><a href=\"./produtoSelecionado\">Produto</a></li>//Camisas\r\n");
      out.write("                        <li><a href=\"./ProdutosCategoria\">Produtos Categorias</a></li>//Calçass\r\n");
      out.write("                        \r\n");
      out.write("                        <li><a href=\"#\">Bermudas</a></li>\r\n");
      out.write("                        <li><a href=\"#\">Tênis</a></li>\r\n");
      out.write("                        <li><a href=\"#\">Marcas</a></li>\r\n");
      out.write("                        <li><a href=\"#\">Acessorios</a></li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>  \r\n");
      out.write("            <div>\r\n");
      out.write("                <b><a href=\"\">Descontos</a></b>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div>\r\n");
      out.write("                <b> <a href=\"\">Novidades</a></b>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div>\r\n");
      out.write("                <b> <a href=\"\">Mais Vendidos</a></b>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("        </nav> \r\n");
      out.write("    </header>\r\n");
      out.write("    <main>\r\n");
      out.write("        <div id=\"carouselExampleControls\" class=\"carousel slide\" data-ride=\"carousel\">\r\n");
      out.write("            <div class=\"carousel-inner\">\r\n");
      out.write("                <div class=\"carousel-item active\">\r\n");
      out.write("                    <img class=\"d-block w-100\" src=\"./assets/Carrousel1.png\" alt=\"Primeiro Slide\">\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"carousel-item\">\r\n");
      out.write("                    <img class=\"d-block w-100\" src=\"./assets/Carrousel2.png\" alt=\"Segundo Slide\">\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"carousel-item\">\r\n");
      out.write("                    <img class=\"d-block w-100\" src=\"./assets/Carrousel3.png\" alt=\"Terceiro Slide\">\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <a class=\"carousel-control-prev\" href=\"#carouselExampleControls\" role=\"button\" data-slide=\"prev\">\r\n");
      out.write("                <span class=\"carousel-control-prev-icon\" aria-hidden=\"true\"></span>\r\n");
      out.write("                <span class=\"sr-only\">Anterior</span>\r\n");
      out.write("            </a>\r\n");
      out.write("            <a class=\"carousel-control-next\" href=\"#carouselExampleControls\" role=\"button\" data-slide=\"next\">\r\n");
      out.write("                <span class=\"carousel-control-next-icon\" aria-hidden=\"true\"></span>\r\n");
      out.write("                <span class=\"sr-only\">Próximo</span>\r\n");
      out.write("            </a>\r\n");
      out.write("        </div>\r\n");
      out.write("    </main>\r\n");
      out.write("    <footer>\r\n");
      out.write("\r\n");
      out.write("    </footer>\r\n");
      out.write("<script src=\"./js/menu.js\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
