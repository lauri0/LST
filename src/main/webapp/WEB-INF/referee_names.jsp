<%--
  Created by IntelliJ IDEA.
  User: siiri
  Date: 01/03/15
  Time: 17:57
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Connection conn = null;
    Statement stmt = null;

    try{
        String s[] = null;
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","cpittT");

        stmt = conn.createStatement();

        String name = request.getParameter("referee");

        ArrayList<String> refereeNames = new ArrayList<String>();

        ResultSet rs = stmt.executeQuery("SELECT first_name FROM referees where first_name like '%"+name+"%';");
        System.out.print("Siit tulevad sobivad");
        System.out.println("SELECT first_name FROM referees where first_name like '%"+name+"%';");
        while(rs.next()){

            refereeNames.add(rs.getString("first_name"));

        }

        System.out.println(refereeNames);
        //jQuery related end

        rs.close();
        stmt.close();
        conn.close();
    }
    catch(Exception e){
        e.printStackTrace();
    }
%>
<html>
<head>
    <title></title>
</head>
<body>

</body>
</html>
