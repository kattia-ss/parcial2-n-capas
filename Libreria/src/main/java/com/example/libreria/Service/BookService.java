package com.example.libreria.Service;

import com.example.libreria.Domain.DTO.create.CreateBookDTO;
import com.example.libreria.Domain.Entity.Book;
import com.example.libreria.Repository.iBookRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
@NoArgsConstructor
public class BookService {

    @Autowired
    private iBookRepository bookRepository;

    public void createBook(CreateBookDTO bookinfo){
        Book book = new Book();
        book.setTitle(bookinfo.getTitle());
        book.setAuthor(bookinfo.getAuthor());
        book.setIsbn(bookinfo.getIsbn());
        book.setPublicationYear(bookinfo.getPublicationYear());
        book.setLanguage(bookinfo.getLanguage());
        book.setPages(bookinfo.getPages());
        book.setGenre(bookinfo.getGenre());
        bookRepository.save(book);
    }

    public CreateBookDTO findByISBN(String isbn){
        Optional<Book> optionalBook = bookRepository.findByIsbn(isbn);
        if (optionalBook.isEmpty()){
            throw new RuntimeException("User not found");
        }
        return  new CreateBookDTO(optionalBook.get().getTitle(), optionalBook.get().getAuthor(),
                optionalBook.get().getIsbn(), optionalBook.get().getPublicationYear(),
                optionalBook.get().getLanguage(), optionalBook.get().getPages(),
                optionalBook.get().getGenre());
    }




}
