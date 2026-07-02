package br.com.dbc.vetpulse.domain.service;

import br.com.dbc.vetpulse.domain.exception.BusinessException;
import br.com.dbc.vetpulse.domain.model.Agendamento;

import java.time.LocalDateTime;

public class AgendamentoDomainService {

    public void validarNovoAgendamento(Agendamento agendamento) {
        if (agendamento.getDataHora() == null) {
            throw new BusinessException("A data e hora do agendamento são obrigatórias.");
        }

        if (agendamento.getDataHora().isBefore(LocalDateTime.now())) {
            throw new BusinessException("Não é possível criar agendamento para uma data passada.");
        }

        if (agendamento.getPet() == null || agendamento.getPet().getIdPet() == null) {
            throw new BusinessException("O pet é obrigatório para criar um agendamento.");
        }

        if (agendamento.getVeterinario() == null || agendamento.getVeterinario().getIdVeterinario() == null) {
            throw new BusinessException("O veterinário é obrigatório para criar um agendamento.");
        }
    }

    public void validarHorarioDisponivel(boolean horarioOcupado) {
        if (horarioOcupado) {
            throw new BusinessException("Já existe agendamento para este veterinário neste horário.");
        }
    }
}
