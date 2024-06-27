
package model.bean;

/**
 *
 * @author Senai
 */
public class CarrinhoDTO {
    private int id_carrinho;
    private String nomeCarrinho;
    private float valorCarrinho;
    private String imagemCarrinho ;
    private String descricaoCarrinho;
    private int quantidadeCarrinho;
    private int produtoId3;
    private float total;
    private float totalProdutos;
    private String nomeCategoria;
    private String tamanho;
    private int tamanhoId3;
    private int categoriaId3;
    private int usuarioId3;

    public CarrinhoDTO() {
    }

    public CarrinhoDTO(int id_carrinho, String nomeCarrinho, float valorCarrinho, String imagemCarrinho, String descricaoCarrinho, int quantidadeCarrinho, int produtoId3, float total, float totalProdutos, String nomeCategoria, String tamanho, int tamanhoId3, int categoriaId3, int usuarioId3) {
        this.id_carrinho = id_carrinho;
        this.nomeCarrinho = nomeCarrinho;
        this.valorCarrinho = valorCarrinho;
        this.imagemCarrinho = imagemCarrinho;
        this.descricaoCarrinho = descricaoCarrinho;
        this.quantidadeCarrinho = quantidadeCarrinho;
        this.produtoId3 = produtoId3;
        this.total = total;
        this.totalProdutos = totalProdutos;
        this.nomeCategoria = nomeCategoria;
        this.tamanho = tamanho;
        this.tamanhoId3 = tamanhoId3;
        this.categoriaId3 = categoriaId3;
        this.usuarioId3 = usuarioId3;
    }

    public int getId_carrinho() {
        return id_carrinho;
    }

    public void setId_carrinho(int id_carrinho) {
        this.id_carrinho = id_carrinho;
    }

    public String getNomeCarrinho() {
        return nomeCarrinho;
    }

    public void setNomeCarrinho(String nomeCarrinho) {
        this.nomeCarrinho = nomeCarrinho;
    }

    public float getValorCarrinho() {
        return valorCarrinho;
    }

    public void setValorCarrinho(float valorCarrinho) {
        this.valorCarrinho = valorCarrinho;
    }

    public String getImagemCarrinho() {
        return imagemCarrinho;
    }

    public void setImagemCarrinho(String imagemCarrinho) {
        this.imagemCarrinho = imagemCarrinho;
    }

    public String getDescricaoCarrinho() {
        return descricaoCarrinho;
    }

    public void setDescricaoCarrinho(String descricaoCarrinho) {
        this.descricaoCarrinho = descricaoCarrinho;
    }

    public int getQuantidadeCarrinho() {
        return quantidadeCarrinho;
    }

    public void setQuantidadeCarrinho(int quantidadeCarrinho) {
        this.quantidadeCarrinho = quantidadeCarrinho;
    }

    public int getProdutoId3() {
        return produtoId3;
    }

    public void setProdutoId3(int produtoId3) {
        this.produtoId3 = produtoId3;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public float getTotalProdutos() {
        return totalProdutos;
    }

    public void setTotalProdutos(float totalProdutos) {
        this.totalProdutos = totalProdutos;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public int getTamanhoId3() {
        return tamanhoId3;
    }

    public void setTamanhoId3(int tamanhoId3) {
        this.tamanhoId3 = tamanhoId3;
    }

    public int getCategoriaId3() {
        return categoriaId3;
    }

    public void setCategoriaId3(int categoriaId3) {
        this.categoriaId3 = categoriaId3;
    }

    public int getUsuarioId3() {
        return usuarioId3;
    }

    public void setUsuarioId3(int usuarioId3) {
        this.usuarioId3 = usuarioId3;
    }
    

}