package com.revature.dao;
import java.util.List;

import com.revature.model.User;

public interface UserDaoContract {

	
	//CREATE
public int insertUser(User u);

	//READ
public List<User> selectAllUser();
public User selectUserbyPassword(String password, String email);
public User selectUserbyUsername(User user);

	//UPDATE
public int updateUser(User u);

	//DELETE	
public int deleteUser(User u);

}

	

