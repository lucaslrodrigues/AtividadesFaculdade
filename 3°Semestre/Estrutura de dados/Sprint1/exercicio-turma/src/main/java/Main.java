import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        String[] t1 = new String[10];
        String[] t2 = new String[10];

        int indiceT1 = 0;
        int indiceT2 = 0;
        for (int i = 0; i < 10; i++) {
            System.out.printf("Insira o nome do %d° aluno: %n", i+1);
            String alunoNome = leitor.nextLine();
            System.out.println("A qual Turma ele pertence, t1 ou t2?");
            String alunoTurma = leitor.nextLine();

            if (alunoTurma.equals("t1")) {
                t1[indiceT1] = alunoNome;
                indiceT1 ++;
            } else if (alunoTurma.equals("t2")) {
                t2[indiceT2] = alunoNome;
                indiceT2 ++;
            }
        }

        System.out.println("Quantidade de alunos T1: %d\n" +
                    "Quantidade de alunos T2: %d".formatted(t1.length, t2.length));

        System.out.println("Alunos t1:");
        for (int i = 0; i < indiceT1; i++) {
            System.out.println(t1[i]);
        }
        for (int i = 0; i < indiceT2; i++) {
            System.out.println(t2[i]);
        }
    }
}
