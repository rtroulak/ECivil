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

public class Signup2 extends HttpServlet {
	public void doGet(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
				String docType="<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
				"Transitional//EN\">\n";
				HttpSession session = request.getSession(true);
				String mail=request.getParameter("mail");
				String pass=request.getParameter("pass");
				String cellphone=request.getParameter("cellphone");
				String phone=request.getParameter("phone");
				String firstName=request.getParameter("firstName");
				String lastName=request.getParameter("lastName");
				String day=request.getParameter("day");
				String month=request.getParameter("month");
				String year=request.getParameter("year");
				String radios=request.getParameter("radios");
				String country=request.getParameter("country");
				String city=request.getParameter("city");
				session.setAttribute("mail", mail);
				session.setAttribute("pass", pass);
				session.setAttribute("cellphone", cellphone);
				session.setAttribute("phone", phone);
				session.setAttribute("firstName", firstName);
				session.setAttribute("lastName", lastName);
				session.setAttribute("day", day);
				session.setAttribute("month", month);
				session.setAttribute("year", year);
				session.setAttribute("radios", radios);
				session.setAttribute("country", country);
				session.setAttribute("city", city);
				out.println(docType +"<HTML>" +
						"<head><title>Sign Up-Step 2/3</title>" +
								"<script>" +
								"function checkForm()" +
								"{" +

								"var input = document.getElementById('photo');" +
								"if(input.files[0].size > 2097152){" +
											"alert(\"The file must be less than 2 MB\");" +
										"        return false;" +
								"}else" +
											"return true;" +
								"}" +
											"</script>" +
											"</head>" +
	"<body style=\"text-align:center;background-color:#FDF5E6\">" +
	"<h2>Sign up-Step 2/3</h2>" +
	"<form method=\"post\" action=\"./post.Signup3\" onsubmit=\"return checkForm();\">" +
	"<b>Job:</b>" +
	"<input type=\"text\" name=\"job\" maxlength=\"50\"><br>" +
	"<b>Address:</b>" +
	"<input type=\"text\" name=\"address\" maxlength=\"50\"><br>" +
	"<b>Driving License:</b>" +
	"<input type=\"checkbox\" name=\"license\" value=\"car\"/>Car" +
	"<input type=\"checkbox\" name=\"license\" value=\"motor\"/>Motorbike" +
	"<input type=\"checkbox\" name=\"license\" value=\"truck\"/>Truck" +
	"<input type=\"checkbox\" name=\"license\" value=\"boat\"/>Boat<br>" +
	
	"<b>Vehicle:</b>" +
	"<input type=\"checkbox\" name=\"vehicle\" value=\"car\"/>Car" +
	"<input type=\"checkbox\" name=\"vehicle\" value=\"motor\"/>Motorbike" +
	"<input type=\"checkbox\" name=\"vehicle\" value=\"truck\"/>Truck" +
	"<input type=\"checkbox\" name=\"vehicle\" value=\"boat\"/>Boat<br>" +
	
	"<b>Blood Type:</b>" +
	"<select name=\"blood\">" +
	"<option value=\"O+\">O+</option>" +
	"<option value=\"A+\">A+</option>" +
	"<option value=\"B+\">B+</option>" +
	"<option value=\"AB+\">AB+</option>" +
	"<option value=\"O-\">O-</option>" +
	"<option value=\"A-\">A-</option>" +
	"<option value=\"B-\">B-</option>" +
	"<option value=\"AB-\">AB-</option>" +
	"<option value=\"UNKNOWN\" selected>Don't Know/Not Sure</option>" +
	"</select><br>" +
	
	"<b>More Info:</b><br>" +
	"<textarea name=\"info\" id=\"info\" rows=\"10\" cols=\"50\" maxlength=\"500\">" +
	
	"</textarea><br>" +
	"<input type=\"hidden\" name=\"MAX_FILE_SIZE\" value=\"2097152\">" +
	"<b>Photo:</b><input type=file name=\"photo\" id=\"photo\"><br>" +
	
	"<b>Certifications:</b><br>" +
	"<textarea name=\"certificate\" rows=\"2\" cols=\"50\" maxlength=\"100\">" +
	
	"</textarea><br>" +
	
	"<b>I am an active member or i want to be one: </b><BR>" +
	"         <INPUT TYPE=\"radio\" NAME=\"radios2\" VALUE=\"unknown\" onClick=\"memtxt.disabled=true;check.disabled=true\" CHECKED>" +
	"             Unknown" +
	"        <BR>" +
	"        <INPUT TYPE=\"radio\" NAME=\"radios2\" VALUE=\"yes\" onClick=\"memtxt.disabled=false;check.disabled=false\">" +
	"             Yes" +
	"       <BR>" +
	"       <INPUT TYPE=\"radio\" NAME=\"radios2\" VALUE=\"no\" onClick=\"memtxt.disabled=true;check.disabled=true\">" +
	"             No" +
	"       <BR>" +
	
	"I am already a member:<br><textarea id=\"memtxt\" name=\"memtxt\" rows=\"2\" cols=\"50\" maxlength=\"100\" disabled>" +
	
	"</textarea><br>" +
	"<input type=\"checkbox\" id=\"check\" name=\"check\" value=\"yes\" disabled/>I am not a member but i wish to be one<br>" +
	"<br>"+
	"<input type=\"submit\" value=\"Step 3/3\">" +
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
	

