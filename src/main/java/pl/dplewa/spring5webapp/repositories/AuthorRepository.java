package pl.dplewa.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.dplewa.spring5webapp.model.Author;

/**
 * @author Dominik Plewa
 */
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
