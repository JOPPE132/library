package no.mikkel.library.library.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import no.mikkel.library.library.models.Book;
import no.mikkel.library.library.repositories.BookRepository;
import no.mikkel.library.library.services.BookService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("books")
public class BookController {

    @Autowired
    private BookService bookService;

    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @Operation(summary = "Get all books", description = "Returns all books available")
    @GetMapping("(/getAll")
    public ResponseEntity <List<Book>> getBooks() {
        ResponseEntity response;
        Iterable<Book> books = this.bookService.getAll();
        if(!books.iterator().hasNext()){
            response = new ResponseEntity("No books found", HttpStatus.NOT_FOUND);
        }else{
            response = new ResponseEntity("The following books are found: " + books, HttpStatus.FOUND);
        }
        return response;
    }

    @Operation
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@Parameter(name = "id", description = "ID of book to retrieve", required = true) @PathVariable int id){
        ResponseEntity response;
        Optional book = this.bookService.findById(id);
        if(!book.isPresent()) {
            response = new ResponseEntity("No such ID of book is present", HttpStatus.NOT_FOUND);
        }else{
            response = new ResponseEntity<>(book, HttpStatus.FOUND);
        }
        return response;
    }
}
