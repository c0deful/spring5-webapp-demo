package pl.dplewa.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pl.dplewa.spring5webapp.model.Author;
import pl.dplewa.spring5webapp.model.Book;
import pl.dplewa.spring5webapp.repositories.AuthorRepository;
import pl.dplewa.spring5webapp.repositories.BookRepository;

/**
 * This component initializes test data for development environments.
 *
 * @author Dominik Plewa
 */
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        Author terryPratchett = new Author("Terry", "Pratchett");
        Book theFifthElephant = new Book("The Fifth Elephant", "0552167622", "Corgi");
        terryPratchett.getBooks().add(theFifthElephant);
        theFifthElephant.getAuthors().add(terryPratchett);

        authorRepository.save(terryPratchett);
        bookRepository.save(theFifthElephant);

        Author neilGaiman = new Author("Neil", "Gaiman");
        Book americanGods = new Book("American Gods", "1472245547", "Headline");
        neilGaiman.getBooks().add(americanGods);
        americanGods.getAuthors().add(neilGaiman);

        authorRepository.save(neilGaiman);
        bookRepository.save(americanGods);
    }
}
