import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.json.JSONException;

public class GoogleAuthServlet extends HttpServlet {

    public GoogleAuthServlet(){

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final GoogleAuth helper = new GoogleAuth();
        if (request.getParameter("code") == null
                || request.getParameter("state") == null) {
            //String redirectLocation = "./index";
            //response.sendRedirect(redirectLocation);
	/*
	 * initial visit to the page
	 */

            String location = new String(helper.buildLoginUrl());
            response.sendRedirect(location);

	/*
	 * set the secure state token in session to be able to track what we sent to google
	 */
            request.getSession().setAttribute("state", helper.getStateToken());

        }

        else if (request.getParameter("code") != null && request.getParameter("state") != null && request.getParameter("state").equals(request.getSession().getAttribute("state"))) {

            request.getSession().removeAttribute("state");

	/*
	 * Executes after google redirects to the callback url.
	 */
            try {
                String userInfo = helper.getUserInfoJson(request.getParameter("code"));
                String fullName = helper.getNameFromJson(userInfo);
                String email = helper.getEmailFromJson(userInfo);

                String[] names = fullName.split("\\s+");
                String firstName = names[0];
                String surName = names[1];

                try {
                    request.getSession().setAttribute("firstName", firstName);
                    request.getSession().setAttribute("surName", surName);
                    request.getSession().setAttribute("email", email);
                    //String redirectLocation = "./comment";
                    //response.sendRedirect(redirectLocation);
                    request.getRequestDispatcher("/WEB-INF/comment.jsp").forward(request, response);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        //request.getRequestDispatcher("/WEB-INF/auth.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
