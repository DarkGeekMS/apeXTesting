package TestingScript;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
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
		Reporter.log("apexcom test starts");
	}
	@AfterClass
	public void finalize()
	{
		Reporter.log("apexcom test ends");
		chromeDriver.shutdown();
	}
	
  @Test(description="Openning Certain ApexCom")
  public void f() throws Throwable {
	  chromeDriver.nav(chromeDriver.Url);
	  Thread.sleep(3000);
	  try {
		  ApexcomPage.apexcom = chromeDriver.LocateById(ApexcomPage.apexcomid);
	  }catch(Exception e) {
		  Reporter.log("Can't find the apexcom ");
		  Assert.assertTrue(false);
	  }
	  String name = ApexcomPage.apexcom.getText();
	  act = builder.moveToElement(ApexcomPage.apexcom).click().build();
	  act.perform();
	  Thread.sleep(3000);
	  try {
		  ApexcomPage.apexcompost = chromeDriver.LocateById(ApexcomPage.apexcompostid);
	  }catch(Exception e) {
		  Reporter.log("Can't find the apexcom post button ");
		  Assert.assertTrue(false);
	  }
	  act = builder.moveToElement(ApexcomPage.apexcompost).click().build();
	  act.perform();
	  Thread.sleep(3000);
	  try {
		  ApexcomPage.posttitle = chromeDriver.LocateById(ApexcomPage.posttitleid);
	  }catch(Exception e) {
		  Reporter.log("Can't find the apexcom post title ");
		  Assert.assertTrue(false);
	  }
	  Thread.sleep(1000);
	  String expected=chromeDriver.Url + "/ApexCom/" + name + "/ApexPosts";
	  String current = chromeDriver.driver.getCurrentUrl();
	  assertEquals( expected, current);
  }
}
