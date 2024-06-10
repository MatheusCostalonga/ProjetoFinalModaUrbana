/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.sql.Date;

/**
 *
 * @author Senai
 */
public class UsuarioDTO {
    private int id_usuario;

    private String nome;
    private String senha;
    private String usuario;
    private String telefone;
    private String data_nascimento;
    private boolean adm;
    private String cpf;

    public UsuarioDTO() {
    }

    public UsuarioDTO(int id_usuario, String nome, String senha, String usuario, String telefone, String data_nascimento, boolean adm, String cpf) {
        this.id_usuario = id_usuario;
        this.nome = nome;
        this.senha = senha;
        this.usuario = usuario;
        this.telefone = telefone;
        this.data_nascimento = data_nascimento;
        this.adm = adm;
        this.cpf = cpf;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public boolean isAdm() {
        return adm;
    }

    public void setAdm(boolean adm) {
        this.adm = adm;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

   

   
}
