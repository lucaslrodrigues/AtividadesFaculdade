package org.example;

public class Main {
    public static void main(String[] args) {
        ListaObj list = new ListaObj(3);
        list.adiciona(1);
        list.adiciona("A");
        list.adiciona(false);
        list.removeElemento(1);
    }
}