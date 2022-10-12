package edu.kh.jsp.ex.controller;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/chickenOrder")
public class ChickenOrderServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	req.setCharacterEncoding("UTF-8");
	
	String aa = req.getParameter("aa");
	
	int amount = Integer.parseInt(req.getParameter("amount"));
	
	int total = 20000 + (2000*amount);
	
	RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/orderResult.jsp");
	
	
	
	}
}
