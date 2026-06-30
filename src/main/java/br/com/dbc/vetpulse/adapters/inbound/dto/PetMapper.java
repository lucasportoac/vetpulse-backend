package br.com.dbc.vetpulse.adapters.inbound.dto;

import br.com.dbc.vetpulse.domain.model.Pet;
import br.com.dbc.vetpulse.domain.model.Tutor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PetMapper {

    private final TutorMapper tutorMapper;

    public Pet toDomain(PetCreateDTO dto) {
        return Pet.builder()
                .nome(dto.getNome())
                .especie(dto.getEspecie())
                .raca(dto.getRaca())
                .idade(dto.getIdade())
                .sexo(dto.getSexo())
                .tutor(Tutor.builder()
                        .idTutor(dto.getIdTutor())
                        .build())
                .build();
    }

    public PetDTO toDTO(Pet pet) {
        PetDTO dto = new PetDTO();
        dto.setIdPet(pet.getIdPet());
        dto.setNome(pet.getNome());
        dto.setEspecie(pet.getEspecie());
        dto.setRaca(pet.getRaca());
        dto.setIdade(pet.getIdade());
        dto.setSexo(pet.getSexo());
        dto.setTutor(tutorMapper.toDTO(pet.getTutor()));
        return dto;
    }
}
