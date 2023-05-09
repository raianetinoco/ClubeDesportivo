package application;

import entities.*;
import enumerated.Atividade;
import exception.AtletasClubesDesportivoExceptions.*;
import exception.AtletasProfExceptions.InvalidParcelaFixaProfException;
import exception.CacifoExceptions.InvalidDimensaoCacifoException;
import exception.CacifoExceptions.InvalidNumCacifoException;
import exception.DataExceptions.InvalidAnoException;
import exception.DataExceptions.InvalidDataAfiliacaoException;
import exception.DataExceptions.InvalidDiaException;
import exception.DataExceptions.InvalidMesException;
import file.FicheiroListaAtletas;
import library.Cacifo;
import library.Data;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.Character.toUpperCase;

/**
 * The type Main.
 */
public class Main {

    public static void main(String[] args) {

//▪ Criação de uma instância da classe ClubeDesportivo;
        ClubeDesportivo clube1 = new ClubeDesportivo("Brasil Clube", new Data(2023, 4, 28), new ArrayList<>());

//▪ Armazenamento nessa instância de 3 objetos de cada uma das categorias (Profissional, Semiprofissional e Amador);
        ArrayList<Atleta> lista1 = new ArrayList<>();
        ArrayList<String> anterior1 = new ArrayList<>();
        anterior1.add("Porto");
        anterior1.add("Benfica");

        Profissional profissional1 = new Profissional("Raiane", 123456789, 'F', new Data(1990, 12, 24),
                new Data(2023, 4, 28), Atividade.CORRIDA, anterior1, new Cacifo(1, 0.1), 50, 30, 96);
        Profissional profissional2 = new Profissional("Helo", 987654321, 'F', new Data(1950, 2, 15),
                new Data(2018, 1, 12), Atividade.NATACAO, anterior1, new Cacifo(2, 0.2), 40, 30, 89);
        Profissional profissional3 = new Profissional("Zeus", 565458974, 'M', new Data(2012, 7, 2),
                new Data(2014, 9, 6), Atividade.CICLISMO, anterior1, new Cacifo(3, 0.3), 60, 30, 80);

        SemiProfissional semiProfissional1 = new SemiProfissional("Ana", 654789652, 'F', new Data(2010, 4, 16),
                new Data(2018, 4, 28), Atividade.CORRIDA, anterior1, new Cacifo(4, 0.5), 70, 96);
        SemiProfissional semiProfissional2 = new SemiProfissional("Luis", 987654321, 'M', new Data(1950, 2, 15),
                new Data(2015, 1, 25), Atividade.CAMINHADA, anterior1, new Cacifo(5, 0.3), 10, 100);
        SemiProfissional semiProfissional3 = new SemiProfissional("Bruna", 465232114, 'F', new Data(2012, 3, 2),
                new Data(2019, 6, 6), Atividade.CICLISMO, anterior1, new Cacifo(6, 0.6), 10, 96);

        Amador amador1 = new Amador("Jorge", 456123685, 'M', new Data(2000, 8, 1),
                new Data(2018, 4, 3), Atividade.NATACAO, anterior1, new Cacifo(7, 0.4), 40, 102);
        Amador amador2 = new Amador("Joana", 777888999, 'F', new Data(1996, 2, 10),
                new Data(2015, 7, 30), Atividade.CAMINHADA, anterior1, new Cacifo(8, 0.2), 2, 100);
        Amador amador3 = new Amador("Salvador", 456888999, 'M', new Data(1987, 5, 2),
                new Data(2007, 12, 5), Atividade.CORRIDA, anterior1, new Cacifo(9, 0.1), 20, 108);

        lista1.add(profissional1);
        lista1.add(profissional2);
        lista1.add(profissional3);
        lista1.add(semiProfissional1);
        lista1.add(semiProfissional2);
        lista1.add(semiProfissional3);
        lista1.add(amador1);
        lista1.add(amador2);
        lista1.add(amador3);

        clube1.setListaAtletas(lista1);

        System.out.printf("%n###### DADOS INTRODUZIDOS PELO UTILIZADOR ###### %n");
        Amador amador4 = (Amador) CriarAtleta(new Amador());
        SemiProfissional semiProfissional4 = (SemiProfissional) CriarAtleta(new SemiProfissional());
        Profissional profissional4 = (Profissional) CriarAtleta(new Profissional());


        clube1.inserirAtleta(amador4);
        clube1.inserirAtleta(semiProfissional4);
        clube1.inserirAtleta(profissional4);
        System.out.printf("%n###### ATLETAS CRIADOS COM SUCESSO!!! ######%n");

        lista1.add(amador4);
        lista1.add(semiProfissional4);
        lista1.add(profissional4);


//▪ Obter o nome, a FCM e as FCT de cada atleta semiprofissional e amador
        Severe.ListarSemiProfissionalNomeFCMeFCT(lista1);
        Severe.ListarAmadorNomeFCMeFCT(lista1);

//▪ Obter o nome e o valor a pagar de cada atleta
        Severe.ListarAtletasNomeValorPagar(lista1);

//▪ Obter a quantidade de instâncias de atletas amadores e semiprofissionais criadas
        Severe.qtdAmadorESemiProfissional();

//▪ Apresentar valor total a pagar a cada tipo de atleta (profissional, semiprofissional e amador)
        Severe.imprimirValorTotalPagarTipoAtleta(lista1);

//▪ Apresentar o valor total a pagar a todos os atletas
        Severe.imprimirValorTotalPagarTodosAtletas(clube1, lista1);

//▪ Executar as funcionalidades implementadas na classe ClubeDesportivo e visualizar o seu resultado.
        ClubeDesportivo clube2 = new ClubeDesportivo("Novo Clube", new Data(2023, 4, 28), new ArrayList<>());

        System.out.printf("%n%n****** C O M P A R A R    C L U B E S ******");
        System.out.printf("%nO objeto '%s' é igual ao objeto '%s'? %s%n", clube1.getNomeClube(), clube2.getNomeClube(), clube1.equals(clube2));
        ClubeDesportivo clube3 = new ClubeDesportivo(clube1);
        System.out.printf("%nO objeto '%s' é igual ao objeto '%s'? %s%n", clube1.getNomeClube(), clube3.getNomeClube(), clube1.equals(clube3));

        System.out.printf("%n****** R E T O R N A R    O    N O M E    D O    C L U B E ******");
        System.out.printf("%nO nome do clube é: %s", clube1.getNomeClube());

        System.out.printf("%n%n****** R E T O R N A R    L I S T A    D E    A T L E T A S    O R D E N A D A    P O R    N O M E ******");
        System.out.printf("%n%s", clube1.ordenarlistaAtletasNome());

        System.out.printf("%n%n****** R E T O R N A R    L I S T A    D E    A T L E T A S    O R D E N A D A    I N V E R S A M E N T E    P O R    V A L O R    P R E M I O ******");
        System.out.printf("%n%s", clube1.atletasOrdenadosInversamentePorPremios());

        System.out.printf("%n%n****** R E T O R N A R    V A L O R    T O T A L    (P A R A    E F E I T O    D E    I R S) ******");
        System.out.printf("%nValor total IRS: %.2f€ %n", clube1.calcularValorTotalIRS());

//▪ Retornar uma lista de atletas do clube, ordenada alfabeticamente por categoria, modalidade e nome.
        System.out.printf("%n%n****** R E T O R N A R    L I S T A    D E    A T L E T A S    O R D E N A D A    P O R    C A T E G O R I A,    M O D A L I D A D E    E    N O M E ******");
        System.out.printf("%n%s", clube1.ordenarListaCriterios());

//▪ Importação dos atletas profissionais de um ficheiro de texto por omissão;
        System.out.printf("%n%n****** I M P O R T A R     A T L E T A S     P R O F I S S I O N A I S ******");
        FicheiroListaAtletas ficheiroListaAtletas1 = new FicheiroListaAtletas();
        ficheiroListaAtletas1.exportarTexto(clube1);
        ArrayList<Atleta> proArray = ficheiroListaAtletas1.importarTexto("profissionalClubeDesportivo.txt");
        System.out.printf("%nImportação realizada com sucesso! %d atletas do tipo profissional importados.", proArray.size());

        // ArrayList<Atleta> amadorArray = ficheiroListaAtletas1.importarTexto("amadorClubeDesportivo.txt");
        // System.out.printf("%nImportação realizada com sucesso! %d atletas do tipo profissional importados.", amadorArray.size());
        // ArrayList<Atleta> semiArray = ficheiroListaAtletas1.importarTexto("semiprofissionalClubeDesportivo.txt");
        // System.out.printf("%nImportação realizada com sucesso! %d atletas do tipo profissional importados.", semiArray.size());

//▪ Importação dos atletas de um ficheiro de texto definido pelo utilizador;
        Severe.importarPorTipo();

//▪ Exportação dos atletas amadores para um ficheiro de texto por omissão;
        System.out.printf("%n%n****** E X P O R T A R     A T L E T A S     A M A D O R E S ******");
        String tipoAtleta = "Amador";
        if (ficheiroListaAtletas1.exportarTipoAtleta(clube1, tipoAtleta)) {
            System.out.printf("%nFicheiro do tipo %s exportado%n", tipoAtleta);
        } else {
            System.out.printf("%nFalha na exportação do ficheiro do tipo %s%n", tipoAtleta);
        }

//▪ Serialização dos atletas semiprofissionais para um ficheiro por omissão;
        System.out.printf("%n%n****** S E R E A L I Z A R     A T L E T A S   S E M I P R O F I S S I O N A I S ******");
        tipoAtleta = "SemiProfissional";
        if (ficheiroListaAtletas1.serializarTipoAtleta(clube1, tipoAtleta)) {
            System.out.printf("%nFicheiro binário do tipo %s criado!!!%n", tipoAtleta);
        } else {
            System.out.printf("%nFalha na criação do ficheiro binário do tipo %s%n", tipoAtleta);
        }

//▪ Serialização de um tipo de atletas definido pelo utilizador para um determinado ficheiro definido pelo utilizador;
        Severe.serializarPorTipo(clube1);

//▪ Desserialização de um tipo de atletas definido pelo utilizador para um determinado ficheiro definido pelo utilizador;
        Severe.desserializarPorTipo();

//▪ Serialização do clube desportivo criado por omissão
        System.out.printf("%n%n****** S E R E A L I Z A R     C L U B E     D E S P O R T I V O ******");
        FicheiroListaAtletas ficheiroListaAtletas2 = new FicheiroListaAtletas();
        if (ficheiroListaAtletas2.serializar(clube1)) {
            System.out.printf("%nFicheiro binário do clube desportivo criado!!!%n");
        } else {
            System.out.printf("%nFalha na criação do ficheiro binário do clube desportivo%n");
        }

//▪ Desserialização de um clube desportivo por omissão
        try {
            System.out.printf("%n%n****** D E S S E R E A L I Z A R     C L U B E     D E S P O R T I V O ******");
            ClubeDesportivo clubeDesserializado = ficheiroListaAtletas2.desserializar();
            System.out.printf("%nClube desportivo ' %s ' desserializado com sucesso! %n", clubeDesserializado.nomeClube);


        } catch (Exception e) {
            System.out.printf("%nFalha na desserialização do clube desportivo! %n");
        }
    }

    public static Atleta CriarAtleta(Atleta novoAtleta) {
        Scanner input = new Scanner(System.in);

        boolean nomeValido = false;

        do {
            try {
                System.out.printf("%nInsira o nome do Atleta %s: ", novoAtleta.getClass().getSimpleName());
                String nome = input.nextLine();
                novoAtleta.setNome(nome);
                nomeValido = true;

            } catch (InvalidNameException e) {
                System.out.println(e.getMessage());
                // input.nextLine();
            }
        } while (!nomeValido);

        boolean idCivilValido = false;
        do {
            try {
                System.out.print("Insira o n° ID Civil: ");
                int idCivil = input.nextInt();
                input.nextLine();
                novoAtleta.setIdCivil(idCivil);
                idCivilValido = true;

            } catch (InvalidIdCivilException e) {
                System.out.println(e.getMessage());
                input.nextLine();
            } catch (InputMismatchException e) {
                input.nextLine();
                System.out.println("ERRO: Id Civil do Atleta inválido !!! Somente números são permitidos");

//            } finally {
//                input.nextLine();
            }
        } while (!idCivilValido);

        boolean generoValido = false;
        do {
            try {
                System.out.print("Insira o gênero do Atleta | M - masculino  ou F - feminino: ");
                char genero = toUpperCase(input.next().charAt(0));
                novoAtleta.setGenero(genero);
                generoValido = true;

            } catch (InvalidGeneroException e) {
                System.out.println(e.getMessage());
            }
        } while (!generoValido);

        boolean dataNascimentoValida = false;
        do {
            try {
                novoAtleta.setDataNasc(Severe.dataNascimento());
                dataNascimentoValida = true;

            } catch (InvalidAnoException | InvalidMesException | InvalidDiaException e) {
                System.out.println(e.getMessage());
            } catch (Exception erro) {
                System.out.println("ERRO: Data de Nascimento inserida - Formato inválido!! ");
            }
        } while (!dataNascimentoValida);

        boolean dataAfiliacaoValida = false;
        do {
            try {
                novoAtleta.setDataAfiliacao(Severe.dataAfiliacao());
                dataAfiliacaoValida = true;

            } catch (InvalidAnoException | InvalidMesException | InvalidDiaException |
                     InvalidDataAfiliacaoException e) {
                System.out.println(e.getMessage());
            } catch (Exception erro) {
                System.out.println("ERRO: Data de Afiliação inserida - Formato inválido!! ");
            }
        } while (!dataAfiliacaoValida);


        boolean atividadeValida = false;
        do {
            try {
                Atividade atividade = Severe.atividade();
                novoAtleta.setAtividade(atividade);
                atividadeValida = true;
            } catch (InvalidAtividadeException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("ERRO: Insira apenas números inteiros !!!");
            }
        } while (!atividadeValida);

        input.nextLine();
        do {
            System.out.print("Digite o nome do clube anterior (ou digite 'done' para finalizar): ");
            String clubesAnteriores = input.nextLine();
            if (clubesAnteriores.equalsIgnoreCase("done")) {
                break;
            }
            novoAtleta.addClubeAnterior(clubesAnteriores);
        } while (true);

        boolean cacifoValido = false;
        do {
            try {
                Cacifo cacifo = Severe.cacifo();
                novoAtleta.setCacifo(cacifo);
                cacifoValido = true;

            } catch (InvalidNumCacifoException | InvalidDimensaoCacifoException e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException |NumberFormatException e) {
                System.out.println("ERRO: Dados inválidos! Número do Cacifo: apenas inteiros | Dimensão: n° separados por vígula.");
                input.nextLine();
            }
        } while (!cacifoValido);

        boolean premioValido = false;
        do {
            try {
                System.out.print("Insira o valor do prêmio: ");
                double premioMensalArrecadado = input.nextDouble();
                novoAtleta.setPremioMensalArrecadado(premioMensalArrecadado);
                premioValido = true;

            } catch (InvalidPremioMensalArrecadadoException e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("ERRO: Valor do prêmio inválido !!! Adicione somente números separados por vígula.");
            } finally {
                input.nextLine();
            }
        } while (!premioValido);


        if (novoAtleta.getClass().getSimpleName().equalsIgnoreCase("Profissional")) {
            boolean parcelaFixaValida = false;
            do {
                try {
                    System.out.print("Insira o valor da parcela fixa: ");
                    double parcelaFixa = input.nextDouble();
                    ((Profissional) novoAtleta).setParcFixaProfissional(parcelaFixa);
                    parcelaFixaValida = true;

                } catch (InvalidParcelaFixaProfException e) {
                    System.out.println(e.getMessage());
                    input.nextLine();
                } catch (InputMismatchException e) {
                    System.out.println("ERRO: Valor da parcela fixa inválido !!! Adicione somente números separados por vígula.");
                } finally {
                    input.nextLine();
                }
            } while (!parcelaFixaValida);
        }

        return novoAtleta;
    }
}