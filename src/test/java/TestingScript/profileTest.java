package TestingScript;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import DriverDef.Chrome;
import PageModel.LoginPage;
import PageModel.profilePage;
import PageModel.searchPage;

import java.util.List;

public class profileTest{
	public Chrome driver;
	public searchPage st;
	public profilePage ProfPage;
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
	public void init() throws Throwable
	{
		driver = new Chrome();
		st = new searchPage();
		ProfPage = new profilePage();
		login = new LoginPage();
		builder = new Actions(driver.driver);
		System.out.println("profile test starts");
		////////////////////////////////////////////
		//LOG IN and open setting page/////
		////////////////////////////////////////////
		driver.nav(driver.Url);
		Thread.sleep(5000);
	  	signin("eslam","123456");

											// loged in
		try {
			login.UserInfo = driver.LocateById(login.logoutDivID);
			}catch(Exception e) {
			Reporter.log("Can't login");
			Assert.assertTrue(false);
			}
			act = builder.moveToElement(login.UserInfo).click().build();
			act.perform();
			try {
			login.profileBTN = driver.LocateByXpath("//*[@id='loggedbutton']//following-sibling::ul/li[2]");
			}catch(Exception e) {
			Reporter.log("Can't find setting btn");
			Assert.assertTrue(false);
			}
			act = builder.moveToElement(login.profileBTN).click().build();
			act.perform();
			Thread.sleep(1000);												// open profile
		
	}


@AfterClass
public void finalize()
	{
		driver.shutdown();
		System.out.println("profile test ends");
	}



@Test(priority=1,description="check add post Button")
public void test1() 
{
	try {
		ProfPage.newpostBTN = driver.LocateById(ProfPage.newpostBTNid);
		}catch(Exception e) {
		Reporter.log("Can't login");
		Assert.assertTrue(false);
		}
		act = builder.moveToElement(ProfPage.newpostBTN).click().build();
		act.perform();
		try {
			ProfPage.createpostdiv = driver.LocateById("button");
			}catch(Exception e) {
			Reporter.log("Can't open add post page");
			Assert.assertTrue(false);
			}
		assertNotNull(ProfPage.createpostdiv);
}



//blocked users  sayed  zz11 zz15
@Test(priority=2,description="check Plocked users")
public void test2() throws Throwable 
{
	try {
		login.UserInfo = driver.LocateById(login.logoutDivID);
		}catch(Exception e) {
		Reporter.log("Can't login");
		Assert.assertTrue(false);
		}
		act = builder.moveToElement(login.UserInfo).click().build();
		act.perform();
		try {
		login.profileBTN = driver.LocateByXpath("//*[@id='loggedbutton']//following-sibling::ul/li[2]");
		}catch(Exception e) {
		Reporter.log("Can't find setting btn");
		Assert.assertTrue(false);
		}
		act = builder.moveToElement(login.profileBTN).click().build();
		act.perform();
		Thread.sleep(1000);								// open profile
	try {
		ProfPage.blockBTN = driver.LocateById(ProfPage.blockBTNid);
		}catch(Exception e) {
		Reporter.log("Can't login");
		Assert.assertTrue(false);
		}
		act = builder.moveToElement(ProfPage.blockBTN).click().build();
		act.perform();
		boolean getUser=false;
		List<WebElement>  BlockedUsersList = driver.driver.findElements(By.xpath("//*[@id='box']//p"));
	    int x =BlockedUsersList.size();
	    System.out.println(BlockedUsersList.size());
	    for(int i=0;i<x;i++)
	    {
	    	System.out.println(BlockedUsersList.get(i).getText());
	    	if (BlockedUsersList.get(i).getText().equals("sayed"))
	    	{
	    		getUser=true;
	    	}
	    	
	    }
	    assertTrue(getUser);
		
}

@Test(priority=3,description="UnPlock user Test")
public void test3() 
{
	try {
		ProfPage.blockBTN = driver.LocateById(ProfPage.blockBTNid);
		}catch(Exception e) {
		Reporter.log("Can't login");
		Assert.assertTrue(false);
		}
		act = builder.moveToElement(ProfPage.blockBTN).click().build();
		act.perform();
		boolean getUser=true;
		boolean check= false;
		List<WebElement>  BlockedUsersList = driver.driver.findElements(By.xpath("//*[@id='box']//p"));
		List<WebElement>  UNBlockBTNs = driver.driver.findElements(By.xpath("//*[@id='button']"));
	    int x =BlockedUsersList.size();
	    for(int i=0;i<x;i++)
	    {
	    	if (BlockedUsersList.get(i).getText().contains("zz11"))
	    	{
	    		UNBlockBTNs.get(i).click();
	    		try {
	    			ProfPage.confirmblockBTN = driver.LocateByXpath("//button[@class='swal-button swal-button--confirm']");
	    			}catch(Exception e) {
	    			Reporter.log("Can't login");
	    			Assert.assertTrue(false);
	    			}
	    			act = builder.moveToElement(ProfPage.confirmblockBTN).click().build();
	    			act.perform();
	    			x--;
	    			check=true;
	    			break;
	    	}
	    }
	   
	    for(int i=0;i<x;i++)
	    {
	    	if (BlockedUsersList.get(i).getText().contains("zz11"))
	    	{
	    		getUser=false;
	    	}
	    }
	    
	    assertTrue(getUser&&check);
		
}

@Test(priority=4,description="check user data is right")
public void test4() 
{
	boolean confirmData=false;
	try {
		ProfPage.UsernameLogo = driver.LocateByXpath("//div[@class='content']/h4");
		}catch(Exception e) {
		Reporter.log("Can't find user logo");
		Assert.assertTrue(false);
		}
	if(ProfPage.UsernameLogo.getText().contains("eslam"))
	{
		confirmData=true;
	}
	assertTrue(confirmData);
}

@Test(priority=5,description=" open acount from post and Plock user")
public void test5() throws Throwable 
{
	try {
		ProfPage.homeBTN = driver.LocateById(ProfPage.homeBTNid);
		}catch(Exception e) {
		Reporter.log("Can't login");
		Assert.assertTrue(false);
		}
		act = builder.moveToElement(ProfPage.homeBTN).click().build();
		act.perform();
		
		try {
			ProfPage.user = driver.LocateById(ProfPage.userid);
			}catch(Exception e) {
			Reporter.log("Can't login");
			Assert.assertTrue(false);
			}
			act = builder.moveToElement(ProfPage.user).click().build();
			act.perform();
			try {
				ProfPage.blockBTN = driver.LocateById("blocktbutton");
				}catch(Exception e) {
				Reporter.log("Can't login");
				Assert.assertTrue(false);
				}
				act = builder.moveToElement(ProfPage.blockBTN).click().build();
				act.perform();
			

	try {
		login.UserInfo = driver.LocateById(login.logoutDivID);
		}catch(Exception e) {
		Reporter.log("Can't login");
		Assert.assertTrue(false);
		}
	act = builder.moveToElement(login.UserInfo).click().build();
	act.perform();
	try {
		login.profileBTN = driver.LocateByXpath("//*[@id='loggedbutton']//following-sibling::ul/li[2]");
		}catch(Exception e) {
			Reporter.log("Can't find setting btn");
			Assert.assertTrue(false);
			}
	act = builder.moveToElement(login.profileBTN).click().build();
	act.perform();
	Thread.sleep(1000);		//open profile			
				
	try {
		ProfPage.blockBTN = driver.LocateById(ProfPage.blockBTNid);
		}catch(Exception e) {
		Reporter.log("Can't login");
		Assert.assertTrue(false);
		}
		act = builder.moveToElement(ProfPage.blockBTN).click().build();
		act.perform();
		boolean getUser=false;
		List<WebElement>  BlockedUsersList = driver.driver.findElements(By.xpath("//*[@id='box']//p"));
	    int x =BlockedUsersList.size();
	    System.out.println(BlockedUsersList.size());
	    for(int i=0;i<x;i++)
	    {
	    	System.out.println(BlockedUsersList.get(i).getText());
	    	if (BlockedUsersList.get(i).getText().equals("sayed"))
	    	{
	    		getUser=true;
	    	}
	    }
	    assertTrue(getUser);
		
}

@Test(priority=6,description=" search for acount from post and Plock user")
public void test6() throws Throwable 
{
	try {
		ProfPage.homeBTN = driver.LocateById(ProfPage.homeBTNid);
		}catch(Exception e) {
		Reporter.log("Can't login");
		Assert.assertTrue(false);
		}
		act = builder.moveToElement(ProfPage.homeBTN).click().build();
		act.perform();			// open home page
		
		try {
			   st.searchTXT = driver.driver.findElement(By.className("form-control"));
		   }catch(Exception e) {
				Reporter.log("Can't find the searchTXT");
				AssertJUnit.assertTrue(false);
			}
		   act = builder.sendKeys(st.searchTXT,"hellie").build();
			act.perform();
			st.searchTXT.sendKeys(Keys.ENTER);		//search done about something

			try {
		    	st.UsersBTN = driver.LocateById(st.UsersBTNid);
		   }catch(Exception e) {
				Reporter.log("Can't find the user and community Button");
				Assert.assertTrue(false);
			}
		    act = builder.moveToElement(st.UsersBTN).click().build();
		    act.perform();										//open community and user
		    
		    try {
		    	st.UsersBTN = driver.LocateById("sub1");
		   }catch(Exception e) {
				Reporter.log("Can't find the user and community Button");
				Assert.assertTrue(false);
			}
		    act = builder.moveToElement(st.UsersBTN).click().build();
		    act.perform();						// open user page
		    
		    try {
		    	ProfPage.blockBTN = driver.LocateById("blocktbutton");
		   }catch(Exception e) {
				Reporter.log("Can't find the user and community Button");
				Assert.assertTrue(false);
			}
		    act = builder.moveToElement(ProfPage.blockBTN ).click().build();
		    act.perform();						// oblock user
		    
		    
		try {
			ProfPage.user = driver.LocateById(ProfPage.userid);
			}catch(Exception e) {
			Reporter.log("Can't login");
			Assert.assertTrue(false);
			}
			act = builder.moveToElement(ProfPage.user).click().build();
			act.perform();
			try {
				ProfPage.blockBTN = driver.LocateById("blocktbutton");
				}catch(Exception e) {
				Reporter.log("Can't login");
				Assert.assertTrue(false);
				}
				act = builder.moveToElement(ProfPage.blockBTN).click().build();
				act.perform();
				
				try {
					ProfPage.blockBTN = driver.LocateByXpath("//button[@class='swal-button swal-button--confirm']");
					}catch(Exception e) {
					Reporter.log("Can't login");
					Assert.assertTrue(false);
					}
					act = builder.moveToElement(ProfPage.blockBTN).click().build();
					act.perform();
										//confirm block
			

	try {
		login.UserInfo = driver.LocateById("main");
		}catch(Exception e) {
		Reporter.log("Can't login");
		Assert.assertTrue(false);
		}
	
	    assertNotNull(login.UserInfo);
		
}

}
