package med.alura.springBoot.CarlosBaldessari.domain.paciente;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import med.alura.springBoot.CarlosBaldessari.domain.endereco.DadosEnderecoDTO;

public record AtualizacaoDadosPacientes(
        @NotNull Long Id,
        String nome,
        String telefone,
        @Valid DadosEnderecoDTO endereco
) {

}
