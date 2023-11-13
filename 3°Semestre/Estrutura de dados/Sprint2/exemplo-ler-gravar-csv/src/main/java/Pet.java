public class Pet {
    private int id;
    private String nome;
    private String porte;
    private double peso;

    public Pet(int id, String nome, String porte, double peso) {
        this.id = id;
        this.nome = nome;
        this.porte = porte;
        this.peso = peso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPorte() {
        return porte;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", porte='" + porte + '\'' +
                ", peso=" + peso +
                '}';
    }
}
