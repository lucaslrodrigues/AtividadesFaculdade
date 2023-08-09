package org.example;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private List<Funcionario> funcionarios;

    public Empresa() {
        this.funcionarios = new ArrayList<>();
    }

    public void adicionaFunc(Funcionario f){
        funcionarios.add(f);
    }

    public void exibirTodos(){
        for(Funcionario funcionarioDaVez: funcionarios){
            System.out.println("--------------------------------\n");
            System.out.println(funcionarioDaVez);
        }
    }

    public void exibirHoristas(){
        for(Funcionario funcionarioDaVez: funcionarios){
            if (funcionarioDaVez instanceof Horista) {
                System.out.println("--------------------------------\n");
                System.out.println(funcionarioDaVez);
            }
        }
    }

    public void exibirTotalSalario(){
        Double total = 0.0;
        for (Funcionario f: funcionarios){
            total += f.calcularSarlario();
        }
        System.out.println(String.format("total de salarios: %.2f", total));
    }

    public void exibirTotalSalarios(){
        Double valorTotal = 0.0;
        for (int i = 0; i < funcionarios.size(); i++){
            valorTotal += funcionarios.get(i).calcularSarlario();
        }
        System.out.println("O total é " + valorTotal);
    }
}
