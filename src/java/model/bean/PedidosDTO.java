/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.sql.Date;
import java.util.List;

/**
 *
 * @author Senai
 */
public class PedidosDTO {
    
    private int id_pedido;
    private int usuario_id2;
    private int pedidos_produtos_id;
    private int endereco_id;
    private String status_pagamento;
    private String metodo_Pagamento;
    private Date data_pedido;
    private Date data_prevista;
    
    public PedidosDTO() {
    }

    public PedidosDTO(int id_pedido, int usuario_id2, int pedidos_produtos_id, int endereco_id, String status_pagamento, String metodo_Pagamento, Date data_pedido, Date data_prevista) {
        this.id_pedido = id_pedido;
        this.usuario_id2 = usuario_id2;
        this.pedidos_produtos_id = pedidos_produtos_id;
        this.endereco_id = endereco_id;
        this.status_pagamento = status_pagamento;
        this.metodo_Pagamento = metodo_Pagamento;
        this.data_pedido = data_pedido;
        this.data_prevista = data_prevista;
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

    public Date getData_pedido() {
        return data_pedido;
    }

    public void setData_pedido(Date data_pedido) {
        this.data_pedido = data_pedido;
    }

    public Date getData_prevista() {
        return data_prevista;
    }

    public void setData_prevista(Date data_prevista) {
        this.data_prevista = data_prevista;
    }
    
    
}
