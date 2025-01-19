package med.alura.springBoot.CarlosBaldessari.paciente;

import med.alura.springBoot.CarlosBaldessari.medicos.DadosListagemMedicosDTO;

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
