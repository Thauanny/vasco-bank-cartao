package com.VascoBankCartao.VascoBankCartaoart.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "Compra")
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "id_cartao")
    Integer idCartao;
    @Column(name = "valor")
    double valor;
    @Column(name = "data_compra")
    String dataCompra;
    @Column(name = "mes_compra")
    @Enumerated(EnumType.STRING)
    MESES mesCompra;
    @Column(name = "local")
    String local;
    @Column(name = "parcelas")
    int parcelas;

}
