public class Teste {
    public static void main(String[] args) {
        ListaEstatica lista = new ListaEstatica(5);
        lista.adiciona(15);
        lista.adiciona(15);
        lista.adiciona(30);
        lista.adiciona(40);
        lista.adiciona(50);

        lista.substitui(50, 15);
        lista.contaOcorrencias(15);
        lista.adicionaNoInicio(27);
        lista.removePeloIndice(0);
        lista.adicionaNoInicio(27);
    }
}
