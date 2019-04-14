package TestingScript;

import org.junit.Assert;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
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
	@BeforeClass
	public void init()
	{
		driver = new Chrome();
		post = new Post();
		login = new LoginPage();
		builder = new Actions(driver.driver);
		Reporter.log("Post test starts");
	}
	@AfterClass
	public void finalize()
	{
		driver.shutdown();
		Reporter.log("Post test ends");
	}
	
	@Test(priority=0,description="Press on every part of a post and check if it opens it or not(works for logged person or not)")
	public void test1() throws InterruptedException {
		driver.nav(driver.Url);
		Thread.sleep(3000);
		try {
			post.FullPost = driver.LocateById(post.FullPostId);
			act = builder.moveToElement(post.FullPost).click().build();
			act.perform();
			Thread.sleep(1000);
			try {
				driver.LocateById(post.PostContentId);
				Reporter.log("clicking Full post worked");
			}catch(Exception e) {
				Reporter.log("Test 1 failed Didn't open While clicking on Full post");
				Assert.assertTrue(false);
			}
		}catch(Exception e) {
			Reporter.log("can't Find Full Post Element");
			Assert.assertTrue(false);
		}
		driver.nav(driver.Url);
		Thread.sleep(3000);
		try {
			post.PostBody = driver.LocateById(post.PostBodyId);
			act = builder.moveToElement(post.PostBody).click().build();
			act.perform();
			Thread.sleep(1000);
			try {
				driver.LocateById(post.PostContentId);
				Reporter.log("Clicking on Post Body worked");
			}catch(Exception e) {
				Reporter.log("Test 1 failed Didn't open While clicking on post's Body");
				Assert.assertTrue(false);
			}
		}catch(Exception e) {
			Reporter.log("can't Find post body");
			Assert.assertTrue(false);
		}
		driver.nav(driver.Url);
		Thread.sleep(3000);
		try {
			post.time = driver.LocateById(post.TimeId);
			act = builder.moveToElement(post.time).click().build();
			act.perform();
			Thread.sleep(1000);
			try {
				driver.LocateById(post.PostContentId);
				Reporter.log("clicking post time worked");
			}catch(Exception e) {
				Reporter.log("Test 1 failed Didn't open While clicking on post's time");			}
		}catch(Exception e) {
			Reporter.log("can't Find post's time");
			Assert.assertTrue(false);
		}
		driver.nav(driver.Url);
		Thread.sleep(3000);
		try {
			post.PostFooter = driver.LocateByXpath("//div[@id='post']//footer");
			act = builder.moveToElement(post.PostFooter).click().build();
			act.perform();
			Thread.sleep(1000);
			try {
				driver.LocateById(post.PostContentId);
				Reporter.log("clicking footer of post worked");
			}catch(Exception e) {
				Reporter.log("Test 1 failed Didn't open While clicking on post's footer");
				Assert.assertTrue(false);
			}
		}catch(Exception e) {
			Reporter.log("can't Find post's footer Element");
			Assert.assertTrue(false);
		}
		driver.nav(driver.Url);
		Thread.sleep(3000);
		try {
			post.CommentButton = driver.LocateById(post.CommentButtonId);
			act = builder.moveToElement(post.CommentButton).click().build();
			act.perform();
			Thread.sleep(1000);
			try {
				driver.LocateById(post.PostContentId);
				Reporter.log("clicking Comment Button worked");
			}catch(Exception e) {
				Reporter.log("Test 1 failed Didn't open While clicking on Comment Button");
				Assert.assertTrue(false);
			}
		}catch(Exception e) {
			Reporter.log("can't Find Comment Button");
			Assert.assertTrue(false);
		}
		driver.nav(driver.Url);
		Thread.sleep(3000);
		try {
			post.PostVote = driver.LocateById(post.PostVoteId);
			act = builder.moveToElement(post.PostVote).click().build();
			act.perform();
			Thread.sleep(1000);
			try {
				driver.LocateById(post.PostContentId);
				Reporter.log("clicking Vote Counter of post worked");
			}catch(Exception e) {
				Reporter.log("Test 1 failed Didn't open While clicking on post's Vote Counter");
				Assert.assertTrue(false);
			}
		}catch(Exception e) {
			Reporter.log("can't Find Vote Counter Element");
			Assert.assertTrue(false);
		}
		Reporter.log("Test 1 passed");
	}
	
	@Test(priority=1,description="Check save")
	public void test2() throws InterruptedException {
		driver.nav(driver.Url);
		Thread.sleep(3000);
		for(int i=0;i<1;i++) {
		try {
			post.PostSaveButton = driver.LocateById(post.PostSaveButtonId);
		}catch(Exception e) {
			Reporter.log("Save Button Not Found");
			Assert.assertTrue(false);
		}
		String before = post.PostSaveButton.getText();
		act = builder.moveToElement(post.PostSaveButton).click().build();
		act.perform();
		Thread.sleep(1000);
		String after = post.PostSaveButton.getText();
		Assert.assertNotEquals(before, after);
		}
		Reporter.log("Test 2 passed");
	}
	@Test(priority=2,description="Check Hide")
	public void test3() throws Throwable {
		driver.nav(driver.Url);
		Thread.sleep(3000);
		try {
			post.PostExtra = driver.LocateById(post.PostExtraId);
		}catch(Exception e) {
			Reporter.log("Expand Arrow Doesn't Exist");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(post.PostExtra).click().build();
		act.perform();
		Thread.sleep(1000);
		try {
			post.HideIcon = driver.LocateByXpath("//div[@id='post']//a[@class='HIDE']");
		}catch(Exception e) {
			Reporter.log("Hide Icon Doesn't Exist");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(post.HideIcon).click().build();
		act.perform();
		Thread.sleep(1000);
		Alert msg;
		for(int i=0;i<5;i++)
		{
		        try
		        {
		            msg = driver.driver.switchTo().alert();
		            break;
		        }
		        catch(NoAlertPresentException e)
		        {
		          Thread.sleep(1000);
		        }
		}
		msg = driver.driver.switchTo().alert();
		msg.accept();
		Reporter.log("Test 3 Passed");
	}
	
	/*
	//testing comments
	@Test(priority=3,description="Try To Comment Without Logging In")
	public void test4() throws Throwable{
		driver.nav(driver.Url);
		try {
			post.FullPost = driver.LocateById(post.FullPostId);
		}catch(Exception e) {
			Reporter.log("can't Find Full Post Element");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(post.FullPost).click().build();
		act.perform();
		try {
			post.PostContent = driver.LocateById(post.PostContentId);
		}catch(Exception e) {
			Reporter.log("Didn't Open Post");
			Assert.assertTrue(false);
		}
		try {
			post.CommentSpace = driver.LocateById(post.CommentSpaceId);
			post.InnerCommentButton = driver.LocateById(post.InnerCommentButtonId);
		}catch(Exception e) {
			Reporter.log("Can't Find Post Area");
			Assert.assertTrue(false);
		}
		act =builder.sendKeys(post.CommentSpace,"Hello World").build();
		act.perform();
		act = builder.moveToElement(post.InnerCommentButton).click().build();
		act.perform();
		Alert msg;
		for(int i=0;i<5;i++)
		{
		        try
		        {
		            msg = driver.driver.switchTo().alert();
		            break;
		        }
		        catch(NoAlertPresentException e)
		        {
		          Thread.sleep(1000);
		        }
		}
		msg = driver.driver.switchTo().alert();
		msg.accept();
	}
	
	@Test(priority=4,description="non empty Comment After Logging In")
	public void test5() throws Throwable{
		driver.nav(driver.Url);
		LoginPage login = new LoginPage();
		try {
			   login.signBtn = driver.LocateById(login.signBtnID);
		}catch(Exception e) {
				Reporter.log("Can't find the signIn Button");
				Assert.assertTrue(false);
		}
		act = builder.moveToElement(login.signBtn).click().build();
		act.perform(); 
		try {
		   login.userNametxt = driver.LocateById(login.userNametxtID);
		   login.paswordtxt = driver.LocateById(login.paswordtxtID);
		   login.submit = driver.LocateById(login.submitID);
		}catch(Exception e) {
			Reporter.log("Missed Elements in Login Form");
			Assert.assertTrue(false);
		  }
		act = builder.sendKeys(login.userNametxt,"King").build();
		act.perform();
  	  	act = builder.sendKeys(login.paswordtxt,"queen12").build();
		act.perform();
		act = builder.moveToElement(login.submit).click().build();
		act.perform();
		Thread.sleep(5000);
		try {
			post.FullPost = driver.LocateById(post.FullPostId);
		}catch(Exception e) {
			Reporter.log("can't Find Full Post Element");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(post.FullPost).click().build();
		act.perform();
		try {
			post.PostContent = driver.LocateById(post.PostContentId);
		}catch(Exception e) {
			Reporter.log("Didn't Open Post");
			Assert.assertTrue(false);
		}
		try {
			post.CommentSpace = driver.LocateById(post.CommentSpaceId);
			post.InnerCommentButton = driver.LocateById(post.InnerCommentButtonId);
		}catch(Exception e) {
			Reporter.log("Can't Find Post Area");
			Assert.assertTrue(false);
		}
		act =builder.sendKeys(post.CommentSpace,"Hello World").build();
		act.perform();
		act = builder.moveToElement(post.InnerCommentButton).click().build();
		act.perform();
		WebElement temp = null;
		try {
			post.Comment = driver.LocateById(post.CommentId);
			temp = driver.LocateById("paragraphComment");
		}catch(Exception e) {
			Reporter.log("Falied To Comment");
			Assert.assertTrue(false);
		}
		String expected = "Hello World";
		String Actual = temp.getText();
		Assert.assertEquals(Actual, expected);
		Reporter.log("Commented Successfully");
	}
	@Test(priority=5,description="empty Comment After Logging In")
	public void test6() throws Throwable{
		driver.nav(driver.Url);
		LoginPage login = new LoginPage();
		try {
			   login.signBtn = driver.LocateById(login.signBtnID);
		}catch(Exception e) {
				Reporter.log("Can't find the signIn Button");
				Assert.assertTrue(false);
		}
		act = builder.moveToElement(login.signBtn).click().build();
		act.perform(); 
		try {
		   login.userNametxt = driver.LocateById(login.userNametxtID);
		   login.paswordtxt = driver.LocateById(login.paswordtxtID);
		   login.submit = driver.LocateById(login.submitID);
		}catch(Exception e) {
			Reporter.log("Missed Elements in Login Form");
			Assert.assertTrue(false);
		  }
		act = builder.sendKeys(login.userNametxt,"King").build();
		act.perform();
  	  	act = builder.sendKeys(login.paswordtxt,"queen12").build();
		act.perform();
		act = builder.moveToElement(login.submit).click().build();
		act.perform();
		Thread.sleep(5000);
		try {
			post.FullPost = driver.LocateById(post.FullPostId);
		}catch(Exception e) {
			Reporter.log("can't Find Full Post Element");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(post.FullPost).click().build();
		act.perform();
		try {
			post.PostContent = driver.LocateById(post.PostContentId);
		}catch(Exception e) {
			Reporter.log("Didn't Open Post");
			Assert.assertTrue(false);
		}
		try {
			post.CommentSpace = driver.LocateById(post.CommentSpaceId);
			post.InnerCommentButton = driver.LocateById(post.InnerCommentButtonId);
		}catch(Exception e) {
			Reporter.log("Can't Find Post Area");
			Assert.assertTrue(false);
		}
		act =builder.sendKeys(post.CommentSpace,"").build();
		act.perform();
		act = builder.moveToElement(post.InnerCommentButton).click().build();
		act.perform();
		Alert msg;
		for(int i=0;i<5;i++)
		{
		        try
		        {
		            msg = driver.driver.switchTo().alert();
		            break;
		        }
		        catch(NoAlertPresentException e)
		        {
		          Thread.sleep(1000);
		        }
		}
		msg = driver.driver.switchTo().alert();
		msg.accept();
		Reporter.log("empty Comment test passed");
	}
	*/
	@Test(priority=6,description="Voting Test")
	public void test7() throws InterruptedException {
		driver.nav(driver.Url);
		Thread.sleep(3000);
		try {
			post.PostUpVote = driver.LocateById(post.PostUpVoteId);
			post.PostDownVote = driver.LocateById(post.PostDownVoteId);
			post.PostVote = driver.LocateById(post.PostVoteId);
		}catch(Exception e) {
			Reporter.log("Post Not Found");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(post.PostUpVote).click().build();
		act.perform();
		Thread.sleep(1000);
		String Vote=post.PostVote.getText();
		Assert.assertEquals(Vote, "1");
		act = builder.moveToElement(post.PostUpVote).click().build();
		act.perform();
		Vote=post.PostVote.getText();
		Assert.assertEquals(Vote,"0");
		act = builder.moveToElement(post.PostDownVote).click().build();
		act.perform();
		Vote=post.PostVote.getText();
		Assert.assertEquals(Vote, "-1");
		act = builder.moveToElement(post.PostDownVote).click().build();
		act.perform();
		Vote=post.PostVote.getText();
		Assert.assertEquals(Vote, "0");
	}
	
	
	//testing user profile button
	@Test(priority=7,description="Visiting Post's user profile")
	public void test8()throws Throwable{
		driver.nav(driver.Url);
		Thread.sleep(3000);
		try {
			post.User = driver.LocateById(post.UserId);
		}catch(Exception e) {
			Reporter.log("Can't find the link");
			Assert.assertTrue(false);
		}
		String UserName = post.User.getText();
		act = builder.moveToElement(post.User).click().build();
		act.perform();
		Thread.sleep(3000);
		String Url = driver.driver.getCurrentUrl();
		String Expected = driver.Url + "/userprofile/" + UserName ;
		Assert.assertEquals(Expected, Url);
		Reporter.log("User Profile is correct");
	}
	
	//testing ApexCom button
	@Test(priority=8,description="Visiting Post's ApexCom")
	public void test9()throws Throwable{
		driver.nav(driver.Url);
		Thread.sleep(3000);
		try {
			post.SubReddit = driver.LocateById(post.SubRedditId);
		}catch(Exception e) {
			Reporter.log("Can't find the link");
			Assert.assertTrue(false);
		}
		String Sub = post.SubReddit.getText();
		act = builder.moveToElement(post.SubReddit).click().build();
		act.perform();
		Thread.sleep(3000);
		String Url = driver.driver.getCurrentUrl();
		String Expected = driver.Url + "/ApexCom/" + Sub ;
		Assert.assertEquals(Expected, Url);
		Reporter.log("ApexCom is correct, Test 9 Passed");
	}
	
	@Test(priority=9,description="Create post's Button without Login")
	public void test10()throws Throwable{
		  driver.nav(driver.Url);
		  Thread.sleep(3000);
		  WebElement CreatePost = null;
		  try {
		  CreatePost = driver.LocateByXpath("//*[@id='main']/button[1]");
		  }catch(Exception e) {
			  Reporter.log("Can't find creation button");
			  Assert.assertTrue(false);
		  }
		  act = builder.moveToElement(CreatePost).click().build();
		  act.perform();
		  Thread.sleep(3000);
		  try {
			  login.signBtn = driver.LocateById(login.signBtnID);
		  }catch(Exception e) {
			  Reporter.log("Didn't open Login Form");
			  Assert.assertTrue(false);
		  }
		  Reporter.log("Create Post Without Login passed");
	}
	
	@Test(priority=10,description="Create post's Button with Login")
	public void test11()throws Throwable{
		driver.nav(driver.Url);
		Thread.sleep(3000);
		  try {
			   login.signBtn = driver.LocateById(login.signBtnID);
			}catch(Exception e) {
				Reporter.log("Can't find the signIn Button");
				Assert.assertTrue(false);
			}
		 act = builder.moveToElement(login.signBtn).click().build();
		 act.perform(); 
		 Thread.sleep(3000);
		  try {
			   login.userNametxt = driver.LocateById(login.userNametxtID);
			   login.paswordtxt = driver.LocateById(login.paswordtxtID);
			   login.submit = driver.LocateById(login.submitID);
		  }catch(Exception e) {
				Reporter.log("Can't find the submit Button");
				Assert.assertTrue(false);
		  }
		  act = builder.sendKeys(login.userNametxt,"King").build();
		  act.perform();
		  act = builder.sendKeys(login.paswordtxt,"queen12").build();
		  act.perform();
		  act = builder.moveToElement(login.submit).click().build();
		  act.perform();
		  Thread.sleep(5000);
		  WebElement CreatePost = null;
		  try {
		  CreatePost = driver.LocateByXpath("//*[@id='main']/button[1]");
		  }catch(Exception e) {
			  Reporter.log("Can't find creation button");
			  Assert.assertTrue(false);
		  }
		  act = builder.moveToElement(CreatePost).click().build();
		  act.perform();
		  Thread.sleep(3000);
		  String Url = driver.driver.getCurrentUrl();
		  Assert.assertEquals(Url, driver.Url+"/Submit");
		  Reporter.log("Create Post with login Test passed");
		  Thread.sleep(5000);
			try {
				login.logout = driver.LocateById(login.logoutDivID);
			}catch(Exception e) {
				Reporter.log("Can't find loguot btn 5");
				Assert.assertTrue(false);
			}
		  	act = builder.moveToElement(login.logout).click().build();
			act.perform();
			Thread.sleep(1000);
			try {
				login.logoutButton = driver.LocateByXpath("//div[@id='loggedDiv']/ul/li[5]");
			}catch(Exception e) {
				Reporter.log("Can't find loguot btn 5");
				Assert.assertTrue(false);
			}
			act = builder.moveToElement(login.logoutButton).click().build();
			act.perform();
			Thread.sleep(1000);
			try {
				login.signBtn = driver.LocateById(login.signBtnID);
			}catch(Exception e) {
				Reporter.log("Can't  loguot");
				Assert.assertTrue(false);
			}
	}
}
