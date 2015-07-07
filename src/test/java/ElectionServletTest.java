import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ElectionServletTest {


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

        when(request.getRequestDispatcher("/WEB-INF/statistics.jsp")).thenReturn(dispatcher);

        new ElectionServlet().doGet(request, response);

        Mockito.verify(request).setAttribute(Matchers.eq("statistics"), Matchers.eq("Riigikogu valimised: 3"));

    }

}