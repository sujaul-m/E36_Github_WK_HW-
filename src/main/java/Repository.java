import java.util.ArrayList;

public class Repository {

    private String name;
    private String description;
    private RepoType repoType;
    private ArrayList<Commit> commits;

    public Repository(String name, String description, RepoType repoType) {
        this.name = name;
        this.description = description;
        this.repoType = repoType;
        this.commits = new ArrayList<Commit>();
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public RepoType getRepoType() {
        return repoType;
    }

    public ArrayList<Commit> getCommits() {
        return commits;
    }

    public void addCommit(Commit commit) {
        commits.add(commit);
    }

    //unable to get below test to pass, logic to me makes sense but i must be doing something wrong

    public ArrayList<Commit> getCommitById(int id) {
        ArrayList<Commit> commitsFound = new ArrayList<Commit>();
        for (Commit commit : this.commits) {
            if(id == commit.getCommitId()) {
                commitsFound.add(commit);
            }
        }
        return commitsFound;
    }

    public ArrayList<Commit> getCommitsByType(CommitType type) {
        ArrayList<Commit> commitsFound = new ArrayList<Commit>();
        for (Commit commit : this.commits) {
            if(type == commit.getCommitType()) {
                commitsFound.add(commit);
            }
        }
        return commitsFound;
    }

    public void revert(int id) {
        ArrayList<Commit> newCommits = new ArrayList<Commit>();
        for (Commit commit : this.commits) {
            if (commit.getCommitId() <= id) {
                newCommits.add(commit);
            }
        }
        this.commits = newCommits;
    }




}