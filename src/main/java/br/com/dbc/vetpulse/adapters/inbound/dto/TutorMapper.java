package br.com.dbc.vetpulse.adapters.inbound.dto;

import br.com.dbc.vetpulse.domain.model.Tutor;
import org.springframework.stereotype.Component;

@Component
public class TutorMapper {

    public Tutor toDomain(TutorCreateDTO dto) {
        return Tutor.builder()
                .nome(dto.getNome())
                .email(dto.getEmail())
                .cpf(dto.getCpf())
                .telefone(dto.getTelefone())
                .build();
    }

    public TutorDTO toDTO(Tutor tutor) {
        TutorDTO dto = new TutorDTO();
        dto.setIdTutor(tutor.getIdTutor());
        dto.setNome(tutor.getNome());
        dto.setEmail(tutor.getEmail());
        dto.setCpf(tutor.getCpf());
        dto.setTelefone(tutor.getTelefone());
        return dto;
    }
}
