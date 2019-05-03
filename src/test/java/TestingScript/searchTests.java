package TestingScript;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;
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
	public Chrome chromeDriver;
	public Actions builder;
	public org.openqa.selenium.interactions.Action act;
	public searchPage SearchPage;

	@BeforeClass
	public void BeforeClass()
	{
		chromeDriver = new Chrome();
		SearchPage = new searchPage();
		builder = new Actions(chromeDriver.driver);
		Reporter.log("search test starts");
	}
	@AfterClass
	public void finalize()
	{
		Reporter.log("search test ends");
		chromeDriver.shutdown();
	}

	@Test (priority=1,description="search about incorrect data")
	public void Test1() throws Throwable {
	   chromeDriver.nav(chromeDriver.Url);
	   Thread.sleep(5000);
	   try {
		   SearchPage.searchTXT = chromeDriver.LocateById(SearchPage.searchTXTid);
	   }catch(Exception e) {
			Reporter.log("Can't find the searchTXT");
			AssertJUnit.assertTrue(false);
		}
	   act = builder.sendKeys(SearchPage.searchTXT,"1111").build();
		act.perform();
		SearchPage.searchTXT.sendKeys(Keys.ENTER);		//search done about something

		 try {
			   SearchPage.errormsg1 = chromeDriver.LocateById(SearchPage.errormsg1id);
		   }catch(Exception e) {
				Reporter.log("Can't find the error message");
				AssertJUnit.assertTrue(false);
			}
		  String expected = SearchPage.errormsg1.getText();  // take pass of lable
		  String actual=" Sorry, there were no post results for ''rere'' ";
	      assertEquals(actual, expected);
		 
	}
	
	@Test (priority=2,description="search about existing data in posts and users")
	public void Test2() throws Throwable {
	   chromeDriver.nav(chromeDriver.Url);
	   Thread.sleep(5000);
	   try {
		   SearchPage.searchTXT = chromeDriver.LocateById(SearchPage.searchTXTid);
	   }catch(Exception e) {
			Reporter.log("Can't find the searchTXT");
			AssertJUnit.assertTrue(false);
		}
	act = builder.sendKeys(SearchPage.searchTXT,"rere").build();
	act.perform();
    SearchPage.searchTXT.sendKeys(Keys.ENTER);		//search done about something

    try {
    	SearchPage.postsBTN = chromeDriver.LocateById(SearchPage.postsBTNid);
   }catch(Exception e) {
		Reporter.log("Can't find the post Button");
		Assert.assertTrue(false);
	}
    act = builder.moveToElement(SearchPage.postsBTN).click().build();
    act.perform();
    try {
    	SearchPage.post1 = chromeDriver.LocateById(SearchPage.post1id);
   }catch(Exception e) {
		Reporter.log("Can't find the post");
		Assert.assertTrue(false);
	}
    Boolean postcheck=false;
    Boolean usersCheck=false;
    String postText= SearchPage.post1.getText();
    if(postText.contains("1111"))
    {
    	postcheck=true;  
	}
    try {
    	SearchPage.UsersBTN = chromeDriver.LocateById(SearchPage.UsersBTNid);
   }catch(Exception e) {
		Reporter.log("Can't find the user and community Button");
		Assert.assertTrue(false);
	}
    act = builder.moveToElement(SearchPage.UsersBTN).click().build();
    act.perform();
    try {
    	SearchPage.user1 = chromeDriver.LocateById(SearchPage.user1id);
   }catch(Exception e) {
		Reporter.log("Can't find the User");
		Assert.assertTrue(false);
	}
    String userText= SearchPage.user1.getText();
    if(userText.contains("1111"))
    {
    	usersCheck=true;  
	}
    assertTrue(usersCheck&&postcheck);
    
}
	
	@Test (priority=3,description="search about existing data in posts and no users with this data")
	public void Tes3() throws Throwable {
	   chromeDriver.nav(chromeDriver.Url);
	   Thread.sleep(5000);
	   try {
		   SearchPage.searchTXT = chromeDriver.LocateById(SearchPage.searchTXTid);
	   }catch(Exception e) {
			Reporter.log("Can't find the searchTXT");
			AssertJUnit.assertTrue(false);
		}
	act = builder.sendKeys(SearchPage.searchTXT,"rere").build();
	act.perform();
    SearchPage.searchTXT.sendKeys(Keys.ENTER);		//search done about something

    try {
    	SearchPage.postsBTN = chromeDriver.LocateById(SearchPage.postsBTNid);
   }catch(Exception e) {
		Reporter.log("Can't find the post Button");
		Assert.assertTrue(false);
	}
    act = builder.moveToElement(SearchPage.postsBTN).click().build();
    act.perform();
    try {
    	SearchPage.post1 = chromeDriver.LocateById(SearchPage.post1id);
   }catch(Exception e) {
		Reporter.log("Can't find the post");
		Assert.assertTrue(false);
	}
    Boolean postcheck=false;
    Boolean usersCheck=false;
    String postText= SearchPage.post1.getText();
    if(postText.contains("1111"))
    {
    	postcheck=true;  
	}
    try {
    	SearchPage.UsersBTN = chromeDriver.LocateById(SearchPage.UsersBTNid);
   }catch(Exception e) {
		Reporter.log("Can't find the user and community Button");
		Assert.assertTrue(false);
	}
    act = builder.moveToElement(SearchPage.UsersBTN).click().build();
    act.perform();
    try {
		   SearchPage.errormsg2 = chromeDriver.LocateById(SearchPage.errormsg2id);
	   }catch(Exception e) {
			Reporter.log("Can't find the error message");
			AssertJUnit.assertTrue(false);
		}
	  String expected = SearchPage.errormsg2.getText();  
	  String actual=" Sorry, there were no post results for ''rere'' ";
	  if(expected==actual)
	  {
		  usersCheck=true;
	  }
   assertTrue(usersCheck&&postcheck);
    
    
}
	
	@Test (priority=4,description="search about existing user and community only")
	public void Tes4() throws Throwable {
	   chromeDriver.nav(chromeDriver.Url);
	   Thread.sleep(5000);
	   try {
		   SearchPage.searchTXT = chromeDriver.LocateById(SearchPage.searchTXTid);
	   }catch(Exception e) {
			Reporter.log("Can't find the searchTXT");
			AssertJUnit.assertTrue(false);
		}
	act = builder.sendKeys(SearchPage.searchTXT,"aNkBhGzKm9").build();
	act.perform();
    SearchPage.searchTXT.sendKeys(Keys.ENTER);		//search done about something

    try {
    	SearchPage.postsBTN = chromeDriver.LocateById(SearchPage.postsBTNid);
   }catch(Exception e) {
		Reporter.log("Can't find the post Button");
		Assert.assertTrue(false);
	}
    act = builder.moveToElement(SearchPage.postsBTN).click().build();
    act.perform();
    try {
		   SearchPage.errormsg1 = chromeDriver.LocateById(SearchPage.errormsg1id);
	   }catch(Exception e) {
			Reporter.log("Can't find the error message");
			AssertJUnit.assertTrue(false);
		}
    Boolean postcheck=false;
    Boolean usersCheck=false;
    String expected = SearchPage.errormsg1.getText();  
	  String actual=" Sorry, there were no post results for ''aNkBhGzKm9'' ";
	  if(expected==actual)
	  {
		  postcheck=true;
	  }
    try {
    	SearchPage.UsersBTN = chromeDriver.LocateById(SearchPage.UsersBTNid);
   }catch(Exception e) {
		Reporter.log("Can't find the user and community Button");
		Assert.assertTrue(false);
	}
    act = builder.moveToElement(SearchPage.UsersBTN).click().build();
    act.perform();
  //a[@class='name']
    try {
    	SearchPage.user1 = chromeDriver.LocateByXpath("//a[@class='name']");
   }catch(Exception e) {
		Reporter.log("Can't find the User");
		Assert.assertTrue(false);
	}
    String userText= SearchPage.user1.getText();
    if(userText.contains("aNkBhGzKm9"))
    {
    	usersCheck=true;  
	}
    assertTrue(usersCheck&&postcheck);
    
}
	
}
