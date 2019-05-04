package TestingScript;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import DriverDef.Chrome;
import PageModel.LoginPage;
import PageModel.SignUpPage;

public class SignUpTest {
	public Chrome driver;
	public SignUpPage page;
	public LoginPage login;
	public Actions builder;
	public Action act;
	
	@BeforeClass
	public void init()
	{
		driver = new Chrome();
		page = new SignUpPage();
		login = new LoginPage();
		builder = new Actions(driver.driver);
		System.out.println("Sign up test starts");
	}
	@AfterClass
	public void finalize()
	{
		driver.shutdown();
		System.out.println("Sign up test ends");
	}
	
	
	@Test(description="Entering inValid Email then press Next or Empty Email",priority=0)
	public void test1() throws InterruptedException
	{
		driver.nav(driver.Url);
		Thread.sleep(5000);
		try {
			page.SignUpButton = driver.LocateById(page.SignUpButtonId);
		}catch(Exception e) {
			System.out.println("Can't find the SignUp Button");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(page.SignUpButton).click().build();
		act.perform();
		Thread.sleep(3000);
		try {
			page.Email = driver.LocateById(page.EmailId);
			page.Next = driver.LocateById(page.NextId);
		}catch(Exception e) {
			System.out.println("Missing Elements in SignUp1 Page");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(page.Next).click().build();
		act.perform();
		try {
			page.ErrorLabel = driver.LocateById(page.ErrorLabelId);
		}catch(Exception e){
			System.out.println("Right Email Formula");
			Assert.assertTrue(false);
		}
		Assert.assertEquals(page.ErrorLabel.getText(),"Email is required");
		
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
		Assert.assertEquals(page.ErrorLabel.getText(),"please fix your email to continue");
		page.Email.clear();
		act = builder.sendKeys(page.Email,"m k@live.com").build();
		act.perform();
		act = builder.moveToElement(page.Next).click().build();
		act.perform();
		try {
			page.ErrorLabel = driver.LocateById(page.ErrorLabelId);
		}catch(Exception e){
			System.out.println("Right Email Formula");
			Assert.assertTrue(false);
		}
		Assert.assertEquals(page.ErrorLabel.getText(),"please fix your email to continue");
		page.Email.clear();
		act = builder.sendKeys(page.Email,"@@live.com").build();
		act.perform();
		act = builder.moveToElement(page.Next).click().build();
		act.perform();
		try {
			page.ErrorLabel = driver.LocateById(page.ErrorLabelId);
		}catch(Exception e){
			System.out.println("Right Email Formula");
			Assert.assertTrue(false);
		}
		Assert.assertEquals(page.ErrorLabel.getText(),"please fix your email to continue");
		System.out.println("Test 1 Passed");
	}
	
	@Test(description="Entering Valid Email then press Next then press back",priority=1)
	public void test2() throws InterruptedException
	{
		driver.nav(driver.Url);
		Thread.sleep(5000);
		try {
			page.SignUpButton = driver.LocateById(page.SignUpButtonId);
		}catch(Exception e) {
			System.out.println("Can't find the SignUp Button");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(page.SignUpButton).click().build();
		act.perform();
		Thread.sleep(3000);
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
		Thread.sleep(3000);
		try {
			page.Back = driver.LocateById(page.BackId);
		}catch(Exception e) {
			System.out.println("Can't Find Back Button");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(page.Back).click().build();
		act.perform();
		Thread.sleep(3000);
		try {
			page.Back = driver.LocateById(page.BackId);
		}catch(Exception e) {
			System.out.println("Test 2 Passed");
			return;
		}
		System.out.println("Didn't Go Back");
		Assert.assertTrue(false);
		
	}
	
	
	@Test(description="Entering Valid Email then press Next then press SignUp with any empty field or not suitable credentials",priority=2)
	public void test3() throws InterruptedException
	{
		driver.nav(driver.Url);
		Thread.sleep(5000);
		try {
			page.SignUpButton = driver.LocateById(page.SignUpButtonId);
		}catch(Exception e) {
			System.out.println("Can't find the SignUp Button");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(page.SignUpButton).click().build();
		act.perform();
		Thread.sleep(3000);
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
		Thread.sleep(3000);
		try {
			page.UserName = driver.LocateById(page.UserNameId);
			page.Password = driver.LocateById(page.PasswordId);
			page.Back = driver.LocateById(page.BackId);
			page.Finish = driver.LocateById(page.FinishId);
		}catch(Exception e) {
			System.out.println("Missing Elements in SignUp2 Page");
			Assert.assertTrue(false);
		}
		act = builder.sendKeys(page.Password,"mohamed").build();
		act.perform();
		Thread.sleep(1000);
		Assert.assertTrue(!page.Finish.isEnabled());
		act = builder.sendKeys(page.UserName,"m_i").build();
		act.perform();
		page.Password.clear();
		act = builder.sendKeys(page.Password,"a").build();
		act.perform();
		act = builder.sendKeys(page.Password,Keys.BACK_SPACE).build();
		act.perform();
		Thread.sleep(1000);
		Assert.assertTrue(!page.Finish.isEnabled());
		System.out.println("Test 3 Passed");
	}
	
	
	@Test(description="Entering With Existing Email",priority=3)
	public void test4() throws InterruptedException
	{
		driver.nav(driver.Url);
		Thread.sleep(5000);
		try {
			page.SignUpButton = driver.LocateById(page.SignUpButtonId);
		}catch(Exception e) {
			System.out.println("Can't find the SignUp Button");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(page.SignUpButton).click().build();
		act.perform();
		Thread.sleep(3000);
		try {
			page.Email = driver.LocateById(page.EmailId);
			page.Next = driver.LocateById(page.NextId);
		}catch(Exception e) {
			System.out.println("Missing Elements in SignUp1 Page");
			Assert.assertTrue(false);
		}
		act = builder.sendKeys(page.Email,"mohamed@live.com").build();
		act.perform();
		act = builder.moveToElement(page.Next).click().build();
		act.perform();
		Thread.sleep(3000);
		try {
			page.UserName = driver.LocateById(page.UserNameId);
			page.Password = driver.LocateById(page.PasswordId);
			page.Back = driver.LocateById(page.BackId);
			page.Finish = driver.LocateById(page.FinishId);
		}catch(Exception e) {
			System.out.println("Missing Elements in SignUp2 Page");
			Assert.assertTrue(false);
		}
		act = builder.sendKeys(page.UserName,"Deepo12").build();
		act.perform();
		act = builder.sendKeys(page.Password,"mohamed").build();
		act.perform();
		act = builder.moveToElement(page.Finish).click().build();
		act.perform();
		Thread.sleep(3000);
		WebElement ErrorLabel = null;
		try {
			ErrorLabel = driver.LocateByXpath("//*[@id=\"partition-register\"]/div[3]/form/div[1]/p[1]");
		}catch(Exception e) {
			System.out.println("Can't Find Error Label");
			Assert.assertTrue(false);
		}
		Assert.assertEquals(ErrorLabel.getText(), "Invalid email or Email already exists");
		System.out.println("Test 4 Passed");
	}
	
	@Test(description="Entering With Existing userName",priority=4)
	public void test5() throws InterruptedException
	{
		driver.nav(driver.Url);
		Thread.sleep(5000);
		try {
			page.SignUpButton = driver.LocateById(page.SignUpButtonId);
		}catch(Exception e) {
			System.out.println("Can't find the SignUp Button");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(page.SignUpButton).click().build();
		act.perform();
		Thread.sleep(3000);
		try {
			page.Email = driver.LocateById(page.EmailId);
			page.Next = driver.LocateById(page.NextId);
		}catch(Exception e) {
			System.out.println("Missing Elements in SignUp1 Page");
			Assert.assertTrue(false);
		}
		act = builder.sendKeys(page.Email,"mohamed1664@live.com").build();
		act.perform();
		act = builder.moveToElement(page.Next).click().build();
		act.perform();
		Thread.sleep(3000);
		try {
			page.UserName = driver.LocateById(page.UserNameId);
			page.Password = driver.LocateById(page.PasswordId);
			page.Back = driver.LocateById(page.BackId);
			page.Finish = driver.LocateById(page.FinishId);
		}catch(Exception e) {
			System.out.println("Missing Elements in SignUp2 Page");
			Assert.assertTrue(false);
		}
		act = builder.sendKeys(page.UserName,"Deepo1").build();
		act.perform();
		act = builder.sendKeys(page.Password,"mohamed").build();
		act.perform();
		act = builder.moveToElement(page.Finish).click().build();
		act.perform();
		Thread.sleep(3000);
		WebElement ErrorLabel = null;
		try {
			ErrorLabel = driver.LocateByXpath("//*[@id='partition-register']/div[3]/form/div[1]/p[1]");
		}catch(Exception e) {
			System.out.println("Can't Find Error Label");
			Assert.assertTrue(false);
		}
		Assert.assertEquals(ErrorLabel.getText(), "That username is already taken");
		System.out.println("Test 5 Passed");
	}
	
	@Test(description="Entering With Long Email",priority=5)
	public void test6() throws InterruptedException
	{
		driver.nav(driver.Url);
		Thread.sleep(5000);
		try {
			page.SignUpButton = driver.LocateById(page.SignUpButtonId);
		}catch(Exception e) {
			System.out.println("Can't find the SignUp Button");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(page.SignUpButton).click().build();
		act.perform();
		Thread.sleep(3000);
		try {
			page.Email = driver.LocateById(page.EmailId);
			page.Next = driver.LocateById(page.NextId);
		}catch(Exception e) {
			System.out.println("Missing Elements in SignUp1 Page");
			Assert.assertTrue(false);
		}
		act = builder.sendKeys(page.Email,"mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm@live.com").build();
		act.perform();
		act = builder.moveToElement(page.Next).click().build();
		act.perform();
		Thread.sleep(3000);
		try {
			page.UserName = driver.LocateById(page.UserNameId);
			page.Password = driver.LocateById(page.PasswordId);
			page.Back = driver.LocateById(page.BackId);
			page.Finish = driver.LocateById(page.FinishId);
		}catch(Exception e) {
			System.out.println("Missing Elements in SignUp2 Page");
			Assert.assertTrue(false);
		}
		act = builder.sendKeys(page.UserName,"deeeeepo").build();
		act.perform();
		act = builder.sendKeys(page.Password,"mohamed").build();
		act.perform();
		act = builder.moveToElement(page.Finish).click().build();
		act.perform();
		Thread.sleep(3000);
		WebElement ErrorLabel = null;
		try {
			ErrorLabel = driver.LocateByXpath("//*[@id='partition-register']/div[3]/form/div[1]/p[1]");
		}catch(Exception e) {
			System.out.println("Can't Find Error Label");
			Assert.assertTrue(false);
		}
		Assert.assertEquals(ErrorLabel.getText(), "Invalid email or Email already exists");
		System.out.println("Test 6 Passed");
	}
	@Test(description="Entering With Long user name or spaced user name",priority=6)
	public void test7() throws InterruptedException
	{
		driver.nav(driver.Url);
		Thread.sleep(5000);
		try {
			page.SignUpButton = driver.LocateById(page.SignUpButtonId);
		}catch(Exception e) {
			System.out.println("Can't find the SignUp Button");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(page.SignUpButton).click().build();
		act.perform();
		Thread.sleep(3000);
		try {
			page.Email = driver.LocateById(page.EmailId);
			page.Next = driver.LocateById(page.NextId);
		}catch(Exception e) {
			System.out.println("Missing Elements in SignUp1 Page");
			Assert.assertTrue(false);
		}
		act = builder.sendKeys(page.Email,"mohamed12345@live.com").build();
		act.perform();
		act = builder.moveToElement(page.Next).click().build();
		act.perform();
		Thread.sleep(3000);
		try {
			page.UserName = driver.LocateById(page.UserNameId);
			page.Password = driver.LocateById(page.PasswordId);
			page.Back = driver.LocateById(page.BackId);
			page.Finish = driver.LocateById(page.FinishId);
		}catch(Exception e) {
			System.out.println("Missing Elements in SignUp2 Page");
			Assert.assertTrue(false);
		}
		act = builder.sendKeys(page.UserName,"mmkmmmmmmmkkkmmmmmmmmmmmmmmmkmmmmmmmm").build();
		act.perform();
		act = builder.sendKeys(page.Password,"mohamed").build();
		act.perform();
		act = builder.moveToElement(page.Finish).click().build();
		act.perform();
		Thread.sleep(3000);
		WebElement ErrorLabel = null;
		try {
			ErrorLabel = driver.LocateByXpath("//*[@id='partition-register']/div[3]/form/div[1]/span[1]");
		}catch(Exception e) {
			System.out.println("Can't Find Error Label");
			Assert.assertTrue(false);
		}
		Assert.assertEquals(ErrorLabel.getText(), "Enter a username of max length 17 without spaces");
		page.UserName.clear();
		act = builder.sendKeys(page.UserName,"m k").build();
		act.perform();
		act = builder.moveToElement(page.Finish).click().build();
		act.perform();
		Thread.sleep(3000);
		ErrorLabel = null;
		try {
			ErrorLabel = driver.LocateByXpath("//*[@id='partition-register']/div[3]/form/div[1]/span[1]");
		}catch(Exception e) {
			System.out.println("Can't Find Error Label");
			Assert.assertTrue(false);
		}
		Assert.assertEquals(ErrorLabel.getText(), "Enter a username of max length 17 without spaces");
		System.out.println("Test 7 Passed");
	}
	@Test(description="Entering With short password",priority=7)
	public void test8() throws InterruptedException
	{
		driver.nav(driver.Url);
		Thread.sleep(5000);
		try {
			page.SignUpButton = driver.LocateById(page.SignUpButtonId);
		}catch(Exception e) {
			System.out.println("Can't find the SignUp Button");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(page.SignUpButton).click().build();
		act.perform();
		Thread.sleep(3000);
		try {
			page.Email = driver.LocateById(page.EmailId);
			page.Next = driver.LocateById(page.NextId);
		}catch(Exception e) {
			System.out.println("Missing Elements in SignUp1 Page");
			Assert.assertTrue(false);
		}
		act = builder.sendKeys(page.Email,"mohamed12345@live.com").build();
		act.perform();
		act = builder.moveToElement(page.Next).click().build();
		act.perform();
		Thread.sleep(3000);
		try {
			page.UserName = driver.LocateById(page.UserNameId);
			page.Password = driver.LocateById(page.PasswordId);
			page.Back = driver.LocateById(page.BackId);
			page.Finish = driver.LocateById(page.FinishId);
		}catch(Exception e) {
			System.out.println("Missing Elements in SignUp2 Page");
			Assert.assertTrue(false);
		}
		act = builder.sendKeys(page.UserName,"deepoo").build();
		act.perform();
		act = builder.sendKeys(page.Password,"mm").build();
		act.perform();
		act = builder.moveToElement(page.Finish).click().build();
		act.perform();
		Thread.sleep(3000);
		WebElement ErrorLabel = null;
		try {
			ErrorLabel = driver.LocateByXpath("//*[@id='partition-register']/div[3]/form/div[1]/span[2]");
		}catch(Exception e) {
			System.out.println("Can't Find Error Label");
			Assert.assertTrue(false);
		}
		Assert.assertEquals(ErrorLabel.getText(), "Password must be at least 6 characters long");
		System.out.println("Test 8 Passed");
	}
	
	@Test(description="Entering Valid Email then press Next then press SignUp with valid UserName & Password",priority=8)
	public void test9() throws InterruptedException
	{
		driver.nav(driver.Url);
		Thread.sleep(5000);
		try {
			page.SignUpButton = driver.LocateById(page.SignUpButtonId);
		}catch(Exception e) {
			System.out.println("Can't find the SignUp Button");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(page.SignUpButton).click().build();
		act.perform();
		Thread.sleep(3000);
		try {
			page.Email = driver.LocateById(page.EmailId);
			page.Next = driver.LocateById(page.NextId);
		}catch(Exception e) {
			System.out.println("Missing Elements in SignUp1 Page");
			Assert.assertTrue(false);
		}
		act = builder.sendKeys(page.Email,"hereComesTheBoom2@gmail.com").build();
		act.perform();
		act = builder.moveToElement(page.Next).click().build();
		act.perform();
		Thread.sleep(3000);
		try {
			page.UserName = driver.LocateById(page.UserNameId);
			page.Password = driver.LocateById(page.PasswordId);
			page.Back = driver.LocateById(page.BackId);
			page.Finish = driver.LocateById(page.FinishId);
		}catch(Exception e) {
			System.out.println("Missing Elements in SignUp2 Page");
			Assert.assertTrue(false);
		}
		act = builder.sendKeys(page.UserName,"hereComes2").build();
		act.perform();
		act = builder.sendKeys(page.Password,"mohamed").build();
		act.perform();
		act = builder.moveToElement(page.Finish).click().build();
		act.perform();
		Thread.sleep(3000);
		try {
			page.Success = driver.LocateById(page.SuccessId);
		}catch(Exception e) {
			System.out.println("Login Failed");
			Assert.assertTrue(false);
		}
		System.out.println("Signed Up Successfully, Test 9 Passed");
		Thread.sleep(5000);
		try {
			login.logout = driver.LocateById(login.logoutDivID);
		}catch(Exception e) {
			System.out.println("Can't find logout btn 5");
			Assert.assertTrue(false);
		}
	  	act = builder.moveToElement(login.logout).click().build();
		act.perform();
		Thread.sleep(1000);
		try {
			login.logoutButton = driver.LocateByXpath("//button[@id='loggedbutton']//following-sibling::ul/li[5]");
		}catch(Exception e) {
			System.out.println("Can't find logout btn 5");
			Assert.assertTrue(false);
		}
		act = builder.moveToElement(login.logoutButton).click().build();
		act.perform();
		Thread.sleep(1000);
		try {
			login.signBtn = driver.LocateById(login.signBtnID);
		}catch(Exception e) {
			System.out.println("Can't  logout");
			Assert.assertTrue(false);
		}
	}
	
}
