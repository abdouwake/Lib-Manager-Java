package com.cgi.library.lib.manager.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Future;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
public class Reservation {
    @Id
    @GeneratedValue
    private int idReservation;
    @ManyToOne
    private User user;
    @ManyToOne
    private Book book;
    @Future
    @DateTimeFormat(pattern="dd/MM/yyyy")
    private Date dateFrom;
    @Future
    @DateTimeFormat(pattern="dd/MM/yyyy")
    private Date dateTo;

    public Reservation(){}

    public Reservation(int idReservation, User user, Book book, Date dateFrom, Date dateTo) {
        this.idReservation = idReservation;
        this.user = user;
        this.book = book;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    public int getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }
}
