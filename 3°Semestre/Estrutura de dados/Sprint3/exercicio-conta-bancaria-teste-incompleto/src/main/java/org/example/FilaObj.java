package org.example;

public class FilaObj<T> {
    private T[] fila;
    private int tamanho;

    public FilaObj(int capacidade) {
        this.tamanho = 0;
        this.fila = (T[]) new Object[capacidade];
    }

    // Métodos

    /* Método isEmpty() - retorna true se a fila está vazia e false caso contrário */
    public boolean isEmpty() {
        return tamanho == 0;
    }

    /* Método isFull() - retorna true se a fila está cheia e false caso contrário */
    public boolean isFull() {
        return tamanho == fila.length;
    }

    /* Método insert - recebe um elemento e insere esse elemento na fila
                       no índice tamanho, e incrementa tamanho
                       Lançar IllegalStateException caso a fila esteja cheia
     */
    public void insert(T info) {
        if (isFull()) {
            throw new IllegalStateException("A fila está cheia");
        }
        this.fila[tamanho] = info;
        this.tamanho ++;
    }

    /* Método peek - retorna o primeiro elemento da fila, sem removê-lo */
    public T peek() {
        return fila[0];
    }

    /* Método poll - remove e retorna o primeiro elemento da fila, se a fila não estiver
       vazia. Quando um elemento é removido, a fila "anda", e tamanho é decrementado
       Depois que a fila andar, "limpar" o ex-último elemento da fila, atribuindo null
     */
    public T poll() {
        T aux = fila[0];
        -- tamanho;
        for (int i = 0; i < tamanho; i++) {
            fila[i] = fila[i + 1];
            this.fila[i+1] = null;
        }
        return aux;
    }

    /* Método exibe() - exibe o conteúdo da fila */
    public void exibe() {
        if (this.tamanho > 0){
            System.out.println("--------- FILA ----------");
            for (int i = 0; i < tamanho; i++) {
                System.out.println(fila[i]);
            }
        }
    }

    /* Usado nos testes  - complete para que fique certo */
    public int getTamanho(){
        return tamanho;
    }

    // Retorna o vetor fila
    public T[] getFila() {
        return null;
    }
}