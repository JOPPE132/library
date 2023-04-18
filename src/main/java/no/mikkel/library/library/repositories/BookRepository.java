package no.mikkel.library.library.repositories;

import no.mikkel.library.library.models.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> {
}
