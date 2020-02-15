package com.example.demothymeleaflist.books;

import com.example.demothymeleaflist.model.Author;
import com.example.demothymeleaflist.model.Book;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@AllArgsConstructor
@Controller
public class AuthorController {
    private AuthorService authorService;

    @GetMapping({"/", "/author"})
    public String showAll(Model model) {
        model.addAttribute("author", authorService.getOne(1));

        return "author";
    }

    @GetMapping("/addBooks")
    public String showCreateForm(Model model) {
        Author author = authorService.getOne(1);

        List<Book> books = List.of(new Book(), new Book(), new Book());
        author.setBooks(books);

        model.addAttribute("author", author);
        return "addBooks";
    }

    @PostMapping("/addBooks")
    public String addBooks(@ModelAttribute Author author, Model model) {
        author.getBooks().forEach(book -> book.setAuthor(author));
        authorService.save(author);

        return "redirect:/";
    }
}
