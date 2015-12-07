/**
* 
* @author  Troulakis Georgios Rafail , Kleftogiorgos Konst/ntinos <rtroulak@gmail.com> , <kleftog@csd.uoc.gr>
* @version 1.0
* @since   2013-06-01 
*/
package post;

import java.io.*; 
import java.sql.*;
import java.util.Random;

import javax.servlet.*;
import javax.servlet.http.*;

public class Eventprofile extends HttpServlet {
	public void doGet(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			String docType =
				"<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
				"Transitional//EN\">\n";
				String title = "Events";
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
						out.println("<li><a href='http://localhost:8083/TestProject/main.html'>New Event</a></li>");
						out.println("<li><a class='sel' href='post.Eventlist'>Events</a></li>");
						out.println("<li><a href='post.Myeventlist'>My Events</a></li>");
						out.println("<li><a href='post.Memberslist'>Members</a></li>");
						out.println("<li><a href='post.Profile'>Profile</a></li>");
						out.println("<li><a href='post.Help'>Help</a></li>");
						out.println("</ul>");
						
						out.println("<TABLE BORDER=1 ALIGN=CENTER>\n" +
				"<TR BGCOLOR=\"black\">\n" +
				"<TH><TH>");
			try {
				Connection con = DBConnectionEvent.getConnection();
				Statement stmt = con.createStatement();

				
				ResultSet rs = stmt.executeQuery("SELECT * FROM event");
				
				String eventm = request.getParameter("event");
				
				while (rs.next()) {
					String event = rs.getString("event_name");
					
					if(event.equals(eventm) ){
						
						out.print("<TR><TD> author \n<TD>"+ rs.getString("author"));
						out.print("<TR><TD> Event Time \n<TD>"+ rs.getString("time"));
						out.print("<TR><TD> Event Date \n<TD>"+ rs.getString("eventDate"));
						out.print("<TR><TD> description \n<TD>"+ rs.getString("description"));
						out.print("<TR><TD> photoPath \n<TD>"+ rs.getString("photo_path"));
						out.print("<TR><TD> recPath \n<TD>"+ rs.getString("rec_path"));
						out.print("<TR><TD> videoPath \n<TD>"+ rs.getString("video_path"));
						out.print("<TR><TD> volunteerNotified \n<TD>"+ rs.getString("volunteer_Notified"));
						out.print("<TR><TD> assistingOperators \n<TD>"+ rs.getString("assisting_Operators"));
						out.print("<TR><TD> volunteerInterested \n<TD>"+ rs.getString("volunteer_Interested"));
						out.print("<TR><TD> volunteerPresent \n<TD>"+ rs.getString("volunteer_Present"));
						out.print("<TR><TD> dlocation \n<TD>"+ rs.getString("desc_location"));
						out.print("<TR><TD> clocation \n<TD>"+ rs.getString("coor_location"));
						out.print("<TR><TD> olocation \n<TD>"+ rs.getString("other_location"));
					
						out.println("</TABLE>\n");
					}
				}
				out.println("</TABLE>\n");
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
	


