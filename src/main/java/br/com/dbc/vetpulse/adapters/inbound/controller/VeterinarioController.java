package br.com.dbc.vetpulse.adapters.inbound.controller;

import br.com.dbc.vetpulse.adapters.inbound.dto.VeterinarioCreateDTO;
import br.com.dbc.vetpulse.adapters.inbound.dto.VeterinarioDTO;
import br.com.dbc.vetpulse.adapters.inbound.dto.VeterinarioMapper;
import br.com.dbc.vetpulse.ports.inbound.VeterinarioUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veterinarios")
@RequiredArgsConstructor
public class VeterinarioController {

    private final VeterinarioUseCase veterinarioUseCase;
    private final VeterinarioMapper mapper;

    @PostMapping
    public ResponseEntity<VeterinarioDTO> criar(@Valid @RequestBody VeterinarioCreateDTO veterinarioCreateDTO) {
        VeterinarioDTO veterinarioDTO = mapper.toDTO(veterinarioUseCase.criar(mapper.toDomain(veterinarioCreateDTO)));
        return ResponseEntity.status(HttpStatus.CREATED).body(veterinarioDTO);
    }

    @GetMapping
    public ResponseEntity<List<VeterinarioDTO>> listar() {
        List<VeterinarioDTO> veterinarios = veterinarioUseCase.listar()
                .stream()
                .map(mapper::toDTO)
                .toList();

        return ResponseEntity.ok(veterinarios);
    }

    @GetMapping("/{idVeterinario}")
    public ResponseEntity<VeterinarioDTO> buscarPorId(@PathVariable Integer idVeterinario) {
        return ResponseEntity.ok(mapper.toDTO(veterinarioUseCase.buscarPorId(idVeterinario)));
    }

    @PutMapping("/{idVeterinario}")
    public ResponseEntity<VeterinarioDTO> atualizar(@PathVariable Integer idVeterinario,
                                                    @Valid @RequestBody VeterinarioCreateDTO veterinarioCreateDTO) {
        VeterinarioDTO veterinarioDTO = mapper.toDTO(
                veterinarioUseCase.atualizar(idVeterinario, mapper.toDomain(veterinarioCreateDTO))
        );

        return ResponseEntity.ok(veterinarioDTO);
    }

    @DeleteMapping("/{idVeterinario}")
    public ResponseEntity<Void> deletar(@PathVariable Integer idVeterinario) {
        veterinarioUseCase.deletar(idVeterinario);
        return ResponseEntity.noContent().build();
    }
}
