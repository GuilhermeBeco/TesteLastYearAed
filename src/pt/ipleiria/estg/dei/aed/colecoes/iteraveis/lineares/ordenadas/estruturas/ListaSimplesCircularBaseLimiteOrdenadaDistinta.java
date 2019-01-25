package pt.ipleiria.estg.dei.aed.colecoes.iteraveis.lineares.ordenadas.estruturas;

import pt.ipleiria.estg.dei.aed.ComparacaoLimite;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ipleiria.pt>
 * Catarina Reis<catarina.reis@ipleiria.pt>
 * Marco Ferreira<marco.ferreira@ipleiria.pt>
 * João Ramos<joao.f.ramos@ipleiria.pt>
 * Original code: José Magno<jose.magno@ipleiria.pt>
 */
public class ListaSimplesCircularBaseLimiteOrdenadaDistinta<T> extends ListaSimplesCircularBaseLimiteOrdenada<T> {

    private static final long serialVersionUID = 1L;

    public ListaSimplesCircularBaseLimiteOrdenadaDistinta(ComparacaoLimite<T> cpl) {
        super(cpl);
    }

    // Não permite inserção de 2 elementos iguais
    @Override
    public void inserir(T elem) {
        No ant = getNoAnterior(elem);
        if (criterio.comparar(ant.seguinte.elemento, elem) != 0) {
            new No(elem, ant);
            numeroElementos++;
        } else {
            throw new IllegalArgumentException("Elemento duplicado");
        }
    }

}
