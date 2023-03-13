/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lucas.projeto.individual;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author lukas
 */
public class Metods {
    
    String bar = "\n-------------------------------------------------"
                + "-------------------------\n";
    
    Integer converterParaIdadeGato (Integer idade){
        if (idade <= 2) {
            return 15;
        }else{
            Integer idadeGato = ((idade - 1) * 4) + 15;
            return idadeGato;
        }
    }
    
    void exibirIdadeDeGato (Integer idade) {
        Integer idadeGato = converterParaIdadeGato(idade);
        
        System.out.println(String.format("Sua idade equivale a "
                + "%d anos para um gato", idadeGato));
    }
    
    
    // SORTEIO
        

    
    String sortearRaca() {
        String raca;
        Integer numSorteado = ThreadLocalRandom.current().nextInt(1 , 10);
        switch(numSorteado){
            case 1:
                raca = "Maine Coon";
                break;
            case 2:
                raca = "Sohynx";
                break;
            case 3:
                raca = "Gato Persa";
                break;
            case 4:
                raca = "British Shorthair";
                break;
            case 5:
                raca = "Siamês";
                break;
            case 6:
                raca = "Angorá";
                break;
            case 7:
                raca = "Himalaio";
                break;
            case 8:
                raca = "Ragdoll";
                break;
            default:
                raca = "bons e velhos gatos vira-latas"
                        +"\n\nGuarde a sete chaves..."
                        + "\n----- NGC6543 -----";
        }
        
        return raca;
    }
    
    void exibirRacaSorteada(){
        String raca = sortearRaca();
        System.out.println(String.format(
                "A raça que combina com você é a dos %s!!", raca));
    }
            
    // JOGO
    Integer pontosJogador = 0;
    void exibirOpcoesJogo(){
        System.out.println("-------- LUTA -------\n"
        + "\nVocê lutará contra o animal domestico"
        + " mais impiedoso e maligno!\n"
        + "Este é um jogo de turnos, a cada rodada"
        + " você pode escolher entre atacar ou defender."
        + "\nPontos de defesa e ataque são sorteados"
        + " aleatoriamente, sendo defesa de 0 a 4 "
        + "e ataque de 0 a 5. (quem vencer não perde vida)"
        + "\nCaso a defesa vença, o ataque perde 2 de vida\n"
        + "\nAlguns deles começam com"
        + " vantagens de ataque ou defesa."
        + "\nEscolha seu campeão!\n\n"
        + "[1] Gato mago - ataque: 2, defesa: "
        + "0\n"
        + "[2] Gato sptecher - ataque: 1, "
        + "defesa: 1\n"
        + "[3] Gato de schodinger - ataque: 0, "
        + "defesa: 0, especial (????)");
    }
    
    Integer definirAtaqueHeroi(Integer heroi){
        Integer ataque = 0;
        
        if (heroi.equals(1)){
            ataque = 2;
        }else if (heroi.equals(2)){
            ataque = 1;
        }else if (heroi.equals(3)){
            ataque = 0;
        }
        
        return ataque;
    }
    
    Integer definirDefesaHeroi(Integer heroi){
        Integer defesa = 0;
        
        if (heroi.equals(1)){
            defesa = 0;
        }else if (heroi.equals(2)){
            defesa = 1;
        }else if (heroi.equals(3)){
            defesa = 0;
        }
        
        return defesa;
    }
    
    Integer defender (Integer heroi){
        System.out.println("--------- DEFESA --------");
        Integer inimigoAcao =
                ThreadLocalRandom.current().nextInt(1, 3);
                // 1 = ataque, 2 = defesa
        
        Integer valorDefesa = definirDefesaHeroi(heroi);
        
        Integer defesaJogador =
                ThreadLocalRandom.current().nextInt(1, 4)+ valorDefesa;
        
        Integer resultado;
        
        // 100 = perdeu, 200 = venceu e 300 = empate.

        if (inimigoAcao.equals(1)) {
            Integer acao = ThreadLocalRandom.current().nextInt(0, 5);
            if (acao > defesaJogador){
                
                if ((acao - defesaJogador) == 0) {
                    resultado = (acao - defesaJogador) + 101;
                    System.out.println(String.format("O adversario atravesou a "
                        + " defesa causando %d de dano", ((acao - defesaJogador) + 1)));
                }else{
                    resultado = (acao - defesaJogador) + 100;
                    System.out.println(String.format("O adversario atravesou a "
                            + " defesa causando %d de dano", (acao - defesaJogador)));
                }
            }else{
                resultado = 200 + 2;
                System.out.println("O jogador conseguiu"
                        + " defender e causou 2 de dano!");
            }
        }else{
            resultado = 300;
            System.out.println("\n-------- AMBOS DEFENDERAM ---------\n"
                    + "(AMBOS PERDEM 1 DE VIDA)");
        }
        return resultado;
    }
    
    Integer atacar (Integer heroi){
        System.out.println("------- ATAQUE ---------");
            Integer inimigoAcao =
                ThreadLocalRandom.current().nextInt(1, 3);
                // 1 = ataque, 2 = defesa
            
            Integer valorAtaque = definirAtaqueHeroi(heroi);        

            Integer ataqueJogador =
                ThreadLocalRandom.current().nextInt(1, 4 ) + valorAtaque;
                // Valor do ataque
        Integer resultado;
        
        // 100 = perdeu, 200 = venceu e 300 = empate.
        
        Integer acao = ThreadLocalRandom.current().nextInt(0, 5);
        if (inimigoAcao.equals(2)) {
            if (acao > ataqueJogador){
                
                resultado = 100 + 2;
                System.out.println("O adversario defendeu"
                        + " e causou 2 de dano");
            }else{
                if ((ataqueJogador - acao) == 0) {
                    resultado = 201 + (ataqueJogador - acao);
                    System.out.println(String.format("O jogador conseguiu"
                            + " atravessar a defesa e causou %d de dano!",
                            ((ataqueJogador - acao)+1)));
                }else{
                    resultado = 200 + (ataqueJogador - acao);
                    System.out.println(String.format("O jogador conseguiu"
                            + " atravessar a defesa e causou %d de dano!",
                            (ataqueJogador - acao)));
                }
            }
        }else{
            resultado = 300;
            System.out.println("\n-------- Empate ---------\n"
                    + "(AMBOS PERDEM 1 DE VIDA)");                

        }
        return resultado;
    }
    
    Integer atacar (Integer heroi, String frase){
        // ATAQUE ESPECIAL
        System.out.println(String.format("%s", frase));
            Integer inimigoAcao =
                ThreadLocalRandom.current().nextInt(1, 3);
                // 1 = ataque, 2 = defesa
            
            Integer ataqueJogador =
                ThreadLocalRandom.current().nextInt(1, 4) + 5;
                // Valor do ataque
        Integer resultado;
        
        // 100 = perdeu, 200 = venceu e 300 = empate.
        
        if (inimigoAcao.equals(2)) {
            Integer acao = ThreadLocalRandom.current().nextInt(0, 5);
            if (acao > ataqueJogador){
                
                resultado = 100 + 2;
                System.out.println("O adversario defendeu"
                        + " e causou 2 de dano");
            }else{
                resultado = 200 + (ataqueJogador - acao);
                System.out.println(String.format("O jogador conseguiu"
                        + " atravessar a defesa e causou %d de dano!",
                        (ataqueJogador - acao)));
            }
        }else{
            resultado = 200 + ataqueJogador;
            System.out.println(String.format("O ataque do inimigo é "
                    + "quebrado e o jogador causa %d de dano", ataqueJogador));
        }
        return resultado;
    }
    
    void exibirResultado(Integer vidaJogador, Integer vidaAdversario){
        
        String resultado = definirResultado(vidaJogador, vidaAdversario);
        
            System.out.println(String.format("%s%s"
                    + "\nJogador: %d\nAdversario: %d\n\nPONTUAÇÂO: %d\n"
                    + "OBRIGADO POR JOGAR"
                    , bar, resultado,  vidaJogador, 
                    vidaAdversario, pontosJogador));

    }
    
    String definirResultado(Integer vidaJogador, Integer vidaAdversario){
        if (vidaJogador.equals(vidaAdversario)){
            return "EMPATE";
        }else if (vidaJogador >= 10){
            pontosJogador++;
            return "INTACTO";
        }else if (vidaJogador > vidaAdversario && vidaAdversario < -3){
            pontosJogador++;
            return "MASSACROU";
        }else if (vidaJogador > vidaAdversario){
            pontosJogador++;
            return "VITORIOSO";
        }else{
            return "DERROTA";
        }
    }
    
    void exibirEncerramento(){
        System.out.println("________________________\n" +
                            "|                       |\n" +
                            "|     ATÉ A PROXIMA     |\n" +
                            "|                       |\n" +
                            "|_______________________|\n" +
                            "          ||\n" +
                            "          ||\n" +
                            "          ||         ( ^..^)/");
    }
}
