public class Secretaria extends Funcionario{
    private Double salario;
    private Double extra;

    public Secretaria(String nome, String cpf, Double salario, Double extra) {
        super(nome, cpf);
        this.salario = salario;
        this.extra = extra;
    }

    @Override
    public Double calcularSalario() {
        return salario + extra;
    }
}
