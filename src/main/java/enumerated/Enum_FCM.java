package enumerated;

/**
 * The enum Enum fcm.
 */
public enum Enum_FCM {

    /**
     * Ref caminhada corrida enum fcm.
     */
    REF_CAMINHADA_CORRIDA(208.75),
    /**
     * Ref ciclismo f enum fcm.
     */
    REF_CICLISMO_F(189),
    /**
     * Ref ciclismo m enum fcm.
     */
    REF_CICLISMO_M(202),
    /**
     * Ref natacao enum fcm.
     */
    REF_NATACAO(204),

    /**
     * Valor caminhada corrida enum fcm.
     */
    VALOR_CAMINHADA_CORRIDA(0.73),
    /**
     * Valor ciclismo f enum fcm.
     */
    VALOR_CICLISMO_F(0.56),
    /**
     * Valor ciclismo m enum fcm.
     */
    VALOR_CICLISMO_M(0.72),
    /**
     * Valor natacao enum fcm.
     */
    VALOR_NATACAO(1.7);

    private double num;

    Enum_FCM(double num) {
        this.num = num;
    }

    /**
     * Gets num.
     *
     * @return the num
     */
    public double getNum() {
        return num;
    }
}
