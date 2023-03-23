/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lucas.primeiro.projeto.poo;

/**
 *
 * @author lukas
 */
public class app {
    public static void main(String[] args) {
        // Instanciar um objeto
        BilheteUnico bilheteLimao = new BilheteUnico();
        BilheteUnico bilheteXamps = new BilheteUnico();
        
        bilheteLimao.nomeTitular = "Lucas de Lima";
        bilheteLimao.possuiMeiaTarifa = true;
        bilheteLimao.saldo = 0.0;
        
        bilheteXamps.nomeTitular = "Xampson";
        bilheteXamps.possuiMeiaTarifa = false;
        bilheteXamps.saldo = 0.0;
        
        // Teste bilhete 1
        bilheteLimao.recarregar(50.0);
        bilheteLimao.usar();
        
        // Teste bilhete 2
        bilheteXamps.recarregar(3.10);
        bilheteXamps.usar();
        
    }
}
