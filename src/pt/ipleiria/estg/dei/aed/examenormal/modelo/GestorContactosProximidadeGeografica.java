package pt.ipleiria.estg.dei.aed.examenormal.modelo;

import pt.ipleiria.estg.dei.aed.ComparacaoLimite;
import pt.ipleiria.estg.dei.aed.ComparacaoLimiteInteirosAscendente;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.IteradorIteravel;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.IteradorIteravelDuplo;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.associativas.estruturas.TabelaHashPorSondagemComIncrementoQuadratico;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.lineares.ordenadas.estruturas.ListaDuplaCircularBaseLimiteOrdenada;
import pt.ipleiria.estg.dei.aed.modelo.contactos.Contacto;
import pt.ipleiria.estg.dei.aed.modelo.contactos.CoordenadaGeografica;
import pt.ipleiria.estg.dei.aed.modelo.contactos.Data;
import pt.ipleiria.estg.dei.aed.modelo.contactos.comparadores.ComparacaoContactosPorDistanciaAscedente;


public enum GestorContactosProximidadeGeografica {
    INSTANCIA;
    public static final IteradorIteravelDuplo<Contacto> ITERADOR = new ListaDuplaCircularBaseLimiteOrdenada<>(ComparacaoContactosPorDistanciaAscedente.CRITERIO).iterador();
    public static final CoordenadaGeografica COORDENADA_GEOGRAFICA_LEIRIA = new CoordenadaGeografica(39.735082, -8.820678);
    public static final CoordenadaGeografica COORDENADA_GEOGRAFICA_ANTIPODA_LEIRIA = new CoordenadaGeografica(-39.735082, 171.179322);
    private ListaDuplaCircularBaseLimiteOrdenada<Contacto> contactos;
    private TabelaHashPorSondagemComIncrementoQuadratico<Integer, GestorContactosNumaData> contactosAnoDistancia;


    GestorContactosProximidadeGeografica() {
        contactos = new ListaDuplaCircularBaseLimiteOrdenada(ComparacaoContactosPorDistanciaAscedente.CRITERIO);
        contactosAnoDistancia = new TabelaHashPorSondagemComIncrementoQuadratico<>(20);


    }

    public void inserir(Contacto contacto) {
        if (contacto != null) {
            contactos.inserir(contacto);
            int ano = contacto.getDataNascimento().getAno();
            GestorContactosNumaData contactosNumAno = contactosAnoDistancia.consultar(ano);
            if (contactosNumAno == null) {
                contactosNumAno = new GestorContactosNumaData();
                contactosAnoDistancia.inserir(ano, contactosNumAno);
            }
            contactosNumAno.inserir(contacto);
        }
        //??????????????????????????????????????????
    }

    public IteradorIteravel<Contacto> getContactos() {
        return contactos.iterador();
    }

    public IteradorIteravel<Contacto> consultar(double distancia) {
        ListaDuplaCircularBaseLimiteOrdenada<Contacto> contactosAux= new ListaDuplaCircularBaseLimiteOrdenada<>(ComparacaoContactosPorDistanciaAscedente.CRITERIO);
        for(Contacto contacto:contactos){
            if(contacto.getCoordenadaGeografica().getDistancia(COORDENADA_GEOGRAFICA_LEIRIA)>distancia){
                break;
            }
            contactosAux.inserir(contacto);

        }
        return contactosAux.iterador();
        //????????????????????????????????????''''
    }

    public IteradorIteravel<Contacto> consultar(double distancia, int anoNascimento) {
        GestorContactosNumaData contactosNumAno = contactosAnoDistancia.consultar(anoNascimento);
        if(contactosNumAno==null){
            return ITERADOR;
        }
        return contactosNumAno.consultar(distancia);
    }


    private class GestorContactosNumaData {

        private ListaDuplaCircularBaseLimiteOrdenada<Contacto> contactosCoor ;

        public GestorContactosNumaData() {
        //    contactos = new ListaDuplaCircularBaseLimiteOrdenada<>(ComparacaoContactosPorNumeroTelefoneDescendente.CRITERIO);
            contactosCoor = new ListaDuplaCircularBaseLimiteOrdenada<>(ComparacaoContactosPorDistanciaAscedente.CRITERIO);
        }

        public void inserir(Contacto contacto) {
            contactosCoor.inserir(contacto);
        }


        public boolean isVazia() {
            return contactos.isVazia() == contactosCoor.isVazia() ? true : false;
        }


        public IteradorIteravel<Contacto> consultar(double distancia) {
            ListaDuplaCircularBaseLimiteOrdenada<Contacto> contactosAux= new ListaDuplaCircularBaseLimiteOrdenada<>(ComparacaoContactosPorDistanciaAscedente.CRITERIO);
            for(Contacto contacto:contactosCoor){
                if(contacto.getCoordenadaGeografica().getDistancia(COORDENADA_GEOGRAFICA_LEIRIA)>distancia){
                    break;
                }
                contactosAux.inserir(contacto);

            }
            return contactosAux.iterador();

        }
    }

}