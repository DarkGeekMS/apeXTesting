package TestingScript;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
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
		Reporter.log("Navigation test starts");
	}
	@AfterClass
	public void finalize()
	{
		Reporter.log("navigation test ends");
		chromeDriver.shutdown();
	}
	
	
	@Test (priority=1,description="Check that login Button don't change URL")
	public void login() throws InterruptedException 
	{
		chromeDriver.nav(chromeDriver.Url);
		Thread.sleep(3000);
		try {
			Navigations.signBtn = chromeDriver.LocateById(Navigations.signBtnID);
		}catch(Exception e) {
			Reporter.log("Can't find the signIn Button");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(Navigations.signBtn).click().build();
		act.perform();
		Thread.sleep(3000);
		String currentURL = chromeDriver.driver.getCurrentUrl();
		assertEquals(Navigations.HomeLink, currentURL);
	}
	@Test (priority=2,description="Check that signup Buton don't change URL")
	public void signup() throws InterruptedException 
	{
		chromeDriver.nav(chromeDriver.Url);
		Thread.sleep(3000);
		try {
			Navigations.SignUpButton = chromeDriver.LocateById(Navigations.SignUpButtonId);
		}catch(Exception e) {
			Reporter.log("Can't find the SignUpButton ");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(Navigations.SignUpButton).click().build();
		act.perform();
		Thread.sleep(1000);
		String currentURL = chromeDriver.driver.getCurrentUrl();
		assertEquals(Navigations.HomeLink, currentURL);
	}
	@Test (priority=3,description="Check that post don't change URL")
	public void postslink() throws InterruptedException 
	{
		chromeDriver.nav(chromeDriver.Url);
		Thread.sleep(3000);
		try {
			Navigations.postText = chromeDriver.LocateById(Navigations.postTextid);
		}catch(Exception e) {
			Reporter.log("Can't find the post ");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(Navigations.postText).click().build();
		act.perform();
		Thread.sleep(1000);
		String currentURL = chromeDriver.driver.getCurrentUrl();
		assertEquals(Navigations.HomeLink, currentURL);
	}
	@Test (priority=4,description="Check that correct navigation to apexcom")
	public void apexcomLink() throws InterruptedException 
	{
		chromeDriver.nav(chromeDriver.Url);
		Thread.sleep(3000);
		try {
			Navigations.apexcom = chromeDriver.LocateById(Navigations.apexcomid);
		}catch(Exception e) {
			Reporter.log("Can't find the apexcom ");
			Assert.assertTrue(false);
		}
		String name = Navigations.apexcom.getText();
		act = builder.moveToElement(Navigations.apexcom).click().build();
		act.perform();
		Thread.sleep(1000);
		String currentURL = chromeDriver.driver.getCurrentUrl();
		assertEquals(Navigations.apexcomLink + name, currentURL);
	}
	@Test (priority=5,description="Check that correct navigation to apexcom posts")
	public void apexcomposts() throws InterruptedException 
	{
		chromeDriver.nav(chromeDriver.Url);
		Thread.sleep(3000);
		try {
			Navigations.apexcom = chromeDriver.LocateById(Navigations.apexcomid);
		}catch(Exception e) {
			Reporter.log("Can't find the apexcom ");
			Assert.assertTrue(false);
		}
		String name = Navigations.apexcom.getText();
		act = builder.moveToElement(Navigations.apexcom).click().build();
		act.perform(); 
		Thread.sleep(1000);
		try {
			Navigations.apexcompost = chromeDriver.LocateById(Navigations.apexcompostid);
		}catch(Exception e) {
			Reporter.log("Can't find the apexcom post button ");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(Navigations.apexcompost).click().build();
		act.perform();
		Thread.sleep(1000);
		String currentURL = chromeDriver.driver.getCurrentUrl();
		String expected = Navigations.apexcomLink + name + "/ApexPosts";
		assertEquals(expected, currentURL);
	}
	@Test (priority=6,description="Check that correct navigation after logout")
	public void logout() throws InterruptedException 
	{
		chromeDriver.nav(chromeDriver.Url);
		Thread.sleep(3000);
		try {
			Navigations.signBtn = chromeDriver.LocateById(Navigations.signBtnID);
		}catch(Exception e) {
			Reporter.log("Can't find the signIn Button");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(Navigations.signBtn).click().build();
		act.perform();
		Thread.sleep(1000);
		try {
			Navigations.userNametxt = chromeDriver.LocateById(Navigations.userNametxtID);
			Navigations.paswordtxt = chromeDriver.LocateById(Navigations.paswordtxtID);
			Navigations.submit = chromeDriver.LocateById(Navigations.submitID);
		}catch(Exception e) {
			Reporter.log("Can't find the submit Button 4");
			Assert.assertTrue(false);
		}
		act = builder.sendKeys(Navigations.userNametxt,"King").build();
		act.perform();
		act = builder.sendKeys(Navigations.paswordtxt,"queen12").build();
		act.perform();
		act = builder.moveToElement(Navigations.submit).click().build();
		act.perform();
		Thread.sleep(1000);
		try {
			Navigations.logout = chromeDriver.LocateById(Navigations.logoutDivID);
		}catch(Exception e) {
			Reporter.log("Can't find loguot btn 5");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(Navigations.logout).click().build();
		act.perform();
		Thread.sleep(1000);
		try {
			Navigations.logoutButton = chromeDriver.LocateByXpath("//div[@id='loggedDiv']/ul/li[5]");
		}catch(Exception e) {
			Reporter.log("Can't find logout btn 5");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(Navigations.logoutButton).click().build();
		act.perform();
		Thread.sleep(1000);
		String currentURL = chromeDriver.driver.getCurrentUrl();
		assertEquals(Navigations.HomeLink, currentURL);
	 }	
	@Test (priority=7,description="Check that correct navigation to user")
	public void userLink() throws InterruptedException 
	{
		chromeDriver.nav(chromeDriver.Url);
		Thread.sleep(3000);
		try {
			Navigations.signBtn = chromeDriver.LocateById(Navigations.signBtnID);
		}catch(Exception e) {
			Reporter.log("Can't find the signIn Button");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(Navigations.signBtn).click().build();
		act.perform();
		Thread.sleep(1000);
		try {
			Navigations.userNametxt = chromeDriver.LocateById(Navigations.userNametxtID);
			Navigations.paswordtxt = chromeDriver.LocateById(Navigations.paswordtxtID);
			Navigations.submit = chromeDriver.LocateById(Navigations.submitID);
		}catch(Exception e) {
			Reporter.log("Can't find the submit Button 4");
			Assert.assertTrue(false);
		}
		act = builder.sendKeys(Navigations.userNametxt,"King").build();
		act.perform();
		act = builder.sendKeys(Navigations.paswordtxt,"queen12").build();
		act.perform();
		act = builder.moveToElement(Navigations.submit).click().build();
		act.perform();
		Thread.sleep(1000);
		try {
			Navigations.logout = chromeDriver.LocateById(Navigations.logoutDivID);
		}catch(Exception e) {
			Reporter.log("Can't find loguot btn 5");
			Assert.assertTrue(false);
		}
	  	act = builder.moveToElement(Navigations.logout).click().build();
		act.perform();
		Thread.sleep(1000);
		WebElement profile = null;
		try {
			profile = chromeDriver.LocateByXpath("//div[@id='loggedDiv']/ul/li[2]");
		}catch(Exception e) {
			Reporter.log("Can't locate profile Button");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(profile).click().build();
		act.perform();
		Thread.sleep(1000);
		String currentURL = chromeDriver.driver.getCurrentUrl();
		assertEquals(Navigations.UserProfileLink + "King", currentURL);
	}
	@Test (priority=8,description="Testing Fake profile")
	public void FakeProfile() throws InterruptedException 
	{
		String url = Navigations.UserProfileLink + "i'mGonnaTestYouToDeath";
		chromeDriver.nav(url);
		Thread.sleep(3000);
		Assert.assertNotEquals(chromeDriver.driver.getCurrentUrl(), url);
	 }	
	@Test (priority=9,description="Testing Fake ApexCom")
	public void FakeApex() throws InterruptedException 
	{
		String url = Navigations.apexcomLink + "i'mGonnaTestYouToDeath";
		chromeDriver.nav(url);
		Thread.sleep(3000);
		Assert.assertNotEquals(chromeDriver.driver.getCurrentUrl(), url);
	 }	
	
	@Test (priority=10,description="Clicking on Logo")
	public void logo() throws InterruptedException 
	{
		chromeDriver.nav(chromeDriver.Url);
		Thread.sleep(3000);
		WebElement logo = null;
		try {
			logo = chromeDriver.LocateByXpath("//a[@href='/HomePage']");
		}catch(Exception e) {
			Reporter.log("Can't find Logo");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(logo).click().build();
		act.perform();
		Thread.sleep(1000);
		Assert.assertEquals(chromeDriver.driver.getCurrentUrl(), chromeDriver.Url + "/HomePage");
	 }	
}
