package guru.springframework.spring5webapp.controller;

import guru.springframework.spring5webapp.repository.AuthorRepository;
import guru.springframework.spring5webapp.repository.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookController {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookController(BookRepository bookRepository,
                          AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @GetMapping("/books")
    public String book(Model model) {

        model.addAttribute("books", bookRepository.findAll());//model -> view

        return "books";
    }

    @GetMapping("/authors")
    public String authors(Model model){

        model.addAttribute("authors", authorRepository.findAll());

        return "author/authors";
    }

    @GetMapping("/authorById")
    public String authorByName(@RequestParam int id, Model model){
        String fullName = authorRepository.findById(id).get().getFirstName() + " " + authorRepository.findById(1).get().getLastName();

        model.addAttribute("author", fullName);

        return "author";
    }
}
