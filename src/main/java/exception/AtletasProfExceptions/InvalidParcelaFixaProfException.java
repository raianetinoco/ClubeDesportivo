package exception.AtletasProfExceptions;

/**
 * The type Invalid parcela fixa prof exception.
 */
public class InvalidParcelaFixaProfException extends RuntimeException {
    /**
     * Instantiates a new Invalid parcela fixa prof exception.
     */
    public InvalidParcelaFixaProfException() {
        super("ERRO: valor parcela fixa inválido !!!");
    }

    /**
     * Instantiates a new Invalid parcela fixa prof exception.
     *
     * @param mensagem the mensagem
     */
    public InvalidParcelaFixaProfException(String mensagem) {
        super(mensagem);
    }
}
