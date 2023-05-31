package com.VascoBankCartao.VascoBankCartaoart.Controller;

import com.VascoBankCartao.VascoBankCartaoart.models.CartaoCredito;
import com.VascoBankCartao.VascoBankCartaoart.models.Pagamento;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping(value = "/cartaoCredito")
public class CartaoController
{
        @PostMapping("/{idConta}")
        public ResponseEntity<?> cadastraCartao(@PathVariable Integer idConta, @RequestBody CartaoCredito cartaoCredito) {
                try {
                        // chamada service
                        System.out.println(idConta);

                        return ResponseEntity.ok(cartaoCredito);
                } catch (Exception e) {
                        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                .body("{\"message\": \"Nao foi possivel concluir\"}");
                }
        }

        @PostMapping("/{idConta}/{idCartao}/pagamento")
        public ResponseEntity<?> pagamentoCartao(@PathVariable Integer idConta, @PathVariable Integer idConta, @RequestBody Pagamento pagamento) {
                try {
                        // chamada service
                        System.out.println(idConta);

                        return ResponseEntity.ok(pagamento);
                } catch (Exception e) {
                        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                .body("{\"message\": \"Nao foi possivel concluir\"}");
                }
        }

        @GetMapping("/{idConta}/{idCartao}")
        public ResponseEntity<?> cartao(@PathVariable Integer idConta,@PathVariable Integer idCartao) {
                try {
                        // chamada service
                        System.out.println(idConta);
                        return ResponseEntity.ok("{\"message\": \"Em contrucao\"}");
                } catch (Exception e) {
                        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                .body("{\"message\": \"Nao foi possivel concluir\"}");
                }
        }
        @GetMapping("/{idConta}/all")
        public ResponseEntity<?> cartaoAll(@PathVariable Integer idConta) {
                try {
                        // chamada service
                        System.out.println(idConta);
                        return ResponseEntity.ok("{\"message\": \"Em contrucao\"}");
                } catch (Exception e) {
                        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                .body("{\"message\": \"Nao foi possivel concluir\"}");
                }
        }
        @DeleteMapping("/{idConta}/{idCartao}")
        public ResponseEntity<?> deleteCartao(@PathVariable Integer idConta, @PathVariable Integer idCartao) {
                try {
                        // chamada service
                        System.out.println(idConta);
                        return ResponseEntity.ok("{\"message\": \"Em contrucao\"}");
                } catch (Exception e) {
                        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                .body("{\"message\": \"Nao foi possivel concluir\"}");
                }
        }
        @GetMapping("/{idConta}/{idCartao}/limite")
        public ResponseEntity<?> limiteCartao(@PathVariable Integer idConta,@PathVariable Integer idCartao) {
                try {
                        // chamada service
                        System.out.println(idConta);
                        return ResponseEntity.ok("{\"message\": \"Em contrucao\"}");
                } catch (Exception e) {
                        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                .body("{\"message\": \"Nao foi possivel concluir\"}");
                }
        }
        @GetMapping("/{idConta}/{idCartao}/fatura")
        public ResponseEntity<?> faturaCartao(@PathVariable Integer idConta,@PathVariable Integer idCartao) {
                try {
                        // chamada service
                        System.out.println(idConta);
                        return ResponseEntity.ok("{\"message\": \"Em contrucao\"}");
                } catch (Exception e) {
                        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                .body("{\"message\": \"Nao foi possivel concluir\"}");
                }
        }
        @GetMapping("/{idConta}/{idCartao}/extrato/{intervalo}")
        public ResponseEntity<?> extratoCartao(@PathVariable Integer idConta,@PathVariable Integer idCartao, @PathVariable Integer idConta,@PathVariable Intervalo intervalo) {
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