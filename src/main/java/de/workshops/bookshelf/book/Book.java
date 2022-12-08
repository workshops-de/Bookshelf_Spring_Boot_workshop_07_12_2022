package de.workshops.bookshelf.book;

import lombok.Data;

import javax.validation.constraints.Size;

@Data
public class Book {

    @Size(min = 10)
    private String title;
    private String description;
    private String author;
    private String isbn;
}
