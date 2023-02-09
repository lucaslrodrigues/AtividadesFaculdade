package lucas.lista1.exercicios;

import java.util.Scanner;

/**
 *
 * @author Lucas
 */
public class Ex5 {
    public static void main(String[] args) {
        Scanner reader = new Scanner (System.in);
        
        System.out.println("Digite um numero:");
        Double num1 = reader.nextDouble();
        
        System.out.println("Digite outro numero:");
        Double num2 = reader.nextDouble();
        
        System.out.println("Resultado da soma:\n"+ (num1 + num2) +
                "\nResultado da subtração:\n" + (num1 - num2) +
                "\nResultado da multiplicação:\n" + (num1 * num2) +
                "\nResultado da divisão:\n" + (num1 / num2));
    }
}
