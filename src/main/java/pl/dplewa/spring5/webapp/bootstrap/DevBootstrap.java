package pl.dplewa.spring5.webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pl.dplewa.spring5.webapp.model.Book;
import pl.dplewa.spring5.webapp.repositories.AuthorRepository;
import pl.dplewa.spring5.webapp.repositories.BookRepository;
import pl.dplewa.spring5.webapp.model.Author;
import pl.dplewa.spring5.webapp.model.Publisher;
import pl.dplewa.spring5.webapp.repositories.PublisherRepository;

import java.util.Arrays;
import java.util.Collections;

/**
 * This component initializes test data for development environments.
 *
 * @author Dominik Plewa
 */
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository,
                        BookRepository bookRepository,
                        PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        final Author terryPratchett = new Author("Terry", "Pratchett");
        final Publisher corgi = new Publisher("Corgi");
        final Book theFifthElephant = new Book("The Fifth Elephant", "0552167622", corgi,
                Collections.singleton(terryPratchett));

        final Author neilGaiman = new Author("Neil", "Gaiman");
        final Publisher headline = new Publisher("Headline");
        final Book americanGods = new Book("American Gods", "1472245547", headline,
                Collections.singleton(neilGaiman));

        authorRepository.saveAll(Arrays.asList(terryPratchett, neilGaiman));
        publisherRepository.saveAll(Arrays.asList(corgi, headline));
        bookRepository.saveAll(Arrays.asList(theFifthElephant, americanGods));
    }
}
