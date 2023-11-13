package org.example;

public class Main {
    public static void main(String[] args) {
        Fila fila = new Fila(3);
        fila.insert("One Piece");
        fila.insert("Jujutsu Kaisen");
        fila.insert("Dororo");
        fila.insert("Teste");
        fila.peek();
        fila.poll();
        fila.exibe();
        fila.poll();
        fila.exibe();
        fila.poll();
        fila.exibe();
    }
}