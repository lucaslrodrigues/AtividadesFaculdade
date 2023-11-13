public abstract class Brinquedo implements IRenda{
    private String nome;
    public int codigo;

    public Brinquedo(String nome, int codigo) {
        this.nome = nome;
        this.codigo = codigo;
    }

    public abstract Double getRenda();

    public abstract Double getValorImposto();

    @Override
    public String toString() {
        return String.format("Brinquedo = %s\nCódigo = %d", nome, codigo);
    }
}
