/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lucas.lista.poo.encapsulamento;

/**
 *
 * @author lukas
 */
public class TestePokemon {
    public static void main(String[] args) {
        Pokemon poke1 = new Pokemon();
        poke1.setNome("Nossepass");
        poke1.setTipo("Pedra");
        poke1.setForca(80);
        poke1.setDoces(0);
        
        Pokemon poke2 = new Pokemon();
        poke2.setNome("Mew");
        poke2.setTipo("Psíquico");
        poke2.setForca(90);
        poke2.setDoces(0);
        
        TreinadorPokemon treinador = new TreinadorPokemon();
        treinador.setNivel(0);
        treinador.setNome("Ash");
        
        for (int i = 0; i < 5; i++) {
            treinador.treinarPokemon(poke1);
        }
        
        poke1.exibirPokemon();
        
        treinador.evoluirPokemon(poke1, "Probopass");
        
        poke1.exibirPokemon();
        
        for (int i = 0; i < 2; i++) {
            treinador.treinarPokemon(poke2);
        }
        
        poke2.exibirPokemon();
        
        treinador.evoluirPokemon(poke2, "Mewtwo");
        
        System.out.println(String.format("Nome: %s\n"
                + "Nível: %d",
                treinador.getNome(), treinador.getNivel()));
    }
}
