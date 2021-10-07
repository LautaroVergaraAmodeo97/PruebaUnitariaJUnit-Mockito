package TutorialJUnit.repositories;

import TutorialJUnit.models.Pais;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisRepositorio extends CrudRepository<Pais, Long> {
    Pais findPaisByCodigo(String codigo);
}
