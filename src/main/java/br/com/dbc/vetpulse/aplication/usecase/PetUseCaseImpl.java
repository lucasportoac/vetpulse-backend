package br.com.dbc.vetpulse.application.usecase;

import br.com.dbc.vetpulse.domain.exception.ResourceNotFoundException;
import br.com.dbc.vetpulse.domain.model.Pet;
import br.com.dbc.vetpulse.domain.model.Tutor;
import br.com.dbc.vetpulse.ports.inbound.PetUseCase;
import br.com.dbc.vetpulse.ports.outbound.PetRepositoryPort;
import br.com.dbc.vetpulse.ports.outbound.TutorRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PetUseCaseImpl implements PetUseCase {

    private final PetRepositoryPort petRepositoryPort;
    private final TutorRepositoryPort tutorRepositoryPort;

    @Override
    public Pet criar(Pet pet) {
        Tutor tutor = tutorRepositoryPort.buscarPorId(pet.getTutor().getIdTutor())
                .orElseThrow(() -> new ResourceNotFoundException("Tutor não encontrado."));

        pet.setTutor(tutor);
        return petRepositoryPort.salvar(pet);
    }

    @Override
    public List<Pet> listar() {
        return petRepositoryPort.listar();
    }

    @Override
    public Pet buscarPorId(Integer idPet) {
        return petRepositoryPort.buscarPorId(idPet)
                .orElseThrow(() -> new ResourceNotFoundException("Pet não encontrado."));
    }

    @Override
    public Pet atualizar(Integer idPet, Pet pet) {
        Pet petEncontrado = buscarPorId(idPet);

        Tutor tutor = tutorRepositoryPort.buscarPorId(pet.getTutor().getIdTutor())
                .orElseThrow(() -> new ResourceNotFoundException("Tutor não encontrado."));

        petEncontrado.setNome(pet.getNome());
        petEncontrado.setEspecie(pet.getEspecie());
        petEncontrado.setRaca(pet.getRaca());
        petEncontrado.setIdade(pet.getIdade());
        petEncontrado.setSexo(pet.getSexo());
        petEncontrado.setTutor(tutor);

        return petRepositoryPort.salvar(petEncontrado);
    }

    @Override
    public void deletar(Integer idPet) {
        buscarPorId(idPet);
        petRepositoryPort.deletar(idPet);
    }
}
