package br.com.dbc.vetpulse.adapters.outbound.persistence.repository;

import br.com.dbc.vetpulse.adapters.outbound.persistence.entity.AgendamentoEntity;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.Optional;

public interface AgendamentoJpaRepository extends JpaRepository<AgendamentoEntity, Integer> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("""
            SELECT a
            FROM AgendamentoEntity a
            WHERE a.veterinario.idVeterinario = :idVeterinario
            AND a.dataHora = :dataHora
            """)
    Optional<AgendamentoEntity> buscarAgendamentoPorVeterinarioEDataHoraComLock(
            @Param("idVeterinario") Integer idVeterinario,
            @Param("dataHora") LocalDateTime dataHora
    );
}
