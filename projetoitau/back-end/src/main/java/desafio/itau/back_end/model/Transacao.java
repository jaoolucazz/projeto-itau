package desafio.itau.back_end.model;

import java.time.OffsetDateTime;

public class Transacao {
    
    private Double valor;
    private OffsetDateTime dateTime;

    public Transacao(final Double valor, final OffsetDateTime dateTime) {
        this.valor = valor;
        this.dateTime = dateTime;
    }

    public Double getValor() {
        return valor;
    }

    public OffsetDateTime getDateTime() {
        return dateTime;
    }
}
