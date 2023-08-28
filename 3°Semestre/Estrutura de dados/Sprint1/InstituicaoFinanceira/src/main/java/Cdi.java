import java.time.LocalDate;
import java.time.Period;

public class Cdi extends Investimentos implements IMonetario{
    public Cdi(Double valorInvestimento, Double valorJuros) {
        super(valorInvestimento, valorJuros);
    }

    public Cdi(Double valorInvestimento, Double valorJuros, LocalDate dataInicio) {
        super(valorInvestimento, valorJuros, dataInicio);
    }

    @Override
    public Double descontarTributos(Double valorBruto) {
        return valorBruto - valorBruto * 0.020;
    }

    @Override
    public Double getTotalInvestido() {
        if (calcularMeses() == 0) {
            return calcularJuros();
        }
        return descontarTributos(calcularJuros());
    }
    public int calcularMeses() {
        LocalDate end = LocalDate.now();
        Period p = Period.between(super.getDataInicio(), end);
        int meses = (p.getYears() * 12) + p.getMonths();
        return meses;
    }
    @Override
    public Double calcularJuros() {
        Double total = super.getValorInvestimento();
        for (int i = 0; i < calcularMeses(); i++){
            total += total * ((super.getValorJuros() / 13) / 100);
        }
        return total;
    }

    @Override
    public String toString() {
        return String.format("""
                CDI
                %s
                Valor bruto investido: %.2f
                Valor liquido: %.2f
                =============================================
                """,
                super.toString(),
                calcularJuros(),
                getValorInvestimento());
    }
}
