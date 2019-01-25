package pt.ipleiria.estg.dei.aed.modelo.contactos;

import pt.ipleiria.estg.dei.aed.ComparacaoLimite;

public enum ComparacaoLimiteDatasAscendente implements ComparacaoLimite<Contacto> {
    CRITERIO;



    @Override
    public Contacto getLimite() {
        return new Contacto(" "," ",Integer.MAX_VALUE," ",new Data(0,0,Integer.MAX_VALUE),new CoordenadaGeografica(0,0));
    }



    @Override
    public int comparar(Contacto o1, Contacto o2) {
        return Integer.compare(o1.getDataNascimento().getAno(),o2.getDataNascimento().getAno());
    }
}
