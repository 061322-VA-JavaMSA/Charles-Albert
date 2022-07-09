package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dtos.UserDTO;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;
import com.revature.services.UserService;
import com.revature.util.CorsFix;

public class UserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private UserService us = new UserService();
	private ObjectMapper om = new ObjectMapper();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		// Specifying that the response content-type will be JSON
		CorsFix.addCorsHeader(req.getRequestURI(), res);
		res.addHeader("Content-Type", "application/json");

		
		String pathInfo = req.getPathInfo();

		// if pathInfo is null, the req should be to /users -> send back all users
		if (pathInfo == null) {

			HttpSession session = req.getSession();

			if (true) {
				// retrieving users from db using UserService
				List<User> users = us.getUsers();
				List<UserDTO> usersDTO = new ArrayList<>();

				// converting Users to UserDTOs for data transfer
				users.forEach(u -> usersDTO.add(new UserDTO(u)));

				// retrieving print writer to write to the Response body
				try (PrintWriter pw = res.getWriter();) {
					// writing toString representation of Users to body
					pw.write(om.writeValueAsString(usersDTO));
				}

			} else {
				res.sendError(401, "Unauthorized request.");
			}

		} else {

			// Have to remove "/" to get the id to be retrieved
			int id = Integer.parseInt(pathInfo.substring(1));

			try (PrintWriter pw = res.getWriter()) {
				// retrieve user by id
				User u = us.getUserById(id);
				UserDTO uDTO = new UserDTO(u);

				// convert user to JSON and write to response body
				pw.write(om.writeValueAsString(uDTO));

				res.setStatus(200);
			} catch (UserNotFoundException e) {
				res.setStatus(404);
				e.printStackTrace();
			}
		}
	}

	
}