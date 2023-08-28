import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Carrinho carrinho = new Carrinho();
        Boolean validacao = false;
        Scanner leitor = new Scanner(System.in);
        Scanner leitor2 = new Scanner(System.in);
        String barraFormat = "====================";

        do{
            boolean validaCampos = false;
            System.out.println("%s Opções %s\n".formatted(barraFormat, barraFormat) +
                    "1. Adicionar livro\n" +
                    "2. Adicionar DVD\n" +
                    "3. Adicionar Servico\n" +
                    "4. Exibir itens do carrinho\n" +
                    "5. Exibir total de venda\n" +
                    "6. Fim\n:");
            String opicao = leitor.next();

            switch (opicao) {
                case "1":
                    int codigoLivro;
                    Double precoCustoLivro;
                    String nomeLivro;
                    String autorLivro;
                    String isbnLivro;
                    do {
                        System.out.println("%s Crie um livro %s".formatted(barraFormat, barraFormat));
                        System.out.println("Codigo: ");
                        codigoLivro = leitor.nextInt();

                        System.out.println("Preço de custo do livro: ");
                        precoCustoLivro = leitor.nextDouble();

                        System.out.println("Nome do livro: ");
                        leitor.nextLine();
                        nomeLivro = leitor.nextLine();

                        System.out.println("Autor: ");
                        autorLivro = leitor2.nextLine();

                        System.out.println("ISBN: ");
                        isbnLivro = leitor2.nextLine();

                        if (precoCustoLivro < 0.0 || nomeLivro.isEmpty() || autorLivro.isEmpty() || isbnLivro.isEmpty()) {
                            System.out.println("Preencha os dados do livro corretamente");
                        } else {
                            validaCampos = true;
                        }
                    } while (!validaCampos);

                    Livro livro = new Livro(codigoLivro, precoCustoLivro, nomeLivro, autorLivro, isbnLivro);
                    carrinho.adicionaVendavel(livro);
                    break;
                case "2":
                    int codigoDvd;
                    Double precoCustoDvd;
                    String nomeDvd;
                    String gravadoraDvd;
                    do {
                        System.out.println("%s Crie um DVD %s".formatted(barraFormat, barraFormat));
                        System.out.println("Codigo: ");
                        codigoDvd = leitor.nextInt();

                        System.out.println("Preço de custo: ");
                        precoCustoDvd = leitor.nextDouble();

                        System.out.println("Nome: ");
                        nomeDvd = leitor2.nextLine();

                        System.out.println("Gravadora: ");
                        gravadoraDvd = leitor2.nextLine();

                        if (precoCustoDvd < 0.0 || nomeDvd.isEmpty() || gravadoraDvd.isEmpty()) {
                            System.out.println("Preencha os dados do livro corretamente");
                        } else {
                            validaCampos = true;
                        }
                    } while (!validaCampos);

                    Dvd dvd = new Dvd(codigoDvd, precoCustoDvd, nomeDvd, gravadoraDvd);
                    carrinho.adicionaVendavel(dvd);
                    break;
                case "3":
                    String descricaoServico;
                    int codigoServico;
                    int quantHoraServico;

                    Double valorHoraervico;
                    System.out.println("%s Crie um serviço %s".formatted(barraFormat, barraFormat));
                    System.out.println("Codigo: ");
                    codigoServico = leitor.nextInt();

                    System.out.println("Descrição");
                    leitor.nextLine();
                    descricaoServico = leitor.nextLine();

                    System.out.println("Quantidade de horas: ");
                    quantHoraServico = leitor2.nextInt();

                    System.out.println("Valor hora: ");
                    valorHoraervico = leitor.nextDouble();

                    Servico servico = new Servico(descricaoServico, codigoServico, quantHoraServico, valorHoraervico);
                    carrinho.adicionaVendavel(servico);
                    break;
                case "4":
                    System.out.println("%s Itens do carrinho %s".formatted(barraFormat, barraFormat));
                    carrinho.exibeItensCarrinho();
                    break;

                case "5":
                    System.out.println("%s======".formatted(barraFormat));
                    System.out.println("Total em vendas: R$%.2f".formatted(carrinho.calculaTotalVenda()));
                    System.out.println("%s======".formatted(barraFormat));
                    break;

                case "6":
                    validacao = true;
                    System.out.println("Até a próxima!");
                    break;

                default:
                    System.out.println("[ERRO] Opção inválida");
            }

        } while (validacao.equals(false));
    }
}
