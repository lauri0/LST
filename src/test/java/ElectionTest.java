import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ElectionTest {

    @Before
    public void setUp() throws Exception {

        TestHelper.createDb();
    }

    @After
    public void tearDown() throws Exception {

        TestHelper.dropDb();

    }

    @Test
    public void testReturnNumberOfReferees() throws Exception {

        Election parliamentElection = new Election(1);
        assertEquals("Riigikogu valimised: 3", parliamentElection.returnNumberOfReferees());

    }
}