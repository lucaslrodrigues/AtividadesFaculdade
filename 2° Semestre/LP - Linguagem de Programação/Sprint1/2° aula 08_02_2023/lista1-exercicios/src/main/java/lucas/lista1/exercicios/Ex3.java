
package lucas.lista1.exercicios;

import java.util.Scanner;

/**
 *
 * @author aluno
 */
public class Ex3 {
    public static void main(String[] args) {
        
        Scanner reader = new Scanner (System.in);
        
        System.out.println("Digite em minutos o tempo que você passou aquecendo:");
        Integer tempoAquecimento = reader.nextInt();
        
        System.out.println("Digite em minutos o tempo que você passou fazendo exercicios aerobicos:");
        Integer tempoAerobicos = reader.nextInt();
        
        System.out.println("Digite em minutos o tempo que você passou praticando musculação:");
        Integer tempoMusculacao = reader.nextInt();
        
        Integer sumTime = tempoAquecimento + tempoAerobicos + tempoMusculacao;
        Integer sum = (tempoAquecimento * 12) + (tempoAerobicos * 20) + (tempoMusculacao * 25);
        
        System.out.println("Olá, Jorge. Você fez um total de " 
                + sumTime + " minutos de exercícios e perdeu cerca de\n"
                + sum + " calorias");
    }
}
