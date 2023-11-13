import java.util.Scanner;

public class TesteVetores {

    public static void exibirVetor(int[] vetor){
        // Exibindo valores do vetor
        for (int i = 0; i < vetor.length; i++) {
            System.out.println(String.format("[%d] = %d", i, vetor[i]));
        }
    }

    public static void exibirStrings(String[] vetor){
        for (int i = 0; i < vetor.length; i++) {
            System.out.println(String.format("[%d] = %s", i, vetor[i]));
        }
    }
    public static void main(String[] args) {
        int[] vetor01 = new int[10];
        int[] vetor02 = {100, 200, 300, 400, 500};
        String[] vetor03 = new String[4];

        // Alterando valores vetor01

        for (int i = 0; i < vetor01.length; i++) {
            vetor01[i] = i * 10;
        }

        System.out.println("Exibindo vetor01:");
        exibirVetor(vetor01);
        System.out.println("\nExibindo vetor02:");
        exibirVetor(vetor02);
        System.out.println("\nExibindo vetor03");
        exibirStrings(vetor03);

        Scanner leitor = new Scanner(System.in);

        for (int i = 0; i < vetor03.length; i++){
            System.out.println("Digite um nome");
            String nome = leitor.nextLine();
            vetor03[i] = nome;
        }
        exibirStrings(vetor03);

    }
}
