/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.Conexao;

/**
 *
 * @author alunos
 */
public class CNHDAO {
    public void cadastrar(CNH c) throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        PreparedStatement comando = con.prepareStatement("insert into cnh (validade, dtemissao, cpf, categoria, nomeautoescola, orgemissor, pontoscarteira) values (?,?,?,?,?,?,?)");
        comando.setString(1, c.getValidade());
        comando.setString(2, c.getDtEmissao());
        comando.setString(3, c.getCpf());
        comando.setString(4, c.getCategoria());
        comando.setString(5, c.getNomeAutoescola());
        comando.setString(6, c.getOrgEmissor());
        comando.setInt(7, c.getPontosCarteira());
        comando.execute();
        con.close();
    }
    
    public void update(CNH c) throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        PreparedStatement comando = con.prepareStatement("update cnh set validade = ? , dtemissao = ? , cpf = ? , categoria = ? , nomeautoescola = ? , orgemissor = ? , pontoscarteira = ? where numregistro = ?");
        comando.setString(1, c.getValidade());
        comando.setString(2, c.getDtEmissao());
        comando.setString(3, c.getCpf());
        comando.setString(4, c.getCategoria());
        comando.setString(5, c.getNomeAutoescola());
        comando.setString(6, c.getOrgEmissor());
        comando.setInt(7, c.getPontosCarteira());
        comando.setInt(8, c.getNumregistro());
        comando.execute();
        con.close();
    }
    
    public void delete(CNH c) throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        PreparedStatement comando = con.prepareStatement("delete from cnh where numregistro = ?");
        comando.setInt(1, c.getNumregistro());
        comando.execute();
        con.close();
    }
    
    public CNH select (CNH c) throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        PreparedStatement comando = con.prepareStatement("select * from cnh where numregistro = ?");
        comando.setInt(1, c.getNumregistro());
        ResultSet rs = comando.executeQuery();
        
        CNH cnh = new CNH();
        
        if (rs.next()){
            cnh.setNumregistro(rs.getInt("numregistro"));
            cnh.setValidade(rs.getString("validade"));
            cnh.setDtEmissao(rs.getString("dtemissao"));
            cnh.setCpf(rs.getString("cpf"));
            cnh.setCategoria(rs.getString("categoria"));
            cnh.setNomeAutoescola(rs.getString("nomeautoescola"));
            cnh.setOrgEmissor(rs.getString("orgemissor"));
            cnh.setPontosCarteira(rs.getInt("pontoscarteira"));
        }
        
        return cnh;
    }
    
    public List<CNH> selectall () throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        PreparedStatement comando = con.prepareStatement("select * from cnh order by numregistro");
        ResultSet rs = comando.executeQuery();
        
        List<CNH> lcnh = new ArrayList<CNH>();
        while(rs.next()){
            CNH cnh = new CNH();
            cnh.setNumregistro(rs.getInt("numregistro"));
            cnh.setValidade(rs.getString("validade"));
            cnh.setDtEmissao(rs.getString("dtemissao"));
            cnh.setCpf(rs.getString("cpf"));
            cnh.setCategoria(rs.getString("categoria"));
            cnh.setNomeAutoescola(rs.getString("nomeautoescola"));
            cnh.setOrgEmissor(rs.getString("orgemissor"));
            cnh.setPontosCarteira(rs.getInt("pontoscarteira"));
            
            lcnh.add(cnh);
        }
        
        return lcnh;
    }
}
