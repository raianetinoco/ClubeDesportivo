package criteria;

import entities.Atleta;

import java.util.Comparator;

/**
 * The type Criterio cat ativ nome.
 */
public class CriterioCatAtivNome implements Comparator {

   @Override
    public int compare(Object a1, Object a2) {

        int categoriaComparacao = ((Atleta)a1).getClass().getSimpleName().compareTo(((Atleta)a2).getClass().getSimpleName());
        if (categoriaComparacao != 0) {
            return categoriaComparacao;
        }
        int atividadeComparacao = ((Atleta)a1).getAtividade().name().compareTo(((Atleta)a2).getAtividade().name());
        if (atividadeComparacao != 0) {
            return atividadeComparacao;
        }
        return ((Atleta)a1).getNome().compareTo(((Atleta)a2).getNome());
    }
}
