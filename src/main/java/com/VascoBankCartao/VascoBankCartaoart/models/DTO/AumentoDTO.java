package com.VascoBankCartao.VascoBankCartaoart.models.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AumentoDTO {
    Integer idConta;
    double valor;
}
