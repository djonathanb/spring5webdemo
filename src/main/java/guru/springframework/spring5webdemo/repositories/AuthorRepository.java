package guru.springframework.spring5webdemo.repositories;

import guru.springframework.spring5webdemo.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
