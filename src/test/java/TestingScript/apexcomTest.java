package TestingScript;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import DriverDef.Chrome;
import PageModel.apexcomPage;

public class apexcomTest {
  
  public Chrome chromeDriver;
	public apexcomPage ApexcomPage;
	public Actions builder;
	public org.openqa.selenium.interactions.Action act;


	@BeforeClass
  public void BeforeClass()
	{
		chromeDriver = new Chrome();
		ApexcomPage = new apexcomPage();
		builder = new Actions(chromeDriver.driver);
		System.out.println("Sign up test starts");
	}
	@AfterClass
	public void finalize()
	{
		System.out.println("Sign up test ends");
		chromeDriver.shutdown();
	}
	
@Test
  public void f() throws Throwable {
	chromeDriver.nav("http://localhost:8080/");
	try {
		ApexcomPage.apexcom = chromeDriver.LocateById(ApexcomPage.apexcomid);
		}catch(Exception e) {
			System.out.println("Can't find the apexcom ");
			Assert.assertTrue(false);
		}

	   act = builder.moveToElement(ApexcomPage.apexcom).click().build();
	   act.perform();
	   
	   try {
		   ApexcomPage.apexcompost = chromeDriver.LocateById(ApexcomPage.apexcompostid);
		}catch(Exception e) {
			System.out.println("Can't find the apexcom post button ");
			Assert.assertTrue(false);
		}

	   act = builder.moveToElement(ApexcomPage.apexcompost).click().build();
	   act.perform();
	   try {
		   ApexcomPage.posttitle = chromeDriver.LocateById(ApexcomPage.posttitleid);
		}catch(Exception e) {
			System.out.println("Can't find the apexcom post title ");
			Assert.assertTrue(false);
		}
	   Thread.sleep(1000);
	   String ecpected = "http://localhost:8080/ApexCom/555/ApexPosts";
	   String current = chromeDriver.driver.getCurrentUrl();
	   assertEquals( ecpected, current);
	  
  }

}
