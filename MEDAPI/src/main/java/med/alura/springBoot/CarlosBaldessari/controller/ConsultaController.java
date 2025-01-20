package med.alura.springBoot.CarlosBaldessari.controller;


import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.alura.springBoot.CarlosBaldessari.consulta.DadosCancelamentoConsultaDTO;
import med.alura.springBoot.CarlosBaldessari.domain.consulta.AgendaConsultas;
import med.alura.springBoot.CarlosBaldessari.domain.consulta.DadosAgendamentoConsultaDTO;
import med.alura.springBoot.CarlosBaldessari.domain.consulta.DadosDetalhamentoConsultaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.sound.midi.Soundbank;

@RestController
@RequestMapping("consultas")
public class ConsultaController {

    @Autowired
    private AgendaConsultas agendaConsultas;

    @PostMapping
    @Transactional
    public ResponseEntity agendar (@RequestBody @Valid DadosAgendamentoConsultaDTO dadosAgendamentoConsulta){
        System.out.println(dadosAgendamentoConsulta);

        agendaConsultas.agendar(dadosAgendamentoConsulta);
        return ResponseEntity.ok(new DadosDetalhamentoConsultaDTO(null, null, null, null));
    }
    @DeleteMapping
    @Transactional
    public ResponseEntity cancelarConsulta (@RequestBody @Valid DadosCancelamentoConsultaDTO dadosCancelamentoConsulta){
        System.out.println(dadosCancelamentoConsulta);
        agendaConsultas.cancelar(dadosCancelamentoConsulta);
        return  ResponseEntity.noContent().build();

    }
}
