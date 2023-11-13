package sptech.servico;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import sptech.dominio.Pokemon;
import sptech.dominio.TipoPokemon;
import sptech.repositorio.PokemonRepository;
import sptech.repositorio.TipoPokemonRepository;

/*
Uma service abriga regras de negócio
IMPORTANTE: Por padrão uma Service é SINGLETON
Ou seja, só existe 1 (uma) instância dela na aplicação

SQRS é um padrão em que existem duas Services
Uma para consulta e outra que precisam de autenticação e inserções que são mais demorados
*/
@Service
public class PokemonService {

    private PokemonRepository repository;
    private TipoPokemonRepository tipoPokemonRepository;


    public PokemonService(PokemonRepository repository, TipoPokemonRepository tipoPokemonRepository) {
        this.repository = repository;
        this.tipoPokemonRepository = tipoPokemonRepository;
    }

    public void apanhar(int codigo, double forcaGolpe){
        validarForcaGolpe(forcaGolpe);
        if (!repository.existsById(codigo)) {
            // É o mesmo que:
            // return ResponseEntity.status(404).build();
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        Pokemon pokemon = repository.findById(codigo).get();
        pokemon.setForca(getForcaAposGolpe(pokemon.getForca(), forcaGolpe));
        repository.save(pokemon);

    }

    protected void validarForcaGolpe(double forcaGolpe) {
        if (forcaGolpe < 0.0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "A força do golpe deve ser 0 ou mais");
        }
    }

    protected double getForcaAposGolpe(double forca, double golpe) {
        if (golpe < 0.0) {
            throw new IllegalArgumentException("Golpe deve ser >= 0");
        }
        if (forca < 0.0) {
            throw new IllegalArgumentException("Força deve ser >= 0");
        }
        if (golpe > forca) {
            return 0.0;
        }
        return forca - golpe;
    }

    public Pokemon salvar(Pokemon pokemon){
//        int cod = pokemon.getCodigo();
//        if (cod != 0) {
//            if (!repository.existsById(cod)) {
//                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Codigo de pokemon %s não encontrado".formatted(cod));
//            }
//        }
//        int codTipo = pokemon.getTipo().getCodigo();
//        if (!tipoPokemonRepository.existsById(codTipo)) {
//            if (!repository.existsById(pokemon.getCodigo())) {
//                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Codigo de tipo de pokemon %s não encontrado".formatted(pokemon.getTipo().getCodigo()));
//            }
//        }
//        if (!(pokemon.getTipo().getForcaMaxima() <= pokemon.getForca())) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
//        }
//        return repository.save(pokemon);
        int codigo = pokemon.getCodigo();
        if (codigo != 0) { // se não for 0 significa que é uma atualização
            if (!repository.existsById(codigo)) {
                throw new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "código de pokemon %d não encontrado".formatted(codigo)
                );
            }
        }

        int codigoTipo = pokemon.getTipo().getCodigo();
        if (!tipoPokemonRepository.existsById(codigoTipo)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "código de tipo de pokemon %d não encontrado".formatted(codigoTipo)
            );
        }

        // recuperando o tipo de pokemon do banco
        TipoPokemon tipo =
                tipoPokemonRepository.findById(codigoTipo).get();
        double forcaMaxima = tipo.getForcaMaxima();

        if (pokemon.getForca() > forcaMaxima) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, // status 400
                    "a força desse pokemon deveria ser no máximo %.2f".formatted(forcaMaxima)
            );
        }

        // ao usarmos o retorno do save
        // com certeza teremos codigo preenchido em caso de insert
        return repository.save(pokemon);
    }
}
