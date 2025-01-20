package med.alura.springBoot.CarlosBaldessari.domain.consulta.validacoes;

import med.alura.springBoot.CarlosBaldessari.domain.consulta.DadosAgendamentoConsultaDTO;

public interface ValidadorAgendamentoConsulta {
    void validar(DadosAgendamentoConsultaDTO dadosAgendamentoConsultaDTO);

}
