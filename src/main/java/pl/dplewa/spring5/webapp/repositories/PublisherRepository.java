package pl.dplewa.spring5.webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.dplewa.spring5.webapp.model.Publisher;

/**
 * @author Dominik Plewa
 */
public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
