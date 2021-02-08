package com.example.demo.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> getTransactions() {
        return transactionRepository.findAll();
    }

    public void addNewTransaction(Transaction transaction) {
//        TODO: Add logic such that a book is not lended out twice at the same time.

        if (transaction.getStartDate() == null) {
            transaction.setStartDate(LocalDate.now());
        }
        transactionRepository.save(transaction);
    }

    public void deleteTransaction(Long transactionId) {
        boolean exists = transactionRepository.existsById(transactionId);
        if (!exists) {
            throw new IllegalStateException("Transaction with id " + transactionId + " does not exist.");
        }
        transactionRepository.deleteById(transactionId);
    }

    public void updateTransaction(Long transactionId,
                                  Long clientId,
                                  Long bookId,
                                  LocalDate startDate) {
        Transaction transaction = transactionRepository.findById(transactionId)
                .orElseThrow(() -> new IllegalStateException(
                        "Transaction with id " + transactionId + " does not exist."));

//        TODO: Include clientRepository and bookRepository in this module
//        boolean clientExists = clientRepository.existsById(clientId);
//        if (!clientExists) {
//            throw new IllegalStateException("Client with id " + clientId + " does not exist.");
//        }
//        if (!bookExists) {
//            throw new IllegalStateException("Book with id " + bookId + " does not exist.");
//        }
//        boolean bookExists = bookRepository.existsById(bookId);

//        TODO: Check if book bot already rented out at this point.
//        TODO: Check if client has not already lend the max of 2 books.
//        TODO: Check if startDate is a proper date format.

//        TODO: Update if attribute filled in...
    }

}
