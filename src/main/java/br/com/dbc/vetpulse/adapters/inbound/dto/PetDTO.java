package br.com.dbc.vetpulse.adapters.inbound.dto;

import br.com.dbc.vetpulse.domain.model.EspeciePet;
import br.com.dbc.vetpulse.domain.model.SexoPet;
import lombok.Data;

@Data
public class PetDTO {

    private Integer idPet;
    private String nome;
    private EspeciePet especie;
    private String raca;
    private Integer idade;
    private SexoPet sexo;
    private TutorDTO tutor;
}
