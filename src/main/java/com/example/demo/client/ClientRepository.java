package com.example.demo.client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository
        extends JpaRepository<Client, Long> {

    @Query("SELECT c from Client c WHERE c.email = ?1")
    Optional<Client> findClientByEmail(String email);

}
