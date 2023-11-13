import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class GerenciadorDeArquivos {
    public static void gravaArquivoCsv(ListaObj<Roupa> lista, String nomeArq) {

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
                Roupa roupa = lista.getElemento(i);
                //Recupere um elemento da lista e formate aqui:
                saida.format("%d;%s;%d;%.2f;%s;%s;%s\n", roupa.getId(), roupa.getNome(), roupa.getTamanho(), roupa.getPreco(), roupa.getMarca(), roupa.getFabricacao(), roupa.getTipoTecido());
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
//Leia e formate a saída no console aqui:

// Cabeçalho
            System.out.printf("%7s %-12s %7s %s %-14s %-14s %-14s\n", "id", "tamanho", "nome", "preço", "marca", "fabricação", "tipo tecido");
            while (entrada.hasNext()) {
                int id = entrada.nextInt();
                int tamanho = entrada.nextInt();
                String nome = entrada.next();
                double preco = entrada.nextDouble();
                String marca = entrada.next();
                String fabricacao = entrada.next();
                String tipoTecido = entrada.next();

                System.out.printf("%07d %-12s %7d %7.2f %-14s %-14s %-14s\n", id, nome, tamanho, preco, marca, fabricacao, tipoTecido);
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
