package com.cgi.library.lib.manager.Repository;

import com.cgi.library.lib.manager.Model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Integer> {
    @Override
    List<Reservation> findAll();

}
