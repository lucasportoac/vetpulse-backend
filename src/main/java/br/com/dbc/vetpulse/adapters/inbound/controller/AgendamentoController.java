package br.com.dbc.vetpulse.adapters.inbound.controller;

import br.com.dbc.vetpulse.adapters.inbound.dto.AgendamentoCreateDTO;
import br.com.dbc.vetpulse.adapters.inbound.dto.AgendamentoDTO;
import br.com.dbc.vetpulse.adapters.inbound.dto.AgendamentoMapper;
import br.com.dbc.vetpulse.ports.inbound.AgendamentoUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agendamentos")
@RequiredArgsConstructor
public class AgendamentoController {

    private final AgendamentoUseCase agendamentoUseCase;
    private final AgendamentoMapper mapper;

    @PostMapping
    public ResponseEntity<AgendamentoDTO> criar(@Valid @RequestBody AgendamentoCreateDTO agendamentoCreateDTO) {
        AgendamentoDTO agendamentoDTO = mapper.toDTO(
                agendamentoUseCase.criar(mapper.toDomain(agendamentoCreateDTO))
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(agendamentoDTO);
    }

    @GetMapping
    public ResponseEntity<List<AgendamentoDTO>> listar() {
        List<AgendamentoDTO> agendamentos = agendamentoUseCase.listar()
                .stream()
                .map(mapper::toDTO)
                .toList();

        return ResponseEntity.ok(agendamentos);
    }

    @GetMapping("/{idAgendamento}")
    public ResponseEntity<AgendamentoDTO> buscarPorId(@PathVariable Integer idAgendamento) {
        return ResponseEntity.ok(mapper.toDTO(agendamentoUseCase.buscarPorId(idAgendamento)));
    }

    @PatchMapping("/{idAgendamento}/cancelar")
    public ResponseEntity<AgendamentoDTO> cancelar(@PathVariable Integer idAgendamento) {
        return ResponseEntity.ok(mapper.toDTO(agendamentoUseCase.cancelar(idAgendamento)));
    }

    @DeleteMapping("/{idAgendamento}")
    public ResponseEntity<Void> deletar(@PathVariable Integer idAgendamento) {
        agendamentoUseCase.deletar(idAgendamento);
        return ResponseEntity.noContent().build();
    }
}
