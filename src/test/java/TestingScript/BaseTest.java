package TestingScript;

import DriverDef.Chrome;
import PageModel.LoginPage;
import PageModel.settingPage;
import PageModel.subredditPage;
import PageModel.searchPage;
public class BaseTest {

	public Chrome chromeDriver = new Chrome();  // here you created chrome driver
	public subredditPage subreddit= new subredditPage(chromeDriver.driver);
	public settingPage setting=new settingPage(chromeDriver.driver);
	public searchPage search =new searchPage(chromeDriver.driver);
//	public profilePage profile =new profilePage(chromeDriver.driver);
	
	
}
