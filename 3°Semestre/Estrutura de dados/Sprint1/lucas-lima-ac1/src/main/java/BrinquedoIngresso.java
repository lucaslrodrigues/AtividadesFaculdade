public class BrinquedoIngresso extends Brinquedo{
    private Double valorIngresso;
    private int qtdIngressoVendido;

    public BrinquedoIngresso(String nome, int codigo, Double valorIngresso, int qtdIngressoVendido) {
        super(nome, codigo);
        this.valorIngresso = valorIngresso;
        this.qtdIngressoVendido = qtdIngressoVendido;
    }

    @Override
    public Double getRenda() {
        return valorIngresso * qtdIngressoVendido;
    }

    @Override
    public Double getValorImposto() {
        return getRenda() * 0.18;
    }

    @Override
    public String toString() {
        return String.format("%s" +
                "Valor ingresso = %.2f" +
                "Quantidade ingressos vendidos = %d",
                super.toString(),
                valorIngresso,
                qtdIngressoVendido);
    }
}
