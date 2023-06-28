package com.VascoBankCartao.VascoBankCartaoart.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.VascoBankCartao.VascoBankCartaoart.models.Compra;
import com.VascoBankCartao.VascoBankCartaoart.models.Fatura;
import com.VascoBankCartao.VascoBankCartaoart.repository.CompraRepository;
import com.VascoBankCartao.VascoBankCartaoart.repository.FaturaRepository;

@Service
public class FaturaService {
    @Autowired
    private FaturaRepository faturaRepository;
    @Autowired
    private CompraRepository compraRepository;

    public Fatura cadastraFatura(Fatura fatura) {
        return faturaRepository.save(fatura);
    }

    public List<Fatura> retornarFaturas(Integer idCartao) {
        List<Fatura> faturas = faturaRepository.retornarFaturas(idCartao);
        List<Compra> compras = compraRepository.retornarCompras(idCartao);
        List<Compra> comprasPorMesFatura = new ArrayList<>();
        try {
            for (Fatura fatura : faturas) {
                for (Compra compra : compras) {
                    if (compra.getMesCompra() == fatura.getMesVencimento()) {
                        comprasPorMesFatura.add(compra);
                    }
                    fatura.setCompras(comprasPorMesFatura);
                }
            }
        } catch (Exception e) {
            System.err.println(e);
        }

        return faturas;

    }

    public Fatura retornarFatura(Integer idFatura) {
        return faturaRepository.findById(idFatura).get();
    }

    public Fatura atualizarFatura(Fatura fatura) {
       Fatura _fatura = faturaRepository.findById(fatura.getId()).get();
       _fatura.setCompras(fatura.getCompras());
       _fatura.setDataVencimento(fatura.getDataVencimento());
       _fatura.setId(fatura.getId());
       _fatura.setIdCartao(fatura.getIdCartao());
       _fatura.setMesVencimento(fatura.getMesVencimento());
       _fatura.setPaga(fatura.isPaga());
       _fatura.setValorTotal(fatura.getValorTotal());
       return faturaRepository.save(_fatura);

    }
}