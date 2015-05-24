import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CommentTest {

    @Before
    public void setUp() throws Exception {

        TestHelper.createDb();
    }

    @After
    public void tearDown() throws Exception {

        TestHelper.dropDb();

    }

    @Test
    public void testSave() throws Exception {

        Comment comment = new Comment("This is some random comment");
        Referee referee = new Referee("a","b","c","d");

        referee.saveRefereeDataToDataBase(comment, referee);
        Comment returnedComment = Comment.returnCommentByReferee(referee,1);
        assertEquals(comment.getMessage(), returnedComment.getMessage());
    }
}