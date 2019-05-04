package TestingScript;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import DriverDef.Chrome;
import PageModel.searchPage;

public class searchTests {
	public Chrome driver;
	public Actions builder;
	public org.openqa.selenium.interactions.Action act;
	public searchPage SearchPage;

	@BeforeClass
	public void BeforeClass()
	{
		driver = new Chrome();
		SearchPage = new searchPage();
		builder = new Actions(driver.driver);
		Reporter.log("search test starts");
	}
	
	@AfterClass
	public void finalize()
	{
		Reporter.log("search test ends");
		driver.shutdown();
	}


@Test (priority=1,description="search about incorrect data")
public void Test1() throws Throwable {
	driver.nav(driver.Url);
	   Thread.sleep(2000);
	   try {
		   SearchPage.searchTXT = driver.driver.findElement(By.className("form-control"));
	   }catch(Exception e) {
			Reporter.log("Can't find the searchTXT");
			AssertJUnit.assertTrue(false);
		}
	   act = builder.sendKeys(SearchPage.searchTXT,"11111").build();
		act.perform();
		SearchPage.searchTXT.sendKeys(Keys.ENTER);		//search done about something

		 try {
			   SearchPage.errormsg1 = driver.LocateById(SearchPage.errormsg1id);
		   }catch(Exception e) {
				Reporter.log("Can't find the error message");
				AssertJUnit.assertTrue(false);
			}
		  String expected = SearchPage.errormsg1.getText();  // take pass of lable
		  String actual="Sorry, there were no post results for ''11111''";
	      assertEquals(actual, expected);
		 
}	
	@Test (priority=2,description="search about existing user and community only")
	public void Test2() throws Throwable {
		driver.nav(driver.Url);
	   Thread.sleep(2000);
	   try {
		   SearchPage.searchTXT = driver.driver.findElement(By.className("form-control"));
	   }catch(Exception e) {
			Reporter.log("Can't find the searchTXT");
			AssertJUnit.assertTrue(false);
		}
	act = builder.sendKeys(SearchPage.searchTXT,"eslam").build();
	act.perform();
    SearchPage.searchTXT.sendKeys(Keys.ENTER);		//search done about something

    try {
    	SearchPage.postsBTN = driver.LocateByXpath("//div[@class='body']//a[1]");
   }catch(Exception e) {
		Reporter.log("Can't find the post Button");
		Assert.assertTrue(false);
	}
    act = builder.moveToElement(SearchPage.postsBTN).click().build();
    act.perform();
    try {
		   SearchPage.errormsg1 = driver.LocateById(SearchPage.errormsg1id);
	   }catch(Exception e) {
			Reporter.log("Can't find the error message");
			AssertJUnit.assertTrue(false);
		}
    Boolean postcheck=false;
    Boolean usersCheck=false;
    String expected = SearchPage.errormsg1.getText();  
	  String actual="Sorry, there were no post results for ''eslam''";
	  if(expected==actual)
	  {
		  postcheck=true;
	  }
    try {
    	SearchPage.UsersBTN = driver.LocateById(SearchPage.UsersBTNid);
   }catch(Exception e) {
		Reporter.log("Can't find the user and community Button");
		Assert.assertTrue(false);
	}
    act = builder.moveToElement(SearchPage.UsersBTN).click().build();
    act.perform();
  //a[@class='name']
    try {
    	SearchPage.user1 = driver.LocateByXpath("//a[@class='name']");
   }catch(Exception e) {
		Reporter.log("Can't find the User");
		Assert.assertTrue(false);
	}
    String userText= SearchPage.user1.getText();
    if(userText.contains("eslam"))
    {
    	usersCheck=true;  
	}
    assertTrue(!(usersCheck&&postcheck));
    
}
	@Test (priority=3,description="search about existing data in posts and no users with this data")
	public void Tes3() throws Throwable {
		driver.nav(driver.Url);
	   Thread.sleep(2000);
	   try {
		   SearchPage.searchTXT = driver.driver.findElement(By.className("form-control"));
	   }catch(Exception e) {
			Reporter.log("Can't find the searchTXT");
			AssertJUnit.assertTrue(false);
		}
	act = builder.sendKeys(SearchPage.searchTXT,"for test").build();
	act.perform();
    SearchPage.searchTXT.sendKeys(Keys.ENTER);		//search done about something

    try {
    	SearchPage.postsBTN = driver.LocateByXpath("//div[@class='body']//a[1]");
   }catch(Exception e) {
		Reporter.log("Can't find the post Button");
		Assert.assertTrue(false);
	}
    act = builder.moveToElement(SearchPage.postsBTN).click().build();
    act.perform();
    try {
    	SearchPage.post1 = driver.driver.findElement(By.className("panel-body"));
   }catch(Exception e) {
		Reporter.log("Can't find the post");
		Assert.assertTrue(false);
	}
    Boolean postcheck=false;
    Boolean usersCheck=false;
    String postText= SearchPage.post1.getText();
    if(postText.contains("for test"))
    {
    	postcheck=true;  
	}
    try {
    	SearchPage.UsersBTN = driver.LocateById(SearchPage.UsersBTNid);
   }catch(Exception e) {
		Reporter.log("Can't find the user and community Button");
		Assert.assertTrue(false);
	}
    act = builder.moveToElement(SearchPage.UsersBTN).click().build();
    act.perform();
    try {
		   SearchPage.errormsg2 = driver.LocateById(SearchPage.errormsg2id);
	   }catch(Exception e) {
			Reporter.log("Can't find the error message");
			AssertJUnit.assertTrue(false);
		}
	  String expected = SearchPage.errormsg2.getText();  
	  String actual="Sorry, there were no post results for ''for test''";
	  if(expected==actual)
	  {
		  usersCheck=true;
	  }
   assertTrue(!(usersCheck&&postcheck));
    
    
}
	@Test (priority=4,description="search about existing data in posts and users")
	public void Test4() throws Throwable {
		driver.nav(driver.Url);
	   Thread.sleep(2000);
	   try {
		   SearchPage.searchTXT = driver.driver.findElement(By.className("form-control"));
	   }catch(Exception e) {
			Reporter.log("Can't find the searchTXT");
			AssertJUnit.assertTrue(false);
		}
	act = builder.sendKeys(SearchPage.searchTXT,"reem").build();
	act.perform();
    SearchPage.searchTXT.sendKeys(Keys.ENTER);		//search done about something

    try {
    	SearchPage.postsBTN = driver.LocateByXpath("//div[@class='body']//a[1]");
   }catch(Exception e) {
		Reporter.log("Can't find the post Button");
		Assert.assertTrue(false);
	}
    act = builder.moveToElement(SearchPage.postsBTN).click().build();
    act.perform();
    try {
    	SearchPage.post1 = driver.driver.findElement(By.className("panel-body"));
   }catch(Exception e) {
		Reporter.log("Can't find the post");
		Assert.assertTrue(false);
	}
    Boolean postcheck=true;
    Boolean usersCheck=true;
    String postText= SearchPage.post1.getText();
    if(postText.contains("reem"))
    {
    	postcheck=true;  
	}
    
    assertTrue(usersCheck&&postcheck);
    
}
}
