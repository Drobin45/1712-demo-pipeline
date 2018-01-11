package com.revature.model;

public class User {

	
	protected int id;
	protected String username;
	private String pass;
	protected String firstName;
	protected String lastName;
	protected String email;
	
	public User(){}

	public User(int id, String username, String pass, String firstname, String lastname, String email) {
		super();
		this.id = id;
		this.username = username;
		this.pass = pass;
		this.firstName = firstname;
		this.lastName = lastname;
		this.email = email;
	}

	public User(int id, String username, String firstname, String lastname, String email) {
		this.id = id;
		this.username = username;
		this.firstName = firstname;
		this.lastName = lastname;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getFirstname() {
		return firstName;
	}

	public void setFirstname(String firstname) {
		this.firstName = firstname;
	}

	public String getLastname() {
		return lastName;
	}

	public void setLastname(String lastname) {
		this.lastName = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", pass=" + pass + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + "]";
	}
	
	
}
