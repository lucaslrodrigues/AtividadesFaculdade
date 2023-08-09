package org.example;

public class AlunoPos extends Aluno{
    private Double nota1;
    private Double nota2;
    private Double notaMonografia;

    public AlunoPos(Integer ra, String nome, Double nota1, Double nota2, Double notaMonografia) {
        super(ra, nome);
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.notaMonografia = notaMonografia;
    }

    @Override
    public Double calcularMedia() {
        return (nota1 + nota2 + notaMonografia) / 3;
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

    public Double getNotaMonografia() {
        return notaMonografia;
    }

    public void setNotaMonografia(Double notaMonografia) {
        this.notaMonografia = notaMonografia;
    }

    @Override
    public String toString() {
        return String.format("%s\n" +
                        "Nota1: %.2f\n" +
                "Nota2: %.2f\n" +
                "Nota Monografia: %.2f",
                super.toString(),
                nota1,
                nota2,
                notaMonografia);
    }
}
