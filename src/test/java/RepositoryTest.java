import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

public class RepositoryTest {

    private Repository repo;
    private Commit commit;
    private Commit commit1;
    private Commit commit2;

    @Before
    public void before() {
        repo = new Repository("E36_GitHub_WK_HW", "Week 11 Weekend Homework at CodeClan.", RepoType.PUBLIC);
        commit = new Commit("Initial Commit", CommitType.FEATURE, 931320);
        commit1 = new Commit("Created Tests For Repository", CommitType.FEATURE, 931420);
        commit2 = new Commit("Bug Error - Java: ';' expected in first test", CommitType.BUGFIX, 931520);
    }

    @Test
    public void hasName() {
        assertEquals("E36_GitHub_WK_HW", repo.getName());
    }

    @Test
    public void hasDescription() {
        assertEquals("Week 11 Weekend Homework at CodeClan.", repo.getDescription());
    }

    @Test
    public void hasRepoType() {
        assertEquals(RepoType.PUBLIC, repo.getRepoType());
    }

    @Test
    public void hasNoCommits(){
        assertEquals(0, repo.getCommits().size());
    }

    @Test
    public void canAddCommit() {
        repo.addCommit(commit);
        assertEquals(1, repo.getCommits().size());
    }

//    MVP Spec required that we should be able to get a commit by its UniqueID:

    @Test
    public void canGetCommitById() {
        assertEquals(931320, repo.getCommitById(931320));
    }

//    We should be able to get all commits of a certain type (e.g. all features):

    @Test
    public void canGetAllCommitsByType() {
        repo.addCommit(commit);
        repo.addCommit(commit2);
        repo.addCommit(commit1);
        assertEquals(2, repo.getCommitsByType(CommitType.FEATURE).size());
        assertEquals(1, repo.getCommitsByType(CommitType.BUGFIX).size());
    }

    //    A Repository should be able to revert (roll-back) commits to a certain point:

    @Test
    public void canRevert() {
        repo.addCommit(commit);
        repo.addCommit(commit1);
        repo.addCommit(commit2);
        repo.revert(931420);
        assertEquals(2, repo.getCommits().size());
    }
}