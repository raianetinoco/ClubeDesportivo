package exception.DataExceptions;

/**
 * The type Invalid ano exception.
 */
public class InvalidAnoException extends IllegalArgumentException {

    /**
     * Instantiates a new Invalid ano exception.
     */
    public InvalidAnoException() {
        super("Ano é inválido!!");
    }

    /**
     * Instantiates a new Invalid ano exception.
     *
     * @param mensagem the mensagem
     */
    public InvalidAnoException(String mensagem) {
        super(mensagem);
    }

}

