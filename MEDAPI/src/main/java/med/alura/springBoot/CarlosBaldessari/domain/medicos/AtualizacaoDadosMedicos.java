package med.alura.springBoot.CarlosBaldessari.domain.medicos;

import jakarta.validation.constraints.NotNull;
import med.alura.springBoot.CarlosBaldessari.domain.endereco.DadosEnderecoDTO;

public record AtualizacaoDadosMedicos(
        @NotNull Long id,
        String nome,
        String telefone,
        String email,
        DadosEnderecoDTO endereco) {
}
