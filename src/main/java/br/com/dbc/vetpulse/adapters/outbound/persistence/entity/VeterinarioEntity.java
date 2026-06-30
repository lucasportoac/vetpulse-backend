package br.com.dbc.vetpulse.adapters.outbound.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "VETERINARIO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VeterinarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_VETERINARIO")
    private Integer idVeterinario;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name = "EMAIL", nullable = false, unique = true)
    private String email;

    @Column(name = "CRMV", nullable = false, unique = true)
    private String crmv;

    @Column(name = "ESPECIALIDADE")
    private String especialidade;

    @Column(name = "TELEFONE")
    private String telefone;
}
