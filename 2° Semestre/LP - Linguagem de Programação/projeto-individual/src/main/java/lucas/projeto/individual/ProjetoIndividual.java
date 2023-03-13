/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package lucas.projeto.individual;

import java.util.Scanner;

/**
 *
 * @author lukas
 */
public class ProjetoIndividual {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        Metods classe = new Metods();

        String bar = "\n-------------------------------------------------"
                + "-------------------------\n";
        
        System.out.println("Gatos!!\nSeres peculiares e comuns que ganharam"
                + " mistisismos, posto de entidade como deuses"
                + " e amigo (ou inimigo) dos lares)");
        
        Boolean verify = true;
        
        while (verify) {
            System.out.println(String.format("%s1 - Quantos anos"
                    + " de gato voê têm?\n"
                    + "2 - Você é um amante de gatos?\n"
                    + "3 - Sortear raça de gatos\n"
                    + "4 - Sair\n"
                    + "5 - Jogo", bar));
            Integer escolha = leitor.nextInt();
            
            switch (escolha){
                case 1:
                    System.out.println(String.format("%sSabia que"
                            + " o primeiro ano de um gato"
                            + " podem ser comparados a 15 anos do nosso"
                            + " ponto de vista?\nOs demais se comparam a "
                            + "4 anos humanos!\n\n"
                            + "Qual a sua idade?", bar));
                    Integer idade = leitor.nextInt();

                    classe.exibirIdadeDeGato(idade);
                    break;
                case 2:
                    System.out.println(String.format("%sOs egipcios"
                            + " consideravam eles criaturas"
                            + " magicas que traziam sorte"
                            + " por volta de 2.000ac.\n"
                            + "Você têm um gato?\n"
                            + "[s] ou [n]", bar));
                    String teste = leitor.nextLine();
                    String resposta = leitor.nextLine();

                    if ("n".equals(resposta)){
                        System.out.println("Você costuma comentar"
                                + " sobre a vida das outras pessoas?"
                                + " (fofoca ou stalkear, seja sincero)\n"
                                + "[s] ou [n]");
                        resposta = leitor.nextLine();
                        if ("n".equals(resposta)) {
                            System.out.println("Você não precisa"
                                    + " de gatos! A vida é bela sem"
                                    + " um animal tão perigoso em casa.");
                        }else if ("s".equals(resposta)) {
                            System.out.println("Você precisa de um gato...");
                        }else{
                            System.out.println("Valor invalido");
                        }
                    }else if ("s".equals(resposta)){
                        System.out.println("Quantos gatos você têm?");
                        Integer respostaQtdGatos = leitor.nextInt();

                        if (respostaQtdGatos >= 2) {
                            System.out.println("Você é realmente um"
                                    + " fan de gatos! Quer mais um?"
                                    + "\n\nGuarde a sete chaves..."
                                    + "----- NGC6543 -----");
                        }else{
                            System.out.println("Você gosta de felinos!");
                        }
                    }else{
                        System.out.println("Valor invalido");
                    }
                    break;
                case 3:
                    // Sorteio - raça de gato (animais?)
//                        System.out.println(String.format("%sEscolha ";;;
//                                + "um tipo de animal e sorteie a sua raça\n"
//                                + "[1] - Gato\n[2] Cachorro\n"
//                                + "[3] - Passaro", bar));
//                        Integer escolhaSorteio = leitor.nextInt();
                    System.out.println("Sorteie uma raça de gato para você");
                    leitor.nextLine();
                    classe.exibirRacaSorteada();
                    break;

                case 4:
                    verify = false;
                    break;

                case 5:
                    classe.exibirOpcoesJogo();
                    Integer heroi = leitor.nextInt();

                    Boolean confirm = true;

                    if (heroi > 3 || heroi < 1) {
                        System.out.println("Herói não encontrado");
                        confirm = false;
                    }

                    if (confirm) {

                        Integer vidaJogador = 15;
                        Integer vidaAdversario = 15;

                        Integer contador = 0;
                        Boolean verifyLuta = true;

                        while (verifyLuta) {
                            contador ++;
                            System.out.println(String.format("%sTurno %d"
                                    + "%sJogador: %d\n"
                                    + "Adversario: %d\n\n"
                                    + "[1] Defender\n[2] Atacar (default)"
                                    , bar,contador, bar,
                                    vidaJogador, vidaAdversario));

                            Integer acao = leitor.nextInt();

                            Integer resultadoTurno = 0;

                            if (acao.equals(1)) {
                                resultadoTurno = classe.defender(heroi);

                                if (resultadoTurno < 200) {
                                    vidaJogador -= (resultadoTurno - 100);
                                }else if (resultadoTurno < 300){
                                    vidaAdversario -=  (resultadoTurno - 200);
                                }else{
                                    vidaAdversario -= 1;
                                    vidaJogador -= 1;
                                }
                            }else{

                                if (contador.equals(8) && vidaJogador < vidaAdversario
                                        && heroi.equals(3)) {
                                    System.out.println("DIGITE O CODIGO "
                                            + "SECRETO...");
                                    leitor.nextLine();
                                    String cod = leitor.nextLine();
                                                                        
                                    if ("NGC6543".equals(cod)){
                                        String frase = "\nESPECIAL GATO DE "
                                                + "SCHRODINGER\n";
                                        resultadoTurno = 
                                                classe.atacar(heroi, frase);
                                    }else{
                                        System.out.println("Parece que você"
                                                + " não conheceu o segredo...");
                                    }
                                }else{
                                    
                                    resultadoTurno = classe.atacar(heroi);
                                }
                                
                                if (resultadoTurno < 200) {
                                    vidaJogador -= (resultadoTurno - 100);
                                }else if (resultadoTurno < 300){
                                    vidaAdversario -=  (resultadoTurno - 200);
                                }else{
                                    vidaAdversario -= 1;
                                    vidaJogador -= 1;
                                }                                    
                            }

                            if (vidaJogador <= 0 || vidaAdversario <= 0) {
                                verifyLuta = false;
                                classe.exibirResultado(vidaJogador, vidaAdversario);
                            }
                        }
                    }
                    break;
                default:
                    System.out.println("Opção invalida! "
                            + "digite algo valido");

            }
        }    
        classe.exibirEncerramento();
    }
}
