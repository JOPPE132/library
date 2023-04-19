package no.mikkel.library.library.controllers;

import no.mikkel.library.library.models.Author;
import no.mikkel.library.library.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;



}
