package entities;

import enumerated.Atividade;
import library.Cacifo;
import library.Data;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * The type Nao profissional.
 */
public abstract class NaoProfissional extends Atleta implements Serializable {

    private static double refAno1 = 5;
    private static double refAno2 = 10;
    private static double refAno3 = 20;
    private static double percAntiguidade1 = 0.02;
    private static double percAntiguidade2 = 0.08;
    private static double percAntiguidade3 = 0.2;

    /**
     * Instantiates a new Nao profissional.
     *
     * @param id                     the id
     * @param nome                   the nome
     * @param idCivil                the id civil
     * @param genero                 the genero
     * @param dataNasc               the data nasc
     * @param dataAfiliacao          the data afiliacao
     * @param atividade              the atividade
     * @param clubesAnteriores       the clubes anteriores
     * @param cacifo                 the cacifo
     * @param premioMensalArrecadado the premio mensal arrecadado
     * @param fcRepouso              the fc repouso
     */
    public NaoProfissional(String id, String nome, int idCivil, char genero, Data dataNasc, Data dataAfiliacao, Atividade atividade, ArrayList<String> clubesAnteriores, Cacifo cacifo, double premioMensalArrecadado, int fcRepouso) {
        super(id, nome, idCivil, genero, dataNasc, dataAfiliacao, atividade, clubesAnteriores, cacifo, premioMensalArrecadado, fcRepouso);
    }

    /**
     * Instantiates a new Nao profissional.
     *
     * @param id the id
     */
    public NaoProfissional(String id) {
        super(id);
    }

    /**
     * Instantiates a new Nao profissional.
     *
     * @param outroAtleta the outro atleta
     */

    public NaoProfissional(NaoProfissional outroAtleta) {
        super(outroAtleta);
    }

    /**
     * toString Não profissional class
     */
    @Override
    public String toString() {
        return String.format("Não Profissional\n%s", super.toString());
    }

    /**
     * equals Não profissional class
     */
    @Override
    public boolean equals(Object outroObjeto) {
        if (!super.equals(outroObjeto)) {
            return false;
        }
        NaoProfissional outroNaoProfissional = (NaoProfissional) outroObjeto;
        return true;
    }

    /**
     * Gets perc antiguidade 1.
     *
     * @return the perc antiguidade 1
     */

    public static double getPercAntiguidade1() {
        return percAntiguidade1;
    }

    /**
     * Gets perc antiguidade 2.
     *
     * @return the perc antiguidade 2
     */
    public static double getPercAntiguidade2() {
        return percAntiguidade2;
    }

    /**
     * Gets perc antiguidade 3.
     *
     * @return the perc antiguidade 3
     */
    public static double getPercAntiguidade3() {
        return percAntiguidade3;
    }

    /**
     * Gets ref ano 1.
     *
     * @return the ref ano 1
     */
    public static double getRefAno1() {
        return refAno1;
    }

    /**
     * Gets ref ano 2.
     *
     * @return the ref ano 2
     */
    public static double getRefAno2() {
        return refAno2;
    }

    /**
     * Gets ref ano 3.
     *
     * @return the ref ano 3
     */
    public static double getRefAno3() {
        return refAno3;
    }


    /**
     * Sets ref ano 1.
     *
     * @param refAno1 the ref ano 1
     */
    public static void setRefAno1(double refAno1) {
        NaoProfissional.refAno1 = refAno1;
    }

    /**
     * Sets ref ano 2.
     *
     * @param refAno2 the ref ano 2
     */
    public static void setRefAno2(double refAno2) {
        NaoProfissional.refAno2 = refAno2;
    }

    /**
     * Sets ref ano 3.
     *
     * @param refAno3 the ref ano 3
     */
    public static void setRefAno3(double refAno3) {
        NaoProfissional.refAno3 = refAno3;
    }

    /**
     * Sets perc antiguidade 1.
     *
     * @param percAntiguidade1 the perc antiguidade 1
     */
    public static void setPercAntiguidade1(double percAntiguidade1) {
        NaoProfissional.percAntiguidade1 = percAntiguidade1;
    }

    /**
     * Sets perc antiguidade 2.
     *
     * @param percAntiguidade2 the perc antiguidade 2
     */
    public static void setPercAntiguidade2(double percAntiguidade2) {
        NaoProfissional.percAntiguidade2 = percAntiguidade2;
    }

    /**
     * Sets perc antiguidade 3.
     *
     * @param percAntiguidade3 the perc antiguidade 3
     */
    public static void setPercAntiguidade3(double percAntiguidade3) {
        NaoProfissional.percAntiguidade3 = percAntiguidade3;
    }

}
