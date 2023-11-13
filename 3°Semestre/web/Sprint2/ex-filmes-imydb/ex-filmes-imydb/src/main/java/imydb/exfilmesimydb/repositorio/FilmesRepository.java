package imydb.exfilmesimydb.repositorio;

import imydb.exfilmesimydb.modelo.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmesRepository extends JpaRepository<Filme, Integer> {

}
