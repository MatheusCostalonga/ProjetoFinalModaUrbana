/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;


/**
 *
 * @author Senai
 */
public class ProdutoDTO {
    
     private int idProduto;
    private String nome_produto;
    private String imagem;
    private String imagem1;
    private String imagem2;
    private String imagem3;
    private float valor;
    private String descricao;
    private int tamanhoId;
    private String qual_tamanho;
    private int categoriaId;
    private int quantidade;
    private String nome_categoria;
    
    public ProdutoDTO() {
    }

    public ProdutoDTO(int idProduto, String nome_produto, String imagem, String imagem1, String imagem2, String imagem3, float valor, String descricao, int tamanhoId, String qual_tamanho, int categoriaId, int quantidade, String nome_categoria) {
        this.idProduto = idProduto;
        this.nome_produto = nome_produto;
        this.imagem = imagem;
        this.imagem1 = imagem1;
        this.imagem2 = imagem2;
        this.imagem3 = imagem3;
        this.valor = valor;
        this.descricao = descricao;
        this.tamanhoId = tamanhoId;
        this.qual_tamanho = qual_tamanho;
        this.categoriaId = categoriaId;
        this.quantidade = quantidade;
        this.nome_categoria = nome_categoria;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome_produto() {
        return nome_produto;
    }

    public void setNome_produto(String nome_produto) {
        this.nome_produto = nome_produto;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getImagem1() {
        return imagem1;
    }

    public void setImagem1(String imagem1) {
        this.imagem1 = imagem1;
    }

    public String getImagem2() {
        return imagem2;
    }

    public void setImagem2(String imagem2) {
        this.imagem2 = imagem2;
    }

    public String getImagem3() {
        return imagem3;
    }

    public void setImagem3(String imagem3) {
        this.imagem3 = imagem3;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getTamanhoId() {
        return tamanhoId;
    }

    public void setTamanhoId(int tamanhoId) {
        this.tamanhoId = tamanhoId;
    }

    public String getQual_tamanho() {
        return qual_tamanho;
    }

    public void setQual_tamanho(String qual_tamanho) {
        this.qual_tamanho = qual_tamanho;
    }

    public int getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getNome_categoria() {
        return nome_categoria;
    }

    public void setNome_categoria(String nome_categoria) {
        this.nome_categoria = nome_categoria;
    }

    
}
