package br.com.dbc.vetpulse.adapters.outbound.persistence.mapper;

import br.com.dbc.vetpulse.adapters.outbound.persistence.entity.VeterinarioEntity;
import br.com.dbc.vetpulse.domain.model.Veterinario;
import org.springframework.stereotype.Component;

@Component
public class VeterinarioPersistenceMapper {

    public VeterinarioEntity toEntity(Veterinario veterinario) {
        return VeterinarioEntity.builder()
                .idVeterinario(veterinario.getIdVeterinario())
                .nome(veterinario.getNome())
                .email(veterinario.getEmail())
                .crmv(veterinario.getCrmv())
                .especialidade(veterinario.getEspecialidade())
                .telefone(veterinario.getTelefone())
                .build();
    }

    public Veterinario toDomain(VeterinarioEntity entity) {
        return Veterinario.builder()
                .idVeterinario(entity.getIdVeterinario())
                .nome(entity.getNome())
                .email(entity.getEmail())
                .crmv(entity.getCrmv())
                .especialidade(entity.getEspecialidade())
                .telefone(entity.getTelefone())
                .build();
    }
}
