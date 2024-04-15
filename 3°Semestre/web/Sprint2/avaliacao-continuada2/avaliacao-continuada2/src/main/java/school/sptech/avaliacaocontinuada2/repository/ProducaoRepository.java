package school.sptech.avaliacaocontinuada2.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import school.sptech.avaliacaocontinuada2.entity.Producao;

import java.time.LocalDate;
import java.util.List;

public interface ProducaoRepository extends JpaRepository<Producao, Integer> {

    //1. Buscar producoes por nome do diretor (VALOR EXATO)
    List<Producao> findAllByDiretor(String nome);

    // 2. Buscar producoes por parte do titulo (VALOR APROXIMADO ignorando maiusculas e minusculas)
    List<Producao> findAllByTituloIgnoreCase(String nome);

    //3. Contar todas os producoes de um genero (VALOR EXATO - JQPL)
    Integer countByGenero(String nome);
    //4. Buscar producoes com data de lançamento MAIOR que uma data específica)
    List<Producao> findAllByDataLancamentoAfter(LocalDate data);

    //5. Buscar producoes com data de lançamento MENOR OU IGUAL que uma data específica
    List<Producao> findAllByDataLancamentoLessThanEqual(LocalDate data);

    //6. Buscar producao mais votada (quantidade de avaliacoes)
    Producao findFirstByOrderByNotaImdbDesc();

    //7. Buscar top 3 producoes com maior nota (SOMENTE 3, sendo a primeira a maior)
    List<Producao> findTop3ByOrderByNotaImdbDesc();

    //8. Buscar TOTAL DE AVALIAÇÕES a partir de um gênero (VALOR EXATO - JPQL)
    //DICA: RETORNE UM INTEIRO (Integer)
    @Transactional
    @Query("""
            select sum(p.notaImdb)
            from Producao p
            where p.genero = ?1
            """)
    Integer totalAvaliacaoByGenero(String nome);
}
