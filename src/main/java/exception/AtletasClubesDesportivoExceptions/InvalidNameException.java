package exception.AtletasClubesDesportivoExceptions;

/**
 * The type Invalid name exception.
 */
public class InvalidNameException extends RuntimeException {

    /**
     * Instantiates a new Invalid name exception.
     */
    public InvalidNameException() {
        super("ERRO! nome inválido !!!");
    }

    /**
     * Instantiates a new Invalid name exception.
     *
     * @param mensagem the mensagem
     */
    public InvalidNameException(String mensagem) {
        super(mensagem);
    }

}
