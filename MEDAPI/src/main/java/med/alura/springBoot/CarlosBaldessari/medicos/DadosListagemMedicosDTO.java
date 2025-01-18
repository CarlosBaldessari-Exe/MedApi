package med.alura.springBoot.CarlosBaldessari.medicos;

public record DadosListagemMedicosDTO(
        String nome,
        String email,
        String crm,
        Especialidade especialidade) {

    public DadosListagemMedicosDTO(medico medico) {
        this(medico.getNome(),
                medico.getEmail(),
                medico.getCrm(),
                medico.getEspecialidade());
    }

}
