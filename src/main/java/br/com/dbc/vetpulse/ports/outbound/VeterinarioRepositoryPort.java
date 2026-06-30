package br.com.dbc.vetpulse.ports.outbound;

import br.com.dbc.vetpulse.domain.model.Veterinario;

import java.util.List;
import java.util.Optional;

public interface VeterinarioRepositoryPort {

    Veterinario salvar(Veterinario veterinario);

    List<Veterinario> listar();

    Optional<Veterinario> buscarPorId(Integer idVeterinario);

    void deletar(Integer idVeterinario);
}
