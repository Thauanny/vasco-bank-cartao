package com.VascoBankCartao.VascoBankCartaoart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.VascoBankCartao.VascoBankCartaoart.models.CartaoCredito;
import com.VascoBankCartao.VascoBankCartaoart.models.Compra;
import com.VascoBankCartao.VascoBankCartaoart.models.Fatura;
import com.VascoBankCartao.VascoBankCartaoart.repository.CartaoRepository;

@Service
public class CartaoService {
    @Autowired
    private CartaoRepository cartaoRepository;

    public CartaoCredito cadastraCartao(CartaoCredito cartao) {
        return cartaoRepository.save(cartao);
    }

    public CartaoCredito retornarCartao(Integer idCartao) {
        return cartaoRepository.findById(idCartao).get();
    }
    public List<CartaoCredito> retornarTodosCartoes(Integer idCartao) {
        return cartaoRepository.findAllById(idCartao);
    }





}
