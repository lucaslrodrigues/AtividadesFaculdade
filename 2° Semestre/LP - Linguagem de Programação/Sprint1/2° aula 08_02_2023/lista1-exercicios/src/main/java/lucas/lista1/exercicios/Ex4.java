package lucas.lista1.exercicios;

import java.util.Scanner;

/**
 *
 * @author Lucas
 */
public class Ex4 {
    public static void main(String[] args) {
        Scanner reader = new Scanner (System.in);
        
        System.out.println("Digite o valor unitario do produto:");
        Double unitaryValue = reader.nextDouble();
        
        System.out.println("Quantidade vendida:");
        Integer amount = reader.nextInt();
        
        System.out.println("Valor pago pelo cliente:");
        Double amountPaid = reader.nextDouble();
        
        Double saleValue = amount * unitaryValue;
        
        if (amountPaid < saleValue) {
            System.out.println("Não há troco, faltam R$" + (saleValue - amountPaid));
        }else{
            System.out.println("Seu troco será de R$ " + (amountPaid - saleValue));
        }
    }
}
