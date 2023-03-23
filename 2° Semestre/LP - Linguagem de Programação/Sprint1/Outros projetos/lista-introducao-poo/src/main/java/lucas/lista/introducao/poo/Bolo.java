/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lucas.lista.introducao.poo;

/**
 *
 * @author lukas
 */
public class Bolo {
    String sabor;
    Double valor = 36.76;
    Integer qtdVendida = 0;
    
    void comprarBolo (Integer qtdPedido, String saborEscolhido){
        if ((qtdPedido + qtdVendida) > 100) {
            System.out.println("O pedido ultrapassou o limite "
                    + "diário para esse bolo");
        } else {
            qtdVendida += qtdPedido;
            sabor = saborEscolhido;
            exibirRelatorio(qtdPedido, sabor);
        }
    }
    
    void exibirRelatorio(Integer qtdPedido, String sabor){
        System.out.println(String.format("O bolo sabor %s, foi comprado "
                + "%d vezes hoje, totalizando R$%.2f", 
                sabor, qtdPedido, (qtdVendida.doubleValue() * valor)));
    }
}
