package edu.kh.project.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.project.main.model.service.MainService;

@WebServlet("/main")
public class MainServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		MainService service = new MainService();
		
		try {
			Map<Integer, String> boardTypeMap = service.selectBoardType();
			
//			application scope로 
//			key = "boardTypeMap"
//			value = boardTypeMap이 참조하는 객체를 속성으로 세팅
			ServletContext application = req.getServletContext();
			application.setAttribute("boardTypeMap", boardTypeMap);
			
					
			RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/views/common/main.jsp");
			
			dispatcher.forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
