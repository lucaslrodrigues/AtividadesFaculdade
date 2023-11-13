import java.util.Scanner;

public class Exercicio6 {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        int[] dias = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int contadorDias = 0;
        System.out.println("Digite um dia: ");
        int dia = leitor.nextInt();
        System.out.println("Digite um mes: ");
        int mes = leitor.nextInt();

        if (!validaDia(dia, mes)) {
            System.out.println("[ERRO] Dia ou mês invalidos: %d/%d".formatted(dia, mes));
        }else{
            for (int i = 0; i < dias.length; i ++) {
                if (mes-1 > i) {
                    contadorDias += dias[i];
                }
            }
            contadorDias += dia;
            System.out.println("O dia %d/%d corresponde ao dia %d do ano".formatted(dia, mes, contadorDias));
        }
    }

    public static Boolean validaDia(int dia, int mes){
        if ((mes % 2 == 0 && mes > 7) || (mes % 2 != 0 && mes <= 7)){
            return dia > 0 && dia <= 31;
        }else if (mes > 0 && mes <= 12){
            return mes == 2 ? dia > 0 && dia <= 28 : dia > 0 && dia <= 30;
        }else{
            return false;
        }
    }
}
