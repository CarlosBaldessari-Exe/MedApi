package med.alura.springBoot.CarlosBaldessari.consulta;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import med.alura.springBoot.CarlosBaldessari.domain.medicos.Especialidade;

import java.time.LocalDate;

public record DadosCancelamentoConsultaDTO(
         @NotNull
        Long idConsulta,

        @NotNull
        MotivoCancelamento motivo
) {
}
