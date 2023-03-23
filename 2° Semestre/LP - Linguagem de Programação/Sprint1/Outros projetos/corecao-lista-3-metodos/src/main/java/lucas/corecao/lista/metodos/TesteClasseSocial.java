/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lucas.corecao.lista.metodos;

import java.util.Scanner;

/**
 *
 * @author lukas
 */
public class TesteClasseSocial {
    public static void main(String[] args) {
        ClasseSocial classe = new ClasseSocial();
        Scanner leitor = new Scanner(System.in);
        
        
        System.out.println("Digite sua renda");
        Double rendaDigitada = leitor.nextDouble();
        
        Double qtdSalario = classe.calcularQtdSalMin(rendaDigitada, 1045.00 );
        
        System.out.println("Você recebe aproximadamente " + qtdSalario +
            " salários minimos.");
        
//        System.out.println(String.format("Você recebe aproximadamente %.1f"
//                + " salários minimos.", qtdSalario));
        
        String classeSocial = classe.definirClasse(qtdSalario);
//        System.out.println(String.format ("Você pertence a classe socia"
//                + " %s.", classeSocial));
        classe.exibirRelatorioClasseSocial(qtdSalario, classeSocial);
        
        classe.exibirRelatorioClasseSocial(rendaDigitada);
        classe.exibirRelatorioClasseSocial(2560.50, "D");
    }
}
