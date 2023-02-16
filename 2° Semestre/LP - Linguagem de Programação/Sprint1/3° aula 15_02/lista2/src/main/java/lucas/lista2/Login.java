package lucas.lista2;

import java.util.Scanner;

/**
 *
 * @author aluno
 */
public class Login {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        
        System.out.println("Digite um usuário:");
        String usuarioDigitado = reader.nextLine();
        System.out.println("Digite uma senha");
        String senhaDigitada = reader.nextLine();
        
        while (!("admin".equals(usuarioDigitado) && "#SPtech2022".equals(senhaDigitada))){
            System.out.println("Login e/ou senha invalidos");
            
            System.out.println("Digite um usuário:");
            usuarioDigitado = reader.nextLine();
            System.out.println("Digite uma senha");
            senhaDigitada = reader.nextLine();
        }
        
        System.out.println("Login realizado com sucesso!");
    }
 
}
