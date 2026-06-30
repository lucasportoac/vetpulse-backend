package br.com.dbc.vetpulse.application.usecase;

import br.com.dbc.vetpulse.domain.exception.ResourceNotFoundException;
import br.com.dbc.vetpulse.domain.model.Agendamento;
import br.com.dbc.vetpulse.domain.model.Pet;
import br.com.dbc.vetpulse.domain.model.StatusAgendamento;
import br.com.dbc.vetpulse.domain.model.Veterinario;
import br.com.dbc.vetpulse.ports.inbound.AgendamentoUseCase;
import br.com.dbc.vetpulse.ports.outbound.AgendamentoRepositoryPort;
import br.com.dbc.vetpulse.ports.outbound.PetRepositoryPort;
import br.com.dbc.vetpulse.ports.outbound.VeterinarioRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AgendamentoUseCaseImpl implements AgendamentoUseCase {

    private final AgendamentoRepositoryPort agendamentoRepositoryPort;
    private final PetRepositoryPort petRepositoryPort;
    private final VeterinarioRepositoryPort veterinarioRepositoryPort;

    @Override
    public Agendamento criar(Agendamento agendamento) {
        Pet pet = petRepositoryPort.buscarPorId(agendamento.getPet().getIdPet())
                .orElseThrow(() -> new ResourceNotFoundException("Pet não encontrado."));

        Veterinario veterinario = veterinarioRepositoryPort.buscarPorId(agendamento.getVeterinario().getIdVeterinario())
                .orElseThrow(() -> new ResourceNotFoundException("Veterinário não encontrado."));

        boolean horarioOcupado = agendamentoRepositoryPort.existeAgendamentoNoHorario(
                veterinario.getIdVeterinario(),
                agendamento.getDataHora()
        );

        if (horarioOcupado) {
            throw new IllegalArgumentException("Já existe agendamento para este veterinário neste horário.");
        }

        agendamento.setPet(pet);
        agendamento.setVeterinario(veterinario);
        agendamento.setStatus(StatusAgendamento.AGENDADO);

        return agendamentoRepositoryPort.salvar(agendamento);
    }

    @Override
    public List<Agendamento> listar() {
        return agendamentoRepositoryPort.listar();
    }

    @Override
    public Agendamento buscarPorId(Integer idAgendamento) {
        return agendamentoRepositoryPort.buscarPorId(idAgendamento)
                .orElseThrow(() -> new ResourceNotFoundException("Agendamento não encontrado."));
    }

    @Override
    public Agendamento cancelar(Integer idAgendamento) {
        Agendamento agendamento = buscarPorId(idAgendamento);
        agendamento.setStatus(StatusAgendamento.CANCELADO);
        return agendamentoRepositoryPort.salvar(agendamento);
    }

    @Override
    public void deletar(Integer idAgendamento) {
        buscarPorId(idAgendamento);
        agendamentoRepositoryPort.deletar(idAgendamento);
    }
}
