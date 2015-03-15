 /**
 * Created by siiri on 26/02/15.
 */

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class TestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String data = "Tere";
        request.setAttribute("data", data);
        request.getRequestDispatcher("/WEB-INF/tervitaja.jsp").forward(request, response);
    }

}
