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

public class Signup3 extends HttpServlet {
	public void doGet(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
				String docType="<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
				"Transitional//EN\">\n";
				HttpSession session = request.getSession(true);
				
				String job=request.getParameter("job");
				String address=request.getParameter("address");
				String carl="no";
				String motorl="no";
				String truckl="no";
				String boatl="no";
				String carv="no";
				String motorv="no";
				String truckv="no";
				String boatv="no";
				String[] paramValues1 =request.getParameterValues("license");
				if( paramValues1 != null){
					for(int i=0; i<paramValues1.length; i++) {
						if( paramValues1[i].equals("car") )
							carl="yes";
						if( paramValues1[i].equals("motor") )
							motorl="yes";
						if( paramValues1[i].equals("truck") )
							truckl="yes";
						if( paramValues1[i].equals("boat") )
							boatl="yes";
					}
				}
				String[] paramValues3 =request.getParameterValues("vehicle");
				if( paramValues3 != null){
					for(int i=0; i<paramValues3.length; i++) {
						if( paramValues3[i].equals("car") )
							carv="yes";
						if( paramValues3[i].equals("motor") )
							motorv="yes";
						if( paramValues3[i].equals("truck") )
							truckv="yes";
						if( paramValues3[i].equals("boat") )
							boatv="yes";
					}
				}
				String blood=request.getParameter("blood");
				String info=request.getParameter("info");
				String photo=request.getParameter("photo");
				String certificate=request.getParameter("certificate");
				String radios2=request.getParameter("radios2");
				String memtxt=request.getParameter("memtxt");
				String check=request.getParameter("check");
				session.setAttribute("job", job);
				session.setAttribute("address", address);
				session.setAttribute("blood", blood);
				session.setAttribute("info", info);
				session.setAttribute("photo", photo);
				session.setAttribute("certificate", certificate);
				session.setAttribute("radios2", radios2);
				session.setAttribute("memtxt", memtxt);
				session.setAttribute("check", check);
				out.println(docType +"<HTML>" +
						"<head><title>Sign Up-Step 2/3</title>" +
											"</head>" +
	"<body style=\"text-align:center;background-color:#FDF5E6\">" +
	"<h2>Sign up-Step 3/3</h2>" +
	"<form method=\"post\" action=\"./post.Postsignup\" >"+
	"<b>Social:</b><br>" +
	"<b>Facebook:</b><input type=\"text\" name=\"facebook\" maxlength=\"50\"><br>" +
	"<b>Skype ID:</b><input type=\"text\" name=\"skype\" maxlength=\"50\"><br>" +
	"<b>Gmail/GTalk ID:</b><input type=\"text\" name=\"gmail\" maxlength=\"50\"><br>"+
	"<input type='hidden' name='mail' value="+session.getAttribute("mail")+">"+
	"<input type='hidden' name='pass' value="+session.getAttribute("pass")+">"+
	"<input type='hidden' name='cellphone' value="+session.getAttribute("cellphone")+">"+
	"<input type='hidden' name='phone' value="+session.getAttribute("phone")+">"+
	"<input type='hidden' name='firstName' value="+session.getAttribute("firstName")+">"+
	"<input type='hidden' name='lastName' value="+session.getAttribute("lastName")+">"+
	"<input type='hidden' name='day' value="+session.getAttribute("day")+">"+
	"<input type='hidden' name='month' value="+session.getAttribute("month")+">"+
	"<input type='hidden' name='year' value="+session.getAttribute("year")+">"+
	"<input type='hidden' name='radios' value="+session.getAttribute("radios")+">"+
	"<input type='hidden' name='country' value="+session.getAttribute("country")+">"+
	"<input type='hidden' name='city' value="+session.getAttribute("city")+">"+
	"<input type='hidden' name='job' value="+session.getAttribute("job")+">"+
	"<input type='hidden' name='address' value="+session.getAttribute("address")+">");
	if(carl.equals("yes"))
		out.println("<input type='hidden' name='license' value='car' >");
	if(motorl.equals("yes"))
		out.println("<input type='hidden' name='license' value='motor' >");
	if(truckl.equals("yes"))
		out.println("<input type='hidden' name='license' value='truck' >");
	if(boatl.equals("yes"))
		out.println("<input type='hidden' name='license' value='boat' >");
	if(carv.equals("yes"))
		out.println("<input type='hidden' name='vehicle' value='car' >");
	if(motorv.equals("yes"))
		out.println("<input type='hidden' name='vehicle' value='motor' >");
	if(truckv.equals("yes"))
		out.println("<input type='hidden' name='vehicle' value='truck' >");
	if(boatv.equals("yes"))
		out.println("<input type='hidden' name='vehicle' value='boat' >");
	out.println("<input type='hidden' name='blood' value="+session.getAttribute("blood")+">"+
	"<input type='hidden' name='info' value="+session.getAttribute("info")+">"+
	"<input type='hidden' name='photo' value="+session.getAttribute("photo")+">"+
	"<input type='hidden' name='certificate' value="+session.getAttribute("certificate")+">"+
	"<input type='hidden' name='radios2' value="+session.getAttribute("radios2")+">"+
	"<input type='hidden' name='memtxt' value="+session.getAttribute("memtxt")+">"+
	"<input type='hidden' name='check' value="+session.getAttribute("check")+">"+
	"<form method=\"post\" onsubmit=\"return checkForm();\">" +
	
	"<input type=\"submit\" value=\"Sign Up\">" +
	"</form>" +
	"</body>" +
	"</HTML>");
				
			
}
	
	public void doPost(HttpServletRequest request,
	HttpServletResponse response)
	throws ServletException, IOException {
			doGet(request, response);
	}
	
	
	}
	

