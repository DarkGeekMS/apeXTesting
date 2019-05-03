package firefoxTestingScript;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import DriverDef.Firefox;
import PageModel.LoginPage;
import PageModel.profileSettingPage;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class FFsettingTests
{
	public Firefox driver;
	public profileSettingPage settingPage;
	public LoginPage login;
	public Actions builder;
	public org.openqa.selenium.interactions.Action act;
	
	@BeforeClass
	public void BeforeClass() throws Throwable
		{
		    driver = new Firefox();
			settingPage = new profileSettingPage();
			login = new LoginPage();
			builder = new Actions(driver.driver);
			Reporter.log("setting test starts");
			////////////////////////////////////////////
			//LOG IN and open setting page/////
			////////////////////////////////////////////
			driver.nav(driver.Url);
		  	Thread.sleep(5000);
		  	try {
		  		login.signBtn = driver.LocateById(login.signBtnID);
			}catch(Exception e) {
				Reporter.log("Can't find the signIn Button ");
				Assert.assertTrue(false);
			}
		  	act = builder.moveToElement(login.signBtn).click().build();
		  	act.perform(); 
		  	Thread.sleep(3000);
		  	try {
			   login.userNametxt = driver.LocateById(login.userNametxtID);
			   login.paswordtxt = driver.LocateById(login.paswordtxtID);
			   login.submit = driver.LocateById(login.submitID);
			}catch(Exception e) {
				Reporter.log("Can't find the submit Button ");
				Assert.assertTrue(false);
			}
		  	
		  	act = builder.sendKeys(login.userNametxt,"mondaTalaat").build();
		  	act.perform();
		  	act = builder.sendKeys(login.paswordtxt,"monda21").build();
		  	act.perform();
		  	act = builder.moveToElement(login.submit).click().build();
		  	act.perform();
		  	Thread.sleep(5000);											//log in done
		  	
		  	try {
		  		login.UserInfo = driver.LocateById(login.logoutDivID);
			}catch(Exception e) {
				Reporter.log("Can't login");
				Assert.assertTrue(false);
			}
		  	act = builder.moveToElement(login.UserInfo).click().build();
		  	act.perform();
			try {
				login.settingBTN = driver.LocateByXpath("//a[@class='router-link-exact-active router-link-active']");
			}catch(Exception e) {
				Reporter.log("Can't find setting btn");
				Assert.assertTrue(false);
			}
			act = builder.moveToElement(login.settingBTN).click().build();
			act.perform();
			Thread.sleep(1000);
			
		}
	@AfterClass
	public void finalize()
		{
			Reporter.log("setting test ends");
			driver.shutdown();
		}
	
/*	@BeforeTest
	public void BeforeTest()
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
				login.settingBTN = driver.LocateByXpath("//a[@class='router-link-exact-active router-link-active']");
			}catch(Exception e) {
				Reporter.log("Can't find setting btn");
				Assert.assertTrue(false);
			}
			act = builder.moveToElement(login.settingBTN).click().build();
			act.perform();
			Thread.sleep(1000);
		}*/	
	
	
	@Test(priority=1,description="cancel change pass test")
	public void cancelChangePass() throws Throwable 
{
	  try {
		  settingPage.changepassbutton = driver.LocateById(settingPage.changepassbuttonid);
		}catch(Exception e) {
			Reporter.log("Can't find the change pasword Button ");
			Assert.assertTrue(false);
		}
	  	act = builder.moveToElement(settingPage.changepassbutton).click().build();
	  	act.perform();    															 // change pass form opened
	  	
	  	Thread.sleep(3000);
	  	try {
	  		settingPage.oldpasstxt = driver.LocateByXpath("//input[@placeholder='Old Password']");
	  		settingPage.newpasstxt = driver.LocateByXpath("//input[@placeholder='New Password']");
	  		settingPage.usernameTXT = driver.LocateById(settingPage.usernameTXTid);
	  		settingPage.cancelpassBtn = driver.LocateById(settingPage.cancelpassBtnid);
		}catch(Exception e) {
			Reporter.log("Can't find the cancel Button ");
			Assert.assertTrue(false);
		}
	  	act = builder.sendKeys(settingPage.usernameTXT,"monda22").build();
		act.perform();
		act = builder.sendKeys(settingPage.oldpasstxt,"monda21").build();
		act.perform();
		act = builder.sendKeys(settingPage.newpasstxt,"monda22").build();
		act.perform();
		
		act = builder.moveToElement(settingPage.cancelpassBtn).click().build();
		act.perform();
		Thread.sleep(5000);  													 //  new pass canceled

		assertNull(settingPage.newpasstxt);
	  	
	  	
}

	@Test(priority=2,description="inter wrong  username when you change pass")
	public void wrongPass() throws Throwable
	{
		try {
			  settingPage.changepassbutton = driver.LocateById(settingPage.changepassbuttonid);
			}catch(Exception e) {
				Reporter.log("Can't find the change pasword Button ");
				Assert.assertTrue(false);
			}
		  	act = builder.moveToElement(settingPage.changepassbutton).click().build();
		  	act.perform();    															 // change password form opened
		  	
		  	Thread.sleep(3000);
		  	try {
		  		settingPage.oldpasstxt = driver.LocateByXpath("//input[@placeholder='Old Password']");
		  		settingPage.newpasstxt = driver.LocateByXpath("//input[@placeholder='New Password']");
		  		settingPage.usernameTXT = driver.LocateById(settingPage.usernameTXTid);
		  		settingPage.savepassBTN = driver.LocateById(settingPage.savepassBTNid);
			}catch(Exception e) {
				Reporter.log("Can't find the save Button ");
				Assert.assertTrue(false);
			}
		  	act = builder.sendKeys(settingPage.usernameTXT,"sqqwswq").build();
			act.perform();
			act = builder.sendKeys(settingPage.oldpasstxt,"monda21").build();
			act.perform();
			act = builder.sendKeys(settingPage.newpasstxt,"cwdwe").build();
			act.perform();
			
			act = builder.moveToElement(settingPage.savepassBTN).click().build();
			act.perform();																// enter two unmatches pass
			
																						//check wrong message 			
	}
		
	@Test(priority=3,description="complete change pass test")
	public void changePasswordTest() throws Throwable 
	  {
		  try {
			  settingPage.changepassbutton = driver.LocateById(settingPage.changepassbuttonid);
			}catch(Exception e) {
				Reporter.log("Can't find the change pasword Button ");
				Assert.assertTrue(false);
			}
		  	act = builder.moveToElement(settingPage.changepassbutton).click().build();
		  	act.perform();    															 // change pass form opened
		  	
		  	Thread.sleep(3000);
		  	try {
		  		settingPage.oldpasstxt = driver.LocateByXpath("//input[@placeholder='Old Password']");
		  		settingPage.newpasstxt = driver.LocateByXpath("//input[@placeholder='New Password']");
		  		settingPage.usernameTXT = driver.LocateById(settingPage.usernameTXTid);
		  		settingPage.savepassBTN = driver.LocateById(settingPage.savepassBTNid);
			}catch(Exception e) {
				Reporter.log("Can't find the submit Button 7");
				Assert.assertTrue(false);
			}
		  	act = builder.sendKeys(settingPage.oldpasstxt,"monda21").build();
			act.perform();
			act = builder.sendKeys(settingPage.newpasstxt,"monda22").build();
			act.perform();
			act = builder.sendKeys(settingPage.usernameTXT,"monda22").build();
			act.perform();
			act = builder.moveToElement(settingPage.savepassBTN).click().build();
			act.perform();
			Thread.sleep(5000);  													 //  new pass saved
			
			try {
		  		login.UserInfo = driver.LocateById(login.logoutDivID);
			}catch(Exception e) {
				Reporter.log("Can't login");
				Assert.assertTrue(false);
			}
		  	act = builder.moveToElement(login.UserInfo).click().build();
		  	act.perform();
		  	
		  	try {
		  		login.logoutButton = driver.LocateByXpath("//a[@class='logOut']");
			}catch(Exception e) {
				Reporter.log("Can't logout");
				Assert.assertTrue(false);
			}
		  	act = builder.moveToElement(login.logoutButton).click().build();
		  	act.perform();														  // logged out
		  	
		  	Thread.sleep(5000);
		  	try {
		  		login.signBtn = driver.LocateById(login.signBtnID);
			}catch(Exception e) {
				Reporter.log("Can't find the signIn Button ");
				Assert.assertTrue(false);
			}
		  	act = builder.moveToElement(login.signBtn).click().build();
		  	act.perform(); 
		  	Thread.sleep(3000);
		  	try {
			   login.userNametxt = driver.LocateById(login.userNametxtID);
			   login.paswordtxt = driver.LocateById(login.paswordtxtID);
			   login.submit = driver.LocateById(login.submitID);
			}catch(Exception e) {
				Reporter.log("Can't find the submit Button ");
				Assert.assertTrue(false);
			}
		  	
		  	act = builder.sendKeys(login.userNametxt,"mondaTalaat").build();
		  	act.perform();
		  	act = builder.sendKeys(login.paswordtxt,"monda22").build();
		  	act.perform();
		  	act = builder.moveToElement(login.submit).click().build();
		  	act.perform();															// log in with new pass
		  	
		  	
		  	try {
		  		login.UserInfo = driver.LocateById(login.logoutDivID);
			}catch(Exception e) {
				Reporter.log("Can't login");
				Assert.assertTrue(false);
			}
		  	String actual ="mondaTalaat";
			
		  	String expected =driver.driver.findElement(By.id(login.logoutDivID)).getText();
			assertEquals(actual, expected);
	  }
	
	@Test(priority=4,description="Allow notification Test test")
	public void allowNotifications() throws Throwable
	{
		try {
			  settingPage.notificationRadiobutton = driver.LocateByXpath(settingPage.notificationRadiobuttonxpath);
			}catch(Exception e) {
				Reporter.log("Can't find the radio Button ");
				Assert.assertTrue(false);
			}
		  	act = builder.moveToElement(settingPage.notificationRadiobutton).click().build();
		  	act.perform();    																	// radio button is clicked
	// not completed don't know what should happened
		  	
		  																						//check that notification is allowed
	}
	
	@Test(priority=5,description="change profile picture test")
	public void changePic() throws Throwable
	{
		try {
			  settingPage.Psimage = driver.LocateById(settingPage.Psimageid);
			}catch(Exception e) {
				Reporter.log("Can't find the change profile image Button ");
				Assert.assertTrue(false);
			}
		
		   builder.sendKeys(settingPage.Pimage,"C:\\Users\\future\\Desktop\\profile").build(); 
		   act.perform(); 
		  	
		  // chromeDriver.driver.findElement(By.id(settingPage.Pimageid)).sendKeys("C:\\Users\\future\\Desktop\\profile");   																	// radio button is clicked
	
		   BufferedImage imgA = ImageIO.read(new File(settingPage.Psimage.getAttribute("src")));																						//send image to sight
		   try {
				  settingPage.saveImgButton = driver.LocateById(settingPage.saveImgButtonid);
				}catch(Exception e) {
					Reporter.log("Can't find the save image Button ");
					Assert.assertTrue(false);
				}
			act = builder.moveToElement(settingPage.saveImgButton).click().build();
		  	act.perform(); 																	// click save
			  	
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
				Thread.sleep(1000);							// profile is opened
			  	
				try {
					  settingPage.Pimage = driver.LocateByXpath("//img[@class='image']");
					}catch(Exception e) {
						Reporter.log("Can't find the  profile image ");
						Assert.assertTrue(false);
					}
				BufferedImage imgb = ImageIO.read(new File(settingPage.Pimage.getAttribute("src")));																						//send image to sight
				boolean check =settingPage.bufferedImagesEqual(imgA, imgb);
				assertTrue(check);
				
				
	}
	
	
	@Test(priority=7,description="deactivate profile test")
	public void deactivate() throws Throwable
	{

		 try {
			  settingPage.deactivateaccountBTN = driver.LocateById(settingPage.deactivateaccountBTNid);
			}catch(Exception e) {
				Reporter.log("Can't find the change pasword Button ");
				Assert.assertTrue(false);
			}
		  	act = builder.moveToElement(settingPage.deactivateaccountBTN).click().build();
		  	act.perform(); 																// click on deactivate Button
		  	
		  	try {
				  settingPage.passtodeactivateTXT = driver.LocateById(settingPage.passtodeactivateTXTid);
				}catch(Exception e) {
					Reporter.log("Can't find the change pasword Button ");
					Assert.assertTrue(false);
				}
			  	act = builder.sendKeys(settingPage.passtodeactivateTXT,"123456").build();
			  	act.perform(); 															// enter password
		  	
		  	try {
				  settingPage.deletefordeactivateBTN = driver.LocateById(settingPage.deletefordeactivateBTNid);
				}catch(Exception e) {
					Reporter.log("Can't find the  delete Button ");
					Assert.assertTrue(false);
				}
			act = builder.moveToElement(settingPage.deletefordeactivateBTN).click().build();
		  	act.perform(); 							//press on delete
			Thread.sleep(1000);
			try {
		  		login.signBtn = driver.LocateById(login.signBtnID);
			}catch(Exception e) {
				Reporter.log("Can't find the signIn Button ");
				Assert.assertTrue(false);
			}
			assertNotNull(login.signBtn);
			  	
	}

	@Test(priority=8,description="deactivate profile test and cancel")
	public void canceldeactivate() throws Throwable
	{

		 try {
			  settingPage.deactivateaccountBTN = driver.LocateById(settingPage.deactivateaccountBTNid);
			}catch(Exception e) {
				Reporter.log("Can't find the change pasword Button ");
				Assert.assertTrue(false);
			}
		  	act = builder.moveToElement(settingPage.deactivateaccountBTN).click().build();
		  	act.perform(); 																// click on deactivate Button
		  	
		  	try {
				  settingPage.passtodeactivateTXT = driver.LocateById(settingPage.passtodeactivateTXTid);
				}catch(Exception e) {
					Reporter.log("Can't find the change pasword Button ");
					Assert.assertTrue(false);
				}
			  	act = builder.sendKeys(settingPage.passtodeactivateTXT,"123456").build();
			  	act.perform(); 															// enter password
		  	
		  	try {
				  settingPage.canceldeactivateBTN = driver.LocateById(settingPage.canceldeactivateBTNid);
				}catch(Exception e) {
					Reporter.log("Can't find the  delete Button ");
					Assert.assertTrue(false);
				}
			act = builder.moveToElement(settingPage.canceldeactivateBTN).click().build();
		  	act.perform(); 							//press on delete
			Thread.sleep(1000);
			
			assertNull(settingPage.canceldeactivateBTN);
			  	
	}

}
