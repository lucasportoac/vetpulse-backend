package br.com.dbc.vetpulse.adapters.outbound.persistence.mapper;

import br.com.dbc.vetpulse.adapters.outbound.persistence.entity.AgendamentoEntity;
import br.com.dbc.vetpulse.domain.model.Agendamento;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AgendamentoPersistenceMapper {

    private final PetPersistenceMapper petPersistenceMapper;
    private final VeterinarioPersistenceMapper veterinarioPersistenceMapper;

    public AgendamentoEntity toEntity(Agendamento agendamento) {
        return AgendamentoEntity.builder()
                .idAgendamento(agendamento.getIdAgendamento())
                .pet(petPersistenceMapper.toEntity(agendamento.getPet()))
                .veterinario(veterinarioPersistenceMapper.toEntity(agendamento.getVeterinario()))
                .dataHora(agendamento.getDataHora())
                .motivoConsulta(agendamento.getMotivoConsulta())
                .status(agendamento.getStatus())
                .build();
    }

    public Agendamento toDomain(AgendamentoEntity entity) {
        return Agendamento.builder()
                .idAgendamento(entity.getIdAgendamento())
                .pet(petPersistenceMapper.toDomain(entity.getPet()))
                .veterinario(veterinarioPersistenceMapper.toDomain(entity.getVeterinario()))
                .dataHora(entity.getDataHora())
                .motivoConsulta(entity.getMotivoConsulta())
                .status(entity.getStatus())
                .build();
    }
}
