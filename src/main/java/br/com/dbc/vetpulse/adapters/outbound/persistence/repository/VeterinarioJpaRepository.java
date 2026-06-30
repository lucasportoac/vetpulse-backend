package br.com.dbc.vetpulse.adapters.outbound.persistence.repository;

import br.com.dbc.vetpulse.adapters.outbound.persistence.entity.VeterinarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeterinarioJpaRepository extends JpaRepository<VeterinarioEntity, Integer> {
}
