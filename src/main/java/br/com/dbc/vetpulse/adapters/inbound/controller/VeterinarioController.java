package br.com.dbc.vetpulse.adapters.inbound.controller;

import br.com.dbc.vetpulse.adapters.inbound.dto.VeterinarioCreateDTO;
import br.com.dbc.vetpulse.adapters.inbound.dto.VeterinarioDTO;
import br.com.dbc.vetpulse.adapters.inbound.dto.VeterinarioMapper;
import br.com.dbc.vetpulse.ports.inbound.VeterinarioUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veterinarios")
@RequiredArgsConstructor
public class VeterinarioController {

    private final VeterinarioUseCase veterinarioUseCase;
    private final VeterinarioMapper mapper;

    @PostMapping
    public VeterinarioDTO criar(@Valid @RequestBody VeterinarioCreateDTO veterinarioCreateDTO) {
        return mapper.toDTO(veterinarioUseCase.criar(mapper.toDomain(veterinarioCreateDTO)));
    }

    @GetMapping
    public List<VeterinarioDTO> listar() {
        return veterinarioUseCase.listar()
                .stream()
                .map(mapper::toDTO)
                .toList();
    }

    @GetMapping("/{idVeterinario}")
    public VeterinarioDTO buscarPorId(@PathVariable Integer idVeterinario) {
        return mapper.toDTO(veterinarioUseCase.buscarPorId(idVeterinario));
    }

    @PutMapping("/{idVeterinario}")
    public VeterinarioDTO atualizar(@PathVariable Integer idVeterinario,
                                    @Valid @RequestBody VeterinarioCreateDTO veterinarioCreateDTO) {
        return mapper.toDTO(veterinarioUseCase.atualizar(idVeterinario, mapper.toDomain(veterinarioCreateDTO)));
    }

    @DeleteMapping("/{idVeterinario}")
    public void deletar(@PathVariable Integer idVeterinario) {
        veterinarioUseCase.deletar(idVeterinario);
    }
}
