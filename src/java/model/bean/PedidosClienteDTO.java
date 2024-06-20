/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.sql.Date;

/**
 *
 * @author Leandro
 */
public class PedidosClienteDTO {
    private int id_pedidosClientes;
    private String nome_produtos_pedidos;
    private float valor_pedidos_produtos;
    private String imagem_pedidos_produtos;
    private String descricao_pedidos_produtos;
    private int quantidade_pedidos_produtos ;
    private Date data_pedido;
    private String nome_tamanho;
    private int tamanho_id4;
    private int produto_id4;
    private int usuario_id4;
    private String nome_categoria;
    private int categoria_id4;

    public PedidosClienteDTO() {
    }

    public PedidosClienteDTO(int id_pedidosClientes, String nome_produtos_pedidos, float valor_pedidos_produtos, String imagem_pedidos_produtos, String descricao_pedidos_produtos, int quantidade_pedidos_produtos, Date data_pedido, String nome_tamanho, int tamanho_id4, int produto_id4, int usuario_id4, String nome_categoria, int categoria_id4) {
        this.id_pedidosClientes = id_pedidosClientes;
        this.nome_produtos_pedidos = nome_produtos_pedidos;
        this.valor_pedidos_produtos = valor_pedidos_produtos;
        this.imagem_pedidos_produtos = imagem_pedidos_produtos;
        this.descricao_pedidos_produtos = descricao_pedidos_produtos;
        this.quantidade_pedidos_produtos = quantidade_pedidos_produtos;
        this.data_pedido = data_pedido;
        this.nome_tamanho = nome_tamanho;
        this.tamanho_id4 = tamanho_id4;
        this.produto_id4 = produto_id4;
        this.usuario_id4 = usuario_id4;
        this.nome_categoria = nome_categoria;
        this.categoria_id4 = categoria_id4;
    }

    public int getId_pedidosClientes() {
        return id_pedidosClientes;
    }

    public void setId_pedidosClientes(int id_pedidosClientes) {
        this.id_pedidosClientes = id_pedidosClientes;
    }

    public String getNome_produtos_pedidos() {
        return nome_produtos_pedidos;
    }

    public void setNome_produtos_pedidos(String nome_produtos_pedidos) {
        this.nome_produtos_pedidos = nome_produtos_pedidos;
    }

    public float getValor_pedidos_produtos() {
        return valor_pedidos_produtos;
    }

    public void setValor_pedidos_produtos(float valor_pedidos_produtos) {
        this.valor_pedidos_produtos = valor_pedidos_produtos;
    }

    public String getImagem_pedidos_produtos() {
        return imagem_pedidos_produtos;
    }

    public void setImagem_pedidos_produtos(String imagem_pedidos_produtos) {
        this.imagem_pedidos_produtos = imagem_pedidos_produtos;
    }

    public String getDescricao_pedidos_produtos() {
        return descricao_pedidos_produtos;
    }

    public void setDescricao_pedidos_produtos(String descricao_pedidos_produtos) {
        this.descricao_pedidos_produtos = descricao_pedidos_produtos;
    }

    public int getQuantidade_pedidos_produtos() {
        return quantidade_pedidos_produtos;
    }

    public void setQuantidade_pedidos_produtos(int quantidade_pedidos_produtos) {
        this.quantidade_pedidos_produtos = quantidade_pedidos_produtos;
    }

    public Date getData_pedido() {
        return data_pedido;
    }

    public void setData_pedido(Date data_pedido) {
        this.data_pedido = data_pedido;
    }

    public String getNome_tamanho() {
        return nome_tamanho;
    }

    public void setNome_tamanho(String nome_tamanho) {
        this.nome_tamanho = nome_tamanho;
    }

    public int getTamanho_id4() {
        return tamanho_id4;
    }

    public void setTamanho_id4(int tamanho_id4) {
        this.tamanho_id4 = tamanho_id4;
    }

    public int getProduto_id4() {
        return produto_id4;
    }

    public void setProduto_id4(int produto_id4) {
        this.produto_id4 = produto_id4;
    }

    public int getUsuario_id4() {
        return usuario_id4;
    }

    public void setUsuario_id4(int usuario_id4) {
        this.usuario_id4 = usuario_id4;
    }

    public String getNome_categoria() {
        return nome_categoria;
    }

    public void setNome_categoria(String nome_categoria) {
        this.nome_categoria = nome_categoria;
    }

    public int getCategoria_id4() {
        return categoria_id4;
    }

    public void setCategoria_id4(int categoria_id4) {
        this.categoria_id4 = categoria_id4;
    }


}