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
import model.bean.PedidosProdutosDTO;


/**
 *
 * @author Leandro
 */
public class PedidosProdutosDAO {
        public List<PedidosProdutosDTO> leiaPedidosProdutos() {
        List<PedidosProdutosDTO> PedidosProdutos = new ArrayList<>();
     try{
         Connection conexao = Conexao.conectar();
         PreparedStatement stmt = null;
         ResultSet rs = null;
         
         stmt = conexao.prepareStatement("SELECT * FROM pedidos_produtos");
         rs = stmt.executeQuery();
         while(rs.next()){
             PedidosProdutosDTO objPedidtosProdutos = new PedidosProdutosDTO();
    //        objPedidtosProdutos.setPedido_id(rs.getInt("usuario_id3"));
    //         objPedidtosProdutos.setProduto_id(0);
      //       objCarrinho.setUsuarioId3(rs.getInt("usuario_id3"));
             PedidosProdutos.add(objPedidtosProdutos);
         }
     }catch(SQLException e){
         e.printStackTrace();
     }   
        return PedidosProdutos;
    }
      public void cadastrarPedidosProdutos(PedidosProdutosDTO p) {
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            
            stmt = conexao.prepareStatement("INSERT INTO pedidos_produtos (nome_produtos_pedidos, valor_pedidos_produtos, imagem_pedidos_produtos, descricao_pedidos_produtos, quantidade_pedidos_produtos, tamanho_id4, produto_id4, usuario_id4, categoria_id4) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, p.getNome_produtos_pedidos());
            stmt.setFloat(2, p.getValor_pedidos_produtos());
            stmt.setString(3, p.getImagem_pedidos_produtos());
            stmt.setString(4, p.getDescricao_pedidos_produtos());
            stmt.setInt(5, p.getQuantidade_pedidos_produtos());
            stmt.setInt(6, p.getTamanho_id4());
            stmt.setInt(7, p.getProduto_id4());
            stmt.setInt(8, p.getUsuario_id4());
            stmt.setInt(9, p.getCategoria_id4());
            System.out.println("nome produtos pedidos dao: "+p.getNome_produtos_pedidos());
            System.out.println("categoria produtos pedidos dao: "+p.getCategoria_id4());
            
            stmt.executeUpdate();
            stmt.close();
            conexao.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
