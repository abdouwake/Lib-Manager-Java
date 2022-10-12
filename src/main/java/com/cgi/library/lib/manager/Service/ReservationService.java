package com.cgi.library.lib.manager.Service;

import com.cgi.library.lib.manager.Model.Reservation;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public interface ReservationService {
    public List<Reservation> getAllReservations();
    public boolean isBookReserved(Integer isbn, Date dateFrom,Date dateTo);
    public Reservation createReservation(Reservation reservation);

    public Optional<Reservation> findById(Integer id);

    public Boolean existsById(Integer idReservation);
    public void deleteById(Integer idReservation);

    public List<Reservation> findReservationByUser(Integer idUser);
    public List<Reservation> findReservationByBook(Integer idBook);
    //Réserver un livre
    //Annuler une reservation
    //get reservations of a book
    //get reservation of a specific user
}
