package entities;

import enumerated.Atividade;
import library.Cacifo;
import library.Data;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * The type Semi profissional.
 */
public class SemiProfissional extends NaoProfissional implements Serializable {

    private static final String PREFIXO_ATLETA_SEMIPROF = "SEMIPROF-";
    private static final double TAXA_IMUTAVEL_IRS = 0.1;


    private static double parcFixaSemiProfissional = 50;
    private static int totalSemiProfissional = 0;


    /**
     * Instantiates a new Semi profissional.
     *
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
    public SemiProfissional(String nome, int idCivil, char genero, Data dataNasc, Data dataAfiliacao, Atividade atividade, ArrayList<String> clubesAnteriores, Cacifo cacifo, double premioMensalArrecadado, int fcRepouso) {
        super(PREFIXO_ATLETA_SEMIPROF + (++totalSemiProfissional), nome, idCivil, genero, dataNasc, dataAfiliacao, atividade, clubesAnteriores, cacifo, premioMensalArrecadado, fcRepouso);
    }

    /**
     * Instantiates a new Semi profissional.
     */
    public SemiProfissional() {
        super(PREFIXO_ATLETA_SEMIPROF + (++totalSemiProfissional));
    }

    /**
     * Instantiates a new Semi profissional.
     *
     * @param outroAtleta the outro atleta
     */
    public SemiProfissional(SemiProfissional outroAtleta) {
        super(outroAtleta);
    }

    /**
     * equals SemiProfissional class
     */

    @Override
    public String toString() {
        return String.format("SemiProfissional\n%s", super.toString());
    }

    /**
     * equals SemiProfissional class
     */

    @Override
    public boolean equals(Object outroObjeto) {
        if (!super.equals(outroObjeto)) {
            return false;
        }
        SemiProfissional outroSemiProfissional = (SemiProfissional) outroObjeto;
        return true;
    }

    @Override
    public double calcularPgtoMensal() {
        double percentagem = 0;
        double antiguidadeObjeto = this.calcularAntiguidade();
        if (antiguidadeObjeto >= getRefAno1() && antiguidadeObjeto <= getRefAno2())
            percentagem = getPercAntiguidade1();
        if (antiguidadeObjeto > getRefAno2() && antiguidadeObjeto <= getRefAno3())
            percentagem = getPercAntiguidade2();
        if (antiguidadeObjeto > getRefAno3())
            percentagem = getPercAntiguidade3();

        double parcVariavel = percentagem * parcFixaSemiProfissional;
        return (parcFixaSemiProfissional + parcVariavel) - calcularIRS();

    }

    /**
     * Total pagar tipo atleta double.
     *
     * @param lista the lista
     * @return the double
     */
    public static double totalPagarTipoAtleta(ArrayList<Atleta> lista) {
        double totalPagar = 0;
        for (Atleta i : lista) {
            if (i instanceof SemiProfissional) {
                totalPagar += i.calcularPgtoMensal();
            }
        }
        return totalPagar;
    }

    /**
     * Calcular IRS SemiProfissional class
     *
     * @return double
     */
    @Override
    public double calcularIRS() {
        return parcFixaSemiProfissional * TAXA_IMUTAVEL_IRS;
    }


    /**
     * Gets parc fixa semi profissional.
     *
     * @return the parc fixa semi profissional
     */
    public static double getParcFixaSemiProfissional() {
        return parcFixaSemiProfissional;
    }

    /**
     * Gets total semi profissional.
     *
     * @return the total semi profissional
     */
    public static int getTotalSemiProfissional() {
        return totalSemiProfissional;
    }


    /**
     * Sets parc fixa semi profissional.
     *
     * @param parcFixaSemiProfissional the parc fixa semi profissional
     */

    public static void setParcFixaSemiProfissional(double parcFixaSemiProfissional) {
        SemiProfissional.parcFixaSemiProfissional = parcFixaSemiProfissional;
    }

}
