package com.example.demothymeleaflist;

import com.example.demothymeleaflist.books.AuthorRepository;
import com.example.demothymeleaflist.model.Author;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoThymeleafListApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoThymeleafListApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(AuthorRepository authorRepository) {
        return (args) -> {
            Author author = new Author();
            author.setName("author1");
            authorRepository.save(author);
        };
    }
}
