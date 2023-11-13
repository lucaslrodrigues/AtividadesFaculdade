package sptech.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sptech.dominio.Pokemon;
import sptech.dominio.TipoPokemon;
import sptech.dto.PokemonSimplesDTO;
import sptech.repositorio.PokemonRepository;
import sptech.repositorio.TipoPokemonRepository;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/pokemons")
public class PokemonController {
    @Autowired
    PokemonRepository repository;
    @Autowired
    TipoPokemonRepository tipoPokemonRepository;

    @PostMapping("/tipo")
    public ResponseEntity post(@RequestParam String nome, @RequestParam int id) {
        TipoPokemon tp = new TipoPokemon(id, nome);
        tipoPokemonRepository.save(tp);
        return ResponseEntity.status(201).body(tp);
    }

    @GetMapping("/")
    public ResponseEntity<List<Pokemon>> getRepository() {
        List<Pokemon> pokemons = repository.findAll();
        return pokemons.isEmpty() ? ResponseEntity.status(204).build() : ResponseEntity.status(200).body(pokemons);
    }

    @PostMapping("/")
    public ResponseEntity post(@RequestBody @Valid Pokemon novoPokemon){
        repository.save(novoPokemon);
        return repository.existsById(novoPokemon.getCodigo()) ? ResponseEntity.status(201).body(novoPokemon.getCodigo()) : ResponseEntity.status(400).body(novoPokemon.getCodigo());
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Pokemon> get(@PathVariable int codigo){
        // findById() Optional que pode retornar ou não
        // ResponseEntity.of() retorna?
        // - 404 para não encontrado
        // - 200 para valor encontrado
        return ResponseEntity.of(repository.findById(codigo));
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity delete(@PathVariable int codigo){
        if (repository.existsById(codigo)){
            repository.deleteById(codigo);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Pokemon> put(@RequestBody @Valid Pokemon pokemon, @PathVariable int codigo){
        if (repository.existsById(codigo)) {
            pokemon.setCodigo(codigo);
            repository.save(pokemon);
            return ResponseEntity.status(200).body(pokemon);
        }
        return ResponseEntity.status(404).build();
    }

    @GetMapping("/simples")
    public ResponseEntity<List<PokemonSimplesDTO>> filtrarSimples(){
        List<PokemonSimplesDTO> lista = repository.findAllSimples();

        return lista.isEmpty() ? ResponseEntity.status(204).build(): ResponseEntity.status(200).body(lista);
    }

    @GetMapping("/filtro-tipo")
    public ResponseEntity<List<Pokemon>> filtrarTipo(@RequestParam String tipo){
        List<Pokemon> pokemonsTipo = repository.findByTipo(tipoPokemonRepository.findByNomeIgnoreCase(tipo));
        return pokemonsTipo.isEmpty() ? ResponseEntity.status(204).build() : ResponseEntity.status(200).body(pokemonsTipo);
    }

    @GetMapping("/contagem-tipo")
    public ResponseEntity<Integer> contarTipo(@RequestParam String tipo){
        int contagemTipo = repository.countByTipo(tipoPokemonRepository.findByNomeIgnoreCase(tipo));
        return contagemTipo == 0 ? ResponseEntity.status(204).build() : ResponseEntity.status(200).body(contagemTipo);
    }

    @GetMapping("/presos")
    public ResponseEntity<List<Pokemon>> retornarPresos(){
        List<Pokemon> presos = repository.findAllByLivreFalse();
        return presos.isEmpty() ? ResponseEntity.status(204).build() : ResponseEntity.status(200).body(presos);
    }

    @GetMapping("/contagem-soltos")
    public ResponseEntity<Integer> contagemSoltos(){
        int contagemSoltos = repository.countByLivreFalse();
        return contagemSoltos == 0 ? ResponseEntity.status(204).build() : ResponseEntity.status(200).body(contagemSoltos);
    }

    @DeleteMapping("/presos")
    public ResponseEntity<List<Pokemon>> deletePresos(){
        List<Pokemon> toDelete = repository.deleteByLivreFalse();

        return toDelete.isEmpty() ? ResponseEntity.status(204).build() : ResponseEntity.status(200).body(toDelete);
    }

    @GetMapping("/filtro-forca/{forcaMinima}/{forcaMaxima}")
    public ResponseEntity<List<Pokemon>> intervaloDeForca(@PathVariable double forcaMaxima, @PathVariable double forcaMinima){
        List<Pokemon> pokemons = repository.findAllByForcaBetween(forcaMinima, forcaMaxima);
        return pokemons.isEmpty() ? ResponseEntity.status(204).build() : ResponseEntity.status(200).body(pokemons);
    }
}
