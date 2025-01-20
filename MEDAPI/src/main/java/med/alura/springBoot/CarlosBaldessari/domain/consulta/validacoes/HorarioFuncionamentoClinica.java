package med.alura.springBoot.CarlosBaldessari.domain.consulta.validacoes;

import med.alura.springBoot.CarlosBaldessari.domain.ValidacaoException;
import med.alura.springBoot.CarlosBaldessari.domain.consulta.DadosAgendamentoConsultaDTO;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class HorarioFuncionamentoClinica implements  ValidadorAgendamentoConsulta{
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
