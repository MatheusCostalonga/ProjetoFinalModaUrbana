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
                objProduto.setNome_produto(rs.getString("nome_produto"));
                objProduto.setValor(rs.getFloat("valor"));
                objProduto.setDescricao(rs.getString("descricao"));
                objProduto.setCategoriaId(rs.getInt("categoria_id"));
                objProduto.setTamanhoId(rs.getInt("tamanho_id"));
                objProduto.setImagem(rs.getString("imagem"));
                produtos.add(objProduto);
            }
            rs.close();
            stmt.close();
            conexao.close();
        } catch (SQLException e) {
        }
        return produtos;
    }
            public void cadastrarProduto(ProdutoDTO p) {
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            
            stmt = conexao.prepareStatement("INSERT INTO produtos (categoria_id, nome_produto, valor, imagem, descricao, quantidade, tamanho_id) VALUES (?, ?, ?, ?, ?, ?, ?)");
            stmt.setInt(1, p.getCategoriaId());
            stmt.setString(2, p.getNome_produto());
            stmt.setFloat(3, p.getValor());
            stmt.setString(4, p.getImagem());
            stmt.setString(5, p.getDescricao());
            stmt.setInt(6, p.getQuantidade());
            stmt.setInt(7, p.getTamanhoId());
            
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
            stmt = conexao.prepareStatement("SELECT * FROM produtos LIMIT 100");
            rs = stmt.executeQuery();

            while (rs.next()) {
                ProdutoDTO produto = new ProdutoDTO();
                produto.setIdProduto(rs.getInt("id_produto"));
                produto.setNome_produto(rs.getString("nome_produto"));
                produto.setCategoriaId(rs.getInt("categoria_id"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setTamanhoId(rs.getInt("tamanho_id"));
                produto.setValor(rs.getFloat("valor"));
                produto.setImagem(rs.getString("imagem"));
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
            
            //SELECT * FROM produtos WHERE nome_produto LIKE %?% OR descricao LIKE ?
            stmt = conexao.prepareStatement("SELECT * FROM produtos WHERE nome_produto LIKE ? OR categoria_id LIKE ?");
            stmt.setString(1, busca);
            stmt.setString(2, busca);
            
            rs = stmt.executeQuery();
             while (rs.next()) {
             ProdutoDTO  prod = new ProdutoDTO();
             prod.setIdProduto(rs.getInt("id_produto"));
             prod.setNome_produto(rs.getString("nome_produto"));
             prod.setCategoriaId(rs.getInt("categoria_id"));
             prod.setDescricao(rs.getString("descricao"));
             prod.setTamanhoId(rs.getInt("tamanho_id"));
             prod.setImagem(rs.getString("imagem"));
             prod.setValor(rs.getFloat("valor"));
             resultadoBusca.add(prod);           
             }
            
            } catch(SQLException e){
                e.printStackTrace();;
            }
            
            return resultadoBusca;
        }
        public List<ProdutoDTO> buscarProduto(int id_produto){
            List<ProdutoDTO> produto = new ArrayList<>();
            try{
                Connection conexao = Conexao.conectar();
                PreparedStatement stmt = null;
                ResultSet rs = null;
                
                stmt = conexao.prepareStatement("SELECT * FROM produtos WHERE id_produto = ?");
                stmt.setInt(1, id_produto);
                rs = stmt.executeQuery();
                while (rs.next()){
                    ProdutoDTO produtos = new ProdutoDTO();
                    produtos.setIdProduto(rs.getInt("id_produto"));
                    produtos.setCategoriaId(rs.getInt("categoria_id"));
                    produtos.setNome_produto(rs.getString("nome_produto"));
                    produtos.setImagem(rs.getString("imagem"));
                    produtos.setDescricao(rs.getString("descricao"));               
                    produtos.setValor(rs.getFloat("valor"));
                    produto.add(produtos);
                }
                rs.close();
                stmt.close();
                conexao.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
            return produto;
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
             prod.setImagem(rs.getString("imagem"));
             prod.setDescricao(rs.getString("descricao"));
             prod.setTamanhoId(rs.getInt("tamanho_id"));
             prod.setValor(rs.getFloat("valor"));
             resultadoBusca.add(prod);           
             }
            
            } catch(SQLException e){
                e.printStackTrace();
            }
            
            return resultadoBusca;
                }

        public List<ProdutoDTO> ListarCamiseta(){
        List<ProdutoDTO> produtos = new ArrayList<>();
    try{
        Connection conexao = Conexao.conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        stmt = conexao.prepareStatement("SELECT produtos.id_produto, produtos.nome_produto, produtos.imagem, produtos.descricao, produtos.tamanho_id, produtos.quantidade, produtos.valor, categorias.nome_categoria FROM produtos INNER JOIN categorias ON produtos.categoria_id = categorias.id_categoria WHERE produtos.categoria_id = '1'");

      /*  stmt = conexao.prepareStatement("SELECT * FROM produtos");*/
     
        rs = stmt.executeQuery();
        while(rs.next()){
            ProdutoDTO produto = new ProdutoDTO();
            produto.setIdProduto(rs.getInt("id_produto"));
            produto.setNome_produto(rs.getString("nome_produto"));
            produto.setImagem(rs.getString("imagem"));
            produto.setDescricao(rs.getString("descricao"));
            produto.setTamanhoId(rs.getInt("tamanho_id"));
            produto.setQuantidade(rs.getInt("quantidade"));
            produto.setNome_categoria(rs.getString("nome_categoria"));
            produto.setValor(rs.getFloat("valor"));
            produtos.add(produto);
            
            
        }
        
    } catch(SQLException e){
        e.printStackTrace();
    }
            return produtos;          
}  
             public List<ProdutoDTO> ListarCamisa(){
        List<ProdutoDTO> produtos = new ArrayList<>();
    try{
        Connection conexao = Conexao.conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        stmt = conexao.prepareStatement("SELECT produtos.id_produto, produtos.nome_produto, produtos.imagem, produtos.descricao, produtos.tamanho_id, produtos.quantidade, produtos.valor, categorias.nome_categoria FROM produtos INNER JOIN categorias ON produtos.categoria_id = categorias.id_categoria WHERE produtos.categoria_id = '2'");

      /*  stmt = conexao.prepareStatement("SELECT * FROM produtos");*/
     
        rs = stmt.executeQuery();
        while(rs.next()){
            ProdutoDTO produto = new ProdutoDTO();
            produto.setIdProduto(rs.getInt("id_produto"));
            produto.setNome_produto(rs.getString("nome_produto"));
            produto.setImagem(rs.getString("imagem"));
            produto.setDescricao(rs.getString("descricao"));
            produto.setTamanhoId(rs.getInt("tamanho_id"));
            produto.setQuantidade(rs.getInt("quantidade"));
            produto.setNome_categoria(rs.getString("nome_categoria"));
            produto.setValor(rs.getFloat("valor"));
            produtos.add(produto);
            
            
        }
        
    } catch(SQLException e){
        e.printStackTrace();
    }
            return produtos;
                         
}
                     public List<ProdutoDTO> ListarCalça(){
        List<ProdutoDTO> produtos = new ArrayList<>();
    try{
        Connection conexao = Conexao.conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        stmt = conexao.prepareStatement("SELECT produtos.id_produto, produtos.nome_produto, produtos.imagem, produtos.descricao, produtos.tamanho_id, produtos.quantidade, produtos.valor, categorias.nome_categoria FROM produtos INNER JOIN categorias ON produtos.categoria_id = categorias.id_categoria WHERE produtos.categoria_id = '3'");

      /*  stmt = conexao.prepareStatement("SELECT * FROM produtos");*/
     
        rs = stmt.executeQuery();
        while(rs.next()){
            ProdutoDTO produto = new ProdutoDTO();
            produto.setIdProduto(rs.getInt("id_produto"));
            produto.setNome_produto(rs.getString("nome_produto"));
            produto.setImagem(rs.getString("imagem"));
            produto.setDescricao(rs.getString("descricao"));
            produto.setTamanhoId(rs.getInt("tamanho_id"));
            produto.setQuantidade(rs.getInt("quantidade"));
            produto.setNome_categoria(rs.getString("nome_categoria"));
            produto.setValor(rs.getFloat("valor"));
            produtos.add(produto);
            
            
        }
        
    } catch(SQLException e){
        e.printStackTrace();
    }
            return produtos;
                         
}
             public List<ProdutoDTO> ListarJaqueta(){
        List<ProdutoDTO> produtos = new ArrayList<>();
    try{
        Connection conexao = Conexao.conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        stmt = conexao.prepareStatement("SELECT produtos.id_produto, produtos.nome_produto, produtos.imagem, produtos.descricao, produtos.tamanho_id, produtos.quantidade, produtos.valor, categorias.nome_categoria FROM produtos INNER JOIN categorias ON produtos.categoria_id = categorias.id_categoria WHERE produtos.categoria_id = '4'");
     
        rs = stmt.executeQuery();
        while(rs.next()){
            ProdutoDTO produto = new ProdutoDTO();
            produto.setIdProduto(rs.getInt("id_produto"));
            produto.setNome_produto(rs.getString("nome_produto"));
            produto.setImagem(rs.getString("imagem"));
            produto.setDescricao(rs.getString("descricao"));
            produto.setTamanhoId(rs.getInt("tamanho_id"));
            produto.setQuantidade(rs.getInt("quantidade"));
            produto.setNome_categoria(rs.getString("nome_categoria"));
            produto.setValor(rs.getFloat("valor"));
            produtos.add(produto);
            
            
        }
        
    } catch(SQLException e){
        e.printStackTrace();
    }
            return produtos;
                         
}
              public List<ProdutoDTO> ListarBermuda(){
        List<ProdutoDTO> produtos = new ArrayList<>();
    try{
        Connection conexao = Conexao.conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        stmt = conexao.prepareStatement("SELECT produtos.id_produto, produtos.nome_produto, produtos.imagem, produtos.descricao, produtos.tamanho_id, produtos.quantidade, produtos.valor, categorias.nome_categoria FROM produtos INNER JOIN categorias ON produtos.categoria_id = categorias.id_categoria WHERE produtos.categoria_id = '5'");

      /*  stmt = conexao.prepareStatement("SELECT * FROM produtos");*/
     
        rs = stmt.executeQuery();
        while(rs.next()){
            ProdutoDTO produto = new ProdutoDTO();
            produto.setIdProduto(rs.getInt("id_produto"));
            produto.setNome_produto(rs.getString("nome_produto"));
            produto.setImagem(rs.getString("imagem"));
            produto.setDescricao(rs.getString("descricao"));
            produto.setTamanhoId(rs.getInt("tamanho_id"));
            produto.setQuantidade(rs.getInt("quantidade"));
            produto.setNome_categoria(rs.getString("nome_categoria"));
            produto.setValor(rs.getFloat("valor"));
            produtos.add(produto);
            
            
        }
        
    } catch(SQLException e){
        e.printStackTrace();
    }
            return produtos;
                         
}
              
public int consultarQuantidadeProduto(int produtoId) {
    System.out.println("id Produto dao: " + produtoId); // Verificação para o console
    int quantidade = 0;
    try {
        Connection conexao = Conexao.conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        stmt = conexao.prepareStatement("SELECT quantidade FROM produtos WHERE id_produto = ?");
        stmt.setInt(1, produtoId);

        rs = stmt.executeQuery();
        if (rs.next()) {
            ProdutoDTO objProduto = new ProdutoDTO();
            quantidade = rs.getInt("quantidade");
        }
        
        rs.close();
        stmt.close();
        conexao.close();
        
    } catch (SQLException e) {
        e.printStackTrace();
    }
    
    return quantidade;
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
