/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lucas.lista.introducao.poo;

/**
 *
 * @author lukas
 */
public class TesteTermometro {
    public static void main(String[] args) {
        Termometro term = new Termometro();
        term.temperaturaAtual = 22.0;
        term.temperaturaMaxima = 27.0;
        term.temperaturaMinima = 17.0;
        
        term.aumentaTemperatura(30.0);
        term.exibeFahreinheit();
        
        term.diminuirTemperatura(8.0);
        term.exibeFahreinheit();
    }
}
