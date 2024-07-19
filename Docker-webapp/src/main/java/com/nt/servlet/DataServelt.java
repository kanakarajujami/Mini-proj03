package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DataServelt
 */
@WebServlet("/dateurl")
public class DataServelt extends HttpServlet {
		public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//get PrintWriter class
		PrintWriter pw=response.getWriter();
		//set content type
		     response.setContentType("text/html");
		     //business logic
		     Date date=new Date();
		     pw.println("<h1 style='color:green;text-align:center'>Date and Time:"+date+"</h1>");
		     pw.println("<br><a href='index.jsp'>Home</a>");
		     pw.close();
		 
	}


	public  void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
