package br.com.dbc.vetpulse.adapters.inbound.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class VeterinarioCreateDTO {

    @NotBlank(message = "Nome é obrigatório.")
    private String nome;

    @Email(message = "E-mail inválido.")
    @NotBlank(message = "E-mail é obrigatório.")
    private String email;

    @NotBlank(message = "CRMV é obrigatório.")
    private String crmv;

    private String especialidade;

    private String telefone;
}
