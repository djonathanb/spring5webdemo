package guru.springframework.spring5webdemo.repositories;

import guru.springframework.spring5webdemo.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
