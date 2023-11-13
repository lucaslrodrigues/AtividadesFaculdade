package sptech.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import sptech.dominio.Pokemon;
import sptech.dominio.TipoPokemon;
import sptech.repositorio.TipoPokemonRepository;

import javax.validation.Valid;

@RestController
@RequestMapping("/tipos-pokemon")
public class TipoPokemonContoller {
    private TipoPokemonRepository repository;

    public TipoPokemonContoller(TipoPokemonRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<TipoPokemon> get(@PathVariable int codigo){
        if (repository.existsById(codigo)){
            return ResponseEntity.status(200).body(repository.findById(codigo).get());
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tipo de pokemon " + codigo + " não existe!");
    }


}
