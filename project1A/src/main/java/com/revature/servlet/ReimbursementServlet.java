package com.revature.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Reimbursement;
import com.revature.services.ReimbursementService;
import com.revature.util.CorsFix;

/**
 * Servlet implementation class ReimbursementServlet
 */
public class ReimbursementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReimbursementService rs = new ReimbursementService();
	private ObjectMapper om = new ObjectMapper();
 
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CorsFix.addCorsHeader(req.getRequestURI(), resp);
		resp.addHeader("Content-Type", "application/json");
		HttpSession session = req.getSession();
		String pathInfo = req.getPathInfo();
		
		List<Reimbursement> testing = rs.getReimbursements();
		PrintWriter testWriter = resp.getWriter();
		testWriter.write(om.writeValueAsString(testing));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CorsFix.addCorsHeader(req.getRequestURI(), resp);
		resp.addHeader("Content-Type", "application/json");
		//HttpSession session = req.getSession();
		String pathInfo = req.getPathInfo();
		InputStream reqBody = req.getInputStream();
		Reimbursement newReimb = om.readValue(reqBody, Reimbursement.class);
		
		rs.createreimbursement(newReimb);
		resp.setStatus(201);
		
		
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPut(req, resp);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doDelete(req, resp);
	}
	
	

}
