public class Coordenador extends Funcionario implements ControleBonus{

    private Integer qtdHorasCoordenacao;
    private Double valorHoraCoordenacao;
    private Integer qtdCursoCoordenacao;

    public Coordenador(String nome, String cpf, Integer qtdHorasCoordenacao, Double valorHoraCoordenacao, Integer qtdCursoCoordenacao) {
        super(nome, cpf);
        this.qtdHorasCoordenacao = qtdHorasCoordenacao;
        this.valorHoraCoordenacao = valorHoraCoordenacao;
        this.qtdCursoCoordenacao = qtdCursoCoordenacao;
    }

    @Override
    public Double calcularSalario() {
        return qtdHorasCoordenacao * valorHoraCoordenacao * 4.5 + (qtdCursoCoordenacao * 500);
    }

    @Override
    public double receberBonus() {
        return calcularSalario() * 1.2;
    }
}
