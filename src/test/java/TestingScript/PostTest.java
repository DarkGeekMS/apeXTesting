package TestingScript;

import org.junit.Assert;
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
	public Actions builder;
	public Action act;
	@BeforeClass
	public void init()
	{
		driver = new Chrome();
		post = new Post();
		builder = new Actions(driver.driver);
		System.out.println("Post test starts");
	}
	@AfterClass
	public void finalize()
	{
		driver.shutdown();
		System.out.println("Sign up test ends");
	}
	/*
	@Test(priority=0,description="press on every part of a post and check if it opens it or not(works for logged person or not)")
	public void test1() {
		driver.nav("http://localhost:8081/");
		try {
			post.FullPost = driver.LocateById(post.FullPostId);
			act = builder.moveToElement(post.FullPost).click().build();
			act.perform();
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
		driver.nav("http://localhost:8081/");
		try {
			post.PostCol1 = driver.LocateById(post.PostCol1Id);
			act = builder.moveToElement(post.PostCol1).click().build();
			act.perform();
			try {
				driver.LocateById(post.PostContentId);
				System.out.println("clicking First column of post worked");
			}catch(Exception e) {
				System.out.println("Test 1 failed Didn't open While clicking on post's First column");
				Assert.assertTrue(false);
			}
		}catch(Exception e) {
			System.out.println("can't Find First col's Element");
			Assert.assertTrue(false);
		}
		driver.nav("http://localhost:8081/");
		try {
			post.PostCol2 = driver.LocateById(post.PostCol2Id);
			act = builder.moveToElement(post.PostCol2).click().build();
			act.perform();
			try {
				driver.LocateById(post.PostContentId);
				System.out.println("clicking second column of post worked");
			}catch(Exception e) {
				System.out.println("Test 1 failed Didn't open While clicking on post's second column");
				Assert.assertTrue(false);
			}
		}catch(Exception e) {
			System.out.println("can't Find second col's Element");
			Assert.assertTrue(false);
		}
		driver.nav("http://localhost:8081/");
		try {
			post.PostRow = driver.LocateById(post.PostRowId);
			act = builder.moveToElement(post.PostRow).click().build();
			act.perform();
			try {
				driver.LocateById(post.PostContentId);
				System.out.println("clicking Row of post worked");
			}catch(Exception e) {
				System.out.println("Test 1 failed Didn't open While clicking on post's Row");
				Assert.assertTrue(false);
			}
		}catch(Exception e) {
			System.out.println("can't Find post's Row Element");
			Assert.assertTrue(false);
		}
		driver.nav("http://localhost:8081/");
		try {
			post.CommentButton = driver.LocateById(post.CommentButtonId);
			act = builder.moveToElement(post.CommentButton).click().build();
			act.perform();
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
		driver.nav("http://localhost:8081/");
		try {
			post.PostVote = driver.LocateById(post.PostVoteId);
			act = builder.moveToElement(post.PostVote).click().build();
			act.perform();
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
	
	@Test(priority=1,description="check save")
	public void test2() {
		driver.nav("http://localhost:8081/");
		for(int i=0;i<1;i++) {
		try {
			post.PostSaveButton = driver.LocateById(post.PostSaveButtonId);
		}catch(Exception e) {
			System.out.println("Save Button Not Found");
			Assert.assertTrue(false);
		}
		String before = post.PostSaveButton.getText();
		act = builder.moveToElement(post.PostSaveButton).click().build();
		act.perform();
		String after = post.PostSaveButton.getText();
		Assert.assertNotEquals(before, after);
		}
		System.out.println("Test 2 passed");
	}
	
	@Test(priority=2,description="check Hide")
	public void test3() throws Throwable {
		driver.nav("http://localhost:8081/");
		try {
			post.PostExtra = driver.LocateById(post.PostExtraId);
		}catch(Exception e) {
			System.out.println("Expand Arrow Doesn't Exist");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(post.PostExtra).click().build();
		act.perform();
		try {
			post.HideIcon = driver.LocateById(post.HideIconId);
		}catch(Exception e) {
			System.out.println("Hide Icon Doesn't Exist");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(post.HideIcon).click().build();
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
	//testing comments
	@Test(priority=3,description="Try To Comment Without Logging In")
	public void test4() throws Throwable{
		driver.nav("http://localhost:8081/");
		try {
			post.FullPost = driver.LocateById(post.FullPostId);
		}catch(Exception e) {
			System.out.println("can't Find Full Post Element");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(post.FullPost).click().build();
		act.perform();
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
	
	@Test(priority=3,description="non empty Comment After Logging In")
	public void test4() throws Throwable{
		driver.nav("http://localhost:8081/");
		LoginPage login = new LoginPage();
		try {
			   login.signBtn = driver.LocateById(login.signBtnID);
		}catch(Exception e) {
				System.out.println("Can't find the signIn Button");
				Assert.assertTrue(false);
		}
		act = builder.moveToElement(login.signBtn).click().build();
		act.perform(); 
		try {
		   login.userNametxt = driver.LocateById(login.userNametxtID);
		   login.paswordtxt = driver.LocateById(login.paswordtxtID);
		   login.submit = driver.LocateById(login.submitID);
		}catch(Exception e) {
			System.out.println("Missed Elements in Login Form");
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
			System.out.println("can't Find Full Post Element");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(post.FullPost).click().build();
		act.perform();
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
		WebElement temp = null;
		try {
			post.Comment = driver.LocateById(post.CommentId);
			temp = driver.LocateById("paragraphComment");
		}catch(Exception e) {
			System.out.println("Falied To Comment");
			Assert.assertTrue(false);
		}
		String expected = "Hello World";
		String Actual = temp.getText();
		Assert.assertEquals(Actual, expected);
		System.out.println("Commented Successfully");
	}
	@Test(priority=4,description="empty Comment After Logging In")
	public void test5() throws Throwable{
		driver.nav("http://localhost:8081/");
		LoginPage login = new LoginPage();
		try {
			   login.signBtn = driver.LocateById(login.signBtnID);
		}catch(Exception e) {
				System.out.println("Can't find the signIn Button");
				Assert.assertTrue(false);
		}
		act = builder.moveToElement(login.signBtn).click().build();
		act.perform(); 
		try {
		   login.userNametxt = driver.LocateById(login.userNametxtID);
		   login.paswordtxt = driver.LocateById(login.paswordtxtID);
		   login.submit = driver.LocateById(login.submitID);
		}catch(Exception e) {
			System.out.println("Missed Elements in Login Form");
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
			System.out.println("can't Find Full Post Element");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(post.FullPost).click().build();
		act.perform();
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
		System.out.println("empty Comment test passed");
	}
	*/
	@Test(priority=5,description="Voting Test")
	public void test6() {
		driver.nav("http://localhost:8081/");
		try {
			post.PostUpVote = driver.LocateById(post.PostUpVoteId);
			post.PostDownVote = driver.LocateById(post.PostDownVoteId);
			post.PostVote = driver.LocateById(post.PostVoteId);
		}catch(Exception e) {
			System.out.println("Post Not Found");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(post.PostUpVote).click().build();
		act.perform();
		if(post.PostVote.getText() == "1") {
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(post.PostUpVote).click().build();
		act.perform();
		if(post.PostVote.getText() == "0") {
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(post.PostDownVote).click().build();
		act.perform();
		if(post.PostVote.getText() == "-1") {
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(post.PostDownVote).click().build();
		act.perform();
		if(post.PostVote.getText() == "0") {
			Assert.assertTrue(false);
		}
	}
}
