package TestingScript;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

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
	}



	@Test (priority=1,description="submit without entering data")
	 public void Test1() throws Throwable {
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
					System.out.println("login form not opened in test 1");
					return;
				}
			  try {
				   login.submit = chromeDriver.LocateById(login.submitID);
				}catch(Exception e) {
					System.out.println("Can't find the submit Button test 1");
					return;
				}
			  Thread.sleep(3000);
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
		  chromeDriver.naivgates("http://localhost:8080/");
		  try {
			   login.signBtn = chromeDriver.LocateById(login.signBtnID);
			}catch(Exception e) {
				System.out.println("Can't find the signIn Button test 2");
				return;
			}
		  act = builder.moveToElement(login.signBtn).click().build();
		  act.perform();
		  try {
			   login.signlable = chromeDriver.LocateById(login.signlableID);
			}catch(Exception e) {
				System.out.println("Can't find the signIn Button test 2");
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
				System.out.println("Can't find the signIn Button test 2");
				return;
			}

		  act = builder.sendKeys(login.userNametxt,"reem").build();
			act.perform();
			act = builder.sendKeys(login.paswordtxt,"1212145").build();
			act.perform();
			Thread.sleep(3000);
			act = builder.moveToElement(login.submit).click().build();
			act.perform();

		  try {
			   login.incorrectmailLable = chromeDriver.LocateById(login.incorrectmailLableID);
			}catch(Exception e) {
				System.out.println("Can't find the signIn Button test 2");
				return;
			}
		  String expected = login.incorrectmailLable.getText();
		  String actual="Incorrect username or password";
		  assertEquals(actual, expected);
	  }


	  @Test (priority=3,description="wrong pass")
	  public void Test3() {
		  chromeDriver.naivgates("http://localhost:8080/");
		  try {
			   login.signBtn = chromeDriver.LocateById(login.signBtnID);
			}catch(Exception e) {
				System.out.println("Can't find the signIn Button 3");
				return;
			}
		  act = builder.moveToElement(login.signBtn).click().build();
		  act.perform();

		  try {
			   login.signlable = chromeDriver.LocateById(login.signlableID);
			}catch(Exception e) {
				System.out.println("Can't find the signIn Button 3");
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
				System.out.println("Can't find the signIn Button 3");
				return;
			}


		act = builder.sendKeys(login.userNametxt,"reem").build();
		act.perform();
		act = builder.sendKeys(login.paswordtxt,"1212145").build();
		act.perform();
		act = builder.moveToElement(login.submit).click().build();
		act.perform();
		  try {
			   login.incorrectpassLable = chromeDriver.LocateById(login.incorrectpassLableID);
			}catch(Exception e) {
				System.out.println("Can't find the signIn Button 3");
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

		  try {
			   login.userNametxt = chromeDriver.LocateById(login.userNametxtID);
			   login.paswordtxt = chromeDriver.LocateById(login.paswordtxtID);
			   login.submit = chromeDriver.LocateById(login.submitID);
			}catch(Exception e) {
				System.out.println("Can't find the signIn Button");
				return;
			}
		  act = builder.sendKeys(login.userNametxt,"reem").build();
			act.perform();
			act = builder.sendKeys(login.paswordtxt,"1212145").build();
			act.perform();
			act = builder.moveToElement(login.submit).click().build();
			act.perform();
			  try {
				   login.UserInfo = chromeDriver.LocateById(login.UserInfoID);
				}catch(Exception e) {
					System.out.println("Can't login");
					return;
				}
			  String expected = login.UserInfo.getText();
			  String actual="reem";
			assertEquals(actual, expected);

	  }

	  @Test (priority=5,description="loguot")
	  public void Test5() {
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

		  try {
			   login.userNametxt = chromeDriver.LocateById(login.userNametxtID);
			   login.paswordtxt = chromeDriver.LocateById(login.paswordtxtID);
			   login.submit = chromeDriver.LocateById(login.submitID);
			}catch(Exception e) {
				System.out.println("Can't find the signIn Button");
				return;
			}
		  act = builder.sendKeys(login.userNametxt,"reem").build();
			act.perform();
			act = builder.sendKeys(login.paswordtxt,"1212145").build();
			act.perform();
			act = builder.moveToElement(login.submit).click().build();
			act.perform();
			  try {
				   login.UserInfo = chromeDriver.LocateById(login.UserInfoID);
				}catch(Exception e) {
					System.out.println("Can't login");
					return;
				}
			  act = builder.moveToElement(login.UserInfo).click().build();
				act.perform();

				 try {
					   login.loguot = chromeDriver.LocateById(login.loguotID);
					}catch(Exception e) {
						System.out.println("Can't find loguot btn");
						return;
					}
				  act = builder.moveToElement(login.loguot).click().build();
					act.perform();

					try {
						   login.signBtn = chromeDriver.LocateById(login.signBtnID);
						}catch(Exception e) {
							System.out.println("Can't  loguot");
							return;
						}
				assertNotNull(login.signBtn);


	  }
}
