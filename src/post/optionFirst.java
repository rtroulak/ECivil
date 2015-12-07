/**
* 
* @author  Troulakis Georgios Rafail , Kleftogiorgos Konst/ntinos <rtroulak@gmail.com> , <kleftog@csd.uoc.gr>
* @version 1.0
* @since   2013-06-01 
*/
package post;

import post.Member;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.io.*; 
import java.sql.*;
import java.util.Random;

import javax.servlet.*;
import javax.servlet.http.*;

public class optionFirst extends HttpServlet {
	public void doGet(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html style='height:100%;'>" +
				"<head>" +
				"<style>" +
				
				"a.blue:link,a.blue:visited" +
				"{" +
					"display:inline;" +
					"font-weight:bold;" +
					"font-size:550%;" +
					"color:white;" +
					"background-color:blue;" +
					"height:100%;" +
					"text-align:center;" +
					"text-decoration:none;" +
					"padding-left:7%;" +
					"padding-right:7%;" +
				"}" +
				"a.blue:hover,a.blue:active" +
				"{" +
					"background-color:#191970;" +
				"}" +
				"div.in{" +
				"float:right;" +
				"border: 1px solid black;" +
				"}" +
				"</style>" +
				
				"</head>" +
				
				
				"<body  style='background-color:black;height:99%;'>" +
						"<div style='height:10%;''>" +
							"<div class='in' style='width:8.5%;background-color:grey;padding-left:5%;'>" +
							"		<img src='http://localhost:8083/TestProject/phone.png' height='100%' width='45%'>" +
							"</div>"
							 );
						
				

		
				try {
					Connection con = DBConnectionEvent.getConnection();
					Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
					
					HttpSession session = request.getSession(true);
					String emailmember = (String) session.getAttribute("mail");
					
					Date date = new Date();
					
				    Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				    String s = formatter.format(date);
				    String[] r=s.split(" ");
				    System.out.println(r[0]);
				    
					Random randomGenerator = new Random();
					int randomInt = randomGenerator.nextInt(100000);
					String eventname="event"+randomInt+r[1];
					
					Event e = new Event(eventname, r[0], r[1],emailmember);
					e.addInDatabase();
					
					session.setAttribute("eventname", eventname);
					
					ResultSet rs = stmt.executeQuery("SELECT * FROM event");
					
					rs.first();
					int gpsflag=0;
					while (rs.next()) {
						String event_name = rs.getString("event_name");
						String coor = rs.getString("COOR_LOCATION");
						if(eventname.equals(event_name) && !(coor.equals("null")) ){
							out.println(
										"<div class='in' style='width:8.5%;background-color:green;padding-left:5%;'>" +
										"		<img src='http://localhost:8083/TestProject/gps.png' height='100%' width='45%'>" +
										"</div>");
							gpsflag=1;
						}
					}
					if(gpsflag == 0){
						out.println(
									"<div class='in' style='width:8.5%;background-color:grey;padding-left:5%;'>" +
									"		<img src='http://localhost:8083/TestProject/gps.png' height='100%' width='45%'>" +
									"</div>");
					}
					
					
					rs.first();
					int soundflag=0;
					while (rs.next()) {
						String event_name = rs.getString("event_name");
						String recPath = rs.getString("rec_path");
						if(eventname.equals(event_name) && !(recPath.equals("null")) ){
							out.println(
										"<div class='in' style='width:8.5%;background-color:green;padding-left:5%;'>" +
										"		<img src='http://localhost:8083/TestProject/sound.png' height='100%' width='45%'>" +
										"</div>");
							soundflag=1;
						}
					}
					if(soundflag == 0){
						out.println(
									"<div class='in' style='width:8.5%;background-color:grey;padding-left:5%;'>" +
									"		<img src='http://localhost:8083/TestProject/sound.png' height='100%' width='45%'>" +
									"</div>");
					}
					
					
					rs.first();
					int photoflag=0;
					while (rs.next()) {
						String event_name = rs.getString("event_name");
						String photoPath = rs.getString("photo_path");
						if(eventname.equals(event_name) && !(photoPath.equals("null")) ){
							out.println(
									"<div class='in' style='width:8.5%;background-color:green;padding-left:5%;'>" +
											"		<img src='http://localhost:8083/TestProject/phot.png' height='100%' width='45%'>" +
											"</div>");
							photoflag=1;
						}
					}
					if(photoflag == 0){
						out.println(
								"<div class='in' style='width:8.5%;background-color:grey;padding-left:5%;'>" +
										"		<img src='http://localhost:8083/TestProject/phot.png' height='100%' width='45%'>" +
										"</div>");
					}
					
					
					rs.first();
					int videoflag=0;
					while (rs.next()) {
						String event_name = rs.getString("event_name");
						String videoPath = rs.getString("video_path");
						if(eventname.equals(event_name) && !(videoPath.equals("null")) ){
							out.println(
									"<div class='in' style='width:8.5%;background-color:green;padding-left:5%;'>" +
									"		<img src='http://localhost:8083/TestProject/video.png' height='100%' width='45%'>" +
									"</div>");
							videoflag=1;
						}
					}
					if(videoflag == 0){
						out.println(
								"<div class='in' style='width:8.5%;background-color:grey;padding-left:5%;'>" +
								"		<img src='http://localhost:8083/TestProject/video.png' height='100%' width='45%'>" +
								"</div>");
					}
					
					out.println("<div class='in' style='width:8.5%;background-color:red;padding-left:5%;'>" +
						"		<img src='http://localhost:8083/TestProject/hand.png' height='100%' width='45%'>" +
						"</div>");
					
					
					rs.first();
					int eventflag=0;
					while (rs.next()) {
						String event_name = rs.getString("event_name");
						if(eventname.equals(event_name)){
							out.println(
									"<div class='in' style='width:8.5%;background-color:green;padding-left:5%;'>" +
											"		<img src='http://localhost:8083/TestProject/acc.png' height='100%' width='45%'>" +
									"</div>");
							eventflag=1;
						}
					}
					if(eventflag == 0){
						out.println(
								"<div class='in' style='width:8.5%;background-color:red;padding-left:5%;'>" +
										"		<img src='http://localhost:8083/TestProject/acc.png' height='100%' width='45%'>" +
								"</div>");
					}
					
					out.println("</div>");
					
					con.close();
				} catch (SQLException | ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        
		out.println(
			"<div style='height:75%;'>" +
				"<a href='video.html' style='margin:15%;'><img src='http://localhost:8083/TestProject/tape.png' height='25.1%' width='17%'></a>" +
				"<a href='http://localhost:8083/TestProject/image.html' style='margin:15%;'><img src='http://localhost:8083/TestProject/camera.png' height='25.1%' width='17%'></a>" +
				"<a href='http://localhost:8083/TestProject/audio.html' style='margin:15%;'><img src='http://localhost:8083/TestProject/mic.png' height='25.1%' width='17%'></a>" +
				"<a href='http://localhost:8083/TestProject/message.html' style='margin:15%;'><img src='http://localhost:8083/TestProject/text.png' height='25.1%' width='17%'></a>" +
				"<a href='position.html' style='margin:15%;'><img src='http://localhost:8083/TestProject/map.png' height='25.1%' width='17%'></a>" +
				"<a href='phones.html' style='margin:15%;'><img src='http://localhost:8083/TestProject/mob.png' height='25.1%' width='17%'></a>" +
			"</div>" +
		
			"<div style='height:15%;background-color:blue;'>" +
				"<a class='blue' href='monitor.html' style='float:left'>Monitor</a>" +
				"<a class='blue' href='post.Main' style='margin-left:5%;float:left'><img src='http://localhost:8083/TestProject/shut.png' height='100%' width='100%'></a>" +
				"<a class='blue' href='type.html' style='float:right'>Type</a>" +
				"</div>" +
				"</body>" +
			"</html>");

			}
	
	public void doPost(HttpServletRequest request,
	HttpServletResponse response)
	throws ServletException, IOException {
			doGet(request, response);
	}

}
