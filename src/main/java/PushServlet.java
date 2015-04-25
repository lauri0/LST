/**
 * Created by Lauri on 24.04.2015.
 */
import java.io.IOException;
import java.io.PrintWriter;

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
        int minute = 0;
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
        }
        writer.close();
    }
}