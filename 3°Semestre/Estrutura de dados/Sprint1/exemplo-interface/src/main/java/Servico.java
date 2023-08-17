public class Servico implements Tributavel{
    private String descricao;
    private double preco;

    public Servico(String descricao, double preco) {
        this.descricao = descricao;
        this.preco = preco;
    }

    @Override
    public double getValorTributo() {
        return preco * 0.12;
    }

    @Override
    public String toString() {
        return ("============== SERVICO =============\n" +
                "Decricao: %s\n" +
                "Preco: %.2f").formatted(descricao, preco);
    }
}
