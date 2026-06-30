package br.com.dbc.vetpulse.adapters.outbound.persistence.mapper;

import br.com.dbc.vetpulse.adapters.outbound.persistence.entity.PetEntity;
import br.com.dbc.vetpulse.domain.model.Pet;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PetPersistenceMapper {

    private final TutorPersistenceMapper tutorPersistenceMapper;

    public PetEntity toEntity(Pet pet) {
        return PetEntity.builder()
                .idPet(pet.getIdPet())
                .nome(pet.getNome())
                .especie(pet.getEspecie())
                .raca(pet.getRaca())
                .idade(pet.getIdade())
                .sexo(pet.getSexo())
                .tutor(tutorPersistenceMapper.toEntity(pet.getTutor()))
                .build();
    }

    public Pet toDomain(PetEntity entity) {
        return Pet.builder()
                .idPet(entity.getIdPet())
                .nome(entity.getNome())
                .especie(entity.getEspecie())
                .raca(entity.getRaca())
                .idade(entity.getIdade())
                .sexo(entity.getSexo())
                .tutor(tutorPersistenceMapper.toDomain(entity.getTutor()))
                .build();
    }
}
