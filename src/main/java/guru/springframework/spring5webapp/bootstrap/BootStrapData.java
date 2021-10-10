package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.AddressPublisher;
import guru.springframework.spring5webapp.domain.AuthorEntity;
import guru.springframework.spring5webapp.domain.BookEntity;
import guru.springframework.spring5webapp.domain.PublisherEntity;
import guru.springframework.spring5webapp.repository.AuthorRepository;
import guru.springframework.spring5webapp.repository.BookRepository;
import guru.springframework.spring5webapp.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        AuthorEntity eric = new AuthorEntity("Eric", "Evans");
        BookEntity ddd = new BookEntity("Domain Driven Design", "123123");

        eric.books.add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        AuthorEntity rod = new AuthorEntity("Rod", "Johnson");
        BookEntity notEJB = new BookEntity("J2EE", "234567456456465");

        rod.books.add(notEJB);
        ddd.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(notEJB);

        System.out.println(bookRepository.count());

        PublisherEntity publisherEntity = new PublisherEntity("Publisher", new AddressPublisher("14 Road", "London", "London", "12311we"));

        publisherRepository.save(publisherEntity);

        System.out.println(publisherRepository.count());

    }
}
