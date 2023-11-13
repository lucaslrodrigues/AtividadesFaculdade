public class main {
    public static void main(String[] args) {
        ListaEstatica lista = new ListaEstatica(8);

        lista.adiciona(40);
        lista.adiciona(40);
        lista.adiciona(40);
        lista.adiciona(40);

        lista.busca(40);

//        lista.removePeloIndice(2);


//        lista.removeElemento(10);
//        lista.substitui(20,40);
        lista.adicionaNoInicio(5);

        lista.exibe();
        System.out.println(lista.contaOcorrencias(40));
    }
}
