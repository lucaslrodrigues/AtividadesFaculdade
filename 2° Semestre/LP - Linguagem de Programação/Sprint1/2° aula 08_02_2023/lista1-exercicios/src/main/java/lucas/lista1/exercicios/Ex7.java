package lucas.lista1.exercicios;

import java.util.Scanner;

/**
 *
 * @author Lucas
 */
public class Ex7 {
    public static void main(String[] args) {
        Scanner reader = new Scanner (System.in);
        
        System.out.println("Qual o limite de peso do elevador?");
        Double weightValue = reader.nextDouble();
        
        System.out.println("Qual o limite de pessoas?");
        Integer amountValue = reader.nextInt();
        
        System.out.println("Peso da 1° pessoa");
        Double person1 = reader.nextDouble();

        System.out.println("Peso da 2° pessoa");
        Double person2 = reader.nextDouble();
    
        System.out.println("Peso da 3° pessoa");
        Double person3 = reader.nextDouble();
        
        Double amountWeight = person1 + person2 + person3;
        
        System.out.println("Entraram 3 pessoas no elevador, no qual cabem "
                + amountValue + " pessoas. O peso total no elevador é de "
                + amountWeight + ", sendo que ele suporta " + weightValue);
    }
}
