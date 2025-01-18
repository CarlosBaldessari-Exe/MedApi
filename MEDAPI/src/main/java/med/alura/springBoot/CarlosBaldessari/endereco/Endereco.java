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
}
