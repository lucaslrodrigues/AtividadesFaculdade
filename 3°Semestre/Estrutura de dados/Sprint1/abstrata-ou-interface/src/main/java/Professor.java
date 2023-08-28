public class Professor extends Funcionario implements ControleBonus {

    Integer qtdAulasSemana;
    Double valorHoraAula;

    public Professor(String nome, String cpf, Integer qtdAulasSemana, Double valorHoraAula) {
        super(nome, cpf);
        this.qtdAulasSemana = qtdAulasSemana;
        this.valorHoraAula = valorHoraAula;
    }

    public void darAula(){

    }

    public double receberBonus(){
        return calcularSalario() * 1.15;
    }

    @Override
    public Double calcularSalario() {
        return qtdAulasSemana * valorHoraAula * 4.5;
    }
}
