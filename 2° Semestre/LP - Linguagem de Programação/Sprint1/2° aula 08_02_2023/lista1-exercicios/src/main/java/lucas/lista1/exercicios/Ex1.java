package lucas.lista1.exercicios;


import java.util.Scanner;


/**
 *
 * @author aluno
 */
public class Ex1 {
    public static void main(String[] args) {
        Scanner leitor = new Scanner (System.in);
        
        System.out.println("Digite o login");
        String loginDigitado = leitor.nextLine();
        
        System.out.println("Digite a senha");
        String senhaDigitada = leitor.nextLine();
        
        System.out.println("Digite a quantidade de tentativas antes do bloqueio");
        String tentativasDigitadas = leitor.nextLine();
        
        System.out.println("Seu login é "+loginDigitado+" e sua senha é "
                +senhaDigitada+". \nVocê tem " +tentativasDigitadas+ 
                " tentativas antes de ser bloqueado");
    }
}
