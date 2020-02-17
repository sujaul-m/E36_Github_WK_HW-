import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GitHubTest {

    private GitHub gitHub;
    private Account account1;
    private Account account2;
    private Account account3;
    private Account account4;

    @Before
    public void before() {
        gitHub = new GitHub();
        account1 = new Account("Sujaul Miah", "Sujaul's Repo", AccountType.FREE);
        account2 = new Account("Harrison Booth", "Harrison's Repo", AccountType.FREE);
        account3 = new Account("Katie Jeffree", "Katie's Repo", AccountType.FREE);
        account4 = new Account("Alex Bazlinton", "Alex's Repo", AccountType.FREE);
    }

//    Treemap is always sorted hence last key is Sujaul's Repo and first key is Alex's Repo despite account 1 being added first and account 4 being added last
    @Test
    public void gitHubHasAccounts() {
        gitHub.addAccount(account1);
        gitHub.addAccount(account2);
        gitHub.addAccount(account3);
        gitHub.addAccount(account4);
        assertEquals(4, gitHub.getAccounts().size());
        assertEquals("Alex's Repo", gitHub.getAccounts().firstKey());
        assertEquals("Sujaul's Repo", gitHub.getAccounts().lastKey());
    }


}