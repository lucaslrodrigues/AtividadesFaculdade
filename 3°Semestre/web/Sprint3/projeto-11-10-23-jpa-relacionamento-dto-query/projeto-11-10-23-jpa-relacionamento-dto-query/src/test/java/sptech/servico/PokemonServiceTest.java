package sptech.servico;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.server.ResponseStatusException;
import sptech.dominio.Pokemon;
import sptech.dominio.TipoPokemon;
import sptech.repositorio.PokemonRepository;
import sptech.repositorio.TipoPokemonRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = PokemonService.class)
class PokemonServiceTest {
    @Autowired
    PokemonService service;
    @MockBean // Indica que o atributo não será de verdade. Será um Mock
    PokemonRepository pokemonRepository;
    @MockBean
    TipoPokemonRepository tipoPokemonRepository;

    @Test // Indica que o metodo é um cenário de teste
    @DisplayName("getForcaGolpe() Deve calcular corretamente")
    void getForcaAposGolpe() {
        PokemonService service = new PokemonService(null, null);
        double resultado = service.getForcaAposGolpe(100.0, 20.0);
        assertEquals(80.0, resultado);
        double resultado2 = service.getForcaAposGolpe(100.0, 30.0);
        assertEquals(70.0, resultado2);
        double resultado3 = service.getForcaAposGolpe(100.0, 90.0);
        assertEquals(10.0, resultado3);
    }

    @ParameterizedTest // Indica que serão realizados vários cenários em um teste só
    @CsvSource(value =
            {"100:20:80", "100:30:70", "100:90:10", "50:200:0", "300:400:0"}, delimiter=':')
    @DisplayName("getForcaGolpe() Deve calcular corretamente")
    void getForcaAposGolpeVariosCenarios(double forca, double golpe, double esperado) {
        PokemonService service = new PokemonService(null, null);
        double resultado = service.getForcaAposGolpe(forca, golpe);
        assertEquals(esperado, resultado);
    }

    @Test
//    @CsvSource(value)
    @DisplayName("Deve ocorrer exceção caso a força ou o golpe forem negativos")
    void getForcaGolpeErro(){
        PokemonService service = new PokemonService(null, null);
        assertThrows(IllegalArgumentException.class, () -> service.getForcaAposGolpe(100, -10));
        assertThrows(IllegalArgumentException.class, () -> service.getForcaAposGolpe(-100, 10));
    }

    @Test
    @DisplayName("apanhar deve reduzir a força corretamente")
    void apanharOk(){
        // Configurando comportamento
        var codigo = 10;
        when(pokemonRepository.existsById(codigo)).thenReturn(true);
        var pokemonTeste = new Pokemon();
        var tipoPokemon = new TipoPokemon();
        tipoPokemon.setForcaMaxima(100.0);
        pokemonTeste.setTipo(tipoPokemon);
        pokemonTeste.setForca(100.0);

        when(pokemonRepository.findById(codigo)).thenReturn(Optional.of(pokemonTeste));

        service.apanhar(codigo, 30.0);
        assertEquals(70.0, pokemonTeste.getForca());
    }

    @Test
    @DisplayName("apanhar deve lançar uma exceção se o código for inválido")
    void apanharCodigoInvalido() {
        // Configurando comportamento
        var codigo = 51;
        when(pokemonRepository.existsById(codigo)).thenReturn(false);

//        assertThrows(ResponseStatusException.class, () -> service.apanhar(codigo, 100.0));
        ResponseStatusException exception = assertThrows(ResponseStatusException.class,
                () -> service.apanhar(codigo, 100.0));
        assertEquals(404, exception.getRawStatusCode()=
                );
    }
}