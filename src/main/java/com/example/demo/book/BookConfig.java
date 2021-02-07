package com.example.demo.book;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class BookConfig {

    @Bean
    CommandLineRunner commandLineRunnerBook(BookRepository repository) {
        return args -> {
            Book theLordOfTheRings3 = new Book(
                    "The Return of the King",
                    "J.R.R. Tolkien",
                    LocalDate.of(2000, Month.APRIL, 6));
            Book harryPotter1 = new Book(
                    "Harry pother and the Philosopher's Stone",
                    "J.K. Rowling",
                    LocalDate.of(1997, Month.AUGUST, 20));
            Book harryPotter2 = new Book(
                    "Harry pother and the Chamber of Secrets",
                    "J.K. Rowling",
                    LocalDate.of(1998, Month.JULY, 1));

            repository.saveAll(List.of(theLordOfTheRings3, harryPotter1, harryPotter2));
        };
    }
}
