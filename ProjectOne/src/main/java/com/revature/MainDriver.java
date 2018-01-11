package com.revature;

import com.revature.model.User;
import com.revature.service.UserService;
import com.revature.service.UserServiceContract;

public class MainDriver {
	static User currentUser = null;
	
	public static void main(String[] args) {
		UserServiceContract userService = new UserService();
		
currentUser = userService.selectUserByPassword("1234", "drobin897email");
System.out.println(currentUser); 


		
	}
}
