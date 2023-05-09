package entities;

import enumerated.Atividade;
import library.Cacifo;
import library.Data;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * The type Profissional.
 */
public class Profissional extends Atleta implements Serializable {
    /**
     * The Parc fixa profissional.
     */
    double parcFixaProfissional;


    private static final String PREFIXO_ATLETA_PROFISSIONAL = "PROF-";
    private static final double PARC_FIXA_PROFISSIONAL = 0;
    private static final double TAXA_IMUTAVEL_IRS = 0.1;


    private static int totalProfissional = 0;
    private static double percMensalArrecadado = 0.2;

    /**
     * Instantiates a new Profissional.
     *
     * @param nome                   the nome
     * @param idCivil                the id civil
     * @param genero                 the genero
     * @param dataNasc               the data nasc
     * @param dataAfiliacao          the data afiliacao
     * @param atividade              the atividade
     * @param clubesAnteriores       the clubes anteriores
     * @param cacifo                 the cacifo
     * @param PremioMensalArrecadado the premio mensal arrecadado
     * @param parcFixaProfissional   the parc fixa profissional
     * @param fcRepouso              the fc repouso
     */

    public Profissional(String nome, int idCivil, char genero, Data dataNasc, Data dataAfiliacao, Atividade atividade, ArrayList<String> clubesAnteriores, Cacifo cacifo, double PremioMensalArrecadado, double parcFixaProfissional, int fcRepouso) {
        super(PREFIXO_ATLETA_PROFISSIONAL + (++totalProfissional), nome, idCivil, genero, dataNasc, dataAfiliacao, atividade, clubesAnteriores, cacifo, PremioMensalArrecadado, fcRepouso);
        setParcFixaProfissional(parcFixaProfissional);
    }


    /**
     * Instantiates a new Profissional.
     *
     * @param nome the nome
     */
    public Profissional(String nome) {
        super(PREFIXO_ATLETA_PROFISSIONAL + (++totalProfissional), nome);
        setParcFixaProfissional(parcFixaProfissional);
    }

    /**
     * Instantiates a new Profissional.
     */
    public Profissional() {
        super(PREFIXO_ATLETA_PROFISSIONAL + (++totalProfissional));
        setParcFixaProfissional(PARC_FIXA_PROFISSIONAL);
    }


    /**
     * Instantiates a new Profissional.
     *
     * @param outroAtleta the outro atleta
     */

    public Profissional(Profissional outroAtleta) {
        super(outroAtleta);
        this.parcFixaProfissional = outroAtleta.parcFixaProfissional;
    }


    /**
     * Gets parc fixa profissional.
     *
     * @return the parc fixa profissional
     */
    public double getParcFixaProfissional() {
        return parcFixaProfissional;
    }


    /**
     * Sets parc fixa profissional.
     *
     * @param parcFixaProfissional the parc fixa profissional
     */
    public void setParcFixaProfissional(double parcFixaProfissional) {
        this.parcFixaProfissional = parcFixaProfissional;
    }

    /**
     * toString Profissional class
     */
    @Override
    public String toString() {
        return String.format("Profissional\n%sparcFixaProfissional: %.2f\n", super.toString(), parcFixaProfissional);
    }

    /**
     * equals Profissional class
     */
    @Override
    public boolean equals(Object outroObjeto) {
        if (!super.equals(outroObjeto)) {
            return false;
        }
        Profissional outroProfissional = (Profissional) outroObjeto;
        return this.parcFixaProfissional == outroProfissional.parcFixaProfissional;
    }


    @Override
    public double calcularPgtoMensal() {
        double parcVariavel = percMensalArrecadado * getPremioMensalArrecadado();
        return (parcFixaProfissional + parcVariavel) - calcularIRS();
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
            if (i instanceof Profissional) {
                totalPagar += i.calcularPgtoMensal();
            }
        }
        return totalPagar;
    }

    /**
     * Calcular IRS Profissional class
     * @return double
     */
    @Override
    public double calcularIRS() {
        return this.parcFixaProfissional * TAXA_IMUTAVEL_IRS;
    }

    /**
     * Gets perc mensal arrecadado.
     *
     * @return the perc mensal arrecadado
     */

    public static double getPercMensalArrecadado() {
        return percMensalArrecadado;
    }

    /**
     * Gets total profissional.
     *
     * @return the total profissional
     */
    public static int getTotalProfissional() {
        return totalProfissional;
    }


    /**
     * Sets perc mensal arrecadado.
     *
     * @param percMensalArrecadado the perc mensal arrecadado
     */

    public static void setPercMensalArrecadado(double percMensalArrecadado) {
        Profissional.percMensalArrecadado = percMensalArrecadado;
    }


}
