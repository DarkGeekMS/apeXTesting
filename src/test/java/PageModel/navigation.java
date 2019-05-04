package PageModel;

import org.openqa.selenium.WebElement;

public class navigation {

	public String HomeLink;
	public String apexcomLink;
	public String UserProfileLink;
	public String creatpostlink;
	public String userSettingsLink;
	
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
	public WebElement pop;
	public WebElement all;
	public WebElement origin;
	public WebElement msg;
	public WebElement post;
	public String logoutDivID;
	public String logoutButtonId;
	public String apexcompostid;
	public String apexcomid;
	public String signBtnID;
	public String SignUpButtonId;
	public String postTextid;
	public String popPath;
	public String allPath;
	public String originPath;
	public String msgPath;
	public String postPath;
	public String listPath;
	public String sortList;
	public String submitID;
	public String userNametxtID;
	public String paswordtxtID;
	public String postclass;
	public String ListButton;
	public String sortButton;
	public navigation()
	{
		HomeLink = System.getenv("SERVER_URL");
		if(HomeLink == null)
		{
			HomeLink = "http://35.232.3.8/";
		}
		apexcomLink= HomeLink + "ApexCom/";
		UserProfileLink = HomeLink + "userprofile/";
		userSettingsLink = HomeLink + "UserSettings/";
		creatpostlink= HomeLink + "Submit";
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
		popPath = "//*[@id='mainNav']/div[1]/div[3]/div/button[1]";
		allPath = "//*[@id='mainNav']/div[1]/div[3]/div/button[2]";
		originPath = "//*[@id='mainNav']/div[1]/div[3]/div/button[3]";
		msgPath = "//*[@id='mainNav']/div[1]/div[4]/div/button[1]";
		postPath = "//*[@id='mainNav']/div[1]/div[4]/div/button[2]";
		listPath = "//*[@id='mainNav']/div[1]/div[1]/ul";
		sortList = "//*[@id='main']/div[1]/ul";
		ListButton = "//*[@id='mainNav']/div[1]/div[1]/button";
		sortButton = "//*[@id='selected']";
	}
}



