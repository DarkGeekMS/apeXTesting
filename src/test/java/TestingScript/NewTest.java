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


public class NewTest
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
	  @Test (priority=7,description="loguot")
	  public void Test7() throws Throwable {
		  chromeDriver.nav("http://localhost:8081/");
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
						System.out.println("can't logout");
						Assert.assertTrue(false);
					}
					act = builder.moveToElement(login.logoutButton).click().build();
					act.perform();
					try {
						   login.signBtn = chromeDriver.LocateById(login.signBtnID);
						}catch(Exception e) {
							System.out.println("Can't  logout");
							Assert.assertTrue(false);
						}
	  }
}
