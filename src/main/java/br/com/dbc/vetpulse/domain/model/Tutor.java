package br.com.dbc.vetpulse.domain.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tutor {

    private Integer idTutor;
    private String nome;
    private String email;
    private String cpf;
    private String telefone;
}
