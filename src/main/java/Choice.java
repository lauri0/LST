package main.java;

import java.sql.*;

public class Choice {

    int id;
    String firstName;
    String lastName;
    String occupation;
    String choice;

    //static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
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
            //STEP 2: Register JDBC driver
            Class.forName("org.postgresql.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            stmt.executeUpdate(" INSERT INTO choices (id, first_name, last_name, occupation, choice) VALUES ("+Integer.toString(id)+",'" +firstName+"','"+lastName+"', '"+occupation+"','"+choice+"');");
            //ResultSet rs = stmt.executeQuery(sql);


        stmt.close();
        conn.close();
    }catch(SQLException se){
        //Handle errors for JDBC
        se.printStackTrace();
    }catch(Exception e){
        //Handle errors for Class.forName
        e.printStackTrace();
    }finally{
        //finally block used to close resources
        try{
            if(stmt!=null)
                stmt.close();
        }catch(SQLException se2){
        }// nothing we can do
        try{
            if(conn!=null)
                conn.close();
        }catch(SQLException se){
            se.printStackTrace();
        }//end finally try
    }//end try
    System.out.println("Goodbye!");
    }

    static Choice getChoiceByID(int number){

        Connection conn = null;
        Statement stmt = null;

        try{

            //Class.forName("com.mysql.jdbc.Driver");

            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            System.out.println("Creating statement...");

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
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
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

}
