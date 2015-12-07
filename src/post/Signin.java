/**
* 
* @author  Troulakis Georgios Rafail , Kleftogiorgos Konst/ntinos <rtroulak@gmail.com> , <kleftog@csd.uoc.gr>
* @version 1.0
* @since   2013-06-01 
*/
package post;

import post.Member;
import post.Admins;
import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class Signin extends HttpServlet {
	public void doGet(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			String email =
					CookieUtilities.getCookieValue(request, 
					"email", "");
			String password =
					CookieUtilities.getCookieValue(request, 
					"password", "");
			String docType =
				"<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
				"Transitional//EN\">\n";
				out.println(docType +
							"<HTML>" +
							"<head>" +
							"<title>Sign in</title>" +
							"</head>" +
							"<body style='text-align:center;background-color:black;color:white;'>" +
							"<h2>Sign In</h2>" +
							"<form method='post' action='./post.Postsignin'>" +
									
							"<b>E-mail:</b>" +
							"<input type='email' id='mail' name='mail' placeholder='user@mail.com' VALUE=\"" + email + "\" required><br>" +
							"<b>Password:</b>" +
							"<input type='password' id='pass' name='pass'  pattern='.{6,10}' maxlength='10' VALUE=\"" + password + "\" required><br>" +
							
							"<b>Remember Me</b>" +
							"<input type='checkbox' id='remember' name='remember' value='yes'><br>" +
							
							"<input type='submit' value='Sign In'>" +
							"</form>" +
							"</body>" +
							"</HTML>" +
							"");
				
			
}
	
	public void doPost(HttpServletRequest request,
	HttpServletResponse response)
	throws ServletException, IOException {
			doGet(request, response);
	}
	
	
	}
	

