package br.com.dbc.vetpulse.ports.inbound;

import br.com.dbc.vetpulse.domain.model.Agendamento;

import java.util.List;

public interface AgendamentoUseCase {

    Agendamento criar(Agendamento agendamento);

    List<Agendamento> listar();

    Agendamento buscarPorId(Integer idAgendamento);

    Agendamento cancelar(Integer idAgendamento);

    void deletar(Integer idAgendamento);
}
