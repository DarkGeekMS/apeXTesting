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
		System.out.println("Sign up test starts");
	}
	@AfterClass
	public void finalize()
	{
		System.out.println("Sign up test ends");
		chromeDriver.shutdown();
	}



	@Test (priority=1,description="submit without entering data")
	 public void Test1() throws Throwable {
			   chromeDriver.nav("http://localhost:8080/");
			   try {
				   login.signBtn = chromeDriver.LocateById(login.signBtnID);
				}catch(Exception e) {
					System.out.println("Can't find the signIn Button");
					Assert.assertTrue(false);
				}

			   act = builder.moveToElement(login.signBtn).click().build();
			   act.perform();
			   
			  try {
				   login.submit = chromeDriver.LocateById(login.submitID);
				}catch(Exception e) {
					System.out.println("Can't find the submit Button test 1");
					Assert.assertTrue(false);
				}
			  act = builder.moveToElement(login.submit).click().build();
			   act.perform();
			   
			   try {
				  login.signlable = chromeDriver.LocateById(login.signlableID);
				}catch(Exception e) {
					System.out.println("not stayed in sama page after submit test 1");
					return;
				}

			  String expected = login.signlable.getText();  // take pass of lable
			  String actual="Sign in";
			  assertEquals(actual, expected);
			  
			   
		  }

	@Test (priority=2,description="wrong user name")
	  public void Test2() throws Throwable {
		  chromeDriver.nav("http://localhost:8080/");
		  try {
			   login.signBtn = chromeDriver.LocateById(login.signBtnID);
			}catch(Exception e) {
				System.out.println("Can't find the signIn Button");
				Assert.assertTrue(false);
			}

		   act = builder.moveToElement(login.signBtn).click().build();
		   act.perform();
		   
		  try {
			   login.userNametxt = chromeDriver.LocateById(login.userNametxtID);
			   login.paswordtxt = chromeDriver.LocateById(login.paswordtxtID);
			   login.submit = chromeDriver.LocateById(login.submitID);
			}catch(Exception e) {
				System.out.println("Can't find the signIn Button test 2");
				Assert.assertTrue(false);
			}

		    act = builder.sendKeys(login.userNametxt,"reem").build();
			act.perform();
			act = builder.sendKeys(login.paswordtxt,"1212145").build();
			act.perform();
			act = builder.moveToElement(login.submit).click().build();
			act.perform();
			
		  try {
			   login.incorrectmailLable = chromeDriver.LocateById(login.incorrectmailLableID);
			}catch(Exception e) {
				System.out.println("Can't find the signIn Button test 2");
				return;
			}
		  String expected = login.incorrectmailLable.getText();
		  String actual=" Incorrect username or password  ";
		  assertEquals(actual, expected);

	  }


	  @Test (priority=3,description="wrong pass")
	  public void Test3() throws Throwable {
		  chromeDriver.nav("http://localhost:8080/");
		  try {
			   login.signBtn = chromeDriver.LocateById(login.signBtnID);
			}catch(Exception e) {
				System.out.println("Can't find the signIn Button 3");
				Assert.assertTrue(false);
			}
		  act = builder.moveToElement(login.signBtn).click().build();
		  act.perform();

		  try {
			   login.userNametxt = chromeDriver.LocateById(login.userNametxtID);
			   login.paswordtxt = chromeDriver.LocateById(login.paswordtxtID);
			   login.submit = chromeDriver.LocateById(login.submitID);
			}catch(Exception e) {
				System.out.println("Can't find the submit Button 3");
				Assert.assertTrue(false);
			}


		act = builder.sendKeys(login.userNametxt,"King").build();
		act.perform();
		act = builder.sendKeys(login.paswordtxt,"1212145").build();
		act.perform();
		act = builder.moveToElement(login.submit).click().build();
		act.perform();
	
		try {
			   login.incorrectmailLable = chromeDriver.LocateById(login.incorrectmailLableID);
			}catch(Exception e) {
				System.out.println("Can't find the signIn Button 3");
				return;
			}
		  String expected = login.incorrectmailLable.getText();  // take pass of lable
		  String actual=" Incorrect username or password  ";
		assertEquals(actual, expected);

	  }

	  @Test (priority=4,description="right mail and pass")
	  public void Test4() throws Throwable {
		  chromeDriver.nav("http://localhost:8080/");
		  try {
			   login.signBtn = chromeDriver.LocateById(login.signBtnID);
			}catch(Exception e) {
				System.out.println("Can't find the signIn Button 4");
				Assert.assertTrue(false);
			}
		 act = builder.moveToElement(login.signBtn).click().build();
		 act.perform(); 
		
		  try {
			   login.userNametxt = chromeDriver.LocateById(login.userNametxtID);
			   login.paswordtxt = chromeDriver.LocateById(login.paswordtxtID);
			   login.submit = chromeDriver.LocateById(login.submitID);
			}catch(Exception e) {
				System.out.println("Can't find the submit Button 4");
				Assert.assertTrue(false);
			}
		  act = builder.sendKeys(login.userNametxt,"ayatmostafa").build();
		  act.perform();
    	  act = builder.sendKeys(login.paswordtxt,"0000000").build();
		act.perform();
		act = builder.moveToElement(login.submit).click().build();
		act.perform();
		Thread.sleep(5000);
			  try {
				   login.UserInfo = chromeDriver.LocateById(login.UserInfoID);
				}catch(Exception e) {
					System.out.println("Can't login");
					Assert.assertTrue(false);
				}
			  String expected = login.UserInfo.getText();
			  String actual=" ayatmostafa  ";
			Assert.assertNotEquals(actual, expected);
	  }
	  
	  @Test (priority=5,description="forget username")
	  public void Test5() {
		  chromeDriver.nav("http://localhost:8080/");
		  try {
			   login.signBtn = chromeDriver.LocateById(login.signBtnID);
			}catch(Exception e) {
				System.out.println("Can't find the signIn Button 5");
				Assert.assertTrue(false);
			}
		 act = builder.moveToElement(login.signBtn).click().build();
		 act.perform(); 
	
		  try {
			   login.forgetname =chromeDriver.LocateById(login.forgetnameID);
			   
			}catch(Exception e) {
				System.out.println("Can't find the submit Button 5");
				Assert.assertTrue(false);
			}
		  
		  act = builder.moveToElement(login.forgetname).click().build();
		  act.perform();
		  assertNull(login.signlable);
		 
	  }
	  
	  @Test (priority=6,description="forget password")
	  public void Test6() {
		  chromeDriver.nav("http://localhost:8080/");
		  try {
			   login.signBtn = chromeDriver.LocateById(login.signBtnID);
			}catch(Exception e) {
				System.out.println("Can't find the signIn Button 6");
				Assert.assertTrue(false);
			}
		 act = builder.moveToElement(login.signBtn).click().build();
		 act.perform(); 

		  try {
			   login.forgotpasLable =chromeDriver.LocateById(login.forgetnameID);
			   
			}catch(Exception e) {
				System.out.println("Can't find the submit Button 6");
				Assert.assertTrue(false);
			}
		  
		  act = builder.moveToElement(login.forgotpasLable).click().build();
		  act.perform();
		  assertNull(login.signlable);
		  
	  }

	  @Test (priority=7,description="loguot")
	  public void Test7() throws Throwable {
		  chromeDriver.nav("http://localhost:8080/");
		  try {
			   login.signBtn = chromeDriver.LocateById(login.signBtnID);
			}catch(Exception e) {
				System.out.println("Can't find the signIn Button 7");
				Assert.assertTrue(false);
			}
		 act = builder.moveToElement(login.signBtn).click().build();
		 act.perform(); 
		 
		  try {
			   login.userNametxt = chromeDriver.LocateById(login.userNametxtID);
			   login.paswordtxt = chromeDriver.LocateById(login.paswordtxtID);
			   login.submit = chromeDriver.LocateById(login.submitID);
			}catch(Exception e) {
				System.out.println("Can't find the submit Button 7");
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
					   login.logout = chromeDriver.LocateById(login.logoutDivID);
					}catch(Exception e) {
						System.out.println("Can't find loguot btn 5");
						Assert.assertTrue(false);
					}
				  	act = builder.moveToElement(login.logout).click().build();
					act.perform();
					try {
						   login.logoutButton = chromeDriver.LocateById(login.logoutButtonId);
						}catch(Exception e) {
							System.out.println("Can't find loguot btn 5");
							Assert.assertTrue(false);
						}
					act = builder.moveToElement(login.logoutButton).click().build();
					act.perform();

					try {
						   login.signBtn = chromeDriver.LocateById(login.signBtnID);
						}catch(Exception e) {
							System.out.println("Can't  loguot");
							Assert.assertTrue(false);
						}
	  }
}
