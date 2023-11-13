import org.example.ListaEstatica;

public class app {
    public static void main(String[] args) {
//        org.example.ListaEstatica lista1 = new ListaEstatica(7);
//        lista1.adiciona(10);
//        lista1.adiciona(20);
//        lista1.adiciona(30);
//        lista1.adicionaNoindice(-1, 111);  // deve dar indice invalido
//        lista1.adicionaNoindice(8, 111);  // deve dar indice invalido
//        lista1.adicionaNoindice(3, 40);  // deve dar certo (exiba para conferir)
//        lista1.adicionaNoindice(0, 5);  // deve dar certo (exiba para conferir)
//        lista1.adicionaNoindice(2, 111);  // deve dar certo (exiba para conferir)

        ListaEstatica lista2 = new ListaEstatica(10);
        lista2.adiciona(8);
        lista2.adiciona(5);
        lista2.adiciona(4);
        lista2.adiciona(7);
        lista2.adiciona(10);
        lista2.adiciona(2);
//        lista2.exibe();
        lista2.ordena();
//        lista2.exibe();
        System.out.println(lista2.pesquisaBinaria(2));
        System.out.println(lista2.pesquisaBinaria(8));
        System.out.println(lista2.pesquisaBinaria(10));
        System.out.println(lista2.pesquisaBinaria(9));

    }
}
