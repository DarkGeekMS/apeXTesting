package firefoxTestingScript;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import PageModel.LoginPage;
import PageModel.Message;
import DriverDef.Firefox;
public class FFmessegeTests {
	LoginPage login;
	Message msg;
	Firefox driver;
	public Actions builder;
	public Action act;
	
	void checkMsg(String to,String Sub,String text,WebElement elem,String Class,boolean ok) throws InterruptedException
	{
		WebElement To=null,Subject=null,Text=null;
		act = builder.moveToElement(elem).click().build();
		act.perform();
		Thread.sleep(5000);
		try {
			Subject = driver.LocateByXpath("//*[@id='app']//div[@class='"+Class+"'][1]//div[@class='container2']/p");
			To = driver.LocateByXpath("//*[@id='app']//div[@class='"+Class+"'][1]//div[@class='container2']//div[@class='sub']//div[@class='first-line']/a");
			Text = driver.LocateByXpath("//*[@id='app']//div[@class='"+Class+"'][1]//div[@class='container2']//div[@class='sub']//div[@class='second-line']");
		}catch(Exception e) {
			Reporter.log("Didn't find any" + Class);
			return;
		}
		if(!ok) {
			Assert.assertNotEquals(To.getText(), to);
			Assert.assertNotEquals(Subject.getText(), Sub+":");
			Assert.assertNotEquals(Text.getText(), text);
		}
		else
		{
			Assert.assertEquals(To.getText(), to);
			Assert.assertEquals(Subject.getText(), Sub+":");
			Assert.assertEquals(Text.getText(), text);
		}
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
	public void init()
	{
		driver = new Firefox();
		msg = new Message();
		login = new LoginPage();
		builder = new Actions(driver.driver);
		Reporter.log("Messages test starts");
	}
	@AfterClass
	public void finalize()
	{
		driver.shutdown();
		Reporter.log("Messages test ends");
	}
	
	@Test(priority=0,description="press on Messages Button without login")
	public void test1() throws InterruptedException{
		driver.nav(driver.Url);
		Thread.sleep(5000);
		try {
			msg.messageButton = driver.LocateByXpath(msg.messageButtonXPath);
		}catch(Exception e) {
			Reporter.log("Can't Find Message Button");
			Reporter.log("Test 1 passed");
			return;
		}
		Reporter.log("Found Message Button without login");
		Reporter.log("Test 1 Failed");
		Assert.assertTrue(false);
	}
	@Test(priority=1,description="press on Messages Button after login and check message key word in the current page's bar")
	public void test2() throws InterruptedException{
		driver.nav(driver.Url);
		Thread.sleep(5000);
		signin("hell1","hell12");
		try {
			msg.messageButton = driver.LocateByXpath(msg.messageButtonXPath);
		}catch(Exception e) {
			Reporter.log("Can't Find Message Button");
			Reporter.log("Test 2 failed");
			logout();
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(msg.messageButton).click().build();
		act.perform();
		Thread.sleep(5000);
		String expected = driver.Url + "/Messages";
		String Actual = driver.driver.getCurrentUrl();
		Assert.assertEquals(expected, Actual);
		try {
			msg.Span = driver.LocateById(msg.spanId);
		}catch(Exception e) {
			Reporter.log("can't find the span");
			logout();
			Assert.assertTrue(false);
		}
		Assert.assertEquals(msg.Span.getText(), "Messages");
		Reporter.log("Test 2 passed");
		logout();
	}
	
	@Test(priority=2,description="Test Inbox Button")
	public void test3() throws InterruptedException{
		driver.nav(driver.Url);
		Thread.sleep(5000);
		signin("hell1","hell12");
		try {
			msg.messageButton = driver.LocateByXpath(msg.messageButtonXPath);
		}catch(Exception e) {
			Reporter.log("Can't Find Message Button");
			logout();
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(msg.messageButton).click().build();
		act.perform();
		Thread.sleep(5000);
		try {
			msg.inboxButton = driver.LocateById(msg.inboxId);
		}catch(Exception e) {
			Reporter.log("can't find Inbox");
			logout();
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(msg.inboxButton).click().build();
		act.perform();
		Thread.sleep(5000);
		try {
			driver.LocateByXpath("//*[@id='app']/div[2]/div[2]");
		}catch(Exception e) {
			Reporter.log("inbox Bar is missed");
			Assert.assertTrue(false);
		}
		List<WebElement>list = driver.driver.findElements(By.className("allMessages"));
		for(int i=0;i<list.size();i++)
		{
			if(!(list.get(i).isDisplayed()))
			{
				logout();
				Assert.assertTrue(false);
			}
		}
		Reporter.log("Test 3 passed");
		logout();
	}
	
	@Test(priority=3,description="Send a message to my self")
	public void test4() throws InterruptedException {
		driver.nav(driver.Url);
		Thread.sleep(5000);
		signin("hell1","hell12");
		try {
			msg.messageButton = driver.LocateByXpath(msg.messageButtonXPath);
		}catch(Exception e) {
			Reporter.log("Can't Find Message Button");
			Reporter.log("Test 4 failed");
			logout();
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(msg.messageButton).click().build();
		act.perform();
		Thread.sleep(5000);
		try {
			msg.send = driver.LocateById(msg.sendId);
			msg.sentButton = driver.LocateById(msg.sentId);
			msg.inboxButton = driver.LocateById(msg.inboxId);
		}catch(Exception e) {
			Reporter.log("missing Buttons");
			Assert.assertTrue(false);
		}
		act=builder.moveToElement(msg.send).click().build();
		act.perform();
		Thread.sleep(5000);
		try {
			msg.to = driver.LocateByXpath(msg.toXPath);
			msg.subject = driver.LocateByXpath(msg.subjectXPath);
			msg.text = driver.LocateById(msg.textId);
			msg.sendButton = driver.LocateByXpath(msg.sendButtonXpath);
		}catch(Exception e) {
			Reporter.log("mising Elements");
			Assert.assertTrue(false);
		}
		String to = "hell1";
		String Sub = "Testing a message 0";
		String text = "test1";
		act = builder.sendKeys(msg.to, to).build();
		act.perform();
		act = builder.sendKeys(msg.subject, Sub).build();
		act.perform();
		act = builder.sendKeys(msg.text, text).build();
		act.perform();
		act = builder.moveToElement(msg.sendButton).click().build();
		act.perform();
		Thread.sleep(5000);
		WebElement alertMsg=null,alertButton=null;
		try {
			alertMsg = driver.LocateByXpath("/html/body/div[2]/div/div[1]");
			alertButton = driver.LocateByXpath("/html/body/div[2]/div/div[2]/div/button");
		}catch(Exception e) {
			Reporter.log("alert message didn't appear");
			logout();
			Assert.assertTrue(false);
		}
		Assert.assertEquals(alertMsg.getText(), "Message Sent!");
		act = builder.moveToElement(alertButton).click().build();
		act.perform();
		Thread.sleep(3000);
		checkMsg(to,Sub,text,msg.sentButton,"sentMessages",false);
		act = builder.moveToElement(msg.inboxButton).click().build();
		act.perform();
		try {
			msg.allButton = driver.LocateById(msg.allId);
			msg.unreadButton = driver.LocateById(msg.unreadId);
		}catch(Exception e) {
			Reporter.log("missing Buttons");
			Assert.assertTrue(false);
		}
		checkMsg(to,Sub,text,msg.allButton,"allMessages",false);
		checkMsg(to,Sub,text,msg.unreadButton,"unreadMessages",false);
		Reporter.log("Test 4 passed");
		logout();
	}
	
	@Test(priority=4,description="Send a message to another user")
	public void test5() throws InterruptedException {
		driver.nav(driver.Url);
		Thread.sleep(5000);
		signin("hell1","hell12");
		try {
			msg.messageButton = driver.LocateByXpath(msg.messageButtonXPath);
		}catch(Exception e) {
			Reporter.log("Can't Find Message Button");
			Reporter.log("Test 5 failed");
			logout();
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(msg.messageButton).click().build();
		act.perform();
		Thread.sleep(5000);
		try {
			msg.send = driver.LocateById(msg.sendId);
			msg.sentButton = driver.LocateById(msg.sentId);
			msg.inboxButton = driver.LocateById(msg.inboxId);
		}catch(Exception e) {
			Reporter.log("missing Buttons");
			Assert.assertTrue(false);
		}
		act=builder.moveToElement(msg.send).click().build();
		act.perform();
		Thread.sleep(5000);
		try {
			msg.to = driver.LocateByXpath(msg.toXPath);
			msg.subject = driver.LocateByXpath(msg.subjectXPath);
			msg.text = driver.LocateById(msg.textId);
			msg.sendButton = driver.LocateByXpath(msg.sendButtonXpath);
		}catch(Exception e) {
			Reporter.log("mising Elements");
			Assert.assertTrue(false);
		}
		String to = "hell12";
		String Sub = "Testing a message 10";
		String text = "test5";
		act = builder.sendKeys(msg.to, to).build();
		act.perform();
		act = builder.sendKeys(msg.subject, Sub).build();
		act.perform();
		act = builder.sendKeys(msg.text, text).build();
		act.perform();
		act = builder.moveToElement(msg.sendButton).click().build();
		act.perform();
		Thread.sleep(5000);
		WebElement alertMsg=null,alertButton=null;
		try {
			alertMsg = driver.LocateByXpath("/html/body/div[2]/div/div[1]");
			alertButton = driver.LocateByXpath("/html/body/div[2]/div/div[2]/div/button");
		}catch(Exception e) {
			Reporter.log("alert message didn't appear");
			logout();
			Assert.assertTrue(false);
		}
		Assert.assertEquals(alertMsg.getText(), "Message Sent!");
		act = builder.moveToElement(alertButton).click().build();
		act.perform();
		Thread.sleep(3000);
		checkMsg(to,Sub,text,msg.sentButton,"sentMessages",true);
		logout();
		signin("hell12","hell12");
		try {
			msg.messageButton = driver.LocateByXpath(msg.messageButtonXPath);
		}catch(Exception e) {
			Reporter.log("Can't Find Message Button");
			Reporter.log("Test 5 failed");
			logout();
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(msg.messageButton).click().build();
		act.perform();
		Thread.sleep(5000);
		try {
			msg.send = driver.LocateById(msg.sendId);
			msg.sentButton = driver.LocateById(msg.sentId);
			msg.inboxButton = driver.LocateById(msg.inboxId);
		}catch(Exception e) {
			Reporter.log("missing Buttons");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(msg.inboxButton).click().build();
		act.perform();
		try {
			msg.allButton = driver.LocateById(msg.allId);
			msg.unreadButton = driver.LocateById(msg.unreadId);
		}catch(Exception e) {
			Reporter.log("missing Buttons");
			Assert.assertTrue(false);
		}
		checkMsg("hell1",Sub,text,msg.allButton,"allMessages",true);
		checkMsg("hell1",Sub,text,msg.unreadButton,"unreadMessages",true);
		Reporter.log("Test 5 passed");
		logout();
	}
	@Test(priority=5,description="Reading a message")
	public void test6() throws InterruptedException {
		driver.nav(driver.Url);
		Thread.sleep(5000);
		signin("hell12","hell12");
		try {
			msg.messageButton = driver.LocateByXpath(msg.messageButtonXPath);
		}catch(Exception e) {
			Reporter.log("Can't Find Message Button");
			Reporter.log("Test 5 failed");
			logout();
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(msg.messageButton).click().build();
		act.perform();
		Thread.sleep(5000);
		try {
			msg.inboxButton = driver.LocateById(msg.inboxId);
		}catch(Exception e) {
			Reporter.log("missing Buttons");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(msg.inboxButton).click().build();
		act.perform();
		try {
			msg.allButton = driver.LocateById(msg.allId);
			msg.unreadButton = driver.LocateById(msg.unreadId);
			msg.readButton = driver.LocateById(msg.readId);
		}catch(Exception e) {
			Reporter.log("missing Buttons");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(msg.unreadButton).click().build();
		act.perform();
		WebElement To=null,Subject=null,Text=null,perma=null;
		try {
			Subject = driver.LocateByXpath("//*[@id='app']//div[@class='unreadMessages'][1]//div[@class='container2']/p");
			To = driver.LocateByXpath("//*[@id='app']//div[@class='unreadMessages'][1]//div[@class='container2']//div[@class='sub']//div[@class='first-line']/a");
			Text = driver.LocateByXpath("//*[@id='app']//div[@class='unreadMessages'][1]//div[@class='container2']//div[@class='sub']//div[@class='second-line']");
			perma = driver.LocateByXpath("//*[@id='app']//div[@class='unreadMessages'][1]//div[@class='container2']//div[@class='sub']//div[@class='first-line']//button[@id='Permalink']");
		}catch(Exception e) {
			Reporter.log("Didn't find any unreadMessage");
			Assert.assertTrue(false);
		}
		String to = To.getText();
		String Sub = Subject.getText();
		String text = Text.getText();
		act = builder.moveToElement(perma).click().build();
		act.perform();
		Thread.sleep(5000);
		try {
			Subject = driver.LocateByXpath("//*[@id='app']//div[@class='unreadMessages'][1]//div[@class='container2']/p");
			To = driver.LocateByXpath("//*[@id='app']//div[@class='unreadMessages'][1]//div[@class='container2']//div[@class='sub']//div[@class='first-line']/a");
			Text = driver.LocateByXpath("//*[@id='app']//div[@class='unreadMessages'][1]//div[@class='container2']//div[@class='sub']//div[@class='second-line']");
		}catch(Exception e) {
			Reporter.log("Didn't find any unreadMessage");
			return;
		}
		Assert.assertNotEquals(To.getText(), to);
		Assert.assertNotEquals(Subject.getText(), Sub);
		Assert.assertNotEquals(Text.getText(), text);
		act = builder.moveToElement(msg.readButton).click().build();
		act.perform();
		try {
			Subject = driver.LocateByXpath("//*[@id='app']//div[@class='readMessages'][1]//div[@class='container2']/p");
			To = driver.LocateByXpath("//*[@id='app']//div[@class='readMessages'][1]//div[@class='container2']//div[@class='sub']//div[@class='first-line']/a");
			Text = driver.LocateByXpath("//*[@id='app']//div[@class='readMessages'][1]//div[@class='container2']//div[@class='sub']//div[@class='second-line']");
		}catch(Exception e) {
			Reporter.log("Didn't find any readMessage");
			Assert.assertTrue(false);
		}
		Assert.assertEquals(To.getText(), to);
		Assert.assertEquals(Subject.getText(), Sub);
		Assert.assertEquals(Text.getText(), text);
		Reporter.log("Test 5 passed");
		logout();
	}
	
	@Test(priority=6,description="deleting a message")
	public void test7() throws InterruptedException {
		driver.nav(driver.Url);
		Thread.sleep(5000);
		signin("hell12","hell12");
		try {
			msg.messageButton = driver.LocateByXpath(msg.messageButtonXPath);
		}catch(Exception e) {
			Reporter.log("Can't Find Message Button");
			Reporter.log("Test 5 failed");
			logout();
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(msg.messageButton).click().build();
		act.perform();
		Thread.sleep(5000);
		try {
			msg.inboxButton = driver.LocateById(msg.inboxId);
		}catch(Exception e) {
			Reporter.log("missing Buttons");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(msg.inboxButton).click().build();
		act.perform();
		try {
			msg.allButton = driver.LocateById(msg.allId);
			msg.unreadButton = driver.LocateById(msg.unreadId);
			msg.readButton = driver.LocateById(msg.readId);
		}catch(Exception e) {
			Reporter.log("missing Buttons");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(msg.unreadButton).click().build();
		act.perform();
		WebElement To=null,Subject=null,Text=null,Del=null;
		try {
			Subject = driver.LocateByXpath("//*[@id='app']//div[@class='unreadMessages'][1]//div[@class='container2']/p");
			To = driver.LocateByXpath("//*[@id='app']//div[@class='unreadMessages'][1]//div[@class='container2']//div[@class='sub']//div[@class='first-line']/a");
			Text = driver.LocateByXpath("//*[@id='app']//div[@class='unreadMessages'][1]//div[@class='container2']//div[@class='sub']//div[@class='second-line']");
			Del = driver.LocateByXpath("//*[@id='app']//div[@class='unreadMessages'][1]//div[@class='container2']//div[@class='sub']//div[@class='first-line']//button[@id='Delete']");
		}catch(Exception e) {
			Reporter.log("Didn't find any unreadMessage");
			Assert.assertTrue(false);
		}
		String to = To.getText();
		String Sub = Subject.getText();
		String text = Text.getText();
		act = builder.moveToElement(Del).click().build();
		act.perform();
		Thread.sleep(5000);
		try {
			Subject = driver.LocateByXpath("//*[@id='app']//div[@class='unreadMessages'][1]//div[@class='container2']/p");
			To = driver.LocateByXpath("//*[@id='app']//div[@class='unreadMessages'][1]//div[@class='container2']//div[@class='sub']//div[@class='first-line']/a");
			Text = driver.LocateByXpath("//*[@id='app']//div[@class='unreadMessages'][1]//div[@class='container2']//div[@class='sub']//div[@class='second-line']");
		}catch(Exception e) {
			Reporter.log("Didn't find any unreadMessage");
		}
		try {
			Subject = driver.LocateByXpath("//*[@id='app']//div[@class='unreadMessages'][2]//div[@class='container2']/p");
			To = driver.LocateByXpath("//*[@id='app']//div[@class='unreadMessages'][2]//div[@class='container2']//div[@class='sub']//div[@class='first-line']/a");
			Text = driver.LocateByXpath("//*[@id='app']//div[@class='unreadMessages'][2]//div[@class='container2']//div[@class='sub']//div[@class='second-line']");
		}catch(Exception e) {
			Reporter.log("Didn't find any unreadMessage");
		}
		Assert.assertNotEquals(To.getText(), to);
		Assert.assertNotEquals(Subject.getText(), Sub);
		Assert.assertNotEquals(Text.getText(), text);
		act = builder.moveToElement(msg.allButton).click().build();
		act.perform();
		try {
			Subject = driver.LocateByXpath("//*[@id='app']//div[@class='allMessages'][1]//div[@class='container2']/p");
			To = driver.LocateByXpath("//*[@id='app']//div[@class='allMessages'][1]//div[@class='container2']//div[@class='sub']//div[@class='first-line']/a");
			Text = driver.LocateByXpath("//*[@id='app']//div[@class='allMessages'][1]//div[@class='container2']//div[@class='sub']//div[@class='second-line']");
		}catch(Exception e) {
			Reporter.log("Didn't find any readMessage");
			Assert.assertTrue(false);
		}
		Assert.assertNotEquals(To.getText(), to);
		Assert.assertNotEquals(Subject.getText(), Sub);
		Assert.assertNotEquals(Text.getText(), text);
		Reporter.log("Test 5 passed");
		logout();
	}
	@Test(priority=7,description="Empty message")
	public void test8() throws InterruptedException {
		driver.nav(driver.Url);
		Thread.sleep(5000);
		signin("hell1","hell12");
		try {
			msg.messageButton = driver.LocateByXpath(msg.messageButtonXPath);
		}catch(Exception e) {
			Reporter.log("Can't Find Message Button");
			Reporter.log("Test 8 failed");
			logout();
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(msg.messageButton).click().build();
		act.perform();
		Thread.sleep(5000);
		try {
			msg.send = driver.LocateById(msg.sendId);
			msg.sentButton = driver.LocateById(msg.sentId);
			msg.inboxButton = driver.LocateById(msg.inboxId);
		}catch(Exception e) {
			Reporter.log("missing Buttons");
			Assert.assertTrue(false);
		}
		act=builder.moveToElement(msg.send).click().build();
		act.perform();
		Thread.sleep(5000);
		try {
			msg.to = driver.LocateByXpath(msg.toXPath);
			msg.subject = driver.LocateByXpath(msg.subjectXPath);
			msg.text = driver.LocateById(msg.textId);
			msg.sendButton = driver.LocateByXpath(msg.sendButtonXpath);
		}catch(Exception e) {
			Reporter.log("mising Elements");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(msg.sendButton).click().build();
		act.perform();
		Thread.sleep(5000);
		WebElement alertMsg=null,alertButton=null;
		try {
			alertMsg = driver.LocateByXpath("/html/body/div[2]/div/div[1]");
			alertButton = driver.LocateByXpath("/html/body/div[2]/div/div[2]/div/button");
		}catch(Exception e) {
			Reporter.log("alert message didn't appear");
			logout();
			Assert.assertTrue(false);
		}
		Assert.assertEquals(alertMsg.getText(), "To box cannot be empty!");
		act = builder.moveToElement(alertButton).click().build();
		act.perform();
		Thread.sleep(3000);
		Reporter.log("Test 8 passed");
		logout();
	}
	
	@Test(priority=8,description="Message Reply")
	public void test9() throws InterruptedException {
		driver.nav(driver.Url);
		Thread.sleep(5000);
		signin("hell1","hell12");
		try {
			msg.messageButton = driver.LocateByXpath(msg.messageButtonXPath);
		}catch(Exception e) {
			Reporter.log("Can't Find Message Button");
			Reporter.log("Test 8 failed");
			logout();
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(msg.messageButton).click().build();
		act.perform();
		Thread.sleep(5000);
		try {
			msg.send = driver.LocateById(msg.sendId);
			msg.sentButton = driver.LocateById(msg.sentId);
			msg.inboxButton = driver.LocateById(msg.inboxId);
		}catch(Exception e) {
			Reporter.log("missing Buttons");
			Assert.assertTrue(false);
		}
		act=builder.moveToElement(msg.send).click().build();
		act.perform();
		Thread.sleep(5000);
		try {
			msg.to = driver.LocateByXpath(msg.toXPath);
			msg.subject = driver.LocateByXpath(msg.subjectXPath);
			msg.text = driver.LocateById(msg.textId);
			msg.sendButton = driver.LocateByXpath(msg.sendButtonXpath);
		}catch(Exception e) {
			Reporter.log("mising Elements");
			Assert.assertTrue(false);
		}
		String to = "hell12";
		String Sub = "Reply test";
		String text = "reply to this";
		act = builder.sendKeys(msg.to, to).build();
		act.perform();
		act = builder.sendKeys(msg.subject, Sub).build();
		act.perform();
		act = builder.sendKeys(msg.text, text).build();
		act.perform();
		act = builder.moveToElement(msg.sendButton).click().build();
		act.perform();
		Thread.sleep(5000);
		WebElement alertMsg=null,alertButton=null;
		try {
			alertMsg = driver.LocateByXpath("/html/body/div[2]/div/div[1]");
			alertButton = driver.LocateByXpath("/html/body/div[2]/div/div[2]/div/button");
		}catch(Exception e) {
			Reporter.log("alert message didn't appear");
			logout();
			Assert.assertTrue(false);
		}
		Assert.assertEquals(alertMsg.getText(), "Message Sent!");
		act = builder.moveToElement(alertButton).click().build();
		act.perform();
		Thread.sleep(3000);
		checkMsg(to,Sub,text,msg.sentButton,"sentMessages",true);
		logout();
		signin("hell12","hell12");
		try {
			msg.messageButton = driver.LocateByXpath(msg.messageButtonXPath);
		}catch(Exception e) {
			Reporter.log("Can't Find Message Button");
			Reporter.log("Test 9 failed");
			logout();
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(msg.messageButton).click().build();
		act.perform();
		Thread.sleep(5000);
		try {
			msg.send = driver.LocateById(msg.sendId);
			msg.sentButton = driver.LocateById(msg.sentId);
			msg.inboxButton = driver.LocateById(msg.inboxId);
		}catch(Exception e) {
			Reporter.log("missing Buttons");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(msg.inboxButton).click().build();
		act.perform();
		try {
			msg.allButton = driver.LocateById(msg.allId);
			msg.unreadButton = driver.LocateById(msg.unreadId);
		}catch(Exception e) {
			Reporter.log("missing Buttons");
			Assert.assertTrue(false);
		}
		checkMsg("hell1",Sub,text,msg.allButton,"allMessages",true);
		checkMsg("hell1",Sub,text,msg.unreadButton,"unreadMessages",true);
		WebElement replyButton=null;
		try {
			replyButton = driver.LocateByXpath("//*[@id='app']//div[@class='unreadMessages'][1]//div[@class='container2']//div[@class='sub']//div[@class='first-line']//button[@id='Reply']");
		}catch(Exception e) {
			Reporter.log("Didn't find any unreadMessage");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(replyButton).click().build();
		act.perform();
		Thread.sleep(3000);
		WebElement Reply=null,perm=null,Send=null;
		try {
			Reply = driver.LocateByXpath("//*[@id='app']//div[@class='unreadMessages'][1]//textarea[@id='CommentSpace']");
			perm = driver.LocateByXpath("//*[@id='app']//div[@class='unreadMessages'][1]//div[@class='container2']//div[@class='sub']//div[@class='first-line']//button[@id='Permalink']");
			Send = driver.LocateByXpath("//*[@id='app']//div[@class='unreadMessages'][1]//div[@id='WriteComment']//div[@id='Buttons']//button[@id='Message']");
		}catch(Exception e) {
			Reporter.log("Reply window didn't open");
			Assert.assertTrue(false);
		}
		String r="Okay";
		act = builder.sendKeys(Reply,r).build();
		act.perform();
		act = builder.moveToElement(Send).click().build();
		act.perform();
		Thread.sleep(5000);
		act=builder.moveToElement(perm).click().build();
		act.perform();
		Thread.sleep(5000);
		WebElement R=null,sentTo=null;
		try {
			R = driver.LocateByXpath("//*[@id='app']//div[@class='unreadMessages'][1]//div[@class='sub2']//div[@class='second-line2']");
			sentTo = driver.LocateByXpath("//*[@id='app']//div[@class='unreadMessages'][1]//div[@class='sub2']//div[@class='first-line2']//a");
		}catch(Exception e) {
			Reporter.log("can't find the reply");
			Assert.assertTrue(false);
		}
		Assert.assertEquals(sentTo.getText(), "hell1");
		Assert.assertEquals(R.getText(), r);
		logout();
		signin("hell1","hell12");
		try {
			msg.messageButton = driver.LocateByXpath(msg.messageButtonXPath);
		}catch(Exception e) {
			Reporter.log("Can't Find Message Button");
			Reporter.log("Test 9 failed");
			logout();
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(msg.messageButton).click().build();
		act.perform();
		Thread.sleep(5000);
		try {
			msg.send = driver.LocateById(msg.sendId);
			msg.sentButton = driver.LocateById(msg.sentId);
			msg.inboxButton = driver.LocateById(msg.inboxId);
		}catch(Exception e) {
			Reporter.log("missing Buttons");
			Assert.assertTrue(false);
		}
		act=builder.moveToElement(msg.sentButton).click().build();
		act.perform();
		Thread.sleep(5000);
		try {
			perm = driver.LocateByXpath("//*[@id='app']//div[@class='sentMessages'][1]//div[@class='container2']//div[@class='sub']//div[@class='first-line']//button[@id='Permalink']");
		}catch(Exception e) {
			Reporter.log("Replies window didn't open");
			Assert.assertTrue(false);
		}
		act=builder.moveToElement(perm).click().build();
		act.perform();
		Thread.sleep(3000);
		WebElement R2=null,from=null;
		try {
			R2 = driver.LocateByXpath("//*[@id='app']//div[@class='sentMessages'][1]//div[@class='second-line2']");
			from = driver.LocateByXpath("//*[@id='app']//div[@class='sentMessages'][1]//div[@class='first-line2']//a");
		}catch(Exception e) {
			Reporter.log("can't find the reply");
			Assert.assertTrue(false);
		}
		Assert.assertEquals(from.getText(), "hell12");
		Assert.assertEquals(R2.getText(), r);
		logout();
		Reporter.log("Test 9 passed");
	}
	@Test(priority=9,description="Blocking")
	public void test10() throws InterruptedException {
		driver.nav(driver.Url);
		Thread.sleep(5000);
		signin("hell12","hell12");
		try {
			msg.messageButton = driver.LocateByXpath(msg.messageButtonXPath);
		}catch(Exception e) {
			Reporter.log("Can't Find Message Button");
			Reporter.log("Test 10 failed");
			logout();
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(msg.messageButton).click().build();
		act.perform();
		Thread.sleep(5000);
		try {
			msg.inboxButton = driver.LocateById(msg.inboxId);
		}catch(Exception e) {
			Reporter.log("missing Buttons");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(msg.inboxButton).click().build();
		act.perform();
		try {
			msg.allButton = driver.LocateById(msg.allId);
			msg.unreadButton = driver.LocateById(msg.unreadId);
			msg.readButton = driver.LocateById(msg.readId);
		}catch(Exception e) {
			Reporter.log("missing Buttons");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(msg.unreadButton).click().build();
		act.perform();
		Thread.sleep(5000);
		WebElement To=null,sub=null,text=null,Block=null;
		try {
			sub = driver.LocateByXpath("//*[@id='app']//div[@class='unreadMessages'][1]//div[@class='container2']/p");
			To = driver.LocateByXpath("//*[@id='app']//div[@class='unreadMessages'][1]//div[@class='container2']//div[@class='sub']//div[@class='first-line']/a");
			text = driver.LocateByXpath("//*[@id='app']//div[@class='unreadMessages'][1]//div[@class='container2']//div[@class='sub']//div[@class='second-line']");
			Block = driver.LocateByXpath("//*[@id='app']//div[@class='unreadMessages'][1]//div[@class='container2']//div[@class='sub']//div[@class='first-line']//button[@id='BlockUser']");
		}catch(Exception e) {
			Reporter.log("Didn't find any unreadMessage");
			Assert.assertTrue(false);
		}
		String to = To.getText(),Sub=sub.getText(),t=text.getText();
		act = builder.moveToElement(Block).click().build();
		act.perform();
		Thread.sleep(5000);
		try {
			driver.LocateById("no").click();
		}catch(Exception e) {
			Reporter.log("pressing the No Button Failed");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(Block).click().build();
		act.perform();
		Thread.sleep(5000);
		try {
			driver.LocateById("yes").click();
		}catch(Exception e) {
			Reporter.log("pressing the yes Button Failed");
			Assert.assertTrue(false);
		}
		Thread.sleep(5000);
		try {
			sub = driver.LocateByXpath("//*[@id='app']//div[@class='unreadMessages'][1]//div[@class='container2']/p");
			To = driver.LocateByXpath("//*[@id='app']//div[@class='unreadMessages'][1]//div[@class='container2']//div[@class='sub']//div[@class='first-line']/a");
			text = driver.LocateByXpath("//*[@id='app']//div[@class='unreadMessages'][1]//div[@class='container2']//div[@class='sub']//div[@class='second-line']");
		}catch(Exception e) {
			Reporter.log("Didn't find any unreadMessage");
			Assert.assertTrue(false);
		}
		Assert.assertEquals(t, text.getText());
		Assert.assertEquals(Sub, sub.getText());
		Assert.assertEquals(to, To.getText());
		Thread.sleep(1000);
		try {
			login.logout = driver.LocateById(login.logoutDivID);
		}catch(Exception e) {
			Reporter.log("Can't find profile button");
			Assert.assertTrue(false);
		}
	  	act = builder.moveToElement(login.logout).click().build();
		act.perform();
		Thread.sleep(5000);
		try {
			login.logoutButton = driver.LocateByXpath("//*[@id='loggedbutton']//following-sibling::ul/li[2]");
		}catch(Exception e) {
			Reporter.log("Can't find profile button");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(login.logoutButton).click().build();
		act.perform();
		Thread.sleep(5000);
		try {
			driver.LocateByXpath("//*[@id='firstnavbar']/a[5]").click();
			Thread.sleep(5000);
		}catch(Exception e) {
			Reporter.log("Can't find Block List Button");
		}
		String user="";
		try {
			user = driver.LocateByXpath("//*[@id='block']//div[@id='box'][1]/div/p").getText();
		}catch(Exception e) {
			Reporter.log("No Blocked Users");
		}
		Assert.assertEquals(user, to);
		logout();
		signin("hell1","hell12");
		try {
			msg.messageButton = driver.LocateByXpath(msg.messageButtonXPath);
		}catch(Exception e) {
			Reporter.log("Can't Find Message Button");
			Reporter.log("Test 10 failed");
			logout();
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(msg.messageButton).click().build();
		act.perform();
		Thread.sleep(5000);
		try {
			msg.send = driver.LocateById(msg.sendId);
			msg.sentButton = driver.LocateById(msg.sentId);
			msg.inboxButton = driver.LocateById(msg.inboxId);
		}catch(Exception e) {
			Reporter.log("missing Buttons");
			Assert.assertTrue(false);
		}
		act=builder.moveToElement(msg.send).click().build();
		act.perform();
		Thread.sleep(5000);
		try {
			msg.to = driver.LocateByXpath(msg.toXPath);
			msg.subject = driver.LocateByXpath(msg.subjectXPath);
			msg.text = driver.LocateById(msg.textId);
			msg.sendButton = driver.LocateByXpath(msg.sendButtonXpath);
		}catch(Exception e) {
			Reporter.log("mising Elements");
			Assert.assertTrue(false);
		}
		act = builder.sendKeys(msg.to, "hell12").build();
		act.perform();
		act = builder.sendKeys(msg.subject, "hello").build();
		act.perform();
		act = builder.sendKeys(msg.text, "hello 2").build();
		act.perform();
		act = builder.moveToElement(msg.sendButton).click().build();
		act.perform();
		Thread.sleep(5000);
		try {
			driver.LocateByXpath("/html/body/div[2]/div/div[2]/div/button").click();
		}catch(Exception e) {
			Reporter.log("Can't find a response");
		}
		Reporter.log("Test 10 passed");
		logout();
	}
	
	
	
}
