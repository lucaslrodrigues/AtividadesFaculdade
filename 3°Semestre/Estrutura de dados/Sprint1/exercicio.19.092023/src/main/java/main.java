public class main {
    public static void main(String[] args) {
        ListaEstatica lista = new ListaEstatica(4);

        lista.adiciona(10);
        lista.adiciona(20);
        lista.adiciona(30);
        lista.adiciona(40);

        lista.busca(40);

        lista.removePeloIndice(2);


        lista.removerElemento(10);

        lista.exibe();
    }
}
