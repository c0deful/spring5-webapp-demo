package pl.dplewa.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.dplewa.spring5webapp.model.Author;
import pl.dplewa.spring5webapp.model.Book;

/**
 * @author Dominik Plewa
 */
public interface BookRepository extends CrudRepository<Book, Long> {
}
