package library;

import exception.CacifoExceptions.InvalidDimensaoCacifoException;
import exception.CacifoExceptions.InvalidNumCacifoException;

import java.io.Serializable;

/**
 * The type Cacifo.
 */
public class Cacifo implements Serializable {
    private int numCacifo;
    private double dimensao;

    private static final int NUM_CACIFO_POR_OMISSAO = 0;
    private static final int DIMENSAO_POR_OMISSAO = 0;


    /**
     * Instantiates a new Cacifo.
     *
     * @param numCacifo the num cacifo
     * @param dimensao  the dimensao
     */
    public Cacifo(int numCacifo, double dimensao) {
        setNumCacifo(numCacifo);
        setDimensao(dimensao);
    }

    /**
     * Instantiates a new Cacifo.
     */
    public Cacifo() {
        setNumCacifo(NUM_CACIFO_POR_OMISSAO);
        setDimensao(DIMENSAO_POR_OMISSAO);
    }

    /**
     * Instantiates a new Cacifo.
     *
     * @param outroCacifo the outro cacifo
     */
    public Cacifo(Cacifo outroCacifo) {
        this.numCacifo = outroCacifo.numCacifo;
        this.dimensao = outroCacifo.dimensao;
    }

    /**
     * Gets num cacifo.
     *
     * @return the num cacifo
     */
    public int getNumCacifo() {
        return numCacifo;
    }

    /**
     * Gets dimensao.
     *
     * @return the dimensao
     */
    public double getDimensao() {
        return dimensao;
    }


    /**
     * Sets num cacifo.
     *
     * @param numCacifo the num cacifo
     */
    public void setNumCacifo(int numCacifo) {
        if (numCacifo < 0 || numCacifo > 99999999) {
            throw new InvalidNumCacifoException();
        }
        this.numCacifo = numCacifo;
    }

    /**
     * Sets dimensao.
     *
     * @param dimensao the dimensao
     */
    public void setDimensao(double dimensao) {
        if (dimensao < 0 || dimensao > 10) {
            throw new InvalidDimensaoCacifoException();
        }
        this.dimensao = dimensao;
    }

    /**
     * toString Cacifo class
     */
    @Override
    public String toString() {
        return String.format("numCacifo: %d\ndimensao: %.2f", numCacifo, dimensao);
    }

    /**
     * Equals Cacifo class
     */
    @Override
    public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) {
            return true;
        }
        if (outroObjeto == null || getClass() != outroObjeto.getClass()) {
            return false;
        }
        Cacifo outroCacifo = (Cacifo) outroObjeto;

        return this.numCacifo == outroCacifo.numCacifo
                && this.dimensao == outroCacifo.dimensao;
    }
}