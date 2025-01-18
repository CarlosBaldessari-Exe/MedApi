package med.alura.springBoot.CarlosBaldessari.endereco;

public record DadosEnderecoDTO(
        String logradouro,
        String Bairro,
        String cep,
        String cidade,
        String uf,
        String complemento,
        String numero
) {
}
