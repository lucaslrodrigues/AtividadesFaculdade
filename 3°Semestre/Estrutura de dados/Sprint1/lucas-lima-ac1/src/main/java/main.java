public class main {
    public static void main(String[] args) {
        ControleImposto controle = new ControleImposto();
        BrinquedoIngresso brinquedo1 = new BrinquedoIngresso("Montanha Russa", 1, 20.0, 2);
        BrinquedoAlugado brinquedo2 = new BrinquedoAlugado("Patinete", 2, 10.0, 2);
        Socio socio1 = new Socio("João", 2000.0);

        controle.adicionarRenda(brinquedo1);
        controle.adicionarRenda(brinquedo2);
        controle.adicionarRenda(socio1);
        controle.exibirImposto();
        System.out.println(controle.totalImpostos());
    }
}
