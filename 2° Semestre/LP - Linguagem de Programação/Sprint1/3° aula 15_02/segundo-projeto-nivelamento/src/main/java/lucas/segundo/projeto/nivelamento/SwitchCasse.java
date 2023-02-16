package lucas.segundo.projeto.nivelamento;

import java.util.Scanner;

/**
 *
 * @author aluno
 */
public class SwitchCasse {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        System.out.println("Digite um número que corresponde "
                + "ao dia da semana:");

        Integer diaDigitado = leitor.nextInt();

        switch (diaDigitado) {
            case 1:
                System.out.println("Segundou");
                break;
            case 2:
                System.out.println("Terçou");
                break;
            case 3:
                System.out.println("Quartou");
                break;
            case 4:
                System.out.println("Quintou");
                break;
            case 5:
                System.out.println("Sextou");
                break;
            case 6:
                System.out.println("Sabadou");
                break;
            case 7:
                System.out.println("Domingou");
                break;
            default:
                System.out.println("Dia inválido");
        }
    }
}
