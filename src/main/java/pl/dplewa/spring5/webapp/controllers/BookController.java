package pl.dplewa.spring5.webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.dplewa.spring5.webapp.repositories.BookRepository;
import pl.dplewa.spring5.webapp.model.Book;

/**
 * @author Dominik Plewa
 */
@Controller
public class BookController {
    // views
    public static final String BOOK_LIST_VIEW = "books";

    // dependencies
    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books")
    public String getBooks(Model model) {
        final Iterable<Book> allBooks = bookRepository.findAll();
        model.addAttribute("books", allBooks);
        return BOOK_LIST_VIEW;
    }
}
