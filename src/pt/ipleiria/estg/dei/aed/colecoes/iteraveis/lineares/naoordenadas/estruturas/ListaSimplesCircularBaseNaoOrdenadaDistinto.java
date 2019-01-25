package pt.ipleiria.estg.dei.aed.colecoes.iteraveis.lineares.naoordenadas.estruturas;

public class ListaSimplesCircularBaseNaoOrdenadaDistinto<T> extends ListaSimplesCircularBaseNaoOrdenada<T> {

    @Override
    public void inserirNoInicio(T elem) {
        if (contem(elem)) {
            throw new IllegalArgumentException("Elemento duplicado");
        }

        super.inserirNoInicio(elem);
    }

    @Override
    public void inserirNoFim(T elem) {
        if (contem(elem)) {
            throw new IllegalArgumentException("Elemento duplicado");
        }

        super.inserirNoFim(elem);
    }

    @Override
    public void inserir(T elem) {
        if (contem(elem)) {
            throw new IllegalArgumentException("Elemento duplicado");
        }

        super.inserir(elem);
    }
}
