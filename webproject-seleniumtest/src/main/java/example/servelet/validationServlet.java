   package example.servelet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import example.bean.User;
import example.bean.UserValidation;

/**
 * Servlet implementation class validationServlet
 */
@WebServlet(name = "validation", urlPatterns = { "/validationhtml" })//use this url in forn tag in html file
public class validationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		//fetching request specific parameter ie uid and pwd
		//this is done  by using String getParameter() of httpservlet
		
		String currentUserName=request.getParameter("uid");
		String currentPassword=request.getParameter("pwd");
		
		//populating an object of type User class
		
		User currentuser=new User(currentUserName,currentPassword);
		
		//passing object to user validator to check validity
		
		boolean valid=UserValidation.isValid(currentuser);
		if(valid)
			out.write("<h1>Welocome to my world website</h1>");
		else
			out.print("<h1>incorrect credentials</h1>");
				
				//out.println("<h1>...</h1>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
