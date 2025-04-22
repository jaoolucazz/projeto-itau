package desafio.itau.back_end.controller;

import desafio.itau.back_end.dto.Estatistica;
import desafio.itau.back_end.service.TransacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.DoubleSummaryStatistics;

@RestController
@RequestMapping("/estatistica")
public class EstatisticaController {

    private final TransacaoService transacaoService;

    public EstatisticaController(TransacaoService transacaoService){
        this.transacaoService = transacaoService;
    }

    @GetMapping
    public ResponseEntity<Estatistica> getEstatistica(){
        DoubleSummaryStatistics stats = transacaoService.getEstatistica();
        return ResponseEntity.ok(new Estatistica(stats));
    }

}
