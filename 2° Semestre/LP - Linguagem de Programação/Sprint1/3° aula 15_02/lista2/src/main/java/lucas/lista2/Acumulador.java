package lucas.lista2;

import java.util.Scanner;

/**
 *
 * @author aluno
 */
public class Acumulador {
    public static void main(String[] args) {
        Scanner reader = new Scanner (System.in);
        
        System.out.println("Digite:");
        Integer numeroDigitado = reader.nextInt();
        
        Integer acumulado = 0;
        while (numeroDigitado != 0) {
            acumulado += numeroDigitado;
            numeroDigitado = reader.nextInt();
        }
        
        String frase = String.format("A soma dos números é %d", acumulado);
        System.out.println(frase);
    }
}
