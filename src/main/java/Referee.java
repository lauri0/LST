/**
 * Created by siiri on 01/03/15.
 */
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.*;

public class Referee {

    private int id;
    private String firstName;
    private String lastName;
    private String occupation;


    //static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    //static final String USER = "postgres";
    //static final String PASS = "testParool123";

    public Referee(int id, String firstName, String lastName, String occupation){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.occupation = occupation;
    }

    private static Connection getConnection() throws URISyntaxException, SQLException {
        URI dbUri = new URI(System.getenv("DATABASE_URL"));

        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

        return DriverManager.getConnection(dbUrl, username, password);
    }

    static Referee getRefereeByName(String firstName, String lastName){
        Connection conn = null;
        Statement stmt = null;

        try{

            //Class.forName("org.postgresql.Driver");

            //conn = DriverManager.getConnection(DB_URL,USER,PASS);
            conn = getConnection();

            stmt = conn.createStatement();
            String sql;
            System.out.println("SELECT id, first_name, last_name, occupation FROM referee WHERE first_name = " + "'" + firstName + "'" + " AND last_name = " + "'" + lastName + "'" + ";");
            sql = "SELECT id, first_name, last_name, occupation FROM referee WHERE first_name = " + "'" + firstName + "'" + " AND last_name = " + "'" + lastName + "'" + ";";
            ResultSet rs = stmt.executeQuery(sql);

            if(rs.next()){
                int id = rs.getInt("id");
                String fName = rs.getString("first_name");
                String lName = rs.getString("last_name");
                String occupation = rs.getString("occupation");
                Referee referee = new Referee(id, fName, lName, occupation);
                return referee;
            }

            stmt.close();
            conn.close();

            return null;


        }catch(SQLException se){

            se.printStackTrace();

        }catch(Exception e){

            e.printStackTrace();

        }finally{

            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }

        return null;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getOccupation() {
        return occupation;
    }

    public int getId() {
        return id;
    }

    public String toString() {
        return "Id:" + this.id + ", first name:" + this.firstName + ", last name:" + this.lastName + " , occupation:" + this.occupation;
    }

    }


