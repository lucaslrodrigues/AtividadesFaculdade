/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lucas.correcao.lista.poo;

/**
 *
 * @author lukas
 */
public class AppEncomenda {
    public static void main(String[] args) {
        Encomenda enc1 = new Encomenda();
        enc1.distancia = 13.7;
        enc1.enderecoDestinatario = "Av. Tarciso Atrio, 232";
        enc1.enderecoRemetente = "Rua Tiurusbangos, 695";
        enc1.tamanho = "G";
        enc1.valorEncomenda = 20.0;
        enc1.emitirEtiqueta();
    }
}
