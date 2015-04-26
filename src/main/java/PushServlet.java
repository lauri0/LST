/**
 * Created by Lauri on 24.04.2015.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PushServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/event-stream");
        response.setCharacterEncoding("UTF-8");

        PrintWriter writer = response.getWriter();

/*        int minute = 0;
        for (int second = 0; second < 3600; second++) {

            if (second == 60) {
                second = 0;
                minute += 1;
            }

            writer.write("event:second\n");
            writer.write("data: " + second + "\n\n");

            writer.write("event:minute\n");
            writer.write("data: " + minute + "\n\n");

            writer.flush();

            try {
                Thread.sleep(999);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/

        Election election = new Election(1);
        String stats = null;

        for (int i = 0; i < 3600; i++) {
            try {
                stats = election.returnNumberOfReferees();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }

            writer.write("event:statUpdate\n");
            writer.write("data: " + stats + "\n\n");
            writer.flush();

            try {
                Thread.sleep(50000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        writer.close();
    }
}