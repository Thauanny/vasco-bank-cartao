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

    public void setId(int idConta) {
        id = idConta;
    }
    public int getId(){
        return id;
    }

    public void setNome(String nomeConta) {
        nome = nomeConta;
    }
    public String getNome(){
        return nome;
    }
    public void setNumero(int numeroConta) {
        numero = numeroConta;
    }
    public int getNumero(){
        return numero;
    }
    public void setDataVencimento(String data) {
        dataVencimento = data;
    }
    public String getDataVencimento(){
        return dataVencimento;
    }
    public void setCvv(int cvv1) {
        cvv = cvv1;
    }
    public int getCvv(){
        return cvv;
    }
    public void setLimite(double limiteCartao) {
        limite = limiteCartao;
    }
    public double getLimite(){
        return limite;
    }
    public void setEligivelAumentoLimite(boolean podeAumentarLimite) {
        eligivelAumentoLimite = podeAumentarLimite;
    }
    public boolean isEligivelAumentoLimite(){
        return eligivelAumentoLimite;
    }
    public void setVirtual(boolean cartaoEhVirtual) {
        virtual = cartaoEhVirtual;
    }
    public boolean isVirtual(){
        return virtual;
    }
}

