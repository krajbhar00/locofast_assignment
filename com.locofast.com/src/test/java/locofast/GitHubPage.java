package locofast;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GitHubPage extends BaseSetUpTest
{
	
	@FindBy(xpath="(//a[contains(text(),'Sign')])[2]")
	WebElement Home_SignInBtn;
	
	@FindBy(xpath="//input[@id='login_field']")
	WebElement userName;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement userPwd;
	
	@FindBy(xpath="//input[@value='Sign in']")
	WebElement userSignInBtn;
	
	@FindBy(xpath="//*[@class='octicon octicon-plus']")
	WebElement addReposity;
	
	@FindBy(xpath="//a[contains(text(),'New repository')]")
	WebElement newReposityBtn;
	
	@FindBy(xpath="//input[@id='repository_name']")
	WebElement reposityName;
	
	@FindBy(xpath="//input[@id='repository_auto_init']")
	WebElement readMeInitCheck;
	
	@FindBy(xpath="//button[contains(text(),'Create repository')]")
	WebElement createReposityBtn;
	
	@FindBy(xpath="(//summary[@class='Header-link'])[2]")
	WebElement viewProfile;
	
	@FindBy(xpath="//a[contains(text(),'Your repositories')]")
	WebElement yourRepositoryBtn;
	
	@FindBy(xpath="(//*[@itemprop='name codeRepository'])[1]")
	WebElement createdRepository;
	
	@FindBy(xpath="//span[contains(text(),'Issues')]")
	WebElement issueBtn;
	
	@FindBy(xpath="//span[contains(text(),'New issue')]")
	WebElement newIssueBtn;
	
	@FindBy(xpath="//input[@id='issue_title']")
	WebElement issueTitle;
	
	@FindBy(xpath="//textarea[@id='issue_body']")
	WebElement issueDescription;
	
	@FindBy(xpath="(//button[contains(text(),'Submit new issue')])[1]")
	WebElement submitNewIssueBtn;
	
	@FindBy(xpath="//textarea[@id='new_comment_field']")
	WebElement issueComment;	
	
	@FindBy(xpath="//h1[@class='gh-header-title f1 mr-0 flex-auto break-word']")
	WebElement issueName;
	
	@FindBy(xpath="//div[@class='flex-auto min-width-0 lh-condensed p-2 pr-3 pr-md-2']/a")
	List<WebElement> issueList;
	
	@FindBy(xpath="//button[contains(text(),'Comment')]")
	WebElement comment;
	
	@FindBy(xpath="//*[@class='octicon octicon-pencil']")
	WebElement editRepository;
	
	@FindBy(xpath="//pre[@class=' CodeMirror-line ']")
	WebElement editLine;
	
	@FindBy(xpath="//*[contains(text(),' Commit changes')]")
	WebElement commitChanges;
	
	@FindBy(xpath="//span[contains(text(),'Settings')]")
	WebElement settingBtn;
	
	@FindBy(xpath="//summary[contains(text(),'Delete this repository')]")
	WebElement deleteRepositoryBtn;
	
	@FindBy(xpath="(//*[contains(text(),'Please type')]/strong)[3]")
	WebElement copyRepositoryName;
	
	@FindBy(xpath="(//input[@class='form-control input-block'])[4]")
	WebElement repositoryNameConfirmation;
	
	@FindBy(xpath="//button[contains(text(),'I understand the consequences, delete this repository')]")
	WebElement deleteThisRepositoryBtn;
	

	

	ArrayList<String> array=new ArrayList<String>();
	String Issue1 = null;
	String Issue2 = null;
	
	
	public GitHubPage()
	{
		PageFactory.initElements(driver, GitHubPage.this);
	}
	
	
	public void logInIntoApplication(String uName,String uPwd)
	{
		log.info("Clicking on SignIn btn");
		Home_SignInBtn.click();
		
		log.info("Entering user name");
		userName.sendKeys(uName);
		
		log.info("Entering user pwd");
		userPwd.sendKeys(uPwd);
		
		log.info("Clicking on user signIn btn");
		userSignInBtn.click();
		
		log.info("User successfully logged in");
	}
	
	
	public void createNewRepository()
	{
		log.info("Clicking on add repository btn");
		addReposity.click();
		
		log.info("Clicking on new repository btn");
		newReposityBtn.click();
		
		log.info("Entering repository name");
		reposityName.sendKeys("locofast_Test");
		
		readMeInitCheck.click();
		createReposityBtn.submit();	
		
		log.info("Repository created successfully");
	}
	
	public void openCreatedRepository()
	{
		log.info("Clicking on user profile");
		viewProfile.click();
		
		log.info("Clicking on your repository from user profile");
		yourRepositoryBtn.click();
		
		log.info("Clicking on created repository");
		createdRepository.click();		
		
		log.info("Repository open");
	}
	
	public void creatNewIssue(String title,String description)
	{
		log.info("Clicking on Issue button");
		issueBtn.click();
		
		log.info("Clicking on new Issue button");
		newIssueBtn.click();
		
		log.info("Entering issue name");
		issueTitle.sendKeys(title);
		
		log.info("Enter issue description");
		issueDescription.sendKeys(description);
		
		log.info("Clicking on issue submit button");
		submitNewIssueBtn.submit();	
		
		log.info("Issue created successfully");
	}
	
	public String getIssueName()
	{
		log.info("Returning the Issue name "+issueName.getText());
		return issueName.getText();
	}
	
	public void addingIssueHrefIntoArray()
	{
		log.info("Clicking on Issue button");
		issueBtn.click();
		
		log.info("Printing the total issue created :-"+issueList.size());
		for( WebElement issue:issueList)
		{
			String issueUrl=issue.getAttribute("href");
			log.info("Adding issue href into array:- "+issueUrl);
			
			array.add(issueUrl);
		}
		log.info("Issue href successfully added into array");
	}
	
	public void addingCommentIntoIssue()
	{
		addingIssueHrefIntoArray();	
		
		for(int i=0;i<array.size();i++)
		{
			log.info("Navigating to issue "+array.get(i));
			driver.navigate().to(array.get(i));
			
			String iName=issueName.getText();
			log.info("Issue name is "+iName);
			
			log.info("Clicking on comment section");
			issueComment.click();
			
			log.info("Adding comment into issue "+i);
			issueComment.sendKeys("Adding comment into issue "+iName);
			comment.submit();	
			log.info("Commment added in issue "+i);
		}
	}
	
	public void editRepositoryName(String emoji)
	{
		log.info("Clicking on edit repository name");
		editRepository.click();
		
		log.info("Adding emoji into reporitory name");
		editLine.sendKeys(emoji);
		
		log.info("Clicking on submit button");
		commitChanges.submit();	
		
		log.info(emoji+" Emoji successfully added into repository");
	}
	
	public void mentionIssueIntoCommentAnd_NavigatingToIssueFromComment()
	{
		addingIssueHrefIntoArray();
		
		for(int i=0;i<array.size();i++)
		{	
			if(i==0)
			{
				driver.navigate().to(array.get(i));
				log.info("Storing the ");
				Issue2=array.get(i);
			}
			if(i==1)
			{
				log.info("Navigating to issue "+array.get(i));
				driver.navigate().to(array.get(i));
				Issue1=array.get(i);
				issueComment.click();
				issueComment.clear();
				log.info("Commenting in "+Issue1);
				issueComment.sendKeys("Commenting "+Issue2+" into "+Issue1);
				comment.submit();				
				log.info("Comment submitted in "+Issue1);
			}
		}
		log.info("Navigating to issue "+Issue2+" from comment section");
		driver.navigate().to(Issue2);
		log.info("Successfully naviagted to commented issue");
	}
	
	public void deleteRepository()
	{
		log.info("Clicking on setting button");
		settingBtn.click();
		
		log.info("Clicking on delete repository button");
		deleteRepositoryBtn.click();
		
		String str=copyRepositoryName.getText();
		log.info("Sending the repository name "+str+" to delete the created repository");
		repositoryNameConfirmation.sendKeys(str);
		log.info("Clicking on delete button");
		deleteThisRepositoryBtn.submit();
		
		log.info("Created repository deleted successfully");
	}
	
	
}
