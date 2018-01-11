package com.revature.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.revature.model.User;

public class UserDao implements UserDaoContract {
	
	private static String url = "jdbc:oracle:thin:@usfbdjava.cfowboymslww.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "user01";
	private static String password = "pass1234";
	
	static{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public int insertUser(User u) {
		return 0;
	}
	@Override
	public List<User> selectAllUser() {
		return null;
	}
	@Override
	public User selectUserbyPassword(String pass, String email) {
		System.out.println("Test 1");
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "SELECT * FROM ers_users WHERE u_password = ? AND u_email = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, pass);
			ps.setString(2, email);
			ResultSet rs = ps.executeQuery();
			System.out.println("Test 2");
			if (rs.next()) {
				return new User(rs.getInt("u_id"), rs.getString("u_username"), rs.getString("u_password"), rs.getString("u_firstname"), rs.getString("u_lastname"), rs.getString("u_email"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public User selectUserbyUsername(User user) {
		User aUser = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "SELECT * FROM ers_users WHERE u_username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				aUser = new User(rs.getInt("u_id"), rs.getString("u_username"), rs.getString("u_password"), rs.getString("u_firstname"), rs.getString("u_lastname"), rs.getString("u_email"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return aUser;
	}
	/*
	@Override
	public int updateUser(User user) {
		User aUser = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "UPDATE ers_users SET U_USERNAME= ? WHERE U_USERNAME=" + user.getUsername();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.toString()); //What the hell goes here?!
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				aUser = new User(rs.getInt("u_id"), rs.getString("u_username"), rs.getString("u_password"), rs.getString("u_firstname"), rs.getString("u_lastname"), rs.getString("u_email"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return aUser;
	}
	
	*/
	@Override
	public int deleteUser(User u) {
		return 0;
	}
	@Override
	public int updateUser(User u) { //Added so I can comment out the actual method above for the time being
		return 0;
	}
	
}
