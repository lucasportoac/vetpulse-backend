package br.com.dbc.vetpulse.adapters.inbound.dto;

import br.com.dbc.vetpulse.domain.model.Veterinario;
import org.springframework.stereotype.Component;

@Component
public class VeterinarioMapper {

    public Veterinario toDomain(VeterinarioCreateDTO dto) {
        return Veterinario.builder()
                .nome(dto.getNome())
                .email(dto.getEmail())
                .crmv(dto.getCrmv())
                .especialidade(dto.getEspecialidade())
                .telefone(dto.getTelefone())
                .build();
    }

    public VeterinarioDTO toDTO(Veterinario veterinario) {
        VeterinarioDTO dto = new VeterinarioDTO();
        dto.setIdVeterinario(veterinario.getIdVeterinario());
        dto.setNome(veterinario.getNome());
        dto.setEmail(veterinario.getEmail());
        dto.setCrmv(veterinario.getCrmv());
        dto.setEspecialidade(veterinario.getEspecialidade());
        dto.setTelefone(veterinario.getTelefone());
        return dto;
    }
}
