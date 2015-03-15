
import java.sql.*;

public class Choice {

/*    int id;
    String firstName;
    String lastName;
    String occupation;
    String choice;

    static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    static final String USER = "postgres";
    static final String PASS = "testParool123";


    public Choice(int id, String firstName, String lastName, String occupation, String choice){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.occupation = occupation;
        this.choice = choice;
    }

    void saveToDatabase(){

        Connection conn = null;
        Statement stmt = null;

        try{

            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            stmt.executeUpdate(" INSERT INTO choices (id, first_name, last_name, occupation, choice) VALUES ("+Integer.toString(id)+",'" +firstName+"','"+lastName+"', '"+occupation+"','"+choice+"');");

        stmt.close();
        conn.close();
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

    }

    static Choice getChoiceByID(int number){

        Connection conn = null;
        Statement stmt = null;

        try{

            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            stmt = conn.createStatement();
            String sql;
            System.out.println("SELECT id, first_name, last_name, occupation, comment_content FROM choices WHERE id = " + Integer.toString(number) + ";");
            sql = "SELECT id, first_name, last_name, occupation, choice FROM choices WHERE id = " + Integer.toString(number) + ";";
            ResultSet rs = stmt.executeQuery(sql);

            if(rs.next()){
                int id = rs.getInt("id");
                String fName = rs.getString("first_name");
                String lName = rs.getString("last_name");
                String occupation = rs.getString("occupation");
                String choice = rs.getString("choice");
                Choice entry = new Choice(id, fName, lName, occupation, choice);
                return entry;
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

    @Override
    public String toString() {
        return "Entry{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", occupation='" + occupation + '\'' +
                ", choice='" + choice + '\'' +
                '}';
    }
*/
}
