import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Repositorio repositorio = new Repositorio();
        int cont = 0;
        Scanner leitor = new Scanner(System.in);
        Scanner leitor2 = new Scanner(System.in);
        boolean condicao = true;
        while (condicao) {
            System.out.println("""
                    1 - Salvar objeto
                    2 - Deletar objeto
                    3 - Exibir
                    4 - Desfazer
                    5 - Fim
                    """);
            Integer resposta = leitor.nextInt();
            switch (resposta){
                case 1:
                    repositorio.salvar(criarRoupa(leitor, leitor2));
                    System.out.println("Teste");
                    break;
                case 2:
                    System.out.println("Qual id deseja deletar?");
                    Integer id = leitor.nextInt();
                    repositorio.deletar(id);
                    break;
                case 3:
                    repositorio.exibir();
                    break;
                case 4:
                    repositorio.desfazer();
                    break;
                case 5:
                    condicao = false;
                    break;
                default:
                    System.out.println("Digite uma opição valida");
            }
        }
    }

    public static Roupa criarRoupa(Scanner leitor, Scanner leitor2){
        System.out.println("""
                -----------------------------------------
                |         ADICIONE UMA ROUPA            |
                -----------------------------------------
                """);
        System.out.println("Tamanho da peça");
        Integer tamanho = leitor.nextInt();
        System.out.println("Nome");
        String nome = leitor2.nextLine();
        System.out.println("Preço");
        Double preco = leitor.nextDouble();
        System.out.println("Marca");
        String marca = leitor2.nextLine();
        System.out.println("Fabricação");
        String fabricacao = leitor2.nextLine();
        System.out.println("Tipo de tecido");
        String tipoTecido = leitor2.nextLine();

        return new Roupa(tamanho, nome, preco, marca, fabricacao, tipoTecido);
    }
}
