/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lucas.atividade02.ac01;

/**
 *
 * @author lucas
 */
public class VerificarPrimo {
    Integer isPrimo (Integer num){
        Integer cont = 0;
        Integer i = 1;
        while (i < 1000 || i <= num) {
            if (num % i == 0) {
                cont ++; 
            }
            i ++;
        }
//        ;
//        if (num % 1 == 0) {
//           cont ++; 
//        }
//        if (num % 2 == 0) {
//            cont ++;
//        }
//        if (num % 3 == 0) {
//            cont ++;
//        }
//        if (num % 5 == 0) {
//            cont ++;
//        }
//        if (num % 7 == 0) {
//            cont ++;
//        }
//        if (num % 9 == 0) {
//            cont ++;
//        }
//        if (num % num == 0) {
//            cont ++
//        }
        return cont;
    }
    
    void exibirPrimo(Integer num){
        Integer qtdDivisores = isPrimo(num);
        String bar = "\n----------------------------------------\n";
        if (qtdDivisores > 2){
            System.out.println(String.format("%s"
                    + "O número %d não é um número primo\n"
                    + "Ele possiu %d divisores.%s",
                    bar, num, qtdDivisores, bar));
        }else {
            System.out.println(String.format("%s"
                + "O número %d é um número primo\n"
                + "Ele possiu %d divisores.%s",
                bar, num, qtdDivisores, bar));
        }
    }
}
