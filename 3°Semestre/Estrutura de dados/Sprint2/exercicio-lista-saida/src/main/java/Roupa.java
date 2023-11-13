import java.util.concurrent.ThreadLocalRandom;

public class Roupa {
    private int id;
    private int tamanho;
    private String nome;
    private double preco;
    private String marca;
    private String fabricacao;
    private String tipoTecido;

    public Roupa() {
        this.id = ThreadLocalRandom.current().nextInt(1, 99999);
    }

    public Roupa(int tamanho, String nome, double preco, String marca, String fabricacao, String tipoTecido) {
        this();
        this.tamanho = tamanho;
        this.nome = nome;
        this.preco = preco;
        this.marca = marca;
        this.fabricacao = fabricacao;
        this.tipoTecido = tipoTecido;
    }

    public Roupa(int id, String nome, int tamanho, double preco, String marca, String fabricacao, String tipoTecido) {
        this.id = id;
        this.tamanho = tamanho;
        this.nome = nome;
        this.preco = preco;
        this.marca = marca;
        this.fabricacao = fabricacao;
        this.tipoTecido = tipoTecido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getFabricacao() {
        return fabricacao;
    }

    public void setFabricacao(String fabricacao) {
        this.fabricacao = fabricacao;
    }

    public String getTipoTecido() {
        return tipoTecido;
    }

    public void setTipoTecido(String tipoTecido) {
        this.tipoTecido = tipoTecido;
    }

    @Override
    public String toString() {
        return String.format("%07d %-12s %7d %7.2f %-14s %-14s %-14s\n",
                id,
                nome,
                tamanho,
                preco,
                marca,
                fabricacao,
                tipoTecido);
    }
}
