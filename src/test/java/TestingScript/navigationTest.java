package TestingScript;

import static org.testng.Assert.assertEquals;



import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import DriverDef.Chrome;
import PageModel.LoginPage;
import PageModel.navigation;


public class navigationTest {
	
	public Chrome driver;
	public navigation Navigations;
	public Actions builder;
	public LoginPage login;
	public org.openqa.selenium.interactions.Action act;


	void signin(String name,String pass) throws InterruptedException {
		try {
	  		login.signBtn = driver.LocateById(login.signBtnID);
		}catch(Exception e) {
			logout();
		}
		try {
	  		login.signBtn = driver.LocateById(login.signBtnID);
		}catch(Exception e) {
			Reporter.log("Can't find the signIn Button");
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
			Reporter.log("Can't find the submit Button ");
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
			Reporter.log("Can't find logout btn 5");
			Assert.assertTrue(false);
		}
	  	act = builder.moveToElement(login.logout).click().build();
		act.perform();
		Thread.sleep(5000);
		try {
			login.logoutButton = driver.LocateByXpath("//*[@id='loggedbutton']//following-sibling::ul/li[5]");
		}catch(Exception e) {
			Reporter.log("Can't find logout btn 5");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(login.logoutButton).click().build();
		act.perform();
		Thread.sleep(5000);
	}
	
	@BeforeClass
	public void BeforeClass()
	{
		driver = new Chrome();
		Navigations = new navigation();
		builder = new Actions(driver.driver);
		login = new LoginPage();
		Reporter.log("Navigation test starts");
	}
	
	@AfterClass
	public void finalize()
	{
		Reporter.log("navigation test ends");
		driver.shutdown();
	}
	
	
	@Test (priority=1,description="Check that login Button doesn't change URL")
	public void login() throws InterruptedException 
	{
		driver.nav(driver.Url);
		Thread.sleep(3000);
		try {
			Navigations.signBtn = driver.LocateById(Navigations.signBtnID);
		}catch(Exception e) {
			Reporter.log("Can't find the signIn Button");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(Navigations.signBtn).click().build();
		act.perform();
		Thread.sleep(3000);
		String currentURL = driver.driver.getCurrentUrl();
		assertEquals(currentURL,Navigations.HomeLink);
		Assert.assertNotEquals(driver.driver.getTitle(), "Not Found");
	}
	@Test (priority=2,description="Check that signup Button doesn't change URL")
	public void signup() throws InterruptedException 
	{
		driver.nav(driver.Url);
		Thread.sleep(3000);
		try {
			Navigations.SignUpButton = driver.LocateById(Navigations.SignUpButtonId);
		}catch(Exception e) {
			Reporter.log("Can't find the SignUpButton ");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(Navigations.SignUpButton).click().build();
		act.perform();
		Thread.sleep(1000);
		String currentURL = driver.driver.getCurrentUrl();
		assertEquals(currentURL,Navigations.HomeLink);
		Assert.assertNotEquals(driver.driver.getTitle(), "Not Found");

	}
	
	@Test (priority=3,description="Check navigation to apexcom")
	public void apexcomLink() throws InterruptedException 
	{
		driver.nav(driver.Url);
		Thread.sleep(3000);
		try {
			Navigations.apexcom = driver.LocateById(Navigations.apexcomid);
		}catch(Exception e) {
			Reporter.log("Can't find the apexcom ");
			Assert.assertTrue(false);
		}
		String name = Navigations.apexcom.getText();
		act = builder.moveToElement(Navigations.apexcom).click().build();
		act.perform();
		Thread.sleep(1000);
		String currentURL = driver.driver.getCurrentUrl();
		assertEquals(currentURL,Navigations.apexcomLink + name);
		Assert.assertNotEquals(driver.driver.getTitle(), "Not Found");

	}
	@Test (priority=4,description="Check navigation to apexcom posts")
	public void apexcomposts() throws InterruptedException 
	{
		driver.nav(driver.Url);
		Thread.sleep(3000);
		try {
			Navigations.apexcom = driver.LocateById(Navigations.apexcomid);
		}catch(Exception e) {
			Reporter.log("Can't find the apexcom ");
			Assert.assertTrue(false);
		}
		String name = Navigations.apexcom.getText();
		act = builder.moveToElement(Navigations.apexcom).click().build();
		act.perform(); 
		Thread.sleep(3000);
		try {
			Navigations.apexcompost = driver.LocateById(Navigations.apexcompostid);
		}catch(Exception e) {
			Reporter.log("Can't find the apexcom post button ");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(Navigations.apexcompost).click().build();
		act.perform();
		Thread.sleep(3000);
		String currentURL = driver.driver.getCurrentUrl();
		String expected = Navigations.apexcomLink + name + "/ApexPosts";
		assertEquals(currentURL,expected);
		Assert.assertNotEquals(driver.driver.getTitle(), "Not Found");

	}
	@Test (priority=5,description="Check navigation after logout")
	public void logoutTest() throws InterruptedException 
	{
		driver.nav(driver.Url);
		Thread.sleep(3000);
		signin("hell12","hell12");
		logout();
		String currentURL = driver.driver.getCurrentUrl();
		assertEquals(currentURL,Navigations.HomeLink);
		Assert.assertNotEquals(driver.driver.getTitle(), "Not Found");

	 }	
	@Test (priority=6,description="Check navigation to user")
	public void userLink() throws InterruptedException 
	{
		driver.nav(driver.Url);
		Thread.sleep(3000);
		signin("hell12","hell12");
		try {
			Navigations.logout = driver.LocateById(Navigations.logoutDivID);
		}catch(Exception e) {
			Reporter.log("Can't find logout btn");
			Assert.assertTrue(false);
		}
	  	act = builder.moveToElement(Navigations.logout).click().build();
		act.perform();
		Thread.sleep(1000);
		WebElement profile = null;
		try {
			profile = driver.LocateByXpath("//*[@id='loggedbutton']//following-sibling::ul/li[2]");
		}catch(Exception e) {
			Reporter.log("Can't locate profile Button");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(profile).click().build();
		act.perform();
		Thread.sleep(1000);
		String currentURL = driver.driver.getCurrentUrl();
		assertEquals(currentURL,Navigations.UserProfileLink + "hell12");
		Assert.assertNotEquals(driver.driver.getTitle(), "Not Found");
	}
	@Test (priority=7,description="Check navigation to userSettings")
	public void usersettings() throws InterruptedException 
	{
		driver.nav(driver.Url);
		Thread.sleep(3000);
		signin("hell12","hell12");
		try {
			Navigations.logout = driver.LocateById(Navigations.logoutDivID);
		}catch(Exception e) {
			Reporter.log("Can't find logout btn");
			Assert.assertTrue(false);
		}
	  	act = builder.moveToElement(Navigations.logout).click().build();
		act.perform();
		Thread.sleep(1000);
		WebElement set = null;
		try {
			set = driver.LocateByXpath("//*[@id='loggedbutton']//following-sibling::ul/li[3]");
		}catch(Exception e) {
			Reporter.log("Can't locate Settings Button");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(set).click().build();
		act.perform();
		Thread.sleep(1000);
		String currentURL = driver.driver.getCurrentUrl();
		assertEquals(currentURL,Navigations.userSettingsLink + "hell12");
		Assert.assertNotEquals(driver.driver.getTitle(), "Not Found");
	}
	@Test (priority=8,description="Testing Fake profile")
	public void FakeProfile() throws InterruptedException 
	{
		String url = Navigations.UserProfileLink + "i'mGonnaTestYouToDeath";
		driver.nav(url);
		Thread.sleep(3000);
		Assert.assertEquals(driver.driver.getCurrentUrl(), url);
		Assert.assertEquals(driver.driver.getTitle(), "Not Found");
	 }	
	@Test (priority=9,description="Testing Fake ApexCom")
	public void FakeApex() throws InterruptedException 
	{
		String url = Navigations.apexcomLink + "i'mGonnaTestYouToDeath";
		driver.nav(url);
		Thread.sleep(3000);
		Assert.assertEquals(driver.driver.getCurrentUrl(), url);
		Assert.assertEquals(driver.driver.getTitle(), "Not Found");
	 }	
	
	@Test (priority=10,description="Clicking on Logo")
	public void logo() throws InterruptedException 
	{
		driver.nav(driver.Url);
		Thread.sleep(3000);
		WebElement logo = null;
		try {
			logo = driver.LocateByXpath("//a[@href='/HomePage/New']");
		}catch(Exception e) {
			Reporter.log("Can't find Logo");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(logo).click().build();
		act.perform();
		Thread.sleep(1000);
		Assert.assertEquals(driver.driver.getCurrentUrl(), driver.Url + "HomePage/New");
		Assert.assertNotEquals(driver.driver.getTitle(), "Not Found");
	}	
	
	@Test (priority=11,description="Press on popular Button")
	public void popularButton() throws InterruptedException 
	{
		driver.nav(driver.Url);
		Thread.sleep(3000);
		signin("hell12","hell12");
		try {
			Navigations.pop = driver.LocateByXpath(Navigations.popPath);
		}catch(Exception e) {
			Reporter.log("Can't find popular icon");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(Navigations.pop).click().build();
		act.perform();
		Thread.sleep(3000);
		String currentURL = driver.driver.getCurrentUrl();
		assertEquals(currentURL,Navigations.HomeLink + "HomePage/Hot");
		Assert.assertNotEquals(driver.driver.getTitle(), "Not Found");
	}
	@Test (priority=12,description="Press on All posts Button")
	public void allButton() throws InterruptedException 
	{
		driver.nav(driver.Url);
		Thread.sleep(3000);
		signin("hell12","hell12");
		try {
			Navigations.all = driver.LocateByXpath(Navigations.allPath);
		}catch(Exception e) {
			Reporter.log("Can't find all icon");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(Navigations.all).click().build();
		act.perform();
		Thread.sleep(3000);
		String currentURL = driver.driver.getCurrentUrl();
		assertEquals(currentURL,Navigations.HomeLink + "HomePage/New");
		Assert.assertNotEquals(driver.driver.getTitle(), "Not Found");
	}
	@Test (priority=13,description="Press on original content's Button")
	public void originButton() throws InterruptedException 
	{
		driver.nav(driver.Url);
		Thread.sleep(3000);
		signin("hell12","hell12");
		try {
			Navigations.origin = driver.LocateByXpath(Navigations.originPath);
		}catch(Exception e) {
			Reporter.log("Can't find original content's icon");
			Assert.assertTrue(false);
		}
		String temp = driver.driver.getCurrentUrl();
		act = builder.moveToElement(Navigations.origin).click().build();
		act.perform();
		Thread.sleep(3000);
		String currentURL = driver.driver.getCurrentUrl();
		Assert.assertNotEquals(currentURL,temp);
		Assert.assertNotEquals(driver.driver.getTitle(), "Not Found");
	}
	@Test (priority=14,description="Press on message Button")
	public void messageButton() throws InterruptedException 
	{
		driver.nav(driver.Url);
		Thread.sleep(3000);
		signin("hell12","hell12");
		try {
			Navigations.msg = driver.LocateByXpath(Navigations.msgPath);
		}catch(Exception e) {
			Reporter.log("Can't find Message's icon");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(Navigations.msg).click().build();
		act.perform();
		Thread.sleep(3000);
		String currentURL = driver.driver.getCurrentUrl();
		Assert.assertEquals(currentURL,Navigations.HomeLink + "Messages");
		Assert.assertNotEquals(driver.driver.getTitle(), "Not Found");
	}
	@Test (priority=15,description="Press on create post's Button")
	public void postButton() throws InterruptedException 
	{
		driver.nav(driver.Url);
		Thread.sleep(3000);
		signin("hell12","hell12");
		try {
			Navigations.post = driver.LocateByXpath(Navigations.postPath);
		}catch(Exception e) {
			Reporter.log("Can't find post's icon");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(Navigations.post).click().build();
		act.perform();
		Thread.sleep(3000);
		String currentURL = driver.driver.getCurrentUrl();
		Assert.assertEquals(currentURL,Navigations.HomeLink + "Submit");
		Assert.assertNotEquals(driver.driver.getTitle(), "Not Found");
	}
	@Test (priority=16,description="Check post's navigation list")
	public void checkList() throws InterruptedException 
	{
		driver.nav(driver.Url);
		Thread.sleep(3000);
		signin("hell12","hell12");
		WebElement element=null;
		try {
			driver.LocateByXpath(Navigations.ListButton).click();
		}catch(Exception e) {
			Reporter.log("Can't find List icon");
			Assert.assertTrue(false);
		}
		Thread.sleep(3000);
		try {
			element = driver.LocateByXpath(Navigations.listPath + "/li[2]"); //popular
		}catch(Exception e) {
			Reporter.log("Can't find List item icon");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(element).click().build();
		act.perform();
		Thread.sleep(3000);
		String currentURL = driver.driver.getCurrentUrl();
		assertEquals(currentURL,Navigations.HomeLink + "HomePage/Hot");
		Assert.assertNotEquals(driver.driver.getTitle(), "Not Found");
		Reporter.log("popular Button's test passed");
		driver.nav(driver.Url);
		Thread.sleep(3000);
		try {
			driver.LocateByXpath(Navigations.ListButton).click();
		}catch(Exception e) {
			Reporter.log("Can't find List item icon");
			Assert.assertTrue(false);
		}
		Thread.sleep(3000);
		try {
			element = driver.LocateByXpath(Navigations.listPath + "/li[3]"); //All
		}catch(Exception e) {
			Reporter.log("Can't find List item icon");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(element).click().build();
		act.perform();
		Thread.sleep(3000);
		currentURL = driver.driver.getCurrentUrl();
		assertEquals(currentURL,Navigations.HomeLink + "HomePage/New");
		Assert.assertNotEquals(driver.driver.getTitle(), "Not Found");
		Reporter.log("All Button's test passed");
		driver.nav(driver.Url);
		Thread.sleep(3000);
		try {
			driver.LocateByXpath(Navigations.ListButton).click();
		}catch(Exception e) {
			Reporter.log("Can't find List item icon");
			Assert.assertTrue(false);
		}
		String temp = driver.driver.getCurrentUrl();
		Thread.sleep(3000);
		try {
			element = driver.LocateByXpath(Navigations.listPath + "/li[4]"); //original content
		}catch(Exception e) {
			Reporter.log("Can't find List item icon");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(element).click().build();
		act.perform();
		Thread.sleep(3000);
		currentURL = driver.driver.getCurrentUrl();
		Assert.assertNotEquals(currentURL,temp);
		Assert.assertNotEquals(driver.driver.getTitle(), "Not Found");
		Reporter.log("original content Button's test passed");
		driver.nav(driver.Url);
		Thread.sleep(3000);
		try {
			driver.LocateByXpath(Navigations.ListButton).click();
		}catch(Exception e) {
			Reporter.log("Can't find List item icon");
			Assert.assertTrue(false);
		}
		Thread.sleep(3000);
		try {
			element = driver.LocateByXpath(Navigations.listPath + "/li[1]"); //Home
		}catch(Exception e) {
			Reporter.log("Can't find List item icon");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(element).click().build();
		act.perform();
		Thread.sleep(3000);
		currentURL = driver.driver.getCurrentUrl();
		Assert.assertEquals(currentURL,Navigations.HomeLink);
		Assert.assertNotEquals(driver.driver.getTitle(), "Not Found");
		Reporter.log("Home Button's test passed");
	}
	
	@Test (priority=17,description="Check sort list")
	public void sortList() throws InterruptedException 
	{
		driver.nav(driver.Url);
		Thread.sleep(3000);
		signin("hell12","hell12");
		WebElement element=null;
		try {
			driver.LocateByXpath(Navigations.sortButton).click();
		}catch(Exception e) {
			Reporter.log("Can't find List icon");
			Assert.assertTrue(false);
		}
		Thread.sleep(3000);
		try {
			element = driver.LocateByXpath(Navigations.sortList + "/li[1]"); //Hot
		}catch(Exception e) {
			Reporter.log("Can't find List item icon");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(element).click().build();
		act.perform();
		Thread.sleep(3000);
		String currentURL = driver.driver.getCurrentUrl();
		assertEquals(currentURL,Navigations.HomeLink + "HomePage/Hot");
		Assert.assertNotEquals(driver.driver.getTitle(), "Not Found");
		Reporter.log("Hot Button's test passed");
		driver.nav(driver.Url);
		Thread.sleep(3000);
		try {
			driver.LocateByXpath(Navigations.sortButton).click();
		}catch(Exception e) {
			Reporter.log("Can't find List icon");
			Assert.assertTrue(false);
		}
		Thread.sleep(3000);
		try {
			element = driver.LocateByXpath(Navigations.sortList + "/li[5]"); //New
		}catch(Exception e) {
			Reporter.log("Can't find List item icon");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(element).click().build();
		act.perform();
		Thread.sleep(3000);
		currentURL = driver.driver.getCurrentUrl();
		assertEquals(currentURL,Navigations.HomeLink + "HomePage/New");
		Assert.assertNotEquals(driver.driver.getTitle(), "Not Found");
		Reporter.log("New Button's test passed");
		driver.nav(driver.Url);
		Thread.sleep(3000);
		try {
			driver.LocateByXpath(Navigations.sortButton).click();
		}catch(Exception e) {
			Reporter.log("Can't find List icon");
			Assert.assertTrue(false);
		}
		Thread.sleep(3000);
		try {
			element = driver.LocateByXpath(Navigations.sortList + "/li[9]"); //Controversial
		}catch(Exception e) {
			Reporter.log("Can't find List item icon");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(element).click().build();
		act.perform();
		Thread.sleep(3000);
		currentURL = driver.driver.getCurrentUrl();
		assertEquals(currentURL,Navigations.HomeLink + "HomePage/Controversial");
		Assert.assertNotEquals(driver.driver.getTitle(), "Not Found");
		Reporter.log("Controversial Button's test passed");
		driver.nav(driver.Url);
		Thread.sleep(3000);
		try {
			driver.LocateByXpath(Navigations.sortButton).click();
		}catch(Exception e) {
			Reporter.log("Can't find List icon");
			Assert.assertTrue(false);
		}
		Thread.sleep(3000);
		try {
			element = driver.LocateByXpath(Navigations.sortList + "/li[13]"); //Top
		}catch(Exception e) {
			Reporter.log("Can't find List item icon");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(element).click().build();
		act.perform();
		Thread.sleep(3000);
		currentURL = driver.driver.getCurrentUrl();
		Assert.assertEquals(currentURL,Navigations.HomeLink+ "HomePage/Top");
		Assert.assertNotEquals(driver.driver.getTitle(), "Not Found");
		Reporter.log("Top Button's test passed");
		driver.nav(driver.Url);
		Thread.sleep(3000);
		try {
			driver.LocateByXpath(Navigations.sortButton).click();
		}catch(Exception e) {
			Reporter.log("Can't find List icon");
			Assert.assertTrue(false);
		}
		Thread.sleep(3000);
		try {
			element = driver.LocateByXpath(Navigations.sortList + "/li[17]"); //Rising
		}catch(Exception e) {
			Reporter.log("Can't find List item icon");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(element).click().build();
		act.perform();
		Thread.sleep(3000);
		currentURL = driver.driver.getCurrentUrl();
		Assert.assertEquals(currentURL,Navigations.HomeLink+ "HomePage/Rising");
		Assert.assertNotEquals(driver.driver.getTitle(), "Not Found");
		Reporter.log("Rising Button's test passed");
	}
	
	@Test (priority=18,description="ApexCom Creation")
	public void CreateApexCom() throws InterruptedException 
	{
		driver.nav(driver.Url);
		Thread.sleep(3000);
		signin("hell12","hell12");	//ordinary user
		WebElement Button = null;
		try {
			Button = driver.LocateByXpath("//*[@id='Communtitii']");
		}catch(Exception e) {
			Reporter.log("can't  find Creation Button");
		}
		act = builder.moveToElement(Button).click().build();
		act.perform();
		Thread.sleep(3000);
		Assert.assertNotEquals(driver.driver.getCurrentUrl(), Navigations.HomeLink + "CreateApexCom");
		signin("adam81","monda21");	//admin
		try {
			Button = driver.LocateByXpath("//*[@id='Communtitii']");
		}catch(Exception e) {
			Reporter.log("can't  find Creation Button");
		}
		act = builder.moveToElement(Button).click().build();
		act.perform();
		Thread.sleep(3000);
		Assert.assertEquals(driver.driver.getCurrentUrl(), Navigations.HomeLink + "CreateApexCom");
	}
	
	@Test (priority=19,description="Check that post doesn't change URL")
	public void postslink() throws InterruptedException 
	{
		driver.nav(driver.Url);
		Thread.sleep(3000);
		try {
			Navigations.postText = driver.LocateById(Navigations.postTextid);
		}catch(Exception e) {
			Reporter.log("Can't find the post ");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(Navigations.postText).click().build();
		act.perform();
		Thread.sleep(1000);
		String currentURL = driver.driver.getCurrentUrl();
		assertEquals(currentURL,Navigations.HomeLink);
		Assert.assertNotEquals(driver.driver.getTitle(), "Not Found");
	}
	@Test (priority=20,description="Check Reloading")
	public void Reload() throws InterruptedException 
	{
		driver.nav(driver.Url);
		Thread.sleep(3000);
		signin("hell12","hell12");
		try {
			Navigations.logout = driver.LocateById(Navigations.logoutDivID);
		}catch(Exception e) {
			Reporter.log("Can't find logout btn");
			Assert.assertTrue(false);
		}
	  	act = builder.moveToElement(Navigations.logout).click().build();
		act.perform();
		Thread.sleep(1000);
		WebElement profile = null;
		try {
			profile = driver.LocateByXpath("//*[@id='loggedbutton']//following-sibling::ul/li[2]");
		}catch(Exception e) {
			Reporter.log("Can't locate profile Button");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(profile).click().build();
		act.perform();
		Thread.sleep(1000);
		String currentURL = driver.driver.getCurrentUrl();
		driver.driver.navigate().refresh();
		assertEquals(currentURL,Navigations.UserProfileLink + "hell12");
		Assert.assertNotEquals(driver.driver.getTitle(), "Not Found");
	}
	
}
