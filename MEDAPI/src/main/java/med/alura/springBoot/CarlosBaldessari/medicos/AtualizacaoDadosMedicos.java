package med.alura.springBoot.CarlosBaldessari.medicos;

import jakarta.validation.constraints.NotNull;
import med.alura.springBoot.CarlosBaldessari.endereco.DadosEnderecoDTO;

public record AtualizacaoDadosMedicos(
        @NotNull Long id,
        String nome,
        String telefone,
        String email,
        DadosEnderecoDTO endereco) {
}
