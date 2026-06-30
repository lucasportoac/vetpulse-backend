package br.com.dbc.vetpulse.adapters.inbound.dto;

import lombok.Data;

@Data
public class VeterinarioDTO {

    private Integer idVeterinario;
    private String nome;
    private String email;
    private String crmv;
    private String especialidade;
    private String telefone;
}
