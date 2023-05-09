package criteria;

import entities.Atleta;

import java.util.Comparator;


/**
 * The type Criterio valor premio.
 */
public class CriterioValorPremio implements Comparator {
    @Override
    public int compare(Object atleta1, Object atleta2) {
        Double premio1 = ((Atleta) atleta1).getPremioMensalArrecadado();
        Double premio2 = ((Atleta) atleta2).getPremioMensalArrecadado();

        return premio1.compareTo(premio2);

    }

}

