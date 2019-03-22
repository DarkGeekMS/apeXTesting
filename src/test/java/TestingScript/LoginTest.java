package TestingScript;

import static org.testng.Assert.assertEquals;

import java.awt.Desktop.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import org.openqa.selenium.interactions.Actions;

import DriverDef.Chrome;
import PageModel.LoginPage; 


public class LoginTest
{
	public Chrome chromeDriver;
	public LoginPage login;
	
	
	public Actions builder;////////////////////////
	public Action act;///////////////
	
	
	@BeforeClass
	public void init()
	{
		chromeDriver = new Chrome();
		login = new LoginPage();
		builder = new Actions(chromeDriver.driver);/////////////////////
		System.out.println("Sign up test starts");
	}
	@AfterClass
	public void finalize()
	{
		System.out.println("Sign up test ends");
	}
	
	
	
	@Test (priority=1,description="submit without entering data")
	 public void Test1() {
			   chromeDriver.naivgates("http://localhost:8080/");
			   //chromeDriver.takescreenshots();
			   try {
				   login.signBtn = chromeDriver.LocateById(login.signBtnID);
				}catch(Exception e) {
					System.out.println("Can't find the signIn Button");
					return;
				}
			   
			   act = builder.moveToElement(login.signBtn).click().build();
			   act.perform();
			  
			  
			 
			  //chromeDriver.takescreenshots();
			  try {
				   login.signlable = chromeDriver.LocateById(login.signlableID);
				}catch(Exception e) {
					System.out.println("login form not opened in test 1");
					return;
				}
			  try {
				   login.submit = chromeDriver.LocateById(login.submitID);
				}catch(Exception e) {
					System.out.println("Can't find the submit Button");
					return;
				}
			  act = builder.moveToElement(login.submit).click().build();
			   act.perform();
			  //chromeDriver.takescreenshots();
			  try {
				  login.signlable = chromeDriver.LocateById(login.signlableID);
				}catch(Exception e) {
					System.out.println("not stayed in sama page after submit");
					return;
				}
			  
			  String expected = login.signlable.getText();  // take pass of lable
			  String actual="Sign in"; 
			  assertEquals(actual, expected); 
		  }
	@Test (priority=2,description="wrong user name")
	  public void Test2() {
		  chromeDriver.naivgates("http://localhost:8080/");
		  try {
			   login.signBtn = chromeDriver.LocateById(login.signBtnID);
			}catch(Exception e) {
				System.out.println("Can't find the signIn Button");
				return;
			}
		  act = builder.moveToElement(login.signBtn).click().build();
		  act.perform();
		  try {
			   login.signlable = chromeDriver.LocateById(login.signlableID);
			}catch(Exception e) {
				System.out.println("Can't find the signIn Button");
				return;
			}
		  try {
			   login.signlable = chromeDriver.LocateById(login.signlableID);
			}catch(Exception e) {
				System.out.println("login form not opened in test 2");
				return;
			}
		  try {
			   login.userNametxt = chromeDriver.LocateById(login.userNametxtID);
			   login.paswordtxt = chromeDriver.LocateById(login.paswordtxtID);
			   login.submit = chromeDriver.LocateById(login.submitID);
			}catch(Exception e) {
				System.out.println("Can't find the signIn Button");
				return;
			}
		 /*
		  login.userNametxt.sendKeys("cddcdsds");
		  login.paswordtxt.sendKeys("1261997");
		  login.submit.click();
		  */
		  
		  act = builder.sendKeys(login.userNametxt,"reem").build();
			act.perform();
			act = builder.sendKeys(login.paswordtxt,"1212145").build();
			act.perform();
			act = builder.moveToElement(login.submit).click().build();
			act.perform();
		 // chromeDriver.takescreenshots();
		  try {
			   login.incorrectmailLable = chromeDriver.LocateById(login.incorrectmailLableID);
			}catch(Exception e) {
				System.out.println("Can't find the signIn Button");
				return;
			}
		  String expected = login.incorrectmailLable.getText();  // take pass of lable
		  String actual="Incorrect username or password"; 
		  assertEquals(actual, expected); 
	  }
	
	  
	  @Test (priority=3,description="wrong pass")
	  public void Test3() {
		  chromeDriver.naivgates("http://localhost:8080/");
		  try {
			   login.signBtn = chromeDriver.LocateById(login.signBtnID);
			}catch(Exception e) {
				System.out.println("Can't find the signIn Button");
				return;
			}
		  act = builder.moveToElement(login.signBtn).click().build();
		  act.perform();
		  
		  try {
			   login.signlable = chromeDriver.LocateById(login.signlableID);
			}catch(Exception e) {
				System.out.println("Can't find the signIn Button");
				return;
			}
		  String s =login.signlable.getText();
		  if(s.contains("Sign in"))
		  {
			  System.out.print("login form openedin test 3");
		  }
		  else
		  {
			  System.out.print("login form not opened in test 3");
		  }
		  try {
			   login.userNametxt = chromeDriver.LocateById(login.userNametxtID);
			   login.paswordtxt = chromeDriver.LocateById(login.paswordtxtID);
			   login.submit = chromeDriver.LocateById(login.submitID);
			}catch(Exception e) {
				System.out.println("Can't find the signIn Button");
				return;
			}
		  /*
		  login.userNametxt.sendKeys("rehamgamalosman");
		  login.paswordtxt.sendKeys("kjkjk");
		  */
		  
		act = builder.sendKeys(login.userNametxt,"reem").build();
		act.perform();
		act = builder.sendKeys(login.paswordtxt,"1212145").build();
		act.perform();
		act = builder.moveToElement(login.submit).click().build();
		act.perform();
		  try {
			   login.incorrectpassLable = chromeDriver.LocateById(login.incorrectpassLableID);
			}catch(Exception e) {
				System.out.println("Can't find the signIn Button");
				return;
			}
		  String expected = login.incorrectpassLable.getText();  // take pass of lable
		  String actual="Incorrect password"; 
		assertEquals(actual, expected); 
	  }
	  
	  @Test (priority=4,description="right mail and pass")
	  public void Test4() {
		  chromeDriver.naivgates("http://localhost:8080/");
		  try {
			   login.signBtn = chromeDriver.LocateById(login.signBtnID);
			}catch(Exception e) {
				System.out.println("Can't find the signIn Button");
				return;
			}
		 act = builder.moveToElement(login.signBtn).click().build();
		 act.perform(); login.signBtn.click();
		  try {
			   login.signlable = chromeDriver.LocateById(login.signlableID);
			}catch(Exception e) {
				System.out.println("Can't find the signIn Button");
				return;
			}
		  String s =login.signlable.getText();
		  if(s.contains("Sign in"))
		  {
			  System.out.print("login form opened in test 4");
		  }
		  else
		  {
			  System.out.print("login form not opened in test 4");
		  }
		  try {
			   login.userNametxt = chromeDriver.LocateById(login.userNametxtID);
			   login.paswordtxt = chromeDriver.LocateById(login.paswordtxtID);
			   login.submit = chromeDriver.LocateById(login.submitID);
			}catch(Exception e) {
				System.out.println("Can't find the signIn Button");
				return;
			}
		  /*
		  login.userNametxt.sendKeys("rehamgamalosman");
		  login.paswordtxt.sendKeys("1261997");
		  login.submit.click();
		  */
		  
		  act = builder.sendKeys(login.userNametxt,"reem").build();
			act.perform();
			act = builder.sendKeys(login.paswordtxt,"1212145").build();
			act.perform();
			act = builder.moveToElement(login.submit).click().build();
			act.perform();
		  //chromeDriver.takescreenshots();
		  try {
			   login.UserInfo = chromeDriver.LocateById(login.UserInfoID);
			}catch(Exception e) {
				System.out.println("Can't find the signIn Button");
				return;
			}
		  String expected = login.UserInfo.getText();  // take pass of lable
		  String actual="RehamGamalosman"; 
		assertEquals(actual, expected); 
	  }
	  
	  /*
	  @Test (priority=5,description="forget username")
	  public void Test5() {
		  chromeDriver.naivgates("http://localhost:8080/");
		  try {
			   login.signBtn = chromeDriver.LocateById(login.signBtnID);
			}catch(Exception e) {
				System.out.println("Can't find the signIn Button");
				return;
			}
		  login.signBtn.click();
		  chromeDriver.takescreenshots();
		  String s =login.signlable.getText();
		  if(s.contains("Sign in"))
		  {
			  System.out.print("login form opened in test 5");
		  }
		  else
		  {
			  System.out.print("login form not opened in test 5");
		  }
		  login.forgetname.click();
		  chromeDriver.takescreenshots();
		  String expected = login.UserInfo.getText();  // take pass of lable
		  String actual="RehamGamalosman"; 
		assertEquals(actual, expected); 
	  }
	  
	  @Test (priority=6,description="forget password")
	  public void Test6() {
		  chromeDriver.naivgates("http://localhost:8080/");
		  try {
			   login.signBtn = chromeDriver.LocateById(login.signBtnID);
			}catch(Exception e) {
				System.out.println("Can't find the signIn Button");
				return;
			}
		  login.signBtn.click();
		  String s =login.signlable.getText();
		  if(s.contains("Sign in"))
		  {
			  System.out.print("login form opened in test 6");
		  }
		  else
		  {
			  System.out.print("login form not opened in test 6");
		  }
		  login.forgotpasLable.click();
		  chromeDriver.takescreenshots();
		  
		  String expected = login.UserInfo.getText();  // take pass of lable
		  String actual="RehamGamalosman"; 
		assertEquals(actual, expected); 
	  }
	 */
}



	/*
 @Test (priority=1,description="submit without entering data")
 public void Test1() {
		   chromeDriver.naivgates("http://localhost:8080/");
		   chromeDriver.takescreenshots();
		  login.signBtn.click();
		  String s =login.signlable.getText();
		  if(s.contains("Sign in"))
		  {
			  System.out.print("login form opened in test 1");
		  }
		  else
		  {
			  System.out.print("login form not opened in test 1");
		  }
		  chromeDriver.takescreenshots();
		  login.submit.click();
		  chromeDriver.takescreenshots();
		  String expected = login.signlable.getText();  // take pass of lable
		  String actual="Sign in"; 
		  assertEquals(actual, expected); 
	  }
	   
	@Test (priority=2,description="wrong user name")
  public void Test2() {
		chromeDriver.naivgates("http://localhost:8080/");
	  login.signBtn.click();
	  String s =login.signlable.getText();
	  if(s.contains("Sign in"))
	  {
		  System.out.print("login form opened in test 2");
	  }
	  else
	  {
		  System.out.print("login form not opened in test 2");
	  }
	  
	  login.userNametxt.sendKeys("cddcdsds");
	  login.paswordtxt.sendKeys("1261997");
	  login.submit.click();
	  chromeDriver.takescreenshots();
	  String expected = login.incorrectmailLable.getText();  // take pass of lable
	  String actual="Incorrect username or password"; 
	  assertEquals(actual, expected); 
  }
  
  @Test (priority=3,description="wrong pass")
  public void Test3() {
	  chromeDriver.naivgates("http://localhost:8080/");
	  login.signBtn.click();
	  
	  String s =login.signlable.getText();
	  if(s.contains("Sign in"))
	  {
		  System.out.print("login form openedin test 3");
	  }
	  else
	  {
		  System.out.print("login form not opened in test 3");
	  }
	  
	  login.userNametxt.sendKeys("rehamgamalosman");
	  login.paswordtxt.sendKeys("kjkjk");
	  String expected = login.incorrectpassLable.getText();  // take pass of lable
	  String actual="Incorrect password"; 
	assertEquals(actual, expected); 
  }
  
  @Test (priority=4,description="right mail and pass")
  public void Test4() {
	  chromeDriver.naivgates("http://localhost:8080/");
	  login.signBtn.click();
	  String s =login.signlable.getText();
	  if(s.contains("Sign in"))
	  {
		  System.out.print("login form opened in test 4");
	  }
	  else
	  {
		  System.out.print("login form not opened in test 4");
	  }
	  login.userNametxt.sendKeys("rehamgamalosman");
	  login.paswordtxt.sendKeys("1261997");
	  login.submit.click();
	  chromeDriver.takescreenshots();
	  String expected = login.UserInfo.getText();  // take pass of lable
	  String actual="RehamGamalosman"; 
	assertEquals(actual, expected); 
  }
  
  @Test (priority=5,description="forget username")
  public void Test5() {
	  chromeDriver.naivgates("http://localhost:8080/");
	  login.signBtn.click();
	  chromeDriver.takescreenshots();
	  String s =login.signlable.getText();
	  if(s.contains("Sign in"))
	  {
		  System.out.print("login form opened in test 5");
	  }
	  else
	  {
		  System.out.print("login form not opened in test 5");
	  }
	  login.forgetname.click();
	  chromeDriver.takescreenshots();
	  String expected = login.UserInfo.getText();  // take pass of lable
	  String actual="RehamGamalosman"; 
	assertEquals(actual, expected); 
  }
  
  @Test (priority=6,description="forget password")
  public void Test6() {
	  chromeDriver.naivgates("http://localhost:8080/");
	  login.signBtn.click();
	  String s =login.signlable.getText();
	  if(s.contains("Sign in"))
	  {
		  System.out.print("login form opened in test 6");
	  }
	  else
	  {
		  System.out.print("login form not opened in test 6");
	  }
	  login.forgotpasLable.click();
	  chromeDriver.takescreenshots();
	  
	  String expected = login.UserInfo.getText();  // take pass of lable
	  String actual="RehamGamalosman"; 
	assertEquals(actual, expected); 
  }
  
  @AfterSuite
  public void afterMethod() {
	  chromeDriver.shutdown();
  }
  */

  


