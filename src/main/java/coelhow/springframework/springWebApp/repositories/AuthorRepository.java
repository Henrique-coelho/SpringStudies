package coelhow.springframework.springWebApp.repositories;

import coelhow.springframework.springWebApp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
