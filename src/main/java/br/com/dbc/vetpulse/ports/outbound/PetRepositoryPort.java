package br.com.dbc.vetpulse.ports.outbound;

import br.com.dbc.vetpulse.domain.model.Pet;

import java.util.List;
import java.util.Optional;

public interface PetRepositoryPort {

    Pet salvar(Pet pet);

    List<Pet> listar();

    Optional<Pet> buscarPorId(Integer idPet);

    void deletar(Integer idPet);
}
