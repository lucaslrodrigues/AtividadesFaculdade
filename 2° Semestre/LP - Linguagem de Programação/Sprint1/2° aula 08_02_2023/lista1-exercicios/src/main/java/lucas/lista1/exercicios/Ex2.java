package lucas.lista1.exercicios;


import java.util.Scanner;

/**
 *
 * @author aluno
 */
public class Ex2 {
    public static void main(String[] args) {
        Scanner reader = new Scanner (System.in);
        
        System.out.println("Quantos filhos você tem entre 0 a três anos de idade?");
        Integer sonsZeroToThree = reader.nextInt();
        
        System.out.println("Quantos filhos você tem entre 4 a 16 anos de idade?");
        Integer sonsFourToSixten = reader.nextInt();
        
        System.out.println("Quantos filhos você tem entre 17 a 18 anos de idade?");
        Integer sonsSeventenToEighten = reader.nextInt();
        
        Double sum;
        Integer mountChilds = sonsZeroToThree + sonsFourToSixten + sonsSeventenToEighten;
        
            Double child1 = sonsZeroToThree * 25.12;
            Double child2 = sonsFourToSixten * 15.88;
            Double child3 = sonsSeventenToEighten * 12.44;
        
        sum = child1 + child2 + child3;
        
        System.out.println("Você tem um total de " 
                + mountChilds + " filhos e vai receber R$ " 
                + sum + " de bolsa");
    }
}
