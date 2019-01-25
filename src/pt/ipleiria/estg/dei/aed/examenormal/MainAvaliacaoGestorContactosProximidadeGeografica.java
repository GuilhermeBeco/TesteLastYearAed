package pt.ipleiria.estg.dei.aed.examenormal;

import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.IteradorIteravel;
import pt.ipleiria.estg.dei.aed.examenormal.modelo.GestorContactosProximidadeGeografica;
import pt.ipleiria.estg.dei.aed.modelo.contactos.Contacto;
import pt.ipleiria.estg.dei.aed.modelo.contactos.CoordenadaGeografica;
import pt.ipleiria.estg.dei.aed.modelo.contactos.Data;

public class MainAvaliacaoGestorContactosProximidadeGeografica {

    private MainAvaliacaoGestorContactosProximidadeGeografica() {
        Contacto[] contactos = {
               // new Contacto("Manuel", "Silva", 910000000, "Leiria Shopping", new Data(1, 1, 2010), new CoordenadaGeografica(39.731851, -8.825210)),
                new Contacto("Maria", "Silva", 920000000, "Rua Dr. José Marques, Torres Novas", new Data(10, 1, 2000), new CoordenadaGeografica(39.471536, -8.540320)),
                new Contacto("José", "Santos", 960000000, "Avenida dos Aliados, Porto", new Data(10, 12, 2000), new CoordenadaGeografica(41.148360, -8.610786)),
                new Contacto("Ana", "Campos", 930000000, "Rua 1º de Abril, Marinha Grande", new Data(20, 05, 2001), new CoordenadaGeografica(39.728369, -8.933257))
        };

        for (Contacto contacto : contactos) {
            GestorContactosProximidadeGeografica.INSTANCIA.inserir(contacto);
        }

        System.out.println("Todos os contactos:");
        apresentar(GestorContactosProximidadeGeografica.INSTANCIA.getContactos());

        System.out.println("\nContactos que residem até 100 km de Leiria");
        apresentar(GestorContactosProximidadeGeografica.INSTANCIA.consultar(100));

        System.out.println("\nContactos que residem até 100 km de Leiria e nascidos em 2000");
        apresentar(GestorContactosProximidadeGeografica.INSTANCIA.consultar(100, 2000));
    }

    public static void main(String[] args) {
        new MainAvaliacaoGestorContactosProximidadeGeografica();
    }

    private void apresentar(IteradorIteravel<Contacto> iteradorContactos) {
        for (Contacto contacto : iteradorContactos) {
            System.out.print("(" + String.format("%.3f", GestorContactosProximidadeGeografica.COORDENADA_GEOGRAFICA_LEIRIA.getDistancia(contacto.getCoordenadaGeografica())) + " km) " + contacto);
        }
    }
}
