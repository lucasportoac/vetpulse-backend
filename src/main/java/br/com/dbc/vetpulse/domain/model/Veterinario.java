package br.com.dbc.vetpulse.domain.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Veterinario {

    private Integer idVeterinario;
    private String nome;
    private String email;
    private String crmv;
    private String especialidade;
    private String telefone;
}
