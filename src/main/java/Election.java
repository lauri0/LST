import java.net.URISyntaxException;
import java.sql.*;

/**
 * Created by siiri on 18/03/15.
 */
public class Election {

    public final static int parliamentElectionId = 1;
    public final static int presidentialElectionId = 2;
    public final static int localElectionId = 3;

    private int id;
    private String type;

    public Election(int id){
        this.id = id;
    }

    public String returnNumberOfReferees() throws ClassNotFoundException, SQLException, URISyntaxException {

        Connection conn = null;
        PreparedStatement stmt = null;
        int electionId = getId();
        conn = DatabaseConnection.getConnection();

        String selectStatement = "SELECT election.type, COUNT (*) as number_of_referees from election, referee_choices WHERE referee_choices.election_id = election.id AND election.id =? GROUP BY election.type;";
        stmt = conn.prepareStatement(selectStatement);
        stmt.setInt(1, electionId);
        stmt.execute();

        ResultSet rs = stmt.getResultSet();

        if(rs.next()){

            String electionType = rs.getString("type");
            int numberOfRefereesPerElection = rs.getInt("number_of_referees");

            conn.close();
            stmt.close();
            return electionType + ": " + numberOfRefereesPerElection;
        }

        conn.close();
        stmt.close();

        return null;
    }

    public static int getParliamentElectionId() {
        return parliamentElectionId;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }
}
