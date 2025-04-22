package desafio.itau.back_end.dto;

import java.time.OffsetDateTime;


import jakarta.validation.constraints.NotNull;

public class RequisicaoDeTransacao {
    
    @NotNull

    private Double valor;

    @NotNull
    private OffsetDateTime dataHora;

    public Double getValor() {
        return valor;
    }

    public OffsetDateTime getDataHora() {
        return dataHora;
    }

}
