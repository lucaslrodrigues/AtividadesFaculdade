/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lucas.correcao.lista.poo;

/**
 *
 * @author lukas
 */
public class App {
    public static void main(String[] args) {
        Bolo bolo1 = new Bolo();
        bolo1.sabor = "chocolate";
        bolo1.quantidadeVendida = 0;
        bolo1.valor = 1.0;
        
        bolo1.comprarBolo(45);
        bolo1.exibirRelatorio();
        bolo1.comprarBolo(20);
        bolo1.exibirRelatorio();
        bolo1.comprarBolo(50);
        bolo1.exibirRelatorio();
        bolo1.comprarBolo(6);
        bolo1.exibirRelatorio();
        
        Bolo bolo2 = new Bolo();
        bolo2.sabor = "cocada";
        bolo2.quantidadeVendida = 0;
        bolo2.valor = 10.0;
        
        Bolo bolo3 = new Bolo();
        bolo3.sabor = "formigueiro";
        bolo3.quantidadeVendida = 0;
        bolo3.valor = 100.0;
    }
}
