/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.sql.Blob;

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
    private String tamanho;
    private int categoriaId;
    private int quantidade;
    
    public ProdutoDTO() {
    }

    public ProdutoDTO(int idProduto, String nome_produto, String imagem, float valor, String descricao, String tamanho, int categoriaId, int quantidade) {
        this.idProduto = idProduto;
        this.nome_produto = nome_produto;
        this.imagem = imagem;
        this.valor = valor;
        this.descricao = descricao;
        this.tamanho = tamanho;
        this.categoriaId = categoriaId;
        this.quantidade = quantidade;
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

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
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

}
