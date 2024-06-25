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
import model.bean.PedidosAdmDTO;
import model.bean.PedidosClienteDTO;

/**
 *
 * @author Leandro
 */
public class PedidosClienteDAO {
    public List<PedidosClienteDTO> LerPedidosCliente(int idUsuario){
      List<PedidosClienteDTO> pedidos = new ArrayList<>();
      
      try{
         Connection conexao = Conexao.conectar();
         PreparedStatement stmt = null;
         ResultSet rs = null;
         
        stmt = conexao.prepareStatement("SELECT pc.id_pedidosCliente, pc.nome_produtos_pedidos, pc.valor_pedidos_produtos, pc.imagem_pedidos_produtos, pc.descricao_pedidos_produtos, pc.quantidade_pedidos_produtos, pc.data_pedido, t.tamanho_produto AS nome_tamanho, c.nome_categoria FROM pedidos_cliente pc INNER JOIN tamanho t ON pc.tamanho_id4 = t.id_tamanho INNER JOIN categorias c ON pc.categoria_id4 = c.id_categoria WHERE pc.usuario_id4 = ?;");
        stmt.setInt(1, idUsuario);
        rs = stmt.executeQuery();
         
   
         while(rs.next()){
             PedidosClienteDTO objPedido = new PedidosClienteDTO();
             objPedido.setId_pedidosClientes(rs.getInt("id_pedidosCliente"));
             objPedido.setNome_produtos_pedidos(rs.getString("nome_produtos_pedidos"));
             objPedido.setValor_pedidos_produtos(rs.getFloat("valor_pedidos_produtos"));
             objPedido.setImagem_pedidos_produtos(rs.getString("imagem_pedidos_produtos"));
             objPedido.setDescricao_pedidos_produtos(rs.getString("descricao_pedidos_produtos"));
             objPedido.setQuantidade_pedidos_produtos(rs.getInt("quantidade_pedidos_produtos"));
             objPedido.setNome_categoria(rs.getString("nome_categoria"));
             objPedido.setNome_tamanho(rs.getString("nome_tamanho"));
             pedidos.add(objPedido);
         }
         

      }catch(SQLException e){
      e.printStackTrace();
      }
      return pedidos;
    }
    public void cadastrarPedidosProdutos(PedidosClienteDTO p){
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            
            stmt = conexao.prepareStatement("INSERT INTO pedidos_cliente (nome_produtos_pedidos, valor_pedidos_produtos, imagem_pedidos_produtos, descricao_pedidos_produtos, quantidade_pedidos_produtos, tamanho_id4, produto_id4, usuario_id4, categoria_id4) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, p.getNome_produtos_pedidos());
            stmt.setFloat(2, p.getValor_pedidos_produtos());
            stmt.setString(3, p.getImagem_pedidos_produtos());
            stmt.setString(4, p.getDescricao_pedidos_produtos());
            stmt.setInt(5, p.getQuantidade_pedidos_produtos());
            stmt.setInt(6, p.getTamanho_id4());
            stmt.setInt(7, p.getProduto_id4());
            stmt.setInt(8, p.getUsuario_id4());
            stmt.setInt(9, p.getCategoria_id4());
            stmt.executeUpdate();
            
            
            stmt.close();
            conexao.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
     public List<PedidosClienteDTO> leiaTotalPedidos(int idUsuario) {
        List<PedidosClienteDTO> Carrinho = new ArrayList<>();
     try{
         Connection conexao = Conexao.conectar();
         PreparedStatement stmt = null;
         ResultSet rs = null;
         
         stmt = conexao.prepareStatement("SELECT SUM(p.valor_pedidos_produtos * p.quantidade_pedidos_produtos) AS total FROM pedidos_cliente p WHERE p.usuario_id4 = ?");
         stmt.setInt(1, idUsuario);
         rs = stmt.executeQuery();
         if(rs.next()){
             PedidosClienteDTO objPedidoCliente = new PedidosClienteDTO();
             objPedidoCliente.setTotalProdutosPedidos(rs.getFloat("total"));
             Carrinho.add(objPedidoCliente);
         }
     }catch(SQLException e){
         e.printStackTrace();
     }   
        return Carrinho;
    }
}
