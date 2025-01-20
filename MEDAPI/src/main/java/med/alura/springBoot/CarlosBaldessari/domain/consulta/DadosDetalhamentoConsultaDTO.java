package med.alura.springBoot.CarlosBaldessari.domain.consulta;

import java.time.LocalDate;

public record DadosDetalhamentoConsultaDTO(Long id, Long idMedico, Long idPaciente, LocalDate data) {
}
