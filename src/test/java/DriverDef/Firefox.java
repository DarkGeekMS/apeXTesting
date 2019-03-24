package DriverDef;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox {
	public WebDriver driver;
	File driverpath =new File ("driver/geckodriver.exe"); //add link of the driver
	

	public Firefox () 
	{
		System.setProperty("webdriver.Firefox.driver",driverpath.getAbsolutePath());//write value of this driver
		this.driver=new FirefoxDriver(); // here you connected the driver by option	

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
