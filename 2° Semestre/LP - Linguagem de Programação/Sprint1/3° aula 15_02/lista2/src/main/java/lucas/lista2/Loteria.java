package lucas.lista2;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author aluno
 */
public class Loteria {
    public static void main(String[] args) {
        Scanner reader = new Scanner (System.in);
        
        System.out.println("Digite um número de 0 a 10:");
        Integer numDigitado = reader.nextInt();
        
        Integer numSorteado;
        Integer cont = 0;
        
        do {
            numSorteado = ThreadLocalRandom.current().nextInt(0,10);
            System.out.println(numSorteado);
            cont ++;
            
        } while (numSorteado != numDigitado);
        
        if (cont <= 3) {
            System.out.println("Você é muito sortudo!");
        } else if (cont <= 10){
            System.out.println("Você é sortudo");
        } else {
            System.out.println("É melhor você parar de apostar e ir trabalhar");
        }
    }
}
