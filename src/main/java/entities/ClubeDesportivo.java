package entities;

import criteria.CriterioCatAtivNome;
import criteria.CriterioValorPremio;
import exception.AtletasClubesDesportivoExceptions.InvalidNameException;
import library.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;


/**
 * The type Clube desportivo.
 */
public class ClubeDesportivo implements Serializable {

    /**
     * Nome do Clube
     */
    public String nomeClube;

    /**
     * Data de Fundação
     */
    public Data dataFundacao;

    /**
     * Lista de Atletas
     */
    public ArrayList<Atleta> listaAtletas;

    /**
     * Nome do Clube por Omissão
     */
    private static final String NOME_CLUBE_POR_OMISSAO = "sem nome do Clube";

    /**
     * Instantiates a new Clube desportivo.
     *
     * @param nomeClube    the nome club
     * @param dataFundacao the data fundacao
     * @param listaAtletas the lista atletas
     */
    public ClubeDesportivo(String nomeClube, Data dataFundacao, ArrayList<Atleta> listaAtletas) {
        setNomeClube(nomeClube);
        setDataFundacao(dataFundacao);
        setListaAtletas(listaAtletas);
    }

    public ClubeDesportivo(ArrayList<Atleta> listaAtletas) {
        setNomeClube(NOME_CLUBE_POR_OMISSAO);
        setDataFundacao(new Data());
        setListaAtletas(listaAtletas);
    }

    /**
     * Construtor vazio
     */
    public ClubeDesportivo() {
        setNomeClube(NOME_CLUBE_POR_OMISSAO);
        setDataFundacao(new Data());
        setListaAtletas(new ArrayList<>());
    }

    /**
     * Construtor Copia.
     *
     * @param outroClube the outro clube
     */
    public ClubeDesportivo(ClubeDesportivo outroClube) {
        this.nomeClube = outroClube.nomeClube;
        this.dataFundacao = new Data(outroClube.dataFundacao);
        this.listaAtletas = new ArrayList<>(outroClube.listaAtletas);
    }

    /**
     * Gets nome club.
     *
     * @return the nome club
     */
    public String getNomeClube() {
        return nomeClube;
    }

    /**
     * Gets data fundacao.
     *
     * @return the data fundacao
     */
    public Data getDataFundacao() {
        return new Data(dataFundacao);
    }

    /**
     * Gets lista atletas.
     *
     * @return the lista atletas
     */
    public ArrayList<Atleta> getListaAtletas() {
        return new ArrayList<>(listaAtletas);
    }


    /**
     * Get lista atletas como array string [ ].
     *
     * @return the string [ ]
     */
    public String[] getListaAtletasComoArray(ArrayList<Atleta> lista) {
        String[] listaAtletas = new String[lista.size()];
        int i = 0;

        for (Atleta atleta : lista) {
            listaAtletas[i++] = atleta.toString();
        }

        return listaAtletas;
    }

    /**
     * Sets nome club.
     *
     * @param nomeClube the nome club
     */

    public void setNomeClube(String nomeClube) {
        if (!nomeClube.matches("^[a-zA-Z\\s\\-À-ÖØ-öø-ÿ]+$")) {
            throw new InvalidNameException();
        }
        this.nomeClube = nomeClube;
    }

    /**
     * Sets data fundacao.
     *
     * @param dataFundacao the data fundacao
     */
    public void setDataFundacao(Data dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    /**
     * Sets lista atletas.
     *
     * @param listaAtletas the lista atletas
     */
    public void setListaAtletas(ArrayList<Atleta> listaAtletas) {
        this.listaAtletas = new ArrayList<>(listaAtletas);
    }

    /**
     * toString do Clube Desportivo
     */

    @Override
    public String toString() {
        return String.format("nome Clube: %s\ndata Fundação: %s\nlista Atletas: %s\n", nomeClube, dataFundacao.toAnoMesDiaString(), listaAtletas);
    }

    /**
     * equals do Clube Desportivo
     */

    @Override
    public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) {
            return true;
        }
        if (outroObjeto == null || getClass() != outroObjeto.getClass()) {
            return false;
        }
        ClubeDesportivo outroClube = (ClubeDesportivo) outroObjeto;
        ArrayList<Atleta> thisLista = new ArrayList<>(listaAtletas);

        ArrayList<Atleta> copia = new ArrayList<>(outroClube.listaAtletas);
        Collections.sort(thisLista);
        Collections.sort(copia);

        return this.nomeClube.equalsIgnoreCase(outroClube.nomeClube)
                && this.dataFundacao.equals(outroClube.dataFundacao)
                && thisLista.equals(copia);
    }

    /**
     * adicionar novo atleta
     *
     * @param atleta the atleta
     */
    public void inserirAtleta(Atleta atleta) {
        listaAtletas.add(atleta);
    }

    /**
     * Retornar um boolean informando se a lista de atletas está ou não vazia.
     *
     * @return the array list
     */
    public boolean isVazia() {
        return listaAtletas.isEmpty();
    }

    /**
     * Retornar uma lista de atletas, ordenada alfabeticamente por nome, utiizando a Interface nativa Comparable.
     *
     * @return the array list
     */
    public ArrayList<Atleta> ordenarlistaAtletasNome() {
        ArrayList<Atleta> listaOrdenada = new ArrayList<>(listaAtletas);
        Collections.sort(listaOrdenada);
        return listaOrdenada;
    }

    /**
     * Retornar uma lista de atletas, ordenada inversamente pelo valor dos prémios, utilizando a Interface nativa Comparator. .
     *
     * @return the array list
     */
    public ArrayList<Atleta> atletasOrdenadosInversamentePorPremios() {
        Collections.sort(listaAtletas, Collections.reverseOrder(new CriterioValorPremio()));
        return listaAtletas;
    }


    /**
     * Retornar uma lista de atletas do clube, ordenada alfabeticamente por categoria, atividade e nome.
     *
     * @return the array list
     */
    public ArrayList<Atleta> ordenarListaCriterios() {
        Collections.sort(listaAtletas, new CriterioCatAtivNome());
        return listaAtletas;
    }

    /**
     * Valor total todos atletas double.
     *
     * @param listaAtletas the lista atletas
     * @return the double
     */
    public double valorTotalTodosAtletas(ArrayList<Atleta> listaAtletas) {
        int SomaTotal = 0;
        for (Atleta i : listaAtletas) {
            SomaTotal += i.calcularPgtoMensal();
        }
        return SomaTotal;
    }

    /**
     * Retornar o valor total, para efeitos de IRS, da totalidade dos atletas.
     *
     * @return the int
     */
    public double calcularValorTotalIRS() {
        double valorTotalIRS;
        double somaIRSProfissional = 0;
        double somaIRSSemiProfissional = 0;
        for (Atleta atleta : this.listaAtletas) {

            if (atleta instanceof Profissional) {
                somaIRSProfissional += atleta.calcularIRS();
            } else if (atleta instanceof SemiProfissional) {
                somaIRSSemiProfissional += atleta.calcularIRS();
            }
        }
        valorTotalIRS = somaIRSProfissional + somaIRSSemiProfissional;
        return valorTotalIRS;
    }



}