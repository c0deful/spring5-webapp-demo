package pl.dplewa.spring5webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.dplewa.spring5webapp.model.Author;
import pl.dplewa.spring5webapp.repositories.AuthorRepository;

/**
 * @author Dominik Plewa
 */
@Controller
public class AuthorController {
    // views
    public static final String AUTHOR_LIST_VIEW = "authors";

    // dependencies
    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @RequestMapping("/authors")
    public String getBooks(Model model) {
        final Iterable<Author> allAuthors = authorRepository.findAll();
        model.addAttribute("authors", allAuthors);
        return AUTHOR_LIST_VIEW;
    }
}
