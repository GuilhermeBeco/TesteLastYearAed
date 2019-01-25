package pt.ipleiria.estg.dei.aed.examenormal;

import pt.ipleiria.estg.dei.aed.colecoes.naoiteraveis.estruturas.Fila;
import pt.ipleiria.estg.dei.aed.colecoes.naoiteraveis.estruturas.Pilha;

public class MainAvaliacaoTrocarPorOrdemDeInsercaoPilhaFila {

    private MainAvaliacaoTrocarPorOrdemDeInsercaoPilhaFila() {
        Pilha<Integer> pilha = new Pilha<>();
        pilha.inserir(1);
        pilha.inserir(2);
        pilha.inserir(3);

        Fila<Integer> fila = new Fila<>();
        fila.inserir(11);
        fila.inserir(12);
        fila.inserir(13);

        System.out.println(pilha);
        System.out.println(fila);

        trocarPorOrdemDeInsercao(pilha, fila);

        System.out.println(pilha);
        System.out.println(fila);
    }

    public static void main(String[] args) {
        new MainAvaliacaoTrocarPorOrdemDeInsercaoPilhaFila();
    }

    private <T> void trocarPorOrdemDeInsercao(Pilha<T> pilha, Fila<T> fila) {
        T elementoPilha;
        T elementoFila;
        int countPilha=0;
       // int countFila=0;
        do{
            elementoPilha= pilha.consultar();
            fila.inserir(elementoPilha);
            pilha.remover();
            countPilha++;//3
        }while(!pilha.isVazia());
        do{
            elementoFila=fila.consultar();
            pilha.inserir(elementoFila);
            fila.remover();//6
        }while (!fila.isVazia());

        do{
            elementoPilha=pilha.consultar();
            fila.inserir(elementoPilha);
            pilha.remover();
            countPilha--;

        }while(countPilha!=0);
    }
}


