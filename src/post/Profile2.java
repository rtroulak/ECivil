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

public class Profile2 extends HttpServlet {
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
				"<HEAD><TITLE>"+title + "</TITLE></HEAD>\n"+
				"<BODY BGCOLOR=\"#FDF5E6\" >\n" +
				"<H1 ALIGN=CENTER>" + title + "</H1>\n");
			try {
	        	Connection con = DBConnection.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM member");
				
				HttpSession session = request.getSession(true);
				String emailmember = (String)session.getAttribute("email");
				out.println("<h1 align=center><form method='post' action='./post.Profilechange'>\n");
				out.println("<input type='hidden' name='mail' value="+emailmember+">");
				out.println("<input type='submit' value='Change Profile'>");
				out.println("</form></h1>");
				out.println("<TABLE BORDER=1 ALIGN=CENTER>\n" +
				"<TR BGCOLOR=\"#FFAD00\">\n" +
				"<TH><TH>");
				while (rs.next()) {
					String email = rs.getString("email");
					if(email.equals(emailmember) ){
						out.print("<TR><TD> E-mail \n<TD>"+ rs.getString("email"));
						out.print("<TR><TD> Password \n<TD>"+ rs.getString("password"));
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
				out.println("<a href='post.Memberslist'>Members</a><br>");
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
	

