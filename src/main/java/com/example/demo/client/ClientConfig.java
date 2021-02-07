package com.example.demo.client;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class ClientConfig {

    @Bean
    CommandLineRunner commandLineRunnerClient(ClientRepository repository) {
        return args -> {
            Client mariam = new Client("Mariam",
                    "mariam.jamal@gmail.com",
                    LocalDate.of(2000, Month.JANUARY, 5));
            Client alex = new Client("Alex",
                    "alex@gmail.com",
                    LocalDate.of(2004, Month.JANUARY, 5));

            repository.saveAll(List.of(mariam, alex));
        };
    }
}
