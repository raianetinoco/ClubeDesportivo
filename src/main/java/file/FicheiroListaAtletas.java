package file;

import criteria.CriterioCatAtivNome;
import entities.*;
import enumerated.Atividade;
import library.Cacifo;
import library.Data;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


/**
 * The type Ficheiro lista atletas.
 */
public class FicheiroListaAtletas {

    /**
     * The constant FICHEIRO_SERIALIZAR_POR_TIPO.
     */
    public static final String FICHEIRO_SERIALIZAR_POR_TIPO = "ListaAtletasPorTipo.ltf";
    /**
     * The constant FICHEIRO_SERIALIZAR_CLUBE_DESPORTIVO.
     */
    public static final String FICHEIRO_SERIALIZAR_CLUBE_DESPORTIVO = "ClubeDesportivo.ltf";
    /**
     * The constant FICHEIRO_TEXTO_CLUBE_DESPORTIVO.
     */
    public static final String FICHEIRO_TEXTO_CLUBE_DESPORTIVO = "ClubeDesportivo.txt";
    /**
     * The constant FICHEIRO_TEXTO_POR_TIPO.
     */
    public static final String FICHEIRO_TEXTO_POR_TIPO = "ListaAtletasPorTipo.txt";


    /**
     * Instantiates a new Ficheiro lista atletas.
     */
    public FicheiroListaAtletas() {
    }


    /**
     * Serializar boolean.
     *
     * @param clubeDesportivo the clube desportivo
     * @return the boolean
     */
    public boolean serializar(ClubeDesportivo clubeDesportivo) {
        return serializar(FICHEIRO_SERIALIZAR_CLUBE_DESPORTIVO, clubeDesportivo);
    }

    /**
     * Serializar boolean.
     *
     * @param nomeFicheiro    the nome ficheiro
     * @param clubeDesportivo the clube desportivo
     * @return the boolean
     */
    public boolean serializar(String nomeFicheiro, ClubeDesportivo clubeDesportivo) {
        return serializar(new File(nomeFicheiro), clubeDesportivo);
    }

    /**
     * Serializar boolean.
     *
     * @param nomeFicheiro    the nome ficheiro
     * @param clubeDesportivo the clube desportivo
     * @return the boolean
     */
    public boolean serializar(File nomeFicheiro, ClubeDesportivo clubeDesportivo) {
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(nomeFicheiro));
            try {
                outputStream.writeObject(clubeDesportivo);
                return true;
            } finally {
                outputStream.close();
            }
        } catch (IOException ex) {
            return false;
        }
    }

    /**
     * Serializar tipo atleta boolean.
     *
     * @param listaAtletas the lista atletas
     * @param tipoAtleta   the tipo atleta
     * @return the boolean
     */
    public boolean serializarTipoAtleta(ClubeDesportivo listaAtletas, String tipoAtleta) {
        return serializarTipoAtleta(FICHEIRO_SERIALIZAR_POR_TIPO, listaAtletas, tipoAtleta);
    }

    /**
     * Serializar tipo atleta boolean.
     *
     * @param nomeFicheiro the nome ficheiro
     * @param listaAtletas the lista atletas
     * @param tipoAtleta   the tipo atleta
     * @return the boolean
     */
    public boolean serializarTipoAtleta(String nomeFicheiro, ClubeDesportivo listaAtletas, String tipoAtleta) {
        return serializarTipoAtleta(new File(nomeFicheiro), listaAtletas, tipoAtleta);
    }

    /**
     * Serializar tipo atleta boolean.
     *
     * @param nomeFicheiro the nome ficheiro
     * @param listaAtletas the lista atletas
     * @param tipoAtleta   the tipo atleta
     * @return the boolean
     */
    public boolean serializarTipoAtleta(File nomeFicheiro, ClubeDesportivo listaAtletas, String tipoAtleta) {
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(nomeFicheiro));
            try {
                ArrayList<Atleta> tipoLista = new ArrayList<>();

                for (Atleta atleta : listaAtletas.getListaAtletas()) {
                    if (atleta instanceof Profissional && (atleta.getClass().getSimpleName().equalsIgnoreCase(tipoAtleta))) {
                        tipoLista.add(atleta);
                    } else if (atleta instanceof SemiProfissional && (atleta.getClass().getSimpleName().equalsIgnoreCase(tipoAtleta))) {
                        tipoLista.add(atleta);
                    } else if (atleta instanceof Amador && (atleta.getClass().getSimpleName().equalsIgnoreCase(tipoAtleta))) {
                        tipoLista.add(atleta);
                    }
                }
                outputStream.writeObject(tipoLista);
                return true;
            } finally {
                outputStream.close();
            }
        } catch (IOException ex) {
            return false;
        }
    }

    /**
     * Desserializar clube desportivo.
     *
     * @return the clube desportivo
     */
    public ClubeDesportivo desserializar() {
        return desserializar(FICHEIRO_SERIALIZAR_CLUBE_DESPORTIVO);
    }

    /**
     * Desserializar clube desportivo.
     *
     * @param nomeFicheiro the nome ficheiro
     * @return the clube desportivo
     */
    public ClubeDesportivo desserializar(String nomeFicheiro) {
        return desserializar(new File(nomeFicheiro));
    }

    /**
     * Desserializar clube desportivo.
     *
     * @param nomeFicheiro the nome ficheiro
     * @return the clube desportivo
     */
    public ClubeDesportivo desserializar(File nomeFicheiro) {
        try (ObjectInputStream strem = new ObjectInputStream(new FileInputStream(nomeFicheiro))) {
            ClubeDesportivo clube = (ClubeDesportivo) strem.readObject();
            return clube;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ClubeDesportivo();
        }
    }

    /**
     * Desserializar tipo atleta array list.
     *
     * @return the array list
     */
    public ArrayList<Atleta> desserializarTipoAtleta() {
        return desserializarTipoAtleta(FICHEIRO_SERIALIZAR_POR_TIPO);
    }

    /**
     * Desserializar tipo atleta array list.
     *
     * @param nomeFicheiro the nome ficheiro
     * @return the array list
     */
    public ArrayList<Atleta> desserializarTipoAtleta(String nomeFicheiro) {
        return desserializarTipoAtleta(new File(nomeFicheiro));
    }

    /**
     * Desserializar tipo atleta array list.
     *
     * @param nomeFicheiro the nome ficheiro
     * @return the array list
     */
    public ArrayList<Atleta> desserializarTipoAtleta(File nomeFicheiro) {
        ArrayList<Atleta> tipoLista;
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(nomeFicheiro + ".ltf"));
            try {
                 tipoLista = (ArrayList<Atleta>) inputStream.readObject();
                return tipoLista;
            } finally {
                inputStream.close();
            }
        } catch (FileNotFoundException e) {
            System.out.printf("%nERRO: O arquivo especificado não foi encontrado.%n");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
    }
        return new ArrayList<Atleta>();
}


    /**
     * Importar texto array list.
     *
     * @return the array list
     */
    public ArrayList<Atleta> importarTexto() {
        return importarTexto(new File(FICHEIRO_TEXTO_CLUBE_DESPORTIVO));
    }

    /**
     * Importar texto array list.
     *
     * @param nomeFicheiro the nome ficheiro
     * @return the array list
     */
    public ArrayList<Atleta> importarTexto(String nomeFicheiro) {
        return importarTexto(new File(nomeFicheiro));
    }

    /**
     * Importar texto array list.
     *
     * @param ficheiro the ficheiro
     * @return the array list
     */
    public ArrayList<Atleta> importarTexto(File ficheiro) {
        ArrayList<Atleta> listAtleta = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(ficheiro);
            try {

                Atleta atleta;
                while (scanner.hasNextLine()) {
                    String tipo = scanner.nextLine();

                    String id = scanner.nextLine();

                    if (tipo.equalsIgnoreCase("Semiprofissional")) {
                        atleta = new SemiProfissional();
                        scanner.nextLine();
                    } else if (tipo.equalsIgnoreCase("Profissional")) {
                        atleta = new Profissional();
                    } else {
                        atleta = new Amador();
                        scanner.nextLine();
                    }

                    scanner.nextLine();

                    atleta.setNome(scanner.nextLine().split(":")[1].trim());
                    atleta.setIdCivil(Integer.parseInt(scanner.nextLine().split(":")[1].trim()));
                    atleta.setGenero(scanner.nextLine().split(":")[1].trim().toCharArray()[0]);

                    String[] v1 = scanner.nextLine().split(":")[1].split("/");
                    atleta.setDataNasc(new Data(Integer.parseInt(v1[0].trim()), Integer.parseInt(v1[1]), Integer.parseInt(v1[2])));

                    String[] v2 = scanner.nextLine().split(":")[1].split("/");
                    atleta.setDataAfiliacao(new Data(Integer.parseInt(v2[0].trim()), Integer.parseInt(v2[1]), Integer.parseInt(v2[2])));

                    Atividade atividade = Atividade.SEM_ATIVIDADE;
                    String atividadeLida = scanner.nextLine().split(":")[1].trim();
                    for (Atividade a : Atividade.values()) {
                        if (atividadeLida.equalsIgnoreCase(a.toString())) {
                            atividade = a;
                            break;
                        }
                    }
                    atleta.setAtividade(atividade);

                    ArrayList<String> clubAnt = new ArrayList<>();
                    String x = scanner.nextLine();
                    String[] clubArray = x.split(":")[1].split(",");
                    for (String club : clubArray) {
                        clubAnt.add(club.trim());
                    }
                    atleta.setClubesAnteriores(clubAnt);

                    Cacifo cacifo = new Cacifo();
                    cacifo.setNumCacifo(Integer.parseInt(scanner.nextLine().split(":")[1].trim()));
                    cacifo.setDimensao(Double.parseDouble(scanner.nextLine().split(":")[1].trim().replace(',', '.')));
                    atleta.setCacifo(cacifo);

                    atleta.setPremioMensalArrecadado(Double.parseDouble(scanner.nextLine().split(":")[1].trim().replace(',', '.')));

                    if (atleta instanceof Profissional)
                        ((Profissional) atleta).setParcFixaProfissional(Double.parseDouble(scanner.nextLine().split(":")[1].trim().replace(',', '.')));

                    if (scanner.hasNextLine())
                        scanner.nextLine();

                    listAtleta.add(atleta);
                }

                return listAtleta;
            } finally {
                scanner.close();
            }
        } catch (IOException ex) {
            return new ArrayList<Atleta>();
        }
    }

    /**
     * Exportar texto boolean.
     *
     * @param clubeDesportivo the clube desportivo
     * @return the boolean
     */
    public boolean exportarTexto(ClubeDesportivo clubeDesportivo) {
        return exportarTexto(FICHEIRO_TEXTO_CLUBE_DESPORTIVO, clubeDesportivo);
    }

    /**
     * Exportar texto boolean.
     *
     * @param nomeFicheiro    the nome ficheiro
     * @param clubeDesportivo the clube desportivo
     * @return the boolean
     */
    public boolean exportarTexto(String nomeFicheiro, ClubeDesportivo clubeDesportivo) {
        return exportarTexto(new File(nomeFicheiro), clubeDesportivo);
    }

    /**
     * Exportar texto boolean.
     *
     * @param ficheiro        the ficheiro
     * @param clubeDesportivo the clube desportivo
     * @return the boolean
     */
    public boolean exportarTexto(File ficheiro, ClubeDesportivo clubeDesportivo) {
        ArrayList<Atleta> amador = new ArrayList<>();
        ArrayList<Atleta> semiProfissional = new ArrayList<>();
        ArrayList<Atleta> profissional = new ArrayList<>();

        for (Atleta atleta : clubeDesportivo.getListaAtletas()) {
            if (atleta instanceof Amador) {
                amador.add(atleta);
            } else if (atleta instanceof SemiProfissional) {
                semiProfissional.add(atleta);
            } else {
                profissional.add(atleta);
            }
        }

        CriterioCatAtivNome criterio1 = new CriterioCatAtivNome();
        Collections.sort(amador, criterio1);
        Collections.sort(semiProfissional, criterio1);
        Collections.sort(profissional, criterio1);

        try {
            String[] listaAtletasParaFicheiro1 = clubeDesportivo.getListaAtletasComoArray(amador);
            PrintWriter out1 = new PrintWriter("amador" + ficheiro);
            try {
                for (int i = 0; i < listaAtletasParaFicheiro1.length - 1; i++) {
                    out1.println(listaAtletasParaFicheiro1[i]);
                }
                out1.print(listaAtletasParaFicheiro1[listaAtletasParaFicheiro1.length - 1]);
            } finally {
                out1.close();
            }
        } catch (IOException ex) {
            return false;
        }
        try {
            String[] listaAtletasParaFicheiro2 = clubeDesportivo.getListaAtletasComoArray(semiProfissional);
            PrintWriter out2 = new PrintWriter("semiprofissional" + ficheiro);
            try {
                for (int i = 0; i < listaAtletasParaFicheiro2.length - 1; i++) {
                    out2.println(listaAtletasParaFicheiro2[i]);
                }
                out2.print(listaAtletasParaFicheiro2[listaAtletasParaFicheiro2.length - 1]);
            } finally {
                out2.close();
            }
        } catch (IOException ex) {
            return false;
        }
        try {
            String[] listaAtletasParaFicheiro3 = clubeDesportivo.getListaAtletasComoArray(profissional);
            PrintWriter out3 = new PrintWriter("profissional" + ficheiro);
            try {
                for (int i = 0; i < listaAtletasParaFicheiro3.length - 1; i++) {
                    out3.println(listaAtletasParaFicheiro3[i]);
                }
                out3.print(listaAtletasParaFicheiro3[listaAtletasParaFicheiro3.length - 1]);
                return true;
            } finally {
                out3.close();
            }
        } catch (IOException ex) {
            return false;
        }
    }

    /**
     * Exportar tipo atleta boolean.
     *
     * @param clubeDesportivo the clube desportivo
     * @param tipoAtleta      the tipo atleta
     * @return the boolean
     */
    public boolean exportarTipoAtleta(ClubeDesportivo clubeDesportivo, String tipoAtleta) {
        return exportarTipoAtleta(FICHEIRO_TEXTO_POR_TIPO, clubeDesportivo, tipoAtleta);
    }

    /**
     * Exportar tipo atleta boolean.
     *
     * @param nomeFicheiro    the nome ficheiro
     * @param clubeDesportivo the clube desportivo
     * @param tipoAtleta      the tipo atleta
     * @return the boolean
     */
    public boolean exportarTipoAtleta(String nomeFicheiro, ClubeDesportivo clubeDesportivo, String tipoAtleta) {
        return exportarTipoAtleta(new File(nomeFicheiro), clubeDesportivo, tipoAtleta);
    }

    /**
     * Exportar tipo atleta boolean.
     *
     * @param nomeFicheiro    the nome ficheiro
     * @param clubeDesportivo the clube desportivo
     * @param tipoAtleta      the tipo atleta
     * @return the boolean
     */
    public boolean exportarTipoAtleta(File nomeFicheiro, ClubeDesportivo clubeDesportivo, String tipoAtleta) {

        try {
            PrintWriter outWriter = new PrintWriter(nomeFicheiro);
            try {
                ArrayList<Atleta> tipoLista = new ArrayList<>();

                for (Atleta atleta : clubeDesportivo.getListaAtletas()) {
                    if (atleta instanceof Profissional && (atleta.getClass().getSimpleName().equalsIgnoreCase(tipoAtleta))) {
                        tipoLista.add(atleta);
                    } else if (atleta instanceof SemiProfissional && (atleta.getClass().getSimpleName().equalsIgnoreCase(tipoAtleta))) {
                        tipoLista.add(atleta);
                    } else if (atleta instanceof Amador && (atleta.getClass().getSimpleName().equalsIgnoreCase(tipoAtleta))) {
                        tipoLista.add(atleta);
                    }
                }
                CriterioCatAtivNome criterio1 = new CriterioCatAtivNome();
                Collections.sort(tipoLista, criterio1);
                outWriter.print(tipoLista);
                return true;
            } finally {
                outWriter.close();
            }
        } catch (IOException ex) {
            return false;
        }
    }


}
