package exception.AtletasClubesDesportivoExceptions;

/**
 * The type Invalid premio mensal arrecadado exception.
 */
public class InvalidPremioMensalArrecadadoException extends RuntimeException {
    /**
     * Instantiates a new Invalid premio mensal arrecadado exception.
     */
    public InvalidPremioMensalArrecadadoException() {
        super("ERRO: valor prêmio mensal inválido !!!");
    }

    /**
     * Instantiates a new Invalid premio mensal arrecadado exception.
     *
     * @param mensagem the mensagem
     */
    public InvalidPremioMensalArrecadadoException(String mensagem) {
        super(mensagem);
    }
}
