public class Paciente {
    private Integer id;
    private String nome;
    private String sintomas;
    private Boolean prioritario;
    private Double peso;
    private Integer idade;

    public Paciente(Integer id, String nome, String sintomas, Boolean prioritario, Double peso, Integer idade) {
        this.id = id;
        this.nome = nome;
        this.sintomas = sintomas;
        this.prioritario = prioritario;
        this.peso = peso;
        this.idade = idade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public Boolean getPrioritario() {
        return prioritario;
    }

    public void setPrioritario(Boolean prioritario) {
        this.prioritario = prioritario;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sintomas='" + sintomas + '\'' +
                ", prioritario=" + prioritario +
                ", peso=" + peso +
                ", idade=" + idade +
                '}';
    }
}
