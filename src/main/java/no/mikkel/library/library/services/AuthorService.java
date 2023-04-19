package no.mikkel.library.library.services;

import no.mikkel.library.library.models.Author;
import no.mikkel.library.library.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public AuthorService(){
    }

    public Iterable<Author> getAll(){
        return this.authorRepository.findAll();
    }

}
