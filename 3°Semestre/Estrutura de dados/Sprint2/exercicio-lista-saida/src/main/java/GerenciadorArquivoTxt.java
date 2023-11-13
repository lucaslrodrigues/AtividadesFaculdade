import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorArquivoTxt {
    public static void gravaRegistro(String registro, String nomeArq) {
        BufferedWriter saida = null;

        // Abre o arquivo
        try {
            saida = new BufferedWriter(new FileWriter(nomeArq, true));
        } catch (IOException erro) {
            System.out.println("Erro na abertura do arquivo");
        }

        // Grava o registro e fecha o arquivo
        try {
            saida.append(registro + "\n");
            saida.close();
        } catch (IOException erro) {
            System.out.println("Erro ao gravar o arquivo");
            erro.printStackTrace();
        }
    }

    public static void gravaArquivoTxt(ListaObj<Roupa> lista, String nomeArq) {
        int contaRegDados = 0;

        // Monta o registro de header
        String header = "00ROUPA"; //Verificar documento de layout
        header += LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
        header += "01";

        // Grava o registro de header
        gravaRegistro(header, nomeArq);

        // Grava os registros de dados (ou registros de corpo)

        for (int i = 0; i < lista.getTamanho(); i++) {
            String corpo = "02";
            corpo += String.format("%7d", lista.getElemento(i).getId());
            corpo += String.format("%-12s", lista.getElemento(i).getNome()); //Completar de acordo com documento
            corpo += String.format("%7d", lista.getElemento(i).getTamanho());
            corpo += String.format("%7.2f", lista.getElemento(i).getPreco());
            corpo += String.format("%-14s", lista.getElemento(i).getMarca());
            corpo += String.format("%-14s", lista.getElemento(i).getFabricacao());
            corpo += String.format("%-14s", lista.getElemento(i).getTipoTecido());
            //Gravando corpo no arquivo:
            gravaRegistro(corpo, nomeArq);
            // Incrementa o contador de registros de dados gravados
            contaRegDados++;
        }

        // Monta e grava o registro de trailer
        String trailer = "01";
        trailer += String.format("%010d", contaRegDados);

        gravaRegistro(trailer, nomeArq);
    }

    public static void leArquivoTxt(String nomeArq) {
        BufferedReader entrada = null;
        String registro, tipoRegistro;
        int contaRegDadosLidos = 0;
        int qtdRegDadosGravados;

        // Cria uma lista para armazenar os objetos criados com
        // os dados lidos do arquivo txt

        List<Roupa> listaLida = new ArrayList<>();

        // Abre o arquivo
        try {
            entrada = new BufferedReader(new FileReader(nomeArq));
        } catch (IOException erro) {
            System.out.println("Erro na abertura do arquivo");
        }

        // Leitura do arquivo
        try {
            registro = entrada.readLine();

            while (registro != null) {
                // obtem os 2 primeiros caracteres do registro lido
                // 1o argumento do substring é o indice do que se quer obter, iniciando de zero
                // 2o argumento do substring é o indice final do que se deseja, MAIS UM
                // 012345
                // 00NOTA
                tipoRegistro = registro.substring(0, 2);

                if (tipoRegistro.equals("00")) {
                    System.out.println("--------- É um registro de header -----------");
                    //Exibir informações do header
                    System.out.println("Tipo do arquivo: " + registro.substring(2, 7));
                    System.out.println("Data e Hora: " + registro.substring(7, 26));
                    System.out.println("Versão do layout: " + registro.substring(26, 28));
//                    System.out.println("Versão do layout: " + registro.substring(30, 32));

                } else if (tipoRegistro.equals("01")) {
                    System.out.println("--------- É um registro de trailer ---------");
                    //Exibir quantidade de registros
                    System.out.println("Quantidade de dados: " + registro.substring(2, 12));


                } else if (tipoRegistro.equals("02")) {
                    System.out.println("---------- É um registro de corpo ----------");
                    //Guardar dados do corpo em variáveis

                    Integer id = Integer.valueOf(registro.substring(2, 8).trim());
                    String nome = registro.substring(9, 24).trim();
                    Integer tamanho = Integer.valueOf(registro.substring(25, 28).trim());
                    Double preco =  Double.valueOf(registro
                            .substring(29, 34)
                            .trim()
                            .replace(",", "."));
                    String marca = registro.substring(35, 47).trim();
                    String fabricacao = registro.substring(48, 59).trim();
                    String tipoTecido = registro.substring(60, 72).trim();

                    System.out.println("Id: " + id);
                    System.out.println("Nome: " + nome);
                    System.out.println("Tamanho: " + tamanho);
                    System.out.println("Preço: " + preco);
                    System.out.println("Marca: " + marca);
                    System.out.println("Fabricação: " + fabricacao);
                    System.out.println("Tipo de tecido: " + tipoTecido);

                    // Incrementa o contador de reg de dados lidos
                    contaRegDadosLidos++;

                    // Cria um objeto com os dados lidos do registro
                    Roupa r = new Roupa(id, nome, tamanho, preco, marca, fabricacao, tipoTecido);
                    // Se estivesse conectado a um banco de dados,
                    listaLida.add(r);
                    // como não estamos conectados a um BD, vamos adicionar na lista
                } else {
                    System.out.println("Registro inválido");
                }
                // Le o proximo registro
                registro = entrada.readLine();

            }  // fim do while
            // Fecha o arquivo
            entrada.close();
        } // fim do try
        catch (IOException erro) {
            System.out.println("Erro ao ler o arquivo");
            erro.printStackTrace();
        }

        // Exibe a lista lida
        System.out.println("\nLista lida do arquivo:");
        for (Roupa r : listaLida) {
            System.out.println(r);
        }

        // Aqui tb seria possível salvar a lista no BD
        // repository.saveAll(lista);
    }
}
