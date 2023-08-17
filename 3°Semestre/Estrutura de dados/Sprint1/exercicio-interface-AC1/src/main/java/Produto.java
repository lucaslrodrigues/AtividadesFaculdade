public abstract class Produto implements Vendavel{
    private int codigo;
    private Double precoCusto;

    public Produto(int codigo, Double precoCusto) {
        this.codigo = codigo;
        this.precoCusto = precoCusto;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Double getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(Double precoCusto) {
        this.precoCusto = precoCusto;
    }

    @Override
    public String toString() {
        return """
                Codigo: %d
                Preco de custo: %.2f
                Preco de venda: %.2f
                """.formatted(codigo,
                precoCusto,
                getValorVenda()
                );
    }
}
