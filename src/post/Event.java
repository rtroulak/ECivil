/**
* 
* @author  Troulakis Georgios Rafail , Kleftogiorgos Konst/ntinos <rtroulak@gmail.com> , <kleftog@csd.uoc.gr>
* @version 1.0
* @since   2013-06-01 
*/
package post;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Event {

    private int id; // (auto-generated) (primary key)
    private String event_name; // (unique) 
    private String eventDate; // (format: yyyy-MM-dddd)
    private String author;
    private String status;
    private String time;
    private String description;
    private String videoPath;
    private String recPath;
    private String photoPath;
    private boolean volunteerNotified;
    private boolean  assistingOperators;
    private String volunteerInterested;
    private String volunteerPresent;
    private String dlocation;
    private String clocation;
    private String olocation;
    

    public Event(String event_name, String eventDate, String t,String Author) {
        this.event_name=event_name;
        this.eventDate=eventDate;
        this.author=Author;
        this.time=t;
        this.status="open";
    }

    /**
     * Establish a database connection and add the member in the database.
     *
     * @throws ClassNotFoundException
     */
    public void addInDatabase() throws ClassNotFoundException {

        try {

            Connection con = DBConnectionEvent.getConnection();
            Statement stmt = con.createStatement();

            String insertQuery = "INSERT INTO "
                    + " EVENT (EVENT_NAME, EVENTDATE, AUTHOR, STATUS, TIME, DESCRIPTION , VIDEO_PATH , REC_PATH , PHOTO_PATH , VOLUNTEER_NOTIFIED , ASSISTING_OPERATORS , VOLUNTEER_INTERESTED , VOLUNTEER_PRESENT, DESC_LOCATION, COOR_LOCATION, OTHER_LOCATION) "
                    + " VALUES ("
                    + "'" + event_name + "',"
                    + "'" + eventDate + "',"
                    + "'" + author + "',"
                    + "'" + status + "',"
                    + "'" + time + "',"
                    + "'" + description + "',"
                    + "'" + videoPath + "',"
                    + "'" + recPath + "',"
                    + "'" + photoPath + "',"
                    + "'" + volunteerNotified + "',"
                    + "'" + assistingOperators + "',"
                    + "'" + volunteerInterested + "',"
                    + "'" + volunteerPresent + "'," 
                    + "'" + dlocation + "',"
                    + "'" + clocation + "',"
                    + "'" + olocation + "'"
                    + ")";

            stmt.executeUpdate(insertQuery);
            System.out.println("# The Event was successfully added in the database.");

            /* Get the Event id from the database and set it to the event */
            String getIdQuery = "SELECT ID FROM EVENT WHERE EVENT_NAME = '" + event_name + "'";
            ResultSet result = stmt.executeQuery(getIdQuery);
            result.next();
            this.id = result.getInt("ID");
            System.out.println("# The ID of the new event is: " + this.id);

            stmt.close();
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * An example of adding a new event in the database.
     *
     * @param args the command line arguments
     * @throws ClassNotFoundException
     */
   /*public static void main(String[] args) throws ClassNotFoundException {

	   	Event m = new Event("tsounami stin eleu8erias", "2013-07-14", "3:30");
        m.setVideopath("videopath");
        m.setRecpath("recordingpath");
        m.setPhotopath("photopath");
        m.setdlocation("dlocation");
        m.setclocation("clocation");
        m.setolocation("olocation");

        m.addInDatabase();
    }*/

    /* Getters and Setters */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEvent() {
        return event_name;
    }

    public void setEvent(String name) {
        this.event_name = name;
    }

    public String getEventdate() {
        return eventDate;
    }

    public void setEventdate(String date) {
        this.eventDate = date;
    }
    
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String Author) {
        this.author = Author;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String Status) {
        this.status = Status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String desc) {
        this.description = desc;
    }

    public String getVideopath() {
        return videoPath;
    }

    public void setVideopath(String video) {
        this.videoPath = video;
    }

    public String getRecpath() {
        return recPath;
    }

    public void setRecpath(String rec) {
        this.recPath = rec;
    }

    public String getPhotopath() {
        return photoPath;
    }

    public void setPhotopath(String photo) {
        this.photoPath = photo;
    }

    

    public boolean volunteerNotified() {
        return volunteerNotified;
    }

    public void setvolunteerNotified(boolean volunteerNotified) {
        this.volunteerNotified = volunteerNotified;
    }

    public boolean assistingOperators() {
        return assistingOperators;
    }

    public void setassistingOperators(boolean assistingOperators) {
        this.assistingOperators = assistingOperators;
    }

    
    public String getvolunteerInterested() {
        return volunteerInterested;
    }

    public void setvolunteerInterestedD(String volunteerInterested) {
        this.volunteerInterested = volunteerInterested;
    }

    public String getvolunteerPresent() {
        return volunteerPresent;
    }

    public void setvolunteerPresent(String volunteerPresent) {
        this.volunteerPresent = volunteerPresent;
    }
   
    
    public String getolocation() {
        return olocation;
    }

    public void setolocation(String  olocation) {
        this. olocation =  olocation;
    }
    
    public String getclocation() {
        return clocation;
    }

    public void setclocation(String  clocation) {
        this. clocation =  clocation;
    }
    
    public String getdlocation() {
        return dlocation;
    }

    public void setdlocation(String  dlocation) {
        this. dlocation =  dlocation;
    }
    

    
}
