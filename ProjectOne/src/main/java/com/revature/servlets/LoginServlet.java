package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.model.User;
import com.revature.service.ValidateService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("LoginServlet -GET");
		req.getRequestDispatcher("EmployeeLogin.html").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("LoginServlet -POST");

		User employeeUser = new User();

		String username = req.getParameter("e_username");
		String password = req.getParameter("e_password");

		employeeUser.setUsername(username);
		employeeUser.setPass(password);

		employeeUser = new ValidateService().validateUser(employeeUser);
		
		System.out.println("User enter: " + username + " & " + password);
		if(employeeUser != null) {
			System.out.println("Testing");
			HttpSession session = req.getSession();
			
			session.setAttribute("user", employeeUser);
			
			req.getRequestDispatcher("EmployeeHomepage.html").forward(req, resp);			
		} else {
			System.err.println("Invalid login information, sending user back to login page");
			resp.sendRedirect("EmployeeLogin.html");			
		}		
	}
}
