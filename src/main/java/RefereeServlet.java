 /**
 * Created by siiri on 01/03/15.
 */



import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class RefereeServlet extends HttpServlet {

    public RefereeServlet(){

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String refereeName = request.getParameter("referee");
        System.out.println(refereeName);
        String[] nameComponents = refereeName.split(" ");
        String firstName = nameComponents[0];
        String lastName = nameComponents[1];
        System.out.println(firstName + " " + lastName);
        Referee ref = Referee.getRefereeByName(firstName, lastName);
        request.setAttribute("ref", ref);
        request.getRequestDispatcher("/WEB-INF/referee.jsp").forward(request, response);

    }
}
