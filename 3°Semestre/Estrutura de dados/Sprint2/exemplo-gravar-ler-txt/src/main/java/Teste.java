import java.util.ArrayList;
import java.util.List;

public class Teste {
    public static void main(String[] args) {
        List<Aluno> listaAluno = new ArrayList<>();
        listaAluno.add(new Aluno("ADS", "123", "Bob da Silva", "Est. dados", .5, 7));
        listaAluno.add(new Aluno("CCO", "345", "José da Silva", "Cálculo", 6.5, 20));
        GerenciadorArquivoTxt.gravaArquivoTxt(listaAluno, "alunos");

        GerenciadorArquivoTxt.leArquivoTxt("alunos");
    }
}
