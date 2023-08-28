import java.time.LocalDate;
import java.time.Period;

public class TituloPublico extends Investimentos implements IMonetario{
    public String tipoTitulo;


    public TituloPublico(Double valorInvestimento, Double valorJuros,  String tipoTitulo) {
        super(valorInvestimento, valorJuros);
        this.tipoTitulo = tipoTitulo;
    }

    public TituloPublico(Double valorInvestimento, Double valorJuros, LocalDate dataInicio, String tipoTitulo) {
        super(valorInvestimento, valorJuros, dataInicio);
        this.tipoTitulo = tipoTitulo;
    }

    @Override
    public Double descontarTributos(Double valorBruto){
        return valorBruto - valorBruto * 0.015;
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
    public Double calcularJuros() {
        Double total = super.getValorInvestimento();
        for (int i = 0; i < calcularMeses(); i++){
            total += total * ((super.getValorJuros() / 12) / 100);
        }
        return total;
    }

    public String getTipoTitulo() {
        return tipoTitulo;
    }

    public void setTipoTitulo(String tipoTitulo) {
        this.tipoTitulo = tipoTitulo;
    }

    @Override
    public String toString() {
        return String.format("""
                TITULO PUBLICO
                Tipo de titulo publico: %s
                %s
                Valor bruto investido: %.2f
                Valor liquido: %.2f
                =============================================
                """,
                tipoTitulo,
                super.toString(),
                calcularJuros(),
                getTotalInvestido());
    }
}
