package exception.CacifoExceptions;

/**
 * The type Invalid num cacifo exception.
 */
public class InvalidNumCacifoException extends RuntimeException {
    /**
     * Instantiates a new Invalid num cacifo exception.
     */
    public InvalidNumCacifoException() {
        super("ERRO: Número do Cacifo inválido !!!");
    }

    /**
     * Instantiates a new Invalid num cacifo exception.
     *
     * @param mensagem the mensagem
     */
    public InvalidNumCacifoException(String mensagem) {
        super(mensagem);
    }
}
