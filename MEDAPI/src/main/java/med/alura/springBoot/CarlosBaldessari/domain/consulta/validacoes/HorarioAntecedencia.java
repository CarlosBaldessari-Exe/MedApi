package med.alura.springBoot.CarlosBaldessari.domain.consulta.validacoes;


import med.alura.springBoot.CarlosBaldessari.domain.ValidacaoException;
import med.alura.springBoot.CarlosBaldessari.domain.consulta.DadosAgendamentoConsultaDTO;

import java.time.Duration;
import java.time.LocalTime;

public class HorarioAntecedencia {
public void  validar(DadosAgendamentoConsultaDTO dadosAgendamentoConsultaDTO){
    var dataConsulta= dadosAgendamentoConsultaDTO.data();
    var agora= LocalTime.now();
    var difEnMinutos = Duration.between(agora, dataConsulta).toMinutes();
    if (difEnMinutos < 30 ){
        throw new ValidacaoException("La consulta debe ser agendada con 30 min de antelacion");
    }
}
}
