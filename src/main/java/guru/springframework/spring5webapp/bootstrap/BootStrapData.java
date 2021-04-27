package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRespository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRespository bookRespository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRespository bookRespository, PublisherRepository publisherRespository) {
        this.authorRepository = authorRepository;
        this.bookRespository = bookRespository;
        this.publisherRepository = publisherRespository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started in Bootstrap");

        Publisher publisher = new Publisher();
        publisher.setName("SFG Publishing");
        publisher.setCity("St Petersburg");
        publisher.setState("FL");

        publisherRepository.save(publisher);

        System.out.println("Publisher Count: " + publisherRepository.count());
        Author alex = new Author("Alex","Sales");
        Book ddd = new Book("Domain Driven Design","123123");
        alex.getBooks().add(ddd);
        ddd.getAuthors().add(alex);

        authorRepository.save(alex);
        bookRespository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB","1231564561");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRespository.save(noEJB);

        System.out.println("Number of books: " + bookRespository.count());
        System.out.println("Number of Authors: " + authorRepository.count());
    }
}
