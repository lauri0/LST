import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by siiri on 22/03/15.
 */
/*
public class ElectionServlet extends HttpServlet {

    public ElectionServlet(){}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Election election = new Election(1);
        try {
            election.returnNumberOfReferees();
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException(e);

        request.getRequestDispatcher("/WEB-INF/statistics.jsp").forward(request, response);
    }
}
*/