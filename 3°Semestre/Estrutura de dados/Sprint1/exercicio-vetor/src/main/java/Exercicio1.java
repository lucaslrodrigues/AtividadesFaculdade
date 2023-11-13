import java.util.Scanner;

public class Exercicio1 {

    public static int[] adicionarAoVetor(int[] vetor){
        Scanner leitor = new Scanner(System.in);

        for (int i = 0; i < vetor.length; i++){
            System.out.println("Digite um número");
            Integer num = leitor.nextInt();
            vetor[i] = num;
        }
        return vetor;
    }

    public static void exibirNumeros(int[] vetor){
        for (int i = 0; i < vetor.length; i++) {
            System.out.println(String.format("[%d] = %d", i, vetor[i]));
        }
    }

    public static void exibirInverso(int[] vetor){
        for (int i = vetor.length; i > 0; i--) {
            System.out.println(String.format("[%d] = %d", i, vetor[i-1]));
        }
    }
    public static void main(String[] args) {
        int[] vetor = new int[7];
        vetor = adicionarAoVetor(vetor);
        System.out.println("\nVETOR");
        exibirNumeros(vetor);
        System.out.println("\nVETOR INVERSO");
        exibirInverso(vetor);

    }
}
