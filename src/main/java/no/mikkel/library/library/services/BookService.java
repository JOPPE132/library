package no.mikkel.library.library.services;

import no.mikkel.library.library.models.Book;
import no.mikkel.library.library.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public BookService(){
    }

    public Iterable<Book> getAll(){
        return this.bookRepository.findAll();
    }

    public Optional<Book> findById(int id){
        return this.bookRepository.findById(id);
    }

}
