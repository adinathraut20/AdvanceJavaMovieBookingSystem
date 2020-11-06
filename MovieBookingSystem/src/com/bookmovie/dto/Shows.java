package com.bookmovie.dto;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Shows")
public class Shows {

	@Id
	@GeneratedValue
	@Column(name = "show_id")
	private int showId;
	@ManyToOne
	@JoinColumn(name = "movie_id")
	private Movie movie;
	@ManyToOne
	@JoinColumn(name = "hall_id")
	private Hall hall;
	@Column(name = "show_date")
	private String showDate;
	@Column(name = "show_time")
	private String showTime;
	@Column(name = "duration")
	private String duration;
	@Column(name = "price")
	private float price;
	@Column(name = "total_seats")
	private int totalSeats;
	@Column(name = "booked_seats")
	private int bookedSeats;
	
	public Shows() {
		super();
	}

	public Shows(int showId) {
		super();
		this.showId = showId;
	}

	public Shows(int showId, Movie movie, Hall hall, String showDate, String showTime, String duration, float price,
			int totalSeats, int bookedSeats) {
		super();
		this.showId = showId;
		this.movie = movie;
		this.hall = hall;
		this.showDate = showDate;
		this.showTime = showTime;
		this.duration = duration;
		this.price = price;
		this.totalSeats = totalSeats;
		this.bookedSeats = bookedSeats;
	}

	public int getShowId() {
		return showId;
	}

	public void setShowId(int showId) {
		this.showId = showId;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Hall getHall() {
		return hall;
	}

	public void setHall(Hall hall) {
		this.hall = hall;
	}

	public String getShowDate() {
		return showDate;
	}

	public void setShowDate(String showDate) {
		this.showDate = showDate;
	}

	public String getShowTime() {
		return showTime;
	}

	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}

	public int getBookedSeats() {
		return bookedSeats;
	}

	public void setBookedSeats(int bookedSeats) {
		this.bookedSeats = bookedSeats;
	}

	@Override
	public String toString() {
		return "Shows [showId=" + showId + ", movie=" + movie + ", hall=" + hall + ", showDate=" + showDate
				+ ", showTime=" + showTime + ", duration=" + duration + ", price=" + price + ", totalSeats="
				+ totalSeats + ", bookedSeats=" + bookedSeats + "]";
	}

	

	
	
	
}
