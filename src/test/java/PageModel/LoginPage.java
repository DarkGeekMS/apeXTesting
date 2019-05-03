


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
	public WebElement UserInfo;
	public WebElement Errorlable;
	public WebElement logout;
	public WebElement logoutButton;
	public WebElement settingBTN;
	public WebElement profileBTN;
	public String logoutDivID;
	public String logoutButtonId;
	public String signBtnID;
	public String submitID;
	public String userNametxtID;
	public String paswordtxtID;
	public String forgotpasLableID;
	public String forgetnameID;
	public String UserInfoID;

	public LoginPage()
	{
		signBtnID = "LoginBTN";
		submitID= "LoginButton";
		userNametxtID = "usernamextxt";
		paswordtxtID = "password";
		forgotpasLableID = "forgetpass";
		forgetnameID = "forgetname";
		UserInfoID = "logoutPic";
		logoutDivID="loggedbutton";
		logoutButtonId = "logOut";
	}





}
