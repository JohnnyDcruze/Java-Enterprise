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
		public void setTravelDate(Date TravelDate) {
			this.TravelDate = TravelDate;
		}
		public String getTravelClass() {
			return travelClass;
		}
		public void setTravelClass(String travelClass) {
			this.travelClass = travelClass;
		}

}
