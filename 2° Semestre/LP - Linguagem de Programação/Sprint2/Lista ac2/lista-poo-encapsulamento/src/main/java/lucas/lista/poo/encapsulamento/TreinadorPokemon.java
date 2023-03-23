/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lucas.lista.poo.encapsulamento;

/**
 *
 * @author lukas
 */
public class TreinadorPokemon {
    private String nome;
    private Integer nivel = 0;
    
    void treinarPokemon (Pokemon poke) {
        Integer forca = poke.getForca();
        Double aumentarForca = (forca.doubleValue() * 1.10);
        poke.setForca(aumentarForca.intValue());
        
        Integer aumentaDoces = poke.getDoces() + 10;
        poke.setDoces(aumentaDoces);
    }
    
    void evoluirPokemon (Pokemon poke, String nomeEvolucao) {
        if (poke.getDoces() >= 50) {
            String evolucaoAnterior = poke.getNome();
            poke.setNome(nomeEvolucao);
            poke.setDoces(poke.getDoces() - 50);
            nivel += 10;
            exibirEvolucao(poke, evolucaoAnterior);
        } else {
            System.out.println("Não foi possível realizar a operação");
        }
    }
    
    void exibirEvolucao(Pokemon poke, String evolucaoAnterior){
        System.out.println(String.format("Pokemon %s evolui para %s", evolucaoAnterior, poke.getNome()));
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }
}
