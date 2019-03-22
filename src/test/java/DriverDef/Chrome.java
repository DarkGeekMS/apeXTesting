package DriverDef;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class Chrome {
	public WebDriver driver;
	File driverpath =new File ("C://Users//future//apeXproject//driver//chromedriver.exe"); //add link of the driver
	WebDriverWait wait;

	public Chrome () 
	{
		System.setProperty("webdriver.chrome.driver",driverpath.getAbsolutePath());//write value of this driver
		this.driver=new ChromeDriver(); // here you connected the driver by option
		wait = new WebDriverWait(driver, 20);
		driver.manage().window().maximize();   /// maximize screen

	}
	
	
	
	public WebElement LocateById(String Id) throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(Id)));
		return (driver.findElement(By.id(Id)));
	}
	
	public void naivgates(String url)
	{
		this.driver.navigate().to(url);
	}

	public void shutdown()
	{
		driver.close();
	}
}
