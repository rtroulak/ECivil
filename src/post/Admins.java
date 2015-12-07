/**
* 
* @author  Troulakis Georgios Rafail , Kleftogiorgos Konst/ntinos <rtroulak@gmail.com> , <kleftog@csd.uoc.gr>
* @version 1.0
* @since   2013-06-01 
*/
package post;

import post.BloodType;
import post.Gender;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Admins {

    private int id; // (auto-generated) (primary key)
    private String email; // (unique)
    private String password; // (must be encrypted in md5)
    private String firstname;
    private String lastname; 
   

    public Admins(String email, String password, String firstname, String lastname) {
        this.email = email;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
    
    }

    /**
     * Establish a database connection and add the member in the database.
     *
     * @throws ClassNotFoundException
     */
    public void addInDatabase() throws ClassNotFoundException {

        try {

            Connection con = DBConnectionAdmin.getConnection();
            Statement stmt = con.createStatement();

            String insertQuery = "INSERT INTO "
                    + " ADMIN (EMAIL, PASSWORD, FIRSTNAME, LASTNAME) "
                    + " VALUES ("
                    + "'" + email + "',"
                    + "'" + password + "',"
                    + "'" + firstname + "',"
                    + "'" + lastname + "'"
                    + ")";

            stmt.executeUpdate(insertQuery);
            System.out.println("# The Admin was successfully added in the database.");

            /* Get the member id from the database and set it to the member */
            String getIdQuery = "SELECT ID FROM ADMIN WHERE EMAIL = '" + email + "'";
            ResultSet result = stmt.executeQuery(getIdQuery);
            result.next();
            this.id = result.getInt("ID");
            System.out.println("# The ID of the new admin is: " + this.id);

            stmt.close();
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(Admins.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * An example of adding a new member in the database.
     *
     * @param args the command line arguments
     * @throws ClassNotFoundException
     */
    public static void main(String[] args) throws ClassNotFoundException {

        Admins m = new Admins("admin@admin.gr", "admin123", "Administrator", "AdministratorL");
        

        m.addInDatabase();
    }

    /* Getters and Setters */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

  
}
