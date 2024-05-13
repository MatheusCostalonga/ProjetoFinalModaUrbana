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
public class CarrinhoDTO {
    private int id_carrinho;
    private String nomeCarrinho;
    private Float valorCarrinho;
    private byte[] imagemCarrinho ;
    private String descricaoCarrinho;
    private int quantidadeCarrinho;
    private int produtoId3;
    private int usuarioId3;

    public CarrinhoDTO() {
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

    public Float getValorCarrinho() {
        return valorCarrinho;
    }

    public void setValorCarrinho(Float valorCarrinho) {
        this.valorCarrinho = valorCarrinho;
    }

    public byte[] getImagemCarrinho() {
        return imagemCarrinho;
    }

    public void setImagemCarrinho(byte[] imagemCarrinho) {
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

    public int getUsuarioId3() {
        return usuarioId3;
    }

    public void setUsuarioId3(int usuarioId3) {
        this.usuarioId3 = usuarioId3;
    }
    
    
}
