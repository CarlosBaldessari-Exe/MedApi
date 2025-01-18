package med.alura.springBoot.CarlosBaldessari.medicos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.alura.springBoot.CarlosBaldessari.endereco.Endereco;
@Table (name = "medicos")
@Entity(name="Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")

public class medico {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String cre;
    @Enumerated
    private Especialidade especialidade;
    @Embedded
    private Endereco endereco;

    public medico(DadosCadastrosMedicosDTO dados) {
        this.nome=dados.nome();
        this.email=dados.email();
        this.cre=dados.crm();
        this.especialidade=dados.especialidade();
        this.endereco=new Endereco(dados.endereco());
    }
}
