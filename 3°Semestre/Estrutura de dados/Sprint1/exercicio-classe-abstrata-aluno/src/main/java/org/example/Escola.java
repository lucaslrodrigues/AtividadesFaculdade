package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Escola {
    private String nome;
    private List<Aluno> alunos;

    public Escola(String nome) {
        this.nome = nome;
        this.alunos = new ArrayList<>();
    }

    public void adicionaAluno(Aluno a){
        alunos.add(a);
    }

    public void exibirAlunos(){
        System.out.println(alunos);
    }

    public void exibeAlunoGraduacao(){
        for (int i = 0; i < alunos.size(); i ++){
            if (alunos.get(i) instanceof AlunoGraduacao){
                System.out.println(alunos.get(i));
            }
        }
    }

    public void exiberAprovados(){
        for (Aluno alunoDaVez: alunos){
            if (alunoDaVez.calcularMedia() >= 6){
                System.out.println(alunoDaVez);
            }
        }
    }

    public void buscarAluno(Integer ra){
        for (int i = 0; i < alunos.size(); i ++){
            if (Objects.equals(alunos.get(i).getRa(), ra)) {
                System.out.println(alunos.get(i));
            }
        }
    }
}
