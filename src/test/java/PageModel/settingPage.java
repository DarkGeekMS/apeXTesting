package PageModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class settingPage {
	public WebDriver driver;

	public settingPage (WebDriver driver) 
	{
		this.driver = driver; // connect driver of this page
		PageFactory.initElements(driver, this); // hena ana ba3mel connect lel driver bel page 
												// 3ashan a3araf 2ay element ba3melo call be driver web3den esm el page
												// EX: driver.findElement(By.className("login"));
	}

}
