package com.example.demo.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "api/transaction")
public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public List<Transaction> getTransactions() {
        return transactionService.getTransactions();
    }

    @PostMapping
    public void registerNewTransaction(@RequestBody Transaction transaction) {
        transactionService.addNewTransaction(transaction);
    }

    @DeleteMapping(path = "{transactionId}")
    public void deleteTransaction(@PathVariable("transactionId") Long transactionId) {
        transactionService.deleteTransaction(transactionId);
    }

    @PutMapping(path = "{transactionId}")
    public void updateTransaction(
            @PathVariable("transactionId") Long transactionId,
            @RequestParam(required = false) Long clientId,
            @RequestParam(required = false) Long bookId,
            @RequestParam(required = false) LocalDate startDate) {
        transactionService.updateTransaction(transactionId, clientId, bookId, startDate);
    }

}
