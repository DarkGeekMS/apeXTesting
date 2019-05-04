package TestingScript;

import org.junit.Assert;


import static org.testng.Assert.assertTrue;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import DriverDef.Chrome;
import PageModel.LoginPage;
import PageModel.Post;

public class PostTest {
	
	public Chrome driver;
	public Post post;
	public LoginPage login;
	public Actions builder;
	public Action act;
	void signin(String name,String pass) throws InterruptedException {
		try {
	  		login.signBtn = driver.LocateById(login.signBtnID);
		}catch(Exception e) {
			logout();
		}
		try {
	  		login.signBtn = driver.LocateById(login.signBtnID);
		}catch(Exception e) {
			System.out.println("Can't find the signIn Button");
			Assert.assertTrue(false);
		}
	  	act = builder.moveToElement(login.signBtn).click().build();
	  	act.perform(); 
	  	Thread.sleep(5000);
	  	try {
		   login.userNametxt = driver.LocateById(login.userNametxtID);
		   login.paswordtxt = driver.LocateById(login.paswordtxtID);
		   login.submit = driver.LocateByXpath("//*[@id='partition-register']/div[2]/form/button");
		}catch(Exception e) {
			System.out.println("Can't find the submit Button ");
			Assert.assertTrue(false);
		}
	  	act = builder.sendKeys(login.userNametxt,Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE).build();
	  	act.perform();
	  	act = builder.sendKeys(login.paswordtxt,Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE).build();
	  	act.perform();
	  	Thread.sleep(5000);
	  	act = builder.sendKeys(login.userNametxt,name).build();
	  	act.perform();
	  	act = builder.sendKeys(login.paswordtxt,pass).build();
	  	act.perform();
	  	act = builder.moveToElement(login.submit).click().build();
	  	act.perform();
	  	Thread.sleep(5000);
	}
	void logout() throws InterruptedException {
		try {
			login.logout = driver.LocateById(login.logoutDivID);
		}catch(Exception e) {
			System.out.println("Can't find logout btn 5");
			Assert.assertTrue(false);
		}
	  	act = builder.moveToElement(login.logout).click().build();
		act.perform();
		Thread.sleep(5000);
		try {
			login.logoutButton = driver.LocateByXpath("//*[@id='loggedbutton']//following-sibling::ul/li[5]");
		}catch(Exception e) {
			System.out.println("Can't find logout btn 5");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(login.logoutButton).click().build();
		act.perform();
		Thread.sleep(5000);
	}
	@BeforeClass
	public void init()
	{
		driver = new Chrome();
		post = new Post();
		login = new LoginPage();
		builder = new Actions(driver.driver);
		System.out.println("Post test starts");
	}
	@AfterClass
	public void finalize()
	{
		driver.shutdown();
		System.out.println("Post test ends");
	}
	
	//without login tests
	@Test(priority=0,description="Press on every part of a post and check if it opens it or not(works for logged person or not)")
	public void test1() throws InterruptedException {
		driver.nav(driver.Url);
		Thread.sleep(3000);
		try {
			post.FullPost = driver.LocateByXpath(post.FullPostXPath);
			act = builder.moveToElement(post.FullPost).click().build();
			act.perform();
			Thread.sleep(3000);
			try {
				driver.LocateById(post.PostContentId);
				System.out.println("clicking Full post worked");
			}catch(Exception e) {
				System.out.println("Test 1 failed Didn't open While clicking on Full post");
				Assert.assertTrue(false);
			}
		}catch(Exception e) {
			System.out.println("can't Find Full Post Element");
			Assert.assertTrue(false);
		}
		driver.nav(driver.Url);
		Thread.sleep(3000);
		try {
			post.PostBody = driver.LocateByXpath(post.PostBodyXPath);
			act = builder.moveToElement(post.PostBody).click().build();
			act.perform();
			Thread.sleep(3000);
			try {
				driver.LocateById(post.PostContentId);
				System.out.println("Clicking on Post Body worked");
			}catch(Exception e) {
				System.out.println("Test 1 failed Didn't open While clicking on post's Body");
				Assert.assertTrue(false);
			}
		}catch(Exception e) {
			System.out.println("can't Find post body");
			Assert.assertTrue(false);
		}
		driver.nav(driver.Url);
		Thread.sleep(3000);
		try {
			post.time = driver.LocateById(post.TimeId);
			act = builder.moveToElement(post.time).click().build();
			act.perform();
			Thread.sleep(3000);
			try {
				driver.LocateById(post.PostContentId);
				System.out.println("clicking post time worked");
			}catch(Exception e) {
				System.out.println("Test 1 failed Didn't open While clicking on post's time");			}
		}catch(Exception e) {
			System.out.println("can't Find post's time");
			Assert.assertTrue(false);
		}
		driver.nav(driver.Url);
		Thread.sleep(3000);
		try {
			post.PostFooter = driver.LocateByXpath("//div[@id='post']//footer");
			act = builder.moveToElement(post.PostFooter).click().build();
			act.perform();
			Thread.sleep(3000);
			try {
				driver.LocateById(post.PostContentId);
				System.out.println("clicking footer of post worked");
			}catch(Exception e) {
				System.out.println("Test 1 failed Didn't open While clicking on post's footer");
				Assert.assertTrue(false);
			}
		}catch(Exception e) {
			System.out.println("can't Find post's footer Element");
			Assert.assertTrue(false);
		}
		driver.nav(driver.Url);
		Thread.sleep(3000);
		try {
			post.CommentButton = driver.LocateByXpath(post.CommentButtonXPath);
			act = builder.moveToElement(post.CommentButton).click().build();
			act.perform();
			Thread.sleep(3000);
			try {
				driver.LocateById(post.PostContentId);
				System.out.println("clicking Comment Button worked");
			}catch(Exception e) {
				System.out.println("Test 1 failed Didn't open While clicking on Comment Button");
				Assert.assertTrue(false);
			}
		}catch(Exception e) {
			System.out.println("can't Find Comment Button");
			Assert.assertTrue(false);
		}
		driver.nav(driver.Url);
		Thread.sleep(3000);
		try {
			post.PostVote = driver.LocateByXpath(post.PostVoteXPath);
			act = builder.moveToElement(post.PostVote).click().build();
			act.perform();
			Thread.sleep(3000);
			try {
				driver.LocateById(post.PostContentId);
				System.out.println("clicking Vote Counter of post worked");
			}catch(Exception e) {
				System.out.println("Test 1 failed Didn't open While clicking on post's Vote Counter");
				Assert.assertTrue(false);
			}
		}catch(Exception e) {
			System.out.println("can't Find Vote Counter Element");
			Assert.assertTrue(false);
		}
		System.out.println("Test 1 passed");
	}
	
	
	@Test(priority=1,description="Create post's Button without Login")
	public void test2()throws Throwable{
		  driver.nav(driver.Url);
		  Thread.sleep(3000);
		  WebElement CreatePost = null;
		  try {
		  CreatePost = driver.LocateByXpath("//*[@id='main']/button[1]");
		  }catch(Exception e) {
			  System.out.println("Can't find creation button");
			  Assert.assertTrue(false);
		  }
		  act = builder.moveToElement(CreatePost).click().build();
		  act.perform();
		  Thread.sleep(3000);
		  try {
			  login.signBtn = driver.LocateById(login.signBtnID);
		  }catch(Exception e) {
			  System.out.println("Didn't open Login Form");
			  Assert.assertTrue(false);
		  }
		  System.out.println("Create Post Without Login passed");
	}
	
	@Test(priority=2,description="Try To Comment Without Logging In")
	public void test3() throws Throwable{
		driver.nav(driver.Url);
		Thread.sleep(3000);
		try {
			post.FullPost = driver.LocateByXpath(post.FullPostXPath);
		}catch(Exception e) {
			System.out.println("can't Find Full Post Element");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(post.FullPost).click().build();
		act.perform();
		Thread.sleep(3000);
		try {
			post.PostContent = driver.LocateById(post.PostContentId);
		}catch(Exception e) {
			System.out.println("Didn't Open Post");
			Assert.assertTrue(false);
		}
		try {
			post.CommentSpace = driver.LocateById(post.CommentSpaceId);
			post.InnerCommentButton = driver.LocateById(post.InnerCommentButtonId);
		}catch(Exception e) {
			System.out.println("Can't Find Post Area");
			Assert.assertTrue(false);
		}
		act =builder.sendKeys(post.CommentSpace,"Hello World").build();
		act.perform();
		act = builder.moveToElement(post.InnerCommentButton).click().build();
		act.perform();
		Thread.sleep(3000);
		try {
			driver.LocateByXpath("/html/body/div[2]/div/div[2]/div/button").click();
		}catch(Exception e) {
			System.out.println("Can't Find Alert Message");
			Assert.assertTrue(false);
		}
		System.out.println("Commenting without login Passed");
	}
	
	@Test(priority=3,description="Try To save Without Logging In")
	public void test4() throws Throwable{
		driver.nav(driver.Url);
		Thread.sleep(3000);
		try {
			post.PostSaveButton = driver.LocateByXpath(post.PostSaveButtonXPath);
		}catch(Exception e) {
			System.out.println("can't Find save Button");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(post.PostSaveButton).click().build();
		act.perform();
		Thread.sleep(3000);
		try {
			driver.LocateByXpath("/html/body/div[2]/div/div[2]/div/button").click();
		}catch(Exception e) {
			System.out.println("Can't Find Alert Message");
			Assert.assertTrue(false);
		}
		System.out.println("Saving without login Passed");
	}
	
	@Test(priority=4,description="Try To Hide Without Logging In")
	public void test5() throws Throwable{
		driver.nav(driver.Url);
		Thread.sleep(3000);
		try {
			post.PostExtra = driver.LocateByXpath(post.PostExtraXPath);
		}catch(Exception e) {
			System.out.println("can't Find Extra Button");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(post.PostExtra).click().build();
		act.perform();
		Thread.sleep(3000);
		try {
			post.HideIcon = driver.LocateByXpath(post.PostHideXpath);
		}catch(Exception e) {
			System.out.println("Can't Find Hide icon");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(post.HideIcon).click().build();
		act.perform();
		Thread.sleep(3000);
		try {
			driver.LocateByXpath("/html/body/div[2]/div/div[2]/div/button").click();
		}catch(Exception e) {
			System.out.println("Can't Find Alert Message");
			Assert.assertTrue(false);
		}
		System.out.println("Hiding without login Passed");
	}
	@Test(priority=5,description="Try To report Without Logging In")
	public void test6() throws Throwable{
		driver.nav(driver.Url);
		Thread.sleep(3000);
		try {
			post.PostExtra = driver.LocateByXpath(post.PostExtraXPath);
		}catch(Exception e) {
			System.out.println("can't Find Extra Button");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(post.PostExtra).click().build();
		act.perform();
		Thread.sleep(3000);
		try {
			post.Report = driver.LocateByXpath(post.PostReportXpath);
		}catch(Exception e) {
			System.out.println("Can't Find Report icon");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(post.Report).click().build();
		act.perform();
		Thread.sleep(3000);
		try {
			driver.LocateByXpath("/html/body/div[2]/div/div[2]/div/button").click();
		}catch(Exception e) {
			System.out.println("Can't Find Alert Message");
			Assert.assertTrue(false);
		}
		System.out.println("Reporting without login Passed");
	}
	@Test(priority=6,description="Try To Vote Without Logging In")
	public void test7() throws Throwable{
		driver.nav(driver.Url);
		Thread.sleep(3000);
		try {
			post.PostUpVote = driver.LocateByXpath(post.PostUpVoteXPath);
		}catch(Exception e) {
			System.out.println("can't Find UpVote Button");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(post.PostUpVote).click().build();
		act.perform();
		Thread.sleep(3000);
		try {
			driver.LocateByXpath("/html/body/div[2]/div/div[2]/div/button").click();
		}catch(Exception e) {
			System.out.println("Can't Find Alert Message");
			Assert.assertTrue(false);
		}
		driver.nav(driver.Url);
		Thread.sleep(3000);
		try {
			post.PostDownVote = driver.LocateByXpath(post.PostDownVoteXPath);
		}catch(Exception e) {
			System.out.println("can't Find DownVote Button");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(post.PostDownVote).click().build();
		act.perform();
		Thread.sleep(3000);
		try {
			driver.LocateByXpath("/html/body/div[2]/div/div[2]/div/button").click();
		}catch(Exception e) {
			System.out.println("Can't Find Alert Message");
			Assert.assertTrue(false);
		}
		System.out.println("Voting without login Passed");
	}
	// after login
	@Test(priority=7,description="Try To Vote with Logging In")
	public void test8() throws Throwable{
		driver.nav(driver.Url);
		Thread.sleep(3000);
		signin("hell12","hell12");
		try {
			post.PostUpVote = driver.LocateByXpath(post.PostUpVoteXPath);
			post.PostVote = driver.LocateByXpath(post.PostVoteXPath);
		}catch(Exception e) {
			System.out.println("can't Find UpVote Button");
			Assert.assertTrue(false);
		}
		int before = Integer.parseInt(post.PostVote.getText());
		act = builder.moveToElement(post.PostUpVote).click().build();
		act.perform();
		Thread.sleep(3000);
		try {
			driver.LocateByXpath("/html/body/div[2]/div/div[2]/div/button").click();
		}catch(Exception e) {
			System.out.println("Can't Find Alert Message");
			Assert.assertTrue(false);
		}
		Thread.sleep(3000);
		int after = Integer.parseInt(post.PostVote.getText());
		Assert.assertEquals(before+1, after);
		act = builder.moveToElement(post.PostUpVote).click().build();
		act.perform();
		Thread.sleep(3000);
		try {
			driver.LocateByXpath("/html/body/div[2]/div/div[2]/div/button").click();
		}catch(Exception e) {
			System.out.println("Can't Find Alert Message");
			Assert.assertTrue(false);
		}
		Thread.sleep(3000);
		after = Integer.parseInt(post.PostVote.getText());
		Assert.assertEquals(before, after);
		driver.nav(driver.Url);
		Thread.sleep(3000);
		try {
			post.PostDownVote = driver.LocateByXpath(post.PostDownVoteXPath);
			post.PostVote = driver.LocateByXpath(post.PostVoteXPath);
		}catch(Exception e) {
			System.out.println("can't Find DownVote Button");
			Assert.assertTrue(false);
		}
		Thread.sleep(3000);
		before = Integer.parseInt(post.PostVote.getText());
		act = builder.moveToElement(post.PostDownVote).click().build();
		act.perform();
		Thread.sleep(3000);
		try {
			driver.LocateByXpath("/html/body/div[2]/div/div[2]/div/button").click();
		}catch(Exception e) {
			System.out.println("Can't Find Alert Message");
			Assert.assertTrue(false);
		}
		Thread.sleep(3000);
		after = Integer.parseInt(post.PostVote.getText());
		Assert.assertEquals(before-1, after);
		act = builder.moveToElement(post.PostDownVote).click().build();
		act.perform();
		Thread.sleep(3000);
		try {
			driver.LocateByXpath("/html/body/div[2]/div/div[2]/div/button").click();
		}catch(Exception e) {
			System.out.println("Can't Find Alert Message");
			Assert.assertTrue(false);
		}
		Thread.sleep(3000);
		after = Integer.parseInt(post.PostVote.getText());
		Assert.assertEquals(before, after);
		try {
			post.PostUpVote = driver.LocateByXpath(post.PostUpVoteXPath);
			post.PostVote = driver.LocateByXpath(post.PostVoteXPath);
		}catch(Exception e) {
			System.out.println("can't Find UpVote Button");
			Assert.assertTrue(false);
		}
		before = Integer.parseInt(post.PostVote.getText());
		act = builder.moveToElement(post.PostDownVote).click().build();
		act.perform();
		Thread.sleep(3000);
		try {
			driver.LocateByXpath("/html/body/div[2]/div/div[2]/div/button").click();
		}catch(Exception e) {
			System.out.println("Can't Find Alert Message");
			Assert.assertTrue(false);
		}
		Thread.sleep(3000);
		after = Integer.parseInt(post.PostVote.getText());
		act = builder.moveToElement(post.PostUpVote).click().build();
		act.perform();
		Thread.sleep(3000);
		try {
			driver.LocateByXpath("/html/body/div[2]/div/div[2]/div/button").click();
		}catch(Exception e) {
			System.out.println("Can't Find Alert Message");
			Assert.assertTrue(false);
		}
		Thread.sleep(3000);
		int num = Integer.parseInt(post.PostVote.getText());
		Assert.assertEquals(after+2, num);
		act = builder.moveToElement(post.PostDownVote).click().build();
		act.perform();
		Thread.sleep(3000);
		try {
			driver.LocateByXpath("/html/body/div[2]/div/div[2]/div/button").click();
		}catch(Exception e) {
			System.out.println("Can't Find Alert Message");
			Assert.assertTrue(false);
		}
		Thread.sleep(3000);
		after = Integer.parseInt(post.PostVote.getText());
		Assert.assertEquals(after, num-2);
		act = builder.moveToElement(post.PostDownVote).click().build();
		act.perform();
		Thread.sleep(3000);
		try {
			driver.LocateByXpath("/html/body/div[2]/div/div[2]/div/button").click();
		}catch(Exception e) {
			System.out.println("Can't Find Alert Message");
			Assert.assertTrue(false);
		}
		Thread.sleep(3000);
		System.out.println("Voting without login Passed");
	}
	
	@Test(priority=8,description="Try To report another person's post with Logging In")
	public void test9() throws Throwable{
		driver.nav(driver.Url);
		Thread.sleep(3000);
		String user="",apex="",time="",content="",votes="",title="";
		signin("hell12","hell12");
		try {
			post.PostExtra = driver.LocateByXpath(post.PostExtraXPath);
			content = driver.LocateByXpath(post.PostBodyXPath).getText();
			title = driver.LocateByXpath("//*[@id='post']/div/h3").getText();
			votes = driver.LocateByXpath(post.PostUpVoteXPath).getText();
			time = driver.LocateById(post.TimeId).getText();
			apex = driver.LocateById(post.SubRedditId).getText();
			user = driver.LocateById(post.UserId).getText();
		}catch(Exception e) {
			System.out.println("can't Find Extra Button");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(post.PostExtra).click().build();
		act.perform();
		Thread.sleep(3000);
		if(user == "hell12")
		{
			System.out.println("Can't Report your post");
			Assert.assertTrue(false);
		}
		try {
			post.Report = driver.LocateByXpath(post.PostReportXpath);
		}catch(Exception e) {
			System.out.println("Can't Find Report icon");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(post.Report).click().build();
		act.perform();
		Thread.sleep(3000);
		WebElement choise=null,send=null;
		try {
			choise = driver.LocateByXpath("//*[@id='DisplayPosts']/div/div/div[1]/div/div/div[2]/div[9]/input[4]");
		}catch(Exception e) {
			System.out.println("Report window didn't appear");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(choise).click().build();
		act.perform();
		Thread.sleep(3000);
		try {
			send = driver.LocateById("report2");
		}catch(Exception e) {
			System.out.println("Report Button is Disabled");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(send).click().build();
		act.perform();
		Thread.sleep(3000);
		String alert="";
		try {
			alert = driver.LocateByXpath("/html/body/div[2]/div/div[1]").getText();
			driver.LocateByXpath("/html/body/div[2]/div/div[2]/div/button").click();
		}catch(Exception e) {
			System.out.println("Can't Find Alert Message");
			Assert.assertTrue(false);
		}
		Thread.sleep(3000);
		Assert.assertEquals("success :)", alert);
		String user2="",apex2="",time2="",content2="",votes2="",title2="";
		try {
			content2 = driver.LocateByXpath(post.PostBodyXPath).getText();
			title2 = driver.LocateByXpath("//*[@id='post']/div/h3").getText();
			votes2 = driver.LocateByXpath(post.PostUpVoteXPath).getText();
			time2 = driver.LocateById(post.TimeId).getText();
			apex2 = driver.LocateById(post.SubRedditId).getText();
			user2 = driver.LocateById(post.UserId).getText();
		}catch(Exception e) {
			System.out.println("can't Find Extra Button");
			Assert.assertTrue(false);
		}
		Assert.assertEquals(user,user2);
		Assert.assertEquals(apex,apex2);
		Assert.assertEquals(time,time2);
		Assert.assertEquals(votes,votes2);
		Assert.assertEquals(title,title2);
		Assert.assertEquals(content,content2);
		System.out.println("Reporting without login Passed");
	}
	
	@Test(priority=9,description="Try To Hide a post with Logging In (if the test is passed then it's a hide if it failed then it's an unhide")
	public void test10() throws Throwable{
		driver.nav(driver.Url);
		Thread.sleep(3000);
		String user="",apex="",time="",content="",votes="",title="";
		signin("hell12","hell12");
		try {
			post.PostExtra = driver.LocateByXpath(post.PostExtraXPath);
			content = driver.LocateByXpath(post.PostBodyXPath).getText();
			title = driver.LocateByXpath("//*[@id='post']/div/h3").getText();
			votes = driver.LocateByXpath(post.PostVoteXPath).getText();
			time = driver.LocateById(post.TimeId).getText();
			apex = driver.LocateById(post.SubRedditId).getText();
			user = driver.LocateById(post.UserId).getText();
		}catch(Exception e) {
			System.out.println("can't Find Extra Button");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(post.PostExtra).click().build();
		act.perform();
		Thread.sleep(3000);
		try {
			post.HideIcon = driver.LocateByXpath(post.PostHideXpath);
		}catch(Exception e) {
			System.out.println("Can't Find Hide icon");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(post.HideIcon).click().build();
		act.perform();
		Thread.sleep(3000);
		String alert="";
		try {
			alert = driver.LocateByXpath("/html/body/div[2]/div/div[2]").getText();
			driver.LocateByXpath("/html/body/div[2]/div/div[4]/div/button").click();
		}catch(Exception e) {
			System.out.println("Can't Find Alert Message");
			Assert.assertTrue(false);
		}
		Thread.sleep(3000);
		Assert.assertEquals("Post Hidden Successfully!", alert);
		String user2="",apex2="",time2="",content2="",votes2="",title2="";
		try {
			content2 = driver.LocateByXpath(post.PostBodyXPath).getText();
			title2 = driver.LocateByXpath("//*[@id='post']/div/h3").getText();
			votes2 = driver.LocateByXpath(post.PostUpVoteXPath).getText();
			time2 = driver.LocateById(post.TimeId).getText();
			apex2 = driver.LocateById(post.SubRedditId).getText();
			user2 = driver.LocateById(post.UserId).getText();
		}catch(Exception e) {
			System.out.println("No posts to get");
		}
		if(user==user2 && apex==apex2 && time==time2 && votes==votes2 && title==title2 && content==content2)
		{
			System.out.println("Didn't hide");
			Assert.assertTrue(false);
		}
		try {
			login.logout = driver.LocateById(login.logoutDivID);
		}catch(Exception e) {
			System.out.println("Can't find logout btn");
			Assert.assertTrue(false);
		}
	  	act = builder.moveToElement(login.logout).click().build();
		act.perform();
		Thread.sleep(3000);
		WebElement profile = null;
		try {
			profile = driver.LocateByXpath("//*[@id='loggedbutton']//following-sibling::ul/li[2]");
		}catch(Exception e) {
			System.out.println("Can't locate profile Button");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(profile).click().build();
		act.perform();
		Thread.sleep(3000);
		try {
			driver.LocateByXpath("//*[@id='firstnavbar']//a[3]").click();
		}catch(Exception e) {
			System.out.println("Can't find Hidden list");
			Assert.assertTrue(false);
		}
		Thread.sleep(5000);
		List<WebElement>l = driver.driver.findElements(By.xpath("//*[@id='post']"));
		int x=l.size();
		String start = "//*[@id='hiddenposts']//div[@id='DisplayPosts']/div["+Integer.toString(x)+"]//div[@id='post']";
		String contentXpath=start + "//p[@id='postBody']",
				titleXpath=start+"/div/h3",
				votesXpath=start + "//h5[@id='PostVote']",
				timeXpath=start + "//a[@id='timeAgo']",
				apexXpath=start + "//a[@id='subred']",
				userXpath=start + "//a[@id='user']";
		
		try {
			content2 = driver.LocateByXpath(contentXpath).getText();
			title2 = driver.LocateByXpath(titleXpath).getText();
			votes2 = driver.LocateByXpath(votesXpath).getText();
			time2 = driver.LocateByXpath(timeXpath).getText();
			apex2 = driver.LocateByXpath(apexXpath).getText();
			user2 = driver.LocateByXpath(userXpath).getText();
		}catch(Exception e) {
			System.out.println("No posts to get");
		}
		
		Assert.assertEquals(user,user2);
		Assert.assertEquals(apex,apex2);
		Assert.assertEquals(time,time2);
		Assert.assertEquals(votes,votes2);
		Assert.assertEquals(title,title2);
		Assert.assertEquals(content,content2);
		System.out.println("Hiding post with login Passed");
	}
	@Test(priority=10,description="Try To save a post with Logging In (if the test is passed then it's a save if it failed then it's an unsave")
	public void test11() throws Throwable{
		driver.nav(driver.Url);
		Thread.sleep(3000);
		String user="",apex="",time="",content="",votes="",title="",status="";
		signin("hell12","hell12");
		WebElement element=null;
		try {
			driver.LocateByXpath("//*[@id='selected']").click();
		}catch(Exception e) {
			System.out.println("Can't find List icon");
			Assert.assertTrue(false);
		}
		Thread.sleep(3000);
		try {
			element = driver.LocateByXpath("//*[@id='main']/div[1]/ul/li[1]"); //Hot
		}catch(Exception e) {
			System.out.println("Can't find List item icon");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(element).click().build();
		act.perform();
		Thread.sleep(3000);
		try {
			content = driver.LocateByXpath(post.PostBodyXPath).getText();
			title = driver.LocateByXpath("//*[@id='post']/div/h3").getText();
			votes = driver.LocateByXpath(post.PostVoteXPath).getText();
			time = driver.LocateById(post.TimeId).getText();
			apex = driver.LocateById(post.SubRedditId).getText();
			user = driver.LocateById(post.UserId).getText();
			status = driver.LocateById("SaveButton").getText();
		}catch(Exception e) {
			System.out.println("can't Find Extra Button");
			Assert.assertTrue(false);
		}
		try {
			post.PostSaveButton = driver.LocateByXpath(post.PostSaveButtonXPath);
		}catch(Exception e) {
			System.out.println("Can't Find save icon");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(post.PostSaveButton).click().build();
		act.perform();
		Thread.sleep(3000);
		String alert="";
		try {
			alert = driver.LocateByXpath("/html/body/div[2]/div/div[1]").getText();
			driver.LocateByXpath("/html/body/div[2]/div/div[2]/div/button").click();
		}catch(Exception e) {
			System.out.println("Can't Find Alert Message");
			Assert.assertTrue(false);
		}
		Thread.sleep(3000);
		Assert.assertEquals("success :)", alert);
		String user2="",apex2="",time2="",content2="",votes2="",title2="",status2="";
		try {
			content2 = driver.LocateByXpath(post.PostBodyXPath).getText();
			title2 = driver.LocateByXpath("//*[@id='post']/div/h3").getText();
			votes2 = driver.LocateByXpath(post.PostUpVoteXPath).getText();
			time2 = driver.LocateById(post.TimeId).getText();
			apex2 = driver.LocateById(post.SubRedditId).getText();
			user2 = driver.LocateById(post.UserId).getText();
			status2 = driver.LocateById("SaveButton").getText();
		}catch(Exception e) {
			System.out.println("No posts to get");
			Assert.assertTrue(false);
		}
		if(user==user2 && apex==apex2 && time==time2 && votes==votes2 && title==title2 && content==content2 && status!=status2)
		{
			System.out.println("Saved");
		}
		try {
			login.logout = driver.LocateById(login.logoutDivID);
		}catch(Exception e) {
			System.out.println("Can't find logout btn");
			Assert.assertTrue(false);
		}
	  	act = builder.moveToElement(login.logout).click().build();
		act.perform();
		Thread.sleep(3000);
		WebElement profile = null;
		try {
			profile = driver.LocateByXpath("//*[@id='loggedbutton']//following-sibling::ul/li[2]");
		}catch(Exception e) {
			System.out.println("Can't locate profile Button");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(profile).click().build();
		act.perform();
		Thread.sleep(5000);
		WebElement elem=null;
		try {
			elem = driver.LocateByXpath("//*[@id='savedtab']");
		}catch(Exception e) {
			System.out.println("Can't find Hidden list");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(elem).click().build();
		act.perform();
		Thread.sleep(5000);
		List<WebElement>l = driver.driver.findElements(By.xpath("//*[@id='post']"));
		int x=l.size();
		for(int i=1;i<=x;i++)
		{
			String start = "//*[@id='hiddenposts']//div[@id='DisplayPosts']/div["+Integer.toString(i)+"]//div[@id='post']";
			String contentXpath=start + "//p[@id='postBody']",
					titleXpath=start+"/div/h3",
					votesXpath=start + "//h5[@id='PostVote']",
					timeXpath=start + "//a[@id='timeAgo']",
					apexXpath=start + "//a[@id='subred']",
					userXpath=start + "//a[@id='user']",
					savebuttonXpath = start + "//button[@id='SaveButton']";
			try {
				content2 = driver.LocateByXpath(contentXpath).getText();
				title2 = driver.LocateByXpath(titleXpath).getText();
				votes2 = driver.LocateByXpath(votesXpath).getText();
				time2 = driver.LocateByXpath(timeXpath).getText();
				apex2 = driver.LocateByXpath(apexXpath).getText();
				user2 = driver.LocateByXpath(userXpath).getText();
			}catch(Exception e) {
				System.out.println("No posts to get");
			}
			if(user==user2 && apex==apex2 && time==time2 && votes==votes2 && title==title2 && content==content2)
			{
				// when we unsave the post from the profile it doesn't disappear
				try {
					WebElement s =driver.LocateByXpath(savebuttonXpath);
					s.click();
					Thread.sleep(3000);
				}catch(Exception e) {
					System.out.println("Unsaving error");
				}
				try {
					driver.LocateByXpath(savebuttonXpath).click();
					Thread.sleep(3000);
					alert="";
					try {
						alert = driver.LocateByXpath("/html/body/div[2]/div/div[1]").getText();
						driver.LocateByXpath("/html/body/div[2]/div/div[2]/div/button").click();
					}catch(Exception e) {
						System.out.println("Can't Find Alert Message");
						Assert.assertTrue(false);
					}
					Thread.sleep(3000);
					Assert.assertEquals("success :)", alert);
					System.out.println("Post Stil Exists in profile");
					Assert.assertTrue(false);
				}catch(Exception e) {
					System.out.println("unsaved successfully");
				}
				break;
			}
		}
		Assert.assertEquals(user,user2);
		Assert.assertEquals(apex,apex2);
		Assert.assertEquals(time,time2);
		Assert.assertEquals(votes,votes2);
		Assert.assertEquals(title,title2);
		Assert.assertEquals(content,content2);
		System.out.println("Saving post with login Passed");
	}
	
	@Test(priority=11,description="(full test)non empty Comment After Logging In as empty comment has no response") //empty comment has no response
	public void test12() throws Throwable{
		driver.nav(driver.Url);
		Thread.sleep(3000);
		String msg="E2E testing";
		signin("hell12","hell12");
		try {
			post.CommentButton = driver.LocateByXpath(post.CommentButtonXPath);
		}catch(Exception e) {
			System.out.println("can't Find comment button");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(post.CommentButton).click().build();
		act.perform();
		Thread.sleep(3000);
		try {
			post.PostContent = driver.LocateById(post.PostContentId);
		}catch(Exception e) {
			System.out.println("Didn't Open Post");
			Assert.assertTrue(false);
		}
		try {
			post.CommentSpace = driver.LocateById(post.CommentSpaceId);
			post.InnerCommentButton = driver.LocateById(post.InnerCommentButtonId);
		}catch(Exception e) {
			System.out.println("Can't Find Post Area");
			Assert.assertTrue(false);
		}
		act =builder.sendKeys(post.CommentSpace,msg).build();
		act.perform();
		act = builder.moveToElement(post.InnerCommentButton).click().build();
		act.perform();
		Thread.sleep(5000);
		List<WebElement>list = driver.driver.findElements(By.id("Comment"));
		int x = list.size();
		String start = "//*[@id='CommentParent']/div["+Integer.toString(x+1)+"]//div[@id='Comment']";
		String contentXpath = start+"//div[@id='secondLine']//p",
				upvoteXpath = start+"//button[@id='Up']",
				downvoteXpath = start+"//button[@id='Down']",
				ReplyXpath = start+"//div[@id='thirdLine']/button[1]",
				saveXpath =  start+"//div[@id='thirdLine']/button[3]",
				EditXpath =  start+"//div[@id='thirdLine']/button[4]",
				deleteXpath =  start+"//div[@id='thirdLine']/button[5]",
				voteXpath = start+"//div[@id='firstLine']/b[1]";
		WebElement reply=null,save=null,edit=null,delete=null,content=null,votes=null;
		try {
			reply=driver.LocateByXpath(ReplyXpath);
			save=driver.LocateByXpath(saveXpath);
			edit=driver.LocateByXpath(EditXpath);
			delete=driver.LocateByXpath(deleteXpath);
			content=driver.LocateByXpath(contentXpath);
			votes=driver.LocateByXpath(voteXpath);
		}catch(Exception e) {
			System.out.println("Missing elements");
			Assert.assertTrue(false);
		}
		String state=save.getText();
		act=builder.moveToElement(save).click().build();
		act.perform();
		Thread.sleep(3000);
		Assert.assertNotEquals(state, save.getText());
		System.out.println("Save is passed");
		act=builder.moveToElement(edit).click().build();
		act.perform();
		Thread.sleep(3000);
		WebElement Edittext=null,editButton=null;
		try {
			Edittext=driver.LocateByXpath(start+"//div[@id='thirdLine']//following-sibling::div[@id='EditBox']/div/textarea");
			editButton = driver.LocateByXpath(start+"//div[@id='thirdLine']//following-sibling::div[@id='EditBox']/div[2]/button[2]");
		}catch(Exception e) {
			System.out.println("Can't find edit window");
		}
		act=builder.sendKeys(Edittext, msg).build();
		act.perform();
		act=builder.moveToElement(editButton).click().build();
		act.perform();
		Thread.sleep(3000);
		Assert.assertEquals(content.getText(), msg+msg);
		System.out.println("Edit test passed");
		act=builder.moveToElement(reply).click().build();
		act.perform();
		Thread.sleep(2000);
		try {
			Edittext=driver.LocateByXpath(start+"//div[@id='thirdLine']//following-sibling::div[@id='WriteComment']/div/textarea");
			editButton = driver.LocateByXpath("//*[@id='Reply']");
		}catch(Exception e) {
			System.out.println("Can't find reply window");
		}
		act=builder.sendKeys(Edittext, "okay").build();
		act.perform();
		act=builder.moveToElement(editButton).click().build();
		act.perform();
		Thread.sleep(3000);
		start = "//*[@id='CommentParent']/div["+Integer.toString(x+2)+"]//div[@id='Comment']";
		String deletereplyXpath =  start+"//div[@id='thirdLine']/button[5]";
		try {
			driver.LocateByXpath(deletereplyXpath).click();
		}catch(Exception e) {
			System.out.println("Didn't reply");
			Assert.assertTrue(false);
		}
		Thread.sleep(3000);
		System.out.println("Replying test passed");
		act=builder.moveToElement(delete).click().build();
		act.perform();
		Thread.sleep(2000);
		try {
			delete=driver.LocateByXpath(deleteXpath);
		}catch(Exception e) {
			System.out.println("Deleted Successfully");
			return;
		}
		System.out.println("failed to delete");
		Assert.assertTrue(false);
	}
	
	@Test(priority=12,description="Create post's Button with Login")
	public void test13()throws Throwable{
		driver.nav(driver.Url);
		Thread.sleep(3000);
		signin("hell12","hell12");
		WebElement CreatePost = null;
		try {
		  CreatePost = driver.LocateByXpath("//*[@id='main']/button[1]");
		  }catch(Exception e) {
			  System.out.println("Can't find creation button");
			  Assert.assertTrue(false);
		  }
		  act = builder.moveToElement(CreatePost).click().build();
		  act.perform();
		  Thread.sleep(3000);
		  String Url = driver.driver.getCurrentUrl();
		  Assert.assertEquals(Url, driver.Url+"/Submit");
		  try {
			  driver.LocateByXpath("//*[@id='selectList']").click();
		  }catch(Exception e) {
			  System.out.println("Selection not found");
		  }
		  Thread.sleep(3000);
		  try {
			  driver.LocateByXpath("//*[@id='selectList']/option[2]").click();
		  }catch(Exception e) {
			  System.out.println("Selection not found");
		  }
		  Thread.sleep(3000);
		  try {
			  driver.LocateByXpath("//*[@id='usr']").sendKeys("E2E testing");
		  }catch(Exception e) {
			  System.out.println("title not found");
		  }
		  Thread.sleep(3000);
		  try {
			  driver.LocateByXpath("//*[@id='textsendnormal']").sendKeys("E2E testing subject");
		  }catch(Exception e) {
			  System.out.println("body not found");
		  }
		  Thread.sleep(3000);
		  WebElement elem=null;
		  try {
			  elem=driver.LocateByXpath("//*[@id='switchId']");
		  }catch(Exception e) {
			  System.out.println("Switch not found");
		  }
		  Thread.sleep(3000);
		  String tmp=elem.getText();
		  act = builder.moveToElement(elem).click().build();
		  act.perform();
		  Thread.sleep(1000);
		  Assert.assertNotEquals(tmp, elem.getText());
		  try {
			  driver.LocateByXpath("//*[@id='button']").click();
		  }catch(Exception e) {
			  System.out.println("submit not found");
		  }
		  Thread.sleep(3000);
		  try {
			  tmp=driver.LocateByXpath("/html/body/div[2]/div/div[2]").getText();
			  driver.LocateByXpath("/html/body/div[2]/div/div[4]/div/button").click();
		  }catch(Exception e) {
			  System.out.println("alert didn't appear");
		  }
		  Assert.assertEquals("Submitted Successfully!", tmp);
		  System.out.println("Created post successfully");
	}
	
	@Test(priority=13,description="Edit post")
	public void test14()throws Throwable{
		driver.nav(driver.Url);
		Thread.sleep(3000);
		signin("hell12","hell12");
		try {
			login.logout = driver.LocateById(login.logoutDivID);
		}catch(Exception e) {
			System.out.println("Can't find logout btn");
			Assert.assertTrue(false);
		}
	  	act = builder.moveToElement(login.logout).click().build();
		act.perform();
		Thread.sleep(1000);
		WebElement elem = null;
		try {
			elem = driver.LocateByXpath("//*[@id='loggedbutton']//following-sibling::ul/li[2]");
		}catch(Exception e) {
			System.out.println("Can't locate profile Button");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(elem).click().build();
		act.perform();
		Thread.sleep(3000);
		try {
			elem = driver.LocateByXpath("//*[@id='firstnavbar']//a[1]");
		}catch(Exception e) {
			System.out.println("Can't locate posts Button");
			Assert.assertTrue(false);
		}
		try {
			elem=driver.LocateByXpath(post.PostExtraXPath);
		}catch(Exception e) {
			System.out.println("Can't find arrow Button");
			Assert.assertTrue(false);
		}
		act=builder.moveToElement(elem).click().build();
		act.perform();
		Thread.sleep(3000);
		try {
			elem=driver.LocateByXpath("//*[@id='dropMenu']/li[3]/a");
		}catch(Exception e) {
			System.out.println("Can't find edit Button");
			Assert.assertTrue(false);
		}
		act=builder.moveToElement(elem).click().build();
		act.perform();
		Thread.sleep(3000);
		WebElement elem2=null;
		try {
			elem=driver.LocateByXpath("//*[@id='textarea']");
			elem2=driver.LocateByXpath("//*[@id='saveEdit']");
		}catch(Exception e) {
			System.out.println("Can't find edit Button");
			Assert.assertTrue(false);
		}
		act=builder.sendKeys(elem,"mohamed").build();
		act.perform();
		Thread.sleep(3000);
		act=builder.moveToElement(elem2).click().build();
		act.perform();
		Thread.sleep(3000);
		String tmp="";
		try {
			  tmp=driver.LocateByXpath("/html/body/div[2]/div/div[2]").getText();
			  driver.LocateByXpath("/html/body/div[2]/div/div[4]/div/button").click();
		  }catch(Exception e) {
			  System.out.println("alert didn't appear");
		  }
		  Assert.assertEquals("Post edited successfully", tmp);
		  try {
				elem=driver.LocateByXpath("//*[@id='textarea']");
				elem2=driver.LocateByXpath("//*[@id='saveEdit']");
				Assert.assertTrue(false);
			}catch(Exception e) {
				System.out.println("Edited");
			}
		  System.out.println("Created post successfully");
	}
	@Test(priority=14,description="lock post")
	public void test15()throws Throwable{
		driver.nav(driver.Url);
		Thread.sleep(3000);
		signin("hell12","hell12");
		try {
			login.logout = driver.LocateById(login.logoutDivID);
		}catch(Exception e) {
			System.out.println("Can't find logout btn");
			Assert.assertTrue(false);
		}
	  	act = builder.moveToElement(login.logout).click().build();
		act.perform();
		Thread.sleep(1000);
		WebElement elem = null;
		try {
			elem = driver.LocateByXpath("//*[@id='loggedbutton']//following-sibling::ul/li[2]");
		}catch(Exception e) {
			System.out.println("Can't locate profile Button");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(elem).click().build();
		act.perform();
		Thread.sleep(3000);
		try {
			elem = driver.LocateByXpath("//*[@id='firstnavbar']//a[1]");
		}catch(Exception e) {
			System.out.println("Can't locate posts Button");
			Assert.assertTrue(false);
		}
		try {
			elem=driver.LocateByXpath(post.PostExtraXPath);
		}catch(Exception e) {
			System.out.println("Can't find arrow Button");
			Assert.assertTrue(false);
		}
		act=builder.moveToElement(elem).click().build();
		act.perform();
		Thread.sleep(3000);
		try {
			elem=driver.LocateByXpath("//*[@id='dropMenu']/li[5]/a");	
		}catch(Exception e) {
			System.out.println("Can't find lock Button");
			Assert.assertTrue(false);
		}
		act=builder.moveToElement(elem).click().build();
		act.perform();
		Thread.sleep(3000);
		String tmp="";
		try {
			  tmp=driver.LocateByXpath("/html/body/div[2]/div/div[1]").getText();
			  driver.LocateByXpath("/html/body/div[2]/div/div[2]/div/button").click();
		  }catch(Exception e) {
			  System.out.println("alert didn't appear");
		  }
		  Assert.assertEquals("Successfully :)", tmp);
		  System.out.println("locked post successfully");
	}
	@Test(priority=15,description="delete post")
	public void test16()throws Throwable{
		driver.nav(driver.Url);
		Thread.sleep(3000);
		signin("hell12","hell12");
		try {
			login.logout = driver.LocateById(login.logoutDivID);
		}catch(Exception e) {
			System.out.println("Can't find logout btn");
			Assert.assertTrue(false);
		}
	  	act = builder.moveToElement(login.logout).click().build();
		act.perform();
		Thread.sleep(1000);
		WebElement elem = null;
		try {
			elem = driver.LocateByXpath("//*[@id='loggedbutton']//following-sibling::ul/li[2]");
		}catch(Exception e) {
			System.out.println("Can't locate profile Button");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(elem).click().build();
		act.perform();
		Thread.sleep(3000);
		try {
			elem = driver.LocateByXpath("//*[@id='firstnavbar']//a[1]");
		}catch(Exception e) {
			System.out.println("Can't locate posts Button");
			Assert.assertTrue(false);
		}
		try {
			elem=driver.LocateByXpath(post.PostExtraXPath);
		}catch(Exception e) {
			System.out.println("Can't find arrow Button");
			Assert.assertTrue(false);
		}
		act=builder.moveToElement(elem).click().build();
		act.perform();
		Thread.sleep(3000);
		try {
			elem=driver.LocateByXpath("//*[@id='dropMenu']/li[4]/a");	
		}catch(Exception e) {
			System.out.println("Can't find delete Button");
			Assert.assertTrue(false);
		}
		act=builder.moveToElement(elem).click().build();
		act.perform();
		Thread.sleep(3000);
		String tmp="";
		try {
			  tmp=driver.LocateByXpath("/html/body/div[2]/div/div[2]").getText();
			  driver.LocateByXpath("/html/body/div[2]/div/div[4]/div/button").click();
		  }catch(Exception e) {
			  System.out.println("alert didn't appear");
		  }
		  Assert.assertEquals("Post deleted successfully", tmp);
		  System.out.println("deleted post successfully");
	}
}
