package br.com.dbc.vetpulse.adapters.outbound.persistence;

import br.com.dbc.vetpulse.adapters.outbound.persistence.mapper.PetPersistenceMapper;
import br.com.dbc.vetpulse.adapters.outbound.persistence.repository.PetJpaRepository;
import br.com.dbc.vetpulse.domain.model.Pet;
import br.com.dbc.vetpulse.ports.outbound.PetRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PetRepositoryAdapter implements PetRepositoryPort {

    private final PetJpaRepository petJpaRepository;
    private final PetPersistenceMapper mapper;

    @Override
    public Pet salvar(Pet pet) {
        return mapper.toDomain(petJpaRepository.save(mapper.toEntity(pet)));
    }

    @Override
    public List<Pet> listar() {
        return petJpaRepository.findAll()
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public Optional<Pet> buscarPorId(Integer idPet) {
        return petJpaRepository.findById(idPet)
                .map(mapper::toDomain);
    }

    @Override
    public void deletar(Integer idPet) {
        petJpaRepository.deleteById(idPet);
    }
}
