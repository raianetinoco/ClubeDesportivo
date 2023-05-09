package exception.AtletasClubesDesportivoExceptions;

/**
 * The type Invalid atividade exception.
 */
public class InvalidAtividadeException extends RuntimeException {
    /**
     * Instantiates a new Invalid atividade exception.
     */
    public InvalidAtividadeException() {
        super("ERRO: Atividade inválida !!!");
    }

    /**
     * Instantiates a new Invalid atividade exception.
     *
     * @param mensagem the mensagem
     */
    public InvalidAtividadeException(String mensagem) {
        super(mensagem);
    }
}
