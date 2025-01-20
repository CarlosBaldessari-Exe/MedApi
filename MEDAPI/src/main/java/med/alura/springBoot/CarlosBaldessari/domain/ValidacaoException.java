package med.alura.springBoot.CarlosBaldessari.domain;

public class ValidacaoException extends RuntimeException {
    public ValidacaoException(String idDoPacienteNaoExistente) {
        super(idDoPacienteNaoExistente);
    }
}
