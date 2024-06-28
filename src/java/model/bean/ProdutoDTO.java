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
    private float valor;
    private String descricao;
    private int tamanhoId;
    private String qual_tamanho;
    private int categoriaId;
    private int quantidade;
    private String nome_categoria;
    private float total_produtos;
    
    public ProdutoDTO() {
    }

    public ProdutoDTO(int idProduto, String nome_produto, String imagem, float valor, String descricao, int tamanhoId, String qual_tamanho, int categoriaId, int quantidade, String nome_categoria, float total_produtos) {
        this.idProduto = idProduto;
        this.nome_produto = nome_produto;
        this.imagem = imagem;
        this.valor = valor;
        this.descricao = descricao;
        this.tamanhoId = tamanhoId;
        this.qual_tamanho = qual_tamanho;
        this.categoriaId = categoriaId;
        this.quantidade = quantidade;
        this.nome_categoria = nome_categoria;
        this.total_produtos = total_produtos;
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

    public float getTotal_produtos() {
        return total_produtos;
    }

    public void setTotal_produtos(float total_produtos) {
        this.total_produtos = total_produtos;
    }

    
}
