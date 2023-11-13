package org.example;

public class Pilha {

    private int topo;
    private int[] pilha;

    public Pilha(int capacidade) {
        this.topo = -1;
        this.pilha = new int[capacidade];
    }

    public boolean isEmpty(){
        return topo < 0 ? true : false;
    }

    public boolean isFull(){
        return topo >= pilha.length - 1? true : false;
    }

    public void push(int info){
        if (!(topo >= pilha.length - 1)) {
            pilha[topo + 1] = info;
            topo ++;
        }else{
            throw new IllegalStateException("A lista está cheia");
        }
    }

    public int pop(){
        if (topo > - 1) {
            int retorno = pilha[topo];
            pilha[topo] = 0;
            topo --;
            return retorno;
        }
        return topo;
    }

    public int peek(){
        if (topo > - 1) {
            return pilha[topo];
        }
        return topo;
    }

    public void exibe(){
        if (topo < 0) {
            System.out.println("Pilha vazia");
        } else {
            for (int i = 0; i <= topo; i++) {
                System.out.printf("%s", pilha[i]);
            }
        }
    }

    public boolean ehPalindromo(){
//        int meio = v.length / 2;
//        for (int i = 0; i < meio; i++) {
//            if (v[v.length - (i + 1)] != v[i]) {
//                return false;
//            }
//        }
//        return true;

        for (int i = 0; i < topo; i++) {
            if (pilha[i] != pop()){
                return false;
            }
        }
        return true;
    }



    //Getters & Setters (manter)
    public int getTopo() {
        return topo;
    }
}