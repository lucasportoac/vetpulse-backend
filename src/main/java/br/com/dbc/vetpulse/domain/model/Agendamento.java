package br.com.dbc.vetpulse.domain.model;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Agendamento {

    private Integer idAgendamento;
    private Pet pet;
    private Veterinario veterinario;
    private LocalDateTime dataHora;
    private String motivoConsulta;
    private StatusAgendamento status;
}
