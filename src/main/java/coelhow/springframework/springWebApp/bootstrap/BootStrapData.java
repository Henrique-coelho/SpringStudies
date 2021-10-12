package coelhow.springframework.springWebApp.bootstrap;

import coelhow.springframework.springWebApp.domain.Author;
import coelhow.springframework.springWebApp.domain.Book;
import coelhow.springframework.springWebApp.domain.Publisher;
import coelhow.springframework.springWebApp.repositories.AuthorRepository;
import coelhow.springframework.springWebApp.repositories.BookRepository;
import coelhow.springframework.springWebApp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,
                         PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Started in Bootstrap");

        Publisher publisher = new Publisher();
        publisher.setName("HCM Publishing");
        publisher.setCity("Belo Horizonte");
        publisher.setState("Minas Gerais");

        publisherRepository.save(publisher);

        Author coelhow = new Author("Coelho", "Mendes");
        Book hp = new Book("Lovecraft not Potter", "123123");
        coelhow.getBooks().add(hp);
        hp.getAuthors().add(coelhow);
        hp.setPublisher(publisher);

        publisher.getBooks().add(hp);

        authorRepository.save(coelhow);
        bookRepository.save(hp);
        publisherRepository.save(publisher);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "456456");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        noEJB.setPublisher(publisher);

        publisher.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: "+bookRepository.count());
        System.out.println("Publisher number of books: "+publisher.getBooks().size());
    }
}
