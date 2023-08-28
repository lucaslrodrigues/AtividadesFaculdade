import java.time.LocalDate;

public abstract class Investimentos implements IMonetario{
    private Double valorInvestimento;
    private Double valorJuros;
    private LocalDate dataInicio;

    public Investimentos() {
        this.dataInicio = LocalDate.now();
    }

    public Investimentos(Double valorInvestimento, Double valorJuros) {
        this();
        this.valorInvestimento = valorInvestimento;
        this.valorJuros = valorJuros;
    }

    public Investimentos(Double valorInvestimento, Double valorJuros, LocalDate dataInicio) {
        this.valorInvestimento = valorInvestimento;
        this.valorJuros = valorJuros;
        this.dataInicio = dataInicio;
    }

    public abstract Double descontarTributos(Double valorBruto);

    public abstract Double getTotalInvestido();
    public abstract int calcularMeses();

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public Double getValorJuros() {
        return valorJuros;
    }

    public Double getValorInvestimento() {
        return valorInvestimento;
    }

    public void setValorInvestimento(Double valorInvestimento) {
        this.valorInvestimento = valorInvestimento;
    }

    @Override
    public String toString() {
        return String.format("""
                Valor de investimento inicial: %.2f
                Valor juros: %.2f
                Data de inicio: %s
                """, valorInvestimento,
                valorJuros,
                dataInicio);
    }
}
