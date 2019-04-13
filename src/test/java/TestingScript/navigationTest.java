package TestingScript;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import DriverDef.Chrome;
import PageModel.LoginPage;
import PageModel.navigation;

public class navigationTest {
	
	public Chrome chromeDriver;
	public navigation Navigations;
	public Actions builder;
	public org.openqa.selenium.interactions.Action act;


	@BeforeClass
	public void BeforeClass()
	{
		chromeDriver = new Chrome();
		Navigations = new navigation();
		builder = new Actions(chromeDriver.driver);
		System.out.println("Navigation test starts");
	}
	@AfterClass
	public void finalize()
	{
		System.out.println("navigation test ends");
		chromeDriver.shutdown();
	}
	
	
	@Test (priority=1,description="check that login Button don't change URL")
  public void login() 
  {
		chromeDriver.nav("http://localhost:8080/");
		   try {
			   Navigations.signBtn = chromeDriver.LocateById(Navigations.signBtnID);
			}catch(Exception e) {
				System.out.println("Can't find the signIn Button");
				Assert.assertTrue(false);
			}

		   act = builder.moveToElement(Navigations.signBtn).click().build();
		   act.perform();
		   String currentURL = chromeDriver.driver.getCurrentUrl();
		   assertEquals(Navigations.HomeLink, currentURL);
  }
  
	@Test (priority=2,description="Check that signup Buton don't change URL")
  public void signup() 
  {
		chromeDriver.nav("http://localhost:8080/");
		   try {
			   Navigations.SignUpButton = chromeDriver.LocateById(Navigations.SignUpButtonId);
			}catch(Exception e) {
				System.out.println("Can't find the SignUpButton ");
				Assert.assertTrue(false);
			}

		   act = builder.moveToElement(Navigations.SignUpButton).click().build();
		   act.perform();
		   String currentURL = chromeDriver.driver.getCurrentUrl();
		   assertEquals(Navigations.HomeLink, currentURL);
  }
	
	@Test (priority=3,description="check that post don't change URL")
  public void postslink() 
  {
		chromeDriver.nav("http://localhost:8080/");
		   try {
			   Navigations.postText = chromeDriver.LocateById(Navigations.postTextid);
			}catch(Exception e) {
				System.out.println("Can't find the post ");
				Assert.assertTrue(false);
			}

		   act = builder.moveToElement(Navigations.postText).click().build();
		   act.perform();
		   String currentURL = chromeDriver.driver.getCurrentUrl();
		   assertEquals(Navigations.HomeLink, currentURL);
  }
	
	@Test (priority=4,description="check that correct navigation to apexcom")
  public void apexcomLink() 
  {
		chromeDriver.nav("http://localhost:8080/");
		   try {
			   Navigations.apexcom = chromeDriver.LocateById(Navigations.apexcomid);
			}catch(Exception e) {
				System.out.println("Can't find the apexcom ");
				Assert.assertTrue(false);
			}

		   act = builder.moveToElement(Navigations.apexcom).click().build();
		   act.perform();
		   String currentURL = chromeDriver.driver.getCurrentUrl();
		   assertEquals(Navigations.apexcomLink, currentURL);
  }
	
  @Test (priority=5,description="check that correct navigation to apexcom posts")
  public void apexcomposts() 
  {
	  chromeDriver.nav("http://localhost:8080/");
	   try {
		   Navigations.apexcom = chromeDriver.LocateById(Navigations.apexcomid);
		}catch(Exception e) {
			System.out.println("Can't find the apexcom ");
			Assert.assertTrue(false);
		}

	   act = builder.moveToElement(Navigations.apexcom).click().build();
	   act.perform();
	   
	   try {
		   Navigations.apexcompost = chromeDriver.LocateById(Navigations.apexcompostid);
		}catch(Exception e) {
			System.out.println("Can't find the apexcom post button ");
			Assert.assertTrue(false);
		}

	   act = builder.moveToElement(Navigations.apexcompost).click().build();
	   act.perform();
	   String currentURL = chromeDriver.driver.getCurrentUrl();
	   assertEquals(Navigations.apexcomPostsLink, currentURL);
  }

  
	@Test (priority=6,description="check that correct navigation to user")
  public void userLink() 
  {
		chromeDriver.nav("http://localhost:8080/");
		   try {
			   Navigations.signBtn = chromeDriver.LocateById(Navigations.signBtnID);
			}catch(Exception e) {
				System.out.println("Can't find the signIn Button");
				Assert.assertTrue(false);
			}

		   act = builder.moveToElement(Navigations.signBtn).click().build();
		   act.perform();
		   try {
			   Navigations.userNametxt = chromeDriver.LocateById(Navigations.userNametxtID);
			   Navigations.paswordtxt = chromeDriver.LocateById(Navigations.paswordtxtID);
			   Navigations.submit = chromeDriver.LocateById(Navigations.submitID);
			}catch(Exception e) {
				System.out.println("Can't find the submit Button 4");
				Assert.assertTrue(false);
			}
		  act = builder.sendKeys(Navigations.userNametxt,"ayatmostafa").build();
		  act.perform();
    	  act = builder.sendKeys(Navigations.paswordtxt,"0000000").build();
		  act.perform();
		  act = builder.moveToElement(Navigations.submit).click().build();
		  act.perform();
		   
		   String currentURL = chromeDriver.driver.getCurrentUrl();
		   assertEquals(Navigations.userLink, currentURL);
		
  }
	
	@Test (priority=7,description="check that correct navigation to user")
	  public void logout() 
	  {
			chromeDriver.nav("http://localhost:8080/");
			   try {
				   Navigations.signBtn = chromeDriver.LocateById(Navigations.signBtnID);
				}catch(Exception e) {
					System.out.println("Can't find the signIn Button");
					Assert.assertTrue(false);
				}

			   act = builder.moveToElement(Navigations.signBtn).click().build();
			   act.perform();
			   try {
				   Navigations.userNametxt = chromeDriver.LocateById(Navigations.userNametxtID);
				   Navigations.paswordtxt = chromeDriver.LocateById(Navigations.paswordtxtID);
				   Navigations.submit = chromeDriver.LocateById(Navigations.submitID);
				}catch(Exception e) {
					System.out.println("Can't find the submit Button 4");
					Assert.assertTrue(false);
				}
			  act = builder.sendKeys(Navigations.userNametxt,"ayatmostafa").build();
			  act.perform();
	    	  act = builder.sendKeys(Navigations.paswordtxt,"0000000").build();
			  act.perform();
			  act = builder.moveToElement(Navigations.submit).click().build();
			  act.perform();
			  
			  try {
				  Navigations.logout = chromeDriver.LocateById(Navigations.logoutDivID);
				}catch(Exception e) {
					System.out.println("Can't find loguot btn 5");
					Assert.assertTrue(false);
				}
			  	act = builder.moveToElement(Navigations.logout).click().build();
				act.perform();
				try {
					Navigations.logoutButton = chromeDriver.LocateById(Navigations.logoutButtonId);
					}catch(Exception e) {
						System.out.println("Can't find loguot btn 5");
						Assert.assertTrue(false);
					}
				act = builder.moveToElement(Navigations.logoutButton).click().build();
				act.perform();
			   
			   String currentURL = chromeDriver.driver.getCurrentUrl();
			   assertEquals(Navigations.HomeLink, currentURL);
			
	  }
  
	
	

}
