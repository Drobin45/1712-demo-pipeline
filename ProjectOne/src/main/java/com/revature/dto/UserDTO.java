package com.revature.dto;

import com.revature.model.User;
//import com.revature.model.Reimbursement;

public class UserDTO extends User{
private int Rid;
private double Ramount;

public UserDTO() {}

public UserDTO(int Rid, double Ramount) {
	super();
	this.Rid = Rid;
	this.Ramount = Ramount;
}

public UserDTO(int id, String username, String pass, String firstname, String lastname, String email) {
	super(id, username, pass, firstname, lastname, email);
}

public UserDTO(int id, String username, String firstName, String lastName, String email, int Rid, double Ramount) {
	super(id, username, firstName, lastName, email, null);
	this.Rid = Rid;
	this.Ramount = Ramount;
}

public UserDTO(int id, String username, String firstname, String lastname, String email) {
	super(id, username, firstname, lastname, email);
}

public int getRid() {
	return Rid;
}

public void setRid(int Rid) {
	this.Rid = Rid;
}


public double getRamount() {
	return Ramount;
}

public void setRamount(double Ramount) {
	this.Ramount = Ramount;
}

@Override
public String toString() {
	return "UserDTO [Rid=" + Rid + ", Ramount=" + Ramount + 
			", id=" + id + ", username" + username + ", firstName" + firstName + ", lastName" +
			lastName + ", email" + email +"]";
}
//Wasn't able to place getters/setters for User's fields that weren't in UserDTO. This may be a problem

}
