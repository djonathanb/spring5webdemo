package guru.springframework.spring5webdemo.repositories;

import guru.springframework.spring5webdemo.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
