package sptech.dto.mapper;

import sptech.dominio.Pokemon;

import java.util.Optional;

/*
Classe abstrata Mapper que usa Generics
E -> Tipo da Entidade
D -> Tipo do DTO
 */
public abstract class Mapper<E, D> {
    protected abstract D converterEntidadeParaDto(E entidade);
    protected abstract E converterDtoParaEntidade(D dto);

    public D paraDTO(E entidade) {
        if (entidade == null) {
            return null;
        }
        return converterEntidadeParaDto(entidade);
    }

    public E paraEntidade(D dto) {
        if (dto == null) {
            return null;
        }
        return converterDtoParaEntidade(dto);
    }
}
