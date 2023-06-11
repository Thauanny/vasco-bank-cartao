package com.VascoBankCartao.VascoBankCartaoart.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.ForeignKey;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CartaoCredito")
@Getter
@Setter
public class CartaoCredito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cartao")
    Integer id;
    @Column(name = "id_conta")
    Integer idConta;
    @Column(name = "nome")
    String nome;
    @Column(name = "numero")
    String numero;
    @Column(name = "dataVencimento")
    String dataVencimento;
    @Column(name = "cvv")
    String cvv;
    @Column(name = "limite")
    double limite;
    @Column(name = "eligivel_aumento_limite")
    boolean eligivelAumentoLimite;
    @Column(name = "virtual")
    boolean virtual;
    
   }
