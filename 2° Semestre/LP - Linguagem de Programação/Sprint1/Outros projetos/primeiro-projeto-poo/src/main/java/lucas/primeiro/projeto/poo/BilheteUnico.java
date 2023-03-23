/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lucas.primeiro.projeto.poo;

/**
 *
 * @author lukas
 */
// Classees representam um objeto
public class BilheteUnico {
    // Atributos representam caracteristicas
    
    String nomeTitular;
    Double saldo;
    Boolean possuiMeiaTarifa;
    
    // Metodos representam comportamentos
    void recarregar (Double valorRecarga){
        // Comportamentos alteram caracteristicas
        // Métodos alteram os atríbutos
        if (valorRecarga > 0){
            saldo += valorRecarga;
            System.out.println("Novo saldo: " + saldo);
        }else{
            System.out.println("valor inválido!");
        }
    }
    
    void usar(){
        if (possuiMeiaTarifa && saldo >= 2.2) {
            saldo -= 2.2;
            System.out.println("Liberado - Saldo: " + saldo);
        }else if (saldo >= 4.4){
            saldo -= 4.4;
            System.out.println("Liberado - Saldo: " + saldo);
        }else{
            System.out.println("Saldo inválido");
        }
    }
}
