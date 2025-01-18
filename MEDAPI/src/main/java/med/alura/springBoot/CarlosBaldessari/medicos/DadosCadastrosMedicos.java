package med.alura.springBoot.CarlosBaldessari.medicos;

import med.alura.springBoot.CarlosBaldessari.endereco.DadosEndereco;

public record DadosCadastrosMedicos(
        String nome,
        String email,
        String crm,
        Especialidade especialidade,
        DadosEndereco endereco) {

}
