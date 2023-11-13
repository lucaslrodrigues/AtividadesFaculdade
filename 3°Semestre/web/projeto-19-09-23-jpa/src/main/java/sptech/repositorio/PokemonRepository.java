package sptech.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import sptech.dominio.Pokemon;

/*
A interface JpaRepository possui os principais métodos de acesso a banco
(gravação, recuperação, exclusão etc)

Dentro do <>,
o 1o valor é a classe da Entidade
o 2o valor é a classe do Id (como na entidade é int, aquii usamos Integer porque tem que ser classe)
 */
public interface PokemonRepository
                    extends JpaRepository<Pokemon, Integer> {
}
