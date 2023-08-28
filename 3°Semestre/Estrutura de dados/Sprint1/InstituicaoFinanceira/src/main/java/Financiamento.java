public class Financiamento implements IMonetario {
    private String categoria;
    private Double valorParcela;
    private Integer parcelas;

    public Financiamento(String categoria, Double valorParcela, Integer parcelas) {
        this.categoria = categoria;
        this.valorParcela = valorParcela;
        this.parcelas = parcelas;
    }

    @Override
    public Double calcularJuros() {
        Double valorJuros = 0.0;
        for (int i = 0; i < parcelas; i++){
            valorJuros += valorParcela * (3.60 / 12);
        }
        return valorJuros;
    }

    public Double getValorFinal(){
        return valorParcela * parcelas + calcularJuros();
    }

    @Override
    public String toString() {
        return String.format("""
                Financiamento
                Categoria: %s
                Valor da parcela: %.2f
                Parcelas: %d
                Valor financiado: %.2f
                Valor pago: %.2f
                =============================================
                """,
                categoria,
                valorParcela,
                parcelas,
                parcelas * valorParcela,
                getValorFinal());
    }
}
