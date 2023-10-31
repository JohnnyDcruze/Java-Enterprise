package com.example.demo.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.TicketBooking;

@Repository
public interface TicketBookingRepository extends CrudRepository<TicketBooking, Long> {
}

