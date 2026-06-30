package br.com.dbc.vetpulse.adapters.outbound.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "TUTOR")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TutorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TUTOR")
    private Integer idTutor;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name = "EMAIL", nullable = false, unique = true)
    private String email;

    @Column(name = "CPF", nullable = false, unique = true)
    private String cpf;

    @Column(name = "TELEFONE")
    private String telefone;
}
