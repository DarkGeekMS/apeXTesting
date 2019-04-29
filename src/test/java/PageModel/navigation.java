package PageModel;

import org.openqa.selenium.WebElement;

public class navigation {
	public String HomeLink;
	public String apexcomLink;
	public String UserProfileLink;
	public String creatpostlink;
	
	public WebElement signBtn;
	public WebElement SignUpButton;
	public WebElement postText;
	public WebElement apexcom;
    public WebElement apexcompost;
	public WebElement submit;
	public WebElement userNametxt;
	public WebElement paswordtxt;
	public WebElement logout;
	public WebElement logoutButton;
	public WebElement postbutton;
	
	public String logoutDivID;
	public String logoutButtonId;
	public String apexcompostid;
	public String apexcomid;
	public String signBtnID;
	public String SignUpButtonId;
	public String postTextid;

	public String submitID;
	public String userNametxtID;
	public String paswordtxtID;
	public String postclass;

	public navigation()
	{
		HomeLink = System.getenv("SERVER_URL");
		if(HomeLink == NULL)
		{
			HomeLink = "http://35.232.3.8/";
		}
		apexcomLink= HomeLink + "/ApexCom/";
		UserProfileLink = HomeLink + "/userprofile/";
		creatpostlink= HomeLink + "/Submit";
		signBtnID = "LoginBTN";
		SignUpButtonId = "SignUp";
		postTextid="postBody";
		apexcomid="subred";
		apexcompostid="postslink";		
		submitID= "LoginButton";
		userNametxtID = "usernamextxt";
		paswordtxtID = "password";
		logoutDivID="loggedbutton";
		logoutButtonId = "logOut";
		postclass="btn btn-primary ";
	}
}



