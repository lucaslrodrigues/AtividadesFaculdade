import java.util.Scanner;

public class DivisaoLoop {
    public static void main(String[] args) {
        boolean fim = false;

        while (!fim) {
            Scanner leitor = new Scanner(System.in);

            System.out.println("Digite o primeiro número");
            String num01 = leitor.nextLine();
            System.out.println("Digite o segundo número");
            String num02 = leitor.nextLine();

            try{
                int n01Convertido = Integer.parseInt(num01);
                int n02Convertido = Integer.parseInt(num02);
                System.out.println("A divisão é: " + (n01Convertido / n02Convertido));
                fim = true;
            }catch(ArithmeticException erro){
                System.out.println("Erro ao realizar divisão: " + erro.getMessage());
            }catch (NumberFormatException erro){
                System.out.println("Erro ao ler número!: "+ erro.getMessage());
            }finally{
                System.out.println("Tentativa* finalizada!");
            }
        }
    }
}
