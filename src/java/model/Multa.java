/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author alunos
 */
public class Multa {
    
    private int codInfra;
    private int renavam;
    private int numRegistro;
    private String dataInfracao;
    private String localMulta;
    private int numIdentificacaoAgente;
    private int pontosHabilitacao;
    private double valorMulta;
    private String classificacaoMulta;
    private String dtVencimento;
    private String cpf;

    /**
     * @return the codInfra
     */
    public int getCodInfra() {
        return codInfra;
    }

    /**
     * @param codInfra the codInfra to set
     */
    public void setCodInfra(int codInfra) {
        this.codInfra = codInfra;
    }

    /**
     * @return the renavam
     */
    public int getRenavam() {
        return renavam;
    }

    /**
     * @param renavam the renavam to set
     */
    public void setRenavam(int renavam) {
        this.renavam = renavam;
    }

    /**
     * @return the numRegistro
     */
    public int getNumRegistro() {
        return numRegistro;
    }

    /**
     * @param numRegistro the numRegistro to set
     */
    public void setNumRegistro(int numRegistro) {
        this.numRegistro = numRegistro;
    }

    /**
     * @return the dataInfracao
     */
    public String getDataInfracao() {
        return dataInfracao;
    }

    /**
     * @param dataInfracao the dataInfracao to set
     */
    public void setDataInfracao(String dataInfracao) {
        this.dataInfracao = dataInfracao;
    }

    /**
     * @return the localMulta
     */
    public String getLocalMulta() {
        return localMulta;
    }

    /**
     * @param localMulta the localMulta to set
     */
    public void setLocalMulta(String localMulta) {
        this.localMulta = localMulta;
    }

    /**
     * @return the numIdentificacaoAgente
     */
    public int getNumIdentificacaoAgente() {
        return numIdentificacaoAgente;
    }

    /**
     * @param numIdentificacaoAgente the numIdentificacaoAgente to set
     */
    public void setNumIdentificacaoAgente(int numIdentificacaoAgente) {
        this.numIdentificacaoAgente = numIdentificacaoAgente;
    }

    /**
     * @return the pontosHabilitacao
     */
    public int getPontosHabilitacao() {
        return pontosHabilitacao;
    }

    /**
     * @param pontosHabilitacao the pontosHabilitacao to set
     */
    public void setPontosHabilitacao(int pontosHabilitacao) {
        this.pontosHabilitacao = pontosHabilitacao;
    }

    /**
     * @return the valorMulta
     */
    public double getValorMulta() {
        return valorMulta;
    }

    /**
     * @param valorMulta the valorMulta to set
     */
    public void setValorMulta(double valorMulta) {
        this.valorMulta = valorMulta;
    }

    /**
     * @return the classificacaoMulta
     */
    public String getClassificacaoMulta() {
        return classificacaoMulta;
    }

    /**
     * @param classificacaoMulta the classificacaoMulta to set
     */
    public void setClassificacaoMulta(String classificacaoMulta) {
        this.classificacaoMulta = classificacaoMulta;
    }

    /**
     * @return the dtVencimento
     */
    public String getDtVencimento() {
        return dtVencimento;
    }

    /**
     * @param dtVencimento the dtVencimento to set
     */
    public void setDtVencimento(String dtVencimento) {
        this.dtVencimento = dtVencimento;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
}
