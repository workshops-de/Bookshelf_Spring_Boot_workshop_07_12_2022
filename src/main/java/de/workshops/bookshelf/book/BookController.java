package de.workshops.bookshelf.book;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping
    public String getAllBooks(Model model) {
        model.addAttribute("books", bookService.getBooks());

        return "books";
    }

    @GetMapping("/{isbn}")
    public String getSingleBooks(
            @PathVariable @NotBlank @Size(min = 10, max = 15) String isbn,
            Model model
    ) throws BookNotFoundException {
        model.addAttribute("book", bookService.getSingleBook(isbn));

        return "singleBook";
    }
}
