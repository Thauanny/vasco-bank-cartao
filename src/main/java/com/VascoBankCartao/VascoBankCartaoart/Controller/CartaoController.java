package com.VascoBankCartao.VascoBankCartaoart.Controller;

import com.VascoBankCartao.VascoBankCartaoart.models.CartaoCredito;
import com.VascoBankCartao.VascoBankCartaoart.models.DTO.AumentoDTO;
import com.VascoBankCartao.VascoBankCartaoart.models.DTO.ContaDTO;
import com.VascoBankCartao.VascoBankCartaoart.models.DTO.ElegibilidadeDTO;
import com.VascoBankCartao.VascoBankCartaoart.service.CartaoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping(value = "/cartaoCredito")
public class CartaoController {

        @Autowired
        private CartaoService cartaoService;

        @Autowired
        private RestTemplate restTemplate;

        @PostMapping("/{idUser}")
        public ResponseEntity<?> cadastraCartao(@PathVariable Integer idUser,
                        @RequestBody CartaoCredito cartaoCredito) {

                try {
                        ContaDTO conta = restTemplate.getForObject("http://localhost:8080/contaCorrente/{idUser}",
                                        ContaDTO.class,
                                        idUser);
                        if (conta == null)
                                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                                .body("{\"message\": \"usuario não possui conta cadastrado\"}");
                        return ResponseEntity.ok(cartaoService.cadastraCartao(cartaoCredito));
                } catch (Exception e) {
                        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                        .body("{\"message\": \"Nao foi possivel concluir\"}");
                }
        }

        @GetMapping("/{idCartao}")
        public ResponseEntity<?> retornarCartao(@PathVariable Integer idCartao) {
                try {
                        CartaoCredito cartao = cartaoService.retornarCartao(idCartao);
                        if (cartao == null)
                                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                                .body("{\"message\": \"usuario não possui cartao cadastrado\"}");

                        return ResponseEntity.ok(cartao);
                } catch (Exception e) {
                        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                        .body("{\"message\": \"Nao foi possivel concluir\"}");
                }
        }

        @GetMapping("/all/{idConta}")
        public ResponseEntity<?> retornarTodosCartoes(@PathVariable Integer idConta) {
                try {
                        return ResponseEntity.ok(cartaoService.retornarTodosCartoes(idConta));
                } catch (Exception e) {
                        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                        .body("{\"message\": \"Nao foi possivel concluir\"}");
                }
        }

        @DeleteMapping("/{idCartao}")
        public ResponseEntity<?> deleteCartao(@PathVariable Integer idCartao) {
                try {
                        CartaoCredito cartao = cartaoService.retornarCartao(idCartao);
                        if (cartao == null)
                                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                                .body("{\"message\": \"usuario não possui cartao cadastrado\"}");

                        cartaoService.deletaCartao(idCartao);
                        return ResponseEntity.ok("{\"message\": \"Cartão deletado com sucesso\"}");
                } catch (Exception e) {
                        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                        .body("{\"message\": \"Nao foi possivel concluir\"}");
                }
        }

        @GetMapping("/limite/{idCartao}")
        public ResponseEntity<?> limiteCartao(@PathVariable Integer idCartao) {
                try {
                        CartaoCredito cartao = cartaoService.retornarCartao(idCartao);
                        if (cartao == null)
                                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                                .body("{\"message\": \"usuario não possui cartao cadastrado\"}");

                        return ResponseEntity.ok("{\"valor\": " + cartao.getLimite() + "}");
                } catch (Exception e) {
                        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                        .body("{\"message\": \"Nao foi possivel concluir\"}");
                }
        }

        @PutMapping("/solicitarAumentoLimite")
        public ResponseEntity<?> solicitarAumentoLimite(@RequestBody AumentoDTO aumento) {
                try {
                        CartaoCredito cartao = cartaoService.retornarCartao(aumento.getIdCartao());
                        if (cartao == null)
                                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                                .body("{\"message\": \"usuario não possui cartao cadastrado\"}");

                        if (!cartao.isEligivelAumentoLimite())
                                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                                .body("{\"message\": \"Nao foi possivel aumentar o limite dessa vez.\"}");

                        return ResponseEntity.ok(cartaoService.solicitarAumentoLimite(cartao, aumento.getValor()));
                } catch (Exception e) {
                        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                        .body("{\"message\": \"Nao foi possivel concluir\"}");
                }
        }

        @PutMapping("/atualizarEligivelAumentoLimite")
        public ResponseEntity<?> atualizarEligivelAumentoLimite(@RequestBody ElegibilidadeDTO elegibilidade) {
                try {
                        CartaoCredito cartao = cartaoService.retornarCartao(elegibilidade.getIdCartao());
                        if (cartao == null)
                                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                                .body("{\"message\": \"usuario não possui cartao cadastrado\"}");

                        if (cartao.isEligivelAumentoLimite())
                                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                                .body("{\"message\": \"usuario ja possui elegibilidade para aumento de limite\"}");

                        return ResponseEntity.ok(cartaoService.atualizarEligivelAumentoLimite(cartao,
                                        elegibilidade.isElegivel()));
                } catch (Exception e) {
                        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                        .body("{\"message\": \"Nao foi possivel concluir\"}");
                }
        }
}