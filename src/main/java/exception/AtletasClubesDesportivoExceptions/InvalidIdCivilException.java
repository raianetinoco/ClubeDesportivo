package exception.AtletasClubesDesportivoExceptions;

/**
 * The type Invalid id civil exception.
 */
public class InvalidIdCivilException extends RuntimeException {
    /**
     * Instantiates a new Invalid id civil exception.
     */
    public InvalidIdCivilException() {
        super("ERRO: Id Civil  do Atleta inválido !!!");
    }

    /**
     * Instantiates a new Invalid id civil exception.
     *
     * @param mensagem the mensagem
     */
    public InvalidIdCivilException(String mensagem) {
        super(mensagem);
    }
}
