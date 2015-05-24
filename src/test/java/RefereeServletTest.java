import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RefereeServletTest extends Mockito {


    @Before
    public void setUp() throws Exception {

        TestHelper.createDb();
    }

    @After
    public void tearDown() throws Exception {

        TestHelper.dropDb();

    }

    @Test
    public void testServlet() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);
        when(request.getParameter("referee")).thenReturn("Mari Maasik");

        when(request.getRequestDispatcher("/WEB-INF/referee.jsp")).thenReturn(dispatcher);

        new RefereeServlet().doGet(request, response);

        Mockito.verify(request).setAttribute(Matchers.eq("candidateName"), Matchers.eq("Otto Triin"));
        Mockito.verify(request).setAttribute(Matchers.eq("comment"), Matchers.eq("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur"));

    }

}