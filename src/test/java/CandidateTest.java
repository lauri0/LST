import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CandidateTest {

    @Before
    public void setUp() throws Exception {

        TestHelper.createDb();
    }

    @After
    public void tearDown() throws Exception {

        TestHelper.dropDb();

    }

    @Test
    public void testReturnCandidateByReferee() throws Exception {

        Referee mari = Referee.getRefereeByName("Mari", "Maasik");
        Candidate candidate = Candidate.returnCandidateByReferee(mari);
        assertEquals("Otto Triin", candidate.getFirst_name() + " " + candidate.getLast_name());

    }
}