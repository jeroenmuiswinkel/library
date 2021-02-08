package com.example.demo.transaction;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class TransactionConfig {

    @Bean
    CommandLineRunner commandLineRunnerTransaction(TransactionRepository repository) {
        return args -> {
            Transaction mariamBorrowsLOTR3 = new Transaction(1L, 1L, LocalDate.now());
            Transaction alexBorrowsHP1 = new Transaction(2L, 2L, LocalDate.now());

            repository.saveAll(List.of(mariamBorrowsLOTR3, alexBorrowsHP1));
        };
    }
}
