package com.cgi.library.lib.manager.Controller;


import com.cgi.library.lib.manager.Exceptions.ApiRequestException;
import com.cgi.library.lib.manager.Model.ContextObjects.ReservationProps;
import com.cgi.library.lib.manager.Model.Reservation;
import com.cgi.library.lib.manager.ResponseEntity.ResponseHandler;
import com.cgi.library.lib.manager.Service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Reservations")

public class ReservationController {
    DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD");

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/All")
    public ResponseEntity<Object> getAllReservation(){
        List<Reservation> result = reservationService.getAllReservations();
        return ResponseHandler.generateResponse("success", HttpStatus.OK, result);
    }

    @PostMapping("Add")
    public ResponseEntity<Object> createReservation(@RequestBody Reservation reservation){
        //Si le livre n'est pas déjà réservé à durant cette date
        boolean isReserved = reservationService.isBookReserved(reservation.getBook().getIsbn(),reservation.getDateFrom(),reservation.getDateTo());
        if(isReserved){
            return ResponseHandler.generateResponse("Le livre est déjà réservé à cette date.", HttpStatus.CONFLICT, false);
        }
        return ResponseHandler.generateResponse("Le livre a été réservé avec succès.", HttpStatus.OK,true);
    }

    @PostMapping("isReserved")
    public ResponseEntity<Object> isReserved(@RequestBody ReservationProps reservationProps){
        if(reservationService.isBookReserved(reservationProps.getIsbn(),reservationProps.getDatefrom(),reservationProps.getDateTo())){
            return ResponseHandler.generateResponse("Le livre est déjà reservé à cette date.", HttpStatus.OK, true);
        }
        return ResponseHandler.generateResponse("Le livre est libre pour réservation à cette date.", HttpStatus.OK,false);
    }

    @PostMapping("reserver")
    public ResponseEntity<Object> reserver(@RequestBody Reservation reservation) throws Exception{
        Date date = new Date();
        if(reservation.getDateFrom().compareTo(date)<=0 || reservation.getDateTo().compareTo(date)<=0){
            return ResponseHandler.generateResponse("Dates éronnées.", HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
        if(reservationService.isBookReserved(reservation.getBook().getIsbn(),reservation.getDateFrom(),reservation.getDateTo())){
            return ResponseHandler.generateResponse("Ce livre est déjà reservé à cette date.", HttpStatus.CONFLICT, null);
        }
        Optional<Reservation> result = Optional.ofNullable(reservationService.createReservation(reservation));
        return ResponseHandler.generateResponse("La réservation a été enregistrée.", HttpStatus.OK, result);

    }


    @DeleteMapping("/delete/{idReservation}")
    public ResponseEntity<Object> deleteReservation(@PathVariable Integer idReservation) throws Exception{
        if(reservationService.existsById(idReservation)){
            reservationService.deleteById(idReservation);
            return ResponseHandler.generateResponse("La réservation a été annulée avec succès.", HttpStatus.OK, true);

        }else{
            return ResponseHandler.generateResponse("La réservation n'existe pas", HttpStatus.NOT_FOUND, null);

        }
    }

    @GetMapping("/User={idUser}")
    public ResponseEntity<Object> findReservationsByUser(@PathVariable Integer idUser){
        List<Reservation> result = reservationService.findReservationByUser(idUser);
        return ResponseHandler.generateResponse("success", HttpStatus.OK, result);
    }


    @GetMapping("/Book={idBook}")
    public ResponseEntity<Object> findReservationsbyBook(@PathVariable Integer idBook){
        List<Reservation> result = reservationService.findReservationByBook(idBook);
        return ResponseHandler.generateResponse("success", HttpStatus.OK, result);
    }

}
