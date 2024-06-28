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
import model.bean.CarrinhoDTO;

/**
 *
 * @author Senai
 */
public class CarrinhoDAO {
    public List<CarrinhoDTO> lerCarrinho() {
        List<CarrinhoDTO> Carrinho = new ArrayList<>();
     try{
         Connection conexao = Conexao.conectar();
         PreparedStatement stmt = null;
         ResultSet rs = null;
         
         stmt = conexao.prepareStatement("SELECT * FROM carrinho");
         rs = stmt.executeQuery();
         while(rs.next()){
             CarrinhoDTO objCarrinho = new CarrinhoDTO();
             objCarrinho.setId_carrinho(rs.getInt("id_carrinho"));
             objCarrinho.setNomeCarrinho(rs.getString("nome_produto_carrinho"));
             objCarrinho.setValorCarrinho(rs.getFloat("valor_produto_carrinho"));
             objCarrinho.setImagemCarrinho(rs.getString("imagem_produto_carrinho"));
             objCarrinho.setDescricaoCarrinho(rs.getString("descricao_produto_carrinho"));
             objCarrinho.setQuantidadeCarrinho(rs.getInt("quantidade_carrinho"));
             objCarrinho.setProdutoId3(rs.getInt("produto_id3"));
             objCarrinho.setTotal(rs.getFloat("total"));
             objCarrinho.setUsuarioId3(rs.getInt("usuario_id3"));
             Carrinho.add(objCarrinho);
         }
     }catch(SQLException e){
         e.printStackTrace();
     }   
        return Carrinho;
    }
    public void cadastrarProdutoCarrinho(CarrinhoDTO c){
        try{
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            stmt = conexao.prepareStatement("INSERT INTO carrinho (nome_produto_carrinho, valor_produto_carrinho, imagem_produto_carrinho, descricao_produto_carrinho, quantidade_carrinho,tamanho_id3, produto_id3, usuario_id3, categoria_id3) VALUES (?,?,?,?,?,?,?,?,?)");

           //                      stmt = conexao.prepareStatement("INSERT INTO carrinho (nome_produto_carrinho, valor_produto_carrinho, imagem_produto_carrinho, descricao_produto_carrinho, quantidade_carrinho,tamanho_id3, produto_id3, usuario_id3) VALUES (?,?,?,?,?,?,?,?)");
            stmt.setString(1, c.getNomeCarrinho());
            stmt.setFloat(2, c.getValorCarrinho());
            stmt.setString(3, c.getImagemCarrinho());
            stmt.setString(4, c.getDescricaoCarrinho());
            stmt.setInt(5, c.getQuantidadeCarrinho());
            stmt.setInt(6, c.getTamanhoId3());
            stmt.setInt(7, c.getProdutoId3());
            stmt.setInt(8, c.getUsuarioId3());
            stmt.setInt(9, c.getCategoriaId3());
            stmt.executeUpdate();
            
            stmt.close();
            conexao.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
 public void deletarCarrinho(){
        try{
        Connection conexao = Conexao.conectar();
        PreparedStatement stmt = null;

            stmt = conexao.prepareStatement("DELETE FROM carrinho WHERE id_carrinho > 0");

            stmt.executeUpdate();
            stmt.close();
            conexao.close();
        }catch(Exception e){
        e.printStackTrace();
        }
    }
    
        public void deletarProdutoCarrinho(int idCarrinho){
        try{
        Connection conexao = Conexao.conectar();
        PreparedStatement stmt = null;
            stmt = conexao.prepareStatement("DELETE FROM carrinho WHERE id_carrinho = ?");
            stmt.setInt(1, idCarrinho);
            
            stmt.executeUpdate();
            stmt.close();
            conexao.close();
        }catch(Exception e){
        e.printStackTrace();
        }
    }
         public List<CarrinhoDTO> leiaTotalCarrinho(int idUsuario) {
        List<CarrinhoDTO> Carrinho = new ArrayList<>();
     try{
         Connection conexao = Conexao.conectar();
         PreparedStatement stmt = null;
         ResultSet rs = null;
         
         stmt = conexao.prepareStatement("SELECT SUM(c.valor_produto_carrinho * c.quantidade_carrinho) AS total FROM carrinho c WHERE c.usuario_id3 = ?");
         stmt.setInt(1, idUsuario);
         rs = stmt.executeQuery();
         if(rs.next()){
             CarrinhoDTO objCarrinho = new CarrinhoDTO();
             objCarrinho.setTotal(rs.getFloat("total"));
             Carrinho.add(objCarrinho);
         }
     }catch(SQLException e){
         e.printStackTrace();
     }   
        return Carrinho;
    }
    
   /*     public List<CarrinhoDTO> somarProdutos(int idUsuario) {
        List<CarrinhoDTO> Carrinho = new ArrayList<>();
     try{
         Connection conexao = Conexao.conectar();
         PreparedStatement stmt = null;
         ResultSet rs = null;
         
         stmt = conexao.prepareStatement("SELECT c.id_carrinho, c.nome_produto_carrinho, c.valor_produto_carrinho, c.quantidade_carrinho, (c.valor_produto_carrinho * c.quantidade_carrinho) AS total_produtos FROM carrinho c INNER JOIN produtos p ON c.produto_id3 = p.id_produto");
         stmt.setInt(1, idUsuario);       
         rs = stmt.executeQuery();
        while(rs.next()){
             CarrinhoDTO objCarrinho = new CarrinhoDTO();
             objCarrinho.setId_carrinho(rs.getInt("id_carrinho"));
             objCarrinho.setTotalProdutos(rs.getFloat("total_produtos"));
             objCarrinho.setNomeCarrinho(rs.getString("nome_produto_carrinho"));
             Carrinho.add(objCarrinho);
         }
     }catch(SQLException e){
         e.printStackTrace();
     }   
        return Carrinho;
    }*/
         

         
public List<CarrinhoDTO> MostrarTudo(int idUsuario){
        List<CarrinhoDTO> carrinhos = new ArrayList<>();
    try{
        Connection conexao = Conexao.conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        stmt = conexao.prepareStatement("SELECT c.id_carrinho, c.nome_produto_carrinho, c.imagem_produto_carrinho, c.descricao_produto_carrinho, c.produto_id3, c.usuario_id3, c.tamanho_id3, c.total,c.valor_produto_carrinho, c.quantidade_carrinho, (c.valor_produto_carrinho * c.quantidade_carrinho) AS total_produtos FROM carrinho c INNER JOIN produtos p ON c.produto_id3 = p.id_produto WHERE c.usuario_id3 = ?;");
             stmt.setInt(1, idUsuario);
        rs = stmt.executeQuery();
        while(rs.next()){
            CarrinhoDTO carrinho = new CarrinhoDTO();
            carrinho.setId_carrinho(rs.getInt("id_carrinho"));
            carrinho.setNomeCarrinho(rs.getString("nome_produto_carrinho"));
            carrinho.setValorCarrinho(rs.getFloat("valor_produto_carrinho"));
            carrinho.setImagemCarrinho(rs.getString("imagem_produto_carrinho"));
            carrinho.setDescricaoCarrinho(rs.getString("descricao_produto_carrinho"));
            carrinho.setQuantidadeCarrinho(rs.getInt("quantidade_carrinho"));
            carrinho.setTotalProdutos(rs.getFloat("total_produtos"));
            carrinhos.add(carrinho); 
        }

    } catch(SQLException e){
        e.printStackTrace();
    }
            return carrinhos;
                         
}

public int diminuirQuantidadeProduto(int quantidadeDesejada, int produtoId){
    
    try{    
    Connection conexao = Conexao.conectar();
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
    stmt = conexao.prepareStatement("SELECT quantidade FROM produtos WHERE id_produto = ?");
    stmt.setInt(1, produtoId);
    rs = stmt.executeQuery();
    
    if(rs.next()){
        int quantidadeAtual = rs.getInt("quantidade");
        if(quantidadeAtual >= quantidadeDesejada){
            
            int novaQuantidade = quantidadeAtual - quantidadeDesejada;
        stmt = conexao.prepareStatement("UPDATE produtos SET quantidade = ? WHERE id_produto = ?");
        stmt.setInt(1, novaQuantidade);
        stmt.setInt(2, produtoId);
        stmt.executeUpdate();
        
          rs.close();
        stmt.close();
        conexao.close();    
                quantidadeAtual = 0;
        quantidadeDesejada = 0;
        novaQuantidade = 0;
        }
        
    }
    
    } catch (SQLException e){
        e.printStackTrace();
    }
return 0;
} 
        public int verificarCarrinho(int idUsuario){
            int idCarrinho = 0;
          try{
        Connection conexao = Conexao.conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;    
        stmt = conexao.prepareStatement("SELECT id_carrinho FROM carrinho WHERE usuario_id3 = ?");
        stmt.setInt(1, idUsuario);
        rs = stmt.executeQuery();
            while(rs.next()){
          idCarrinho = rs.getInt("id_carrinho");
            }
            stmt.close();
            conexao.close();
        }catch(Exception e){
        e.printStackTrace();
        }
        return idCarrinho;
    } 
}
                    