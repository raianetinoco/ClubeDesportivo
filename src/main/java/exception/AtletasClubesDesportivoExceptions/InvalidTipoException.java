package exception.AtletasClubesDesportivoExceptions;

/**
 * The type Invalid tipo exception.
 */
public class InvalidTipoException extends RuntimeException {
    /**
     * Instantiates a new Invalid tipo exception.
     */
    public InvalidTipoException() {
        super("ERRO: Tipo inválido !!!");
    }

    /**
     * Instantiates a new Invalid tipo exception.
     *
     * @param mensagem the mensagem
     */
    public InvalidTipoException(String mensagem) {
        super(mensagem);
    }
}
