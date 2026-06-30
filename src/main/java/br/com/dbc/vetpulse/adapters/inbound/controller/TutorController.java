package br.com.dbc.vetpulse.adapters.inbound.controller;

import br.com.dbc.vetpulse.adapters.inbound.dto.TutorCreateDTO;
import br.com.dbc.vetpulse.adapters.inbound.dto.TutorDTO;
import br.com.dbc.vetpulse.adapters.inbound.dto.TutorMapper;
import br.com.dbc.vetpulse.ports.inbound.TutorUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tutores")
@RequiredArgsConstructor
public class TutorController {

    private final TutorUseCase tutorUseCase;
    private final TutorMapper mapper;

    @PostMapping
    public TutorDTO criar(@Valid @RequestBody TutorCreateDTO tutorCreateDTO) {
        return mapper.toDTO(tutorUseCase.criar(mapper.toDomain(tutorCreateDTO)));
    }

    @GetMapping
    public List<TutorDTO> listar() {
        return tutorUseCase.listar()
                .stream()
                .map(mapper::toDTO)
                .toList();
    }

    @GetMapping("/{idTutor}")
    public TutorDTO buscarPorId(@PathVariable Integer idTutor) {
        return mapper.toDTO(tutorUseCase.buscarPorId(idTutor));
    }

    @PutMapping("/{idTutor}")
    public TutorDTO atualizar(@PathVariable Integer idTutor,
                              @Valid @RequestBody TutorCreateDTO tutorCreateDTO) {
        return mapper.toDTO(tutorUseCase.atualizar(idTutor, mapper.toDomain(tutorCreateDTO)));
    }

    @DeleteMapping("/{idTutor}")
    public void deletar(@PathVariable Integer idTutor) {
        tutorUseCase.deletar(idTutor);
    }
}
