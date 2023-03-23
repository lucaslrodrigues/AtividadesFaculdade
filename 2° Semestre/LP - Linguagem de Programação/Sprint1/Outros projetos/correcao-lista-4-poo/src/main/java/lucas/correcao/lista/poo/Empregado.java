/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lucas.correcao.lista.poo;

/**
 *
 * @author lukas
 */
public class Empregado {
    String nome;
    Double salario;
    String cargo;
    
    Double reajustarSalario(Double porcentagemReajuste){
        return salario + (salario * (porcentagemReajuste / 100));
    }
    
    void imprimirSalario(Double porcentagemReajuste){
        
        Double salarioReajustado = reajustarSalario(porcentagemReajuste);
        
        System.out.println(String.format("Nome: %s\n"
                + "cargo: %s\n"
                + "Salario Reajustado: %.2f\n",
                nome, cargo, salarioReajustado));
    }
}
