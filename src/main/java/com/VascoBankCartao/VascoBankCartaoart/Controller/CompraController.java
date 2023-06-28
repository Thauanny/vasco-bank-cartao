package com.VascoBankCartao.VascoBankCartaoart.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.VascoBankCartao.VascoBankCartaoart.models.CartaoCredito;
import com.VascoBankCartao.VascoBankCartaoart.models.Compra;
import com.VascoBankCartao.VascoBankCartaoart.service.CartaoService;
import com.VascoBankCartao.VascoBankCartaoart.service.CompraService;

@RestController
@RequestMapping(value = "/compra")
public class CompraController {

    @Autowired
    CompraService compraService;
    @Autowired
    private CartaoService cartaoService;

    @GetMapping("/{idCartao}")
    public ResponseEntity<?> retornarCompra(@PathVariable Integer idCartao) {
        try {
            return ResponseEntity.ok(compraService.retornarCompras(idCartao));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"message\": \"Nao foi possivel concluir\"}");
        }
    }

    @PostMapping("/{idCartao}")
    public ResponseEntity<?> cadastraCompra(@PathVariable Integer idCartao, @RequestBody Compra compra) {
        try {

            CartaoCredito cartao = cartaoService.retornarCartao(idCartao);
            // todo ao registrar compra gerar fatura
            if (cartao.getLimite() < compra.getValor())
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("{\"message\": \" Limite insuficiente \"}");

            compra.setIdCartao(idCartao);
            cartao.setLimiteAux(cartao.getLimiteAux() - compra.getValor());
            cartaoService.atualizarCartao(cartao);
            return ResponseEntity.ok(compraService.cadastraCompra(compra));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"message\": \"Nao foi possivel concluir\"}");
        }
    }

}
