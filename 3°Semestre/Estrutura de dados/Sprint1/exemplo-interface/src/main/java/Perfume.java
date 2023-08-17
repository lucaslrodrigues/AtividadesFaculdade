public class Perfume extends Produto{
    private String fragancia;

    public Perfume(int codigo, String descricao, double preco, String fragancia) {
        super(codigo, descricao, preco);
        this.fragancia = fragancia;
    }

    @Override
    public double getValorTributo() {
        return getPreco() * 0.27;
    }

    @Override
    public String toString() {
        return "============== PERFUME ===============\n" +
                "Fragancia: " + fragancia;
    }
}
