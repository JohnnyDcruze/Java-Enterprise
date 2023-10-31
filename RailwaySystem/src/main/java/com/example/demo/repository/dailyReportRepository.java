package com.example.demo.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.TicketBooking;

public interface dailyReportRepository extends CrudRepository<TicketBooking, Long> {

  
}
