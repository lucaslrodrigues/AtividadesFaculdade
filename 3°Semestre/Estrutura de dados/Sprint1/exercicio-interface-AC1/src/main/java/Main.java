import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Carrinho carrinho = new Carrinho();
        boolean validacao = true;
        Scanner leitor = new Scanner(System.in);


        while (validacao){
            System.out.println("""
                    1. Adicionar livro
                    2. Adicionar DVD
                    3. Adicionar Servico
                    4. Exibir itens do carrinho
                    5. Exibir total de venda
                    6. Fim
                    """);
            int opicao = leitor.nextInt();

            switch (){
                case 1:
                    System.out.println("Crie um livro");
                    System.out.println("Codigo: ");
                    int codigoLivro = leitor.nextInt();
                    leitor.next();
                    System.out.println("Preço de custo do livro: ");
                    Double precoCustoLivro = leitor.nextDouble();
                    leitor.next();

                    System.out.println("Nome do livro: ");
                    String nomeLivro = leitor.nextLine();
                    leitor.next();
                    System.out.println("Autor: ");
                    String autorLivro = leitor.nextLine();
                    leitor.next();
                    System.out.println("ISBN: ");
                    String isbnLivro = leitor.nextLine();
                    leitor.next();

                    Livro livro = new Livro(codigoLivro, precoCustoLivro, nomeLivro, autorLivro, isbnLivro);

                    carrinho.adicionaVendavel(livro);
                    break;
                case 2:
                    System.out.println("Crie uma gravadora");
                    System.out.println("Codigo: ");
                    int codigoDvd = leitor.nextInt();
                    leitor.next();
                    System.out.println("Preço de custo: ");
                    Double precoCustoDvd = leitor.nextDouble();
                    leitor.next();

                    System.out.println("Nome: ");
                    String nomeDvd = leitor.nextLine();
                    leitor.next();

                    System.out.println("Gravadora: ");
                    String gravadoraDvd = leitor.nextLine();
                    leitor.next();

                    Dvd dvd = new Dvd(codigoDvd, precoCustoDvd, nomeDvd, gravadoraDvd);
                    carrinho.adicionaVendavel(dvd);
                    break;
                case 3:
                    System.out.println("Crie um serviço");
                    System.out.println("Codigo: ");
                    int codigoServico = leitor.nextInt();
                    leitor.next();

                    System.out.println("Descrição");
                    String descricaoServico = leitor.nextLine();
                    leitor.next();

                    System.out.println("Quantidade de horas: ");
                    int quantHoraServico = leitor.nextInt();
                    leitor.next();

                    System.out.println("Valor hora: ");
                    Double valorHoraervico = leitor.nextDouble();
                    leitor.next();

                    Servico servico = new Servico();
            }

        }
    }
}
