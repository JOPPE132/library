package no.mikkel.library.library.controllers;

import no.mikkel.library.library.services.AuthorService;
import no.mikkel.library.library.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public String getIndex(Model model){
        model.addAttribute("featuredBooks", this.bookService.getAll());
        return "index";
    }

    @GetMapping("/books")
    public String getBooks(Model model){
//        model.addAttribute("books", this.bookService.getAll());
        return "books";
    }



}
