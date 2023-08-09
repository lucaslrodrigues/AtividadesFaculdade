package org.example;

public class AlunoGraduacao extends Aluno{
    private Double nota1;
    private Double nota2;

    public AlunoGraduacao(Integer ra, String nome, Double nota1, Double nota2) {
        super(ra, nome);
        this.nota1 = nota1;
        this.nota2 = nota2;
    }

    @Override
    public Double calcularMedia() {
        return (nota1 * 0.4) + (nota2 * 0.6);
    }

    public Double getNota1() {
        return nota1;
    }

    public void setNota1(Double nota1) {
        this.nota1 = nota1;
    }

    public Double getNota2() {
        return nota2;
    }

    public void setNota2(Double nota2) {
        this.nota2 = nota2;
    }

    @Override
    public String toString() {
        return String.format("%s\n" +
                "Nota1: %.2f\n" +
                "Nota2: %.2f", super.toString(),
                nota1,
                nota2);
    }
}
