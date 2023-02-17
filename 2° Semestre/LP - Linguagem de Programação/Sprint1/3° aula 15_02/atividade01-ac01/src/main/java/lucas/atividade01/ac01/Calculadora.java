package lucas.atividade01.ac01;

import com.sun.jdi.DoubleValue;
import java.util.Scanner;

/**
 *
 * @author Lucas
 */
public class Calculadora {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        Boolean verify = true;
        while (verify) {

            System.out.println("Digite o número correspondete "
                    + "a operação desejada:\n"
                    + "1 - Soma\n2 - Multiplicação\n3 - Divisão\n4 - Subtração"
                    + "\n0 - sair");
            Integer operationNum = reader.nextInt();
            
            
            if (operationNum != 0) {
                
                System.out.println("Digite um número inteiro");
                Integer integerNum = reader.nextInt();
                Integer result;

                switch (operationNum) {
                    case 1:
                        for (int i = 1; i <= 10; i++) {
                            result = integerNum + i;
                            System.out.println(String.format("%d + %d = "
                                    + "%d", integerNum, i, result));
                        }
                        break;
                    case 2:
                        for (int i = 1; i <= 10; i++) {
                            result = integerNum * i;
                            System.out.println(String.format("%d * %d = "
                                    + "%d", integerNum, i, result));
                        }
                        break;
                    case 3:
                        for (int i = 1; i <= 10; i++) {
                            // Verificando se a divisão resulta em um número quebrado
                            if ((integerNum / i) == 0) {
                                Double resDivision = integerNum.doubleValue() / i;
                                if (resDivision > 0) {
                                    System.out.println(String.format("%d + %d = "
                                            + "%.2f", integerNum, i, resDivision));
                                } else {
                                    result = integerNum / i;
                                    System.out.println(String.format("%d + %d = "
                                        + "%d", integerNum, i, result));
                                }
                            } else {
                                    result = integerNum / i;
                                    System.out.println(String.format("%d + %d = "
                                        + "%d", integerNum, i, result));
                            }
                        }
                        break;
                    case 4:
                        for (int i = 1; i <= 10; i++) {
                            result = integerNum - i;
                            System.out.println(String.format("%d + %d = "
                                    + "%d", integerNum, i, result));
                        }
                        break;
                    default:
                        System.out.println("Opção inválida, tente novamente");
                }
            }else {
                System.out.println("Até logo!");
                verify = false;
            }
        }

    }
}
