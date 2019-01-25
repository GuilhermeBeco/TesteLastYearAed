package pt.ipleiria.estg.dei.aed.colecoes.iteraveis.lineares.naoordenadas.estruturas;

public class ListaSimplesCircularBaseNaoOrdenadaTestePratico1<T> extends ListaSimplesCircularBaseNaoOrdenada<T> {

    public void inserirTodos(int indice, T... elementos) {
        if (indice < 0 || indice > numeroElementos) {
            throw new IndexOutOfBoundsException();
        }

        No ant = base;

        int contador = indice;
        while (contador-- > 0) {
            ant = ant.seguinte;
        }

        for (T elem : elementos) {
            ant = new No(elem, ant);
        }

        if (indice == numeroElementos) {
            noFinal = ant;
        }

        numeroElementos += elementos.length;
    }

    public int removerTodos(T elem) {
        int contadorRemovidos = 0;

        No ant = base;

        while (ant.seguinte != base) {
            if (ant.seguinte.elemento.equals(elem)) {
                contadorRemovidos++;
                ant.seguinte = ant.seguinte.seguinte;
            } else {
                ant = ant.seguinte;
            }
        }

        if (noFinal.elemento.equals(elem)) {
            noFinal = ant;
        }

        numeroElementos -= contadorRemovidos;

        return contadorRemovidos;
    }
}
