package com.example.libreria.Domain.DTO.create;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBookDTO {

    @NotEmpty
    @NotNull
    @NotBlank
    private String title;

    @NotEmpty
    @NotNull
    @NotBlank
    private String author;

    @NotEmpty
    @NotNull
    @NotBlank
    @Pattern(
            regexp = "^([0-9]{10}|[0-9]{13})$",
            message = "The ISBN format must be valid."
    )
    private String isbn;

    @NotNull
    private Integer publicationYear;

    @Nullable
    private String language;

    @NotNull
    @Min(10)
    private Integer pages;

    @NotNull
    @NotBlank
    @NotEmpty
    private String genre;


}
