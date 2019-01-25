package pt.ipleiria.estg.dei.aed.examenormal;

import pt.ipleiria.estg.dei.aed.utils.EstatisticaDeComparacoes;

import static pt.ipleiria.estg.dei.aed.pesquisa.algoritmos.AlgoritmoPesquisa.NAO_ENCONTRADO;

public class MainAvaliacaoContagemUns {

    public MainAvaliacaoContagemUns() {
        int[][] matriz = new int[][]{
                {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 0, 0, 0},
                {1, 1, 1, 1, 1, 0},
                {0, 0, 0, 0, 0, 0},
                {1, 1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0, 0}
        };

        System.out.println("Número de uns na matriz: " + getNumeroUns(matriz));
    }

    public static void main(String[] args) {
        new MainAvaliacaoContagemUns();
    }

    private int getNumeroUns(int[][] matriz) {
        int i=0;
        int j=0;
        int count=0;
        int colunas=matriz[0].length;
        int linhas = matriz.length;
        for(i=0;i<linhas;i++){
            count=count+pesquisarRecursivo(0,colunas-1,matriz[i]);

        }
        return count;
    }
    public int pesquisarRecursivo( int esq, int dir, int... elementos) {
        if (esq > dir) {
            return esq;
        }
        if(esq==dir){
            return esq+elementos[esq];
        }
        if(elementos[esq]==0){
            return esq;
        }
        if(elementos[dir]==1){
            return dir+1;
        }

        int meio = (esq + dir) / 2;


        if (elementos[meio] ==1) {
            return pesquisarRecursivo(meio + 1, dir, elementos);
        }

        return pesquisarRecursivo( esq, meio - 1, elementos);
    }


}








