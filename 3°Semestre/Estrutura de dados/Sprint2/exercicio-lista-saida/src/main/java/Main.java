import org.w3c.dom.ls.LSOutput;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ListaObj<Roupa> roupas = new ListaObj<>(5);
        Scanner leitor = new Scanner(System.in);
        Scanner leitor2 = new Scanner(System.in);
        String barra = "====================";
        System.out.printf("%s LOJA DO LIMÃO %s%n", barra, barra);

        boolean repete = true;
        while (repete) {
            exibeOpcoes();
            int opcao = leitor.nextInt();

            switch (opcao) {
                case 1:
                    addProduto(leitor, leitor2, roupas, barra);
                    break;
                case 2:
                    if (roupas.getTamanho() > 0) {
                        System.out.printf("%-7s %-12s %7s %7s %-14s %-14s %-14s\n", "id", "Nome", "Tamanho", "Preço", "Marca", "fabricação", "tipo de tecido");
                        roupas.exibe();
                    }else{
                        System.out.println("Nada para exibir");
                    }
                    break;
                case 3:
                    System.out.println("Gravando arquivo CSV...");
                    if (roupas.getTamanho() > 0) {
                        GerenciadorDeArquivos.gravaArquivoCsv(roupas, "minhas_roupas");
                    } else {
                        System.out.println("Lista vazia");
                    }
                    break;
                case 4:
                    GerenciadorDeArquivos.leArquivoCsv("minhas_roupas");
                    break;
                case 5:
                    GerenciadorArquivoTxt.gravaArquivoTxt(roupas, "roupas");
                    break;
                case 6:
                    GerenciadorArquivoTxt.leArquivoTxt("roupas");
                case 7:
                    repete = false;
                    break;
                default:
                    System.out.println("[ERRO] Insira uma opção válida!");
                    break;
            }
            System.out.printf("%s ... %s%n", barra, barra);
        }
        System.out.println("Até a próxima!");
    }
    public static void exibeOpcoes(){
        System.out.printf("""
                Escolha a opção desejada:
                1 - Adicionar um produto
                2 - Exibir um relatório
                3 - Gravar CSV
                4 - Ler arquivo
                5 - Gravar txt
                6 - Ler txt
                7 - sair
                """);
    }

    public static void addProduto(Scanner leitor, Scanner leitor2, ListaObj roupas, String barra){
        System.out.println(String.format("%s Adicionado roupa %s", barra, barra));
        System.out.println("Tamanho");
        int tamanho = leitor.nextInt();
        System.out.println("Nome");
        String nome = leitor2.nextLine();
        System.out.println("Preço");
        double preco = leitor.nextDouble();
        System.out.println("Marca");
        String marca = leitor2.nextLine();
        System.out.println("Fabricação");
        String fabricacao = leitor2.nextLine();
        System.out.println("Tipo tecido");
        String tipoTecido = leitor2.nextLine();

        Roupa roupaAdicionar = new Roupa(tamanho, nome, preco, marca, fabricacao, tipoTecido);
        roupas.adiciona(roupaAdicionar);
    }
}
