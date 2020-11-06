package com.bookmovie.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bookmovie.dto.Admin;
import com.bookmovie.dto.Hall;
import com.bookmovie.dto.Movie;
import com.bookmovie.dto.Orders;
import com.bookmovie.dto.Shows;
import com.bookmovie.dto.User;
import com.bookmovie.service.AdminService;
import com.bookmovie.service.UserService;
import com.bookmovie.valid.UserValidator;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private UserValidator userValidator;
	
	@Autowired
	private MailSender mailSender;

	@RequestMapping(value = "/forgot_password.htm",method = RequestMethod.POST)
	public String forgotPassword(@RequestParam String email,ModelMap map, HttpSession session) {		
		String pass = userService.forgotPassword(email);
		String msg = "you are not registered";
		if(pass!=null) {	
			
			SimpleMailMessage message = new SimpleMailMessage();  
	        message.setFrom("adinathraut3000@gmail.com");  
	        message.setTo(email);  
	        message.setSubject("Your password");  
	        message.setText(pass);  
	        //sending message   
	        mailSender.send(message);
			msg = "Check your mail for password";
			
			session.setAttribute("err_mssg1", "Password Successfully Send to your Mail..");
			return "index";
		}
		session.setAttribute("err_mssg", "Entered Email is not Registered!!!");
		return "error_page";
	}
	

	
	@RequestMapping(value = "/prep_reg_form.htm",method = RequestMethod.GET)
	public String prepRegForm(ModelMap map) {
		map.put("user", new User());
		return "signup_page_user";
	}
	
	@RequestMapping(value = "/prep_log_form.htm",method = RequestMethod.GET)
	public String prepLogForm(ModelMap map) {
		map.put("user", new User());
		return "login_page";
	}
	
	@RequestMapping(value = "/prep_logout.htm",method = RequestMethod.GET)
	public String prepLogout(ModelMap map, HttpSession session) {
		System.out.println((User)session.getAttribute("user"));
		session.removeAttribute("user");
		session.invalidate();
		return "index";
	}
	
	@RequestMapping(value = "/registerValidateUser.htm",method = RequestMethod.POST)
	public String registerationValidateUser(User user,  BindingResult result, ModelMap map, HttpSession session) {
		//userValidator.validate(user, result);
		map.put("user", new User());
		/*if(result.hasErrors()) {
			return "signup_page_user";
		}*/
		if(userService.insertUser(user)) {
			map.put("user", new User());
			session.setAttribute("err_mssg1", "Account Successfully Created..");
			return "login_page";
		}
		session.setAttribute("err_mssg", "Account Already Exists!!! Try Another Email");
		return "signup_page_user";
	}
	
	@RequestMapping(value = "/loginValidate.htm", method = RequestMethod.POST)
	public String loginValidate(User user, BindingResult result, ModelMap map, HttpSession session) {
		
		session.removeAttribute("err_mssg");
		session.removeAttribute("err_mssg1");
		
		userValidator.validate(user, result);
		map.put("user", new User());
		if(result.hasErrors()) {
			return "login_page";
		}
		
		User user1 = userService.getUser(user);
		System.out.println(user1);
		if(user1 == null) {			
			session.setAttribute("err_mssg", "Invalid Credential!!!");
			return "login_page";
		}
		else {
			session.setAttribute("user", user1);
			
			List<Movie> li = userService.getMovies();
			if(li == null) {
				return "error_page";
			}
			map.put("user", user1);
			session.setAttribute("user", user1);
			map.put("mList", li);
			return "home_page";
		}		
	}
	
	@RequestMapping(value = "/homeValidate.htm", method = RequestMethod.GET)
	public String homeValidate1(User user, BindingResult result, ModelMap map, HttpSession session) {
		
		if(session.getAttribute("user") == null){
	    	 session.setAttribute("err_mssg", "Please Login Again...");
	    	 return "index";
	    	 
	      } 
	    	  List<Movie> li = userService.getMovies();
				if(li == null) {
					return "error_page";
				}
				map.put("mList", li);
				return "home_page";
 }
	
	
	
	@RequestMapping(value = "/prep_show.htm",method = RequestMethod.GET)
	public String prepShow(ModelMap map, HttpServletRequest request,HttpSession session) {
		if(session.getAttribute("user") == null){
	    	 session.setAttribute("err_mssg", "Please Login Again...");
	    	 return "index"; 
	      } 
		int mId = Integer.parseInt(request.getParameter("movie_id"));
		
		List<Shows> li = userService.getShow(mId);
		if(li == null) {
			session.setAttribute("err_mssg", "OOPs No Shows Avaliable");
			return "error_page";
		}
		map.put("sList", li);
		return "shows_page";
	}
	
	@RequestMapping(value = "/prep_search_page.htm", method = RequestMethod.GET)
	public String prepSearchPage(User user, ModelMap map, HttpSession session) {
		
		if(session.getAttribute("user") == null){
	    	 session.setAttribute("err_mssg", "Please Login Again...");
	    	 return "index";
	    	 
	      }
			
		List<Movie> li = userService.getMovies();
		if(li == null) {
			return "error_page";
		}
		
		map.put("mList", li);
			
			return "search_page";
				
	}
	//user Part
	
	@RequestMapping(value = "/prep_user_buy_orders.htm", method = RequestMethod.GET)
	public String userBuyOrders(User user, ModelMap map, HttpSession session) {
		
		if(session.getAttribute("user") == null){
	    	 session.setAttribute("err_mssg", "Please Login Again...");
	    	 return "index";
	    	 
	      } 
				int userId = ((User)session.getAttribute("user")).getUserId();
	    	  List<Orders> li = userService.getOrdersForUser(userId);
				if(li == null) {
					return "home_page";
				}
				map.put("mList", li);
				return "user_buy_order_page";
 }
	//Booking Part
	
		@RequestMapping(value = "/prep_user_orders.htm",method = RequestMethod.GET)
		public String prepUserOrders(ModelMap map, User user, HttpSession session, HttpServletRequest request) {
			if(session.getAttribute("user") == null){
		    	 session.setAttribute("err_mssg", "Please Login Again...");
		    	 return "index";
		    	 
		      }
			if(request.getParameter("show_id") == null) {
				session.setAttribute("err_mssg", "Error Occured ...");
		    	 return "index";
			}
			
			int showId = Integer.parseInt(request.getParameter("show_id"));
			Shows shows =  adminService.getShow(showId);
			int lastSeatNo = shows.getBookedSeats();
			int totalSeats = shows.getTotalSeats();
			Orders orders = new Orders();
			
			if(lastSeatNo <= totalSeats) {
				User user1 = (User)session.getAttribute("user");
				
				 int seatNo = lastSeatNo + 1;
				 float price = shows.getPrice() + ((shows.getPrice()*18)/100);				
				 
	             System.out.println(java.time.LocalDate.now()); 
	             String odrDate = java.time.LocalDate.now().toString();
	             shows.setBookedSeats(seatNo);
	             orders.setOrderDate(odrDate);
	             orders.setSeatNo(seatNo);
	             orders.setShows(shows);
	             orders.setPrice(price);
	             orders.setUser(user1);
	             map.put("shows", shows);
	             map.put("orders", orders);
	             return "orders_page_confirm";
			}
			else {
             
				map.put("err_msgShow", "No Seats Avaliable for that Show!!!");
				return "home_page";
			
			}
		}
		
		
		@RequestMapping(value = "/confirm_book_page.htm",method = RequestMethod.GET)
		public String confirmShowBook(ModelMap map, User user,HttpSession session, HttpServletRequest request) {
			
			Orders orders1 = (Orders)session.getAttribute("orders");
			adminService.addOrders(orders1);
			adminService.updateShow(orders1.getShows());
			map.put("orders", orders1);
			return "ticket_page";
		}
	
	//Admin Part
	
	@RequestMapping(value = "/prep_admin_log.htm",method = RequestMethod.GET)
	public String prepAdminLogForm(ModelMap map) {
		map.put("admin", new Admin());
		return "login_admin_page";
	}
	@RequestMapping(value = "/prep_admin_logout.htm",method = RequestMethod.GET)
	public String prepAdminLogout(ModelMap map, HttpSession session) {
		
		session.removeAttribute("admin");
		session.invalidate();
		return "index";
	}
	@RequestMapping(value = "/admin_log_validate.htm",method = RequestMethod.POST)
	public String AdminLogValidate(ModelMap map, Admin admin, HttpSession session) {
		
		session.removeAttribute("err_mssg");
		session.removeAttribute("err_mssg1");
		map.put("admin", new Admin());
		
		System.out.println(admin);
		Admin admin1 = adminService.getAdmin(admin);
		map.put("admin", new Admin());
		System.out.println(admin1);
		if(admin1 == null) {			
			session.setAttribute("err_mssg", "Invalid Credential!!!");
			return "login_admin_page";
		}

			map.put("admin", admin1);
			session.setAttribute("admin", admin1);
			return "admin_home_page";
			
		
	}
	
	@RequestMapping(value = "/admin_home.htm",method = RequestMethod.GET)
	public String adminHome(ModelMap map, Admin admin, HttpSession session) {
		if(session.getAttribute("admin") == null){
	    	 session.setAttribute("err_mssg", "Please Login Again...");
	    	 return "index"; 
	      }
		
		return "admin_home_page";
	}
	
	@RequestMapping(value = "/prep_admin_shows.htm",method = RequestMethod.GET)
	public String adminShows(ModelMap map, Admin admin, HttpSession session) {
		
		List<Shows> li = adminService.showsAll();
		if(li == null) {
			return "admin_home_page";
		}
		map.put("sList",li);
		//System.out.println("update prepared");
		return "admin_shows";
	}
	
	
	@RequestMapping(value = "/prep_show_delete.htm",method = RequestMethod.GET)
	public String adminShowsDelete(ModelMap map, Admin admin, HttpSession session, HttpServletRequest request) {
		
		if(session.getAttribute("admin") == null){
	    	 session.setAttribute("err_mssg", "Please Login Again...");
	    	 return "index"; 
	      }
	
		if((request.getParameter("movie_id") == null) || (request.getParameter("show_id")==null) || (request.getParameter("hall_id")==null)) {
			session.setAttribute("err_mssgShows", "Cannot Delete...");
	    	 return "admin_home_page";
		}
		
		int movieId = Integer.parseInt(request.getParameter("movie_id"));
	    int showId = Integer.parseInt(request.getParameter("show_id"));
	    int hallId = Integer.parseInt(request.getParameter("hall_id"));
	    //System.out.println(movieId + " "+ " " + showId + " " + hallId);
	    
	    adminService.deleteShows(showId);
	    List<Shows> li = adminService.showsAll();
		if(li == null) {
			return "admin_home_page";
		}
		map.put("sList",li);
		session.setAttribute("err_mssgShows1", "Show Deleted Successfully &#9786;");
		return "admin_shows";
	}
	@RequestMapping(value = "/prep_show_update.htm",method = RequestMethod.GET)
	public String adminShowsUpdate(ModelMap map, Admin admin, HttpSession session, HttpServletRequest request) {
		if(session.getAttribute("admin") == null){
	    	 session.setAttribute("err_mssg", "Please Login Again...");
	    	 return "index"; 
	      }
		if((request.getParameter("show_id")==null)) {
			 session.setAttribute("err_mssg", "Please Login Again...");
	    	 return "index"; 
		}
		int movieId = Integer.parseInt(request.getParameter("movie_id"));
	    int showId = Integer.parseInt(request.getParameter("show_id"));
	    int hallId = Integer.parseInt(request.getParameter("hall_id"));
		
	    Shows shows = adminService.getShow(showId);
	    map.put("shows", shows);
	    map.put("movieId", movieId);
	    map.put("hallId",hallId);
		return "admin_shows_update_form";
	}	
	
	@RequestMapping(value = "/admin_show_update_Done.htm",method = RequestMethod.POST)
	public String adminShowsUpdate(ModelMap map, Shows shows, HttpSession session) {
		
		if(session.getAttribute("admin") == null){
	    	 session.setAttribute("err_mssg", "Please Login Again...");
	    	 return "index"; 
	      }
		//System.out.println(shows.getHall());
		
		boolean flag = adminService.updateShow(shows);
		List<Shows> li = adminService.showsAll();
		if(li == null) {
			return "admin_home_page";
		}
		map.put("sList",li);
		
		if(!flag) {	
			session.setAttribute("err_mssgShows", "Entered Movie Id or Hall Id Not Present!!!");
			return "admin_shows";
		}
		
		session.setAttribute("err_mssgShows1", "Show Updated Successfully &#9786;");
		return "admin_shows";
	}
	
	@RequestMapping(value = "/admin_shows_add_form.htm",method = RequestMethod.GET)
	public String adminShowsAddForm(ModelMap map, Shows shows, HttpSession session) {
		
		if(session.getAttribute("admin") == null){
	    	 session.setAttribute("err_mssg", "Please Login Again...");
	    	 return "index"; 
	      }
		map.put("shows",new Shows());
		
		return "admin_shows_add_form";
	}
	
	@RequestMapping(value = "/admin_show_add_done.htm",method = RequestMethod.POST)
	public String adminShowsAddFormDone(ModelMap map, Shows shows, HttpSession session) {
		
		if(session.getAttribute("admin") == null){
	    	 session.setAttribute("err_mssg", "Please Login Again...");
	    	 return "index"; 
	      }
		
		boolean flag = adminService.addShow(shows);
		List<Shows> li = adminService.showsAll();
		if(li == null) {
			return "admin_home_page";
		}
		map.put("sList",li);
		if(!flag) {
			session.setAttribute("err_mssgShows", "Movie ID or Hall ID Not Present!!!");
			return "admin_shows";
		}
		session.setAttribute("err_mssgShows1", "Show Added Successfully &#9786;");
		return "admin_shows";
	}
	
	@RequestMapping(value = "/prep_admin_orders.htm",method = RequestMethod.GET)
	public String prepAdminOrders(ModelMap map, Admin admin, HttpSession session) {
		
		if(session.getAttribute("admin") == null){
	    	 session.setAttribute("err_mssg", "Please Login Again...");
	    	 return "index"; 
	      }
		
		List<Orders> li = adminService.showOrders();
		if(li == null) {
			return "admin_home_page";
		}
		map.put("oList",li);
		//System.out.println("update prepared");
		return "admin_orders";
	}
	
	@RequestMapping(value = "/prep_order_delete.htm",method = RequestMethod.GET)
	public String prepAdminOrdersDelete(ModelMap map, Admin admin, HttpSession session, HttpServletRequest request) {
		
		if(session.getAttribute("admin") == null){
	    	 session.setAttribute("err_mssg", "Please Login Again...");
	    	 return "index"; 
	      }
		if(request.getParameter("ticket_id")==null) {
			 session.setAttribute("err_mssgOrder", "Error while Deleting");
	    	 return "admin_home_page"; 
		}
		int ticketId = Integer.parseInt(request.getParameter("ticket_id"));
		
		adminService.deleteOrders(ticketId);
		session.setAttribute("err_mssgOrder1", "Order Deleted Successfully &#9786; ");
		List<Orders> li = adminService.showOrders();
		if(li == null) {
			return "admin_home_page";
		}
		map.put("oList",li);
		return "admin_orders";
	}
	
	@RequestMapping(value = "/prep_order_update.htm",method = RequestMethod.GET)
	public String prepAdminOrdersUpdate(ModelMap map, Admin admin, HttpSession session, HttpServletRequest request) {
		
		if(session.getAttribute("admin") == null){
	    	 session.setAttribute("err_mssg", "Please Login Again...");
	    	 return "index"; 
	      }
		if(request.getParameter("ticket_id")==null) {
			 session.setAttribute("err_mssgOrder", "Error while Updating");
	    	 return "admin_home_page"; 
		}
		int ticketId = Integer.parseInt(request.getParameter("ticket_id"));
		Orders orders = adminService.getOrder(ticketId);
		map.put("orders",orders);
		return "admin_orders_update_form";
	}
	
	@RequestMapping(value = "/admin_orders_update_done.htm",method = RequestMethod.POST)
	public String adminOrdersUpdateDone(ModelMap map, Orders orders, HttpSession session, HttpServletRequest request) {
		
		if(session.getAttribute("admin") == null){
	    	 session.setAttribute("err_mssg", "Please Login Again...");
	    	 return "index"; 
	      }
		
		boolean flag = adminService.updateOrders(orders);
		List<Orders> li = adminService.showOrders();
		if(li == null) {
			return "admin_home_page";
		}
		map.put("oList",li);
		System.out.println(flag);
		if(!flag) {
			session.setAttribute("err_mssgOrder", "Entered Show ID or User ID Not Present!!!");
			return "admin_orders";
		}
		System.out.println("update done");
		session.setAttribute("err_mssgOrder1", "Order Updated Successfully &#9786;");
		return "admin_orders";
	}
	
	@RequestMapping(value = "/prep_admin_movie.htm",method = RequestMethod.GET)
	public String prepAdminMovie(ModelMap map, Admin admin, HttpSession session) {
		
		if(session.getAttribute("admin") == null){
	    	 session.setAttribute("err_mssg", "Please Login Again...");
	    	 return "index"; 
	      }
		
		List<Movie> li = adminService.showMovies();
		if(li == null) {
			return "admin_home_page";
		}
		map.put("mList",li);
		//System.out.println("update prepared");
		return "admin_movie";
	}
	
	@RequestMapping(value = "/prep_admin_movie_update.htm",method = RequestMethod.GET)
	public String prepAdminMovieUpdate(ModelMap map, Admin admin, HttpSession session, HttpServletRequest request) {
		
		if(session.getAttribute("admin") == null){
	    	 session.setAttribute("err_mssg", "Please Login Again...");
	    	 return "index"; 
	      }
		if(request.getParameter("movie_id")==null) {
			 session.setAttribute("err_mssgMovie", "Error while Updating");
	    	 return "admin_home_page"; 
		}
		int movieId = Integer.parseInt(request.getParameter("movie_id"));
		Movie movie = adminService.getMovie(movieId);
		map.put("movie", movie);
		//System.out.println("update prepared");
		return "admin_movie_update_form";
	}
	
	@RequestMapping(value = "/admin_movie_update_done.htm",method = RequestMethod.POST)
	public String prepAdminMovieUpdateDone(ModelMap map, Movie movie, HttpSession session, HttpServletRequest request) {
		
		if(session.getAttribute("admin") == null){
	    	 session.setAttribute("err_mssg", "Please Login Again...");
	    	 return "index"; 
	      }
		boolean flag = adminService.updateMovie(movie);
		List<Movie> li = adminService.showMovies();
		if(li == null) {
			return "admin_home_page";
		}
		map.put("mList",li);
		if(!flag) {
			session.setAttribute("err_mssgMovie", "Error while Updating!!!");
			return "admin_movie";
		}
		session.setAttribute("err_mssgMovie1", "Movie Updated Successfully..");
		return "admin_movie";
	}
	
	@RequestMapping(value = "/prep_admin_movie_add.htm",method = RequestMethod.GET)
	public String prepAdminMovieAdd(ModelMap map, Admin admin, HttpSession session, HttpServletRequest request) {
		
		if(session.getAttribute("admin") == null){
	    	 session.setAttribute("err_mssg", "Please Login Again...");
	    	 return "index"; 
	      }
		
		
		map.put("movie", new Movie());
		
		return "admin_movie_add_form";
	}
	@RequestMapping(value = "/admin_movie_add_done.htm",method = RequestMethod.POST)
	public String adminMovieAddDone(ModelMap map, Movie movie, HttpSession session, HttpServletRequest request) {
		
		if(session.getAttribute("admin") == null){
	    	 session.setAttribute("err_mssg", "Please Login Again...");
	    	 return "index"; 
	      }
		boolean flag = adminService.addMovie(movie);
		List<Movie> li = adminService.showMovies();
		if(li == null) {
			return "admin_home_page";
		}
		map.put("mList",li);
		if(!flag) {
			session.setAttribute("err_mssgMovie", "Error while Adding Movie!!!");
			return "admin_movie";
		}
		session.setAttribute("err_mssgMovie1", "Movie Added Successfully..");
		return "admin_movie";
	}	
	
	//Hall Connection and Data Entry
	
	@RequestMapping(value = "/prep_admin_hall.htm",method = RequestMethod.GET)
	public String prepAdminHall(ModelMap map, Admin admin, HttpSession session) {
		
		if(session.getAttribute("admin") == null){
	    	 session.setAttribute("err_mssg", "Please Login Again...");
	    	 return "index"; 
	      }
		
		List<Hall> li = adminService.showHalls();
		if(li == null) {
			return "admin_home_page";
		}
		map.put("hList",li);
		//System.out.println("update prepared");
		return "admin_hall";
	}
	
	@RequestMapping(value = "/prep_admin_hall_update.htm",method = RequestMethod.GET)
	public String prepAdminHallUpdate(ModelMap map, Admin admin, HttpSession session, HttpServletRequest request) {
		
		if(session.getAttribute("admin") == null){
	    	 session.setAttribute("err_mssg", "Please Login Again...");
	    	 return "index"; 
	      }
		if(request.getParameter("hall_id")==null) {
			 session.setAttribute("err_mssgMovie", "Error while Updating");
	    	 return "admin_home_page"; 
		}
		int hallId = Integer.parseInt(request.getParameter("hall_id"));
		Hall hall = adminService.getHall(hallId);
		map.put("hall", hall);
		//System.out.println("update prepared");
		return "admin_hall_update_form";
	}
	
	@RequestMapping(value = "/admin_hall_update_done.htm",method = RequestMethod.POST)
	public String prepAdminHallUpdateDone(ModelMap map, Hall hall, HttpSession session, HttpServletRequest request) {
		
		if(session.getAttribute("admin") == null){
	    	 session.setAttribute("err_mssg", "Please Login Again...");
	    	 return "index"; 
	      }
		boolean flag = adminService.updateHall(hall);
		List<Hall> li = adminService.showHalls();
		if(li == null) {
			return "admin_home_page";
		}
		map.put("hList",li);
		if(!flag) {
			session.setAttribute("err_mssgHall", "Error while Updating!!!");
			return "admin_movie";
		}
		session.setAttribute("err_mssgHall1", "Hall Updated Successfully..");
		return "admin_hall";
	}
	
	@RequestMapping(value = "/prep_admin_hall_add.htm",method = RequestMethod.GET)
	public String prepAdminHallAdd(ModelMap map, Admin admin, HttpSession session, HttpServletRequest request) {
		
		if(session.getAttribute("admin") == null){
	    	 session.setAttribute("err_mssg", "Please Login Again...");
	    	 return "index"; 
	      }
				
		map.put("hall", new Hall());
		
		return "admin_hall_add_form";
	}
	@RequestMapping(value = "/admin_hall_add_done.htm",method = RequestMethod.POST)
	public String adminHallAddDone(ModelMap map, Hall hall, HttpSession session, HttpServletRequest request) {
		
		if(session.getAttribute("admin") == null){
	    	 session.setAttribute("err_mssg", "Please Login Again...");
	    	 return "index"; 
	      }
		System.out.println(hall);
		boolean flag = adminService.addHall(hall);
		List<Hall> li = adminService.showHalls();
		if(li == null) {
			return "admin_home_page";
		}
		map.put("hList",li);
		if(!flag) {
			session.setAttribute("err_mssgHall", "Error while Adding Hall!!!");
			return "admin_hall";
		}
		session.setAttribute("err_mssgHall1", "Hall Added Successfully..");
		return "admin_hall";
	}
}
