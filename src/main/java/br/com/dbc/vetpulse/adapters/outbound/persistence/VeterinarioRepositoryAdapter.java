package br.com.dbc.vetpulse.adapters.outbound.persistence;

import br.com.dbc.vetpulse.adapters.outbound.persistence.mapper.VeterinarioPersistenceMapper;
import br.com.dbc.vetpulse.adapters.outbound.persistence.repository.VeterinarioJpaRepository;
import br.com.dbc.vetpulse.domain.model.Veterinario;
import br.com.dbc.vetpulse.ports.outbound.VeterinarioRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class VeterinarioRepositoryAdapter implements VeterinarioRepositoryPort {

    private final VeterinarioJpaRepository veterinarioJpaRepository;
    private final VeterinarioPersistenceMapper mapper;

    @Override
    public Veterinario salvar(Veterinario veterinario) {
        return mapper.toDomain(veterinarioJpaRepository.save(mapper.toEntity(veterinario)));
    }

    @Override
    public List<Veterinario> listar() {
        return veterinarioJpaRepository.findAll()
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public Optional<Veterinario> buscarPorId(Integer idVeterinario) {
        return veterinarioJpaRepository.findById(idVeterinario)
                .map(mapper::toDomain);
    }

    @Override
    public void deletar(Integer idVeterinario) {
        veterinarioJpaRepository.deleteById(idVeterinario);
    }
}
