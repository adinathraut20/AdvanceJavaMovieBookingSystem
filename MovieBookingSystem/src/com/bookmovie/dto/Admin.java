package com.bookmovie.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Admin")
public class Admin {

	@Id
	@GeneratedValue
	@Column(name = "admin_id")
	private int adminId;
	@Column(name = "admin_fname")
	private String aFname;
	@Column(name = "admin_lname")
	private String aLname;
	@Column(name = "email")
	private String email;
	@Column(name = "password")
	private String password;
	@Column(name = "contact")
	private String contact;
	
	public Admin(int adminId, String aFname, String aLname, String email, String password, String contact) {
		super();
		this.adminId = adminId;
		this.aFname = aFname;
		this.aLname = aLname;
		this.email = email;
		this.password = password;
		this.contact = contact;
	}

	public Admin(int adminId) {
		super();
		this.adminId = adminId;
	}

	public Admin() {
		super();
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getaFname() {
		return aFname;
	}

	public void setaFname(String aFname) {
		this.aFname = aFname;
	}

	public String getaLname() {
		return aLname;
	}

	public void setaLname(String aLname) {
		this.aLname = aLname;
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
		return "Admin [adminId=" + adminId + ", aFname=" + aFname + ", aLname=" + aLname + ", email=" + email
				+ ", password=" + password + ", contact=" + contact + "]";
	}
	

	
	
}
