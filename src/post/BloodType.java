/**
* 
* @author  Troulakis Georgios Rafail , Kleftogiorgos Konst/ntinos <rtroulak@gmail.com> , <kleftog@csd.uoc.gr>
* @version 1.0
* @since   2013-06-01 
*/
package post;

public enum BloodType {

    O_PLUS("O+"), A_PLUS("A+"), B_PLUS("B+"), AB_PLUS("AB+"), O_MINUS("O-"), A_MINUS("A-"), B_MINUS("B-"), AB_MINUS("AB-"), UNKNOWN("Unknown");
    private String value;

    private BloodType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
