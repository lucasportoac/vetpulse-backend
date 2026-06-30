package br.com.dbc.vetpulse.adapters.outbound.persistence.entity;

import br.com.dbc.vetpulse.domain.model.EspeciePet;
import br.com.dbc.vetpulse.domain.model.SexoPet;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "PET")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PET")
    private Integer idPet;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column(name = "ESPECIE", nullable = false)
    private EspeciePet especie;

    @Column(name = "RACA")
    private String raca;

    @Column(name = "IDADE")
    private Integer idade;

    @Enumerated(EnumType.STRING)
    @Column(name = "SEXO")
    private SexoPet sexo;

    @ManyToOne
    @JoinColumn(name = "ID_TUTOR", nullable = false)
    private TutorEntity tutor;
}
