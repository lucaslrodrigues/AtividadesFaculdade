package sptech.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import sptech.dominio.TipoPokemon;

public interface TipoPokemonRepository extends JpaRepository<TipoPokemon, Integer> {

}
