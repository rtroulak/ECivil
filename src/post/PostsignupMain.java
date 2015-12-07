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

public class PostsignupMain extends HttpServlet {
	public void doGet(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			String docType =
				"<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
				"Transitional//EN\">\n";
				String title = "Your Sign Up was successful";
				out.println(docType +
				"<HTML>\n" +
				"<HEAD><TITLE>"+title + "</TITLE></HEAD>\n"+
				"<BODY BGCOLOR=\"#FDF5E6\">\n" +
				"<H1 ALIGN=CENTER>" + title + "</H1>\n" +
				"<TABLE BORDER=1 ALIGN=CENTER>\n" +
				"<TR BGCOLOR=\"#FFAD00\">\n" +
				"<TH><TH>");
			try {
	        	Connection con = DBConnection.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT email FROM member");
				
				String emailmember = request.getParameter("mail");
				while (rs.next()) {
					String email = rs.getString("email");
					if(email.equals(emailmember)){
						out.print("<script>alert('This Email is already in use');\n"+"location = 'javascript:history.back()';</script>");
						return;
					}
				} 
			}
				catch (SQLException | ClassNotFoundException e1) {
				e1.printStackTrace();
			}
			Member m = new Member(request.getParameter("mail"),request.getParameter("pass"), request.getParameter("firstName"), request.getParameter("lastName"),request.getParameter("year")+"-"+request.getParameter("month")+"-"+request.getParameter("day"), request.getParameter("cellphone"));
			m.setBloodType(BloodType.UNKNOWN);
			if(request.getParameter("radios") != null) {
                if(request.getParameter("radios").equals("unknown")) {
                	m.setGender(Gender.UNKNOWN);
                }
                if(request.getParameter("radios").equals("male")) {
                	m.setGender(Gender.MALE);
                }
                if(request.getParameter("radios").equals("female")) {
                	m.setGender(Gender.FEMALE);
                }
            }
			try {
				m.addInDatabase();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

						out.print("<TR><TD> E-mail \n<TD>"+ request.getParameter("mail"));
						out.print("<TR><TD> Password \n<TD>"+ request.getParameter("pass"));
						out.print("<TR><TD> Cellphone Number \n<TD>"+ request.getParameter("cellphone"));
						out.print("<TR><TD> Phone Number \n<TD>"+ request.getParameter("phone"));
						out.print("<TR><TD> Firstname \n<TD>"+ request.getParameter("firstName"));
						out.print("<TR><TD> Lastname \n<TD>"+ request.getParameter("lastName"));
						out.print("<TR><TD> Date of Birth \n<TD>"+ request.getParameter("day")+"-"+request.getParameter("month")+"-"+request.getParameter("year"));
						out.print("<TR><TD> Sex \n<TD>"+ request.getParameter("radios"));
						out.print("<TR><TD> Country \n<TD>"+ request.getParameter("country"));
						out.print("<TR><TD> City \n<TD>"+ request.getParameter("city"));
						out.println("</TABLE>\n</BODY></HTML>");
			}
	
	public void doPost(HttpServletRequest request,
	HttpServletResponse response)
	throws ServletException, IOException {
			doGet(request, response);
	}
}
