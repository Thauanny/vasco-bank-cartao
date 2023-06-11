package com.VascoBankCartao.VascoBankCartaoart.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Fatura")
public class Fatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_fatura")
    Integer id;
    @Column(name = "id_cartao")
    Integer idCartao;
    @Column(name = "valor_total")
    double valorTotal;
    @Column(name = "data_vencimento")
    String dataVencimento;
    @Column(name = "mes_vencimento")
    @Enumerated(EnumType.STRING)
    MESES mesVencimento;
    @Column(name = "paga")
    boolean paga;
    @ElementCollection
    List<Compra> compras;

}
