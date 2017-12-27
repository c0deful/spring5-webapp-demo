package pl.dplewa.spring5.webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.dplewa.spring5.webapp.model.Book;

/**
 * @author Dominik Plewa
 */
public interface BookRepository extends CrudRepository<Book, Long> {
}
