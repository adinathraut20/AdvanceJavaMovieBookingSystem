package com.bookmovie.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Orders")
public class Orders {
	
	@Id
	@GeneratedValue
	@Column(name = "ticket_id")
	private int ticketId;
	@ManyToOne
	@JoinColumn(name = "show_id")
	private Shows shows;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	@Column(name = "order_date")
	private String orderDate;
	@Column(name = "price")
	private float price;
	@Column( name = "seat_no")
	private int seatNo;
	
	public Orders() {}

	public Orders(int ticketId) {
		this.ticketId = ticketId;
	}

	public Orders(int ticketId, Shows shows, User user, String orderDate, float price, int seatNo) {
		super();
		this.ticketId = ticketId;
		this.shows = shows;
		this.user = user;
		this.orderDate = orderDate;
		this.price = price;
		this.seatNo = seatNo;
	}

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public Shows getShows() {
		return shows;
	}

	public void setShows(Shows shows) {
		this.shows = shows;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}

	@Override
	public String toString() {
		return "Orders [ticketId=" + ticketId + ", shows=" + shows + ", user=" + user + ", orderDate=" + orderDate
				+ ", price=" + price + ", seatNo=" + seatNo + "]";
	}

	

	
	
	
	
}
