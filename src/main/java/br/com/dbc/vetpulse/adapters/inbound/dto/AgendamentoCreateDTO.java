package br.com.dbc.vetpulse.adapters.inbound.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AgendamentoCreateDTO {

    @NotNull(message = "ID do pet é obrigatório.")
    private Integer idPet;

    @NotNull(message = "ID do veterinário é obrigatório.")
    private Integer idVeterinario;

    @NotNull(message = "Data e hora são obrigatórias.")
    @Future(message = "A data do agendamento deve ser futura.")
    private LocalDateTime dataHora;

    private String motivoConsulta;
}
