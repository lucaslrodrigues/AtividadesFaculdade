import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class GerenciadorDeArquivo {
    public static void gravaArquivoCsv(ListaObj<Funcionario> lista, String nomeArq) {
        FileWriter arq = null;
        Formatter saida = null;
        Boolean deuRuim = false;

        nomeArq += ".csv";

        // Bloco try-catch para abrir o arquivo
        try {
            arq = new FileWriter(nomeArq);
            saida = new Formatter(arq);
        } catch (IOException erro) {
            System.out.println("Erro ao abrir o arquivo");
            System.exit(1);
        }

        // Bloco try-catch para gravar o arquivo
        try {
            for (int i = 0; i < lista.getTamanho(); i++) {
                //Recupere um elemento da lista e formate aqui:
                Funcionario funcionario = lista.getElemento(i);
                saida.format("%d;%s;%s;%.2f;%d;%b\n", funcionario.getId(), funcionario.getNome(), funcionario.getEmail(), funcionario.getSalario(), funcionario.getQtdFaltas(), funcionario.isRecebeComissao());
            }
        } catch (FormatterClosedException erro) {
            System.out.println("Erro ao gravar o arquivo");
            deuRuim = true;
        } finally {
            saida.close();
            try {
                arq.close();
            } catch (IOException erro) {
                System.out.println("Erro ao fechar o arquivo");
                deuRuim = true;
            }
            if (deuRuim) {
                System.exit(1);
            }
        }
    }

    public static void leArquivoCsv(String nomeArq) {
        FileReader arq = null;
        Scanner entrada = null;
        Boolean deuRuim = false;

        nomeArq += ".csv";

        // Bloco try-catch para abrir o arquivo
        try {
            arq = new FileReader(nomeArq);
            entrada = new Scanner(arq).useDelimiter(";|\\n");
        } catch (FileNotFoundException erro) {
            System.out.println("Arquivo nao encontrado");
            System.exit(1);
        }

        // Bloco try-catch para ler o arquivo
        try {
            // Print Cabeçalho:
            System.out.printf("%4s %-25s %-30s %7s %10s %8s\n", "id", "nome", "email", "salario", "qtd faltas", "comissão");
            while (entrada.hasNext()) {
                //Print Corpo:
                int id = entrada.nextInt();
                String nome = entrada.next();
                String email = entrada.next();
                double salario = entrada.nextDouble();
                int qtdFaltas = entrada.nextInt();
                boolean commissao = entrada.nextBoolean();
                System.out.printf("%4d %-25s %-30s %7.2f %10d %b\n", id, nome, email, salario, qtdFaltas, commissao);
            }
        } catch (NoSuchElementException erro) {
            System.out.println("Arquivo com problemas");
            deuRuim = true;
        } catch (IllegalStateException erro) {
            System.out.println("Erro na leitura do arquivo");
            deuRuim = true;
        } finally {
            entrada.close();
            try {
                arq.close();
            } catch (IOException erro) {
                System.out.println("Erro ao fechar o arquivo");
                deuRuim = true;
            }
            if (deuRuim) {
                System.exit(1);
            }
        }
    }
}
