package lucas.segundo.projeto.nivelamento;

import java.util.Scanner;

/**
 *
 * @author aluno
 */
public class EstruturaDeRepeticao {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        
        // For
        System.out.println("For 1 a 10");
        for (int i = 0; i <= 10; i ++){
            System.out.println(i);
        }
        System.out.println("For 10 a 0");
        
        for (int i = 10; i >= 0; i --){
            System.out.println(i);
        }
        
        // While
        int i = 0;
        while (i <= 10){
            System.out.println(i);
            i ++;
        }
        
        System.out.println("While - Adivinhe o número");
        
        System.out.println("Digite um número");
        Integer numeroDigitado = leitor.nextInt();
        
        while(numeroDigitado != 42){
            System.out.println("Adivinhe o número");
            numeroDigitado = leitor.nextInt();
        }
        
        System.out.println("Acertou!\n");
        
        // Do while
        System.out.println("do while - Adivinhe o número");
        
//        System.out.println("Digite um número");
//        numeroDigitado = leitor.nextInt();
        
        do {
            System.out.println("Adivinhe o número");
            numeroDigitado = leitor.nextInt();
        } while (numeroDigitado != 42);
        System.out.println("Acertou!");
    }
}
