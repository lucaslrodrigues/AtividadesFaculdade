import java.util.Scanner;

public class Exercicio2 {
    public static int[] adicionarAoVetor(int[] vetor){
        Scanner leitor = new Scanner(System.in);

        for (int i = 0; i < vetor.length; i++){
            System.out.println("Digite um número");
            Integer num = leitor.nextInt();
            vetor[i] = num;
        }
        return vetor;
    }

    public static Double calcularMedia(int[] vetor){
        int total = 0;

        for (int i = 0; i < vetor.length; i++) {
            total += vetor[i];
        }
        return (double) (total / vetor.length);
    }

    public static void main(String[] args) {
        int[] vetor = new int[10];
        vetor = adicionarAoVetor(vetor);
        Double media = calcularMedia(vetor);
        System.out.println(String.format("Média: %.2f",media));
        System.out.println("\nAcima da média");
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] > media) {
                System.out.println(String.format("[%d] = %d", i, vetor[i]));
            }
        }
    }
}
