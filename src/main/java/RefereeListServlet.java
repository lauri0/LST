import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by siiri on 20/03/15.
 */
public class RefereeListServlet extends HttpServlet {

    public RefereeListServlet() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //List<Referee> referees = Referee.getRefereesByFirstLetter("M");
        //request.setAttribute("refereeList", referees);

        request.getRequestDispatcher("/WEB-INF/referees-list.jsp").forward(request, response);
    }
}
