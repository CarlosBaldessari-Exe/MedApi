package med.alura.springBoot.CarlosBaldessari.paciente;

import med.alura.springBoot.CarlosBaldessari.endereco.DadosEndereco;

public record DadosCadastradosPacientes(String nome,
                                        String email,
                                        String telefone,
                                        String cpf,
                                        DadosEndereco dados) {
}
