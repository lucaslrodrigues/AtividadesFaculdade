/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lucas.atividade02.ac01;

import java.util.Scanner;

/**
 *
 * @author lukas
 */
public class Teste5 {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        Integer num = 0;
        do {
            System.out.println("Digite um número positivo:");
            num = leitor.nextInt();
            if (num >= 0) {
                VerificarPrimo primo = new VerificarPrimo();
                primo.exibirPrimo(num);
            }
        }while (num >= 0);
        System.out.println("Até logo");
    }
}
