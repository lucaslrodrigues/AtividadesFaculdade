package lucas.lista1.exercicios;

import java.util.Scanner;

/**
 *
 * @author Lucas
 */
public class Ex9 {
    public static void main(String[] args) {
        Scanner reader = new Scanner (System.in);
        
        System.out.println("Qual o seu nome?");
        String nameValue = reader.nextLine();
        
        System.out.println("Ola, " +nameValue+ "! Qual o ano de seu nascimento?");
        Integer ageValue = reader.nextInt();
        
        if (ageValue > 2023) {
            System.out.println("Data de nascimento invalida");
        }else{
            Integer age = 2030 - ageValue;
            System.out.println("Em 2030 você tera " +age+ " anos.");
        }
    }
}
