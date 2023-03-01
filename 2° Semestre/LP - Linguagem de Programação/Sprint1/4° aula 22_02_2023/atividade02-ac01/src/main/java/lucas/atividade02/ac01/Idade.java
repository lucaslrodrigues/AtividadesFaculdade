/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lucas.atividade02.ac01;

/**
 *
 * @author aluno
 */
public class Idade {
    void classificaIdade (Integer idade){
        if (idade > 60){
            System.out.println("Faixa etária: Idoso");
        }else if (idade > 31){
            System.out.println("Faixa etária: Adulto");
        }else if (idade > 20){
            System.out.println("Faixa etária: Jovem");
        }else if (idade > 12){
            System.out.println("Faixa etária: Jovem");
        }else if (idade > 3){
            System.out.println("Faixa etária: Criança");
        }else{
            System.out.println("Faixa etária: Bebê");
        }
    }
}
