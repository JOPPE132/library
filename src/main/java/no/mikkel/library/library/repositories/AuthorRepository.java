package no.mikkel.library.library.repositories;

import no.mikkel.library.library.models.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Integer> {
}
