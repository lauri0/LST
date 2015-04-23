/**
 * Created by siiri on 01/03/15.
 */

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.Enumeration;
import java.util.List;

 public class RefereeServlet extends HttpServlet {

    public RefereeServlet(){

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String refereeName = request.getParameter("referee");
        System.out.println(refereeName);
        String[] nameComponents = refereeName.split(" ");
        System.out.println(nameComponents[1]);
        String firstName = nameComponents[0];
        String lastName = nameComponents[1].replace(",","");
        System.out.println("Siit algab vajalik info");
        System.out.println(firstName + " " + lastName);
        Referee ref = Referee.getRefereeByName(firstName, lastName);
        Candidate candidate = Candidate.returnCandidateByReferee(ref);
        String candidateFirstName = candidate.getFirst_name();
        String candidateLastName = candidate.getLast_name();
        System.out.println(candidateFirstName);
        System.out.println(candidateFirstName);
        System.out.println(candidateLastName);
        Comment comment = Comment.returnCommentByReferee(ref, Election.parliamentElectionId);
        String commentMessage = comment.getMessage();
        //request.setAttribute("ref", ref);
        //String refereesCandidate = Referee.returnRefereesCandidate(firstName, lastName);
        request.setAttribute("candidateName",candidateFirstName + " " + candidateLastName);
        request.setAttribute("comment", commentMessage);


        request.getRequestDispatcher("/WEB-INF/referee.jsp").forward(request, response);

    }
}
