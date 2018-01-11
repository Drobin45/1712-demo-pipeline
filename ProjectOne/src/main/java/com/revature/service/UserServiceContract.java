package com.revature.service;

import java.util.List;

import com.revature.model.User;

public interface UserServiceContract {

	public List<User> SelectAllUser();

	public User selectUserByPassword(String pass, String email);
	
	public void newUser(int id, String username, String pass, String firstName, String lastName, String email);
	
	public void deleteUser(int id);
}
