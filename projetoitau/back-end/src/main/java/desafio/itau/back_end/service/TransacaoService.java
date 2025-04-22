package desafio.itau.back_end.service;

import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.springframework.stereotype.Service;

import desafio.itau.back_end.model.Transacao;

@Service
public class TransacaoService {
    
    private final Queue<Transacao> transacoes = new ConcurrentLinkedQueue<>();

    public void addTransacao(Transacao transacao) {
        transacoes.add(transacao);
    }

    public void limparTransacoes() {
        transacoes.clear();
    }

    public DoubleSummaryStatistics getEstatistica() {
        OffsetDateTime now = OffsetDateTime.now();
        return transacoes.stream()
                .filter(transacao -> transacao.getDateTime().isAfter(now.minusSeconds(60)))
                .mapToDouble(Transacao::getValor)
                .summaryStatistics();
    }
        
}
