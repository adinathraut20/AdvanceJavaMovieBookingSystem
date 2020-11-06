package com.bookmovie.dao;

import java.util.List;

import com.bookmovie.dto.Movie;
import com.bookmovie.dto.Orders;
import com.bookmovie.dto.Shows;
import com.bookmovie.dto.User;

public interface UserDao {

	boolean addUser(User user);
	User getUser(User user);
	List<Movie> getMovies();
	List<Shows> getShow(int movieId);
	List<Orders> getOrderForUser(int userId);
	String forgotPassword(String email);

}
