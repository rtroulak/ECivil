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

public class MainAdmin extends HttpServlet {
	public void doGet(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {
		  String userAgent = request.getHeader("user-agent");
		  if (userAgent.matches(".*Android.*"))
		  {
			  int flag=0;
			  try {
		        	Connection con = DBConnectionAdmin.getConnection();
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery("SELECT email,password FROM admin");
					
					String emailmember = request.getParameter("mail");
					String passwordmember = request.getParameter("pass");
					while (rs.next()) {
						String email = rs.getString("email");
						String password = rs.getString("password");
						if(email.equals(emailmember) && password.equals(passwordmember)){
							flag=1;//success in login
							break;
						}
					}
					
					/*if(request.getParameter("remember")!=null ){
						if( request.getParameter("remember").equals("yes") ){
										Cookie c1 = new Cookie("email", emailmember);
										c1.setMaxAge(60*60*24*365); 
										response.addCookie(c1);
										Cookie c2 = new Cookie("password", passwordmember);
										c2.setMaxAge(60*60*24*365); 
										response.addCookie(c2);
						
						}
					}
					else{
						Cookie[] cookies = request.getCookies();
						if (cookies != null) {
							for(Cookie cookie: cookies) {
								if(cookie.getName().equals("email")){
									cookie.setMaxAge(0);
									response.addCookie(cookie);
								}
								else if(cookie.getName().equals("password")){
									cookie.setMaxAge(0);
									response.addCookie(cookie);
								}
							}
						}
						
					}*/
				
				}
			catch (SQLException | ClassNotFoundException e1) {
					e1.printStackTrace();
			}
			  	if(flag == 1){
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
							String title = "Wrong password or E-mail.Please try again.";
							out.println(docType +
							"<HTML>\n" +
							"<HEAD><TITLE>"+title +"</TITLE></HEAD>\n"+
									"<BODY BGCOLOR=\"#FDF5E6\" ><H1 ALIGN=CENTER>" + title + "</H1>\n</BODY></HTML>");
			  	}
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
				

			out.println("<ul>");
			out.println("<li><a href='http://localhost:8083/TestProject/main.html'>New Event!!</a></li>");
			out.println("<li><a href='post.Eventlist'>Events</a></li>");
			out.println("<li><a href='post.Myeventlist'>My Events</a></li>");
			out.println("<li><a href='post.Memberslist'>Members</a></li>");
			out.println("<li><a href='post.Profile'>Profile</a></li>");
			out.println("<li><a href='post.Help'>Help</a></li>");
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
