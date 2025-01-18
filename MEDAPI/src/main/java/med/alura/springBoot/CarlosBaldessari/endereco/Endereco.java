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
}
