package med.alura.springBoot.CarlosBaldessari.domain.paciente;

import med.alura.springBoot.CarlosBaldessari.domain.endereco.DadosEnderecoDTO;

public record DadosCadastradosPacientesDTO(String nome,
                                        String email,
                                        String telefone,
                                        String cpf,
                                        DadosEnderecoDTO endereco) {
}
