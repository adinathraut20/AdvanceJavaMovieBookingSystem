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

import com.bookmovie.dto.Movie;
import com.bookmovie.dto.Orders;
import com.bookmovie.dto.Shows;
import com.bookmovie.dto.User;

@Repository
public class UserDaoImple implements UserDao {

	@Autowired
	HibernateTemplate hibernateTemplate;
	

	@Override
	public boolean addUser(User user) {
		return hibernateTemplate.execute(new HibernateCallback<Boolean>() {

			@Override
			public Boolean doInHibernate(Session session) throws HibernateException {
				
				Transaction trans = session.beginTransaction();
				Query q = session.createQuery("from User where email = ?");
				q.setString(0, user.getEmail());
				List<User> li = q.list();
				if(!li.isEmpty()) {
					trans.commit();
					session.flush();
					session.close();
					return false;
				}
				session.save(user);
				trans.commit();
				session.flush();
				session.close();
				
				return true;
				
			}
		});

	}

	@Override
	public User getUser(User user) {

		User usr = hibernateTemplate.execute(new HibernateCallback<User>() {

			@Override
			public User doInHibernate(Session session) throws HibernateException {
				
				Transaction trans = session.beginTransaction();
				Query q = session.createQuery("from User where email = ? and password = ?");
				q.setString(0, user.getEmail());
				q.setString(1, user.getPassword());
				List<User> li = q.list();
				if(li.isEmpty()) {
					return null;
				}
				else {
					return li.get(0);
				}
			}
		});
		
		return usr;
	}

	@Override
	public List<Movie> getMovies() {
		
		List<Movie> li = hibernateTemplate.execute(new HibernateCallback<List<Movie>>() {

			@Override
			public List<Movie> doInHibernate(Session session) throws HibernateException {
				Transaction trans = session.beginTransaction();
				Query q = session.createQuery("from Movie");
				List<Movie> l1 = q.list();
				if(!l1.isEmpty()) {
					return l1;
				}
				return null;
			}} );
		return li;
	}

	@Override
	public List<Shows> getShow(int movieId) {
		
		return hibernateTemplate.execute(new HibernateCallback<List<Shows>>() {

			@Override
			public List<Shows> doInHibernate(Session session) throws HibernateException {
				Transaction trans = session.beginTransaction();
				Query q = session.createQuery("from Shows where movie_id = ?");
				//System.out.println("hiiiii");
				q.setInteger(0, movieId);
				List<Shows> l1 = q.list();
				//System.out.println("List hereeee");
				if(!l1.isEmpty()) {
					System.out.println(l1.get(0));
					return l1;
				}
				return null;
			}} );
	}

	@Override
	public String forgotPassword(String email) {
		String password = hibernateTemplate.execute(new HibernateCallback<String>() {

			@Override
			public String doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				Query q = session.createQuery("from User where email = ?");
				q.setString(0, email);
				List<User> li = q.list();
				String pass = null;
				if(!li.isEmpty())
					pass = li.get(0).getPassword();
				tr.commit();
				session.flush();
				session.close();
				return pass;
			}
			
		});
		return password;
	}

	@Override
	public List<Orders> getOrderForUser(int userId) {
		
		return  hibernateTemplate.execute(new HibernateCallback<List<Orders>>() {

			@Override
			public List<Orders> doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				Query q = session.createQuery("from Orders where user_id = ?");
				q.setInteger(0, userId);
				List<Orders> li = q.list();
				
				if(!li.isEmpty()) {
					
				tr.commit();
				session.flush();
				session.close();
				return li;
			
				}
				return null;
 
	}});

	}
}
