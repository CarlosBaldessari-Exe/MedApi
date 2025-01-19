package med.alura.springBoot.CarlosBaldessari.domain.paciente;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import med.alura.springBoot.CarlosBaldessari.domain.endereco.Endereco;


@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
@Entity(name = "paciente")
public class Paciente {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Boolean ativo;
    private Long id;
    private String nome;
    private  String email;
    private String telefone;
    private String cpf;
    @Embedded
    private Endereco endereco;


    public Paciente(@Valid DadosCadastradosPacientesDTO dados) {
         this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.cpf = dados.cpf();
        this.endereco=new Endereco(dados.endereco());
        this.ativo=true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void atualizarInformacoes(@Valid AtualizacaoDadosPacientes dados) {
    }


     public void excluir() {
        this.ativo  = false;
    }
 public void atualizarInformacoesPacientes( AtualizacaoDadosPacientes dados) {

        if (dados.nome() != null){
            this.nome=dados.nome();
        }
        if (dados.telefone() !=null){
            this.telefone= dados.telefone();
        }
        if (dados.endereco() != null){
            this.endereco.atualizarInformacoes(dados.endereco());
        }
}
}
