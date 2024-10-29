package com.nt;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/wishurl")
public class WishMessageController extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	              //create print writer object
		PrintWriter writer=response.getWriter();
		//set content type
		response.setContentType("html/text");
		writer.println("<h2 style='color:red,text-align:center,margin-top:350px;'>Hello,Good Morning to EveryOne</h2>");
		writer.println("<a a='wishurl'>GotoHome</a>");
		//close writer stream object;
		writer.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
