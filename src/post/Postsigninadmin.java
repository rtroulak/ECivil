/**
* 
* @author  Troulakis Georgios Rafail , Kleftogiorgos Konst/ntinos <rtroulak@gmail.com> , <kleftog@csd.uoc.gr>
* @version 1.0
* @since   2013-06-01 
*/
package post;


import java.io.*; 
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;

import com.google.gson.Gson;

public class Postsigninadmin extends HttpServlet {
	public void doGet(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {
		  String userAgent = request.getHeader("user-agent");
		  if (userAgent.matches(".*Android.*"))
		  {
			 
					

			  	
					response.setContentType("text/html");
					PrintWriter out = response.getWriter();
					String docType =
			  		"<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
							"Transitional//EN\">\n";
							String title = "You Signed In Successfully";
							out.println(docType +
							"<HTML>\n" +
							"<HEAD>" +
							"<script type='text/javascript'>" +
							"function changeweb() {" +
							"   AndroidFunction.Second();" +
							"}" +
							"</script>" +
							"<TITLE>"+title +"</TITLE></HEAD>\n"+
									"<BODY BGCOLOR=\"#FDF5E6\" ><H1 ALIGN=CENTER>" + title + "</H1>\n" +
									"<button type='button' onclick=\"changeweb()\">Click Me!</button>"+
											"</BODY></HTML>");
							HttpSession session = request.getSession(true);
							String email=request.getParameter("mail");
							session.setAttribute("email", email);


		  }
		  else{
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			String docType =
				"<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
				"Transitional//EN\">\n";
				String title = "Main";
				out.println(docType +
				"<HTML>\n" +
				"<HEAD><TITLE>"+title +"</TITLE>" +
				"<style>" +
					"ul" +
					"{" +
						"list-style-type:none;" +
						"margin:0;" +
						"padding:0;" +
						"overflow:hidden;" +
					"}" +
						
					"li" +
					"{" +
						"float:left;" +
					"}" +
						
					"a:link,a:visited" +
					"{" +
						"display:block;" +
						"font-weight:bold;" +
						"font-size:200%;" +
						"color:#FFFFFF;" +
						"background-color:#98bf21;" +
						"text-align:center;" +
						"padding:4px;" +
						"text-decoration:none;" +
						"text-transform:uppercase;" +
						"border: 1px solid black;"+
						"padding:25px"+
					"}" +
					"a:hover,a:active" +
					"{" +
						"background-color:#7A991A;" +
					"}" +
						
					"</style>"+
				"</HEAD>\n"+
						"<body style='background-color:black' >\n");
				
			
					String emaila = request.getParameter("mail");
					
					String docTypea =
							"<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
							"Transitional//EN\">\n";
							out.println(docTypea +
									"<HTML>" +
									"<head>" +
									"<title>Welcome Administrator</title>" +
									"</head>" +
									"<body style='text-align:center;background-color:green;color:white;'>" +
									"<h2>Welcome Administrator</h2>" +
									"<form method='post' action='./post.Postsigninadmin'>"+
											
									"<b>Hello in Administrator Panel press the button to go in admins panel</b>"+ "<input type=submit value=AdminPanel><br>" +
									"</form>" +
									"</body>" +
									"</HTML>" +
									"");
					
					
				
				HttpSession session = request.getSession(true);
				session.setAttribute("mail", emaila);
				
				out.println("<ul>");
				
				out.println("<li><a href='post.Postsigninadmin'>Home[A]</a></li>");
				out.println("<li><a href='post.Eventlistadmin'>Events[A]</a></li>");
				out.println("<li><a href='post.Memberslistadmin'>Members[A]</a></li>");
				out.println("<li><a href='post.Profileadmin'>Profile[A]</a></li>");
				
				out.println("</ul>");
				out.println("</BODY></HTML>");
				
				
		  }
			
}
	
	public void doPost(HttpServletRequest request,
	HttpServletResponse response)
	throws ServletException, IOException {
			doGet(request, response);
	}
}
