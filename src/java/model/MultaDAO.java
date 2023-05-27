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
public class MultaDAO {

    public void cadastrar(Multa m) throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        PreparedStatement comando = con.prepareStatement("insert into multa (renavam, numregistro, datainfracao, localmulta, numidentificacaoagente, pontoshablitacao, valormulta, classificacaomulta, dtvencimento, cpf) values (?,?,?,?,?,?,?,?,?,?)");
        comando.setInt(1, m.getRenavam());
        comando.setInt(2, m.getNumRegistro());
        comando.setString(3, m.getDataInfracao());
        comando.setString(4, m.getLocalMulta());
        comando.setInt(5, m.getNumIdentificacaoAgente());
        comando.setInt(6, m.getPontosHabilitacao());
        comando.setDouble(7, m.getValorMulta());
        comando.setString(8, m.getClassificacaoMulta());
        comando.setString(9, m.getDtVencimento());
        comando.setString(10, m.getCpf());
        comando.execute();
        con.close();
    }

    public void update(Multa m) throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        PreparedStatement comando = con.prepareStatement("update multa set renavam = ? , numregistro = ? , datainfracao = ? , localmulta = ? , numidentificacaoagente = ? , pontoshablitacao = ? , valormulta = ? , classificacaomulta = ? , dtvencimento = ? , pontoshablitacao = ? , cpf = ? where codinfra = ?");
        comando.setInt(1, m.getRenavam());
        comando.setInt(2, m.getNumRegistro());
        comando.setString(3, m.getDataInfracao());
        comando.setString(4, m.getLocalMulta());
        comando.setInt(5, m.getNumIdentificacaoAgente());
        comando.setInt(6, m.getPontosHabilitacao());
        comando.setDouble(7, m.getValorMulta());
        comando.setString(8, m.getClassificacaoMulta());
        comando.setString(9, m.getDtVencimento());
        comando.setString(10, m.getCpf());
        comando.setInt(11, m.getCodInfra());
        comando.execute();
        con.close();
    }

    public void delete(Multa m) throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        PreparedStatement comando = con.prepareStatement("delete from multa where codinfra = ?");
        comando.setInt(1, m.getCodInfra());
        comando.execute();
        con.close();
    }

    public Multa select(Multa m) throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        PreparedStatement comando = con.prepareStatement("select * from multa where codinfra = ?");
        comando.setInt(1, m.getCodInfra());
        ResultSet rs = comando.executeQuery();

        Multa mul = new Multa();

        if (rs.next()) {
            mul.setCodInfra(rs.getInt("codinfra"));
            mul.setRenavam(rs.getInt("renavam"));
            mul.setNumRegistro(rs.getInt("numregistro"));
            mul.setDataInfracao(rs.getString("datainfracao"));
            mul.setLocalMulta(rs.getString("localmulta"));
            mul.setNumIdentificacaoAgente(rs.getInt("numidentificacaoagente"));
            mul.setPontosHabilitacao(rs.getInt("pontoshablitacao"));
            mul.setValorMulta(rs.getDouble("valormulta"));
            mul.setClassificacaoMulta(rs.getString("classificacaomulta"));
            mul.setDtVencimento(rs.getString("dtvencimento"));
            mul.setCpf(rs.getString("cpf"));
        }

        return mul;
    }

    public List<Multa> selectall() throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        PreparedStatement comando = con.prepareStatement("select * from multa order by codinfra");
        ResultSet rs = comando.executeQuery();

        List<Multa> mu = new ArrayList<Multa>();
        while (rs.next()) {
            Multa mul = new Multa();
            mul.setCodInfra(rs.getInt("codinfra"));
            mul.setRenavam(rs.getInt("renavam"));
            mul.setNumRegistro(rs.getInt("numregistro"));
            mul.setDataInfracao(rs.getString("datainfracao"));
            mul.setLocalMulta(rs.getString("localmulta"));
            mul.setNumIdentificacaoAgente(rs.getInt("numidentificacaoagente"));
            mul.setPontosHabilitacao(rs.getInt("pontoshablitacao"));
            mul.setValorMulta(rs.getDouble("valormulta"));
            mul.setClassificacaoMulta(rs.getString("classificacaomulta"));
            mul.setDtVencimento(rs.getString("dtvencimento"));
            mul.setCpf(rs.getString("cpf"));

            mu.add(mul);
        }

        return mu;
    }
}
