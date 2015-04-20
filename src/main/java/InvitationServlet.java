import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;

public class InvitationServlet extends HttpServlet {

    public InvitationServlet(){

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/invite.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String recipient = request.getParameter("recipient");
        String subject = request.getParameter("subject");
        String contents = request.getParameter("contents");

        InvitationSender sender = new InvitationSender();
        sender.sendInvitation(recipient, subject, contents);

        String redirectLocation = "./index";
        response.sendRedirect(redirectLocation);
    }
}
