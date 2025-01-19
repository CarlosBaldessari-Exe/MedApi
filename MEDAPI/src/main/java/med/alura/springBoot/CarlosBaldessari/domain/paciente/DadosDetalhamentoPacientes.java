package med.alura.springBoot.CarlosBaldessari.domain.paciente;

import med.alura.springBoot.CarlosBaldessari.domain.endereco.Endereco;

public record DadosDetalhamentoPacientes(String nome, String email, String telefone, String cpf, Endereco endereco) {

    public DadosDetalhamentoPacientes(Paciente paciente) {
        this(paciente.getNome(), paciente.getEmail(), paciente.getTelefone(), paciente.getCpf(), paciente.getEndereco());
    }
}