package com.revature.service;

import java.util.List;

import com.revature.dao.UserDao;
import com.revature.dao.UserDaoContract;
import com.revature.model.User;
public class UserService implements UserServiceContract {
	
UserDaoContract u = new UserDao(); 
	
	@Override
	public List<User> SelectAllUser() {
		return null;
	}

	@Override
	public User selectUserByPassword(String pass, String email) {		
		return u.selectUserbyPassword(pass, email);
	}

	@Override
	public void newUser(int id, String username, String pass, String firstName, String lastName, String email) {
		
	}

	@Override
	public void deleteUser(int id) {
		
	}

}
