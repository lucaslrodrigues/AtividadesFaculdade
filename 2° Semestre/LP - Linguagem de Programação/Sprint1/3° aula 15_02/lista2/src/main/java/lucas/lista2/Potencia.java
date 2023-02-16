package lucas.lista2;

import java.util.Scanner;

/**
 *
 * @author aluno
 */
public class Potencia {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        
        System.out.println("Digite um numero");
        Integer num1 = reader.nextInt();
        System.out.println("Digite o expoente");
        Integer num2 = reader.nextInt();
        
        Integer mult = num1;
        for (int i = 0; i < num2-1; i ++) {
            mult *= num1;
        }
        
        String frase = String.format ("%d elevado a %d é igual a %d",
                num1, num2, mult);
        
        System.out.println(frase);
    }
}
