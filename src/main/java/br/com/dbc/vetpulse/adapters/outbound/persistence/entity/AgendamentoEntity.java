package br.com.dbc.vetpulse.adapters.outbound.persistence.entity;

import br.com.dbc.vetpulse.domain.model.StatusAgendamento;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(
        name = "AGENDAMENTO",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "UK_AGENDAMENTO_VETERINARIO_DATA_HORA",
                        columnNames = {"ID_VETERINARIO", "DATA_HORA"}
                )
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AgendamentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_AGENDAMENTO")
    private Integer idAgendamento;

    @ManyToOne
    @JoinColumn(name = "ID_PET", nullable = false)
    private PetEntity pet;

    @ManyToOne
    @JoinColumn(name = "ID_VETERINARIO", nullable = false)
    private VeterinarioEntity veterinario;

    @Column(name = "DATA_HORA", nullable = false)
    private LocalDateTime dataHora;

    @Column(name = "MOTIVO_CONSULTA")
    private String motivoConsulta;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS", nullable = false)
    private StatusAgendamento status;
}
