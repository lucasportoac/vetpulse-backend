package br.com.dbc.vetpulse.adapters.outbound.persistence;

import br.com.dbc.vetpulse.adapters.outbound.persistence.mapper.AgendamentoPersistenceMapper;
import br.com.dbc.vetpulse.adapters.outbound.persistence.repository.AgendamentoJpaRepository;
import br.com.dbc.vetpulse.domain.model.Agendamento;
import br.com.dbc.vetpulse.ports.outbound.AgendamentoRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AgendamentoRepositoryAdapter implements AgendamentoRepositoryPort {

    private final AgendamentoJpaRepository agendamentoJpaRepository;
    private final AgendamentoPersistenceMapper mapper;

    @Override
    public Agendamento salvar(Agendamento agendamento) {
        return mapper.toDomain(agendamentoJpaRepository.save(mapper.toEntity(agendamento)));
    }

    @Override
    public List<Agendamento> listar() {
        return agendamentoJpaRepository.findAll()
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public Optional<Agendamento> buscarPorId(Integer idAgendamento) {
        return agendamentoJpaRepository.findById(idAgendamento)
                .map(mapper::toDomain);
    }

    @Override
    public boolean existeAgendamentoNoHorario(Integer idVeterinario, LocalDateTime dataHora) {
        return agendamentoJpaRepository.existsByVeterinarioIdVeterinarioAndDataHora(idVeterinario, dataHora);
    }

    @Override
    public void deletar(Integer idAgendamento) {
        agendamentoJpaRepository.deleteById(idAgendamento);
    }
}
