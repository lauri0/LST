
/**
 * Created by siiri on 27/02/15.
 */
import java.sql.*;

public class Comment {

    int id;
    String firstName;
    String lastName;
    String occupation;
    String message;

    static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    static final String USER = "postgres";
    static final String PASS = "testParool123";


    public Comment(int id, String firstName, String lastName, String occupation, String message){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.occupation = occupation;
        this.message = message;
    }

    void saveToDatabase(){

        Connection conn = null;
        Statement stmt = null;

        try{

            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            //System.out.println(" INSERT INTO comments (id, first_name, last_name, occupation, comment_content) VALUES ("+Integer.toString(id)+",'" +firstName+"','"+lastName+"', '"+occupation+"','"+message+"');");
            stmt = conn.createStatement();
            stmt.executeUpdate(" INSERT INTO comments (id, first_name, last_name, occupation, comment_content) VALUES ("+Integer.toString(id)+",'" +firstName+"','"+lastName+"', '"+occupation+"','"+message+"');");

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

    static Comment getCommentByID(int number){

        Connection conn = null;
        Statement stmt = null;

        try{

            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            String sql;
            System.out.println("SELECT id, first_name, last_name, occupation, comment_content FROM comments WHERE id = " + Integer.toString(number) + ";");
            sql = "SELECT id, first_name, last_name, occupation, comment_content FROM comments WHERE id = " + Integer.toString(number) + ";";
            ResultSet rs = stmt.executeQuery(sql);

            if(rs.next()){
                int id = rs.getInt("id");
                String fName = rs.getString("first_name");
                String lName = rs.getString("last_name");
                String occupation = rs.getString("occupation");
                String message = rs.getString("comment_content");
                Comment comment = new Comment(id, fName, lName, occupation, message);
                return comment;
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
        return "Comment{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", occupation='" + occupation + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

}
