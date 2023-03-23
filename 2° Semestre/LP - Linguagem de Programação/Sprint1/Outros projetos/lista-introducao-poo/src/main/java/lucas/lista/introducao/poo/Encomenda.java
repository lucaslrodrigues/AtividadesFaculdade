/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lucas.lista.introducao.poo;

/**
 *
 * @author lukas
 */
public class Encomenda {
    String tamanho = "P";
    String enderecoRemetente;
    String enderecoDestinatario;
    Double distancia;
    Double valorEncomenda;
    Double valorFrete;
    
    void calculaFrete (String tamanhoEscolhido, 
            Double distanciaDigitada, Double valorDigitado) {
        tamanho = tamanhoEscolhido;
        distancia = distanciaDigitada;
        
        if (tamanho.equals("P")) {
            valorEncomenda = 1.01 * valorDigitado;
        } else if (tamanho.equals("M")) {
            valorEncomenda = 1.03 * valorDigitado;
        } else if (tamanho.equals("G")) {
            valorEncomenda = 1.05 * valorDigitado;
        }
        
        if (distancia < 50.0) {
            valorFrete = 3.0;
        }else if ( distancia < 200){
            valorFrete = 5.0;
        }else{
            valorFrete = 7.0;
        }
        emitirEtiqueta();
    }
    
    void emitirEtiqueta(){
        String bar = "\n-----------------------------------------\n";
        System.out.println(String.format("***** ETIQUETA PARA ENVIO *****\n"
                + "Endereco do remetente: %s\n"
                + "Endereco destinatario: %s\n"
                + "Tamanho: %s\n"
                + "%s"
                + "Valor encomenda: R$.2f\n"
                + "Valor frete: R$%.2f\n"
                + "%s"
                + "Valor total: R$%.2f", 
                enderecoRemetente, enderecoDestinatario, tamanho, bar, 
                valorEncomenda, valorFrete, bar ,(valorFrete + valorEncomenda)));
    }
}
