package br.com.dbc.vetpulse.adapters.outbound.persistence.mapper;

import br.com.dbc.vetpulse.adapters.outbound.persistence.entity.TutorEntity;
import br.com.dbc.vetpulse.domain.model.Tutor;
import org.springframework.stereotype.Component;

@Component
public class TutorPersistenceMapper {

    public TutorEntity toEntity(Tutor tutor) {
        return TutorEntity.builder()
                .idTutor(tutor.getIdTutor())
                .nome(tutor.getNome())
                .email(tutor.getEmail())
                .cpf(tutor.getCpf())
                .telefone(tutor.getTelefone())
                .build();
    }

    public Tutor toDomain(TutorEntity entity) {
        return Tutor.builder()
                .idTutor(entity.getIdTutor())
                .nome(entity.getNome())
                .email(entity.getEmail())
                .cpf(entity.getCpf())
                .telefone(entity.getTelefone())
                .build();
    }
}
