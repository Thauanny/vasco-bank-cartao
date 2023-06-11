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

import com.VascoBankCartao.VascoBankCartaoart.models.Fatura;
import com.VascoBankCartao.VascoBankCartaoart.service.FaturaService;

@RestController
@RequestMapping(value = "/fatura")
public class FaturaController {

    @Autowired
    FaturaService faturaService;

    @GetMapping("/{idCartao}")
    public ResponseEntity<?> retornarFatura(@PathVariable Integer idCartao) {
        try {
            return ResponseEntity.ok(faturaService.retornarFaturas(idCartao));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"message\": \"Nao foi possivel concluir\"}");
        }
    }

    @PostMapping("/{idCartao}")
    public ResponseEntity<?> cadastraFatura(@PathVariable Integer idCartao, @RequestBody Fatura fatura) {
        try {
            fatura.setIdCartao(idCartao);
            return ResponseEntity.ok(faturaService.cadastraFatura(fatura));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"message\": \"Nao foi possivel concluir\"}");
        }
    }
}
