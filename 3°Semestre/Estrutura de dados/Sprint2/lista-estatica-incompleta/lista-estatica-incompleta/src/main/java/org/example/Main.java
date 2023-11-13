package org.example;

public class Main {
    public static void main(String[] args) {
        ListaEstatica lista = new ListaEstatica(3);

        lista.adiciona(10);
        lista.adiciona(20);
        lista.adiciona(30);
        lista.adiciona(40);

//        lista.busca(40);

//        System.out.println(lista.removePeloIndice(2));


//        lista.removeElemento(10);

        lista.exibe();
    }
}