/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lucas.atividade02.ac01;

import java.util.Scanner;

/**
 *
 * @author aluno
 */
public class Teste1 {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        
        System.out.println("Digite a primeira nota");
        Double nota1 = leitor.nextDouble();
        System.out.println("Digite a segunda nota");
        Double nota2 = leitor.nextDouble();
        
        CalculoAluno calc = new CalculoAluno();
        
        Double mediaNota = calc.calcularMedia(nota1, nota2);
        
        System.out.println(String.format("Média: %.1f", mediaNota));
    }
}
