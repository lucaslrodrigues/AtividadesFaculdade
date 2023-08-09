package org.example;

public class TesteAluno{
    public static void main(String[] args) {
        AlunoFundamental alunoFund = new AlunoFundamental(01222011, "Nathan David", 5.0, 9.0, 2.0, 10.0);
        AlunoGraduacao alunoGrad = new AlunoGraduacao(01222000, "Maria Pires", 10.0, 7.0);
        AlunoPos alunoPos = new AlunoPos(01222015, "José Yoshihiro", 7.0, 10.0, 9.0);

        System.out.println(alunoFund);
        System.out.println(alunoGrad);
        System.out.println(alunoPos);

        System.out.println(alunoFund.calcularMedia());
        System.out.println(alunoGrad.calcularMedia());
        System.out.println(alunoPos.calcularMedia());

        Escola escola = new Escola("sptech");
        escola.adicionaAluno(alunoFund);
        escola.adicionaAluno(alunoGrad);
        escola.adicionaAluno(alunoPos);

        System.out.println("ALUNOS\n");
        escola.exibirAlunos();
        System.out.println("ALUNOS APROVADOS\n");
        escola.exiberAprovados();
        System.out.println("GRADUACAO\n");
        escola.exibeAlunoGraduacao();
        System.out.println("ALUNO POR NOME\n");
        escola.buscarAluno(01222011);


    }
}
