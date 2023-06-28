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

    public CartaoCredito atualizarCartao(CartaoCredito cartao) {
        CartaoCredito _cartao =   retornarCartao(cartao.getIdCartaoCredito());
        _cartao.setCvv(cartao.getCvv());
        _cartao.setDataVencimento(cartao.getDataVencimento());
        _cartao.setEligivelAumentoLimite(cartao.isEligivelAumentoLimite());
        _cartao.setIdCartaoCredito(cartao.getIdCartaoCredito());
        _cartao.setIdConta(cartao.getIdConta());
        _cartao.setLimite(cartao.getLimite());
        _cartao.setLimiteAux(cartao.getLimiteAux());
        _cartao.setNome(cartao.getNome());
        _cartao.setNumero(cartao.getNumero());
        _cartao.setVirtual(cartao.isVirtual());
        return cartaoRepository.save(_cartao);
    }


    public List<CartaoCredito> retornarTodosCartoes(Integer contaId) {
        return cartaoRepository.findAllById(contaId);
    }

    public void deletaCartao(Integer idCartao) {
        cartaoRepository.deleteById(idCartao);
    }

    public CartaoCredito solicitarAumentoLimite(CartaoCredito cartao, double aumentoDesejavel) {
        cartao.setLimite(cartao.getLimite() + aumentoDesejavel);
        return cadastraCartao(cartao);

    }

    public CartaoCredito atualizarEligivelAumentoLimite(CartaoCredito cartao, boolean elegivel) {
        cartao.setEligivelAumentoLimite(elegivel);
        return cadastraCartao(cartao);

    }

}
