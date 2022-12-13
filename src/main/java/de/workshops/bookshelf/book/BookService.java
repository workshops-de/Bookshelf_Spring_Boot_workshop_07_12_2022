package de.workshops.bookshelf.book;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookService {

    private final BookRepository bookRepository;

    public List<Book> getBooks() {
        return bookRepository.getBooks();
    }

    public Book getSingleBook(String isbn) throws BookNotFoundException {
        return getBooks().stream().filter(book -> hasIsbn(book, isbn)).findFirst().orElseThrow(BookNotFoundException::new);
    }

    public Book searchBookByAuthor(String author) throws BookNotFoundException {
        return getBooks().stream().filter(book -> hasAuthor(book, author)).findFirst().orElseThrow(BookNotFoundException::new);
    }

    public List<Book> searchBooks(BookSearchRequest request) {
        return getBooks().stream()
                .filter(book -> hasAuthor(book, request.author()))
                .filter(book -> hasIsbn(book, request.isbn()))
                .toList();
    }

    private boolean hasIsbn(Book book, String isbn) {
        return book.getIsbn().equals(isbn);
    }

    private boolean hasAuthor(Book book, String author) {
        return book.getAuthor().contains(author);
    }

    public Book createBook(Book book) {
        bookRepository.createBook(book);

        return book;
    }
}
