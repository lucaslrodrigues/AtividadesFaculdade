package org.example;

public class ListaObj <T> {

    // 01) Declarar vetor de int:
    // É inicializado no construtor
    private T[] vetor;

    // 02) Criar atributo nroElem:
    // Tem dupla função: representa quantos elementos foram adicionado no vetor
    // Também o índice de onde será adicionado o próximo elemento
    private int nroElem;

    // 03) Criar Construtor:
    // Recebe como argumento o tamanho máximo do vetor
    // Cria vetor com tamanho máximo informado
    // Inicializa nroElem
    public ListaObj(int tamanho) {
        this.vetor = (T[]) new Object[tamanho];
        this.nroElem = 0;
    }

    // 04) Método adiciona:
    // Recebe o elemento a ser adicionado na lista
    // Se a lista estiver cheia usar IllegalStateException();
    public void adiciona(T elemento) {
        if (nroElem == vetor.length) {
            throw new IllegalStateException();
        }else{
            System.out.println("Adicionando "+ elemento);
            vetor[nroElem] = elemento;
            nroElem ++;
        }
    }

    // 05) Método busca:
    // Recebe o elemento a ser procurado na lista
    // Retorna o índice do elemento, se for encontrado
    // Retorna -1 se não encontrou
    public int busca(T elementoBuscado) {
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == elementoBuscado) {
                return i;
            }
        }
        return -1;
    }

    // 06) Método removePeloIndice:
    // Recebe o índice do elemento a ser removido
    // Se o índice for inválido, retorna false
    // Se removeu, retorna true
    public boolean removePeloIndice(int indice) {
        if (indice < nroElem && indice > -1) {
            vetor[indice] = null;
            reordenarLista(indice);
            nroElem --;
            return true;
        }
        return false;
    }

    public void reordenarLista(int indice){
        for (int i = indice; i < vetor.length; i++) {
            if (i < nroElem - 1) {
                vetor[i] = vetor[i+1];
            }else{
                vetor[i] = null;
            }
        }
    }

    // 07) Método removeElemento
    // Recebe um elemento a ser removido
    // Utiliza os métodos busca e removePeloIndice
    // Retorna false, se não encontrou o elemento
    // Retorna true, se encontrou e removeu o elemento
    public boolean removeElemento(T elementoARemover) {
        int num = 0;
        for (int i = 0; i < nroElem; i++) {
            System.out.println("Volta" + ++num);
            if (elementoARemover.equals(vetor[i])) {
                vetor[i] = null;
                reordenarLista(0);
                nroElem --;
                return true;
            }
        }
        return false;
    }

    // 08) Método getTamanho
    // Retorna o tamanho da lista
    public int getTamanho() {
        return nroElem;
    }

    // 09) Método getElemento
    // Recebe um índice e retorna o elemento desse índice
    // Se o índice for inválido, retorna null
    public T getElemento(int indice) {
        return indice < nroElem - 1 && indice >= 0 ? vetor[indice] : null;
    }

    // 10) Método limpa
    // Limpa a lista
    public void limpa() {
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = null;
            this.nroElem = 0;
        }
    }

    // 11) Método exibe:
    // Exibe os elementos da lista
    public void exibe() {
        for (int i = 0; i < vetor.length; i++) {
            System.out.println(vetor[i]);
        }
    }

    // Get do vetor
    // Não retirar, é usado nos testes
    public T[] getVetor() {
        return this.vetor;
    }
}
