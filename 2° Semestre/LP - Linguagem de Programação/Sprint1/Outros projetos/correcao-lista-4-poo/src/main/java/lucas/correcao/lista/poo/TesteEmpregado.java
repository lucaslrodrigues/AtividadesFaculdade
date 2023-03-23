/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lucas.correcao.lista.poo;

/**
 *
 * @author lukas
 */
public class TesteEmpregado {
    public static void main(String[] args) {        
        Empregado empreg1 = new Empregado();
        Empregado empreg2 = new Empregado();

        empreg1.nome = "João";
        empreg1.salario = 5400.00;
        empreg1.cargo = "Analista de Sistemas";
        empreg1.imprimirSalario(15.0);

        empreg2.nome = "Maria Pia";
        empreg2.salario = 8000.00;
        empreg2.cargo = "Product Owner";
        empreg2.imprimirSalario(15.0);
    }
}
