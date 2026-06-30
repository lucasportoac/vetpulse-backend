package br.com.dbc.vetpulse.domain.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pet {

    private Integer idPet;
    private String nome;
    private EspeciePet especie;
    private String raca;
    private Integer idade;
    private SexoPet sexo;
    private Tutor tutor;
}
