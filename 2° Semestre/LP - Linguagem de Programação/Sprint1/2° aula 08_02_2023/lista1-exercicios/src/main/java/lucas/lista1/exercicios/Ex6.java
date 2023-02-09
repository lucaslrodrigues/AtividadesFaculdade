package lucas.lista1.exercicios;

import java.util.Scanner;

/**
 *
 * @author Lucas
 */
public class Ex6 {
    public static void main(String[] args) {
        Scanner reader = new Scanner (System.in);
        
        System.out.println("Digite o salario bruto:");
        Double salaryValue = reader.nextDouble();
        
        System.out.println("Qual é o valor gasto em "
                + "transporte na ida para o trablaho?");
        Double transportValue = reader.nextDouble();
        
        Double inss = salaryValue * 0.10;
        Double ir = salaryValue * 0.20;
        Double transport = (transportValue * 2) * 22;
        
        Double discount = inss + ir + transport;
        Double total = salaryValue - discount;
        
        System.out.println("Seu salário bruto é R$" 
                + salaryValue + ", tem um total de R$"
                + discount + " em descontos e receberá um líquido de R$" 
                + total);
    }
}
