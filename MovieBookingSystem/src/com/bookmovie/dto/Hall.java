package com.bookmovie.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Hall")
public class Hall {

	@Id
	@Column(name = "hall_id")
	@GeneratedValue
	private int hallId;
	@Column(name = "hall_name")
	private String hallName;
	@Column( name = "capacity")
	private int capacity;
	
	public Hall() {
		super();
	}
	public Hall(int hallId) {
		super();
		this.hallId = hallId;
	}
	public Hall(int hallId, String hallName, int capacity) {
		super();
		this.hallId = hallId;
		this.hallName = hallName;
		this.capacity = capacity;
	}
	public int getHallId() {
		return hallId;
	}
	public void setHallId(int hallId) {
		this.hallId = hallId;
	}
	public String getHallName() {
		return hallName;
	}
	public void setHallName(String hallName) {
		this.hallName = hallName;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	@Override
	public String toString() {
		return "Hall [hallId=" + hallId + ", hallName=" + hallName + ", capacity=" + capacity + "]";
	}
	
	
	
	
}
