package org.example;

public class Vendedor extends Funcionario{
    private Double vendas;
    private Double taxa;

    public Vendedor(String nome, String cpf, Double vendas, Double taxa) {
        super(nome, cpf);
        this.vendas = vendas;
        this.taxa = taxa;
    }

    @Override
    public Double calcularSarlario() {
        return vendas * taxa;
    }

    @Override
    public String toString() {
        return String.format("%s\n" +
                "Vendas: %.2f\n" +
                "Taxa: %.2f",
                super.toString(),
                this.vendas,
                this.taxa);
    }
}
