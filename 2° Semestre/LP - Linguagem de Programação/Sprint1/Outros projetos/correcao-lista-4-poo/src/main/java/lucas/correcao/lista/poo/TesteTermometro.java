/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lucas.correcao.lista.poo;

/**
 *
 * @author lukas
 */
public class TesteTermometro {
    public static void main(String[] args) {
        Termometro term = new Termometro();
        term.temperaturaAtual = 25.0;
        term.temperaturaMaxima = 35.0;
        term.temperaturaMinima = 15.0;
        
        term.aumentaTemperatura(5.0);
        term.exibeFahreinheit();
        
        term.diminuirTemperatura(20.0);
        term.exibeFahreinheit();
    }
}
