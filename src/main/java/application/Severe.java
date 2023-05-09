package application;

import entities.*;
import enumerated.Atividade;
import exception.AtletasClubesDesportivoExceptions.*;
import file.FicheiroListaAtletas;
import library.Cacifo;
import library.Data;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

/**
 * Classe auxiliar que contem metodos a serem chamados na Classe Main.
 */
public class Severe {

    /**
     * Permite a leitura do input.
     */
    public static Scanner input = new Scanner(System.in).useLocale(Locale.FRENCH);

    /**
     * Data nascimento data.
     *
     * @return the data
     */
    public static Data dataNascimento() {
        System.out.print("Insira a data de nascimento do Atleta no formato (ano/mês/dia): ");
        String[] data = input.nextLine().split("/");
        return Severe.formatarData(data);
    }

    /**
     * Data afiliacao data.
     *
     * @return the data
     */
    public static Data dataAfiliacao() {
        System.out.print("Insira a data de afiliação do Atleta no formato (ano/mês/dia): ");
        String[] dataAf = input.nextLine().split("/");
        return Severe.formatarData(dataAf);
    }

    /**
     * Cacifo cacifo.
     *
     * @return the cacifo
     */
    public static Cacifo cacifo() {
        input.nextLine();
        System.out.print("Insira o número do cacifo: ");
        int nCacifo = Integer.parseInt(input.next());
        System.out.print("Insira a dimensão do cacifo (Tamanho máximo: 10): ");
        double dimensao = input.nextDouble();
        input.nextLine();
        return new Cacifo(nCacifo, dimensao);
    }


    /**
     * Cria mensagem de solicitação ao utilizador para escolher a atividade do atleta.
     *
     * @return mensagem com opções de atividades
     */
    public static String criaMensagemAtividade() {
        String msg = "Selecione a opção da Atividade - Atleta: \n";

        for (Atividade a : Atividade.values()) {
            if (a.getValor() == 0) continue;
            msg += a.getValor() + "-" + a.name() + "\n";
            //msg += a.toString().toUpperCase() + "\n";
        }
        return msg;
    }

    /**
     * Atividade atividade.
     *
     * @return the atividade
     */
    public static Atividade atividade() {
        int opcao;
        String msg = criaMensagemAtividade();
        boolean opcaoValida;
        do {
            System.out.println(msg);
            opcao = Integer.parseInt(input.next());
            input.nextLine();
            opcaoValida = atividadeValida(opcao);
            if (opcao == 0) {
                opcaoValida = false;
            }
            if (!opcaoValida)
                System.out.println("ERRO: Atividade inválida !!!");
        } while (!opcaoValida);
        return Atividade.values()[verIndice(opcao)];
    }

    /**
     * Atividade valida boolean.
     *
     * @param nAtividade the n atividade
     * @return the boolean
     */
    public static boolean atividadeValida(int nAtividade) {
        boolean res = false;
        for (Atividade a : Atividade.values()) {
            if (nAtividade == a.getValor()) {
                res = true;
                break;
            }
        }
        return res;
    }

    /**
     * Verifica o valor correspondente ao numero enviado pelo utilizador
     *
     * @param valor o numero digitado
     * @return a posição da constante na classe Enumerada Atividade
     */
    public static int verIndice(int valor) {
        int res = 0;
        for (Atividade c : Atividade.values()) {
            if (valor == c.ordinal())
                res = c.ordinal();
            break;
        }
        return res;
    }

    /**
     * Metodo para Formatar a data passada pelo utilizador.
     *
     * @param data informada
     * @return a data no formato ano/mes/dia
     */
    public static Data formatarData(String[] data) {
        int ano = Integer.parseInt(data[0]);
        int mes = Integer.parseInt(data[1]);
        int dia = Integer.parseInt(data[2]);

        Data anoNasc1 = new Data();
        anoNasc1.setData(ano, mes, dia);
        return anoNasc1;
    }

    /**
     * Metodo Listar semi profissional nome fc me fct.
     *
     * @param listaAtletas the lista atletas
     */
    public static void ListarSemiProfissionalNomeFCMeFCT(ArrayList<Atleta> listaAtletas) {
        System.out.printf("%n%n****** A T L E T A    S E M I P R O F I S S I O N A L ******");
        ArrayList<Atleta> lista = new ArrayList<>(listaAtletas);
        for (Atleta i : lista) {
            if (i instanceof SemiProfissional) {
                System.out.printf("%nnome: %s FCM: %.2f FCT: %.2f", i.getNome(), i.calculoFCMaxima(), i.calcularFCTrabalho());
            }
        }
    }


    /**
     * Listar amador nome fc me fct.
     *
     * @param listaAtletas the lista atletas
     */
    public static void ListarAmadorNomeFCMeFCT(ArrayList<Atleta> listaAtletas) {
        System.out.printf("%n%n****** A T L E T A    A M A D O R ******");
        ArrayList<Atleta> lista = new ArrayList<>(listaAtletas);
        for (Atleta i : lista) {
            if (i instanceof Amador) {
                System.out.printf("%nnome: %s FCM: %.2f FCT: %.2f", i.getNome(), i.calculoFCMaxima(), i.calcularFCTrabalho());
            }
        }
    }

    /**
     * Qtd amador e semi profissional.
     */
    public static void qtdAmadorESemiProfissional() {
        System.out.printf("%n%n****** Q U A N T I D A D E    D E    A T L E T A S:    A M A D O R     E    S E M I P R O F I S S I O N A L ******");
        System.out.printf("%nQuantidade de amadores: %d%nQuantidade de SemiProfissionais: %d", Amador.getTotalAmador(), SemiProfissional.getTotalSemiProfissional());
    }

    /**
     * Listar atletas valor pagar.
     *
     * @param listaAtletas the lista atletas
     */
    public static void ListarAtletasNomeValorPagar(ArrayList<Atleta> listaAtletas) {

        System.out.printf("%n%n****** P A G A M E N T O   M E N S A L   A   C A D A   A T L E T A ******");

        ArrayList<Atleta> listaValorPagar = new ArrayList<>(listaAtletas);
        for (Atleta i : listaValorPagar) {
            System.out.printf("%nnome: %s  valor a pagar: %.2f€", i.getNome(), i.calcularPgtoMensal());
        }
    }

    /**
     * Imprimir valor total pagar tipo atleta.
     *
     * @param listaAtletas the lista atletas
     */
    public static void imprimirValorTotalPagarTipoAtleta(ArrayList<Atleta> listaAtletas) {
        System.out.printf("%n%n****** V A L O R   T O T A L    A    P A G A R:   Profissional, SemiProfissional e Amador ******");
        System.out.printf("%nProfissional: %.2f€", Profissional.totalPagarTipoAtleta(listaAtletas));
        System.out.printf("%nSemiProfissional: %.2f€", SemiProfissional.totalPagarTipoAtleta(listaAtletas));
        System.out.printf("%nAmador: %.2f€", Amador.totalPagarTipoAtleta(listaAtletas));
    }

    /**
     * Imprimir valor total pagar todos atletas.
     *
     * @param clube        the clube
     * @param listaAtletas the lista atletas
     */
    public static void imprimirValorTotalPagarTodosAtletas(ClubeDesportivo clube, ArrayList<Atleta> listaAtletas) {
        ArrayList<Atleta> lista = new ArrayList<>(listaAtletas);
        System.out.printf("%n%n****** V A L O R   T O T A L    A    P A G A R     A    T O D O S   A T L E T A S ******");
        System.out.printf("%n%s - valor total a pagar:  %.2f€", clube.getNomeClube(), clube.valorTotalTodosAtletas(lista));
    }


    /**
     * Serializar por tipo.
     *
     * @param clube the clube
     */
    public static void serializarPorTipo(ClubeDesportivo clube) {
        System.out.printf("%n%n****** S E R E A L I Z A R    C A T E G O R I A    A T L E T A    P E L O    U T I L I Z A D O R ******");
        boolean nomeValido = false;
        String tipoAtleta;
        do {
            try {
                System.out.printf("%nDigite a Categoria de Atleta : ");
                tipoAtleta = input.nextLine();
                nomeValido = true;

                FicheiroListaAtletas ficheiroListaAtletas = new FicheiroListaAtletas();

                if (ficheiroListaAtletas.serializarTipoAtleta(tipoAtleta + ".ltf", clube, tipoAtleta)) {
                    System.out.printf("%nFicheiro binário do tipo %s criado!!!%n", tipoAtleta);
                } else {
                    System.out.printf("%nFalha na criação do ficheiro binário do tipo %s%n", tipoAtleta);
                }

            } catch (InvalidCategoriaException e) {
                System.out.println(e.getMessage());
                input.nextLine();
            }
        } while (!nomeValido);

    }

    /**
     * Desserializar por tipo.
     */
    public static void desserializarPorTipo() {
        System.out.printf("%n%n****** D E S S E R E A L I Z A R    C A T E G O R I A    A T L E T A    P E L O    U T I L I Z A D O R ******");
        try {
            FicheiroListaAtletas ficheiroListaAtletas = new FicheiroListaAtletas();
            System.out.printf("%nDigite o tipo de atleta a desserializar: ");
            String tipo = input.nextLine();
            ArrayList<Atleta> atletas = ficheiroListaAtletas.desserializarTipoAtleta(tipo);
            if (!atletas.isEmpty()) {
                System.out.printf("%nCategoria ' %s ' desserializado com sucesso! %n", tipo);
                System.out.printf("%nPrimeiro atleta: %s%n", atletas.get(0).getNome());
            } else {
                System.out.printf("%nFalha na desserialização do atleta%n");
            }

        } catch (Exception e) {
            System.out.printf("%nERRO: Falha na desserialização do atleta%n");
        }

    }

    /**
     * Importar por tipo.
     */
    public static void importarPorTipo() {
        System.out.printf("%n%n****** I M P O R T A R   C A T E G O R I A    A T L E T A    P E L O    U T I L I Z A D O R ******");
        boolean nomeValido = false;

        do {
            try {
                FicheiroListaAtletas ficheiroListaAtletas = new FicheiroListaAtletas();

                System.out.printf("%nDigite o tipo do atleta (Amador, Profissional ou Semiprofissional): ");
                String nomeFicheiro = input.nextLine();
                ArrayList<Atleta> importado = ficheiroListaAtletas.importarTexto(nomeFicheiro.toLowerCase() + "ClubeDesportivo.txt");
                nomeValido = true;
                System.out.printf("%nImportação realizada com sucesso! %d atletas do tipo %s importados.", importado.size(), nomeFicheiro);
            } catch (InvalidCategoriaException e) {
                System.out.println(e.getMessage());
                input.nextLine();
            }
        } while (!nomeValido);
    }


}
