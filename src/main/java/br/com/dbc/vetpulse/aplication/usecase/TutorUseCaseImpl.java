package br.com.dbc.vetpulse.application.usecase;

import br.com.dbc.vetpulse.domain.exception.ResourceNotFoundException;
import br.com.dbc.vetpulse.domain.model.Tutor;
import br.com.dbc.vetpulse.ports.inbound.TutorUseCase;
import br.com.dbc.vetpulse.ports.outbound.TutorRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TutorUseCaseImpl implements TutorUseCase {

    private final TutorRepositoryPort tutorRepositoryPort;

    @Override
    public Tutor criar(Tutor tutor) {
        return tutorRepositoryPort.salvar(tutor);
    }

    @Override
    public List<Tutor> listar() {
        return tutorRepositoryPort.listar();
    }

    @Override
    public Tutor buscarPorId(Integer idTutor) {
        return tutorRepositoryPort.buscarPorId(idTutor)
                .orElseThrow(() -> new ResourceNotFoundException("Tutor não encontrado."));
    }

    @Override
    public Tutor atualizar(Integer idTutor, Tutor tutor) {
        Tutor tutorEncontrado = buscarPorId(idTutor);

        tutorEncontrado.setNome(tutor.getNome());
        tutorEncontrado.setEmail(tutor.getEmail());
        tutorEncontrado.setCpf(tutor.getCpf());
        tutorEncontrado.setTelefone(tutor.getTelefone());

        return tutorRepositoryPort.salvar(tutorEncontrado);
    }

    @Override
    public void deletar(Integer idTutor) {
        buscarPorId(idTutor);
        tutorRepositoryPort.deletar(idTutor);
    }
}
