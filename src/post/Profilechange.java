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

public class Profilechange extends HttpServlet {
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
				out.println("<li><a href='http://localhost:8083/TestProject/main.html'>New Event</a></li>");
				out.println("<li><a href='post.Eventlist'>Events</a></li>");
				out.println("<li><a href='post.Myeventlist'>My Events</a></li>");
				out.println("<li><a href='post.Memberslist'>Members</a></li>");
				out.println("<li><a class='sel' href='post.Profile'>Profile</a></li>");
				out.println("<li><a href='post.Help'>Help</a></li>");
				out.println("</ul>");
				
				out.println("<TABLE BORDER=1 ALIGN=CENTER>\n" +
				"<TR BGCOLOR=\"black\">\n" +
				"<TH><TH>");
			try {
	        	Connection con = DBConnection.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM member");
				
				HttpSession session = request.getSession(true);
				String emailmember = (String) session.getAttribute("mail");
				
				while (rs.next()) {
					String email = rs.getString("email");
					out.println("<form method='post' action='./post.Updateprofile'>");
					if(email.equals(emailmember) ){
						out.print("<TR><TD> E-mail \n<TD>"+ rs.getString("email")+"<TD>");
							out.println("<input type='hidden' name='email' value="+emailmember+">");
						out.print("<TR><TD> Password \n<TD>"+ rs.getString("password")+"<TD>");
							out.println("<input type='text' name='password' >");
						out.print("<TR><TD> Cellphone Number \n<TD>"+ rs.getString("TEL_MOBILE")+"<TD>");
							out.println("<input type='text' name='TEL_MOBILE' >");
						out.print("<TR><TD> Phone Number \n<TD>"+ rs.getString("TEL_HOME")+"<TD>");
							out.println("<input type='text' name='TEL_HOME' >");
						out.print("<TR><TD> Firstname \n<TD>"+ rs.getString("firstname")+"<TD>");
							out.println("<input type='text' name='firstname' >");
						out.print("<TR><TD> Lastname \n<TD>"+ rs.getString("lastname")+"<TD>");
							out.println("<input type='text' name='lastname' >");
						out.print("<TR><TD> Date of Birth \n<TD>"+ rs.getString("birthDate")+"<TD>");
							out.println("<input type='text' name='birthDate' >");
						out.print("<TR><TD> Sex \n<TD>"+ rs.getString("gender")+"<TD>");
							out.println("<input type='text' name='gender' >");
						out.print("<TR><TD> Country \n<TD>"+ rs.getString("country")+"<TD>");
							out.println("<input type='text' name='country' >");
						out.print("<TR><TD> City \n<TD>"+ rs.getString("city")+"<TD>");
							out.println("<input type='text' name='city' >");
						out.print("<TR><TD> Job \n<TD>"+ rs.getString("job")+"<TD>");
							out.println("<input type='text' name='job' >");
						out.print("<TR><TD> Address \n<TD>"+ rs.getString("address")+"<TD>");
							out.println("<input type='text' name='address' >");
						out.print("<TR><TD> hasDrivingLicenceCar \n<TD>"+ rs.getString("HAS_DRIVING_LICENCE_CAR")+"<TD>");
							out.println("<input type='text' name='HAS_DRIVING_LICENCE_CAR' >");
						out.print("<TR><TD> hasDrivingLicenceBike \n<TD>"+ rs.getString("HAS_DRIVING_LICENCE_BIKE")+"<TD>");
							out.println("<input type='text' name='HAS_DRIVING_LICENCE_BIKE' >");
						out.print("<TR><TD> hasDrivingLicenceTruck \n<TD>"+ rs.getString("HAS_DRIVING_LICENCE_TRUCK")+"<TD>");
							out.println("<input type='text' name='HAS_DRIVING_LICENCE_TRUCK' >");
						out.print("<TR><TD> hasDrivingLicenceBoat \n<TD>"+ rs.getString("HAS_DRIVING_LICENCE_BOAT")+"<TD>");
							out.println("<input type='text' name='HAS_DRIVING_LICENCE_BOAT' >");
						out.print("<TR><TD> hasCar \n<TD>"+ rs.getString("HAS_CAR")+"<TD>");
							out.println("<input type='text' name='HAS_CAR' >");
						out.print("<TR><TD> hasBike \n<TD>"+ rs.getString("HAS_BIKE")+"<TD>");
							out.println("<input type='text' name='HAS_BIKE' >");
						out.print("<TR><TD> hasTruck \n<TD>"+ rs.getString("HAS_TRUCK")+"<TD>");
							out.println("<input type='text' name='HAS_TRUCK' >");
						out.print("<TR><TD> hasBoat \n<TD>"+ rs.getString("HAS_BOAT")+"<TD>");
							out.println("<input type='text' name='HAS_BOAT' >");
						out.print("<TR><TD> bloodType \n<TD>"+ rs.getString("BLOOD_TYPE")+"<TD>");
							out.println("<input type='text' name='BLOOD_TYPE' >");
						out.print("<TR><TD> certificates \n<TD>"+ rs.getString("CERTIFICATES")+"<TD>");
							out.println("<input type='text' name='CERTIFICATES' >");
						out.print("<TR><TD> volunteerTeamID \n<TD>"+ rs.getString("VOLUNTEER_TEAM_ID")+"<TD>");
							out.println("<input type='text' name='VOLUNTEER_TEAM_ID' >");
						out.print("<TR><TD> volunteerDesire \n<TD>"+ rs.getString("VOLUNTEER_DESIRE")+"<TD>");
							out.println("<input type='text' name='VOLUNTEER_DESIRE' >");
						out.print("<TR><TD> photoPath \n<TD>"+ rs.getString("PHOTO_PATH")+"<TD>");
							out.println("<input type='text' name='PHOTO_PATH' >");
						out.print("<TR><TD> info \n<TD>"+ rs.getString("info")+"<TD>");
							out.println("<input type='text' name='info' >");
						out.print("<TR><TD> facebook \n<TD>"+ rs.getString("facebook")+"<TD>");
							out.println("<input type='text' name='facebook' >");
						out.print("<TR><TD> skype \n<TD>"+ rs.getString("skype")+"<TD>");
							out.println("<input type='text' name='skype' >");
						out.print("<TR><TD> gmail \n<TD>"+ rs.getString("gmail")+"<TD>");
							out.println("<input type='text' name='gmail' >");
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
	

