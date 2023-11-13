public class Funcionario {
    private int id;
    private String nome;
    private String email;
    private double salario;
    private int qtdFaltas;
    private boolean recebeComissao;

    public Funcionario(int id, String nome, String email, double salario, int qtdFaltas, boolean recebeComissao) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.salario = salario;
        this.qtdFaltas = qtdFaltas;
        this.recebeComissao = recebeComissao;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getQtdFaltas() {
        return qtdFaltas;
    }

    public void setQtdFaltas(int qtdFaltas) {
        this.qtdFaltas = qtdFaltas;
    }

    public boolean isRecebeComissao() {
        return recebeComissao;
    }

    public void setRecebeComissao(boolean recebeComissao) {
        this.recebeComissao = recebeComissao;
    }

    @Override
    public String toString() {
        return nome;
    }
}
