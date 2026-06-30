package br.com.dbc.vetpulse.ports.inbound;

import br.com.dbc.vetpulse.domain.model.Tutor;

import java.util.List;

public interface TutorUseCase {

    Tutor criar(Tutor tutor);

    List<Tutor> listar();

    Tutor buscarPorId(Integer idTutor);

    Tutor atualizar(Integer idTutor, Tutor tutor);

    void deletar(Integer idTutor);
}
