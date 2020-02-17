import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CommitTest {

    private Commit commit;


    @Before
    public void before() {
        commit = new Commit("Initial Commit", CommitType.FEATURE, 931320);
    }

//    MVP Spec required all commits to have a description.
    @Test
    public void commitHasDescription() {
        assertEquals("Initial Commit", commit.getDescription());
    }

    @Test
    public void commitHasCommitType() {
        assertEquals(CommitType.FEATURE, commit.getCommitType());
    }

//    MVP Spec required all commits to have a Unique ID
    @Test
    public void commitHasCommitId() {
        assertEquals(931320, commit.getCommitId());
    }

}