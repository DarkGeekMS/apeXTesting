package TestingScript;


import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import DriverDef.Chrome;
import PageModel.SignUpPage;

public class SignUpTest {
  
	public Chrome driver;
	public SignUpPage page;
	public Actions builder;
	public Action act;
	@BeforeClass
	public void init()
	{
		driver = new Chrome();
		page = new SignUpPage();
		builder = new Actions(driver.driver);
		System.out.println("Sign up test starts");
	}
	@AfterClass
	public void finalize()
	{
		driver.shutdown();
		System.out.println("Sign up test ends");
	}
	
	@Test(description="Entering inValid Email then press Next",priority=0)
	public void test1()
	{
		driver.nav("http://localhost:8081/");
		try {
			page.SignUpButton = driver.LocateById(page.SignUpButtonId);
		}catch(Exception e) {
			System.out.println("Can't find the SignUp Button");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(page.SignUpButton).click().build();
		act.perform();
		try {
			page.Email = driver.LocateById(page.EmailId);
			page.Next = driver.LocateById(page.NextId);
		}catch(Exception e) {
			System.out.println("Missing Elements in SignUp1 Page");
			Assert.assertTrue(false);
		}
		act = builder.sendKeys(page.Email,"mohamed").build();
		act.perform();
		act = builder.moveToElement(page.Next).click().build();
		act.perform();
		try {
			page.ErrorLabel = driver.LocateById(page.ErrorLabelId);
		}catch(Exception e){
			System.out.println("Right Email Formula");
			Assert.assertTrue(false);
		}
		Assert.assertEquals(page.ErrorLabel.getText(),"");
	}
	
	@Test(description="Entering Valid Email then press Next then press back",priority=1)
	public void test2()
	{
		driver.nav("http://localhost:8081/");
		try {
			page.SignUpButton = driver.LocateById(page.SignUpButtonId);
		}catch(Exception e) {
			System.out.println("Can't find the SignUp Button");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(page.SignUpButton).click().build();
		act.perform();
		try {
			page.Email = driver.LocateById(page.EmailId);
			page.Next = driver.LocateById(page.NextId);
		}catch(Exception e) {
			System.out.println("Missing Elements in SignUp1 Page");
			Assert.assertTrue(false);
		}
		act = builder.sendKeys(page.Email,"mohamed1989877@gmail.com").build();
		act.perform();
		act = builder.moveToElement(page.Next).click().build();
		act.perform();
		try {
			page.Back = driver.LocateById(page.BackId);
		}catch(Exception e) {
			System.out.println("Can't Find Back Button");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(page.Back).click().build();
		act.perform();
		try {
			page.Back = driver.LocateById(page.BackId);
		}catch(Exception e) {
			System.out.println("Test Passed");
			return;
		}
		System.out.println("Didn't Go Back");
		Assert.assertTrue(false);
	}
	
	@Test(description="Entering Valid Email then press Next then press SignUp with any empty field or not suitable credentials",priority=2)
	public void test3()
	{
		driver.nav("http://localhost:8081/");
		try {
			page.SignUpButton = driver.LocateById(page.SignUpButtonId);
		}catch(Exception e) {
			System.out.println("Can't find the SignUp Button");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(page.SignUpButton).click().build();
		act.perform();
		try {
			page.Email = driver.LocateById(page.EmailId);
			page.Next = driver.LocateById(page.NextId);
		}catch(Exception e) {
			System.out.println("Missing Elements in SignUp1 Page");
			Assert.assertTrue(false);
		}
		act = builder.sendKeys(page.Email,"m98@gmail.com").build();
		act.perform();
		act = builder.moveToElement(page.Next).click().build();
		act.perform();
		try {
			page.UserName = driver.LocateById(page.UserNameId);
			page.Password = driver.LocateById(page.PasswordId);
			page.Back = driver.LocateById(page.BackId);
			page.Finish = driver.LocateById(page.FinishId);
		}catch(Exception e) {
			System.out.println("Missing Elements in SignUp2 Page");
			Assert.assertTrue(false);
		}
		act = builder.sendKeys(page.UserName,"m_i").build();
		act.perform();
		if(page.Finish.isEnabled()) {
			Assert.assertTrue(false);
		}
		
		act = builder.sendKeys(page.UserName,"").build();
		act.perform();
		act = builder.sendKeys(page.Password,"mohamed").build();
		act.perform();
		if(page.Finish.isEnabled()) {
			Assert.assertTrue(false);
		}
		act = builder.sendKeys(page.UserName,"mohamed_ibrahim_333").build();
		act.perform();
		if(page.Finish.isEnabled()) {
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(page.Finish).click().build();
		act.perform();
	}
	
	@Test(description="Entering Valid Email then press Next then press SignUp with valid UserName & Password",priority=3)
	public void test5()
	{
		driver.nav("http://localhost:8081/");
		try {
			page.SignUpButton = driver.LocateById(page.SignUpButtonId);
		}catch(Exception e) {
			System.out.println("Can't find the SignUp Button");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(page.SignUpButton).click().build();
		act.perform();
		try {
			page.Email = driver.LocateById(page.EmailId);
			page.Next = driver.LocateById(page.NextId);
		}catch(Exception e) {
			System.out.println("Missing Elements in SignUp1 Page");
			Assert.assertTrue(false);
		}
		act = builder.sendKeys(page.Email,"mmibrahim@live.com").build();
		act.perform();
		act = builder.moveToElement(page.Next).click().build();
		act.perform();
		try {
			page.UserName = driver.LocateById(page.UserNameId);
			page.Password = driver.LocateById(page.PasswordId);
			page.Back = driver.LocateById(page.BackId);
			page.Finish = driver.LocateById(page.FinishId);
		}catch(Exception e) {
			System.out.println("Missing Elements in SignUp2 Page");
			Assert.assertTrue(false);
		}
		act = builder.sendKeys(page.UserName,"deepo123").build();
		act.perform();
		act = builder.sendKeys(page.Password,"mohamed").build();
		act.perform();
		act = builder.moveToElement(page.Finish).click().build();
		act.perform();
		try {
			page.Success = driver.LocateById(page.SuccessId);
		}catch(Exception e) {
			System.out.println("Login Failed");
			Assert.assertTrue(false);
		}
		System.out.println("Signed Up Successfully");
	}
	@Test(description="Entering With Existing Email",priority=4)
	public void test6() throws InterruptedException
	{
		driver.nav("http://localhost:8081/");
		try {
			page.SignUpButton = driver.LocateById(page.SignUpButtonId);
		}catch(Exception e) {
			System.out.println("Can't find the SignUp Button");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(page.SignUpButton).click().build();
		act.perform();
		try {
			page.Email = driver.LocateById(page.EmailId);
			page.Next = driver.LocateById(page.NextId);
		}catch(Exception e) {
			System.out.println("Missing Elements in SignUp1 Page");
			Assert.assertTrue(false);
		}
		act = builder.sendKeys(page.Email,"mohamed1989877@gmail.com").build();
		act.perform();
		act = builder.moveToElement(page.Next).click().build();
		act.perform();
		try {
			page.UserName = driver.LocateById(page.UserNameId);
			page.Password = driver.LocateById(page.PasswordId);
			page.Back = driver.LocateById(page.BackId);
			page.Finish = driver.LocateById(page.FinishId);
		}catch(Exception e) {
			System.out.println("Missing Elements in SignUp2 Page");
			Assert.assertTrue(false);
		}
		act = builder.sendKeys(page.UserName,"mohamedAhmedibrahim").build();
		act.perform();
		act = builder.sendKeys(page.Password,"mohamed").build();
		act.perform();
		act = builder.moveToElement(page.Finish).click().build();
		act.perform();
		Alert msg;
		for(int i=0;i<5;i++)
		{
		        try
		        {
		            msg = driver.driver.switchTo().alert();
		            break;
		        }
		        catch(NoAlertPresentException e)
		        {
		          Thread.sleep(1000);
		        }
		}
		msg = driver.driver.switchTo().alert();
		msg.accept();
	}
	@Test(description="Entering With Existing userName",priority=5)
	public void test7() throws InterruptedException
	{
		driver.nav("http://localhost:8081/");
		try {
			page.SignUpButton = driver.LocateById(page.SignUpButtonId);
		}catch(Exception e) {
			System.out.println("Can't find the SignUp Button");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(page.SignUpButton).click().build();
		act.perform();
		try {
			page.Email = driver.LocateById(page.EmailId);
			page.Next = driver.LocateById(page.NextId);
		}catch(Exception e) {
			System.out.println("Missing Elements in SignUp1 Page");
			Assert.assertTrue(false);
		}
		act = builder.sendKeys(page.Email,"mohamed1988958@live.com").build();
		act.perform();
		act = builder.moveToElement(page.Next).click().build();
		act.perform();
		try {
			page.UserName = driver.LocateById(page.UserNameId);
			page.Password = driver.LocateById(page.PasswordId);
			page.Back = driver.LocateById(page.BackId);
			page.Finish = driver.LocateById(page.FinishId);
		}catch(Exception e) {
			System.out.println("Missing Elements in SignUp2 Page");
			Assert.assertTrue(false);
		}
		act = builder.sendKeys(page.UserName,"mohamed_ibrahim_333").build();
		act.perform();
		act = builder.sendKeys(page.Password,"mohamed").build();
		act.perform();
		act = builder.moveToElement(page.Finish).click().build();
		act.perform();
		Alert msg;
		for(int i=0;i<5;i++)
		{
		        try
		        {
		            msg = driver.driver.switchTo().alert();
		            break;
		        }
		        catch(NoAlertPresentException e)
		        {
		          Thread.sleep(1000);
		        }
		}
		msg = driver.driver.switchTo().alert();
		msg.accept();
	}
}
