package com.bookmovie.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User {

	@Id
	@GeneratedValue
	@Column(name = "user_id")
	private int userId;
	@Column(name = "user_fname")
	private String uFname;
	@Column(name = "user_lname")
	private String uLname;
	@Column(name = "email")
	private String email;
	@Column(name = "password")
	private String password;
	@Column(name = "contact")
	private String contact;
	
	public User() {}
	
	public User(int userId, String uFname, String uLname, String email, String contact) {
		super();
		this.userId = userId;
		this.uFname = uFname;
		this.uLname = uLname;
		this.email = email;
		this.contact = contact;
	}
	
	public User(int userId) {
		this.userId = userId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getuFname() {
		return uFname;
	}
	public void setuFname(String uFname) {
		this.uFname = uFname;
	}
	public String getuLname() {
		return uLname;
	}
	public void setuLname(String uLname) {
		this.uLname = uLname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", uFname=" + uFname + ", uLname=" + uLname + ", email=" + email
				+ ", password=" + password + ", contact=" + contact + "]";
	}
	
	
	
	
}
