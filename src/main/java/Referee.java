import java.net.URISyntaxException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Referee {

    public static final int NOT_SAVED = -1;
    private int id;
    private String firstName;
    private String lastName;
    private String occupation;
    private String email;


    private Referee(int id, String firstName, String lastName, String occupation, String email){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.occupation = occupation;
        this.email = email;
    }

    public Referee(String firstName, String lastName, String occupation, String email){
        this.id = NOT_SAVED;
        this.firstName = firstName;
        this.lastName = lastName;
        this.occupation = occupation;
        this.email = email;
    }

    public static Referee getRefereeByName(String firstName, String lastName) {

        Connection conn = null;
        Statement stmt = null;

        try{

            conn = DatabaseConnection.getConnection();

            stmt = conn.createStatement();
            String sql;
            System.out.println("SELECT id, first_name, last_name, occupation, email FROM referee WHERE first_name = " + "'" + firstName + "'" + " AND last_name = " + "'" + lastName + "'" + ";");
            sql = "SELECT id, first_name, last_name, occupation, email FROM referee WHERE first_name = " + "'" + firstName + "'" + " AND last_name = " + "'" + lastName + "'" + ";";
            ResultSet rs = stmt.executeQuery(sql);


            if(rs.next()){
                int id = rs.getInt("id");
                String fName = rs.getString("first_name");
                String lName = rs.getString("last_name");
                String occupation = rs.getString("occupation");
                String email = rs.getString("email");
                Referee referee = new Referee(id, fName, lName, occupation, email);
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

    static List<Referee> getRefereesByFirstNameLetter(String letter){

        List <Referee> referees = null;
        Connection conn = null;
        PreparedStatement stmt = null;

        try{

            conn = DatabaseConnection.getConnection();
            referees = new ArrayList<Referee>();


            String selectStatement = "SELECT * FROM referee WHERE first_name LIKE ?";
            stmt = conn.prepareStatement(selectStatement);
            stmt.setString(1, letter + "%");

            ResultSet rs = stmt.executeQuery();
            while (rs.next()){

                int id = rs.getInt("id");
                String fName = rs.getString("first_name");
                String lName = rs.getString("last_name");
                String occupation = rs.getString("occupation");
                String email = rs.getString("email");
                Referee referee = new Referee(id, fName, lName, occupation, email);

                referees.add(referee);
            }

            stmt.close();
            conn.close();

            return referees;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        return null;
    }

    static List<Referee> getRefereesByFirstLetter(String firstLetter) {

        List<Referee> referees = null;
        Connection conn = null;
        Statement stmt = null;

        try {

            conn = DatabaseConnection.getConnection();
            referees = new ArrayList<Referee>();
            stmt = conn.createStatement();
            String sql;

            System.out.println("SELECT * FROM referee WHERE last_name LIKE " + "'" + firstLetter + '%' + "'" + " ORDER BY last_name ASC;");

            sql = "SELECT * FROM referee WHERE last_name LIKE " + "'" + firstLetter  + '%' + "'" + " ORDER BY last_name ASC;";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()) {

                int id = rs.getInt("id");
                String fName = rs.getString("first_name");
                String lName = rs.getString("last_name");
                String occupation = rs.getString("occupation");
                String email = rs.getString("email");
                Referee referee = new Referee(id, fName, lName, occupation, email);

                System.out.println(referee);

                referees.add(referee);

            }

            stmt.close();
            conn.close();

            return referees;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        return null;
    }

    void save() throws ClassNotFoundException, SQLException, URISyntaxException {

        Connection conn = null;
        PreparedStatement stmt2 = null;

        conn = DatabaseConnection.getConnection();


        String firstName = getFirstName();
        String lastName = getLastName();
        String occupation = getOccupation();
        String email = getEmail();
        int id = getId();

        // if referee_id = -1, it means that he is not saved to database. Lets add referee info to referee table, and return he's autoincremented id with RETURNING. Referees id is valuated to this number.
        if(this.id == NOT_SAVED){
            String insertStatement = "INSERT INTO referee (first_name, last_name, occupation, email) VALUES (?,?,?,?) RETURNING id;";
            stmt2 = conn.prepareStatement(insertStatement);
            stmt2.setString(1, firstName);
            stmt2.setString(2, lastName);
            stmt2.setString(3, occupation);
            stmt2.setString(4, email);
            stmt2.execute();
            ResultSet rs = stmt2.getResultSet();
            rs.next();
            this.id = rs.getInt("id");

        }

        //referee_id has already been saved. In that case, lets update information about referee.
        else{
            String updateStatement = "UPDATE referee SET first_name=?, last_name=?,occupation=?, email=? WHERE id=?;";
            stmt2 = conn.prepareStatement(updateStatement);
            stmt2.setString(1, firstName);
            stmt2.setString(2, lastName);
            stmt2.setString(3, occupation);
            stmt2.setString(4,email);
            stmt2.setInt(5,id);
            stmt2.execute();

        }


        conn.close();
        stmt2.close();


    }

    public void saveRefereeDataToDataBase(Comment comment, Referee ref) throws URISyntaxException, SQLException, ClassNotFoundException {

        String email = ref.getEmail();

        Connection conn = null;
        PreparedStatement stmt3 = null;

        conn = DatabaseConnection.getConnection();

        comment.save();
        ref.save();

        int commentId = comment.getId();
        int refId = ref.getId();

        String insertStatement = "INSERT INTO referee_choices (referee_id, election_id, comment_id, candidate_id) VALUES (?,?,?,?);";
        stmt3 = conn.prepareStatement(insertStatement);
        stmt3.setInt(1, refId);
        stmt3.setInt(2, 1);
        stmt3.setInt(3, commentId);
        stmt3.setInt(4, 1);
        stmt3.execute();
        //TODO: get candidate id. At the moment it adds candidate 1

        stmt3.close();
        conn.close();
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

    public String getEmail() {
        return email;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String toString() {
        return "Id:" + this.id + ", first name:" + this.firstName + ", last name:" + this.lastName + " , occupation:" + this.occupation;
    }

    }


