package com.example.libreria.Controller;


import com.example.libreria.Domain.DTO.create.CreateBookDTO;
import com.example.libreria.Domain.Entity.Book;
import com.example.libreria.Repository.iBookRepository;
import com.example.libreria.Service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.regex.Pattern;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;
    private Pattern UUID_REGEX =
            Pattern.compile("^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$");
    @Autowired
    private iBookRepository iBookRepository;


    @PostMapping("/registerBook")
    public ResponseEntity<Void> createUser(@RequestBody @Valid CreateBookDTO info){
        try {
            bookService.createBook(info);
            return ResponseEntity.ok().build();
        } catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/book/{isbn}")
    public ResponseEntity<CreateBookDTO> findByIsbn(@PathVariable("isbn") String isbn){
        try {
            return ResponseEntity.ok(bookService.findByISBN(isbn));
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }







}
