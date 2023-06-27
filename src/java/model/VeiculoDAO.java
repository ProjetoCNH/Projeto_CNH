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
public class VeiculoDAO {
    public void cadastrar(Veiculo v) throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        PreparedStatement comando = con.prepareStatement("insert into veiculo (placa, ano, modelo, tipo, chassi, cor, crv, combustivel, categoria, cpf) values (?,?,?,?,?,?,?,?,?,?)");
        comando.setString(1, v.getPlaca());
        comando.setString(2, v.getAno());
        comando.setString(3, v.getModelo());
        comando.setString(4, v.getTipo());
        comando.setString(5, v.getChassi());
        comando.setString(6, v.getCor());
        comando.setString(7, v.getCrv());
        comando.setString(8, v.getCombustivel());
        comando.setString(9, v.getCategoria());
        comando.setString(10, v.getCpf());
        comando.execute();
        con.close();
    }
    
    public void update(Veiculo v) throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        PreparedStatement comando = con.prepareStatement("update veiculo set placa = ? , ano = ? , modelo = ? , tipo = ? , chassi = ? , cor = ? , crv = ? , combustivel = ?, categoria = ?, cpf = ? where renavam = ?");
        comando.setString(1, v.getPlaca());
        comando.setString(2, v.getAno());
        comando.setString(3, v.getModelo());
        comando.setString(4, v.getTipo());
        comando.setString(5, v.getChassi());
        comando.setString(6, v.getCor());
        comando.setString(7, v.getCrv());
        comando.setString(8, v.getCombustivel());
        comando.setString(9, v.getCategoria());
        comando.setString(10, v.getCpf());
        comando.setInt(11, v.getRenavam());
        comando.execute();
        con.close();
    }
    
    public void delete(Veiculo v) throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        PreparedStatement comando = con.prepareStatement("delete from veiculo where renavam = ?");
        comando.setInt(1, v.getRenavam());
        comando.execute();
        con.close();
    }
    
    public Veiculo select (Veiculo v) throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        PreparedStatement comando = con.prepareStatement("select * from veiculo where renavam = ?");
        comando.setInt(1, v.getRenavam());
        ResultSet rs = comando.executeQuery();
        
        Veiculo vei = new Veiculo();
        
        if (rs.next()){
            vei.setRenavam(rs.getInt("renavam"));
            vei.setPlaca(rs.getString("placa"));
            vei.setAno(rs.getString("ano"));
            vei.setModelo(rs.getString("modelo"));
            vei.setTipo(rs.getString("tipo"));
            vei.setChassi(rs.getString("chassi"));
            vei.setCor(rs.getString("cor"));
            vei.setCrv(rs.getString("crv"));
            vei.setCombustivel(rs.getString("combustivel"));
            vei.setCategoria(rs.getString("categoria"));
            vei.setCpf(rs.getString("cpf"));
        }
        
        
        return vei;
    }
    
    public List<Veiculo> selectall () throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        PreparedStatement comando = con.prepareStatement("select * from veiculo order by renavam");
        ResultSet rs = comando.executeQuery();
        
        List<Veiculo> lv = new ArrayList<Veiculo>();
        while(rs.next()){
            Veiculo vei = new Veiculo();
            vei.setRenavam(rs.getInt("renavam"));
            vei.setPlaca(rs.getString("placa"));
            vei.setAno(rs.getString("ano"));
            vei.setModelo(rs.getString("modelo"));
            vei.setTipo(rs.getString("tipo"));
            vei.setChassi(rs.getString("chassi"));
            vei.setCor(rs.getString("cor"));
            vei.setCrv(rs.getString("crv"));
            vei.setCombustivel(rs.getString("combustivel"));
            vei.setCategoria(rs.getString("categoria"));
            vei.setCpf(rs.getString("cpf"));
            
            lv.add(vei);
        }
        
        return lv;
    }
}
