package pl.dplewa.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.dplewa.spring5webapp.model.Publisher;

/**
 * @author Dominik Plewa
 */
public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
