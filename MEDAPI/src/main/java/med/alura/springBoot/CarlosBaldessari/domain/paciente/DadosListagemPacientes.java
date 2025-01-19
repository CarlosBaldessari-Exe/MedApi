package med.alura.springBoot.CarlosBaldessari.domain.paciente;

public record DadosListagemPacientes(
        Long Id,
        String nome,
        String email,
        String cpf
) {
    public DadosListagemPacientes(Paciente paciente){
        this (paciente.getId(),paciente.getNome(),
                paciente.getEmail(),
                paciente.getCpf());

    }

}
