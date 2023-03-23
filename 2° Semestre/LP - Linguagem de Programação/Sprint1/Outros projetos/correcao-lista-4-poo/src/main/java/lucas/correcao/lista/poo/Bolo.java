/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package lucas.correcao.lista.poo;

/**
 *
 * @author lukas
 */
public class Bolo {
    String sabor;
    Double valor;
    Integer quantidadeVendida;
    
    public void comprarBolo(Integer qtdDesejada){
        Integer qtdSomadas = qtdDesejada + quantidadeVendida;
        if ((qtdSomadas) > 100){
            System.out.println("Seu pedido ultrapassou nosso limite diário para esse bolo");
        }else{
            quantidadeVendida += qtdDesejada;
        }
    }
    
    public void exibirRelatorio(){
        Double totalVendas = quantidadeVendida * valor;
        System.out.println(String.format("O bolo sabor %s, foi comprado %d vezes hoje, totalizando %.2f", sabor, quantidadeVendida, totalVendas));
    }
}
