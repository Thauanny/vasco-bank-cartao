package com.VascoBankCartao.VascoBankCartaoart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.VascoBankCartao.VascoBankCartaoart.models.Compra;
import com.VascoBankCartao.VascoBankCartaoart.repository.CompraRepository;

@Service
public class CompraService {
    @Autowired
    private CompraRepository compraRepository;

    public Compra cadastraCompra(Compra compra) {
        return compraRepository.save(compra);
    }

    public List<Compra> retornarCompras(Integer idFatura) {
        return compraRepository.retornarCompras(idFatura);
    }

}

