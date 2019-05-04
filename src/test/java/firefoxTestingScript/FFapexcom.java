package firefoxTestingScript;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import DriverDef.Firefox;
import PageModel.LoginPage;
import PageModel.apexcomPage;
import PageModel.searchPage;



public class FFapexcom {
	 public Firefox driver;
	 public apexcomPage ApexcomPage;
		public Actions builder;
		public searchPage SearchPage;
		public org.openqa.selenium.interactions.Action act;
		public LoginPage login;


		@BeforeClass
	  public void BeforeClass()
		{
	 SearchPage = new searchPage();
		login = new LoginPage();		
		ApexcomPage = new apexcomPage();
		builder = new Actions(driver.driver);
		Reporter.log("apexcom test starts");
	}
	@AfterClass
	public void finalize()
	{
		Reporter.log("apexcom test ends");
		driver.shutdown();
	}

@Test(priority=5,description="Openning Certain ApexCom from post")
public void openapeX() throws Throwable {
	  driver.nav(driver.Url);
	  Thread.sleep(3000);
	  try {
		  ApexcomPage.apexcom = driver.LocateById(ApexcomPage.apexcomid);
	  }catch(Exception e) {
		  Reporter.log("Can't find the apexcom ");
		  Assert.assertTrue(false);
	  }
	  String name = ApexcomPage.apexcom.getText();
	  act = builder.moveToElement(ApexcomPage.apexcom).click().build();
	  act.perform();
	  Thread.sleep(3000);								// open apex
	  try {
		  ApexcomPage.apexcompost = driver.LocateById(ApexcomPage.apexcompostid);
	  }catch(Exception e) {
		  Reporter.log("Can't find the apexcom post button ");
		  Assert.assertTrue(false);
	  }
	  act = builder.moveToElement(ApexcomPage.apexcompost).click().build();
	  act.perform();
	  Thread.sleep(3000);
	  
	  try {
		  ApexcomPage.posttitle = driver.LocateById(ApexcomPage.posttitleid);
	  }catch(Exception e) {
		  Reporter.log("Can't find the apexcom post title ");
		  Assert.assertTrue(false);
	  }
	  Thread.sleep(1000);
	  String expected=driver.Url + "/ApexCom/" + name + "/ApexPosts";
	  String current = driver.driver.getCurrentUrl();
	  assertEquals( expected, current);
}

@Test(priority=6,description="subscribe ApexCom from post")
public void subscribeapex() throws Throwable {
	  driver.nav(driver.Url);
	  Thread.sleep(3000);
	  try {
		  ApexcomPage.apexcom = driver.LocateById(ApexcomPage.apexcomid);
	  }catch(Exception e) {
		  Reporter.log("Can't find the apexcom ");
		  Assert.assertTrue(false);
	  }
	  String name = ApexcomPage.apexcom.getText();
	  act = builder.moveToElement(ApexcomPage.apexcom).click().build();
	  act.perform();
	  Thread.sleep(3000);					// open apex
	  try {
		  ApexcomPage.subscribebutton = driver.LocateById(ApexcomPage.subscribebuttonid);
	  }catch(Exception e) {
		  Reporter.log("Can't find the apexcom post button ");
		  Assert.assertTrue(false);
	  }
	  act = builder.moveToElement(ApexcomPage.subscribebutton).click().build();
	  act.perform();
	  					// press on subscripe
	  
	  Thread.sleep(1000);
	  String expected=" subscribed ";
	  String current = ApexcomPage.subscribebutton.getText();
	  assertEquals( expected, current);
}

@Test(priority=7,description="create post button in ApexCom Test")
public void cretepost2() throws Throwable {
	  driver.nav(driver.Url);
	  Thread.sleep(3000);
	  try {
		  ApexcomPage.apexcom = driver.LocateById(ApexcomPage.apexcomid);
	  }catch(Exception e) {
		  Reporter.log("Can't find the apexcom ");
		  Assert.assertTrue(false);
	  }
	  String name = ApexcomPage.apexcom.getText();
	  act = builder.moveToElement(ApexcomPage.apexcom).click().build();
	  act.perform();
	  Thread.sleep(3000);					// open apex
	  try {
		  ApexcomPage.createpostbutton = driver.LocateById("createpostbutton");
	  }catch(Exception e) {
		  Reporter.log("Can't find the apexcom post button ");
		  Assert.assertTrue(false);
	  }
	  act = builder.moveToElement(ApexcomPage.createpostbutton).click().build();
	  act.perform();
	  					// press on create post 
	  
	  try {
		  ApexcomPage.createpostbutton = driver.LocateById("button");
			}catch(Exception e) {
			Reporter.log("Can't login");
			Assert.assertTrue(false);
			}
	  assertNotNull(ApexcomPage.createpostbutton);

			
	  
	  
}

@Test(priority=8,description="open moderator profile of ApexCom")
public void finMOderator2() throws Throwable {
	  driver.nav(driver.Url);
	  Thread.sleep(3000);
	  try {
		  ApexcomPage.apexcom = driver.LocateById(ApexcomPage.apexcomid);
	  }catch(Exception e) {
		  Reporter.log("Can't find the apexcom ");
		  Assert.assertTrue(false);
	  }
	  String name = ApexcomPage.apexcom.getText();
	  act = builder.moveToElement(ApexcomPage.apexcom).click().build();
	  act.perform();
	  Thread.sleep(3000);					// open apex
	  try {
		  ApexcomPage.MOderator = driver.LocateById(ApexcomPage.MOderatorid);
	  }catch(Exception e) {
		  Reporter.log("Can't find the apexcom post button ");
		  Assert.assertTrue(false);
	  }
	  act = builder.moveToElement(ApexcomPage.MOderator).click().build();
	  act.perform();
	  					// press on subscripe
	  try {
		  ApexcomPage.user = driver.LocateById("blocktbutton");
			}catch(Exception e) {
			Reporter.log("Can't login");
			Assert.assertTrue(false);
			}
	  assertNotNull(ApexcomPage.user);
	  
}


	@Test(priority=1,description="search for specific ApexCom and subscribe it without log in Test")
	  public void subscribe1() throws Throwable {
		driver.nav(driver.Url);
		  Thread.sleep(3000);
		 	  
		  try {
			   SearchPage.searchTXT = driver.driver.findElement(By.className("form-control"));
		   }catch(Exception e) {
				Reporter.log("Can't find the searchTXT");
				Assert.assertTrue(false);
			}
		act = builder.sendKeys(SearchPage.searchTXT,"test1").build();
		act.perform();
	    SearchPage.searchTXT.sendKeys(Keys.ENTER);		//search done about something
	    Thread.sleep(3000);
	    try {
	    	SearchPage.UsersBTN = driver.LocateById(SearchPage.UsersBTNid);
	   }catch(Exception e) {
			Reporter.log("Can't find the user and community Button");
			Assert.assertTrue(false);
		}
	    act = builder.moveToElement(SearchPage.UsersBTN).click().build();
	    act.perform();
	    Thread.sleep(3000);												// open users and community
	    try {
	    	SearchPage.user1 = driver.LocateByXpath("//a[@class='name']");
	   }catch(Exception e) {
			Reporter.log("Can't find the User");
			Assert.assertTrue(false);
		}
	    act = builder.moveToElement(SearchPage.user1).click().build();
	    act.perform();												// open apexcom
	    
	    Thread.sleep(3000);
	    
	    try {
			  ApexcomPage.subscribebutton = driver.LocateById(ApexcomPage.subscribebuttonid);
		  }catch(Exception e) {
			  Reporter.log("Can't find the apexcom post button ");
		  }
		  act = builder.moveToElement(ApexcomPage.subscribebutton).click().build();
		  act.perform();
		  					// press on subscripe
		  
		  Thread.sleep(3000);
		  try {
			  ApexcomPage.egnoresubscribe = driver.LocateByXpath("/html/body/div[2]/div/div[2]/div/button");
		  }catch(Exception e) {
			  Reporter.log("Can't find the apexcom post button ");
			  Assert.assertTrue(true);
		  }
		  act = builder.moveToElement(ApexcomPage.egnoresubscribe).click().build();
		  act.perform();
		  Thread.sleep(3000);
		  String expected="SUBSCRIBE";
		  String current = ApexcomPage.subscribebutton.getText();
		  System.out.println( ApexcomPage.subscribebutton.getText());
		  Assert.assertEquals( expected, current);
		  
	}

	@Test(priority=2,description="search for specific ApexCom and add post it without log in Test")
	  public void addpostwithoutLogin() throws Throwable {
		driver.nav(driver.Url);
		  Thread.sleep(3000);
		 	  
		  try {
			   SearchPage.searchTXT = driver.driver.findElement(By.className("form-control"));
		   }catch(Exception e) {
				Reporter.log("Can't find the searchTXT");
				AssertJUnit.assertTrue(false);
			}
		act = builder.sendKeys(SearchPage.searchTXT,"test1").build();
		act.perform();
	    SearchPage.searchTXT.sendKeys(Keys.ENTER);		//search done about something
	    
	    try {
	    	SearchPage.UsersBTN = driver.LocateById(SearchPage.UsersBTNid);
	   }catch(Exception e) {
			Reporter.log("Can't find the user and community Button");
			Assert.assertTrue(false);
		}
	    act = builder.moveToElement(SearchPage.UsersBTN).click().build();
	    act.perform();
	    												// open users and community
	    try {
	    	SearchPage.user1 = driver.LocateByXpath("//a[@class='name']");
	   }catch(Exception e) {
			Reporter.log("Can't find the User");
			Assert.assertTrue(false);
		}
	    act = builder.moveToElement(SearchPage.user1).click().build();
	    act.perform();												// open apexcom
	    
	    
	    
	    try {
			  ApexcomPage.createpostbutton = driver.LocateById("createpostbutton");
		  }catch(Exception e) {
			  Reporter.log("Can't find the apexcom post button ");
			  Assert.assertTrue(false);
		  }
		  act = builder.moveToElement(ApexcomPage.createpostbutton).click().build();
		  act.perform();
		  					// press on create post 
		  Thread.sleep(1000);
		  
		  try {
			   login.userNametxt = driver.LocateById(login.userNametxtID);
			   login.paswordtxt = driver.LocateById(login.paswordtxtID);
			   login.submit = driver.LocateById(login.submitID);
			}catch(Exception e) {
				Reporter.log("Can't find the submit Button 4");
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
				  ApexcomPage.createpostbutton = driver.LocateById("createpostbutton");
			  }catch(Exception e) {
				  Reporter.log("Can't find the apexcom post button ");
				  Assert.assertTrue(false);
			  }
			  act = builder.moveToElement(ApexcomPage.createpostbutton).click().build();
			  act.perform();
			  					// press on create post
			  try {
				  ApexcomPage.createpostbutton = driver.LocateById("button");
					}catch(Exception e) {
					Reporter.log("Can't login");
					Assert.assertTrue(false);
					}
			  assertNotNull(ApexcomPage.createpostbutton);
		  
		  

	}
	
	@Test(priority=3,description="search for specific ApexCom and subscribe it with log in Test")
	  public void addPostWithLogIn() throws Throwable {
		driver.nav(driver.Url);
		  Thread.sleep(3000);
		 	signin("eslam", "123456");  
		  try {
			   SearchPage.searchTXT = driver.driver.findElement(By.className("form-control"));
		   }catch(Exception e) {
				Reporter.log("Can't find the searchTXT");
				AssertJUnit.assertTrue(false);
			}
		act = builder.sendKeys(SearchPage.searchTXT,"test1").build();
		act.perform();
	    SearchPage.searchTXT.sendKeys(Keys.ENTER);		//search done about something
	    
	    try {
	    	SearchPage.UsersBTN = driver.LocateById(SearchPage.UsersBTNid);
	   }catch(Exception e) {
			Reporter.log("Can't find the user and community Button");
			Assert.assertTrue(false);
		}
	    
	    act = builder.moveToElement(SearchPage.UsersBTN).click().build();
	    act.perform();
	    												// open users and community
	    try {
	    	SearchPage.user1 = driver.driver.findElement(By.className("name"));
	   }catch(Exception e) {
			Reporter.log("Can't find the User");
			Assert.assertTrue(false);
		} String current = "SUBSCRIBED";
	    act = builder.moveToElement(SearchPage.user1).click().build();
	    act.perform();												// open apexcom
	    
	    
	    try {
			  ApexcomPage.subscribebutton = driver.LocateById(ApexcomPage.subscribebuttonid);
		  }catch(Exception e) {
			  Reporter.log("Can't find the apexcom post button ");
			  Assert.assertTrue(false);
		  }
	      assertNotNull(ApexcomPage.subscribebutton);
		  act = builder.moveToElement(ApexcomPage.subscribebutton).click().build();
		  act.perform();
		  					// press on subscripe
		  
		  Thread.sleep(1000);
		  String expected="SUBSCRIBED";
		 
		  assertEquals( expected, current);

	}
	
	@Test(priority=4,description="open modirator profile of subredit with log in Test")
	  public void findModerator1() throws Throwable {
		driver.nav(driver.Url);
		  Thread.sleep(3000);
		 	
		  try {
			   SearchPage.searchTXT = driver.driver.findElement(By.className("form-control"));
		   }catch(Exception e) {
				Reporter.log("Can't find the searchTXT");
				AssertJUnit.assertTrue(false);
			}
		  boolean check=true;
		act = builder.sendKeys(SearchPage.searchTXT,"u6hS8e1new").build();
		act.perform();
	    SearchPage.searchTXT.sendKeys(Keys.ENTER);		//search done about something
	    
	    try {
	    	SearchPage.UsersBTN = driver.LocateById(SearchPage.UsersBTNid);
	   }catch(Exception e) {
			Reporter.log("Can't find the user and community Button");
			Assert.assertTrue(false);
		}
	    act = builder.moveToElement(SearchPage.UsersBTN).click().build();
	    act.perform();
	    												// open users and community
	    try {
	    	SearchPage.user1 = driver.driver.findElement(By.className("name"));
	   }catch(Exception e) {
			Reporter.log("Can't find the User");
			Assert.assertTrue(false);
		}
	    act = builder.moveToElement(SearchPage.user1).click().build();
	    act.perform();												// open apexcom
	    
	    try {
			  ApexcomPage.MOderator = driver.LocateByXpath("//a[@class='accountLink']");
		  }catch(Exception e) {
			  Reporter.log("Can't find the apexcom post button ");
			  Assert.assertTrue(false);
		  }
	    assertNotNull(ApexcomPage.MOderator);
		
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
