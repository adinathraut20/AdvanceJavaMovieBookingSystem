package com.bookmovie.service;

import java.util.List;




import com.bookmovie.dto.Admin;
import com.bookmovie.dto.Hall;
import com.bookmovie.dto.Movie;
import com.bookmovie.dto.Orders;
import com.bookmovie.dto.Shows;


public interface AdminService {

	Admin getAdmin(Admin admin);
	
	Movie getMovie(int movieId);
	boolean addMovie(Movie movie);
	boolean updateMovie(Movie movie);
	void deleteMovie(int movieId);
	List<Movie> showMovies();
	
	Hall getHall(int hallId);
	boolean addHall(Hall hall);
	boolean updateHall(Hall hall);
	void deleteHall(int hallId);
	List<Hall> showHalls();
	
	Shows getShow(int showId);
	boolean addShow(Shows shows);
	boolean updateShow(Shows shows);
	void deleteShows(int showId);
	List<Shows> showsAll();
	
	Orders getOrder(int ticketId);
	List<Orders> showOrders();
	boolean updateOrders(Orders orders);
	void deleteOrders(int ticketId);
	boolean addOrders(Orders orders);
	
}
