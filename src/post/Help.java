/**
* 
* @author  Troulakis Georgios Rafail , Kleftogiorgos Konst/ntinos <rtroulak@gmail.com> , <kleftog@csd.uoc.gr>
* @version 1.0
* @since   2013-06-01 
*/
package post;

import post.Member;
import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class Help extends HttpServlet {
	public void doGet(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			String docType =
					"<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
							"Transitional//EN\">\n";
							String title = "Help";
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
									
								"a.sel:link,a.sel:visited" +
								"{" +
									"display:block;" +
									"font-weight:bold;" +
									"font-size:200%;" +
									"color:#FFFFFF;" +
									"background-color:#556B2F;" +
									"text-align:center;" +
									"padding:4px;" +
									"text-decoration:none;" +
									"text-transform:uppercase;" +
									"border: 1px solid black;"+
									"padding:25px"+
								"}" +
								"a.sel:hover,a.sel:active" +
								"{" +
									"background-color:#556B2F;" +
								"}" +
									
								"</style>"+
							"</HEAD>\n"+
									"<body style='background-color:black;color:white;' >\n");
			try {
	        	Connection con = DBConnection.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM member");
				
				HttpSession session = request.getSession(true);
				String emailmember = (String) session.getAttribute("mail");
				
				out.println("<ul>");
				out.println("<li><a href='http://localhost:8083/TestProject/main.html'>New Event</a></li>");
				out.println("<li><a href='post.Eventlist'>Events</a></li>");
				out.println("<li><a href='post.Myeventlist'>My Events</a></li>");
				out.println("<li><a href='post.Memberslist'>Members</a></li>");
				out.println("<li><a href='post.Profile'>Profile</a></li>");
				out.println("<li><a class='sel' href='post.Help'>Help</a></li>");
				out.println("</ul>");
				
				out.println("Yo nigga");
				
				out.println("</BODY></HTML>");
				
				
			}
				catch (SQLException | ClassNotFoundException e1) {
				e1.printStackTrace();
			}
			
}
	
	public void doPost(HttpServletRequest request,
	HttpServletResponse response)
	throws ServletException, IOException {
			doGet(request, response);
	}
	
	
	}
	

