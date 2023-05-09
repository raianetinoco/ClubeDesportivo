package entities;

import enumerated.Atividade;
import enumerated.Enum_FCM;
import exception.AtletasClubesDesportivoExceptions.InvalidAtividadeException;
import exception.AtletasClubesDesportivoExceptions.InvalidGeneroException;
import exception.AtletasClubesDesportivoExceptions.InvalidIdCivilException;
import exception.AtletasClubesDesportivoExceptions.InvalidNameException;
import exception.CacifoExceptions.InvalidDimensaoCacifoException;
import exception.DataExceptions.InvalidDataAfiliacaoException;
import interfaces.Calculos;
import library.Cacifo;
import library.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

/**
 * The type Atleta.
 */
public abstract class Atleta implements Comparable<Atleta>, Calculos, Serializable {
    private String id;
    private String nome;
    private int idCivil;
    private char genero;
    private Data dataNasc;
    private Data dataAfiliacao;
    private Atividade atividade;
    private ArrayList<String> clubesAnteriores;
    private Cacifo cacifo;
    private double premioMensalArrecadado;
    private int fcRepouso;


    private static final String NOME_POR_OMISSAO = "sem nome";
    private static final int ID_CIVIL_POR_OMISSAO = 0;
    private static final char GENERO_POR_OMISSAO = 'X';
    private static final double PREMIO_MENSAL_ARRECADADO_POR_OMISSAO = 0;
    private static final int FC_REPOUSO_POR_OMISSAO = 0;


    private static double itQueima = 0.06;
    private static double itCapacidade = 0.075;

    /**
     * Instantiates a new Atleta.
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
    public Atleta(String id, String nome, int idCivil, char genero, Data dataNasc, Data dataAfiliacao, Atividade atividade, ArrayList<String> clubesAnteriores, Cacifo cacifo, double premioMensalArrecadado, int fcRepouso) {
        this.id = id;
        setNome(nome);
        setIdCivil(idCivil);
        setGenero(genero);
        setDataNasc(new Data(dataNasc));
        setDataAfiliacao(new Data(dataAfiliacao));
        setAtividade(atividade);
        setClubesAnteriores(clubesAnteriores);
        setCacifo(cacifo);
        setPremioMensalArrecadado(premioMensalArrecadado);
        setFcRepouso(fcRepouso);
    }


    /**
     * Instantiates a new Atleta.
     *
     * @param id the id
     */
    public Atleta(String id) {
        this.id = id;
        setNome(NOME_POR_OMISSAO);
        setIdCivil(ID_CIVIL_POR_OMISSAO);
        setGenero(GENERO_POR_OMISSAO);
        setDataNasc(new Data());
        setDataAfiliacao(new Data());
        setAtividade(Atividade.SEM_ATIVIDADE);
        setClubesAnteriores(new ArrayList<>());
        setCacifo(new Cacifo());
        setPremioMensalArrecadado(PREMIO_MENSAL_ARRECADADO_POR_OMISSAO);
        setFcRepouso(FC_REPOUSO_POR_OMISSAO);
    }

    /**
     * Instantiates a new Atleta.
     *
     * @param id   the id
     * @param nome the nome
     */
    public Atleta(String id, String nome) {
        setNome(nome);
        setIdCivil(ID_CIVIL_POR_OMISSAO);
        setGenero(GENERO_POR_OMISSAO);
        setDataNasc(new Data());
        setDataAfiliacao(new Data());
        setAtividade(Atividade.SEM_ATIVIDADE);
        setClubesAnteriores(new ArrayList<>());
        setCacifo(new Cacifo());
        setPremioMensalArrecadado(PREMIO_MENSAL_ARRECADADO_POR_OMISSAO);
        setFcRepouso(FC_REPOUSO_POR_OMISSAO);
    }

    /**
     * Instantiates a new Atleta.
     *
     * @param outroAtleta the outro atleta
     */
    public Atleta(Atleta outroAtleta) {
        this.nome = outroAtleta.nome;
        this.idCivil = outroAtleta.idCivil;
        this.genero = outroAtleta.genero;
        this.dataNasc = new Data(outroAtleta.dataNasc);
        this.dataAfiliacao = new Data(outroAtleta.dataAfiliacao);
        this.atividade = (outroAtleta.atividade);
        this.clubesAnteriores = new ArrayList<>(outroAtleta.clubesAnteriores);
        this.cacifo = new Cacifo(outroAtleta.cacifo);
        this.premioMensalArrecadado = outroAtleta.premioMensalArrecadado;
        this.fcRepouso = outroAtleta.fcRepouso;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Gets nome.
     *
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Gets id civil.
     *
     * @return the id civil
     */
    public int getIdCivil() {
        return idCivil;
    }

    /**
     * Gets genero.
     *
     * @return the genero
     */
    public char getGenero() {
        return genero;
    }

    /**
     * Gets data nasc.
     *
     * @return the data nasc
     */
    public Data getDataNasc() {
        return new Data(dataNasc);
    }

    /**
     * Gets data afiliacao.
     *
     * @return the data afiliacao
     */
    public Data getDataAfiliacao() {
        return new Data(dataAfiliacao);
    }

    /**
     * Gets atividade.
     *
     * @return the atividade
     */
    public Atividade getAtividade() {
        return atividade;
    }


    /**
     * Gets clubes anteriores.
     *
     * @return the clubes anteriores
     */
    public ArrayList<String> getClubesAnteriores() {
        return clubesAnteriores;
    }

    /**
     * Gets cacifo.
     *
     * @return the cacifo
     */
    public Cacifo getCacifo() {
        return cacifo;
    }

    /**
     * Gets premio mensal arrecadado.
     *
     * @return the premio mensal arrecadado
     */
    public double getPremioMensalArrecadado() {
        return premioMensalArrecadado;
    }

    /**
     * Gets fc repouso.
     *
     * @return the fc repouso
     */
    public int getFcRepouso() {
        return fcRepouso;
    }

    /**
     * Sets nome.
     *
     * @param nome the nome
     */
    public void setNome(String nome) {
        if (!nome.matches("^[a-zA-Z\\s\\-À-ÖØ-öø-ÿ]+$")) {
            throw new InvalidNameException();
        }
        this.nome = nome;
    }

    /**
     * Sets id civil.
     *
     * @param idCivil the id civil
     */
    public void setIdCivil(int idCivil) {
        if (idCivil < 0 || idCivil > 999999999) {
            throw new InvalidIdCivilException();
        }
        this.idCivil = idCivil;
    }

    /**
     * Sets genero.
     *
     * @param genero the genero
     */
    public void setGenero(char genero) {
        char feminino = 'F';
        char masculino = 'M';
        if (genero != feminino && genero != masculino && genero != GENERO_POR_OMISSAO) {
            throw new InvalidGeneroException();
        }
        this.genero = genero;
    }

    /**
     * Sets data nasc.
     *
     * @param dataNasc the data nasc
     */
    public void setDataNasc(Data dataNasc) {
        this.dataNasc = dataNasc;
    }

    /**
     * Sets data afiliacao.
     *
     * @param dataAfiliacao the data afiliacao
     */
    public void setDataAfiliacao(Data dataAfiliacao) {
        if (getDataNasc().isMaior(dataAfiliacao)) {
            throw new InvalidDataAfiliacaoException();
        }
        this.dataAfiliacao = dataAfiliacao;
    }

    /**
     * Sets atividade.
     *
     * @param atividade the atividade
     */
    public void setAtividade(Atividade atividade) {
        boolean atividadeInvalida = true;
        for (Atividade i : Atividade.values()) {
            if (atividade.equals(i)) {
                atividadeInvalida = false;
                break;
            }
        }
        if (atividadeInvalida) {
            throw new InvalidAtividadeException();
        }
        this.atividade = atividade;
    }

    /**
     * Sets clubes anteriores.
     *
     * @param clubesAnteriores the clubes anteriores
     */
    public void setClubesAnteriores(ArrayList<String> clubesAnteriores) {
        this.clubesAnteriores = clubesAnteriores;
    }

    /**
     * Sets cacifo.
     *
     * @param cacifo the cacifo
     */
    public void setCacifo(Cacifo cacifo) {
        this.cacifo = cacifo;
    }

    /**
     * Sets premio mensal arrecadado.
     *
     * @param premioMensalArrecadado the premio mensal arrecadado
     */
    public void setPremioMensalArrecadado(double premioMensalArrecadado) {
        if (premioMensalArrecadado < 0 || premioMensalArrecadado > 99999999) {
            throw new InvalidDimensaoCacifoException();

        }
        this.premioMensalArrecadado = premioMensalArrecadado;
    }

    /**
     * Sets fc repouso.
     *
     * @param fcRepouso the fc repouso
     */
    public void setFcRepouso(int fcRepouso) { //fazer a exceção
        this.fcRepouso = fcRepouso;
    }

    /**
     * toString Atleta class
     *
     * @return String.format
     */
    @Override
    public String toString() {
        String clubesAnt = "";
        for (String i : clubesAnteriores) {
            clubesAnt += i + ", ";
        }
        return String.format("%nid: %s\nnome: %s\nidCivil: %d\ngenero: %s\ndataNasc: %s\ndataAfiliacao: %s\natividade: %s\nclubesAnteriores: %s\n%s\npremioMensalArrecadado: %.2f\n", id, nome, idCivil, genero, dataNasc.toAnoMesDiaString(), dataAfiliacao.toAnoMesDiaString(), atividade, clubesAnt, cacifo, premioMensalArrecadado);
    }

    /**
     * equals Atleta class
     * return boolean
     */
    @Override
    public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) {
            return true;
        }
        if (outroObjeto == null || getClass() != outroObjeto.getClass()) {
            return false;
        }

        ArrayList<String> outrosAtletas = ((Atleta) outroObjeto).getClubesAnteriores();
        Collections.sort(clubesAnteriores);
        Collections.sort(outrosAtletas);
        Atleta outroAtleta = (Atleta) outroObjeto;

        return this.id.equalsIgnoreCase(outroAtleta.id)
                && this.nome.equalsIgnoreCase(outroAtleta.nome)
                && this.idCivil == outroAtleta.idCivil
                && String.valueOf(this.genero).equalsIgnoreCase(String.valueOf(outroAtleta.genero))
                && this.dataNasc.equals(outroAtleta.dataNasc)
                && this.dataAfiliacao.equals(outroAtleta.dataAfiliacao)
                && this.atividade == (outroAtleta.atividade)
                && this.clubesAnteriores.equals(outrosAtletas)
                && this.cacifo.equals(outroAtleta.cacifo)
                && this.premioMensalArrecadado == (outroAtleta.premioMensalArrecadado)
                && this.fcRepouso == (outroAtleta.fcRepouso);
    }

    /**
     * compareTo Atleta class
     *
     * @return int
     */
    @Override
    public int compareTo(Atleta outroAtleta) {
        return nome.compareTo(outroAtleta.nome);
    }


    public double calculoFCMaxima() {
        String ativ = getAtividade().toString();
        String gen = String.valueOf(getGenero());
        double fcm = 0;
        String feminino = "f";
        String masculino = "m";

        if (ativ.equalsIgnoreCase(Atividade.CAMINHADA.toString()) || ativ.equalsIgnoreCase(Atividade.CORRIDA.toString())) {
            fcm = Enum_FCM.REF_CAMINHADA_CORRIDA.getNum() - (Enum_FCM.VALOR_CAMINHADA_CORRIDA.getNum() * this.calcularIdade());
        }
        if (ativ.equalsIgnoreCase(Atividade.CICLISMO.toString()) && gen.equalsIgnoreCase(feminino)) {
            fcm = Enum_FCM.REF_CICLISMO_F.getNum() - (Enum_FCM.VALOR_CICLISMO_F.getNum() * this.calcularIdade());
        }
        if (ativ.equalsIgnoreCase(Atividade.CICLISMO.toString()) && gen.equalsIgnoreCase(masculino)) {
            fcm = Enum_FCM.REF_CICLISMO_M.getNum() - (Enum_FCM.VALOR_CICLISMO_M.getNum() * this.calcularIdade());
        }
        if (ativ.equalsIgnoreCase(Atividade.NATACAO.toString())) {
            fcm = Enum_FCM.REF_NATACAO.getNum() - (Enum_FCM.VALOR_NATACAO.getNum() * this.calcularIdade());
        }

        return fcm;
    }

    /**
     * calcular frequencia cardiaca máxima method Atleta class
     */
    public double calcularFCTrabalho() {
        return fcRepouso + (itQueima * (calculoFCMaxima() - fcRepouso));
    }

    /**
     * calcular idade method Atleta class
     */
    private int calcularIdade() {
        Data atual = Data.dataAtual();
        Data nasc = getDataNasc();

        int idade = atual.getAno() - nasc.getAno();
        if (idade > 0 && (dataNasc.getMes() > atual.getMes()
                || (dataNasc.getMes() == atual.getMes() && dataNasc.getDia()
                > atual.getDia()))) {
            idade--;
        }
        return idade;
    }

    /**
     * Calcular antiguidade int.
     *
     * @return the int
     */
    public int calcularAntiguidade() {
        Data dataAtual = Data.dataAtual();

        int anos = dataAtual.getAno() - dataAfiliacao.getAno();
        if (anos > 0 && (dataAfiliacao.getMes() > dataAtual.getMes()
                || (dataAfiliacao.getMes() == dataAtual.getMes()
                && dataAfiliacao.getDia() > dataAtual.getDia()))) {
            anos--;
        }
        return anos;
    }

    /**
     * Add clube anterior.
     *
     * @param club the club
     */
    public void addClubeAnterior(String club) {
        this.clubesAnteriores.add(club);
    }


    /**
     * Gets it queima.
     *
     * @return the it queima
     */
    public double getItQueima() {
        return itQueima;
    }

    /**
     * Gets it capacidade.
     *
     * @return the it capacidade
     */
    public double getItCapacidade() {
        return itCapacidade;
    }


    /**
     * Sets it queima.
     *
     * @param itQueima the it queima
     */
    public static void setItQueima(double itQueima) {
        Atleta.itQueima = itQueima;
    }

    /**
     * Sets it capacidade.
     *
     * @param itCapacidade the it capacidade
     */
    public static void setItCapacidade(double itCapacidade) {
        Atleta.itCapacidade = itCapacidade;
    }

    /**
     * calcular pagamento abstract method Atleta class
     */
    public abstract double calcularPgtoMensal();

    /**
     * calcular IRS abstract method Atleta class
     */
    public abstract double calcularIRS();

}
