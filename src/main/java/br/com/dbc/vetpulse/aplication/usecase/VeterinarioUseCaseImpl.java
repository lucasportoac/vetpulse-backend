package br.com.dbc.vetpulse.application.usecase;

import br.com.dbc.vetpulse.domain.exception.ResourceNotFoundException;
import br.com.dbc.vetpulse.domain.model.Veterinario;
import br.com.dbc.vetpulse.ports.inbound.VeterinarioUseCase;
import br.com.dbc.vetpulse.ports.outbound.VeterinarioRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VeterinarioUseCaseImpl implements VeterinarioUseCase {

    private final VeterinarioRepositoryPort veterinarioRepositoryPort;

    @Override
    public Veterinario criar(Veterinario veterinario) {
        return veterinarioRepositoryPort.salvar(veterinario);
    }

    @Override
    public List<Veterinario> listar() {
        return veterinarioRepositoryPort.listar();
    }

    @Override
    public Veterinario buscarPorId(Integer idVeterinario) {
        return veterinarioRepositoryPort.buscarPorId(idVeterinario)
                .orElseThrow(() -> new ResourceNotFoundException("Veterinário não encontrado."));
    }

    @Override
    public Veterinario atualizar(Integer idVeterinario, Veterinario veterinario) {
        Veterinario veterinarioEncontrado = buscarPorId(idVeterinario);

        veterinarioEncontrado.setNome(veterinario.getNome());
        veterinarioEncontrado.setEmail(veterinario.getEmail());
        veterinarioEncontrado.setCrmv(veterinario.getCrmv());
        veterinarioEncontrado.setEspecialidade(veterinario.getEspecialidade());
        veterinarioEncontrado.setTelefone(veterinario.getTelefone());

        return veterinarioRepositoryPort.salvar(veterinarioEncontrado);
    }

    @Override
    public void deletar(Integer idVeterinario) {
        buscarPorId(idVeterinario);
        veterinarioRepositoryPort.deletar(idVeterinario);
    }
}
