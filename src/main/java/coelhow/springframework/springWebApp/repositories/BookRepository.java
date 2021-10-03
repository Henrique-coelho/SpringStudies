package coelhow.springframework.springWebApp.repositories;

import coelhow.springframework.springWebApp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
