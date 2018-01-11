package com.revature.servlets;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.User;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public UpdateServlet() {
		super();
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("UpdateServlet -POST");
		
		Map<String, String[]> myMap = request.getParameterMap();
		Set<String> updateObject = myMap.keySet(); 
		Object obj = updateObject.toArray()[0];
		ObjectMapper jackson = new ObjectMapper();
		
		User ui = jackson.readValue(((String)obj), User.class);
		System.out.println(ui);
		
		HttpSession session = request.getSession();
		User employeeUser = (User) session.getAttribute("user");
		System.out.println("New username is: " + employeeUser.getUsername());
		
		//Using AjaxProcessTxServlet for reference! Still need to work on Dao method for updating (almost done),
		//... this servlet(pretty much done), and the javascript/HTML (haven't started) to allow for passing info from the HTML all the way
		//... down to SQL. For HTML/Js, use pokemonAjax and Pokemon.js for reference?
		
	}
	

}
