package sptech.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import sptech.dominio.TipoPokemon;

import java.util.List;

public interface TipoPokemonRepository extends JpaRepository<TipoPokemon, Integer> {
    TipoPokemon findByNomeIgnoreCase(String nome);
}
