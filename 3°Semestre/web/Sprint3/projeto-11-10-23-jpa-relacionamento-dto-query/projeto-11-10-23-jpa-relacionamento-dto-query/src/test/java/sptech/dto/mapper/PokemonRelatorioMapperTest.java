package sptech.dto.mapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sptech.dominio.Pokemon;
import sptech.dominio.TipoPokemon;
import sptech.dto.PokemonRelatorioDTO;

import static org.junit.jupiter.api.Assertions.*;

class PokemonRelatorioMapperTest {

    PokemonRelatorioMapper mapper = new PokemonRelatorioMapper();

    @Test
    @DisplayName("conversão para dto deve preencher os campos")
    void converterEntidadeParaDto() {
        Pokemon entidade = new Pokemon();
        TipoPokemon tipoPokemon = new TipoPokemon();
        tipoPokemon.setNome("tipo X");
        tipoPokemon.setForcaMaxima(9_000.0);
        entidade.setTipo(tipoPokemon);
        entidade.setNome("Nome X");
        entidade.setForca(7000.0);
        entidade.setLivre(true);

        PokemonRelatorioDTO dto = mapper.paraDTO(entidade);

        assertEquals(entidade.getNome(), dto.getNome());
        assertEquals(entidade.isLivre(), dto.getLivre());
        assertEquals("Forte", dto.getClassificacao());
        assertEquals(entidade.getTipo().getNome(), dto.getNomeTipo());

        PokemonRelatorioDTO dtoNull = mapper.paraDTO(null);
        assertNull(dtoNull);
    }

    @Test
    void converterDtoParaEntidade() {
        Pokemon entidadeOriginal = new Pokemon();
        entidadeOriginal.setNome("Bicho A");
        PokemonRelatorioDTO dto = new PokemonRelatorioDTO(entidadeOriginal);

        Pokemon entidade = mapper.paraEntidade(dto);

        assertEquals(dto.getNome(), entidade.getNome());

        Pokemon entidadeNull = mapper.paraEntidade(null);
        assertNull(entidadeNull);
    }
}