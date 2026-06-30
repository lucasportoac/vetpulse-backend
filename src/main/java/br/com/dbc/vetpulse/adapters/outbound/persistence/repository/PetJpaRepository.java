package br.com.dbc.vetpulse.adapters.outbound.persistence.repository;

import br.com.dbc.vetpulse.adapters.outbound.persistence.entity.PetEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetJpaRepository extends JpaRepository<PetEntity, Integer> {
}
