/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lucas.correcao.lista.poo;

/**
 *
 * @author lukas
 */
public class Encomenda {
    String tamanho;
    String enderecoRemetente;
    String enderecoDestinatario;
    Double distancia;
    Double valorEncomenda;
    
    Double calcularFrete () {
        Double valorFrete = null;
        if (tamanho.equals("P")) {
            valorFrete = valorEncomenda * 0.01;
        } else if (tamanho.equals("M")) {
            valorFrete = valorEncomenda * 0.03;
        } else if (tamanho.equals("G")) {
            valorFrete = valorEncomenda * 0.05;
        }
        
        if (distancia < 50.0) {
            valorFrete += 3.0;
        }else if ( distancia < 200){
            valorFrete += 5.0;
        }else{
            valorFrete += 7.0;
        }
        return valorFrete;
    }
    
    void emitirEtiqueta(){
        Double frete = calcularFrete();
        Double valorTotal = frete + valorEncomenda;
        String bar = "\n-----------------------------------------\n";
        System.out.println(String.format("***** ETIQUETA PARA ENVIO *****\n"
                + "Endereco do remetente: %s\n"
                + "Endereco destinatario: %s\n"
                + "Tamanho: %s\n"
                + "%s"
                + "Valor encomenda: R$%.2f \n"
                + "Valor frete: R$%.2f \n"
                + "%s"
                + "Valor total: R$%.2f", 
                enderecoRemetente, 
                enderecoDestinatario, 
                tamanho, 
                bar, 
                valorEncomenda, 
                frete, 
                bar,
                valorTotal));
    }
}
