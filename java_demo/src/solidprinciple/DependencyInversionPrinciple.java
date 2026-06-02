package solidprinciple;

interface IVersionControl {
	void commit(String message);

	void push();

	void pull();
}

class GitVersionControl implements IVersionControl {

	public void commit(String message) {
		System.out.println("Committing changes to Git with message: " + message);
	}

	public void push() {
		System.out.println("Pushing changes to remote Git repository.");
	}

	public void pull() {
		System.out.println("Pulling changes from remote Git repository.");
	}
}

class DevelopmentTeam {
	private IVersionControl control;

	public DevelopmentTeam(IVersionControl vc) {
		this.control = vc;
	}

	public void makeCommit(String message) {
		control.commit(message);
	}

	public void performPush() {
		control.push();
	}

	public void performPull() {
		control.pull();
	}
}

public class DependencyInversionPrinciple {

	public static void main(String[] args) {

		GitVersionControl git = new GitVersionControl();
		DevelopmentTeam team = new DevelopmentTeam(git);

		team.makeCommit("Initial Commit");
		team.performPush();
		team.performPull();
	}

}
