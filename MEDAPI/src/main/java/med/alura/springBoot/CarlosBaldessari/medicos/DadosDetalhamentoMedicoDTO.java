package med.alura.springBoot.CarlosBaldessari.medicos;

import med.alura.springBoot.CarlosBaldessari.endereco.Endereco;

import java.security.PublicKey;

public record DadosDetalhamentoMedicoDTO(Long id,
                                      String nome,
                                      String email,
                                      String crm,
                                      String telefone,
                                      Especialidade especialidade,
                                      Endereco endereco) {
public  DadosDetalhamentoMedicoDTO (Medico medico){
    this(medico.getId(),
            medico.getNome(),
            medico.getEmail(),
            medico.getCrm(),
            medico.getTelefone(),
            medico.getEspecialidade(),
            medico.getEndereco());
}
}
