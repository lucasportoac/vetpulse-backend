package br.com.dbc.vetpulse.adapters.outbound.persistence.repository;

import br.com.dbc.vetpulse.adapters.outbound.persistence.entity.TutorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TutorJpaRepository extends JpaRepository<TutorEntity, Integer> {
}
