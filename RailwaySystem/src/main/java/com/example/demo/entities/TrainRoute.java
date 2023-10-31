package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
 
@Entity
public class TrainRoute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fromLocation;
    private int km;
    public TrainRoute() {
		super();
	}
	public TrainRoute(String fromLocation, int km, String toLocation) {
		super();
		this.fromLocation = fromLocation;
		this.km = km;
		this.toLocation = toLocation;
	}
	public TrainRoute(Long id, String fromLocation, int km, String toLocation) {
		super();
		this.id = id;
		this.fromLocation = fromLocation;
		this.km = km;
		this.toLocation = toLocation;
	}
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
	public int getKm() {
		return km;
	}
	public void setKm(int km) {
		this.km = km;
	}
	public String getToLocation() {
		return toLocation;
	}
	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}
	private String toLocation;

 
    // Getters and setters (or use Lombok)
}
