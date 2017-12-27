package pl.dplewa.spring5.webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.dplewa.spring5.webapp.model.Author;

/**
 * @author Dominik Plewa
 */
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
