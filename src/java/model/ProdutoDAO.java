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
public class ProdutoDAO {
    public void cadastrar(Produto p) throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        PreparedStatement comando = con.prepareStatement("insert into produtos (descricao, preco, cor, quantidade, nomefornecedor, nparcelas, marca) values (?,?,?,?,?,?,?)");
        comando.setString(1, p.getDescricao());
        comando.setDouble(2, p.getPreco());
        comando.setString(3, p.getCor());
        comando.setInt(4, p.getQuantidade());
        comando.setString(5, p.getNomeFornecedor());
        comando.setInt(6, p.getNParcelas());
        comando.setString(7, p.getMarca());
        comando.execute();
        con.close();
    }
    
    public void update(Produto p) throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        PreparedStatement comando = con.prepareStatement("update produtos set descricao = ? , preco = ? , cor = ? , quantidade = ? , nomefornecedor = ? , nparcelas = ? , marca = ? where id = ?");
        comando.setString(1, p.getDescricao());
        comando.setDouble(2, p.getPreco());
        comando.setString(3, p.getCor());
        comando.setInt(4, p.getQuantidade());
        comando.setString(5, p.getNomeFornecedor());
        comando.setInt(6, p.getNParcelas());
        comando.setString(7, p.getMarca());
        comando.setInt(8, p.getId());
        comando.execute();
        con.close();
    }
    
    public void delete(Produto p) throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        PreparedStatement comando = con.prepareStatement("delete from produtos where id = ?");
        comando.setInt(1, p.getId());
        comando.execute();
        con.close();
    }
    
    public Produto select (Produto p) throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        PreparedStatement comando = con.prepareStatement("select * from produtos where id = ?");
        comando.setInt(1, p.getId());
        ResultSet rs = comando.executeQuery();
        
        Produto prod = new Produto();
        
        if (rs.next()){
            prod.setId(rs.getInt("id"));
            prod.setDescricao(rs.getString("descricao"));
            prod.setPreco(rs.getDouble("preco"));
            prod.setCor(rs.getString("cor"));
            prod.setQuantidade(rs.getInt("quantidade"));
            prod.setNomeFornecedor(rs.getString("nomefornecedor"));
            prod.setNParcelas(rs.getInt("nparcelas"));
            prod.setMarca(rs.getString("marca"));
        }
        
        return prod;
    }
    
    public List<Produto> selectall () throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        PreparedStatement comando = con.prepareStatement("select * from produtos order by id");
        ResultSet rs = comando.executeQuery();
        
        List<Produto> lprod = new ArrayList<Produto>();
        while(rs.next()){
            Produto prod = new Produto();
            prod.setId(rs.getInt("id"));
            prod.setDescricao(rs.getString("descricao"));
            prod.setPreco(rs.getDouble("preco"));
            prod.setCor(rs.getString("cor"));
            prod.setQuantidade(rs.getInt("quantidade"));
            prod.setNomeFornecedor(rs.getString("nomefornecedor"));
            prod.setNParcelas(rs.getInt("nparcelas"));
            prod.setMarca(rs.getString("marca"));
            
            lprod.add(prod);
        }
        
        return lprod;
    }
}

