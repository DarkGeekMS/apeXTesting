package TestingScript;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;

import java.awt.Desktop.Action;
import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.NoAlertPresentException;	
import org.openqa.selenium.Alert;

import DriverDef.Chrome;
import PageModel.LoginPage;


public class LoginTest
{
	public Chrome chromeDriver;
	public LoginPage login;
	public Actions builder;
	public org.openqa.selenium.interactions.Action act;


	@BeforeClass
	public void BeforeClass()
	{
		chromeDriver = new Chrome();
		login = new LoginPage();
		builder = new Actions(chromeDriver.driver);
		Reporter.log("Sign up test starts");
	}
	@AfterClass
	public void finalize()
	{
		Reporter.log("Sign up test ends");
		chromeDriver.shutdown();
	}

	@Test (priority=1,description="Submit without entering data")
	public void Test1() throws Throwable {
	   chromeDriver.nav(chromeDriver.Url);
	   Thread.sleep(5000);
	   try {
		    login.signBtn = chromeDriver.LocateById(login.signBtnID);
	   }catch(Exception e) {
			Reporter.log("Can't find the signIn Button");
			Assert.assertTrue(false);
		}
	    act = builder.moveToElement(login.signBtn).click().build();
	    act.perform();
	    Thread.sleep(3000);
	    try {
		   login.submit = chromeDriver.LocateById(login.submitID);
		}catch(Exception e) {
			Reporter.log("Can't find the submit Button test 1");
			Assert.assertTrue(false);
		}
	    act = builder.moveToElement(login.submit).click().build();
	    act.perform();
	    Thread.sleep(3000);
	    try {
	    	login.Errorlable = chromeDriver.LocateByXpath("//*[@id='partition-register']/div[2]/form/p[1]");
		}catch(Exception e) {
			Reporter.log("not stayed in sama page after submit test 1");
			return;
		}
	    String expected = login.Errorlable.getText();  // take pass of lable
	    String actual="Incorrect username or password";
	    assertEquals(actual, expected);
	}

	@Test (priority=2,description="Wrong user name")
	public void Test2() throws Throwable {
		chromeDriver.nav(chromeDriver.Url);
		Thread.sleep(5000);
		try {
			login.signBtn = chromeDriver.LocateById(login.signBtnID);
		}catch(Exception e) {
			Reporter.log("Can't find the signIn Button");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(login.signBtn).click().build();
		act.perform();
		Thread.sleep(3000);
		try {
		   login.userNametxt = chromeDriver.LocateById(login.userNametxtID);
		   login.paswordtxt = chromeDriver.LocateById(login.paswordtxtID);
		   login.submit = chromeDriver.LocateById(login.submitID);
		}catch(Exception e) {
			Reporter.log("Can't find the signIn Button test 2");
			Assert.assertTrue(false);
		}
	    act = builder.sendKeys(login.userNametxt,"reem1641").build();
		act.perform();
		act = builder.sendKeys(login.paswordtxt,"1212145").build();
		act.perform();
		act = builder.moveToElement(login.submit).click().build();
		act.perform();
		Thread.sleep(3000);
		try {
		   login.Errorlable = chromeDriver.LocateByXpath("//*[@id='partition-register']/div[2]/form/p[1]");
		}catch(Exception e) {
			Reporter.log("Can't find the signIn Button test 2");
			return;
		}
		String expected = login.Errorlable.getText();
		String actual="Incorrect username or password";
		assertEquals(actual, expected);
	  }
	
  @Test (priority=3,description="Wrong password")
  public void Test3() throws Throwable {
	  	chromeDriver.nav(chromeDriver.Url);
	  	Thread.sleep(5000);
	  	try {
		   login.signBtn = chromeDriver.LocateById(login.signBtnID);
		}catch(Exception e) {
			Reporter.log("Can't find the signIn Button 3");
			Assert.assertTrue(false);
		}
	  	act = builder.moveToElement(login.signBtn).click().build();
	  	act.perform();
	  	Thread.sleep(3000);
	  	try {
		   login.userNametxt = chromeDriver.LocateById(login.userNametxtID);
		   login.paswordtxt = chromeDriver.LocateById(login.paswordtxtID);
		   login.submit = chromeDriver.LocateById(login.submitID);
		}catch(Exception e) {
			Reporter.log("Can't find the submit Button 3");
			Assert.assertTrue(false);
		}
	  	act = builder.sendKeys(login.userNametxt,"hell12").build();
	  	act.perform();
	  	act = builder.sendKeys(login.paswordtxt,"1212145").build();
	  	act.perform();
	  	act = builder.moveToElement(login.submit).click().build();
	  	act.perform();
	  	Thread.sleep(3000);
	  	try {
	  		login.Errorlable = chromeDriver.LocateByXpath("//*[@id='partition-register']/div[2]/form/p[1]");
	  	}catch(Exception e) {
			Reporter.log("Can't find the signIn Button test 2");
			return;
		}
	  	String expected = login.Errorlable.getText();
	  	String actual="Incorrect username or password";
	  	assertEquals(actual, expected);
  	}
  
  @Test (priority=5,description="Forget username")
  public void Test5() throws InterruptedException {
	  	chromeDriver.nav(chromeDriver.Url);
	  	Thread.sleep(5000);
	  	try {
	  		login.signBtn = chromeDriver.LocateById(login.signBtnID);
		}catch(Exception e) {
			Reporter.log("Can't find the signIn Button 5");
			Assert.assertTrue(false);
		}
	  	act = builder.moveToElement(login.signBtn).click().build();
	  	act.perform(); 
	  	Thread.sleep(3000);
	  	try {
		   login.forgetname =chromeDriver.LocateById(login.forgetnameID);
		}catch(Exception e) {
			Reporter.log("Can't find the submit Button 5");
			Assert.assertTrue(false);
		}
	  	act = builder.moveToElement(login.forgetname).click().build();
	  	act.perform();
	  	assertNull(login.signBtn);
  }
	  
  @Test (priority=6,description="Forget password")
  public void Test6() throws InterruptedException {
  		chromeDriver.nav(chromeDriver.Url);
  		Thread.sleep(5000);
  		try {
  			login.signBtn = chromeDriver.LocateById(login.signBtnID);
		}catch(Exception e) {
			Reporter.log("Can't find the signIn Button 6");
			Assert.assertTrue(false);
		}
  		act = builder.moveToElement(login.signBtn).click().build();
  		act.perform(); 
  		Thread.sleep(3000);
  		try {
  			login.forgotpasLable =chromeDriver.LocateById(login.forgotpasLableID);
		   
		}catch(Exception e) {
			Reporter.log("Can't find the submit Button 6");
			Assert.assertTrue(false);
		}
  		act = builder.moveToElement(login.forgotpasLable).click().build();
  		act.perform();
  		assertNull(login.signBtn);  
  }

  @Test (priority=7,description="Logout")
  public void Test7() throws Throwable {
	  	chromeDriver.nav(chromeDriver.Url);
	  	Thread.sleep(5000);
	  	try {
	  		login.signBtn = chromeDriver.LocateById(login.signBtnID);
		}catch(Exception e) {
			Reporter.log("Can't find the signIn Button 7");
			Assert.assertTrue(false);
		}
	  	act = builder.moveToElement(login.signBtn).click().build();
	  	act.perform(); 
	  	Thread.sleep(3000);
	  	try {
		   login.userNametxt = chromeDriver.LocateById(login.userNametxtID);
		   login.paswordtxt = chromeDriver.LocateById(login.paswordtxtID);
		   login.submit = chromeDriver.LocateById(login.submitID);
		}catch(Exception e) {
			Reporter.log("Can't find the submit Button 7");
			Assert.assertTrue(false);
		}
	  	act = builder.sendKeys(login.userNametxt,"hell12").build();
		act.perform();
		act = builder.sendKeys(login.paswordtxt,"hell12").build();
		act.perform();
		act = builder.moveToElement(login.submit).click().build();
		act.perform();
		Thread.sleep(5000);
		try {
			login.logout = chromeDriver.LocateById(login.logoutDivID);
		}catch(Exception e) {
			Reporter.log("Can't find loguot btn 5");
			Assert.assertTrue(false);
		}
	  	act = builder.moveToElement(login.logout).click().build();
		act.perform();
		Thread.sleep(1000);
		try {
			login.logoutButton = chromeDriver.LocateByXpath("//div[@id='loggedDiv']/ul/li[5]");
		}catch(Exception e) {
			Reporter.log("Can't find loguot btn 5");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(login.logoutButton).click().build();
		act.perform();
		Thread.sleep(1000);
		try {
			login.signBtn = chromeDriver.LocateById(login.signBtnID);
		}catch(Exception e) {
			Reporter.log("Can't  loguot");
			Assert.assertTrue(false);
		}
  }
	  
  @Test (priority=8,description="Right mail and pass")
  public void Test4() throws Throwable {
	  	chromeDriver.nav(chromeDriver.Url);
	  	Thread.sleep(5000);
	  	try {
	  		login.signBtn = chromeDriver.LocateById(login.signBtnID);
		}catch(Exception e) {
			Reporter.log("Can't find the signIn Button 4");
			Assert.assertTrue(false);
		}
	  	act = builder.moveToElement(login.signBtn).click().build();
	  	act.perform(); 
	  	Thread.sleep(3000);
	  	try {
		   login.userNametxt = chromeDriver.LocateById(login.userNametxtID);
		   login.paswordtxt = chromeDriver.LocateById(login.paswordtxtID);
		   login.submit = chromeDriver.LocateById(login.submitID);
		}catch(Exception e) {
			Reporter.log("Can't find the submit Button 4");
			Assert.assertTrue(false);
		}
	  	act = builder.sendKeys(login.userNametxt,"hell12").build();
	  	act.perform();
	  	act = builder.sendKeys(login.paswordtxt,"hell12").build();
	  	act.perform();
	  	act = builder.moveToElement(login.submit).click().build();
	  	act.perform();
	  	Thread.sleep(5000);
	  	try {
	  		login.UserInfo = chromeDriver.LocateById(login.logoutDivID);
		}catch(Exception e) {
			Reporter.log("Can't login");
			Assert.assertTrue(false);
		}
	  	String expected = login.UserInfo.getText();
	  	String actual="King";
		Assert.assertEquals(actual, expected);
  }
	  
}
