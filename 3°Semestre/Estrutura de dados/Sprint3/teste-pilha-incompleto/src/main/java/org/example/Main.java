package org.example;

import java.text.Normalizer;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello world!");
//
//        Pilha pilha = new Pilha(4);
//        int[] lista = {1,2, 3, 1};
//        pilha.push(1);
//        pilha.push(2);
//        pilha.push(2);
//        pilha.push(1);
//        System.out.println(pilha.ehPalindromo());

//        converterBinario(12.0);

        PilhaObj<String> pilha = new PilhaObj<>(3);
        pilha.push("Hello ");
        pilha.push("World");
        pilha.push("!");
        pilha.exibe();
        pilha.pop();
        pilha.exibe();
        pilha.pop();
        pilha.exibe();
        pilha.pop();
        pilha.exibe();

        exibirAoContrario("A pilha do gato");
        System.out.printf("\n%s", palavraEhPalindromo("subi no ônibus"));
    }

    public static Pilha converterBinario(Double num){
        int length = (int) (Math.log(num) / Math.log(2)) + 1;
        Pilha pilha = new Pilha(length);
        while (num > 1) {
            if (num % 2 == 0) {
                pilha.push(1);
            }else {
                pilha.push(0);
            }
            num = num / 2;
        }
        pilha.exibe();
        return pilha;
    }

    public static void exibirAoContrario(String frase){
        for (int i = frase.length() - 1; i >= 0; i--) {
            System.out.printf("%s", frase.charAt(i));
        }
    }

    public static boolean palavraEhPalindromo(String p){
        String palavra = limparString(p);
        PilhaObj<Character> pilha = new PilhaObj(palavra.length());
        for (int i = 0; i < palavra.length(); i++) {
            pilha.push(palavra.charAt(i));
        }
        return pilha.ehPalindromo();
//        int meio = palavra.length() / 2;
//        for (int i = 0; i < meio; i++) {
//            if (palavra.charAt(palavra.length() - (i + 1)) != palavra.charAt(i)) {
//                return false;
//            }
//        }
//        return true;
    }

    public static String limparString(String p){
        String textoSemEspacos  = p.replace(" ", "").replace("-", "");
        String textoSemAcentos = Normalizer.normalize(textoSemEspacos, Normalizer.Form.NFD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
        return textoSemAcentos.toLowerCase();
    }
}