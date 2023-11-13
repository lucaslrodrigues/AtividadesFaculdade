import java.util.Scanner;
public class Exercicio5 {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        String[] listaModelos = new String[5];
        int[] listaRendimentos = new int[5];
        int maior = 0;

        for (int i = 0; i < 5; i++) {
            System.out.println("Digite o nome do %d° modelo de carro".formatted(i+1));
            listaModelos[i] = leitor.nextLine();
        }

        for (int i = 0; i < 5; i++) {
            System.out.println("Digite rendimento do modelo %s".formatted(listaModelos[i]));
            listaRendimentos[i] = leitor.nextInt();
        }

        for (int i = 0; i < 5; i++) {
            maior = (listaRendimentos[maior] < listaRendimentos[i]) && (i > 0) ? i : maior;
        }
        System.out.println("O carro com maior rendimento é o %s".formatted(listaModelos[maior]));
    }
}
