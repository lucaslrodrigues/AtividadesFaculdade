/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lucas.lista2;

import java.util.Scanner;

/**
 *
 * @author Lucas
 */
public class Votacao {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        
        Integer mussarela = 0;
        Integer calabresa = 0;
        Integer quatroQueijos = 0;
        String bar = "---------------------------";
        for (int i = 0; i < 10; i ++){
            System.out.println(String.format("%s\nVote em algum sabor:\n"
                    + "5 - Mussarela\n25 - SCalabresa\n"
                    + "50 - Quatro queijos", bar));
            Integer nextPizza = reader.nextInt();
            switch (nextPizza){
                case 5:
                    mussarela ++;
                    break;
                case 25:
                    calabresa ++;
                    break;
                case 50:
                    quatroQueijos ++;
                    break;
                default:
                    System.out.println(String.format("%s\nDigite um valor válido", bar, bar));
            }
        }
        String maior;
        Integer ptsMaior;
        
        if (mussarela == 0 && calabresa == 0 && quatroQueijos == 0){
            System.out.println("\nNenhum sabor favorito");
        }else{
            if (mussarela > calabresa) {
                maior = "Mussarela";
                ptsMaior = mussarela;
            }else{
                maior = "Calabresa";
                ptsMaior = calabresa;
            }
            maior = ptsMaior > quatroQueijos ? maior : "Quatro queijos";

            System.out.println(String.format("\nVotos:\nMussarela = %d\n"
                    + "Calabresa = %d\nQuatro queijos = %d\n\n"
                    + "O valor favorito é %s!", 
                    mussarela, calabresa, quatroQueijos, maior));
        }
    }
}
