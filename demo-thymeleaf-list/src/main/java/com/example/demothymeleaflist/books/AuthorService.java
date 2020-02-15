package com.example.demothymeleaflist.books;

import com.example.demothymeleaflist.model.Author;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class AuthorService {
    private AuthorRepository authorRepository;

    public Author getOne(long id) {
        return authorRepository.getOne(id);
    }

    public void save(Author author) {
        authorRepository.save(author);
    }
}
