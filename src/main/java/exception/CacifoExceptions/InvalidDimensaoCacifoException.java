package exception.CacifoExceptions;

/**
 * The type Invalid dimensao cacifo exception.
 */
public class InvalidDimensaoCacifoException extends RuntimeException {
    /**
     * Instantiates a new Invalid dimensao cacifo exception.
     */
    public InvalidDimensaoCacifoException() {
        super("ERRO: Dimensão do Cacifo inválido !!!");
    }

    /**
     * Instantiates a new Invalid dimensao cacifo exception.
     *
     * @param mensagem the mensagem
     */
    public InvalidDimensaoCacifoException(String mensagem) {
        super(mensagem);
    }
}
