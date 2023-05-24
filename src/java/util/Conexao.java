/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author alunos
 */
public class Conexao {
    public static Connection getConexao() throws ClassNotFoundException,SQLException {
        Class.forName("org.postgresql.Driver");Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Projeto_CNH_DB", "postgres", "umc@2022");
        return con;
    }
}
