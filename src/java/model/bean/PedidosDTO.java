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
    private int usuario_id;
    private String status_pagamento;
    private String metodo_Pagamento;
    private float valorTotal;
    private Date data_hora;

    public PedidosDTO() {
    }

   public PedidosDTO(int id_pedido, int usuario_id2, int usuario_id, String status_pagamento, String metodo_Pagamento, float valorTotal, Date data_hora) {
        this.id_pedido = id_pedido;
        this.usuario_id2 = usuario_id2;
        this.usuario_id = usuario_id;
        this.status_pagamento = status_pagamento;
        this.metodo_Pagamento = metodo_Pagamento;
        this.valorTotal = valorTotal;
        this.data_hora = data_hora;
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

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
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

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Date getData_hora() {
        return data_hora;
    }

    public void setData_hora(Date data_hora) {
        this.data_hora = data_hora;
    }

   
    
}
