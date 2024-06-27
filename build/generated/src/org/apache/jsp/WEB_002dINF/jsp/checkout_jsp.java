package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class checkout_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
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

      out.write("    ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"./styles/checkout.css\">\r\n");
      out.write("\r\n");
      out.write("        <meta charset=\"UTF-8\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">\r\n");
      out.write("        <link rel=\"icon\" href=\"favicon.io\" type=\"image/x-icon\">\r\n");
      out.write("        <title>ecommerce</title>\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200\" />\r\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js\" integrity=\"sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("        <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js\" integrity=\"sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("        <script src=\"https://kit.fontawesome.com/187b9a1422.js\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("<header>\r\n");
      out.write("     <h1>Check-out</h1>\r\n");
      out.write("</header>\r\n");
      out.write("        <main>\r\n");
      out.write("                        <div id=\"TodoCheckout\">\r\n");
      out.write("                       \r\n");
      out.write("                            <form action=\"modificarEndereco\" method=\"post\" enctype=\"multipart/form-data\" >\r\n");
      out.write("               <div id=\"informacaoCliente\">\r\n");
      out.write("                            <h1>Informações Usuario</h1>\r\n");
      out.write("                            <div  id=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${usuario.id_usuario}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" class=\"organizar\">\r\n");
      out.write("                                <span>usuario id: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${usuario.id_usuario}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</span>\r\n");
      out.write("                                <span>Nome:</span>\r\n");
      out.write("                                <input type=\"text\" name=\"nome\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${usuario.nome}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" required>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"organizar\">\r\n");
      out.write("                                <span>Usuario:</span>\r\n");
      out.write("                                <input type=\"text\" name=\"usuario\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${usuario.usuario}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" required>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"organizar\">\r\n");
      out.write("                                <span>CPF:</span>\r\n");
      out.write("                                <input type=\"text\" name=\"cpf\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${usuario.cpf}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" required>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"organizar\">\r\n");
      out.write("                                <span>Telefone:</span>\r\n");
      out.write("                                <input type=\"text\" name=\"telefone\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${usuario.telefone}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" required>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            \r\n");
      out.write("                            <br><br>\r\n");
      out.write("                                    ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("           </form>\r\n");
      out.write("                                        <div id=\"FormasPagamentos\">\r\n");
      out.write("                                            \r\n");
      out.write("                                               \r\n");
      out.write("\r\n");
      out.write("            <div class=\"organizarCartao\">\r\n");
      out.write("                <div class=\"tituloPagamento\">\r\n");
      out.write("                    <h1>Informar pagamento</h1>\r\n");
      out.write("                </div>\r\n");
      out.write("            <!-- <img id=\"imgCartao\" src=\"./assets/FiguraCartaoCredito.png\" alt=\"imagem cartao de credito\"> -->\r\n");
      out.write("            <form id=\"formPagamento\">\r\n");
      out.write("                <input type=\"radio\" id=\"PagamentoPix\" name=\"pagamento\" value=\"pix\">\r\n");
      out.write("                <label for=\"pagamentoPix\">PIX</label><br>\r\n");
      out.write("                \r\n");
      out.write("                <input type=\"radio\" id=\"PagamentoCartaoCredito\" name=\"pagamento\" value=\"cartao_credito\">\r\n");
      out.write("                <label for=\"pagamentoCartaoCredito\">Cartão de Crédito</label><br>\r\n");
      out.write("                \r\n");
      out.write("                <input type=\"radio\" id=\"PagamentoCartaoDebito\" name=\"pagamento\" value=\"cartao_debito\">\r\n");
      out.write("                <label for=\"pagamentoCartaoDebito\">Cartão de Débito</label><br>\r\n");
      out.write("                \r\n");
      out.write("                <button type=\"submit\">Forma de pagamento</button>\r\n");
      out.write("            </form>\r\n");
      out.write("\r\n");
      out.write("            <div id=\"InformPix\" style=\"display: none;\">\r\n");
      out.write("                <div id=\"imgpix\">\r\n");
      out.write("                    <span>Imagem do pix</span>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div id=\"InformCartaoCredito\" style=\"display: none;\">\r\n");
      out.write("            <span>Nome do titular do cartão:</span>\r\n");
      out.write("        <input type=\"text\" name=\"titular_cartao\" >\r\n");
      out.write("    <span>Numero cartao:</span>\r\n");
      out.write("    <input type=\"number\" name=\"numero_cartao\" >\r\n");
      out.write("    <span>Codigo de segurança:</span>\r\n");
      out.write("    <input type=\"number\" name=\"codigo_seguranca\" >\r\n");
      out.write("    <span>Data de validade:</span>\r\n");
      out.write("    <input type=\"date\" id=\"data-validade\" name=\"data-validade\" >\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <div id=\"InformCartaoDebito\" style=\"display: none;\">\r\n");
      out.write("        <span>Número do Cartão de Débito:</span>\r\n");
      out.write("        <input type=\"text\" name=\"numeroCartaoDebito\">\r\n");
      out.write("        <span>Data de Validade:</span>\r\n");
      out.write("        <input type=\"text\" name=\"data-validade-debito\">\r\n");
      out.write("        <span>Código de Segurança (CVV):</span>\r\n");
      out.write("        <input type=\"text\" name=\"codigoSegurancaDebito\">\r\n");
      out.write("        <span>Nome do Titular do Cartão:</span>\r\n");
      out.write("        <input type=\"text\" name=\"nomeTitularCartaoDebito\">\r\n");
      out.write("        <span>CPF do Titular do Cartão:</span>\r\n");
      out.write("        <input type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${usuario.cpf}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" name=\"cpfTitularCartaoDebito\">\r\n");
      out.write("        <span>Endereço de Cobrança:</span>\r\n");
      out.write("        <input type=\"text\" name=\"enderecoCobrancaDebito\">\r\n");
      out.write("        <span>Senha do Cartão:</span>\r\n");
      out.write("        <input type=\"text\" name=\"senhaCobrancaCartao\">\r\n");
      out.write("    </div>           \r\n");
      out.write("      \r\n");
      out.write("\r\n");
      out.write("   </div>                        \r\n");
      out.write("</div>\r\n");
      out.write("<form action=\"AdicionarItemProdutosPedidos\" method=\"post\" enctype=\"multipart/form-data\">\r\n");
      out.write("    <div id=\"TudoSobreProdutos\">\r\n");
      out.write("        <h1>Produtos do carrinho</h1>\r\n");
      out.write("\r\n");
      out.write("        <section class=\"ProdutosCarrinhoCheckout\">\r\n");
      out.write("            <div id=\"ProdutosCheckout\">\r\n");
      out.write("                <div id=\"ProdutoMainCarrinho\">\r\n");
      out.write("                    ");
      if (_jspx_meth_c_forEach_1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                    <input type=\"hidden\" name=\"id_usuario\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${usuario.id_usuario}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </section>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"totalProdutosCheckout\">\r\n");
      out.write("            ");
      if (_jspx_meth_c_forEach_2(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div id=\"finalizacao\">\r\n");
      out.write("            <button type=\"submit\">Finalizar Compra</button>\r\n");
      out.write("            <a href=\"./menu\">Deseja voltar às compras? Clique aqui</a>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("                    </main>\r\n");
      out.write("<footer>\r\n");
      out.write("            <div class=\"rodape\">\r\n");
      out.write("            <div class=\"redesSociais\">\r\n");
      out.write("            <span>Visite nossas redes sociais</span>\r\n");
      out.write("           <span><i class=\"fa-brands fa-instagram\"></i>@modaUrbana</span>\r\n");
      out.write("           <span><i class=\"fa-brands fa-facebook\"></i>@modaUrbana</span>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"metodoContato\">\r\n");
      out.write("            <span>Nosso contato para você fazer seu pedido</span>\r\n");
      out.write("            <span><i class=\"fa-solid fa-phone\"></i>(43) 99888-8888</span>\r\n");
      out.write("            <span><i class=\"fa-brands fa-whatsapp\"></i>+55 (43) 9999-9999</span>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("        </footer>                                    \r\n");
      out.write("    </body>\r\n");
      out.write("   <script src=\"./js/checkout.js\"></script> \r\n");
      out.write("\r\n");
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

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setVar("enderecosExistente");
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${enderecoExistente}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\r\n");
          out.write("                            <h1 id=\"enderecosExistente.id_endereco\">Informações para Entrega</h1>\r\n");
          out.write("                            <span>usuario: ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${enderecosExistente.usuario_id1}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</span>\r\n");
          out.write("                            <span>enderecos: ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${enderecosExistente.id_endereco}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</span>\r\n");
          out.write("                            <div class=\"organizar\">\r\n");
          out.write("                                <span>Rua:</span>\r\n");
          out.write("                            <input type=\"text\" name=\"rua\" id=\"rua\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${enderecosExistente.rua != null ? enderecosExistente.rua : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" >\r\n");
          out.write("                        </div>\r\n");
          out.write("                    <div class=\"organizar\">\r\n");
          out.write("                        <span>Número:</span>\r\n");
          out.write("                    <input type=\"number\" name=\"numero\" id=\"numero\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${enderecosExistente.numero != null ? enderecosExistente.numero : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">\r\n");
          out.write("                </div>\r\n");
          out.write("            <div class=\"organizar\">\r\n");
          out.write("                <span>CEP:</span>\r\n");
          out.write("                <input onkeyup=\"CepInput(event)\" maxlength=\"9\" type=\"text\" name=\"cep\" id=\"cep\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${enderecosExistente.cep != null ? enderecosExistente.cep : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">\r\n");
          out.write("        </div>\r\n");
          out.write("    <div class=\"organizar\">\r\n");
          out.write("        <span>Complemento:</span>\r\n");
          out.write("    <input type=\"text\" name=\"complemento\" id=\"complemento\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${enderecosExistente.complemento != null ? enderecosExistente.complemento : ''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">\r\n");
          out.write("</div>\r\n");
          out.write("    <input type=\"hidden\" name=\"id_usuario\" id=\"id_usuario\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${usuario.id_usuario}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">\r\n");
          out.write("    <input type=\"hidden\" name=\"id_endereco\" id=\"id_endereco\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${enderecosExistente.id_endereco}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">\r\n");
          out.write("    <input type=\"hidden\" name=\"rua\" id=\"rua\" >\r\n");
          out.write("    <input type=\"hidden\" name=\"numero\" id=\"numero\">\r\n");
          out.write("    <input type=\"hidden\" name=\"cep\" id=\"cep\" >\r\n");
          out.write("    <input type=\"hidden\" name=\"complemento\" id=\"complemento\" >\r\n");
          out.write("    <div class=\"organizar\">\r\n");
          out.write("        <button type=\"submit\">Salvar Endereço</button>\r\n");
          out.write("    </div>\r\n");
          out.write("</div>\r\n");
          out.write("     \r\n");
          out.write("\r\n");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }

  private boolean _jspx_meth_c_forEach_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_1.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_1.setParent(null);
    _jspx_th_c_forEach_1.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${carrinhos}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_1.setVar("carrinho");
    int[] _jspx_push_body_count_c_forEach_1 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_1 = _jspx_th_c_forEach_1.doStartTag();
      if (_jspx_eval_c_forEach_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("                        <div class=\"informacoesProdutosCheckout\">\r\n");
          out.write("                            <img src=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${carrinho.imagemCarrinho}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" alt=\"...\">\r\n");
          out.write("                            <div class=\"infProd\">\r\n");
          out.write("                                <p class=\"card-title\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${carrinho.nomeCarrinho}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</p>\r\n");
          out.write("                                <p class=\"card-title\">idProduto: ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${carrinho.produtoId3}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</p>\r\n");
          out.write("                                <p class=\"card-text\">Descrição: ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${carrinho.descricaoCarrinho}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</p>\r\n");
          out.write("                            </div>\r\n");
          out.write("                            <div class=\"infProd\">\r\n");
          out.write("                                <p class=\"card-text\">Tamanho id: ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${carrinho.tamanhoId3}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</p>\r\n");
          out.write("                                <p class=\"card-text\">Tamanho: ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${carrinho.tamanho}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</p>\r\n");
          out.write("                                <p class=\"card-text\">Categorias: ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${carrinho.nomeCategoria}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</p>\r\n");
          out.write("                            </div>\r\n");
          out.write("                            <div class=\"infProd\">\r\n");
          out.write("                                <!-- Formulário separado para excluir o item do carrinho -->\r\n");
          out.write("                                <form action=\"ExcluirItemCarrinho\" method=\"post\">\r\n");
          out.write("                                <button type=\"button\" class=\"button\" onclick=\"excluirItemCarrinho(");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${carrinho.id_carrinho}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write(',');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${carrinho.quantidadeCarrinho}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write(',');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${carrinho.produtoId3}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write(")\">\r\n");
          out.write("                                    <i class=\"svgIcon fa-sharp fa-solid fa-trash\"></i>\r\n");
          out.write("                                </button>\r\n");
          out.write("                                    <input type=\"hidden\" name=\"idCarrinho\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${carrinho.id_carrinho}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">\r\n");
          out.write("                                    <input type=\"hidden\" name=\"idProduto\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${carrinho.produtoId3}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">                                    \r\n");
          out.write("                                    <input type=\"hidden\" name=\"quantidadeCarrinho\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${carrinho.quantidadeCarrinho}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">\r\n");
          out.write("                                </form>\r\n");
          out.write("                                <p class=\"card-text\">Categoria ID: R$");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${carrinho.categoriaId3}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</p>\r\n");
          out.write("                                <p class=\"card-text\">Unidades: ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${carrinho.quantidadeCarrinho}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</p>\r\n");
          out.write("                                <p class=\"card-text\">Valor Unidade: R$");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${carrinho.valorCarrinho}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</p>\r\n");
          out.write("                            </div>\r\n");
          out.write("                        </div>\r\n");
          out.write("                        <!-- Campos escondidos para adicionar produtos aos pedidos -->\r\n");
          out.write("                        <input type=\"hidden\" name=\"produtoId\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${carrinho.produtoId3}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">\r\n");
          out.write("                        <input type=\"hidden\" name=\"descricao\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${carrinho.descricaoCarrinho}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">\r\n");
          out.write("                        <input type=\"hidden\" name=\"nomeCarrinho\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${carrinho.nomeCarrinho}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">\r\n");
          out.write("                        <input type=\"hidden\" name=\"valor\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${carrinho.valorCarrinho}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">\r\n");
          out.write("                        <input type=\"hidden\" name=\"quantidade\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${carrinho.quantidadeCarrinho}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">\r\n");
          out.write("                        <input type=\"hidden\" name=\"tamanho\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${carrinho.tamanhoId3}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">\r\n");
          out.write("                        <input type=\"hidden\" name=\"categoria\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${carrinho.categoriaId3}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">\r\n");
          out.write("                        <input type=\"hidden\" name=\"imagem\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${carrinho.imagemCarrinho}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">\r\n");
          out.write("                    ");
          int evalDoAfterBody = _jspx_th_c_forEach_1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_1.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_1);
    }
    return false;
  }

  private boolean _jspx_meth_c_forEach_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_2 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_2.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_2.setParent(null);
    _jspx_th_c_forEach_2.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${totalCarrinho}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_2.setVar("totalCarrinhos");
    int[] _jspx_push_body_count_c_forEach_2 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_2 = _jspx_th_c_forEach_2.doStartTag();
      if (_jspx_eval_c_forEach_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("                <div class=\"valorTotal\">\r\n");
          out.write("                    <span class=\"text\"> Valor Total: R$ ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${totalCarrinhos.total}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</span>\r\n");
          out.write("                </div>\r\n");
          out.write("            ");
          int evalDoAfterBody = _jspx_th_c_forEach_2.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_2[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_2.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_2.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_2);
    }
    return false;
  }
}
