package com.cgi.library.lib.manager.Service;

import com.cgi.library.lib.manager.Model.Reservation;
import com.cgi.library.lib.manager.Repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class ReservationServiceImplementation implements ReservationService {

    //(StartDate1 <= EndDate2) and (StartDate2 <= EndDate1)
    static BiPredicate<Reservation,Date> before = (r,dateFrom) -> (dateFrom.before(r.getDateFrom()));
    static BiPredicate<Reservation,Date> after = (r,dateTo) -> r.getDateTo().after(dateTo);
    static BiPredicate<Reservation,Integer> belongsToUser = (r, idUser) -> r.getUser().getId()==idUser;
    static BiPredicate<Reservation,Integer> concernBook = (r, idBook) -> r.getBook().getIsbn()==idBook;
    @Autowired
    private ReservationRepository reservationRepository;
    @Override
    public boolean isBookReserved(Integer isbn, Date dateFrom, Date dateTo) {
        List<Reservation> reservations = reservationRepository
                .findAll()
                .stream().filter(reservation -> reservation.getBook().getIsbn()==isbn)
                .filter(reservation ->
                     dateTo.compareTo(reservation.getDateFrom())>=0 && dateFrom.compareTo(reservation.getDateTo())<=0
                )
                .collect(Collectors.toList());
        if(reservations.size()!=0){
            return true;
        }
        return false;
    }

    @Override
    public List<Reservation> findReservationByUser(Integer idUser) {
        List<Reservation> reservations = reservationRepository.findAll().stream().filter(
                reservation -> belongsToUser.test(reservation,idUser)
        ).collect(Collectors.toList());
        return reservations;
    }
    @Override
    public List<Reservation> findReservationByBook(Integer idBook) {
        List<Reservation> reservations = reservationRepository.findAll().stream().filter(
                reservation -> concernBook.test(reservation,idBook)
        ).collect(Collectors.toList());
        return reservations;
    }

    @Override
    public Optional<Reservation> findById(Integer id) {
        return reservationRepository.findById(id);
    }

    @Override
    public Boolean existsById(Integer idReservation) {
        return reservationRepository.existsById(idReservation);
    }

    @Override
    public void deleteById(Integer idReservation) {
        reservationRepository.deleteById(idReservation);
    }

    @Override
    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }
}