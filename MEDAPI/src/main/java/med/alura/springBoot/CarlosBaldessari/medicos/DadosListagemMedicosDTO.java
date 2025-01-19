package med.alura.springBoot.CarlosBaldessari.medicos;

public record DadosListagemMedicosDTO(Long id,  String nome, String email, String crm, Especialidade especialidade) {

    public DadosListagemMedicosDTO(Medico medico) {
        this(medico.getId(),
                medico.getNome(),
                medico.getEmail(),
                medico.getCrm(),
                medico.getEspecialidade());
    }

}
