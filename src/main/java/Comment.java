import java.net.URI;
import java.net.URISyntaxException;
import java.sql.*;



public class Comment {

    public static final int NOT_SAVED = -1;

    private int id;
    private String message;


    private Comment(int id, String message){
        this.id = id;
        this.message = message;
    }

    public Comment(String message){
        this.id = NOT_SAVED;
        this.message = message;
    }

    public void save() throws ClassNotFoundException, SQLException, URISyntaxException {

        Connection conn = null;
        Statement stmt = null;

        conn = DatabaseConnection.getConnection();
        stmt = conn.createStatement();

        if(this.id == NOT_SAVED){

            stmt.execute("INSERT INTO comment (message) VALUES (" + " ' " + this.message + " ') " + " RETURNING id;");
            ResultSet rs = stmt.getResultSet();
            rs.next();
            this.id = rs.getInt("id");

        }
        else {
            stmt.executeUpdate("UPDATE comment SET message=" + " '" + this.message + "' " + " WHERE comment.id = " + " '" + this.id + "' " + ";");
          
        }

    }


    static Comment returnCommentByReferee(Referee ref, int electionId){

        int refId = ref.getId();

        Connection conn = null;
        Statement stmt = null;

        try{

            conn = DatabaseConnection.getConnection();
            stmt = conn.createStatement();

            System.out.println("SELECT * FROM comment INNER JOIN referee_choices ON (comment.id = referee_choices.comment_id) WHERE referee_id = " + Integer.toString(refId) + " AND election_id = " + Integer.toString(electionId) + ";");
            String sql = "SELECT * FROM comment INNER JOIN referee_choices ON (comment.id = referee_choices.comment_id) WHERE referee_id = " + Integer.toString(refId) + " AND election_id = " + Integer.toString(electionId) + ";";
            ResultSet rs = stmt.executeQuery(sql);

            if(rs.next()){

                int commentId = rs.getInt("id");

                String commentContent = rs.getString("message");

                Comment comment = new Comment(commentId, commentContent);

                return comment;

            }

            stmt.close();
            conn.close();

            return null;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        return null;
    }


    public String getMessage() {
        return message;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", message='" + message + '\'' +
                '}';
    }

}
