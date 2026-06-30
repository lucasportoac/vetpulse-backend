package br.com.dbc.vetpulse.ports.inbound;

import br.com.dbc.vetpulse.domain.model.Veterinario;

import java.util.List;

public interface VeterinarioUseCase {

    Veterinario criar(Veterinario veterinario);

    List<Veterinario> listar();

    Veterinario buscarPorId(Integer idVeterinario);

    Veterinario atualizar(Integer idVeterinario, Veterinario veterinario);

    void deletar(Integer idVeterinario);
}
