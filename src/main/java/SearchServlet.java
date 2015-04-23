import javax.servlet.http.HttpServlet;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SearchServlet extends HttpServlet {

    public SearchServlet() {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("application/json");

        try{
            String name = request.getParameter("term");
            System.out.println("Data from ajax call: " + name);
            List<Referee> referees = Referee.getRefereesByFirstNameLetter(request.getParameter("term"));
            String refereesList = new Gson().toJson(referees);
            System.out.println("Siit algab list: " + refereesList);
            response.getWriter().write(refereesList);
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}