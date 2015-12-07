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

public class Postsignup extends HttpServlet {
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
			m.setAddress(request.getParameter("address"));
			if( new String(request.getParameter("blood")).equals("O+") )
				m.setBloodType(BloodType.O_PLUS);
			else if( new String(request.getParameter("blood")).equals("A+") )
				m.setBloodType(BloodType.A_PLUS);
			else if( new String(request.getParameter("blood")).equals("B+") )
				m.setBloodType(BloodType.B_PLUS);
			else if( new String(request.getParameter("blood")).equals("AB+") )
				m.setBloodType(BloodType.AB_PLUS);
			else if( new String(request.getParameter("blood")).equals("O-") )
				m.setBloodType(BloodType.O_MINUS);
			else if( new String(request.getParameter("blood")).equals("A-") )
				m.setBloodType(BloodType.A_MINUS);
			else if( new String(request.getParameter("blood")).equals("B-") )
				m.setBloodType(BloodType.B_MINUS);
			else if( new String(request.getParameter("blood")).equals("AB-") )
				m.setBloodType(BloodType.AB_MINUS);
			else if( new String(request.getParameter("blood")).equals("UNKNOWN") )
				m.setBloodType(BloodType.UNKNOWN);
			m.setCity(request.getParameter("city"));
			m.setCountry(request.getParameter("country"));
			String[] paramValues1 =request.getParameterValues("license");
			if( paramValues1 != null){
				for(int i=0; i<paramValues1.length; i++) {
					if( paramValues1[i].equals("car") )
						m.setHasDrivingLicenceCar(true);
					if( paramValues1[i].equals("motor") )
						m.setHasDrivingLicenceBike(true);
					if( paramValues1[i].equals("truck") )
						m.setHasDrivingLicenceTruck(true);
					if( paramValues1[i].equals("boat") )
						m.setHasDrivingLicenceBoat(true);
				}
			}
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
			m.setInfo(request.getParameter("info"));
			m.setJob(request.getParameter("job"));
			m.setPhotoPath(request.getParameter("photo"));
			m.setTelHome(request.getParameter("phone"));
			String[] paramValues3 =request.getParameterValues("vehicle");
			if( paramValues3 != null){
				for(int i=0; i<paramValues3.length; i++) {
					if( paramValues3[i].equals("car") )
						m.setHasCar(true);
					if( paramValues3[i].equals("motor") )
						m.setHasBike(true);
					if( paramValues3[i].equals("truck") )
						m.setHasTruck(true);
					if( paramValues3[i].equals("boat") )
						m.setHasBoat(true);
				}
			}
			m.setCertificates(request.getParameter("certificate"));
			if( request.getParameter("radios2")!=null && request.getParameter("radios2").equals("yes") ){
				if(request.getParameter("memtxt")!=null ){
					m.setVolunteerTeamID(request.getParameter("memtxt"));
				}
				if(request.getParameter("check")!=null ){
					if( request.getParameter("check").equals("yes"))
						m.setVolunteerDesire(true);
				}
			}
			m.setFacebook(request.getParameter("facebook"));
			m.setSkype(request.getParameter("skype"));
			m.setGmail(request.getParameter("gmail"));
			
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
						out.print("<TR><TD> Job \n<TD>"+ request.getParameter("job"));
						out.print("<TR><TD> Address \n<TD>"+ request.getParameter("address"));
						out.print("<TR><TD> Driving License \n<TD>");
						String[] paramValues =request.getParameterValues("license");
						if( paramValues != null){
							if (paramValues.length == 1) {
								String paramValue = paramValues[0];
								if (paramValue.length() == 0)
									out.println("<I>No Value</I>");
								else
									out.println(paramValue);
							} else {
								out.println("<UL>");
								for(int i=0; i<paramValues.length; i++) {
									out.println("<LI>" + paramValues[i]);
								}
								out.println("</UL>");
							}
						}
						out.print("<TR><TD> Vehicle \n<TD>");
						String[] paramValues2 =request.getParameterValues("vehicle");
						if( paramValues2 != null){
							if (paramValues2.length == 1) {
								String paramValue2 = paramValues2[0];
								if (paramValue2.length() == 0)
									out.println("<I>No Value</I>");
								else
									out.println(paramValue2);
							} else {
								out.println("<UL>");
								for(int i=0; i<paramValues2.length; i++) {
									out.println("<LI>" + paramValues2[i]);
								}
								out.println("</UL>");
							}
						}		
						out.print("<TR><TD> Blood Type \n<TD>"+ request.getParameter("blood"));
						out.print("<TR><TD> More Info \n<TD>"+ request.getParameter("info"));
						out.print("<TR><TD> Photo \n<TD>"+ request.getParameter("photo"));
						out.print("<TR><TD> Certifications \n<TD>"+ request.getParameter("certificate"));
						out.print("<TR><TD> Active Member/Become One \n<TD>"+ request.getParameter("radios2"));
						if(request.getParameter("radios2") != null) {
							if(request.getParameter("radios2").equals("yes")){
								out.print("<TR><TD> Already a member \n<TD>"+ request.getParameter("memtxt"));
								out.print("<TR><TD> Not a member but want to become one \n<TD>"+ request.getParameter("check"));
							}
						}
						out.print("<TR><TD> Facebook \n<TD>"+ request.getParameter("facebook"));
						out.print("<TR><TD> Skype ID \n<TD>"+ request.getParameter("skype"));
						out.print("<TR><TD> Gmail/GTalk ID \n<TD>"+ request.getParameter("gmail"));
						out.println("</TABLE>\n</BODY></HTML>");
			}
	
	public void doPost(HttpServletRequest request,
	HttpServletResponse response)
	throws ServletException, IOException {
			doGet(request, response);
	}
}
