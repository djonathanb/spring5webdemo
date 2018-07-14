package guru.springframework.spring5webdemo.bootstrap;

import guru.springframework.spring5webdemo.model.Author;
import guru.springframework.spring5webdemo.model.Book;
import guru.springframework.spring5webdemo.model.Publisher;
import guru.springframework.spring5webdemo.repositories.AuthorRepository;
import guru.springframework.spring5webdemo.repositories.BookRepository;
import guru.springframework.spring5webdemo.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private PublisherRepository publisherRepository;
    private BookRepository bookRepository;

    public DevBootstrap(AuthorRepository authorRepository, PublisherRepository publisherRepository,
                        BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    void initData() {
        Author ericEvans = new Author("Eric", "Evans");
        Publisher addisonWesley = new Publisher("Addison-Wesley Professional", "Boston, Massachusetts, USA");
        Book ddd = new Book("Domain Driven Design", "123589", addisonWesley, Set.of(ericEvans));
        ericEvans.addBook(ddd);

        authorRepository.save(ericEvans);
        publisherRepository.save(addisonWesley);
        bookRepository.save(ddd);

        Author craigWalls = new Author("Craig", "Walls");
        Publisher manning = new Publisher("Mannig", "Shelter Island, New York, USA");;
        Book springInAction = new Book("Spring in Action", "986532", manning, Set.of(craigWalls));
        craigWalls.addBook(springInAction);

        authorRepository.save(craigWalls);
        publisherRepository.save(manning);
        bookRepository.save(springInAction);
    }
}
