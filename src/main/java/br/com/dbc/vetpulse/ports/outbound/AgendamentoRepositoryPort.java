package br.com.dbc.vetpulse.ports.outbound;

import br.com.dbc.vetpulse.domain.model.Agendamento;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface AgendamentoRepositoryPort {

    Agendamento salvar(Agendamento agendamento);

    List<Agendamento> listar();

    Optional<Agendamento> buscarPorId(Integer idAgendamento);

    boolean existeAgendamentoNoHorario(Integer idVeterinario, LocalDateTime dataHora);

    void deletar(Integer idAgendamento);
}
