package med.alura.springBoot.CarlosBaldessari.domain.medicos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.alura.springBoot.CarlosBaldessari.domain.endereco.DadosEnderecoDTO;

public record DadosCadastrosMedicosDTO(
        @NotBlank
        Long id,

        @NotBlank
        String nome,

        @NotBlank
        @Email
        String email,

        @NotBlank
        String telefone,

        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String crm,

        @NotNull
        Especialidade especialidade,

        @NotNull
        @Valid
        DadosEnderecoDTO endereco,

        @NotNull
        Boolean ativo) {

}
