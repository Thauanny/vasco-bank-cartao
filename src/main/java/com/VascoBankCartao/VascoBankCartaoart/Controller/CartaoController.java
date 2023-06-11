package com.VascoBankCartao.VascoBankCartaoart.Controller;

import com.VascoBankCartao.VascoBankCartaoart.models.CartaoCredito;
import com.VascoBankCartao.VascoBankCartaoart.models.Fatura;
import com.VascoBankCartao.VascoBankCartaoart.service.CartaoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping(value = "/cartaoCredito")
public class CartaoController {

        @Autowired
        private CartaoService cartaoService;

        @PostMapping("/{idConta}")
        public ResponseEntity<?> cadastraCartao(@PathVariable Integer idConta,
                        @RequestBody CartaoCredito cartaoCredito) {
                                //todo verificar conta existe
                try {
                        return ResponseEntity.ok(cartaoService.cadastraCartao(cartaoCredito));
                } catch (Exception e) {
                        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                        .body("{\"message\": \"Nao foi possivel concluir\"}");
                }
        }

        @GetMapping("/{idCartao}")
        public ResponseEntity<?> retornarCartao(@PathVariable Integer idCartao) {
                try {
                                                        //todo verificar conta existe
                        return ResponseEntity.ok(cartaoService.retornarCartao(idCartao));
                } catch (Exception e) {
                        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                        .body("{\"message\": \"Nao foi possivel concluir\"}");
                }
        }


        @GetMapping("/all/{idConta}")
        public ResponseEntity<?> retornarTodosCartoes(@PathVariable Integer idConta) {
                try {
                                                        //todo verificar conta existe
                        return ResponseEntity.ok(cartaoService.retornarTodosCartoes(idConta));
                } catch (Exception e) {
                        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                        .body("{\"message\": \"Nao foi possivel concluir\"}");
                }
        }

        @DeleteMapping("/{idCartao}")
        public ResponseEntity<?> deleteCartao(@PathVariable Integer idCartao) {
                try {
                        // chamada service
                        System.out.println(idCartao);
                        return ResponseEntity.ok("{\"message\": \"Em contrucao\"}");
                } catch (Exception e) {
                        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                        .body("{\"message\": \"Nao foi possivel concluir\"}");
                }
        }

        @GetMapping("/{idConta}/{idCartao}/limite")
        public ResponseEntity<?> limiteCartao(@PathVariable Integer idConta, @PathVariable Integer idCartao) {
                try {

                        // chamada service
                        System.out.println(idConta);
                        return ResponseEntity.ok("{\"message\": \"Em contrucao\"}");
                } catch (Exception e) {
                        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                        .body("{\"message\": \"Nao foi possivel concluir\"}");
                }
        }
}