package sptech.modelo;

public class Fabricante {
    private String nome;
    private String paisOrigem;

    public Fabricante() {
    }

    public Fabricante(String nome, String paisOrigem) {
        this.nome = nome;
        this.paisOrigem = paisOrigem;
    }

    public String getNome() {
        return nome;
    }

    public String getPaisOrigem() {
        return paisOrigem;
    }
}
