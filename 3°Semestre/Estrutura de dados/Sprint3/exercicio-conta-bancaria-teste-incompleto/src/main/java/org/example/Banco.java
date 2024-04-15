package org.example;
public class Banco {

    // Atributos
    PilhaObj<Operacao> pilhaOperacao = new PilhaObj(10);
    FilaObj<Operacao> filaOperacao = new FilaObj(10);
    // Contador de operações empilhadas
    Integer contadorOperacao = 0;

    // Métodos

    /* Método debitar - recebe o valor a ser debitado e o objeto conta bancária
       Se o débito ocorreu com sucesso, cria um objeto Operacao com os valores adequados
       e empilha a operação para poder ser desfeita. Atualiza contadorOperacao.
     */
    public void debitar(Double valor, ContaBancaria conta) {
        boolean debitado = conta.debitar(valor);
        if (debitado) {
            Operacao operacao = new Operacao(conta, "Débito", valor);
            try {
                contadorOperacao ++;
                pilhaOperacao.push(operacao);
            }catch (IllegalStateException e){
                throw new IllegalArgumentException();
            }
        }
    }

    /* Método creditar - recebe o valor a ser depositado e o objeto conta bancária
       Executa o depósito, cria um objeto Operacao com os valores adequados
       e empilha a operação para poder ser desfeita. Atualiza contadorOperacao.
     */
    public void creditar(Double valor, ContaBancaria conta) {
        conta.creditar(valor);
        Operacao operacao = new Operacao(conta, "Crédito", valor);
        try {
            contadorOperacao ++;
            pilhaOperacao.push(operacao);
        }catch (IllegalStateException e){
            throw new IllegalArgumentException();
        }
    }

    /* Método desfazerOperacao - recebe a quantidade de operações a serem desfeitas
       Se essa quantidade for inválida, lança IllegalArgumentException
       Senão, "desfaz" a quantidade de operações passadas como argumento
       e atualiza o contadorOperacao
     */
    public void desfazerOperacao(Integer qtdOperacaoDesfeita) {
        if (qtdOperacaoDesfeita > pilhaOperacao.getTopo() || qtdOperacaoDesfeita <= 0) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < qtdOperacaoDesfeita; i++) {
            if (pilhaOperacao.peek().getTipoOperacao().equals("Débito")){
                pilhaOperacao.peek().getContaBancaria().creditar(pilhaOperacao.peek().getValor());
                pilhaOperacao.pop();
                contadorOperacao --;
            } else {
                pilhaOperacao.peek().getContaBancaria().debitar(pilhaOperacao.peek().getValor());
                pilhaOperacao.pop();
                contadorOperacao --;
            }
        }
    }


    /* Método agendarOperacao - recebe o tipo da operaçõa, o valor e o objeto conta bancária
       Se um dos argumentos for inválido, lança IllegalArgumentException.
       Senão, cria um objeto Operacao e insere esse objeto na fila.
    */
    public void agendarOperacao(String tipoOperacao, Double valor, ContaBancaria conta) {
        if (tipoOperacao == null || valor == null || conta == null ||
                ((!tipoOperacao.equalsIgnoreCase("Débito")) &&
                        (!tipoOperacao.equalsIgnoreCase("Crédito"))) || valor <= 0.0) {
            throw new IllegalArgumentException();
        }
        Operacao operacao = new Operacao(conta, tipoOperacao, valor);
        try {
            contadorOperacao++;
            filaOperacao.insert(operacao);
        }catch (IllegalStateException e){
            throw new IllegalArgumentException();
        }
    }

    /* Método executarOperacoesAgendadas
       Se não houver operações na fila, exibe mensagem de que não há operações agendadas.
       Senão, esvazia a fila, executando cada uma das operações agendadas.
    */
    public void executarOperacoesAgendadas() {
        if (filaOperacao.isEmpty()) {
            System.out.println("Não a há operações agendadas");
        } else {
            while (!filaOperacao.isEmpty()) {
                Operacao op = filaOperacao.peek();
                if (op.getTipoOperacao().equalsIgnoreCase("Débito")) {
                    op.getContaBancaria().debitar(op.getValor());
                } else if (op.getTipoOperacao().equalsIgnoreCase("Crédito")) {
                    op.getContaBancaria().creditar(op.getValor());
                } else {
                    throw new IllegalArgumentException();
                }
                contadorOperacao --;
                filaOperacao.poll();
            }
        }
    }

    // Gettens
    public PilhaObj<Operacao> getPilhaOperacao() {
        return pilhaOperacao;
    }

    public FilaObj<Operacao> getFilaOperacao() {
        return filaOperacao;
    }

    public Integer getContadorOperacao() {
        return contadorOperacao;
    }
}
