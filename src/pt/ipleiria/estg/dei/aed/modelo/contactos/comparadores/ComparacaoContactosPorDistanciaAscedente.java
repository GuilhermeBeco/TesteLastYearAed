package pt.ipleiria.estg.dei.aed.modelo.contactos.comparadores;

import pt.ipleiria.estg.dei.aed.Comparacao;
import pt.ipleiria.estg.dei.aed.ComparacaoLimite;
import pt.ipleiria.estg.dei.aed.modelo.contactos.Contacto;
import pt.ipleiria.estg.dei.aed.modelo.contactos.CoordenadaGeografica;
import pt.ipleiria.estg.dei.aed.modelo.contactos.Data;

public enum ComparacaoContactosPorDistanciaAscedente implements ComparacaoLimite<Contacto> {
    CRITERIO;
   // private static final CoordenadaGeografica LIMITE =new CoordenadaGeografica(0,0);

    @Override
    public int comparar(Contacto o1, Contacto o2) {
       return Double.compare(o1.getCoordenadaGeografica().getDistancia(o1.getCoordenadaGeografica()),o2.getCoordenadaGeografica().getDistancia(o2.getCoordenadaGeografica()));
        /*aplicamos o simetrico para que seja por ordem descendente*/
    }

    @Override
    public Contacto getLimite() {
        return new Contacto(" "," ",Integer.MAX_VALUE," ",new Data(0,0,Integer.MAX_VALUE),new CoordenadaGeografica(0,0));
    }
}
