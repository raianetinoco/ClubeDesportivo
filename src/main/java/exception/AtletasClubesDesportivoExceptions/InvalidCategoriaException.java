package exception.AtletasClubesDesportivoExceptions;

/**
 * The type Invalid categoria exception.
 */
public class InvalidCategoriaException extends RuntimeException {
    /**
     * Instantiates a new Invalid categoria exception.
     */
    public InvalidCategoriaException() {
        super("ERRO: Categoria inválida !!!");
    }

    /**
     * Instantiates a new Invalid categoria exception.
     *
     * @param mensagem the mensagem
     */
    public InvalidCategoriaException(String mensagem) {
        super(mensagem);
    }
}
