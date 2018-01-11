package com.revature.service;

import com.revature.dao.UserDao;
import com.revature.dto.UserDTO;
import com.revature.model.Reimbursement;
import com.revature.model.User;

public class ValidateService {

	public User validateUser(User user) {
		UserDao dao = new UserDao(); //Check userDao
		
		User aUser = dao.selectUserbyUsername(user); //Check UserDao method selectUserbyUsername
		if(aUser != null) {
			if(aUser.getUsername().equals(user.getUsername() )
					&& aUser.getPass().equals(user.getPass())) {
				return aUser;
			}
		}		
		return null;		
	}
	
	public UserDTO convertToUserDTO(User user, Reimbursement reim) {
		
		return new UserDTO(user.getId(), user.getUsername(), user.getFirstname(), user.getLastname(), user.getEmail(), reim.getRid(), reim.getRamount());
	}
	
public UserDTO convertToUserDTO(User user) {
		
		return new UserDTO(user.getId(), user.getUsername(), user.getFirstname(), user.getLastname(), user.getEmail());
	}
	
	public User getInfoByUsername(User user) {
		return new UserDao().selectUserbyUsername(user);
	}
	
	//Method to retrieve Reimbursement status will probably go here.
	
	//Use ABP AppService lines 33-35 for reference
}
