package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dtos.UserDTO;
import com.revature.exceptions.LoginException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;
import com.revature.services.AuthService;
import com.revature.util.CorsFix;


public class AuthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AuthService as = new AuthService();
	private ObjectMapper om = new ObjectMapper();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		CorsFix.addCorsHeader(req.getRequestURI(), resp);
		
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		 try {
			 	User principal = as.login(username, password);
			 	
			 	HttpSession session = req.getSession();
			 	session.setAttribute("userId", principal.getId());
			 	session.setAttribute("usserRole", principal.getRole());
			 	
			 	//To make Chrome work with our cookie
			 	String cookie = resp.getHeader("Set-Cookie") + "; SameSite=None; Secure";
				resp.setHeader("Set-Cookie", cookie);
			 	
				
				UserDTO principalDTO = new UserDTO(principal);
				try(PrintWriter pw = resp.getWriter()){
					
					pw.write(om.writeValueAsString(principalDTO));
					resp.setStatus(200);
				
				}
				
		 	}catch ( UserNotFoundException | LoginException e) {
					
		 		resp.sendError(400, "Unable to login.");
		 	}
			 	
		
		}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CorsFix.addCorsHeader(req.getRequestURI(), resp);

		HttpSession session = req.getSession();

		session.invalidate();
	}

	
	
	@Override
	protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CorsFix.addCorsHeader(req.getRequestURI(), resp);
		super.doOptions(req, resp);
	}

}