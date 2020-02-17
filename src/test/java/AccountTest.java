import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AccountTest {

    private Account account;
    private Repository repo;
    private Repository repo1;
    private Repository repo2;


    @Before
    public void before() {
        repo = new Repository("My_Portfolio", "My portfolio of projects completed.", RepoType.PUBLIC);
        repo1 = new Repository("E36_GitHub_WK_HW", "Part of the Week 11 Weekend Homework at CodeClan required us to model GitHub using TDD to the provided specification while also looking for opportunities to use Enums.", RepoType.PUBLIC);
        repo2 = new Repository("PDA_Sujaul_Miah", "Proof of work carried out while at CodeClan to meet SQA requirements", RepoType.PRIVATE);

        account = new Account("sujaul-m", "Sujaul's Repository", AccountType.FREE);
        account.addRepo(repo);
        account.addRepo(repo1);
    }

    @Test
    public void accountHolderHasUsername() {
        assertEquals("sujaul-m", account.getUsername());
    }

    @Test
    public void accountHolderHasName() {
        assertEquals("Sujaul's Repository", account.getName());
    }

    @Test
    public void hasAccountType() {
        assertEquals(AccountType.FREE, account.getAccountType());
    }

    @Test
    public void userHasRepos() {
        assertEquals(2, account.getRepos().size());
    }

//   MVP Spec requires us to have the ability to add repositories:

    @Test
    public void userCanAddRepo() {
        account.addRepo(repo1);
        account.addRepo(repo2);
        assertEquals(3, account.reposCount());
    }

//    MVP Spec requires us to be able to get a repository by name:

    @Test
    public void userCanGetRepoByName() {
        assertEquals("E36_GitHub_WK_HW", account.getRepoByName(repo1));
    }

//    MVP Spec requires GitHubAccounts to always start free, but we should be able to upgrade or downgrade as required:
//    default value is set to 0 while Pro is set to 1

    @Test
    public void usersAccountStartsFree() {
        assertEquals(0, account.getAccountType().getValue());
    }

    @Test
    public void canUpgradeAccountType() {
        account.changeAccountType();
        assertEquals(AccountType.PRO, account.getAccountType());
        assertEquals(1, account.getAccountType().getValue());
    }

    @Test
    public void userCanDowngradeAccountType() {
        account.changeAccountType();
        account.changeAccountType();
        assertEquals(AccountType.FREE, account.getAccountType());
    }

}