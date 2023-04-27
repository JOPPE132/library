package no.mikkel.library.library.services;

import no.mikkel.library.library.models.Book;
import no.mikkel.library.library.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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

    public Iterable<Book> getRandomBooks() {
        Iterable<Book> allBooks = bookRepository.findAll(); // assuming bookRepository is your JPA repository for books
        List<Book> randomBooks = new ArrayList<>();

        // Convert the iterable to a list
        List<Book> bookList = new ArrayList<>();
        allBooks.forEach(bookList::add);

        if (bookList.size() < 2) {
            // If there are fewer than two books, return all books
            return bookList;
        }

        // Generate two distinct random indices
        int index1 = (int) (Math.random() * bookList.size());
        int index2 = index1;
        while (index2 == index1) {
            index2 = (int) (Math.random() * bookList.size());
        }

        // Get the books at the random indices
        Book book1 = bookList.get(index1);
        Book book2 = bookList.get(index2);

        // Add the books to the list
        randomBooks.add(book1);
        randomBooks.add(book2);

        return randomBooks;
    }




}
