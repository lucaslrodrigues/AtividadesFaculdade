package sptech.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import sptech.dominio.Pokemon;
import sptech.dto.PokemonSimplesDTO;
import sptech.repositorio.PokemonRepository;
import sptech.servico.PokemonService;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/pokemons")
public class PokemonController {

    /*
@Autowired -> indica que o Spring vai ser responsável
em criar uma classe que implementa a interface e
instanciar esse atributo antes que ele seja usado por algum método
     */
    @Autowired
    PokemonRepository repository;

    @Autowired
    PokemonService service;

    @GetMapping("/")
    public List<Pokemon> get() {
// findAll() -> select * from tabela
        return repository.findAll();
    }

//    @PostMapping("/")
//    public void post(@RequestBody @Valid Pokemon novoPokemon) {
//// save() -> neste caso fez o insert pois não estamos passando o id
//        repository.save(novoPokemon);
//    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Pokemon> get(@PathVariable int codigo) {
/*
.findById() -> retorna um Optional (que tem ou não valor)
ResponseEntity.of() pode retornar?
 - status 404 e sem corpo caso o Optinal for sem valor
 - status 200 com o valor do Optional caso ele tenha valor
 */
        return ResponseEntity.of(repository.findById(codigo));
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity delete(@PathVariable int codigo) {

        if (repository.existsById(codigo)) {
            repository.deleteById(codigo);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

//    @PutMapping("/{codigo}")
//    public ResponseEntity<Pokemon> put(@PathVariable int codigo,
//                                      @RequestBody @Valid Pokemon pokemon) {
//        // verificando se o codigo existe na base
//        if (!repository.existsById(codigo)) {
//            return ResponseEntity.status(404).build();
//        }
//
//        // substituindo o codigo do JSON pelo da URI
//        pokemon.setCodigo(codigo);
//
//        // save() -> neste caso fez o UPDATE pois estamos passando o id
//        repository.save(pokemon);
//
//        return ResponseEntity.status(200).body(pokemon);
//    }

    @GetMapping("/filtro") // filtro?nome=pikachu
    public ResponseEntity<List<Pokemon>> filtrar(
    @RequestParam String nome
    ) {
        List<Pokemon> lista = repository.findByNomeContains(nome);

        return lista.isEmpty()
                ? ResponseEntity.status(204).build()
                : ResponseEntity.status(200).body(lista);
    }

    @GetMapping("/simples")
    public ResponseEntity<List<PokemonSimplesDTO>> filtrarSimples() {
        List<PokemonSimplesDTO> lista = repository.buscarTodosSoQueSimples();

        return lista.isEmpty()
                ? ResponseEntity.status(204).build()
                : ResponseEntity.status(200).body(lista);
    }

// /filtro-nome-forca?nome=qqq&forca=90.5
    @GetMapping("/filtro-nome-forca")
    public ResponseEntity<List<Pokemon>> filtrarNomeForca(
      @RequestParam String nome, @RequestParam Double forca
    ) {
        List<Pokemon> lista =
                repository.buscarPorNomeForca(nome, forca);

        return lista.isEmpty()
                ? ResponseEntity.status(204).build()
                : ResponseEntity.status(200).body(lista);
    }

    @PatchMapping("/prender/{forcaAbaixoDe}")
    public ResponseEntity<Integer> prender(
        @PathVariable Double forcaAbaixoDe
    ) {
        int presos =
        repository.prenderComForcaAbaixoDe(forcaAbaixoDe);

        return ResponseEntity.status(200).body(presos);
    }

    @GetMapping("/relatorio")
    public ResponseEntity<Map> getRelatorio(){
        Map<String, Object> relatorio = Map.of(
                "quantidadeAquaticos", repository.countAquaticos(),
                "maiorForca", repository.getMaiorForca()
        );
        return ResponseEntity.status(200).body(relatorio);
    }

    @PatchMapping(value = "/foto/{codigo}",
                    consumes = "image/*")
    public ResponseEntity<Void> patchFoto(@PathVariable int codigo, @RequestBody byte[] novaFoto){
        int atualizados = repository.atualizarFoto(novaFoto, codigo);
        int status = atualizados == 1 ? 200 : 400;
        return ResponseEntity.status(status).build();
    }

    @GetMapping(value = "/foto/{codigo}", produces = "image/**")
    public ResponseEntity<byte[]> getFoto(@PathVariable int codigo){
        if (repository.existsById(codigo)){
            return ResponseEntity.status(200).body(repository.getFoto(codigo));
        }
        return ResponseEntity.status(404).build();
    }

    @PatchMapping("/{codigo}/apanhar/{forcaGolpe}")
    public ResponseEntity<Pokemon> apanhar(
            @PathVariable int codigo,
            @PathVariable double forcaGolpe) {
        service.apanhar(codigo, forcaGolpe);
        Pokemon pokemon = repository.findById(codigo).get();
        return ResponseEntity.status(200).body(pokemon);
    }
    @PostMapping("/")
    public ResponseEntity<sptech.dominio.Pokemon> salvar(@RequestBody @Valid Pokemon pokemon){
        return ResponseEntity.status(201).body(service.salvar(pokemon));
    }

    @PutMapping("/{codigo}")
    public Pokemon atualizar(@RequestBody @Valid Pokemon pokemon, @PathVariable int codigo){
        pokemon.setCodigo(codigo);
        return service.salvar(pokemon);
    }
}


