package desafio.itau.back_end.controller;

import java.time.OffsetDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import desafio.itau.back_end.dto.RequisicaoDeTransacao;
import desafio.itau.back_end.model.Transacao;
import desafio.itau.back_end.service.TransacaoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {
    
    private final TransacaoService transacaoService;

    public TransacaoController(TransacaoService transacaoService){
        this.transacaoService = transacaoService;
    }

    @PostMapping
    public ResponseEntity<Void> criarTransacao(@Valid @RequestBody RequisicaoDeTransacao requisicao){
        if (requisicao.getDataHora().isAfter(OffsetDateTime.now())){
            return ResponseEntity.unprocessableEntity().build();
        }
        transacaoService.addTransacao(new Transacao(requisicao.getValor(), requisicao.getDataHora()));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping
    public ResponseEntity<Void> limparTransacoes(){
        transacaoService.limparTransacoes();
        return ResponseEntity.ok().build();
    }
}