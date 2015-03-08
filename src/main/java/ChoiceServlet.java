package main.java;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ChoiceServlet extends HttpServlet {

    public ChoiceServlet(){

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/choice.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String choiceEntry = request.getParameter("testChoice");
        System.out.println(choiceEntry.toString());
        System.out.println(choiceEntry);
        Choice ent = new Choice(1, "Meelis", "Mustik", "kokk", choiceEntry);
        ent.saveToDatabase();
        //Choice comment2 = new Choice(2, "Kadri", "Kaasik", "poliitik", "tere-tere");
        System.out.println(Choice.getChoiceByID(1));
        request.setAttribute("data", ent);
        request.getRequestDispatcher("/WEB-INF/tervitaja.jsp").forward(request, response);
        //request.getRequestDispatcher("/WEB-INF/referee.jsp").forward(request, response);

    }
}
