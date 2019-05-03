package TestingScript;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import DriverDef.Chrome;
import PageModel.LoginPage;
import PageModel.profilePage;

import java.util.List;

public class profileTest<webelement>{
	public Chrome driver;
	public profilePage ProfPage;
	public LoginPage login;
	public Actions builder;
	public Action act;
	@BeforeClass
	public void init() throws Throwable
	{
		driver = new Chrome();
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
			login.profileBTN = driver.LocateByXpath("//a[@class='router-link-active']");
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
			ProfPage.createpostdiv = driver.LocateById(ProfPage.createPostdivid);
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
		login.profileBTN = driver.LocateByXpath("//a[@class='router-link-active']");
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
		List<WebElement>  BlockedUsersList = driver.driver.findElements(By.className("Name"));
	    int x =BlockedUsersList.size();
	    for(int i=0;i<x;i++)
	    {
	    	if (BlockedUsersList.get(i).getText()=="sayed")
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
		List<WebElement>  BlockedUsersList = driver.driver.findElements(By.className("Name"));
		List<WebElement>  UNBlockBTNs = driver.driver.findElements(By.className("button"));
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
	if(ProfPage.UsernameLogo.getText().contains("reem97"))
	{
		confirmData=true;
	}
	assertTrue(confirmData);
}
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
}
