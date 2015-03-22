//import jdk.internal.dynalink.beans.StaticClass;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Candidate {

    private int id;
    private String first_name;
    private String last_name;
    private String party_name;
    private String webpage;

    public Candidate(int id, String first_name, String last_name, String party_name, String webpage){
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.party_name = party_name;
        this.webpage = webpage;
    }


    static Candidate returnCandidateByReferee(Referee ref){

        int refId = ref.getId();

        Connection conn = null;
        Statement stmt = null;

        try {

            Connection connection = DatabaseConnection.getConnection();
            stmt = connection.createStatement();

            System.out.println("SELECT * FROM candidate INNER JOIN referee_choices ON (referee_choices.candidate_id=candidate.id) WHERE referee_id = " + Integer.toString(refId) + ";");
            String sql = "SELECT * FROM candidate INNER JOIN referee_choices ON (referee_choices.candidate_id=candidate.id) WHERE referee_id = " + Integer.toString(refId) + ";";
            ResultSet rs = stmt.executeQuery(sql);


            if (rs.next()) {

                int candidateId = rs.getInt("id");
                String candidateFirstName = rs.getString("first_name");
                String candidateLastName = rs.getString("last_name");
                String candidateParty = rs.getString("party");
                String candidateWebPage = rs.getString("party_webpage");

                Candidate candidate = new Candidate(candidateId,candidateFirstName, candidateLastName, candidateParty, candidateWebPage);
                return candidate;
            }

            connection.close();
            stmt.close();

            return null;

        } catch (SQLException se) {

            se.printStackTrace();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return null;

    }

    public String getFirst_name() {
        return first_name;
    }

    public int getId() {
        return id;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getParty_name() {
        return party_name;
    }

    public String getWebpage() { return webpage; }
}
