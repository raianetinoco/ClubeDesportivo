package exception.DataExceptions;

/**
 * The type Invalid dia exception.
 */
public class InvalidDiaException extends IllegalArgumentException {

    /**
     * Instantiates a new Invalid dia exception.
     */
    public InvalidDiaException() {
        super("Dia é inválido!!");
    }

    /**
     * Instantiates a new Invalid dia exception.
     *
     * @param mensagem the mensagem
     */
    public InvalidDiaException(String mensagem) {
        super(mensagem);
    }

}

