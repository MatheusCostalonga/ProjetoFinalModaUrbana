/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author famil
 */
public class Conexao {
 
    private static final String url ="jdbc:mysql://localhost:3306/ModaUrbana?useSSL=false";
    private static final String usuario ="root";
    private static final String senha = "";
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    
    public static Connection conectar() {
        Connection conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, usuario, senha);
        } catch (Exception e) {
            System.out.println(e);
        }
        return conn;
    }
}
