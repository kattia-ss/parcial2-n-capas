package com.example.libreria.Repository;


import com.example.libreria.Domain.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface iBookRepository  extends JpaRepository<Book, UUID> {

    public Optional<Book> findByIsbn(String isbn);

}
