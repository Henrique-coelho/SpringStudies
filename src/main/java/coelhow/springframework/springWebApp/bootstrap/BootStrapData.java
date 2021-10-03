package coelhow.springframework.springWebApp.bootstrap;

import coelhow.springframework.springWebApp.domain.Author;
import coelhow.springframework.springWebApp.domain.Book;
import coelhow.springframework.springWebApp.repositories.AuthorRepository;
import coelhow.springframework.springWebApp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author coelhow = new Author("Coelho", "Mendes");
        Book hp = new Book("Lovecraft not Potter", "123123");
        coelhow.getBooks().add(hp);
        hp.getAuthors().add(coelhow);

        authorRepository.save(coelhow);
        bookRepository.save(hp);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "456456");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: "+bookRepository.count());
    }
}
