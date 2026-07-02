package br.com.dbc.vetpulse.adapters.inbound.controller;

import br.com.dbc.vetpulse.adapters.inbound.dto.TutorCreateDTO;
import br.com.dbc.vetpulse.adapters.inbound.dto.TutorDTO;
import br.com.dbc.vetpulse.adapters.inbound.dto.TutorMapper;
import br.com.dbc.vetpulse.ports.inbound.TutorUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tutores")
@RequiredArgsConstructor
public class TutorController {

    private final TutorUseCase tutorUseCase;
    private final TutorMapper mapper;

    @PostMapping
    public ResponseEntity<TutorDTO> criar(@Valid @RequestBody TutorCreateDTO tutorCreateDTO) {
        TutorDTO tutorDTO = mapper.toDTO(tutorUseCase.criar(mapper.toDomain(tutorCreateDTO)));
        return ResponseEntity.status(HttpStatus.CREATED).body(tutorDTO);
    }

    @GetMapping
    public ResponseEntity<List<TutorDTO>> listar() {
        List<TutorDTO> tutores = tutorUseCase.listar()
                .stream()
                .map(mapper::toDTO)
                .toList();

        return ResponseEntity.ok(tutores);
    }

    @GetMapping("/{idTutor}")
    public ResponseEntity<TutorDTO> buscarPorId(@PathVariable Integer idTutor) {
        return ResponseEntity.ok(mapper.toDTO(tutorUseCase.buscarPorId(idTutor)));
    }

    @PutMapping("/{idTutor}")
    public ResponseEntity<TutorDTO> atualizar(@PathVariable Integer idTutor,
                                              @Valid @RequestBody TutorCreateDTO tutorCreateDTO) {
        TutorDTO tutorDTO = mapper.toDTO(tutorUseCase.atualizar(idTutor, mapper.toDomain(tutorCreateDTO)));
        return ResponseEntity.ok(tutorDTO);
    }

    @DeleteMapping("/{idTutor}")
    public ResponseEntity<Void> deletar(@PathVariable Integer idTutor) {
        tutorUseCase.deletar(idTutor);
        return ResponseEntity.noContent().build();
    }
}
