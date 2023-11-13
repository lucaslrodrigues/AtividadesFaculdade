package sptech.dominio;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PokemonTest {

    @Test
    @DisplayName("setForca() deve lançar exceção caso a força seja maior que a força máxima daquele tipo")
    void setForca() {
        Pokemon pokemon = new Pokemon();
        TipoPokemon tipo = new TipoPokemon();
        tipo.setForcaMaxima(150.0);
        pokemon.setTipo(tipo);
        assertThrows(IllegalArgumentException.class, () -> pokemon.setForca(9999.9));
    }
}