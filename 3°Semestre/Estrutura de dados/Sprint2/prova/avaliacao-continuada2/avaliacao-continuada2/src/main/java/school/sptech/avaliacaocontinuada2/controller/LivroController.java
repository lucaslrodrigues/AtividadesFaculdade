package school.sptech.avaliacaocontinuada2.controller;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.DefaultKafkaProducerFactoryCustomizer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import school.sptech.avaliacaocontinuada2.entity.Producao;
import school.sptech.avaliacaocontinuada2.repository.ProducaoRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/producoes")
public class LivroController {
    @Autowired
    ProducaoRepository producaoRepository;

    @GetMapping
    public ResponseEntity<List<Producao>> listagem() {
        List<Producao> producao = producaoRepository.findAll();
        return producao.isEmpty() ? ResponseEntity.status(204).build() : ResponseEntity.status(200).body(producao);
    }

    //1.
    @GetMapping("/diretor")
    public ResponseEntity<List<Producao>> listagemAutor(@RequestParam String nome) {
        List<Producao> lista = producaoRepository.findAllByDiretor(nome);
        return lista.isEmpty() ? ResponseEntity.status(404).build() : ResponseEntity.status(200).body(lista);
    }

    //2.
    @GetMapping("/titulo")
    public ResponseEntity<List<Producao>> listagemTitulo(@RequestParam String nome) {
        List<Producao> lista = producaoRepository.findAllByTituloIgnoreCase(nome);
        return lista.isEmpty() ? ResponseEntity.status(404).build() : ResponseEntity.status(200).body(lista);
    }

    //3.
    @GetMapping("/genero")
    public ResponseEntity<Integer> listagemEditora(@RequestParam String nome) {
        Integer quantidade = producaoRepository.countByGenero(nome);
        return quantidade != 0 ? ResponseEntity.status(200).body(quantidade) : ResponseEntity.status(404).build();
    }

    //4.
    @GetMapping("/recentes")
    public ResponseEntity<List<Producao>> listagemRecentes(@RequestParam LocalDate data) {
       List<Producao> lista = producaoRepository.findAllByDataLancamentoAfter(data);
       return lista.isEmpty() ? ResponseEntity.status(404).build() : ResponseEntity.status(200).body(lista);
    }

    //5.
    @GetMapping("/antigos")
    public ResponseEntity<List<Producao>> listagemAntigos(@RequestParam LocalDate data) {
        List<Producao> lista = producaoRepository.findAllByDataLancamentoLessThanEqual(data);
        return lista.isEmpty() ? ResponseEntity.status(404).build() : ResponseEntity.status(200).body(lista);
    }

    //6.
    @GetMapping("/notas/mais-votado")
    public ResponseEntity<Producao> buscarMaisVotado() {
        Producao prod = producaoRepository.findFirstByOrderByNotaImdbDesc();
        return prod == null ? ResponseEntity.status(204).build() : ResponseEntity.status(200).body(prod);
    }

    //7.
    @GetMapping("/notas/top3")
    public ResponseEntity<List<Producao>> listagemMaisBaratos() {
        List<Producao> lista = producaoRepository.findTop3ByOrderByNotaImdbDesc();
        return lista.isEmpty() ? ResponseEntity.status(204).build() : ResponseEntity.status(200).body(lista);
    }

    //8.
    @GetMapping("/quantidade-total-avaliacoes/genero")
    public ResponseEntity<Integer> listagemValorTotal(@RequestParam String nome) {
        Integer total = producaoRepository.totalAvaliacaoByGenero(nome);
        return total > 0 ? ResponseEntity.status(200).body(total) : ResponseEntity.status(404).build();
    }
}
