/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lucas.atividade02.ac01;

/**
 *
 * @author aluno
 */
public class DescontoProgressivo {
    Double calcularDesconto(Double valorUnitario, Integer quantidade){
        if (quantidade >= 3) {
            valorUnitario *= 0.7;
        }else if (quantidade >= 2){
            valorUnitario *= 0.8;
        }else {
            valorUnitario *= 0.9;
        }
        
        return valorUnitario * quantidade;
    }
    
    void exibirNotaFiscal(Double valorUnitario, Integer quantidade){
        Double valorNota = calcularDesconto(valorUnitario, quantidade);
        Double desconto = (quantidade * valorUnitario) - valorNota;
        
        String bar = "\n---------------------------------------\n";
        
        System.out.println(String.format("Valor do produto: R$"
                + "%.2f\nQuantidade: %d %s"
                + "Valor desconto: R$%.2f"
                , valorNota, quantidade, bar, desconto));
    }
}
