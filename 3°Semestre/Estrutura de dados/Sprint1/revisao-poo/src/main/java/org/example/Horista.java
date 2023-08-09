package org.example;

public class Horista extends Funcionario{
    private Integer qtdHora;
    private Double valorHora;

    public Horista(String nome, String cpf, Integer qtdHora, Double valorHora) {
        super(nome, cpf);
        this.qtdHora = qtdHora;
        this.valorHora = valorHora;
    }

    @Override
    public Double calcularSarlario() {
        return qtdHora * valorHora;
    }

    @Override
    public String toString() {
        return String.format("%s\n" +
                "Quantidade de horas: %d\n" +
                "Valor hora: %.2f",
                super.toString(),
                this.qtdHora,
                this.valorHora);
    }
}
