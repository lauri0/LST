/**
 * Created by siiri on 28/02/15.
 */

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class FirstPageServlet extends HttpServlet {

    public FirstPageServlet(){

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = main.java.GoogleAuth.getUserName();
        String inOut = "Log out";
        if (name == null) {
            name = "Pole veel sisse loginud";
            inOut = "Log in";
        }
        request.setAttribute("loginlogout", inOut);
        request.setAttribute("name", name);
        request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
