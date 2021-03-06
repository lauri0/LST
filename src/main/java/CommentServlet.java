import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.Enumeration;

public class CommentServlet extends HttpServlet {

    public CommentServlet(){

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //doPost(request, response);
        if (request.getSession().getAttribute("signinStatus") != null) {
            request.getRequestDispatcher("/WEB-INF/comment.jsp").forward(request, response);
        }
        else {
            response.sendRedirect("./auth");
            request.getSession().setAttribute("origin", "index");
            request.getSession().setAttribute("originjsp", "comment");
        }
        //request.getRequestDispatcher("/WEB-INF/comment.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*
        try {
            if (request.getSession().getAttributeNames("signinStatus") != "1") {
                request.getRequestDispatcher("/WEB-INF/auth.jsp").forward(request, response);

            }
            else {

            }
        }

        catch (Exception e) {
            e.printStackTrace();
        }
        */
        String occupation = request.getParameter("testOccupation");
        String commentMessage = request.getParameter("testComment");
        System.out.println(commentMessage);

        /*Comment comment = new Comment(1, "Mari", "Maasik", "ajakirjanik", commentMessage);
        comment.saveToDatabase();
        Comment comment2 = new Comment(2, "Kadri", "Kaasik", "poliitik", "tere-tere");
        System.out.println(Comment.getCommentByID(1));
        request.setAttribute("data", comment);*/
        //Referee malle = new Referee("Malle","Metssalu","", "malle.metsalu@gmail.com");
        //Referee ossu = Referee.getRefereeByName("Oskar","Mets");
        /*malle.setOccupation(occupation);
        Comment testComment = new Comment(commentMessage);
        try {
            malle.saveRefereeDataToDataBase(testComment, malle);
        } catch (Exception e) {
            e.printStackTrace();
           throw new ServletException(e);

        }*/
        //request.getRequestDispatcher("/WEB-INF/tervitaja.jsp").forward(request, response);

        String firstName = request.getSession().getAttribute("firstName").toString();
        System.out.println("---" + request.getAttribute("firstName"));
        String surName = request.getSession().getAttribute("surName").toString();
        String email = request.getSession().getAttribute("email").toString();
        try {
            if (Referee.getRefereeByName(firstName, surName) == null) {
                Comment com = new Comment(commentMessage);
                Referee ref = new Referee(firstName, surName, occupation ,email);
                ref.saveRefereeDataToDataBase(com, ref);
            }
            else {
                Referee ref = Referee.getRefereeByName(firstName, surName);
                Comment com = Comment.returnCommentByReferee(ref, 1);
                com.setMessage(commentMessage);
                com.save();
            }
        }

        catch (URISyntaxException e) {
            e.printStackTrace();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String redirectLocation = "./index";
        response.sendRedirect(redirectLocation);
    }
}
