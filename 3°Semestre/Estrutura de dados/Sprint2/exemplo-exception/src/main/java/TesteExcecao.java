import java.util.Scanner;

public class TesteExcecao {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        System.out.println("Digite o primeiro número");
        int num01 = leitor.nextInt();
        System.out.println("Digite o segundo número");
        int num02 = leitor.nextInt();

        try{
            System.out.println("A divisão é: " + (num01 / num02));
        }catch(ArithmeticException erro){
            System.out.println("Erro ao realizar divisão: " + erro.getMessage());
        }finally{
            System.out.println("Tentativa* finalizada!");
        }
    }
}
