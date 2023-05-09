package exception.DataExceptions;

/**
 * The type Invalid mes exception.
 */
public class InvalidMesException extends IllegalArgumentException {

    /**
     * Instantiates a new Mes invalido exception.
     */
    public InvalidMesException() {
        super("Mês é inválido!!");
    }

    /**
     * Instantiates a new Mes invalido exception.
     *
     * @param mensagem the mensagem
     */
    public InvalidMesException(String mensagem) {
        super(mensagem);
    }
}
