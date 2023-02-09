package lucas.lista1.exercicios;

import java.util.Scanner;
/**
 *
 * @author Lucas
 */
public class Ex8 {
    public static void main(String[] args) {
        Scanner reader = new Scanner (System.in);
        
        System.out.println("Digite seu nome:");
        String name = reader.nextLine();
        
        System.out.println("Digite sua primeira nota:");
        Double score1 = reader.nextDouble();
        System.out.println("Digite a segunda nota:");
        Double score2 = reader.nextDouble();
        
        Double average = (score1 + score2) / 2;
        
        System.out.println("Olá, " +name+ ". Sua média foi de " + average);
    }
}
