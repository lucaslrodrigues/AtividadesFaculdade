import java.util.Scanner;

public class Exercicio3 {
    public static String[] digitarNomes(String[] vetor, Scanner leitor){
            for (int i = 0; i < vetor.length; i++) {
            System.out.println("Digite um nome");
            String nome = leitor.nextLine();
            vetor[i] = nome;
        }
        return vetor;
    }

    public static String pesquisarNome(String[] vetor, String nome){
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i].equals(nome)) {
                return String.format("Nome encontrado no indice %d", i);
            }
        }
        return "Nome não encontrado";
    }

    public static String pedirNome(Scanner leitor){
        System.out.println("Digite um nome para ser buscado na lista: ");
        String nome = leitor.nextLine();
        return nome;
    }
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        String[] vetor = new String[10];
        vetor = digitarNomes(vetor, leitor);
        String nome = pedirNome(leitor);
        System.out.println(pesquisarNome(vetor, nome));

    }

}
