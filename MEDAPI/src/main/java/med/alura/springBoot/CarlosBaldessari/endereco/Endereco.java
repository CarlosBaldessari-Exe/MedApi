package med.alura.springBoot.CarlosBaldessari.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Endereco {
    private  String logradouro;
    private String Bairro;
    private  String cep;
    private  String cidade;
    private  String uf;
    private  String complemento;
    private   String numero;

    public Endereco(DadosEnderecoDTO dados) {
        this.logradouro= dados.logradouro();
        this.Bairro = dados.logradouro();
        this.cep = dados.cep();
        this.cidade = dados.cidade();
        this.uf= dados.uf();
        this.complemento =dados.complemento();
        this.numero= dados.numero();

    }

    public void atualizarInformacoes(DadosEnderecoDTO dados) {
        if (dados.logradouro() !=null){
        this.logradouro= dados.logradouro();
        }
        if (dados.Bairro() !=null){
        this.Bairro= dados.Bairro();
        }
        if (dados.cep() !=null){
        this.cep= dados.cep();
        }
        if (dados.cidade() !=null){
        this.cidade= dados.cidade();
        }
        if (dados.uf() !=null){
        this.uf= dados.uf();
        }
        if (dados.complemento() !=null){
        this.complemento= dados.complemento();
        }
        if (dados.numero() !=null){
        this.numero= dados.numero();
        }
    }
}
