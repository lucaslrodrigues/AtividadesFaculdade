package sptech.dto.mapper;

import sptech.dominio.Pokemon;
import sptech.dto.PokemonRelatorioDTO;

/*
Mapper é "mapear" ou converter uma entidade em DTO
 */
public class PokemonRelatorioMapper extends Mapper<Pokemon, PokemonRelatorioDTO>{

    @Override
    protected PokemonRelatorioDTO converterEntidadeParaDto(Pokemon entidade) {
        return new PokemonRelatorioDTO(entidade);
    }

    @Override
    protected Pokemon converterDtoParaEntidade(PokemonRelatorioDTO dto) {
        Pokemon entidade = new Pokemon();
        entidade.setNome(dto.getNome());
        return entidade;
    }
}
