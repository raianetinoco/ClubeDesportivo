package enumerated;

/**
 * The enum Atividade.
 */
public enum Atividade {
    /**
     * The Caminhada.
     */
    CAMINHADA (1){
        @Override
        public String toString() {
            return "Caminhada";
        }
    },
    /**
     * The Corrida.
     */
    CORRIDA (2){
        @Override

        public String toString() {
            return "Corrida";
        }
    },
    /**
     * The Ciclismo.
     */
    CICLISMO (3){
        @Override
        public String toString() {
            return "Ciclismo";
        }
    },
    /**
     * The Natacao.
     */
    NATACAO (4){
        @Override
        public String toString() {
            return "Natação";
        }
    },
    /**
     * The Sem atividade.
     */
    SEM_ATIVIDADE (0){
        @Override
        public String toString() {
            return "Sem atividade";
        }
    };
    private int valor;
    Atividade (int valor) {   this.valor = valor;    }

    /**
     * Gets valor.
     *
     * @return the valor
     */
    public int getValor() {
        return this.valor;
    }
}
