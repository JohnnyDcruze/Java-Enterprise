package com.example.demo.entities;



import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TicketBooking {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String fromLocation;
	    private String toLocation;
	    private Date TravelDate;
	    private String travelClass;
	    private String Journey;
	    private double ticketPrice;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getFromLocation() {
			return fromLocation;
		}
		public void setFromLocation(String fromLocation) {
			this.fromLocation = fromLocation;
		}
		public String getToLocation() {
			return toLocation;
		}
		public void setToLocation(String toLocation) {
			this.toLocation = toLocation;
		}
		public Date getTravelDate() {
			return TravelDate;
		}
		public void setTravelDate(Date date) {
			TravelDate = date;
		}
		public String getTravelClass() {
			return travelClass;
		}
		public void setTravelClass(String travelClass) {
			this.travelClass = travelClass;
		}
		public String getJourney() {
			return Journey;
		}
		public void setJourney(String journey) {
			Journey = journey;
		}
		public double getTicketPrice() {
			return ticketPrice;
		}
		public void setTicketPrice(double ticketPrice) {
			this.ticketPrice = ticketPrice;
		}
		public TicketBooking(Long id, String fromLocation, String toLocation, Date travelDate, String travelClass,
				String journey, double ticketPrice) {
			super();
			this.id = id;
			this.fromLocation = fromLocation;
			this.toLocation = toLocation;
			TravelDate = travelDate;
			this.travelClass = travelClass;
			Journey = journey;
			this.ticketPrice = ticketPrice;
		}
		public TicketBooking() {
			super();
		}
		public TicketBooking(String fromLocation, String toLocation, Date travelDate, String travelClass,
				String journey, double ticketPrice) {
			super();
			this.fromLocation = fromLocation;
			this.toLocation = toLocation;
			TravelDate = travelDate;
			this.travelClass = travelClass;
			Journey = journey;
			this.ticketPrice = ticketPrice;
		}
		


}
