package med.alura.springBoot.CarlosBaldessari.paciente;

public record DadosDetalhamentoPacientes(String nome, String email, String telefone, String cpf, Endereco endereco) {

    public DadosDetalhamentoPacientes(Paciente paciente) {
        this(paciente.getNome(), paciente.getEmail(), paciente.getTelefone(), paciente.getCpf(), paciente.getEndereco());
    }
}