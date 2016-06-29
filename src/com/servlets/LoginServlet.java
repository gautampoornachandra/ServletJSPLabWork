package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.User;





/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user= new User();
		user.setName(request.getParameter("username"));
		
		
		String id = request.getParameter("username");
		String pass = request.getParameter("password");
		
		
	
		
		System.out.println("Name: "+user.getName());
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/home.jsp");
		request.setAttribute("user", user);
		
		
		if (id.equals("admin") && pass.equals("admin")) {
			
			Cookie name = new Cookie("name", id);
	        response.addCookie( name );
	        //out.println("<h2>" +"Welcome "+ id + "</h2>");
	        rd.forward(request,response);
	        //response.sendRedirect("home.jsp");
	        //response.sendRedirect("/JEEDemoProject/Dash/dashboard.html");
			
		} else {
			
			out.println("<h2>" +"Invalid username or Password!"+ "</h2>");
		}
		out.close();
	}
}
