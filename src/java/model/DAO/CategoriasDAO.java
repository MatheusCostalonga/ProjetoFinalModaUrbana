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
import model.bean.CategoriaDTO;

/**
 *
 * @author Senai
 */
public class CategoriasDAO {
    
    public List<CategoriaDTO> listarCategorias(){
        List<CategoriaDTO> categorias = new ArrayList();
        
        try{
          Connection conexao = Conexao.conectar();
          PreparedStatement stmt = null;
          ResultSet rs = null;
          
          stmt = conexao.prepareStatement("SELECT * FROM categorias");
          rs = stmt.executeQuery();
          
          while(rs.next()){
              CategoriaDTO categoriaAtual = new CategoriaDTO();
              
              categoriaAtual.setId_categoria(rs.getInt("id_categoria"));
              categoriaAtual.setNome_categoria(rs.getString("nome_categoria"));
          
              categorias.add(categoriaAtual);
          }          
        } catch(SQLException e){
            
        }
        
        return categorias;
    }
}
