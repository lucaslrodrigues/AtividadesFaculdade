public class Aluno {
    private String curso;
    private String ra;
    private String nome;
    private String disciplina;
    private double media;
    private int qtdFaltas;

    public Aluno(String curso, String ra, String nome, String disciplina, double media, int qtdFaltas) {
        this.curso = curso;
        this.ra = ra;
        this.nome = nome;
        this.disciplina = disciplina;
        this.media = media;
        this.qtdFaltas = qtdFaltas;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public int getQtdFaltas() {
        return qtdFaltas;
    }

    public void setQtdFaltas(int qtdFaltas) {
        this.qtdFaltas = qtdFaltas;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "curso='" + curso + '\'' +
                ", ra='" + ra + '\'' +
                ", nome='" + nome + '\'' +
                ", disciplina='" + disciplina + '\'' +
                ", media=" + media +
                ", qtdFaltas=" + qtdFaltas +
                '}';
    }
}
