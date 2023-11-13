import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {
        ListaObj<Funcionario> funcionarios = new ListaObj<>(10);

        funcionarios.adiciona(new Funcionario(1, "João Silva", "joao.silva@empresa.com", 1000.0, 2, true));
        funcionarios.adiciona(new Funcionario(2, "Maria Santos", "maria.santos@empresa.com", 1200.0, 3, false));
        funcionarios.adiciona(new Funcionario(3, "Carlos Oliveira", "carlos.oliveira@empresa.com", 1300.0, 0, true));
        funcionarios.adiciona(new Funcionario(4, "Ana Pereira", "ana.pereira@empresa.com", 1100.0, 1, false));
        funcionarios.adiciona(new Funcionario(5, "Pedro Fernandes", "pedro.fernandes@empresa.com", 1050.0, 4, true));
        funcionarios.adiciona(new Funcionario(6, "Sara Rodrigues", "sara.rodrigues@empresa.com", 1250.0, 2, false));
        funcionarios.adiciona(new Funcionario(7, "Antônio Costa", "antonio.costa@empresa.com", 1400.0, 0, true));
        funcionarios.adiciona(new Funcionario(8, "Isabel Almeida", "isabel.almeida@empresa.com", 1150.0, 3, false));
        funcionarios.adiciona(new Funcionario(9, "Rafael Santos", "rafael.santos@empresa.com", 1350.0, 2, true));
        funcionarios.adiciona(new Funcionario(10, "Marta Lima", "marta.lima@empresa.com", 1250.0, 1, false));

        Scanner leitor = new Scanner(System.in);

        boolean valida = false;
        do {
            System.out.println("""
                Escolha uma opção:
                1) Gravar Arquivo
                2) Ler Arquivo
                3) Ordenar por Quantidade de Faltas
                4) Remover Funcionários com 3 ou mais faltas
                5) Sair
                """);
            Integer opcaoEscolhida = leitor.nextInt();
            switch (opcaoEscolhida){
                case 1:
                    System.out.println("gravando arquivo");
                    GerenciadorDeArquivo.gravaArquivoCsv(funcionarios, "funcionarios");
                    break;
                case 2:
                    GerenciadorDeArquivo.leArquivoCsv("funcionarios");
                    // Complete aqui
                    break;
                case 3:
                    for (int i = 0; i < funcionarios.getTamanho() - 1; i++) {
                        for (int j = 1; j < funcionarios.getTamanho() - i; j++) {
                            if (funcionarios.getElemento(j).getQtdFaltas() < funcionarios.getElemento(j - 1).getQtdFaltas()) {
                                funcionarios.atualizarFuncionario(j);
                            }
                        }
                    }
                    GerenciadorDeArquivo.gravaArquivoCsv(funcionarios, "funcionarios");
                    break;
                case 4:
                    for (int i = 0; i < funcionarios.getTamanho(); i++) {
                        if (funcionarios.getElemento(i).getQtdFaltas() >= 3) {
                            funcionarios.removePeloIndice(i);
                            i--;
                        }
                    }
                    break;
                case 5:
                    valida = true;
                    break;
                default:
                    System.out.println("Digite um valor válido!");
                    break;
            }
        }while(!valida);
    }
}