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
import model.bean.EnderecosDTO;
import raven.toast.Notifications;

/**
 *
 * @author Senai
 */
public class EnderecoDAO {
    
    public List<EnderecosDTO> verEndereco() {
        List<EnderecosDTO> enderecos = new ArrayList<>();
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            stmt = conexao.prepareStatement("SELECT * FROM enderecos");
            rs = stmt.executeQuery();
            while (rs.next()) {
                EnderecosDTO objEndereco = new EnderecosDTO();
                objEndereco.setId_endereco(rs.getInt("id_endereco"));
                objEndereco.setUsuario_id1(rs.getInt("usuario_id1"));
                objEndereco.setRua(rs.getString("rua"));
                objEndereco.setNumero(rs.getInt("numero"));
                objEndereco.setCep(rs.getString("cep"));
                objEndereco.setComplemento(rs.getString("complemento"));
                enderecos.add(objEndereco);
            }
            rs.close();
            stmt.close();
            conexao.close();

        } catch (SQLException erro) {
            erro.printStackTrace();
        }
        return enderecos;
    }
    public void inserirEndereco(EnderecosDTO objEndereco) {
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            stmt = conexao.prepareStatement("INSERT INTO enderecos (usuario_id1, rua, numero, cep, complemento) VALUES (?, ?, ?, ?, ?)");
            stmt.setInt(1, objEndereco.getUsuario_id1());
            stmt.setString(2, objEndereco.getRua());
            stmt.setInt(3, objEndereco.getNumero());
            stmt.setString(4, objEndereco.getCep());
            stmt.setString(5, objEndereco.getComplemento());
            stmt.executeUpdate();
            stmt.close();
            conexao.close();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }

    public void editarEndereco(EnderecosDTO objEndereco) {
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            stmt = conexao.prepareStatement("UPDATE enderecos SET usuario_id1 = ?, rua = ?, numero = ?, cep = ?, complemento = ? WHERE id_endereco = ?");
            stmt.setInt(1, objEndereco.getUsuario_id1());
            stmt.setString(2, objEndereco.getRua());
            stmt.setInt(3, objEndereco.getNumero());
            stmt.setString(4, objEndereco.getCep());
            stmt.setString(5, objEndereco.getComplemento());
            stmt.setInt(6, objEndereco.getId_endereco());

            stmt.executeUpdate();
            stmt.close();
            conexao.close();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }
        public List<EnderecosDTO> enderecoUsuarios(int id_usuarioEndereco) {
        List<EnderecosDTO> enderecos = new ArrayList<>();
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            stmt = conexao.prepareStatement("SELECT * FROM enderecos WHERE usuario_id1 = ?");
           stmt.setInt(1, id_usuarioEndereco);

            rs = stmt.executeQuery();
            while (rs.next()) {

                
                EnderecosDTO objEndereco = new EnderecosDTO();
                objEndereco.setId_endereco(rs.getInt("id_endereco"));
                objEndereco.setUsuario_id1(rs.getInt("usuario_id1"));
                objEndereco.setRua(rs.getString("rua"));
                objEndereco.setNumero(rs.getInt("numero"));
                objEndereco.setCep(rs.getString("cep"));
                objEndereco.setComplemento(rs.getString("complemento"));
                enderecos.add(objEndereco);
            }
            rs.close();
            stmt.close();
            conexao.close();

        } catch (SQLException erro) {
            erro.printStackTrace();
        }
        return enderecos;
    }
          }

