package com.cgi.library.lib.manager.Model.ContextObjects;

import java.util.Date;

public class ReservationProps {
    private int isbn;
    private Date datefrom;
    private Date dateTo;

    public ReservationProps(int isbn, Date datefrom, Date dateTo) {
        this.isbn = isbn;
        this.datefrom = datefrom;
        this.dateTo = dateTo;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public Date getDatefrom() {
        return datefrom;
    }

    public void setDatefrom(Date datefrom) {
        this.datefrom = datefrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }
}
