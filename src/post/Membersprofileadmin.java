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

public class Membersprofileadmin extends HttpServlet {
	public void doGet(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			String docType =
				"<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
				"Transitional//EN\">\n";
				String title = "View Member";
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
	        	Connection con = DBConnection.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM member");
				
				String emailmember = request.getParameter("mail");
				while (rs.next()) {
					String email = rs.getString("email");
					if(email.equals(emailmember) ){
						out.print("<TR><TD> E-mail \n<TD>"+ rs.getString("email"));
						out.print("<TR><TD> Cellphone Number \n<TD>"+ rs.getString("TEL_MOBILE"));
						out.print("<TR><TD> Phone Number \n<TD>"+ rs.getString("TEL_HOME"));
						out.print("<TR><TD> Firstname \n<TD>"+ rs.getString("firstname"));
						out.print("<TR><TD> Lastname \n<TD>"+ rs.getString("lastname"));
						out.print("<TR><TD> Date of Birth \n<TD>"+ rs.getString("birthDate"));
						out.print("<TR><TD> Sex \n<TD>"+ rs.getString("gender"));
						out.print("<TR><TD> Country \n<TD>"+ rs.getString("country"));
						out.print("<TR><TD> City \n<TD>"+ rs.getString("city"));
						out.print("<TR><TD> Job \n<TD>"+ rs.getString("job"));
						out.print("<TR><TD> Address \n<TD>"+ rs.getString("address"));
						out.print("<TR><TD> hasDrivingLicenceCar \n<TD>"+ rs.getString("HAS_DRIVING_LICENCE_CAR"));
						out.print("<TR><TD> hasDrivingLicenceBike \n<TD>"+ rs.getString("HAS_DRIVING_LICENCE_BIKE"));
						out.print("<TR><TD> hasDrivingLicenceTruck \n<TD>"+ rs.getString("HAS_DRIVING_LICENCE_TRUCK"));
						out.print("<TR><TD> hasDrivingLicenceBoat \n<TD>"+ rs.getString("HAS_DRIVING_LICENCE_BOAT"));
						out.print("<TR><TD> hasCar \n<TD>"+ rs.getString("HAS_CAR"));
						out.print("<TR><TD> hasBike \n<TD>"+ rs.getString("HAS_BIKE"));
						out.print("<TR><TD> hasTruck \n<TD>"+ rs.getString("HAS_TRUCK"));
						out.print("<TR><TD> hasBoat \n<TD>"+ rs.getString("HAS_BOAT"));
						out.print("<TR><TD> bloodType \n<TD>"+ rs.getString("BLOOD_TYPE"));
						out.print("<TR><TD> certificates \n<TD>"+ rs.getString("CERTIFICATES"));
						out.print("<TR><TD> volunteerTeamID \n<TD>"+ rs.getString("VOLUNTEER_TEAM_ID"));
						out.print("<TR><TD> volunteerDesire \n<TD>"+ rs.getString("VOLUNTEER_DESIRE"));
						out.print("<TR><TD> photoPath \n<TD>"+ rs.getString("PHOTO_PATH"));
						out.print("<TR><TD> info \n<TD>"+ rs.getString("info"));
						out.print("<TR><TD> facebook \n<TD>"+ rs.getString("facebook"));
						out.print("<TR><TD> skype \n<TD>"+ rs.getString("skype"));
						out.print("<TR><TD> gmail \n<TD>"+ rs.getString("gmail"));
						
						out.println("</TABLE>\n");
						
					}
				}
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
	

