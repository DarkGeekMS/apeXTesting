package TestingScript;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Keys;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import DriverDef.Chrome;
import PageModel.LoginPage;
import PageModel.profileSettingPage;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class settingTests
{
	public Chrome driver;
	public profileSettingPage settingPage;
	public LoginPage login;
	public Actions builder;
	public org.openqa.selenium.interactions.Action act;
	
	@BeforeClass
	public void BeforeClass() throws Throwable
		{
		    driver = new Chrome();
			settingPage = new profileSettingPage();
			login = new LoginPage();
			builder = new Actions(driver.driver);
			Reporter.log("setting test starts");
			////////////////////////////////////////////
			//LOG IN and open setting page/////
			////////////////////////////////////////////
			driver.nav(driver.Url);
		  	Thread.sleep(5000);
		  	
		  	signin("eslam","123459");
		  	try {
		  		login.UserInfo = driver.LocateById(login.logoutDivID);
			}catch(Exception e) {
				Reporter.log("Can't login");
				Assert.assertTrue(false);
			}
		  	act = builder.moveToElement(login.UserInfo).click().build();
		  	act.perform();
			Thread.sleep(1000);

			try {
				login.settingBTN = driver.LocateByXpath("//*[@id='loggedbutton']//following-sibling::ul/li[3]");
			System.out.print("fount");
			}catch(Exception e) {
				Reporter.log("Can't find setting btn");
				Assert.assertTrue(false);
			}
			act = builder.moveToElement(login.settingBTN).click().build();
			act.perform();
			Thread.sleep(1000);
		  									// press on setting
			
		}
	@AfterClass
	public void finalize()
		{
			Reporter.log("setting test ends");
			driver.shutdown();
		}

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
	  		
	  		settingPage.cancelpassBtn = driver.LocateById(settingPage.cancelpassBtnid);
		}catch(Exception e) {
			Reporter.log("Can't find the cancel Button ");
			Assert.assertTrue(false);
		}
		
		act = builder.moveToElement(settingPage.cancelpassBtn).click().build();
		act.perform();
		Thread.sleep(5000);  													 //  new pass canceled

		assertNull(settingPage.usernameTXT);
	  	
	  	
}


	@Test(priority=2,description="inter wrong  username when you change pass")
	public void wrongusername() throws Throwable
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
		  	act = builder.sendKeys(settingPage.usernameTXT,"eslaam").build();
			act.perform();
			act = builder.sendKeys(settingPage.oldpasstxt,"123459").build();
			act.perform();
			act = builder.sendKeys(settingPage.newpasstxt,"123456").build();
			act.perform();
			
			act = builder.moveToElement(settingPage.savepassBTN).click().build();
			act.perform();																// enter two unmatches pass
			
			try {
				  settingPage.allertmess = driver.LocateById(settingPage.allertmessid);
				}catch(Exception e) {
					Reporter.log("Can't find the change pasword Button ");
					Assert.assertTrue(false);
				}																			//check wrong message 			
			assertNotNull(settingPage.allertmess);
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
		  	settingPage.oldpasstxt.clear();
		  	act = builder.sendKeys(settingPage.oldpasstxt,"123459").build();
			act.perform();
			
			settingPage.newpasstxt.clear();
			act = builder.sendKeys(settingPage.newpasstxt,"123456").build();
			act.perform();
			
			settingPage.usernameTXT.clear();
			act = builder.sendKeys(settingPage.usernameTXT,"eslam").build();
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
		  	signin("eslam","123456");													// log in with new pass
		  	
		  	
		  	try {
		  		login.UserInfo = driver.LocateById(login.logoutDivID);
			}catch(Exception e) {
				Reporter.log("Can't login");
				Assert.assertTrue(false);
			}
		  	String actual ="eslam";
			
		  	String expected =driver.driver.findElement(By.id(login.logoutDivID)).getText();
			assertEquals(actual, expected);
	  }
	

	
	@Test(priority=4,description="change profile picture test")
	public void changePic() throws Throwable
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
			login.settingBTN = driver.LocateByXpath("//*[@id='loggedbutton']//following-sibling::ul/li[3]");
		}catch(Exception e) {
			Reporter.log("Can't find setting btn");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(login.settingBTN).click().build();
		act.perform();
		Thread.sleep(1000);											// open setting page
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
				login.profileBTN = driver.LocateByXpath("//*[@id='loggedbutton']//following-sibling::ul/li[2]");
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
	@Test(priority=5,description="deactivate profile test and cancel")
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
		  	settingPage.passtodeactivateTXT.clear();
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
			
			assertNotNull(settingPage.canceldeactivateBTN);
			  	
	}

	@Test(priority=6,description="inter wrong pass to deactivate profile test")
	public void wrongdeactivation() throws Throwable
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
			login.settingBTN = driver.LocateByXpath("//*[@id='loggedbutton']//following-sibling::ul/li[3]");
		}catch(Exception e) {
			Reporter.log("Can't find setting btn");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(login.settingBTN).click().build();
		act.perform();
		Thread.sleep(1000);
															// open setting page
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
				settingPage.deletefordeactivateBTN = driver.LocateById("register-btn");
			}catch(Exception e) {
				Reporter.log("Can't find the signIn Button ");
				Assert.assertTrue(false);
			}
			assertNotNull(login.signBtn);
			  	
	}
	
	@Test(priority=7,description="deactivate profile test")
	public void deactivate() throws Throwable
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
			login.settingBTN = driver.LocateByXpath("//*[@id='loggedbutton']//following-sibling::ul/li[3]");
		}catch(Exception e) {
			Reporter.log("Can't find setting btn");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(login.settingBTN).click().build();
		act.perform();
		Thread.sleep(1000);
															// open setting page
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
