package coelhow.springframework.springWebApp.repositories;

import coelhow.springframework.springWebApp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
