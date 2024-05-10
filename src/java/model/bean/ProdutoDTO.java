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
    private String nome;
    private byte[] imagem;
    private Blob imgBlob;
    private float valor;
    private String descricao;
    private String tamanho;
    private int categoriaId;
    
    public ProdutoDTO() {
    }

    public ProdutoDTO(int idProduto, String nome, byte[] imagem, Blob imgBlob, float valor, String descricao, String tamanho, int categoriaId) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.imagem = imagem;
        this.imgBlob = imgBlob;
        this.valor = valor;
        this.descricao = descricao;
        this.tamanho = tamanho;
        this.categoriaId = categoriaId;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

    public Blob getImgBlob() {
        return imgBlob;
    }

    public void setImgBlob(Blob imgBlob) {
        this.imgBlob = imgBlob;
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

   
    
    
    
}
