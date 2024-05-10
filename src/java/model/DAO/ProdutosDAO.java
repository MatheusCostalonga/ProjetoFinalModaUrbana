/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import conexao.Conexao;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bean.ProdutoDTO;

/**
 *
 * @author Senai
 */
public class ProdutosDAO {
        public List<ProdutoDTO> leitura() {
        List<ProdutoDTO> produtos = new ArrayList<>();
        String sql = "SELECT * FROM produtos";
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                ProdutoDTO objProduto = new ProdutoDTO();
                objProduto.setIdProduto(rs.getInt("id_produto"));
                objProduto.setNome(rs.getString("nome"));
                objProduto.setValor(rs.getFloat("valor"));
                objProduto.setDescricao(rs.getString("descricao"));
                objProduto.setCategoriaId(rs.getInt("categoria_id"));
                objProduto.setTamanho(rs.getString("tamanho"));
                objProduto.setImgBlob(rs.getBlob("imagem"));
                Blob blob = rs.getBlob("imagem");
                int blobLength = (int) blob.length();
                byte[] imagemBytes = blob.getBytes(1, blobLength);
                blob.free();
                objProduto.setImagem(imagemBytes);
                produtos.add(objProduto);
            }
            rs.close();
            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            System.out.println("Leitura de produtos: " + e);
        }
        return produtos;
    }
            public void cadastrarProduto(ProdutoDTO p) {
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            
            stmt = conexao.prepareStatement("INSERT INTO produtos (categoria_id, nome, valor, imagem, descricao, tamanho) VALUES (?, ?, ?, ?, ?, ?)");
            stmt.setInt(1, p.getCategoriaId());
            stmt.setString(2, p.getNome());
            stmt.setFloat(3, p.getValor());
            stmt.setBytes(4, p.getImagem());
            stmt.setString(5, p.getDescricao());
            stmt.setString(6, p.getTamanho());
            
            stmt.executeUpdate();
            stmt.close();
            conexao.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
        
            public List<ProdutoDTO> listarProdutos() {
        List<ProdutoDTO> produtos = new ArrayList<>();
        Connection conexao = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conexao = Conexao.conectar();
            stmt = conexao.prepareStatement("SELECT * FROM produtos LIMIT 10");
            rs = stmt.executeQuery();

            while (rs.next()) {
                ProdutoDTO produto = new ProdutoDTO();
                produto.setIdProduto(rs.getInt("id_produto"));
                produto.setNome(rs.getString("nome"));
                produto.setCategoriaId(rs.getInt("categoria_id"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setTamanho(rs.getString("tamanho"));
                produto.setValor(rs.getFloat("valor"));
                produto.setImagem(rs.getBytes("imagem"));
                produtos.add(produto);
            }
            
            rs.close();
            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return produtos;
    }
        
        public List<ProdutoDTO> buscaProdutos(String busca){
            List<ProdutoDTO> resultadoBusca = new ArrayList();
            try{           
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;  
            
            //SELECT * FROM produtos WHERE nome LIKE %?% OR descricao LIKE ?
            stmt = conexao.prepareStatement("SELECT * FROM produtos WHERE nome LIKE ?");
            stmt.setString(1, busca);
          //  stmt.setString(2,  busca);
            
            rs = stmt.executeQuery();
             while (rs.next()) {
             ProdutoDTO  prod = new ProdutoDTO();
             prod.setIdProduto(rs.getInt("id_produto"));
             prod.setNome(rs.getString("nome"));
             prod.setCategoriaId(rs.getInt("categoria_id"));
             prod.setDescricao(rs.getString("descricao"));
             prod.setTamanho(rs.getString("tamanho"));
             prod.setImagem(rs.getBytes("imagem"));
             prod.setValor(rs.getFloat("valor"));
             resultadoBusca.add(prod);           
             }
            
            } catch(SQLException e){
                e.printStackTrace();;
            }
            
            return resultadoBusca;
        }
        
                public List<ProdutoDTO> buscarCategoria(int categoria){
                List<ProdutoDTO> resultadoBusca = new ArrayList();
            try{           
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;  

            stmt = conexao.prepareStatement("SELECT * FROM produtos WHERE categoria_id = ?");
            stmt.setInt(1, categoria);
            
            rs = stmt.executeQuery();
             while (rs.next()) {
             ProdutoDTO  prod = new ProdutoDTO();
             prod.setIdProduto(rs.getInt("id_produto"));
             prod.setCategoriaId(rs.getInt("categoria_id"));
             prod.setImagem(rs.getBytes("imagem"));
             prod.setDescricao(rs.getString("descricao"));
             prod.setTamanho(rs.getString("tamanho"));
             prod.setValor(rs.getFloat("valor"));
             resultadoBusca.add(prod);           
             }
            
            } catch(SQLException e){
                e.printStackTrace();;
            }
            
            return resultadoBusca;
                }
}
