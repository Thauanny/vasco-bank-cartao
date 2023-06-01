package com.VascoBankCartao.VascoBankCartaoart.models;

public class CartaoCredito {
    int id;
    String nome;
    int numero;
    String dataVencimento;
    int cvv;
    double limite;
    boolean eligivelAumentoLimite;
    boolean virtual;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public String getDataVencimento() {
        return dataVencimento;
    }
    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }
    public int getCvv() {
        return cvv;
    }
    public void setCvv(int cvv) {
        this.cvv = cvv;
    }
    public double getLimite() {
        return limite;
    }
    public void setLimite(double limite) {
        this.limite = limite;
    }
    public boolean isEligivelAumentoLimite() {
        return eligivelAumentoLimite;
    }
    public void setEligivelAumentoLimite(boolean eligivelAumentoLimite) {
        this.eligivelAumentoLimite = eligivelAumentoLimite;
    }
    public boolean isVirtual() {
        return virtual;
    }
    public void setVirtual(boolean virtual) {
        this.virtual = virtual;
    }

   }
