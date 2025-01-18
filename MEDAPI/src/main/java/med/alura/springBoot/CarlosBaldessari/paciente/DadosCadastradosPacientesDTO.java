package med.alura.springBoot.CarlosBaldessari.paciente;

import med.alura.springBoot.CarlosBaldessari.endereco.DadosEnderecoDTO;

public record DadosCadastradosPacientesDTO(String nome,
                                        String email,
                                        String telefone,
                                        String cpf,
                                        DadosEnderecoDTO endereco) {
}
