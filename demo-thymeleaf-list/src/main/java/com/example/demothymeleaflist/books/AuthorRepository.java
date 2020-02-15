package com.example.demothymeleaflist.books;

import com.example.demothymeleaflist.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
