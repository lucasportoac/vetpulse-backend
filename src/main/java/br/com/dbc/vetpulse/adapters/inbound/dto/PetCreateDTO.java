package br.com.dbc.vetpulse.adapters.inbound.dto;

import br.com.dbc.vetpulse.domain.model.EspeciePet;
import br.com.dbc.vetpulse.domain.model.SexoPet;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PetCreateDTO {

    @NotBlank(message = "Nome é obrigatório.")
    private String nome;

    @NotNull(message = "Espécie é obrigatória.")
    private EspeciePet especie;

    private String raca;

    private Integer idade;

    private SexoPet sexo;

    @NotNull(message = "ID do tutor é obrigatório.")
    private Integer idTutor;
}
