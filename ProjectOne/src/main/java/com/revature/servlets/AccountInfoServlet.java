package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dto.UserDTO;
import com.revature.model.Reimbursement;
import com.revature.model.User;
import com.revature.service.ValidateService;

@WebServlet("/accountInfo")
public class AccountInfoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public AccountInfoServlet() {
		super();
	}

	// Left off here, review this servlet and find out EXACTLY what it is doing
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("AccountInfoServlet -GET");
		
		//request.getRequestDispatcher("AccountInfo.html").forward(request, response);		

		ValidateService service = new ValidateService(); 
		HttpSession session = request.getSession();
		User sessionuser = (User) session.getAttribute("user");

		if (sessionuser != null) {
			User user = service.getInfoByUsername(sessionuser);			

			if (user != null) { /* Only half sure user is the needed object here */
				System.out.println("Converting user to DTO");
				UserDTO userDTO = service.convertToUserDTO(sessionuser); // find out how to add Reimbursement object here!

				System.out.println("JSON Mapping DTO");
				ObjectMapper mapper = new ObjectMapper(); // This requires the Jackson API's you built in the lib
															// ...Jackson API's parse Java Objects to JSON Objects and
															// vice-versa
				String json = mapper.writeValueAsString(userDTO);

				PrintWriter out = response.getWriter();
				response.setContentType("application/json");
				out.write(json);
			} else {
				response.setStatus(418);
			}
		} else {
			response.setStatus(418);
		}
		// AjaxBankInfoServlet is reference.
		// This Servlet didn't follow its reference to the letter,
		// .. it is missing a second block of code using "!=null).

	}
}
