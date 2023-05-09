package interfaces;

import entities.Atleta;

import java.util.ArrayList;

/**
 * The interface Calculos.
 */
public abstract interface Calculos {

    /**
     * Calculo fc maxima double.
     *
     * @return the double
     */
    public abstract double calculoFCMaxima();

    /**
     * Calcular fc trabalho double.
     *
     * @return the double
     */
    public abstract double calcularFCTrabalho();

    /**
     * Calcular pgto mensal double.
     *
     * @return the double
     */
    public abstract double calcularPgtoMensal();


    /**
     * Calcular irs double.
     *
     * @return the double
     */
    public abstract double calcularIRS();


}
