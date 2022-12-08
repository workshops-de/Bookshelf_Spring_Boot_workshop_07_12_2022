package de.workshops.bookshelf.book;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

record BookSearchRequest (@NotBlank @Size(min = 10, max = 15) String isbn, @NotBlank @Size(min = 3) String author) {
}
