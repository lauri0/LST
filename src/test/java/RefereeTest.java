import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class RefereeTest {

    @Before
    public void setUp() throws Exception {

       TestHelper.createDb();

    }

    @After
    public void tearDown() throws Exception {

        TestHelper.dropDb();

    }

    @Test
    public void testGetRefereeByName() throws Exception {

        Referee mari = Referee.getRefereeByName("Mari", "Maasik");
        assertEquals("ajakirjanik", mari.getOccupation());
        assertEquals("mari.maasik@gmail.com", mari.getEmail());
    }

    @Test
    public void testGetRefereesByFirstNameLetter() throws Exception {

        List<String> actualFirstNames = new ArrayList<>();
        actualFirstNames.add("Mari");
        actualFirstNames.add("Malle");

        List<Referee> firstNames = Referee.getRefereesByFirstNameLetter("M");
        for (int i = 0; i < firstNames.size(); i++) {
             assertEquals(actualFirstNames.get(i), firstNames.get(i).getFirstName());
        }

    }

    @Test
    public void testGetRefereesByFirstLetter() throws Exception {

        List<Referee> lastNames = Referee.getRefereesByFirstLetter("M");
        assertEquals(6, lastNames.size());

    }

    @Test
    public void testSave() throws Exception {

        Referee mart = new Referee("Mart", "Männik", "kalevipoeg", "mart.mannik@ehitus.fi");
        mart.save();
        List<Referee> lastNames = Referee.getRefereesByFirstLetter("M");
        assertEquals(7, lastNames.size());

    }

    @Test
    public void testSaveRefereeDataToDataBase() throws Exception {

        Referee jaanus = new Referee("Jaanus", "Jõemaa", "näitleja", "jansu79@hot.ee");
        Comment jaanusComment = new Comment("lore ipsum and all that jazz");

        jaanus.saveRefereeDataToDataBase(jaanusComment, jaanus);
        Comment returnedComment = Comment.returnCommentByReferee(jaanus, 1);
        assertEquals(jaanusComment.getMessage(), returnedComment.getMessage());

    }
}