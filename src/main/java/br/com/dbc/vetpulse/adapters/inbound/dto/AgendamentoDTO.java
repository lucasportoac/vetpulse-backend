package br.com.dbc.vetpulse.adapters.inbound.dto;

import br.com.dbc.vetpulse.domain.model.StatusAgendamento;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AgendamentoDTO {

    private Integer idAgendamento;
    private PetDTO pet;
    private VeterinarioDTO veterinario;
    private LocalDateTime dataHora;
    private String motivoConsulta;
    private StatusAgendamento status;
}
