package firefoxTestingScript;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import DriverDef.Firefox;
import PageModel.apexcomPage;

public class FFapexcom {
	 public Firefox FFD;
		public apexcomPage ApexcomPage;
		public Actions builder;
		public org.openqa.selenium.interactions.Action act;


		@BeforeClass
	  public void BeforeClass()
		{
			FFD = new Firefox();
			ApexcomPage = new apexcomPage();
			builder = new Actions(FFD.driver);
			Reporter.log("apexcom test starts");
		}
		@AfterClass
		public void finalize()
		{
			Reporter.log("apexcom test ends");
			FFD.shutdown();
		}
		
	  @Test(description="Openning Certain ApexCom")
	  public void f() throws Throwable {
		  FFD.nav(FFD.Url);
		  Thread.sleep(3000);
		  try {
			  ApexcomPage.apexcom = FFD.LocateById(ApexcomPage.apexcomid);
		  }catch(Exception e) {
			  Reporter.log("Can't find the apexcom ");
			  Assert.assertTrue(false);
		  }
		  String name = ApexcomPage.apexcom.getText();
		  act = builder.moveToElement(ApexcomPage.apexcom).click().build();
		  act.perform();
		  Thread.sleep(3000);
		  try {
			  ApexcomPage.apexcompost = FFD.LocateById(ApexcomPage.apexcompostid);
		  }catch(Exception e) {
			  Reporter.log("Can't find the apexcom post button ");
			  Assert.assertTrue(false);
		  }
		  act = builder.moveToElement(ApexcomPage.apexcompost).click().build();
		  act.perform();
		  Thread.sleep(3000);
		  try {
			  ApexcomPage.posttitle = FFD.LocateById(ApexcomPage.posttitleid);
		  }catch(Exception e) {
			  Reporter.log("Can't find the apexcom post title ");
			  Assert.assertTrue(false);
		  }
		  Thread.sleep(1000);
		  String expected=FFD.Url + "/ApexCom/" + name + "/ApexPosts";
		  String current = FFD.driver.getCurrentUrl();
		  assertEquals( expected, current);
	  }
}
