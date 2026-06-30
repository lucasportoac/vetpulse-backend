package br.com.dbc.vetpulse.ports.inbound;

import br.com.dbc.vetpulse.domain.model.Pet;

import java.util.List;

public interface PetUseCase {

    Pet criar(Pet pet);

    List<Pet> listar();

    Pet buscarPorId(Integer idPet);

    Pet atualizar(Integer idPet, Pet pet);

    void deletar(Integer idPet);
}
