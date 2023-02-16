/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lucas.lista2;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author aluno
 */
public class Sorteio {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        
        System.out.println("Digite um número de 0 a 100");
        Integer numDigitado = reader.nextInt();
        
        Integer numSorteado;
        Boolean first = true;
        
        String frase1 = "";
        Integer pares = 0;
        Integer impares = 0;
        
        for (int i = 0; i < 200; i ++){
            numSorteado = ThreadLocalRandom.current().nextInt(0,100);
            
            if (first) {
                if (numSorteado == numDigitado) {
                    frase1 = String.format
                    ("Primeira aparição na %d° posição", i);
                    first = false;
                } else {
                    frase1 = "Não foi sorteado";
                }
            }
            
            if (numSorteado%2 == 0){
                pares ++;
            }
            if (numSorteado%2 != 0){
                impares++;
            }
        }
        
        System.out.println(frase1 + "\nTotal de pares: " 
                + pares + "\nTotal de impares: " + impares);
    }
}
