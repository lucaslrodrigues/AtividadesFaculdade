package org.example;

import java.util.stream.IntStream;

public class PilhaObj<T> {
    private int topo;
    private T[] pilha;

    public PilhaObj(int capacidade) {
        this.topo = -1;
        this.pilha = (T[]) new Object[capacidade];
    }

    public boolean isEmpty(){
        return topo < 0 ? true : false;
    }

    public boolean isFull(){
        return topo >= pilha.length - 1? true : false;
    }

    public void push(T info){
        if (!(topo >= pilha.length - 1)) {
            pilha[++topo] = info;
        }else{
            throw new IllegalStateException("A lista está cheia");
        }
    }

    public T pop(){
        if (topo > - 1) {
            T retorno = pilha[topo];
            pilha[topo--] = null;
            return retorno;
        }
        return null;
    }

    public T peek(){
        return topo > - 1 ? pilha[topo] : null;
    }

    public void exibe(){
        if (topo >= 0) {
            System.out.println("--------- PILHA ----------");
            IntStream.rangeClosed(0, topo).forEachOrdered(i -> System.out.printf("%s\n", pilha[i]));
        }
    }

    public boolean ehPalindromo(){
        for (int i = 0; i < topo; i++) {
            if (pilha[i] != pop()){
                return false;
            }
        }
        return true;
    }

    public int getTopo() {
        return topo;
    }
}