package br.com.dbc.vetpulse.adapters.outbound.persistence;

import br.com.dbc.vetpulse.adapters.outbound.persistence.mapper.TutorPersistenceMapper;
import br.com.dbc.vetpulse.adapters.outbound.persistence.repository.TutorJpaRepository;
import br.com.dbc.vetpulse.domain.model.Tutor;
import br.com.dbc.vetpulse.ports.outbound.TutorRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class TutorRepositoryAdapter implements TutorRepositoryPort {

    private final TutorJpaRepository tutorJpaRepository;
    private final TutorPersistenceMapper mapper;

    @Override
    public Tutor salvar(Tutor tutor) {
        return mapper.toDomain(tutorJpaRepository.save(mapper.toEntity(tutor)));
    }

    @Override
    public List<Tutor> listar() {
        return tutorJpaRepository.findAll()
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public Optional<Tutor> buscarPorId(Integer idTutor) {
        return tutorJpaRepository.findById(idTutor)
                .map(mapper::toDomain);
    }

    @Override
    public void deletar(Integer idTutor) {
        tutorJpaRepository.deleteById(idTutor);
    }
}
