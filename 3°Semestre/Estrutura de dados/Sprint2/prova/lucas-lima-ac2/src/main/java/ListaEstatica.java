package org.example;

import java.util.Arrays;

//import static org.junit.jupiter.api.Assertions.assertThrows;

public class ListaEstatica {
    private int[] vetor;

    private int nroElem;


    public ListaEstatica(int tamanho) {
        this.vetor = new int[tamanho];
        this.nroElem = 0;
    }

    public void adiciona(int numAdd){
        if (nroElem == vetor.length) {
            throw new IllegalStateException();
        }else{
            System.out.println("Adicionando "+ numAdd);
            vetor[nroElem] = numAdd;
            nroElem ++;
        }
    }

    public void exibe(){
        for (int i = 0; i < vetor.length; i++) {
            System.out.println(vetor[i]);
        }
    }

    public int busca(int numBusca){
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == numBusca) {
                return i;
            }
        }
        return -1;
    }

    public boolean removePeloIndice(int indiceRemover){
        if (indiceRemover < nroElem && indiceRemover > -1) {
            vetor[indiceRemover] = 0;
            nroElem --;
            int valorPosterior = 0;
            for (int i = indiceRemover; i < vetor.length; i++) {
                if (i < nroElem) {
                    vetor[i] = vetor[i+1];
                }else{
                    vetor[i] = 0;
                }
            }
            return true;
        }
        return false;
    }

    public boolean removeElemento(int numRemover){
        for (int i = 0; i < vetor.length; i++) {
            if (numRemover == vetor[i]) {
                removePeloIndice(i);
                return true;
            }
        }
        return false;
    }
    public int getNroElem() {
        return nroElem;
    }

    public int[] getVetor() {
        return vetor;
    }

    public void adicionaNoindice(int indice, int valor){
        if(indice > vetor.length || indice < 0){
            System.out.println("Indice invalido");
        }else if(nroElem >= vetor.length){
            System.out.println("Lista cheia");
        }else{
            for (int i = nroElem; i < indice; i++) {
                vetor[i + 1] = vetor[i];
            }
            vetor[indice] = valor;
            nroElem++;
        }
    }

    public void ordena(){
        for (int x = 0; x < vetor.length - 1; x++) {
            for (int y = 1; y < vetor.length; y++) {
                if(vetor[y - 1] > vetor[y]){
                    int aux = vetor[y -1];
                    vetor[y-1] = vetor[y];
                    vetor[y] = aux;
                }
            }
        }
    }

    public int pesquisaBinaria(int valor) {
        int indSup = vetor.length - 1;
        int indInf = 0;
        int meio;
        ordena();

        while(indInf <= indSup){
            meio = (indInf + indSup) / 2;
            System.out.println(meio);

            if (valor == vetor[meio]) {
                return meio;
            } else if (valor < vetor[meio]) {
                indSup = meio - 1;
            } else {
                indInf = meio + 1;
            }
        }
        return -1;
    }
}
