package io.data.ltbook.repo;


import io.data.ltbook.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepo extends JpaRepository<Book, Long> {
    List<Book> findByType (String type);
    List<Book> findByName (String name);
}
