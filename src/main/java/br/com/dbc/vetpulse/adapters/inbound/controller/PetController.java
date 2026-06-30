package br.com.dbc.vetpulse.adapters.inbound.controller;

import br.com.dbc.vetpulse.adapters.inbound.dto.PetCreateDTO;
import br.com.dbc.vetpulse.adapters.inbound.dto.PetDTO;
import br.com.dbc.vetpulse.adapters.inbound.dto.PetMapper;
import br.com.dbc.vetpulse.ports.inbound.PetUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets")
@RequiredArgsConstructor
public class PetController {

    private final PetUseCase petUseCase;
    private final PetMapper mapper;

    @PostMapping
    public PetDTO criar(@Valid @RequestBody PetCreateDTO petCreateDTO) {
        return mapper.toDTO(petUseCase.criar(mapper.toDomain(petCreateDTO)));
    }

    @GetMapping
    public List<PetDTO> listar() {
        return petUseCase.listar()
                .stream()
                .map(mapper::toDTO)
                .toList();
    }

    @GetMapping("/{idPet}")
    public PetDTO buscarPorId(@PathVariable Integer idPet) {
        return mapper.toDTO(petUseCase.buscarPorId(idPet));
    }

    @PutMapping("/{idPet}")
    public PetDTO atualizar(@PathVariable Integer idPet,
                            @Valid @RequestBody PetCreateDTO petCreateDTO) {
        return mapper.toDTO(petUseCase.atualizar(idPet, mapper.toDomain(petCreateDTO)));
    }

    @DeleteMapping("/{idPet}")
    public void deletar(@PathVariable Integer idPet) {
        petUseCase.deletar(idPet);
    }
}
