package main.java; /**
 * Created by siiri on 26/02/15.
 */

import java.sql.*;

public class FirstExample {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/test";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "cpittT";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try{

            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            stmt = conn.createStatement();
            String sql;
            sql = "SELECT first_name, last_name, phone_num, email FROM client_info";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){

                String f_name  = rs.getString("first_name");
                String l_name = rs.getString("last_name");
                int num = rs.getInt("phone_num");
                String mail = rs.getString("email");


                System.out.println("First name: " + f_name);
                System.out.println("Last name: " + l_name);
                System.out.println("Phone number: " + num);
                System.out.println("Email: " + mail);
            }

            rs.close();
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
        System.out.println("Goodbye!");
    }
}

