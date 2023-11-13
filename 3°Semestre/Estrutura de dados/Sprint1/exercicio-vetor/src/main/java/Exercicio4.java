import java.util.Scanner;

public class Exercicio4 {
    public static void main(String[] args) {
        int[] numeros = new int[10];
        Scanner leitor = new Scanner(System.in);

        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Digite um número");
            Integer num = leitor.nextInt();
            numeros[i] = num;
        }

        System.out.println("Digite um número qualquer:");
        Integer num = leitor.nextInt();
        int qtd = 0;
        for (Integer i: numeros){
            if (i.equals(num)){
                qtd += 1;
            }
        }
        System.out.println(String.format("O número %d ocorre %d vezes", num, qtd));
    }
}
