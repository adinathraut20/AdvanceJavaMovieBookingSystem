package com.bookmovie.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.bookmovie.dto.Admin;
import com.bookmovie.dto.Hall;
import com.bookmovie.dto.Movie;
import com.bookmovie.dto.Orders;
import com.bookmovie.dto.Shows;
import com.bookmovie.dto.User;


@Repository
public class AdminDaoImple implements AdminDao {

	@Autowired
	HibernateTemplate hibernateTemplate;
	
	@Override
	public Admin getAdmin(Admin admin) {
		
		return  hibernateTemplate.execute(new HibernateCallback<Admin>() {

			@Override
			public Admin doInHibernate(Session session) throws HibernateException {
				
				Transaction trans = session.beginTransaction();
				Query q = session.createQuery("from Admin where email = ? and password = ?");
				q.setString(0, admin.getEmail());
				q.setString(1, admin.getPassword());
				List<Admin> li = q.list();
				trans.commit();
				session.flush();
				session.close();
				if(li.isEmpty()) {
					return null;
				}
				else {
					return li.get(0);
				}
			}
		});
	}

	@Override
	public boolean addMovie(Movie movie) {
		
		return hibernateTemplate.execute(new HibernateCallback<Boolean>() {

			@Override
			public Boolean doInHibernate(Session session) throws HibernateException {
				
				Transaction trans = session.beginTransaction();
				session.save(movie);
				trans.commit();
				session.flush();
				session.close();
				
				return true;
				
			}
		});
	}

	@Override
	public boolean updateMovie(Movie movie) {
		
		return hibernateTemplate.execute(new HibernateCallback<Boolean>() {

			@Override
			public Boolean doInHibernate(Session session) throws HibernateException {
				
				Transaction trans = session.beginTransaction();
				session.update(movie);
				trans.commit();
				session.flush();
				session.close();
				
				return true;
				
			}
		});	
		}

	@Override
	public void deleteMovie(int movieId) {
		

	}
	
	@Override
	public Movie getMovie(int movieId) {
		return hibernateTemplate.execute(new HibernateCallback<Movie>() {

			@Override
			public Movie doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				Movie movie = (Movie)session.get(Movie.class, movieId);
				tr.commit();
				session.flush();
				session.close();
				return movie;
			}
			
		});
	}

	@Override
	public List<Movie> showMovies() {
		return hibernateTemplate.execute(new HibernateCallback<List<Movie>>() {

			@Override
			public List<Movie> doInHibernate(Session session) throws HibernateException {
				Transaction trans = session.beginTransaction();
				Query q = session.createQuery("from Movie");
				List<Movie> l1 = q.list();
				trans.commit();
				session.flush();
				session.close();
				if(!l1.isEmpty()) {
					return l1;
				}
				return null;
			}} );
	}

	@Override
	public boolean addHall(Hall hall) {
			return hibernateTemplate.execute(new HibernateCallback<Boolean>() {

				@Override
				public Boolean doInHibernate(Session session) throws HibernateException {
					
					Transaction trans = session.beginTransaction();
					session.save(hall);
					trans.commit();
					session.flush();
					session.close();
					
					return true;
					
				}
			});
	}

	@Override
	public boolean updateHall(Hall hall) {
		return hibernateTemplate.execute(new HibernateCallback<Boolean>() {

			@Override
			public Boolean doInHibernate(Session session) throws HibernateException {
				
				Transaction trans = session.beginTransaction();
				session.update(hall);
				trans.commit();
				session.flush();
				session.close();
				
				return true;
				
			}
		});	
	}

	@Override
	public void deleteHall(int hallId) {
		

	}
	
	@Override
	public Hall getHall(int hallId) {
		return hibernateTemplate.execute(new HibernateCallback<Hall>() {

			@Override
			public Hall doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				Hall hall = (Hall)session.get(Hall.class, hallId);
				tr.commit();
				session.flush();
				session.close();
				return hall;
			}
			
		});
	}


	@Override
	public List<Hall> showHalls() {
		return hibernateTemplate.execute(new HibernateCallback<List<Hall>>() {

			@Override
			public List<Hall> doInHibernate(Session session) throws HibernateException {
				Transaction trans = session.beginTransaction();
				Query q = session.createQuery("from Hall");
				List<Hall> l1 = q.list();
				trans.commit();
				session.flush();
				session.close();
				if(!l1.isEmpty()) {
					return l1;
				}
				return null;
			}} );
	}

	@Override
	public boolean addShow(Shows shows) {
		return hibernateTemplate.execute(new HibernateCallback<Boolean>() {

			@Override
			public Boolean doInHibernate(Session session) throws HibernateException {
				
				Transaction trans = session.beginTransaction();
				System.out.println(shows);
				Movie movie = (Movie)session.get(Movie.class, shows.getMovie().getMovieId());
				Hall hall = (Hall)session.get(Hall.class, shows.getHall().getHallId());
				
				
				if(hall == null || movie == null) {
					trans.commit();
					session.flush();
					session.close();
					return false;
				}
				else {
					shows.setHall(hall);
					shows.setMovie(movie);
					session.save(shows);
					trans.commit();
					session.flush();
					session.close();
				
				return true;
				}
			}
		});

	}

	@Override
	public boolean updateShow(Shows shows) {
		return hibernateTemplate.execute(new HibernateCallback<Boolean>() {

			@Override
			public Boolean doInHibernate(Session session) throws HibernateException {
				
				Transaction trans = session.beginTransaction();
				System.out.println(shows);
				Movie movie = (Movie)session.get(Movie.class, shows.getMovie().getMovieId());
				Hall hall = (Hall)session.get(Hall.class, shows.getHall().getHallId());
				
				
				if(hall == null || movie == null) {
					trans.commit();
					session.flush();
					session.close();
					return false;
				}
				else {
					
					shows.setHall(hall);
					shows.setMovie(movie);
					session.update(shows);
					trans.commit();
					session.flush();
					session.close();
				
				return true;
				}
			}
		});		
	}

	@Override
	public void deleteShows(int showId) {
		hibernateTemplate.execute(new HibernateCallback<Void>() {

			@Override
			public Void doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				Query q = session.createQuery("delete from Orders where show_id = ?");
				q.setInteger(0, showId);
				int x = q.executeUpdate();
				session.delete(new Shows(showId));
				tr.commit();
				session.flush();
				session.close();
				return null;
			}
			
		});

	}
	
	@Override
	public Shows getShow(int showId) {
		return hibernateTemplate.execute(new HibernateCallback<Shows>() {

			@Override
			public Shows doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				Shows shows = (Shows)session.get(Shows.class, showId);
				tr.commit();
				session.flush();
				session.close();
				return shows;
			}
			
		});
	}

	@Override
	public List<Shows> showsAll() {
		return hibernateTemplate.execute(new HibernateCallback<List<Shows>>() {

			@Override
			public List<Shows> doInHibernate(Session session) throws HibernateException {
				Transaction trans = session.beginTransaction();
				Query q = session.createQuery("from Shows");
				List<Shows> l1 = q.list();
				trans.commit();
				session.flush();
				session.close();
				if(!l1.isEmpty()) {
					return l1;
				}
				return null;
			}} );
	}

	@Override
	public List<Orders> showOrders() {
		return hibernateTemplate.execute(new HibernateCallback<List<Orders>>() {

			@Override
			public List<Orders> doInHibernate(Session session) throws HibernateException {
				Transaction trans = session.beginTransaction();
				Query q = session.createQuery("from Orders");
				List<Orders> l1 = q.list();
				trans.commit();
				session.flush();
				session.close();
				if(!l1.isEmpty()) {
					return l1;
				}
				return null;
			}} );
	}

	@Override
	public boolean updateOrders(Orders orders) {
		return hibernateTemplate.execute(new HibernateCallback<Boolean>() {

			@Override
			public Boolean doInHibernate(Session session) throws HibernateException {
				
				
				Transaction trans = session.beginTransaction();
				
				Shows shows = (Shows)session.get(Shows.class, orders.getShows().getShowId());
				User user = (User)session.get(User.class, orders.getUser().getUserId());
				
				
				if(shows == null || user == null) {
					System.out.println("hiiiiiii");
					trans.commit();
					session.flush();
					session.close();
					return false;
				}
				System.out.println("byyyyiiiiiii");
				orders.setShows(shows);
				orders.setUser(user);
				session.update(orders);
				trans.commit();
				session.flush();
				session.close();
				
				return true;
				
			}
		});	
	}

	@Override
	public void deleteOrders(int ticketId) {
		hibernateTemplate.execute(new HibernateCallback<Void>() {

			@Override
			public Void doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				session.delete(new Orders(ticketId));
				tr.commit();
				session.flush();
				session.close();
				return null;
			}
			
		});

	}	

	@Override
	public Orders getOrder(int ticketId) {
		return hibernateTemplate.execute(new HibernateCallback<Orders>() {

			@Override
			public Orders doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				Orders order = (Orders)session.get(Orders.class, ticketId);
				tr.commit();
				session.flush();
				session.close();
				return order;
			}
			
		});
	}

	@Override
	public boolean addOrders(Orders orders) {
		
		return hibernateTemplate.execute(new HibernateCallback<Boolean>() {

			@Override
			public Boolean doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				session.save(orders);
				tr.commit();
				session.flush();
				session.close();
				return true;
			}
			
		});
	}

	

}
