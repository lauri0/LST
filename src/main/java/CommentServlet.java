package main.java; /**
 * Created by siiri on 27/02/15.
 */

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class CommentServlet extends HttpServlet {

    public CommentServlet(){

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/comment.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String commentMessage = request.getParameter("testComment");
        System.out.println(commentMessage);
        Comment comment = new Comment(1, "Mari", "Maasik", "ajakirjanik", commentMessage);
        comment.saveToDatabase();
        Comment comment2 = new Comment(2, "Kadri", "Kaasik", "poliitik", "tere-tere");
        System.out.println(Comment.getCommentByID(1));
        request.setAttribute("data", comment);
        request.getRequestDispatcher("/WEB-INF/tervitaja.jsp").forward(request, response);

    }
}
