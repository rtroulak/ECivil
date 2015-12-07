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

public class Updateprofileadmin extends HttpServlet {
	public void doGet(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			String docType =
				"<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
				"Transitional//EN\">\n";
				String title = "Your Profile Updated Successfully";
				out.println(docType +
				"<HTML>\n" +
				"<HEAD><TITLE>"+title + "</TITLE></HEAD>\n"+
				"<BODY style='background-color:black;color:white;text-align:center'>\n" +
				"<H1 ALIGN=CENTER>" + title + "</H1>\n");
			try {
	        	Connection con = DBConnectionAdmin.getConnection();
				Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
				
				HttpSession session = request.getSession(true);
				String m = (String) session.getAttribute("email");

				ResultSet rs = stmt.executeQuery("SELECT * FROM admin");
				
				
				out.println("<form method='post' action='./post.Profileadmin'>\n");
				out.println("<input type='hidden' name='mail' value="+m+">");
				out.println("<input type='submit' value='Profile'>");
				out.println("</form>");
				out.println("</BODY></HTML>");
				while (rs.next()) {
					String email = rs.getString("email");
					if(email.equals(m)){
						if(request.getParameter("password") != ""){
							rs.updateString( "password", request.getParameter("password"));
				            rs.updateRow();
						}
						
						if(request.getParameter("firstname") != ""){
							rs.updateString( "firstname", request.getParameter("firstname"));
				            rs.updateRow();
						}
						if(request.getParameter("lastname") != ""){
							rs.updateString( "lastname", request.getParameter("lastname"));
				            rs.updateRow();
						}
						
						return;
					}
				}
				
				stmt.close();
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
