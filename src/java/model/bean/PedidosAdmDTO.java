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
public class PedidosAdmDTO {
    
    private int id_pedido;
    private int usuario_id2;
    private int pedidos_produtos_id;
    private int endereco_id;
    private String status_pagamento;
    private String metodo_Pagamento;
    private String nomeProdutos;
    private String nomeCategoria;
    private String nomeTamanho;
    private String descricao;
    private float valorProduto;
    private int quantidade;
    private String imagem;
    private String ruaEndereco;
    private int numeroEndereco;
    private String cep;
    private String nomeUsuario;
    private String telefone;
    private String complemento;
    
    public PedidosAdmDTO() {
    }

    public PedidosAdmDTO(int id_pedido, int usuario_id2, int pedidos_produtos_id, int endereco_id, String status_pagamento, String metodo_Pagamento, String nomeProdutos, String nomeCategoria, String nomeTamanho, String descricao, float valorProduto, int quantidade, String imagem, String ruaEndereco, int numeroEndereco, String cep, String nomeUsuario, String telefone, String complemento) {
        this.id_pedido = id_pedido;
        this.usuario_id2 = usuario_id2;
        this.pedidos_produtos_id = pedidos_produtos_id;
        this.endereco_id = endereco_id;
        this.status_pagamento = status_pagamento;
        this.metodo_Pagamento = metodo_Pagamento;
        this.nomeProdutos = nomeProdutos;
        this.nomeCategoria = nomeCategoria;
        this.nomeTamanho = nomeTamanho;
        this.descricao = descricao;
        this.valorProduto = valorProduto;
        this.quantidade = quantidade;
        this.imagem = imagem;
        this.ruaEndereco = ruaEndereco;
        this.numeroEndereco = numeroEndereco;
        this.cep = cep;
        this.nomeUsuario = nomeUsuario;
        this.telefone = telefone;
        this.complemento = complemento;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public int getUsuario_id2() {
        return usuario_id2;
    }

    public void setUsuario_id2(int usuario_id2) {
        this.usuario_id2 = usuario_id2;
    }

    public int getPedidos_produtos_id() {
        return pedidos_produtos_id;
    }

    public void setPedidos_produtos_id(int pedidos_produtos_id) {
        this.pedidos_produtos_id = pedidos_produtos_id;
    }

    public int getEndereco_id() {
        return endereco_id;
    }

    public void setEndereco_id(int endereco_id) {
        this.endereco_id = endereco_id;
    }

    public String getStatus_pagamento() {
        return status_pagamento;
    }

    public void setStatus_pagamento(String status_pagamento) {
        this.status_pagamento = status_pagamento;
    }

    public String getMetodo_Pagamento() {
        return metodo_Pagamento;
    }

    public void setMetodo_Pagamento(String metodo_Pagamento) {
        this.metodo_Pagamento = metodo_Pagamento;
    }

    public String getNomeProdutos() {
        return nomeProdutos;
    }

    public void setNomeProdutos(String nomeProdutos) {
        this.nomeProdutos = nomeProdutos;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public String getNomeTamanho() {
        return nomeTamanho;
    }

    public void setNomeTamanho(String nomeTamanho) {
        this.nomeTamanho = nomeTamanho;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(float valorProduto) {
        this.valorProduto = valorProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getRuaEndereco() {
        return ruaEndereco;
    }

    public void setRuaEndereco(String ruaEndereco) {
        this.ruaEndereco = ruaEndereco;
    }

    public int getNumeroEndereco() {
        return numeroEndereco;
    }

    public void setNumeroEndereco(int numeroEndereco) {
        this.numeroEndereco = numeroEndereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    
}
