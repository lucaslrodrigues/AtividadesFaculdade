/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lucas.lista.poo.encapsulamento;

/**
 *
 * @author lukas
 */
public class TesteColaborador {
    public static void main(String[] args) {
        Colaborador colab1 = new Colaborador();
        Colaborador colab2 = new Colaborador();
        
        RecursosHumanos rh = new RecursosHumanos();
        
        colab1.setCargo("Analisata de sistemas");
        colab1.setNome("Maria Pia");
        colab1.setSalario(4000.00);
        
        colab2.setCargo("Desenvolvedor Backend");
        colab2.setNome("Lucas Limão");
        colab2.setSalario(3000.00);
        
        rh.exibirInfoColaboradores (colab1);
        rh.promoverColaborador(colab1, "Desenvolvedora QA", 5000.00);
        rh.exibirInfoColaboradores (colab2);
        rh.promoverColaborador(colab2, "Desenvolvedor Junior", 2000.00);
        
        
        rh.reajustarSalario(0.15, colab2);
        
        rh.exibirInfoColaboradores (colab1);
        rh.exibirInfoColaboradores (colab2);
        
        System.out.println("Total de promovidos: " + rh.getTotalPromovidos());
        System.out.println("Salarios reajustados: " + rh.getSalariosReajustados());
    }
}
