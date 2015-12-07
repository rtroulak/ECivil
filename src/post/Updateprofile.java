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

public class Updateprofile extends HttpServlet {
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
	        	Connection con = DBConnection.getConnection();
				Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
				ResultSet rs = stmt.executeQuery("SELECT * FROM member");
				
				String emailmember = request.getParameter("email");
				out.println("<form method='post' action='./post.Profile'>\n");
				out.println("<input type='hidden' name='mail' value="+emailmember+">");
				out.println("<input type='submit' value='Profile'>");
				out.println("</form>");
				out.println("</BODY></HTML>");
				while (rs.next()) {
					String email = rs.getString("email");
					if(email.equals(emailmember)){
						if(request.getParameter("password") != ""){
							rs.updateString( "password", request.getParameter("password"));
				            rs.updateRow();
						}
						if(request.getParameter("TEL_MOBILE") != ""){
							rs.updateString( "TEL_MOBILE", request.getParameter("TEL_MOBILE"));
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
						if(request.getParameter("birthDate") != ""){
							rs.updateString( "birthDate", request.getParameter("birthDate"));
				            rs.updateRow();
						}
						if(request.getParameter("gender") != ""){
							rs.updateString( "gender", request.getParameter("gender"));
				            rs.updateRow();
						}
						if(request.getParameter("country") != ""){
							rs.updateString( "country", request.getParameter("country"));
				            rs.updateRow();
						}
						if(request.getParameter("city") != ""){
							rs.updateString( "city", request.getParameter("city"));
				            rs.updateRow();
						}
						if(request.getParameter("job") != ""){
							rs.updateString( "job", request.getParameter("job"));
				            rs.updateRow();
						}
						if(request.getParameter("address") != ""){
							rs.updateString( "address", request.getParameter("address"));
				            rs.updateRow();
						}
						if(request.getParameter("HAS_DRIVING_LICENCE_CAR") != ""){
							rs.updateString( "HAS_DRIVING_LICENCE_CAR", request.getParameter("HAS_DRIVING_LICENCE_CAR"));
				            rs.updateRow();
						}
						if(request.getParameter("HAS_DRIVING_LICENCE_BIKE") != ""){
							rs.updateString( "HAS_DRIVING_LICENCE_BIKE", request.getParameter("HAS_DRIVING_LICENCE_BIKE"));
				            rs.updateRow();
						}
						if(request.getParameter("HAS_DRIVING_LICENCE_TRUCK") != ""){
							rs.updateString( "HAS_DRIVING_LICENCE_TRUCK", request.getParameter("HAS_DRIVING_LICENCE_TRUCK"));
				            rs.updateRow();
						}
						if(request.getParameter("HAS_DRIVING_LICENCE_BOAT") != ""){
							rs.updateString( "HAS_DRIVING_LICENCE_BOAT", request.getParameter("HAS_DRIVING_LICENCE_BOAT"));
				            rs.updateRow();
						}
						if(request.getParameter("HAS_CAR") != ""){
							rs.updateString( "HAS_CAR", request.getParameter("HAS_CAR"));
				            rs.updateRow();
						}
						if(request.getParameter("HAS_BIKE") != ""){
							rs.updateString( "HAS_BIKE", request.getParameter("HAS_BIKE"));
				            rs.updateRow();
						}
						if(request.getParameter("HAS_TRUCK") != ""){
							rs.updateString( "HAS_TRUCK", request.getParameter("HAS_TRUCK"));
				            rs.updateRow();
						}
						if(request.getParameter("HAS_BOAT") != ""){
							rs.updateString( "HAS_BOAT", request.getParameter("HAS_BOAT"));
				            rs.updateRow();
						}
						if(request.getParameter("BLOOD_TYPE") != ""){
							rs.updateString( "BLOOD_TYPE", request.getParameter("BLOOD_TYPE"));
				            rs.updateRow();
						}
						if(request.getParameter("CERTIFICATES") != ""){
							rs.updateString( "CERTIFICATES", request.getParameter("CERTIFICATES"));
				            rs.updateRow();
						}
						if(request.getParameter("VOLUNTEER_TEAM_ID") != ""){
							rs.updateString( "VOLUNTEER_TEAM_ID", request.getParameter("VOLUNTEER_TEAM_ID"));
				            rs.updateRow();
						}
						if(request.getParameter("VOLUNTEER_DESIRE") != ""){
							rs.updateString( "VOLUNTEER_DESIRE", request.getParameter("VOLUNTEER_DESIRE"));
				            rs.updateRow();
						}
						if(request.getParameter("PHOTO_PATH") != ""){
							rs.updateString( "PHOTO_PATH", request.getParameter("PHOTO_PATH"));
				            rs.updateRow();
						}
						if(request.getParameter("info") != ""){
							rs.updateString( "info", request.getParameter("info"));
				            rs.updateRow();
						}
						if(request.getParameter("facebook") != ""){
							rs.updateString( "facebook", request.getParameter("facebook"));
				            rs.updateRow();
						}
						if(request.getParameter("skype") != ""){
							rs.updateString( "skype", request.getParameter("skype"));
				            rs.updateRow();
						}
						if(request.getParameter("gmail") != ""){
							rs.updateString( "gmail", request.getParameter("gmail"));
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
