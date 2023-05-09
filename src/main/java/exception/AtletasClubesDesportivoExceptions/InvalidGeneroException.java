package exception.AtletasClubesDesportivoExceptions;

/**
 * The type Invalid genero exception.
 */
public class InvalidGeneroException extends RuntimeException {

    /**
     * Instantiates a new Invalid genero exception.
     */
    public InvalidGeneroException() {
        super("ERRO: Gênero inválido !!!");
    }

    /**
     * Instantiates a new Invalid genero exception.
     *
     * @param mensagem the mensagem
     */
    public InvalidGeneroException(String mensagem) {
        super(mensagem);
    }
}

