package br.com.dbc.vetpulse.adapters.inbound.controller;

import br.com.dbc.vetpulse.adapters.inbound.dto.AgendamentoCreateDTO;
import br.com.dbc.vetpulse.adapters.inbound.dto.AgendamentoDTO;
import br.com.dbc.vetpulse.adapters.inbound.dto.AgendamentoMapper;
import br.com.dbc.vetpulse.ports.inbound.AgendamentoUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agendamentos")
@RequiredArgsConstructor
public class AgendamentoController {

    private final AgendamentoUseCase agendamentoUseCase;
    private final AgendamentoMapper mapper;

    @PostMapping
    public AgendamentoDTO criar(@Valid @RequestBody AgendamentoCreateDTO agendamentoCreateDTO) {
        return mapper.toDTO(agendamentoUseCase.criar(mapper.toDomain(agendamentoCreateDTO)));
    }

    @GetMapping
    public List<AgendamentoDTO> listar() {
        return agendamentoUseCase.listar()
                .stream()
                .map(mapper::toDTO)
                .toList();
    }

    @GetMapping("/{idAgendamento}")
    public AgendamentoDTO buscarPorId(@PathVariable Integer idAgendamento) {
        return mapper.toDTO(agendamentoUseCase.buscarPorId(idAgendamento));
    }

    @PatchMapping("/{idAgendamento}/cancelar")
    public AgendamentoDTO cancelar(@PathVariable Integer idAgendamento) {
        return mapper.toDTO(agendamentoUseCase.cancelar(idAgendamento));
    }

    @DeleteMapping("/{idAgendamento}")
    public void deletar(@PathVariable Integer idAgendamento) {
        agendamentoUseCase.deletar(idAgendamento);
    }
}
