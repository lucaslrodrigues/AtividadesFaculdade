import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Financiamento financiamento = new Financiamento("Imobiliario", 1000.0, 240);
        TituloPublico titulo = new TituloPublico(50000.0, 13.0, "Tesouro direto");
        Cdi cdi = new Cdi(100000.0,12.0);

        // Utilizando construtor sobrescrito para simular uma data de inicio do investimento
        LocalDate dataInicio = LocalDate.of(2022, 8, 27);
        TituloPublico tituloSobreescrito = new TituloPublico(100000.0, 12.0, dataInicio, "Tesouro direto");

        InstituicaoFinanceira instituicao = new InstituicaoFinanceira("Alpe", "1212121212");
        instituicao.adicionarMonetario(financiamento);
        instituicao.adicionarMonetario(titulo);
        instituicao.adicionarMonetario(cdi);
        instituicao.adicionarMonetario(tituloSobreescrito);


        instituicao.exibirMonetarios();
    }
}
