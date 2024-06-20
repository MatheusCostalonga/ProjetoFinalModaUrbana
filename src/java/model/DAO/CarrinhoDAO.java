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
        //  Luan me passou e explicou o codigo 
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
    
        public List<CarrinhoDTO> somarProdutos() {
        List<CarrinhoDTO> Carrinho = new ArrayList<>();
     try{
         Connection conexao = Conexao.conectar();
         PreparedStatement stmt = null;
         ResultSet rs = null;
         
         stmt = conexao.prepareStatement("SELECT c.id_carrinho, c.nome_produto_carrinho, c.valor_produto_carrinho, c.quantidade_carrinho, (c.valor_produto_carrinho * c.quantidade_carrinho) AS total_produtos FROM carrinho c INNER JOIN produtos p ON c.produto_id3 = p.id_produto");
       
         rs = stmt.executeQuery();
while(rs.next()){
             CarrinhoDTO objCarrinho = new CarrinhoDTO();
             System.out.println(rs.getFloat("total_produtos"));
             objCarrinho.setId_carrinho(rs.getInt("id_carrinho"));
             objCarrinho.setTotalProdutos(rs.getFloat("total_produtos"));
             Carrinho.add(objCarrinho);
         }
     }catch(SQLException e){
         e.printStackTrace();
     }   
        return Carrinho;
    }
         

         
public List<CarrinhoDTO> MostrarTudo(int idUsuario){
        List<CarrinhoDTO> carrinhos = new ArrayList<>();
    try{
        Connection conexao = Conexao.conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
     // sem categoria id 3   stmt = conexao.prepareStatement("SELECT carrinho.id_carrinho, carrinho.nome_produto_carrinho, carrinho.valor_produto_carrinho, carrinho.imagem_produto_carrinho, carrinho.descricao_produto_carrinho, carrinho.quantidade_carrinho, carrinho.total, categorias.nome_categoria, carrinho.usuario_id3, tamanho.tamanho_produto FROM carrinho INNER JOIN produtos ON carrinho.produto_id3 = produtos.id_produto INNER JOIN categorias ON produtos.categoria_id = categorias.id_categoria INNER JOIN tamanho ON carrinho.tamanho_id3 = tamanho.id_tamanho WHERE carrinho.usuario_id3 = ?");
        stmt = conexao.prepareStatement("SELECT carrinho.id_carrinho, carrinho.nome_produto_carrinho, carrinho.valor_produto_carrinho, carrinho.imagem_produto_carrinho, carrinho.descricao_produto_carrinho, carrinho.quantidade_carrinho, carrinho.total, categorias.nome_categoria, carrinho.usuario_id3, carrinho.tamanho_id3, carrinho.produto_id3, carrinho.categoria_id3, tamanho.tamanho_produto FROM carrinho INNER JOIN produtos ON carrinho.produto_id3 = produtos.id_produto INNER JOIN categorias ON carrinho.categoria_id3 = categorias.id_categoria INNER JOIN tamanho ON carrinho.tamanho_id3 = tamanho.id_tamanho WHERE carrinho.usuario_id3 = ?");
       stmt.setInt(1, idUsuario);

      
        rs = stmt.executeQuery();
        while(rs.next()){
            CarrinhoDTO carrinho = new CarrinhoDTO();
                        System.out.println(rs.getString("nome_produto_carrinho"));
            carrinho.setId_carrinho(rs.getInt("id_carrinho"));
            carrinho.setNomeCarrinho(rs.getString("nome_produto_carrinho"));
            carrinho.setValorCarrinho(rs.getFloat("valor_produto_carrinho"));
            carrinho.setImagemCarrinho(rs.getString("imagem_produto_carrinho"));
            carrinho.setDescricaoCarrinho(rs.getString("descricao_produto_carrinho"));
            carrinho.setQuantidadeCarrinho(rs.getInt("quantidade_carrinho"));
            carrinho.setTamanho(rs.getString("tamanho_produto"));
            carrinho.setNomeCategoria(rs.getString("nome_categoria"));
            carrinho.setCategoriaId3(rs.getInt("categoria_id3"));       
            carrinho.setTamanhoId3(rs.getInt("tamanho_id3"));
            carrinho.setProdutoId3(rs.getInt("produto_id3"));
            carrinhos.add(carrinho); 
        }

    } catch(SQLException e){
        e.printStackTrace();
    }
            return carrinhos;
                         
}

}
                    