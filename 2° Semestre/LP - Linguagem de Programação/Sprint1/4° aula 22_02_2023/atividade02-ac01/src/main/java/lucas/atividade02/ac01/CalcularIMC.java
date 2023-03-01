/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lucas.atividade02.ac01;

/**
 *
 * @author lucas
 */
public class CalcularIMC {
    Double calcular (Double peso, Double altura){
        Double imc = peso / (altura * altura);
        return imc;
    }
    
    void exibirIMC (Double peso, Double altura, Integer contador){
        Double imc = calcular(peso, altura);
        String bar = "\n--------------------------------------------\n";
        System.out.println(String.format("%s%d° Pessoa\n"
                + "IMC: %.2f %s", bar, contador, imc, bar));
    }
}
