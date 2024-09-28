package com.nt.servelt;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/weburl")
public class WishMessageOperations extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 	     //set response content type
		    resp.setContentType("text/html");
		    //get pdf writer
		    PrintWriter pw=resp.getWriter();
		    //set response
		    pw.write("<h1 style='color:red;text-align:center'>Hello,Good Morning</h1><br><br>");
		    //set home page
		    pw.write("<a href='index.jsp'>GoToHome</a>");
		    //close print writer
		    pw.close();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
      doGet(req, resp);
	}

}
