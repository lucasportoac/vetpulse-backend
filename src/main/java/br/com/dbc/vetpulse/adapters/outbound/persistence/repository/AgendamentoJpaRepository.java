package br.com.dbc.vetpulse.adapters.outbound.persistence.repository;

import br.com.dbc.vetpulse.adapters.outbound.persistence.entity.AgendamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface AgendamentoJpaRepository extends JpaRepository<AgendamentoEntity, Integer> {

    boolean existsByVeterinarioIdVeterinarioAndDataHora(Integer idVeterinario, LocalDateTime dataHora);
}
