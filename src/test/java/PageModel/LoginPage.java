


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
	public WebElement incorrectmailLable;
	public WebElement UserInfo;
	public WebElement signlable;
	public WebElement emailtxt;
	public WebElement logout;
	public WebElement logoutButton;

	public String logoutDivID;
	public String logoutButtonId;
	public String signBtnID;
	public String submitID;
	public String userNametxtID;
	public String paswordtxtID;
	public String forgotpasLableID;
	public String forgetnameID;
	public String incorrectmailLableID;
	public String UserInfoID;
	public String signlableID;

	public LoginPage()
	{
		signBtnID = "LoginBTN";
		submitID= "LoginButton";
		userNametxtID = "usernamextxt";
		paswordtxtID = "password";
		forgotpasLableID = "forgetpass";
		forgetnameID = "forgetname";
		incorrectmailLableID = "incorrectmail";
		UserInfoID = "logoutPic";
		signlableID = "signlable";
		logoutDivID="loggedbutton";
		logoutButtonId = "logOut";
	}





}
