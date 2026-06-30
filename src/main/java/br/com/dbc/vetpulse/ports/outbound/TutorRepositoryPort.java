package br.com.dbc.vetpulse.ports.outbound;

import br.com.dbc.vetpulse.domain.model.Tutor;

import java.util.List;
import java.util.Optional;

public interface TutorRepositoryPort {

    Tutor salvar(Tutor tutor);

    List<Tutor> listar();

    Optional<Tutor> buscarPorId(Integer idTutor);

    void deletar(Integer idTutor);
}
