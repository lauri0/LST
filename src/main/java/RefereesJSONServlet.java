import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by siiri on 20/03/15.
 */
public class RefereesJSONServlet extends HttpServlet {

    public RefereesJSONServlet() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println(request.getParameter("letter"));
        List<Referee> referees = Referee.getRefereesByFirstLetter(request.getParameter("letter"));
        Gson gson = new Gson();
        JsonElement element = gson.toJsonTree(referees, new TypeToken<List<Referee>>() {}.getType());
        JsonArray jsonArray = element.getAsJsonArray();
        response.setContentType("application/json");
        response.getWriter().print(jsonArray);
        System.out.println(jsonArray);

        //request.setAttribute("refereeList", referees);
        //request.getRequestDispatcher("/WEB-INF/referees-list.jsp").forward(request, response);
    }
}

