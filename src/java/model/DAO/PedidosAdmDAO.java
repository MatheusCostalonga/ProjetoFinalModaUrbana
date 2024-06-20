/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import model.bean.PedidosAdmDTO;

/**
 *
 * @author Leandro
 */

public class PedidosAdmDAO {
        public List<PedidosAdmDTO> lerPedidosAdm(){
        List<PedidosAdmDTO> pedidos = new ArrayList<>();
        try{
        Connection conexao = Conexao.conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        stmt = conexao.prepareStatement("SELECT pa.id_pedido, pc.nome_produtos_pedidos, pc.valor_pedidos_produtos, pc.imagem_pedidos_produtos, pc.descricao_pedidos_produtos, pc.quantidade_pedidos_produtos, pc.data_pedido, pa.usuario_id2, t.tamanho_produto AS nome_tamanho, c.nome_categoria FROM pedidos_adm pa INNER JOIN pedidos_cliente pc ON pa.pedidos_clientes_id = pc.id_pedidosCliente INNER JOIN tamanho t ON pc.tamanho_id4 = t.id_tamanho INNER JOIN categorias c ON pc.categoria_id4 = c.id_categoria");
        rs = stmt.executeQuery();


        while(rs.next()){
            PedidosAdmDTO objPedidos = new PedidosAdmDTO();
        objPedidos.setId_pedido(rs.getInt("id_pedidos"));
        objPedidos.setUsuario_id2(rs.getInt("usuario_id2"));
        objPedidos.setEndereco_id(rs.getInt("endereco_id"));
        objPedidos.setPedidos_produtos_id(rs.getInt("pedidos_produtos_id"));
        objPedidos.setStatus_pagamento(rs.getString("status_entrega"));
        objPedidos.setMetodo_Pagamento(rs.getString("metodo_pagamento"));
        pedidos.add(objPedidos);
        }  
        rs.close();
         stmt.close();
         conexao.close();
    }catch(SQLException e){
        e.printStackTrace();
    } 
        return pedidos;
    }
        
            public void cadastrarInformPedidos(int idUsuario, int idEndereco){
        try{
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            stmt = conexao.prepareStatement("SELECT id_pedidosCliente FROM pedidos_cliente");
            
           rs = stmt.executeQuery();
            System.out.println("idUsuario: "+idUsuario);
            System.out.println("idEndereco"+ idEndereco);
            while(rs.next()){
                int idPedidoCliente = rs.getInt("id_pedidosCliente");
                System.out.println("idPedidoCliente"+idPedidoCliente);
            stmt = conexao.prepareStatement("INSERT INTO pedidos_adm (usuario_id2, endereco_id, pedidos_clientes_id) VALUES (?,?,?)");
            stmt.setInt(1, idUsuario);
            stmt.setInt(2, idEndereco);
            stmt.setInt(3, idPedidoCliente);
            stmt.executeUpdate();
            }
            stmt.close();
            conexao.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
            public int aumentarQuantidadeProduto(int produtoId, int quantidadeCarrinho){
    try{    
    Connection conexao = Conexao.conectar();
    PreparedStatement stmt = null;
    ResultSet rs = null;

    stmt = conexao.prepareStatement("SELECT quantidade FROM produtos WHERE id_produto = ?");
    stmt.setInt(1, produtoId);
    rs = stmt.executeQuery();
    
    if(rs.next()){
        int quantidadeAtual = rs.getInt("quantidade");
        
            int novaQuantidade = quantidadeAtual + quantidadeCarrinho;

        stmt = conexao.prepareStatement("UPDATE produtos SET quantidade = ? WHERE id_produto = ?");


        stmt.setInt(1, novaQuantidade);
        stmt.setInt(2, produtoId);
        stmt.executeUpdate();
       
        rs.close();
        stmt.close();
        conexao.close();      
        quantidadeAtual = 0;
        quantidadeCarrinho = 0;
        novaQuantidade = 0;
    }
    
    } catch (SQLException e){
        e.printStackTrace();
    }
return 0;
} 
}
