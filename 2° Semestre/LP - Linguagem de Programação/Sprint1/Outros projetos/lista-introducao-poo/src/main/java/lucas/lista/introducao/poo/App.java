/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package lucas.lista.introducao.poo;
/**
 *
 * @author lukas
 */
public class App {

    public static void main(String[] args) {
        Bolo bolo = new Bolo();
        
        String saborBolo1 = "Floresta negra";
        Integer qtdBolo1 = 7;
        bolo.comprarBolo(qtdBolo1, saborBolo1);
        
        String saborBolo2 = "Cenoura";
        Integer qtdBolo2 = 4;
        bolo.comprarBolo(qtdBolo2, saborBolo2);
        
        String saborBolo3 = "Prestigio";
        Integer qtdBolo3 = 17;
        bolo.comprarBolo(qtdBolo3, saborBolo3);
    }
}
