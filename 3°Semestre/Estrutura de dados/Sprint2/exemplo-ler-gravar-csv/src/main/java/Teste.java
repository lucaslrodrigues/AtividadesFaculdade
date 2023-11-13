public class Teste {
    public static void main(String[] args) {
        ListaObj<Pet> pets = new ListaObj<>(5);

        pets.adiciona(new Pet(1, "Belinha", "Pequenino", 3));
        pets.adiciona(new Pet(2, "Layla", "Médio", 10));
        pets.adiciona(new Pet(3, "Lets", "Giga", 20));
        pets.adiciona(new Pet(4, "Go", "Pequenina", 5));
        pets.adiciona(new Pet(5, "Jynx", "Pequena", 0.450));

//        pets.exibe();
        System.out.println("Criando arquivo...");
        GerenciadorDeArquivo.gravaArquivoCsv(pets, "meusPets");
        System.out.println("Lendo arquivo: ");
        GerenciadorDeArquivo.leArquivoCsv("meusPets");
    }

}
