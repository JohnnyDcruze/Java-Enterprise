package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Train {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int train_id;
    private String train_number;
    private String train_name;
    private String start_point;
    private String end_point;
    private String departure_time;
	public int getTrain_id() {
		return train_id;
	}
	public void setTrain_id(int train_id) {
		this.train_id = train_id;
	}
	public String getTrain_number() {
		return train_number;
	}
	public void setTrain_number(String train_number) {
		this.train_number = train_number;
	}
	public String getTrain_name() {
		return train_name;
	}
	public void setTrain_name(String train_name) {
		this.train_name = train_name;
	}
	public String getStart_point() {
		return start_point;
	}
	public void setStart_point(String start_point) {
		this.start_point = start_point;
	}
	public String getEnd_point() {
		return end_point;
	}
	public void setEnd_point(String end_point) {
		this.end_point = end_point;
	}
	public String getDeparture_time() {
		return departure_time;
	}
	public void setDeparture_time(String departure_time) {
		this.departure_time = departure_time;
	}
	public Train(int train_id, String train_number, String train_name, String start_point, String end_point,
			String departure_time) {
		super();
		this.train_id = train_id;
		this.train_number = train_number;
		this.train_name = train_name;
		this.start_point = start_point;
		this.end_point = end_point;
		this.departure_time = departure_time;
	}
	public Train() {
		super();
	}
    

}
