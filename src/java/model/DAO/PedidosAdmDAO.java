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
        stmt = conexao.prepareStatement("SELECT pa.id_pedido, pc.nome_produtos_pedidos AS nomeProdutos, pc.valor_pedidos_produtos AS valorProduto, pc.imagem_pedidos_produtos AS imagem, pc.descricao_pedidos_produtos AS descricao, pc.quantidade_pedidos_produtos AS quantidade, pc.data_pedido, pa.usuario_id2, u.nome, u.telefone, e.rua, e.cep, e.numero, e.complemento, t.tamanho_produto AS nome_tamanho, c.nome_categoria FROM pedidos_adm pa INNER JOIN pedidos_cliente pc ON pa.pedidos_clientes_id = pc.id_pedidosCliente INNER JOIN tamanho t ON pc.tamanho_id4 = t.id_tamanho INNER JOIN categorias c ON pc.categoria_id4 = c.id_categoria INNER JOIN usuarios u ON pa.usuario_id2 = u.id_usuario INNER JOIN enderecos e ON pa.endereco_id = e.id_endereco");
        rs = stmt.executeQuery();


        while(rs.next()){
            PedidosAdmDTO objPedidos = new PedidosAdmDTO();
        objPedidos.setId_pedido(rs.getInt("id_pedido"));
        objPedidos.setNomeProdutos(rs.getString("nomeProdutos"));
        objPedidos.setValorProduto(rs.getFloat("valorProduto"));
        objPedidos.setImagem(rs.getString("imagem"));
        objPedidos.setDescricao(rs.getString("descricao"));
        objPedidos.setQuantidade(rs.getInt("quantidade"));
        objPedidos.setUsuario_id2(rs.getInt("usuario_id2"));
        objPedidos.setNomeUsuario(rs.getString("nome"));
        objPedidos.setTelefone(rs.getString("telefone"));
        objPedidos.setRuaEndereco(rs.getString("rua"));
        objPedidos.setCep(rs.getString("cep"));
        objPedidos.setNumeroEndereco(rs.getInt("numero"));
        objPedidos.setComplemento(rs.getString("complemento"));
        objPedidos.setNomeTamanho(rs.getString("nome_tamanho"));
        objPedidos.setNomeCategoria(rs.getString("nome_categoria"));
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
            while(rs.next()){
                int idPedidoCliente = rs.getInt("id_pedidosCliente");
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
  
}
