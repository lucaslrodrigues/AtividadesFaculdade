package org.example;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ListaEstatica {

    // 01) Declarar vetor de int:
    // É inicializado no construtor
    private int[] vetor;

    // 02) Criar atributo nroElem:
    // Tem dupla função: representa quantos elementos foram adicionado no vetor
    // Também o índice de onde será adicionado o próximo elemento
    private int nroElem;

    // 03) Criar Construtor:
    // Recebe como argumento o tamanho máximo do vetor
    // Cria vetor com tamanho máximo informado
    // Inicializa nroElem


    // 04) Método adiciona:
    // Recebe o elemento a ser adicionado na lista
    // Se a lista estiver cheia usar IllegalStateException();


    // 05) Método busca:
    // Recebe o elemento a ser procurado na lista
    // Retorna o índice do elemento, se for encontrado
    // Retorna -1 se não encontrou


    // 06) Método removePeloIndice:
    // Recebe o índice do elemento a ser removido
    // Se o índice for inválido, retorna false
    // Se removeu, retorna true


    // 07) Método removeElemento
    // Recebe um elemento a ser removido
    // Utiliza os métodos busca e removePeloIndice
    // Retorna false, se não encontrou o elemento
    // Retorna true, se encontrou e removeu o elemento


    // 08 Método exibe:
    // Exibe os elementos da lista


    //Métodos getVetor e getNroElem
    //São usados nos testes

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
}
