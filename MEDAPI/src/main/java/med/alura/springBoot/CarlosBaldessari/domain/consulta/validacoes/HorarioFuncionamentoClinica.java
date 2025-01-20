package med.alura.springBoot.CarlosBaldessari.domain.consulta.validacoes;

import med.alura.springBoot.CarlosBaldessari.domain.ValidacaoException;
import med.alura.springBoot.CarlosBaldessari.domain.consulta.DadosAgendamentoConsultaDTO;

import java.time.DayOfWeek;

public class HorarioFuncionamentoClinica {
    public void validar(DadosAgendamentoConsultaDTO dadosAgendamentoConsultaDTO){
        var dataConsulta = dadosAgendamentoConsultaDTO.data();

        var domingo= dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);

        var aberturaClinica = dataConsulta.atStartOfDay().getHour() < 7;

        var fechamentoClinica= dataConsulta.atStartOfDay().getHour()>18;
        if (domingo || aberturaClinica || fechamentoClinica){
            throw new ValidacaoException("Consulta fora do horario");

        }

    }

}
