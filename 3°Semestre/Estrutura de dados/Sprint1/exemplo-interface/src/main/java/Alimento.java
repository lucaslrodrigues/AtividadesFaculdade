public class Alimento extends Produto{
    private int quantVitamina;

    public Alimento(int codigo, String descricao, double preco, int quantVitamina) {
        super(codigo, descricao, preco);
        this.quantVitamina = quantVitamina;
    }

    @Override
    public double getValorTributo() {
        return getPreco() * 0.15;
    }
}
