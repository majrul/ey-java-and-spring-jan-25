package com.training.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet(urlPatterns = "/hello2", loadOnStartup = 102) //url pattern
public class HelloServlet2 extends HttpServlet {

	@Override
	public void init() throws ServletException {
		System.out.println("init called of HelloServlet2..");
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet called..");
		
		PrintWriter out = response.getWriter();		
		out.write("<html><body>");
		out.write("<h1>Welcome to Servlet</h1>");
		out.write("<h2>Requested URL " + request.getRequestURL() + "</h2>");
		out.write("<h2>Today's Date " + LocalDate.now() + "</h2>");
		out.write("</body></html>");
	}

	@Override
	public void destroy() {
		System.out.println("destroy called..");
	}
}
