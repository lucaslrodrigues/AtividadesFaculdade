package sptech.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import sptech.dominio.Pokemon;
import sptech.dto.PokemonSimplesDTO;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/*
A interface JpaRepository possui os principais métodos de acesso a banco
(gravação, recuperação, exclusão etc)

Dentro do <>,
o 1o valor é a classe da Entidade
o 2o valor é a classe do Id (como na entidade é int, aquii usamos Integer porque tem que ser classe)
 */
public interface PokemonRepository
                    extends JpaRepository<Pokemon, Integer> {

    /*
    Usando operações com Dynamic Finders
     */

    // select * from pokemon where nome = ?
    List<Pokemon> findByNome(String nome);

    // select * from pokemon where nome like ?
    // não pecisa enviar '%' no argumento! :)
    List<Pokemon> findByNomeContains(String nome);

/*
@Query -> Cria uma consulta com JPQL ( por padrão e preferencialmente) ou SQL nativo
No JPQL as instruções SQL são as mesmas (select, insert, delete, where, order etc)
Já quando mencionamos as Entidades e aseus atributos usamos os nomes do código Java

Neste exemplo, usamos o construtor da classe PokemonSimplesDTO
Sempre temos que usar o caminho completo da classe para isso

OBS: quando usamos @Query, não somos obrigados a seguir o padrão de nomes dos dynamic finder
 */
    @Query("""
    select new sptech.dto.PokemonSimplesDTO(p.codigo, p.nome) 
    from Pokemon p        
    """)
    List<PokemonSimplesDTO> buscarTodosSoQueSimples();

/*
Quando usamos parâmetros posicionais, eles começam do 1
?1 ?2 ?3...
NÃO COMEÇA DO 0
 */
    @Query("""
    select p from Pokemon p 
    where p.nome = ?1 and p.forca >= ?2            
    """)
    List<Pokemon> buscarPorNomeForca(String nome, Double forca);

/*
Se for insert, update ou delete, temos que adicionar
as anotações @Modifying e @Transactional
 */
    @Modifying
    @Transactional
    @Query("""
    update Pokemon p set p.livre = false 
    where p.forca < ?1            
    """)
    int prenderComForcaAbaixoDe(Double forca);

    @Query("""
    select count(p) from Pokemon p
    where p.tipo.nome = 'aquatico'
            """)
    long countAquaticos();

    @Query("""
            select coalesce(max(p.forca),0) from Pokemon p
            """)
    Double getMaiorForca();

    @Modifying
    @Transactional
    @Query("""
            update Pokemon p set p.foto = ?1
            where p.codigo = ?2
            """)
    int atualizarFoto(byte[] foto, int codigo);

    @Modifying
    @Transactional
    @Query("""
            update Pokemon p set p.relatorioCSV = ?1
            where p.codigo = ?2
            """)
    int atualizarRelatorio(byte[] Relatorio, int codigo);

    @Query("""
            select p.foto from Pokemon p
            where p.codigo = ?1
            """)
    byte[] getFoto(int codigo);

    @Query("""
            select p.relatorioCSV from Pokemon p
            where p.codigo = ?1
            """)
    byte[] getRelatorio(int codigo);

    Optional<Pokemon> findById(int codigo);

    @Query("""
            select count(l)
            from Luta l
            where l.pokemon1.codigo = ?1 or l.pokemon2 = ?1
            """)
    int countByLutas(int codigo);

    @Query("""
            select count(l)
            from Luta l
            where l.vencedor.codigo = ?1
            """)
    int countByVitorias(int codigo);
//    @Query("""
//            select count(p.lutasComoPokemon2)
//            from Pokemon p
//            where p.codigo = ?1
//            """)
//    int countByLutasComoPokemon2(int codigo);
}
