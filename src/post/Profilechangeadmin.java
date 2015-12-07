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

public class Profilechangeadmin extends HttpServlet {
	public void doGet(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			String docType =
				"<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
				"Transitional//EN\">\n";
				String title = "Profile";
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
								"background-color:red;" +
								"text-align:center;" +
								"padding:4px;" +
								"text-decoration:none;" +
								"text-transform:uppercase;" +
								"border: 1px solid black;"+
								"padding:25px"+
							"}" +
							"a.sel:hover,a.sel:active" +
							"{" +
								"background-color:red;" +
							"}" +
								
							"</style>"+
						"</HEAD>\n"+
								"<body style='background-color:black;color:white;' >\n");
				
				out.println("<ul>");
				out.println("<li><a href='post.Postsigninadmin'>Home[A]</a></li>");
				out.println("<li><a href='post.Eventlistadmin'>Events[A]</a></li>");
				out.println("<li><a href='post.Memberslistadmin'>Members[A]</a></li>");
				out.println("<li><a href='post.Profileadmin'>Profile[A]</a></li>");
				out.println("</ul>");
				
				out.println("<TABLE BORDER=1 ALIGN=CENTER>\n" +
				"<TR BGCOLOR=\"black\">\n" +
				"<TH><TH>");
			try {
	        	Connection con = DBConnectionAdmin.getConnection();
				Statement stmt = con.createStatement();
				HttpSession session = request.getSession(true);
				String m = (String) session.getAttribute("email");

				
				
				ResultSet rs = stmt.executeQuery("SELECT * FROM admin");
				
				
				while (rs.next()) {
					String email = rs.getString("email");
					out.println("<form method='post' action='./post.Updateprofileadmin'>");
					if(email.equals(m) ){
						out.print("<TR><TD> E-mail \n<TD>"+ rs.getString("email")+"<TD>");
							out.println("<input type='hidden' name='email' value="+m+">");
						out.print("<TR><TD> Password \n<TD>"+ rs.getString("password")+"<TD>");
							out.println("<input type='text' name='password' >");
						out.print("<TR><TD> Firstname \n<TD>"+ rs.getString("firstname")+"<TD>");
							out.println("<input type='text' name='firstname' >");
						out.print("<TR><TD> Lastname \n<TD>"+ rs.getString("lastname")+"<TD>");
							out.println("<input type='text' name='lastname' >");
						
						out.println("</TABLE>\n");
						out.println("<input type='submit' value='Submit Changes'>");
						out.println("</form>");
					}
				}
				out.println("</BODY></HTML>");
				
				con.close();
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
	

