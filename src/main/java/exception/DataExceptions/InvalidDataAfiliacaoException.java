package exception.DataExceptions;

/**
 * The type Invalid ano exception.
 */
public class InvalidDataAfiliacaoException extends IllegalArgumentException {

    /**
     * Instantiates a new Invalid ano exception.
     */
    public InvalidDataAfiliacaoException() {
        super("ERRO: Data de Afiliação inválida!!! A data não deve ser mais recente que a data de Nascimento!!");
    }

    /**
     * Instantiates a new Invalid ano exception.
     *
     * @param mensagem the mensagem
     */
    public InvalidDataAfiliacaoException(String mensagem) {
        super(mensagem);
    }

}

