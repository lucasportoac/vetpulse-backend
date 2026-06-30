package br.com.dbc.vetpulse.adapters.inbound.dto;

import br.com.dbc.vetpulse.domain.model.Agendamento;
import br.com.dbc.vetpulse.domain.model.Pet;
import br.com.dbc.vetpulse.domain.model.Veterinario;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AgendamentoMapper {

    private final PetMapper petMapper;
    private final VeterinarioMapper veterinarioMapper;

    public Agendamento toDomain(AgendamentoCreateDTO dto) {
        return Agendamento.builder()
                .pet(Pet.builder()
                        .idPet(dto.getIdPet())
                        .build())
                .veterinario(Veterinario.builder()
                        .idVeterinario(dto.getIdVeterinario())
                        .build())
                .dataHora(dto.getDataHora())
                .motivoConsulta(dto.getMotivoConsulta())
                .build();
    }

    public AgendamentoDTO toDTO(Agendamento agendamento) {
        AgendamentoDTO dto = new AgendamentoDTO();
        dto.setIdAgendamento(agendamento.getIdAgendamento());
        dto.setPet(petMapper.toDTO(agendamento.getPet()));
        dto.setVeterinario(veterinarioMapper.toDTO(agendamento.getVeterinario()));
        dto.setDataHora(agendamento.getDataHora());
        dto.setMotivoConsulta(agendamento.getMotivoConsulta());
        dto.setStatus(agendamento.getStatus());
        return dto;
    }
}
