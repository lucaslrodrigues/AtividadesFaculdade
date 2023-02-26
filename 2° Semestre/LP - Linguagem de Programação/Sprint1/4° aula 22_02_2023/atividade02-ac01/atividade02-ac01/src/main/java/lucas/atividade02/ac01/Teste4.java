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
public class Teste4 {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        Boolean verify = true;
        Integer cont = 1;
        do{
            System.out.println("Digite o peso");
            Double peso = leitor.nextDouble();
            System.out.println("Digite a altura");
            Double altura = leitor.nextDouble();
            
            CalcularIMC imc = new CalcularIMC();
            imc.exibirIMC(peso, altura, cont);
            cont ++;
            
            System.out.println("Calcular mais um IMC?\nSim: 1\nNão: 0");
            Integer continuar = leitor.nextInt();
            
            if(continuar == 0){
                verify = false;
            }
        } while (verify);
    }
}
