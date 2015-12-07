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
import java.util.Random;

import javax.servlet.*;
import javax.servlet.http.*;

public class MessageSubmit extends HttpServlet {
	public void doGet(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {
			response.setContentType("text/html");
			String message = request.getParameter("message");
			PrintWriter out = response.getWriter();
			
			


			try {
				Connection con = DBConnectionEvent.getConnection();
				Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
				
				HttpSession session = request.getSession(true);
				String eventname=(String) session.getAttribute("eventname");
				
				ResultSet rs = stmt.executeQuery("SELECT * FROM event");
				
				while (rs.next()) {
					String event_name = rs.getString("event_name");
					if(eventname.equals(event_name)){
						rs.updateString( "description", message);
						rs.updateRow();
					}
				}
				con.close();
			} catch (SQLException | ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			out.println("<!DOCTYPE html>" +
					"<html>" +
					"<head>" +
					"<meta http-equiv='refresh' content='2; URL=./post.Option'>" +
					"</head>" +
					
					"<style>" +
					"a:link {color:black ;}    /* unvisited link */" +
					"a:visited {color:black ;} /* visited link */" +
					"a:hover {color:white;padding:5px;background-color:#200000 ;}   /* mouse over link */" +
					"a:active {color:#0000FF;}  /* selected link */" +
					"</style>" +
					"</head>" +
					
					"<body style='background-color:white;color:black;text-align:center;font-size:500%;margin-top:15%;'>" +
							"Description Updating." +
					"</body>" +
					"</html>");
			

	}
	
	public void doPost(HttpServletRequest request,
	HttpServletResponse response)
	throws ServletException, IOException {
			doGet(request, response);
	}
}
