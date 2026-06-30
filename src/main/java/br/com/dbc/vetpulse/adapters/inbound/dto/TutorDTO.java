package br.com.dbc.vetpulse.adapters.inbound.dto;

import lombok.Data;

@Data
public class TutorDTO {

    private Integer idTutor;
    private String nome;
    private String email;
    private String cpf;
    private String telefone;
}
