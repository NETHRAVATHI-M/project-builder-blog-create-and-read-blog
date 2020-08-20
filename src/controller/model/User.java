package model;

import java.time.LocalDate;

public class User{
	private String email;
	private String password;
	private LocalDate date;
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
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
	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	public User() {
		// TODO A{uto-generated constructor stub
	}
	
	
}