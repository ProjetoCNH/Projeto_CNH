/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author alunos
 */
public class UsuarioDAO {
    public void cadastrar(Usuario u) throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        PreparedStatement comando = con.prepareStatement("insert into usuario (cpf, nome, dtnascimento, filiacao, telefone, endereco) values (?,?,?,?,?,?)");
        comando.setString(1, u.getCpf());
        comando.setString(2, u.getNome());
        comando.setString(3, u.getDtNascimento());
        comando.setString(4, u.getFiliacao());
        comando.setString(5, u.getTelefone());
        comando.setString(6, u.getEndereco());
        comando.execute();
        con.close();
    }
    
    public void update(Usuario u) throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        PreparedStatement comando = con.prepareStatement("update usuario set nome = ? , dtnascimento = ? , filiacao = ? , telefone = ? , endereco = ? where cpf = ?");
        comando.setString(1, u.getNome());
        comando.setString(2, u.getDtNascimento());
        comando.setString(3, u.getFiliacao());
        comando.setString(4, u.getTelefone());
        comando.setString(5, u.getEndereco());
        comando.setString(6, u.getCpf());
        comando.execute();
        con.close();
    }
    
    public void delete(Usuario u) throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        PreparedStatement comando = con.prepareStatement("delete from usuario where cpf = ?");
        comando.setString(1, u.getCpf());
        comando.execute();
        con.close();
    }
    
    public Usuario select (Usuario u) throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        PreparedStatement comando = con.prepareStatement("select * from usuario where cpf = ?");
        comando.setString(1, u.getCpf());
        ResultSet rs = comando.executeQuery();
        
        Usuario uu = new Usuario();
        
        if (rs.next()){
            uu.setCpf(rs.getString("cpf"));
            uu.setNome(rs.getString("nome"));
            uu.setDtNascimento(rs.getString("dtnascimento"));
            uu.setFiliacao(rs.getString("filiacao"));
            uu.setTelefone(rs.getString("telefone"));
            uu.setEndereco(rs.getString("endereco"));
        }
        
        return uu;
    }
    
    public List<Usuario> selectall () throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        PreparedStatement comando = con.prepareStatement("select * from usuario order by cpf");
        ResultSet rs = comando.executeQuery();
        
        List<Usuario> lu = new ArrayList<Usuario>();
        while(rs.next()){
            Usuario uu = new Usuario();
            uu.setCpf(rs.getString("cpf"));
            uu.setNome(rs.getString("nome"));
            uu.setDtNascimento(rs.getString("dtnascimento"));
            uu.setFiliacao(rs.getString("filiacao"));
            uu.setTelefone(rs.getString("telefone"));
            uu.setEndereco(rs.getString("endereco"));
            
            lu.add(uu);
        }
        
        return lu;
    }
}

