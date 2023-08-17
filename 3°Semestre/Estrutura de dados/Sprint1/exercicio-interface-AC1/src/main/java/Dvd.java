public class Dvd extends Produto{
    private String nome;
    private String gravadora;

    public Dvd(int codigo, Double precoCusto, String nome, String gravadore) {
        super(codigo, precoCusto);
        this.nome = nome;
        this.gravadora = gravadore;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGravadora() {
        return gravadora;
    }

    public void setGravadora(String gravadora) {
        this.gravadora = gravadora;
    }

    @Override
    public double getValorVenda() {
        return 1.2;
    }

    @Override
    public String toString() {
        return """
                Nome: %s
                Gravadora: %s
                """.formatted(nome, gravadora);
    }
}
