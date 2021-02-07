package com.example.demo.book;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Book {
    @Id
    @SequenceGenerator(
            name = "book_sequence",
            sequenceName = "book_sequence",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "book_sequence"
    )

    private Long id;
    private String title;
    private String author;
    private LocalDate releaseDate;
//    TODO add rented out to feature
//    private Long rentedOutTo;

    public Book() {
    }

    public Book(Long id,
                String title,
                String author,
                LocalDate releaseDate) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.releaseDate = releaseDate;
    }

    public Book(String title,
                String author,
                LocalDate releaseDate) {
        this.title = title;
        this.author = author;
        this.releaseDate = releaseDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title ='" + title + '\'' +
                ", author ='" + author + '\'' +
                ", release date =" + releaseDate +
//                ", rented our to =" + rentedOutTo +
                '}';
    }
}
