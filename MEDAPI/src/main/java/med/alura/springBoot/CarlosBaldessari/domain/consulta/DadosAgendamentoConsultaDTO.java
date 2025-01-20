package med.alura.springBoot.CarlosBaldessari.domain.consulta;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import med.alura.springBoot.CarlosBaldessari.domain.medicos.Especialidade;

import java.time.LocalDate;

public record DadosAgendamentoConsultaDTO(
        Long idMedico,
        @NotNull
        Long idPaciente,
        @NotNull
        @Future
        LocalDate data

        ,Especialidade especialidade
) {
}
