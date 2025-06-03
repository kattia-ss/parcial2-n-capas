package com.example.libreria.Domain.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column
    private String title;

    @Column
    private String author;

    @Column(unique = true)
    private String isbn;

    @Column
    private Integer publicationYear;

    @Column
    private String language;

    @Column(nullable = true)
    private Integer pages;

    @Column
    private String genre;


}