package DriverDef;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class Chrome {
	public WebDriver driver;
	WebDriverWait wait;
	public String Url;

	public Chrome () {
		
		boolean isWindows = System.getProperty("os.name").toLowerCase().contains("win");
		File driverpath =new File ("driver/chromedriver" + (isWindows == true? ".exe":"")); //add link of the driver
		System.setProperty("webdriver.chrome.driver",driverpath.getAbsolutePath());//write value of this driver
		driver = new ChromeDriver(); // here you connected the driver by option
		wait = new WebDriverWait(driver, 20);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();   /// maximize screen
		Url= System.getenv("SERVER_URL");
		if(Url == null){
			Url="http://35.232.3.8/";
		}
	}
	
	public WebElement LocateById(String Id) throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(Id)));
		return (driver.findElement(By.id(Id)));
	}
	public WebElement LocateByXpath(String xpath) throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		return (driver.findElement(By.xpath(xpath)));
	}
	
	public void nav(String url)
	{
		this.driver.navigate().to(url);
	}

	public void shutdown()
	{
		driver.close();
	}
}
