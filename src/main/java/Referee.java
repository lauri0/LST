import java.net.URISyntaxException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Referee {

    private int id;
    private String firstName;
    private String lastName;
    private String occupation;
    private String email;


    public Referee(int id, String firstName, String lastName, String occupation, String email){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.occupation = occupation;
        this.email = email;
    }

    static Referee getRefereeByName(String firstName, String lastName){
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

            sql = "SELECT * FROM referee WHERE last_name LIKE " + "'" + firstLetter + '%' + "'" + " ORDER BY last_name ASC;";
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

    public String toString() {
        return "Id:" + this.id + ", first name:" + this.firstName + ", last name:" + this.lastName + " , occupation:" + this.occupation;
    }

    }


