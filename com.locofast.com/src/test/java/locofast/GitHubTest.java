package locofast;

import org.testng.annotations.Test;

public class GitHubTest extends BaseSetUpTest{
	
	@Test(priority=1)
	public void challenge_1()
	{
		log.info("Rurring the 1st test case");

		log.info("log into application");
		new GitHubPage().logInIntoApplication("krajbhar00@gmail.com","Bhardwaj@19");
		
		log.info("Creating new repository");
		new GitHubPage().createNewRepository();
	}
	
	@Test(priority=2)
	public void challenge_2()
	{
		log.info("Rurring the 2nd test case");

		log.info("log into application");
		new GitHubPage().logInIntoApplication("krajbhar00@gmail.com","Bhardwaj@19");
		
		log.info("Opening created repository");
		new GitHubPage().openCreatedRepository();
		
		log.info("Creating new issue 1");
		new GitHubPage().creatNewIssue("Issue Created","Issue description has added");
		log.info("Issue 1 created");
		
		String issueName=new GitHubPage().getIssueName();
		log.info("Returnig issue 1 name "+issueName);
		
		log.info("Creating 2nd issue with previous issue details");
		new GitHubPage().creatNewIssue(issueName,issueName);
		log.info("Issue 2 created");		
	}

	@Test(priority=3)
	public void challenge_3()
	{
		log.info("Rurring the 3rd test case");

		log.info("log into application");
		new GitHubPage().logInIntoApplication("krajbhar00@gmail.com","Bhardwaj@19");
		
		log.info("Opening created repository");
		new GitHubPage().openCreatedRepository();
		
		log.info("Adding comment into issue");
		new GitHubPage().addingCommentIntoIssue();

		log.info("Re-opening created repository");
		new GitHubPage().openCreatedRepository();
		new GitHubPage().editRepositoryName(":lock:"+"\n");
	}
	
	@Test(priority=4)
	public void challenge_4()
	{
		log.info("Rurring the 4th test case");

		log.info("log into application");
		new GitHubPage().logInIntoApplication("krajbhar00@gmail.com","Bhardwaj@19");
		log.info("Opening created repository");
		new GitHubPage().openCreatedRepository();
		
		log.info("Mention the issue into other and navating to commented issue");
		new GitHubPage().mentionIssueIntoCommentAnd_NavigatingToIssueFromComment();
	}
	
	@Test(priority=5)
	public void challenge_5()
	{
		log.info("Rurring the 5th test case");

		log.info("log into application");
		new GitHubPage().logInIntoApplication("krajbhar00@gmail.com","Bhardwaj@19");
		
		log.info("Opening created repository");
		new GitHubPage().openCreatedRepository();
		
		log.info("Deleting the created repository");
		new GitHubPage().deleteRepository();	
	}
	
	
}
