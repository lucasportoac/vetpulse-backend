package br.com.dbc.vetpulse.adapters.inbound.controller;

import br.com.dbc.vetpulse.adapters.inbound.dto.PetCreateDTO;
import br.com.dbc.vetpulse.adapters.inbound.dto.PetDTO;
import br.com.dbc.vetpulse.adapters.inbound.dto.PetMapper;
import br.com.dbc.vetpulse.ports.inbound.PetUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets")
@RequiredArgsConstructor
public class PetController {

    private final PetUseCase petUseCase;
    private final PetMapper mapper;

    @PostMapping
    public ResponseEntity<PetDTO> criar(@Valid @RequestBody PetCreateDTO petCreateDTO) {
        PetDTO petDTO = mapper.toDTO(petUseCase.criar(mapper.toDomain(petCreateDTO)));
        return ResponseEntity.status(HttpStatus.CREATED).body(petDTO);
    }

    @GetMapping
    public ResponseEntity<List<PetDTO>> listar() {
        List<PetDTO> pets = petUseCase.listar()
                .stream()
                .map(mapper::toDTO)
                .toList();

        return ResponseEntity.ok(pets);
    }

    @GetMapping("/{idPet}")
    public ResponseEntity<PetDTO> buscarPorId(@PathVariable Integer idPet) {
        return ResponseEntity.ok(mapper.toDTO(petUseCase.buscarPorId(idPet)));
    }

    @PutMapping("/{idPet}")
    public ResponseEntity<PetDTO> atualizar(@PathVariable Integer idPet,
                                            @Valid @RequestBody PetCreateDTO petCreateDTO) {
        PetDTO petDTO = mapper.toDTO(petUseCase.atualizar(idPet, mapper.toDomain(petCreateDTO)));
        return ResponseEntity.ok(petDTO);
    }

    @DeleteMapping("/{idPet}")
    public ResponseEntity<Void> deletar(@PathVariable Integer idPet) {
        petUseCase.deletar(idPet);
        return ResponseEntity.noContent().build();
    }
}
