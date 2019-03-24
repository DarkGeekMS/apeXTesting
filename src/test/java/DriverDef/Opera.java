package DriverDef;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;

public class Opera {
	public WebDriver driver;
	File driverpath =new File ("driver/operadriver.exe"); //add link of the driver
	

	public Opera () 
	{
		System.setProperty("webdriver.Opera.driver",driverpath.getAbsolutePath());//write value of this driver
		this.driver=new OperaDriver(); // here you connected the driver by option	

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
