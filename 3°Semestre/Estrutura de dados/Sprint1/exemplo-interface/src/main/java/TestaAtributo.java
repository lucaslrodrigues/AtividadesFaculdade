public class TestaAtributo {
    public static void main(String[] args) {
        Alimento alimento1 = new Alimento(12, "pera", 1.5, 12);
        Perfume perfume1 = new Perfume(11, "Perfume jequiti", 80.0, "Luan santana");
        Servico servico1 = new Servico("Instalar roteador wifi", 70.0);

        Tributo tributo = new Tributo();

        tributo.adicionarTributavel(alimento1);
        tributo.adicionarTributavel(perfume1);
        tributo.adicionarTributavel(servico1);

        tributo.exibeTodos();
        System.out.println(tributo.calculaTotalTributo());
    }
}
