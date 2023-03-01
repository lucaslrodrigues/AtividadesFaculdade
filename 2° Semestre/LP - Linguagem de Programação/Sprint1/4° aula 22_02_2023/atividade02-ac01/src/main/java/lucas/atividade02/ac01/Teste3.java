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
public class Teste3 {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        
        System.out.println("Valor unitario do produto:");
        Double valorUnitario = leitor.nextDouble();
        System.out.println("Quantidade:");
        Integer quantidade = leitor.nextInt();
        
        DescontoProgressivo desc = new DescontoProgressivo();
        
        desc.exibirNotaFiscal(valorUnitario, quantidade);
    }
}
