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
public class EstoqueDTO {
    
    private int id_estoque;
    private int produto_id2;
    private int quantidad_estoque;

    public EstoqueDTO() {
    }

    public EstoqueDTO(int id_estoque, int produto_id2, int quantidad_estoque) {
        this.id_estoque = id_estoque;
        this.produto_id2 = produto_id2;
        this.quantidad_estoque = quantidad_estoque;
    }

    public int getId_estoque() {
        return id_estoque;
    }

    public void setId_estoque(int id_estoque) {
        this.id_estoque = id_estoque;
    }

    public int getProduto_id2() {
        return produto_id2;
    }

    public void setProduto_id2(int produto_id2) {
        this.produto_id2 = produto_id2;
    }

    public int getQuantidad_estoque() {
        return quantidad_estoque;
    }

    public void setQuantidad_estoque(int quantidad_estoque) {
        this.quantidad_estoque = quantidad_estoque;
    }
    
    
    
}
