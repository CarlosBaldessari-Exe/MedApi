package med.alura.springBoot.CarlosBaldessari.medicos;

import med.alura.springBoot.CarlosBaldessari.endereco.DadosEnderecoDTO;

public record DadosCadastrosMedicosDTO(
        String nome,
        String email,
        String crm,
        Especialidade especialidade,
        DadosEnderecoDTO endereco) {

}
