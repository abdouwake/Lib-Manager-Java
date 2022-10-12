package com.cgi.library.lib.manager.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
public class Book {
    @Id
    private int isbn;
    @NotNull
    private String title;
    private String description;
    @NotNull
    private String author;
    @Past
    @DateTimeFormat(pattern="dd/MM/yyyy")
    private Date creationDate;
    @ManyToOne
    private User createdBy;

    public Book() {}

    public Book(int isbn, String title, String description, String author, Date creationDate,User createdBy) {
        this.isbn = isbn;
        this.title = title;
        this.description = description;
        this.author = author;
        this.creationDate = creationDate;
        this.createdBy = createdBy;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

}
