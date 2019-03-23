package PageModel;

import org.openqa.selenium.WebElement;


public class LoginPage {
	//public WebDriver driver;

	public WebElement signBtn;
	public WebElement submit;
	public WebElement userNametxt;
	public WebElement paswordtxt;
	public WebElement forgotpasLable;
	public WebElement forgetname;
	public WebElement incorrectpassLable;
	public WebElement incorrectmailLable;
	public WebElement UserInfo;
	public WebElement signlable;
	public WebElement emailtxt;
	public WebElement loguot;
	public String loguotID;
	public String signBtnID;
	public String submitID;
	public String userNametxtID;
	public String paswordtxtID;
	public String forgotpasLableID;
	public String forgetnameID;
	public String incorrectpassLableID;
	public String incorrectmailLableID;
	public String UserInfoID;
	public String signlableID;
	
	public LoginPage()
	{
		signBtnID = "LoginBTN";
		submitID= "submit";
		userNametxtID = "usernametxt";
		paswordtxtID = "password";
		forgotpasLableID = "forgetpass";
		forgetnameID = "forgetname";
		incorrectpassLableID = "incorrectpass";
		incorrectmailLableID = "incorrectmail";
		UserInfoID = "loggedbutton";
		signlableID = "signlable";
		loguotID="";
		
	}
	
	
	
	
	
}
