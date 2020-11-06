package com.bookmovie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookmovie.dao.AdminDao;
import com.bookmovie.dto.Admin;
import com.bookmovie.dto.Hall;
import com.bookmovie.dto.Movie;
import com.bookmovie.dto.Orders;
import com.bookmovie.dto.Shows;

@Service
public class AdminServiceImple implements AdminService {

	@Autowired
	AdminDao adminDao;
	@Override
	public Admin getAdmin(Admin admin) {
		return adminDao.getAdmin(admin);
	}

	@Override
	public boolean addMovie(Movie movie) {
			return adminDao.addMovie(movie);
	}

	@Override
	public boolean updateMovie(Movie movie) {
		return adminDao.updateMovie(movie);
	}

	@Override
	public void deleteMovie(int movieId) {
		adminDao.deleteMovie(movieId);

	}

	@Override
	public List<Movie> showMovies() {
			return adminDao.showMovies();
	}

	@Override
	public boolean addHall(Hall hall) {
		return adminDao.addHall(hall);
	}

	@Override
	public boolean updateHall(Hall hall) {
		return adminDao.updateHall(hall);
	}

	@Override
	public void deleteHall(int hallId) {
		adminDao.deleteHall(hallId);

	}

	@Override
	public List<Hall> showHalls() {
		return adminDao.showHalls();
	}

	@Override
	public boolean addShow(Shows shows) {
		return adminDao.addShow(shows);

	}

	@Override
	public boolean updateShow(Shows shows) {
		return adminDao.updateShow(shows);
	}

	@Override
	public void deleteShows(int showId) {
		adminDao.deleteShows(showId);

	}

	@Override
	public List<Shows> showsAll() {
		return adminDao.showsAll();
	}

	@Override
	public List<Orders> showOrders() {
		return adminDao.showOrders();
	}

	@Override
	public boolean updateOrders(Orders orders) {
			return adminDao.updateOrders(orders);
	}

	@Override
	public void deleteOrders(int ticketId) {
		adminDao.deleteOrders(ticketId);

	}

	@Override
	public Movie getMovie(int movieId) {
			return adminDao.getMovie(movieId);
	}

	@Override
	public Hall getHall(int hallId) {
			return adminDao.getHall(hallId);
	}

	@Override
	public Shows getShow(int showId) {
		return adminDao.getShow(showId);
	}

	@Override
	public Orders getOrder(int ticketId) {
		return adminDao.getOrder(ticketId);
	}

	@Override
	public boolean addOrders(Orders orders) {
		return adminDao.addOrders(orders);
	}


}
