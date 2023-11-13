package sptech.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sptech.dominio.Pokemon;
import sptech.dominio.TipoPokemon;
import sptech.dto.PokemonSimplesDTO;

import javax.transaction.Transactional;
import java.util.List;

public interface PokemonRepository extends JpaRepository<Pokemon, Integer> {
    List<Pokemon> findByNomeContains(String nome);

    @Query("""
            select new sptech.dto.PokemonSimplesDTO(p.codigo, p.nome)
            from Pokemon p
            """)
    List<PokemonSimplesDTO> findAllSimples();

    List<Pokemon> findByTipo(TipoPokemon tipo);

    int countByTipo(TipoPokemon tipo);

    List<Pokemon> findAllByLivreFalse();
    int countByLivreFalse();

    @Transactional
    List<Pokemon> deleteByLivreFalse();

    List<Pokemon> findAllByForcaBetween(double forcaMinima, double forcaMaxima);
}
