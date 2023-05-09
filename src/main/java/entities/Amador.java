package entities;

import enumerated.Atividade;
import library.Cacifo;
import library.Data;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Classe Amador.
 */
public class Amador extends NaoProfissional implements Serializable {

    private static final String PREFIXO_ATLETA_AMADOR = "AMADOR-";

    private static int totalAmador = 0;
    private static double valorMinimo = 5;
    private static double percentagemTodosAmadores = 0.07;

    /**
     * Construtor Classe Amador
     *
     * @param nome                   retorna o nome do atleta
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
    public Amador(String nome, int idCivil, char genero, Data dataNasc, Data dataAfiliacao, Atividade atividade, ArrayList<String> clubesAnteriores, Cacifo cacifo, double premioMensalArrecadado, int fcRepouso) {
        super(PREFIXO_ATLETA_AMADOR + (++totalAmador), nome, idCivil, genero, dataNasc, dataAfiliacao, atividade, clubesAnteriores, cacifo, premioMensalArrecadado, fcRepouso);
    }

    /**
     * Instantiates a new Amador.
     */
    public Amador() {
        super(PREFIXO_ATLETA_AMADOR + (++totalAmador));
    }

    /**
     * Instantiates a new Amador.
     *
     * @param outroAtleta the outro atleta
     */
    public Amador(Amador outroAtleta) { //VERIFICAR
        super(outroAtleta);
    }


    /**
     * toString Amador class
     *
     * @return String.format
     */

    @Override
    public String toString() {
        return String.format("Amador\n%s", super.toString());
    }

    /**
     * equals Amador class
     *
     * @return boolean
     */

    @Override
    public boolean equals(Object outroObjeto) {
        if (!super.equals(outroObjeto)) {
            return false;
        }
        Amador outroAmador = (Amador) outroObjeto;
        return true;
    }

    /**
     * Calcular pagamento mensal a cada a atleta double.
     *
     * @return the double
     */

    public double calcularPgtoMensal() {
        double percentagem = 0;
        double antiguidadeObjeto = this.calcularAntiguidade();
        if (antiguidadeObjeto >= getRefAno1() && antiguidadeObjeto <= getRefAno2())
            percentagem = getPercAntiguidade1();
        if (antiguidadeObjeto > getRefAno2() && antiguidadeObjeto <= getRefAno3())
            percentagem = getPercAntiguidade2();
        if (antiguidadeObjeto > getRefAno3())
            percentagem = getPercAntiguidade3();

        double parcelaVariavel1 = getPremioMensalArrecadado() * percentagem;
        double parcelaVariavel2 = getPremioMensalArrecadado() * percentagemTodosAmadores;

        double pagamento = parcelaVariavel1 + parcelaVariavel2;
        if (pagamento < valorMinimo)
            pagamento = valorMinimo;

        return pagamento;
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
            if (i instanceof Amador) {
                totalPagar += i.calcularPgtoMensal();
            }
        }
        return totalPagar;
    }

    /**
     * Calclular IRS tipo atleta double.
     *
     * @return the double
     */
    @Override
    public double calcularIRS() {
        return 0;
    }

    /**
     * Gets total amador.
     *
     * @return the total amador
     */

    public static int getTotalAmador() {
        return totalAmador;
    }

    /**
     * Gets valor minimo.
     *
     * @return the valor minimo
     */

    public static double getValorMinimo() {
        return valorMinimo;
    }

    /**
     * Gets percentagem todos amadores.
     *
     * @return the percentagem todos amadores
     */
    public double getPercentagemTodosAmadores() {
        return percentagemTodosAmadores;
    }

    /**
     * Sets valor minimo.
     *
     * @param valorMinimo the valor minimo
     */

    public static void setValorMinimo(double valorMinimo) {
        Amador.valorMinimo = valorMinimo;
    }

    /**
     * Sets percentagem todos amadores.
     *
     * @param percentagemTodosAmadores the percentagem todos amadores
     */
    public static void setPercentagemTodosAmadores(double percentagemTodosAmadores) {
        Amador.percentagemTodosAmadores = percentagemTodosAmadores;
    }

}
