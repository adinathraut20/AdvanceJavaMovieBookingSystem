package com.bookmovie.service;

import java.util.List;

import com.bookmovie.dto.Movie;
import com.bookmovie.dto.Orders;
import com.bookmovie.dto.Shows;
import com.bookmovie.dto.User;

public interface UserService {

	boolean insertUser(User user);
	User getUser(User user);	
	List<Movie> getMovies();
	List<Shows> getShow(int movieId);
	List<Orders> getOrdersForUser(int userId);
	
	String forgotPassword(String email);

}
