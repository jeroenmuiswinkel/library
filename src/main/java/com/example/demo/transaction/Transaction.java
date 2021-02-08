package com.example.demo.transaction;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Transaction {
    @Id
    @SequenceGenerator(
            name = "transaction_sequence",
            sequenceName = "transaction_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "transaction_sequence"
    )
    private Long transactionId;
    private Long clientId;
    private Long bookId;
    private LocalDate startDate;
    @Transient
    private LocalDate scheduledReturnDate;

    public Transaction() {
    }

    public Transaction(Long transactionId,
                       Long clientId,
                       Long bookId,
                       LocalDate startDate) {
        this.transactionId = transactionId;
        this.clientId = clientId;
        this.bookId = bookId;
        this.startDate = startDate;
    }

    public Transaction(Long clientId,
                       Long bookId,
                       LocalDate startDate) {
        this.clientId = clientId;
        this.bookId = bookId;
        this.startDate = startDate;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getScheduledReturnDate() {
        return this.startDate.plusDays(14);
    }

    public void setScheduledReturnDate(LocalDate scheduledReturnDate) {
        this.scheduledReturnDate = scheduledReturnDate;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transaction id=" + transactionId +
                ", client id='" + clientId + '\'' +
                ", book id='" + bookId + '\'' +
                ", start date=" + startDate +
                ", scheduled return date=" + scheduledReturnDate +
                '}';
    }

}
