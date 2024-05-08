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
    
    public List<EnderecosDTO> verTabela() {
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
    
    public void inserir(EnderecosDTO objEndereco) {
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            stmt = conexao.prepareStatement("INSERT INTO enderecos (rua, numero, cep, complemento) VALUES (?, ?, ?, ?)");
            stmt.setString(1, objEndereco.getRua());
            stmt.setInt(2, objEndereco.getNumero());
            stmt.setString(3, objEndereco.getCep());
            stmt.setString(4, objEndereco.getComplemento());
            stmt.executeUpdate();
            stmt.close();
            conexao.close();
            Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER, "USUARIO CADASTRADO COM SUCESSO!");
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }
}
