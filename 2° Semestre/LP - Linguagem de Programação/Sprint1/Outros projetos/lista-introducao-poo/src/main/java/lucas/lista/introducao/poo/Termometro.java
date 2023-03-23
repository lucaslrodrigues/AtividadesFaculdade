/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lucas.lista.introducao.poo;

/**
 *
 * @author lukas
 */
public class Termometro {
    Double temperaturaAtual;
    Double temperaturaMaxima;
    Double temperaturaMinima;
    
    void aumentaTemperatura (Double tempAumentar){
        if ((tempAumentar + temperaturaAtual) >= temperaturaMaxima){
            temperaturaAtual = temperaturaMaxima;
        } else {
            temperaturaAtual += tempAumentar;
        }
    }
    
    void diminuirTemperatura (Double tempDiminuir){
        if ((temperaturaAtual - tempDiminuir) <=  temperaturaMinima){
            temperaturaAtual = temperaturaMinima;
        } else {
            temperaturaAtual -= tempDiminuir;
        }
    }
    
    void exibeFahreinheit () {
        Double toF = (temperaturaAtual * (9/5)) + 32;
        System.out.println(String.format("Temperatura atual: %.1f\n"
                + "Em Fahreinheit: %.2f", temperaturaAtual, toF));
    }
}
